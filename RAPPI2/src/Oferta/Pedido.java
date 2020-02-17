package Oferta;

import Interaccion.Cliente;
import Interaccion.Tendero;
import Interaccion.Notificacion;

public class Pedido {
	private Cliente cliente;
	private Plato plato;
	private Restaurante restaurante;
	private boolean entregado;
	private boolean estaListo;
	private Tendero tendero;
	
	public Pedido(Cliente cliente, Plato plato) {
		this.cliente = cliente;
		this.plato = plato;
		this.restaurante = plato.restaurante;
		Notificacion notificacion = new Notificacion(this);
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
	//metodos para sumar a el historial del restaurante el plato pedido
}

