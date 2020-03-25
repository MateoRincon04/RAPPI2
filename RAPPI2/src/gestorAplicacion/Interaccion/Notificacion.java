package gestorAplicacion.Interaccion;

import java.util.ArrayList;
import java.util.Iterator;

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
	private int ID = 0;
	private String tomarPedido="disponible";

	public Notificacion(int pedido) {
		this.pedido = pedido;
		this.tomarPedido= "disponible";
		if(!Data.getdbNotificacion().isEmpty()) {
			this.ID = Data.getdbNotificacion().size()+1;
		}else {
			this.ID = 1;
		}
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
	 * El metodo notificar me permite notificar a los tenderos acerca del nuevo
	 * pedido creado y le avisa tambien a el Restaurante asignado a el Pedido que
	 * realizara el Plato ordenado.
	 */
	public void notificar() {
		Restaurante notif = Data.buscarRestaurante( Data.buscarPedido(pedido).getRestaurante());
		notif.agregarNotificacion(this);
		Data.actualizarDataBaseRestaurante(notif);
		ArrayList<Tendero> iterator = Data.getdbTendero();
		for (int o = 0; o < iterator.size() ; o++) {
			Tendero notificado = Data.buscarTendero(iterator.get(o).getUserName());
			if (notificado.getEstaDisponible().equals("disponible")) {
				notificado.agregarNotificacion(this);
				Data.actualizarDataBaseTendero(notificado);
				/*if (tomarPedido.equals("disponible")) {
					notificado.setEstaDisponible();
					Data.buscarPedido(pedido).setTendero(notificado);
					break;
				}*/
			}
			//break;
		}
		/*
		Iterator<String> iterator2 = Main.tenderos.iterator();
		while (iterator2.hasNext()) {
			Tendero tenderoAtiende =  Data.buscarTendero(iterator2.next());
			if (tenderoAtiende.aceptarPedido() == true) {
				break;
			}
		}*/
	}

}