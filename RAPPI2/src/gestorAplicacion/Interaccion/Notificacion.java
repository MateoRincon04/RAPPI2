package gestorAplicacion.Interaccion;

import java.util.Iterator;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import gestorAplicacion.Oferta.Pedido;
import gestorAplicacion.Oferta.Restaurante;
import BaseDatos.Data;

/**
 * Clase Notificacion su finalidad es de notificar a los tenderos y al
 * restaurante acerca de la creación del pedido para que asi estos sepan que
 * deben de hacer o recoger.
 * 
 * @author: Santiago Tamayo, Paula A. Taborda, Guillermo Toloza, Mateo Rincon
 */
public class Notificacion {
	private Pedido pedido;
	private static int ID = 0;
	private boolean tomarPedido;

	public Notificacion(Pedido pedido) {
		this.pedido = pedido;
		this.ID++;
		this.notificar();
	}

	public int getID() {
		return this.ID;
	}

	public void setTomarPedido() {
		this.tomarPedido = !this.tomarPedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public boolean getTomarPedido() {
		return tomarPedido;
	}

	/**
	 * El método notificar me permite notificar a los tenderos acerca del nuevo
	 * pedido creado y le avisa tambien a el Restaurante asignado a el Pedido que
	 * realizara el Plato ordenado.
	 */
	public void notificar() {
		Restaurante notif = pedido.getPlato().restaurante;
		notif.agregarNotificacion(this);
		Iterator<JsonElement> iterator = Data.traerDataBaseTendero().iterator();
		Gson gson = new Gson();
		while (iterator.hasNext()) {
			Tendero notificado = gson.fromJson(iterator.next(), Tendero.class);
			if (notificado.getEstaDisponible()) {
				notificado.agregarNotificacion(this);
				if (tomarPedido) {
					notificado.setEstaDisponible();
					this.pedido.setTendero(notificado);
					break;
				}
			}
			break;
		}
		Iterator<JsonElement> iterator2 = Data.traerDataBaseTendero().iterator();
		Gson gson2 = new Gson();
		while (iterator2.hasNext()) {
			Tendero tenderoAtiende = gson2.fromJson(iterator.next(), Tendero.class);
			if (tenderoAtiende.aceptarPedido() == true) {
				break;
			}
		}
	}

}