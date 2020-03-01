package Interaccion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import Oferta.Pedido;
import Oferta.Restaurante;
import Administracion.Administrador;
import Administracion.Perfil;
import BaseDatos.Data;

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
	 * El método notificar me permite notificar a los tenderos acerca del nuevo pedido creado y le avisa
	 * tambien a el Restaurante asignado a el Pedido que realizara el Plato ordenado.
	 */
	public void notificar() {
		Restaurante notif = pedido.getPlato().restaurante;
		notif.agregarNotificacion(this);
		Iterator<JsonElement> iterator = Data.traerDataBaseTendero().iterator();
		Gson gson = new Gson();
		while(iterator.hasNext()) {
			Perfil iter = gson.fromJson(iterator.next(), Perfil.class);
			if(iterator instanceof Tendero) {
				Tendero notificado = (Tendero) iter;
				if(notificado.getEstaDisponible()) {
					notificado.agregarNotificacion(this);
					if(tomarPedido){
						notificado.setEstaDisponible();
						this.pedido.setTendero(notificado);
						break;
					}
				}
			}
			
			break;
		}
	}

}