package gestorAplicacion.Oferta;

import BaseDatos.Data;
import gestorAplicacion.Interaccion.Cliente;
import gestorAplicacion.Interaccion.Tendero;
import gestorAplicacion.Interaccion.Notificacion;

/**
 * Clase Pedido, su finalidad es poder tener un formato mas amigable para el cliente poder
 * realizar un encargo y para que al ser creado este agregar las notificaciones a los 
 * respectivos restaurante y tenderos para que puedan realizar cada tarea y asi suplir
 * la peticion del cliente.
 * 
 * @author: Santiago Tamayo, Mateo Rinc�n, Paula A. Taborda, Guillermo Toloza
 */

public class Pedido {
	private static int ID =0;
	private String cliente;
	private String plato;
	private String restaurante;
	private boolean entregado;
	private boolean estaListo;
	private String tendero;
	
	/**
	 * Constructor de Pedido
	 * 
	 * @param cliente, El parametro cliente define el cliente que realizo el Pedido
	 * @param plato, El parametro plato define el plato que desea el cliente
	 */
	public Pedido(Cliente cliente, Plato plato) {
		this.cliente = cliente.getUserName();
		this.plato = plato.getNombre();
		this.restaurante = Data.buscarRestaurante(Data.buscarPlato(plato.getNombre()).getRestaurante()).getNombre();
		ID++;
	}
	
	public int getId(){
		return ID;
	}
	public void crearNotificacion(Pedido pedido) {
		Notificacion n =new Notificacion(pedido);
	}
	
	public boolean getEntregado() {
		return this.entregado;
	}
	
	public void setEntregado() {
		this.entregado= !this.entregado;
		
	}
	
	public void setTendero(Tendero tendero) {
		this.tendero = tendero.getUserName();
	}
	
	public String getTendero() {
		return this.tendero;
	}

	public String getRestaurante() {
		return this.restaurante;
	}
	
	public boolean getEstaListo() {
		return estaListo;
	}
	
	public void setEstaListo(boolean estaListo) {
		this.estaListo = estaListo;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente.getUserName();
	}
	
	public String getCliente() {
		return this.cliente;
	}
	
	public String getPlato() {
		return this.plato;
	}
}

