package Interaccion;


import java.util.Iterator;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import Oferta.Pedido;
import Oferta.Restaurante;
import BaseDatos.Data;

/**
 * Clase Notificacion
 * su finalidad es de notificar a los tenderos y al restaurante acerca de la creaci�n del pedido
 * para que asi estos sepan que deben de hacer o recoger.
 * 
 * @author: Santiago Tamayo, Paula A. Taborda, Guillermo Toloza, Mateo Rincon
 */
public class Notificacion {
	private Pedido pedido;
	private boolean tomarPedido;
	
	public Notificacion(Pedido pedido) {
	this.pedido= pedido;
	this.notificar();
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
	 * El m�todo notificar me permite notificar a los tenderos acerca del nuevo pedido creado y le avisa
	 * tambien a el Restaurante asignado a el Pedido que realizara el Plato ordenado.
	 */
	public void notificar() {
		Restaurante notif = pedido.getPlato().restaurante;
		notif.agregarNotificacion(this);
		Iterator<JsonElement> iterator = Data.traerDataBaseTendero().iterator();
		Gson gson = new Gson();
		while(iterator.hasNext()) {
			Tendero notificado = gson.fromJson(iterator.next(), Tendero.class);
				if(notificado.getEstaDisponible()) {
					notificado.agregarNotificacion(this);
					if(tomarPedido){
						notificado.setEstaDisponible();
						this.pedido.setTendero(notificado);
						break;
					}
				}
			break;
		}
	}

}