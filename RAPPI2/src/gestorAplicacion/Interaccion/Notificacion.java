package gestorAplicacion.Interaccion;

import java.util.Iterator;
import com.google.gson.Gson;

import gestorAplicacion.Oferta.Pedido;
import gestorAplicacion.Oferta.Restaurante;
import BaseDatos.Data;

/**
 * Clase Notificacion su finalidad es de notificar a los tenderos y al
 * restaurante acerca de la creaci�n del pedido para que asi estos sepan que
 * deben de hacer o recoger.
 * 
 * @author: Santiago Tamayo, Paula A. Taborda, Guillermo Toloza, Mateo Rincon
 */
public class Notificacion {
	private int pedido;
	private static int contador = 0;
	private int ID = 0;
	private boolean tomarPedido;

	public Notificacion(int pedido) {
		this.pedido = pedido;
		++this.contador;
		this.ID= contador;
	}

	public int getID() {
		return ID;
	}

	public void setTomarPedido() {
		this.tomarPedido = !this.tomarPedido;
	}

	public int getPedido() {
		return pedido;
	}

	public boolean getTomarPedido() {
		return tomarPedido;
	}

	/**
	 * El m�todo notificar me permite notificar a los tenderos acerca del nuevo
	 * pedido creado y le avisa tambien a el Restaurante asignado a el Pedido que
	 * realizara el Plato ordenado.
	 */
	public void notificar() {
		//solucionar este casteo
		Restaurante notif = Data.buscarRestaurante( Data.buscarPedido(pedido).getRestaurante());
		notif.agregarNotificacion(this);
		Data.actualizarDataBaseRestaurante(notif);
		Iterator<String> iterator = Data.tenderos.iterator();
		Gson gson = new Gson();
		while (iterator.hasNext()) {
			Tendero notificado = Data.buscarTendero(iterator.next());
			if (notificado.getEstaDisponible()) {
				notificado.agregarNotificacion(this);
				Data.actualizarDataBaseTendero(notificado);
				if (tomarPedido) {
					notificado.setEstaDisponible();
					Data.buscarPedido(pedido).setTendero(notificado);
					break;
				}
			}
			break;
		}
		Iterator<String> iterator2 = Data.tenderos.iterator();
		Gson gson2 = new Gson();
		while (iterator2.hasNext()) {
			Tendero tenderoAtiende =  Data.buscarTendero(iterator2.next());
			if (tenderoAtiende.aceptarPedido() == true) {
				break;
			}
		}
	}

}