package Interaccion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Oferta.Pedido;
import Administracion.Administrador;

/**
 * Clase Notificacion
 * su finalidad es de notificar a los tenderos y al restaurante acerca de la creación del pedido
 * para que asi estos sepan que deben de hacer o recoger.
 * 
 * @author: Santiago Tamayo
 * @version: 
 */
public class Notificacion {
	private Pedido pedido;
	private boolean tomarPedido;
	
	public Notificacion(Pedido pedido) {
	this.pedido= pedido;
	
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
	 * El método notificar me permite notificar a los tenderos acerca del nuevo pedido creado y le avisa
	 * tambien a el Restaurante asignado a el Pedido que realizara el Plato ordenado
	 */
	public void notificar() {
		Iterator<Tendero> iterator = Administrador.getTenderos().iterator();
		while(iterator.hasNext()) {
			Tendero notificado = iterator.next();
			if(notificado.getEstaDisponible()) {
				notificado.agregarNotificacion(this);
				if(tomarPedido) {
					notificado.setEstaDisponible();
					this.pedido.setTendero(notificado);
					break;
				}
			}
			break;
		}
	}

}