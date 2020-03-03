	package Oferta;

import Interaccion.Cliente;
import Interaccion.Tendero;
import Interaccion.Notificacion;

/**
 * Clase Pedido, su finalidad es poder tener un formato mas amigable para el cliente poder
 * realizar un encargo y para que al ser creado este agregar las notificaciones a los 
 * respectivos restaurante y tenderos para que puedan realizar cada tarea y asi suplir
 * la peticion del cliente.
 * 
 * @author: Santiago Tamayo, Mateo Rincón, Paula A. Taborda, Guillermo Toloza
 */

public class Pedido {
	private Cliente cliente;
	private Plato plato;
	private Restaurante restaurante;
	private boolean entregado;
	private boolean estaListo;
	private Tendero tendero;
	
	/**
	 * Constructor de Pedido
	 * 
	 * @param cliente, El parametro cliente define el cliente que realizo el Pedido
	 * @param plato, El parametro plato define el plato que desea el cliente
	 */
	public Pedido(Cliente cliente, Plato plato) {
		this.cliente = cliente;
		this.plato = plato;
		this.restaurante = plato.restaurante;
		this.restaurante.addHistorial(plato);
		new Notificacion(this);
	}
	
	public boolean getEntregado() {
		return this.entregado;
	}
	
	public void setEntregado() {
		this.entregado= !this.entregado;
		
	}
	
	public void setTendero(Tendero tendero) {
		this.tendero = tendero;
	}
	
	public Tendero getTendero() {
		return this.tendero;
	}

	public Restaurante getRestaurante() {
		return this.restaurante;
	}
	
	public boolean getEstaListo() {
		return estaListo;
	}
	
	public void setEstaListo(boolean estaListo) {
		this.estaListo = estaListo;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public Plato getPlato() {
		return this.plato;
	}
}

