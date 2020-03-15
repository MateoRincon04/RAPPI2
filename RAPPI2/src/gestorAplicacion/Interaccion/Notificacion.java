package gestorAplicacion.Interaccion;

import java.util.Iterator;
import com.google.gson.Gson;

import gestorAplicacion.Oferta.Pedido;
import gestorAplicacion.Oferta.Restaurante;
import BaseDatos.Data;
import UIMain.Main;

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
	private String tomarPedido="disponible";

	public Notificacion(int pedido) {
		this.pedido = pedido;
		++Notificacion.contador;
		this.ID= contador;
		this.tomarPedido= "disponible";
	}

	public int getID() {
		return ID;
	}

	public void setTomarPedido() {
		if(this.tomarPedido.equals("disponible")) {
			this.tomarPedido = "noDisponible";
		}else {
			this.tomarPedido = "disponible";
		}
	}

	public int getPedido() {
		return pedido;
	}

	public String getTomarPedido() {
		return tomarPedido;
	}

	/**
	 * El m�todo notificar me permite notificar a los tenderos acerca del nuevo
	 * pedido creado y le avisa tambien a el Restaurante asignado a el Pedido que
	 * realizara el Plato ordenado.
	 */
	public void notificar() {
		Restaurante notif = Data.buscarRestaurante( Data.buscarPedido(pedido).getRestaurante());
		notif.agregarNotificacion(this);
		Data.actualizarDataBaseRestaurante(notif);
		Iterator<String> iterator = Main.tenderos.iterator();
		while (iterator.hasNext()) {
			Tendero notificado = Data.buscarTendero(iterator.next());
			if (notificado.getEstaDisponible().equals("disponible")) {
				notificado.agregarNotificacion(this);
				Data.actualizarDataBaseTendero(notificado);
				if (tomarPedido.equals("disponible")) {
					notificado.setEstaDisponible();
					Data.buscarPedido(pedido).setTendero(notificado);
					break;
				}
			}
			break;
		}
		Iterator<String> iterator2 = Main.tenderos.iterator();
		while (iterator2.hasNext()) {
			Tendero tenderoAtiende =  Data.buscarTendero(iterator2.next());
			if (tenderoAtiende.aceptarPedido() == true) {
				break;
			}
		}
	}

}