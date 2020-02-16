package Interaccion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Oferta.Pedido;

public class Notificacion {
	private Pedido pedido;
	private boolean tomarPedido;
	private List<Tendero> tenderos = new ArrayList<Tendero>();
	
	public Notificacion(Pedido pedido) {
	this.pedido= pedido;
	}
	public void setTomarPedido() {
		this.tomarPedido = !this.tomarPedido;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void notificar() {
		Iterator<Tendero> iterator = this.tenderos.iterator();
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