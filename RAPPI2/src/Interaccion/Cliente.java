package Interaccion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Administracion.*;
import Oferta.*;
import BaseDatos.Data;

/**
 * Clase Cliente La finalidad de esta clase es la de creacion de objetos de tipo
 * Cliente, que seran los usuarios que puedan realizar pedidos de platos a
 * restaurantes, tambien calificar los tenderos que entregan estos,
 * 
 * Las estructuras revelantes de la clase son
 * 
 * @see #calififcaciones
 * @see #historial
 * 
 * @author: Santiago Tamayo, Mateo Rincï¿½n
 * @version:
 *
 */
public class Cliente extends Perfil {
	private List<Calificacion> calificaciones = new ArrayList<Calificacion>();
	// private Carrito carrito;
	private String metodoDePago;
	private int referencia;
	private long saldo;
	private Pedido pedido;
	private List<Pedido> historial = new ArrayList<Pedido>();
	

	/**
	 * Constructor para los objetos de la clase Cliente
	 * 
	 * @see Administracion.Perfil#Perfil(String, int, int, int, String)
	 * @param saldo        El parametro saldo define el saldo que tiene el Cliente
	 * @param metodoDePago El parametro metodoDePago define el metodo de pago con el
	 *                     que el Cliente planea comprar platos
	 */
	public Cliente(String nombre, int telefono, int comuna, int clave, String userName, long saldo,
		String metodoDePago) {
		super(nombre, telefono, comuna, clave, userName);
		this.saldo = saldo;
		this.metodoDePago = metodoDePago;
		this.opciones.add(3);
		this.opciones.add(4);
		this.opciones.add(5);
		this.opciones.add(6);
		this.opciones.add(9);
		this.opciones.add(10);
		Data.agreagarObjetoDataBasePerfil(this);
	}

	public long getSaldo() {
		return this.saldo;
	}

	public void setSaldo(long saldo) {
		this.saldo = saldo;
	}

	public void agregarSaldo(long saldo) {
		this.saldo += saldo;
	}

	public void hacerPedido(Plato plato) {
		if (this.getSaldo() >= plato.getPrecio()) {
			Pedido pedido = new Pedido(this, plato);
			this.agregarAlHistorial(pedido);
			System.out.println("Su pedido se ha realizado correctamente.");
		} else {
			System.out.println("Usted no cuenta con saldo suficiente para pedir este plato.");
		}
	}

	public void agregarAlHistorial(Pedido pedido) {
		historial.add(pedido);
	}

	public List<Pedido> getHistorial() {
		return this.historial;
	}

	/**
	 * Mï¿½todo que calcula la calificacion promedio que le han dado los tenderos a
	 * este Cliente
	 * 
	 * @return La calificacion promedio que tiene el Cliente en escala de (0.0,5.0]
	 */
	public double getCalificacionPromediada() {
		double contadorAux = 0;
		if (!this.calificaciones.isEmpty()) {
			Iterator<Calificacion> iterator = this.calificaciones.iterator();
			while (iterator.hasNext()) {
				contadorAux += iterator.next().getPuntuacion();
			}
		}
		return contadorAux / this.calificaciones.size();

	}

	private void setMetodoDePago(String metodoDePago) {
		this.metodoDePago = metodoDePago;
	}

	/**
	 * Mï¿½todo que califica al Tendero que entrego la orden
	 * 
	 * @param puntuacion El parametro puntuacion define la calificacion del Tendero
	 */
	public void calificarTendero(double puntuacion) {
		if (pedido.getEntregado()) {
			Interaccion.Tendero calificando = this.pedido.getTendero();
			Calificacion calificacionTendero = new Calificacion(this, puntuacion, calificando);
			calificando.agregarCalificacion(calificacionTendero);
		}
	}

	/**
	 * Método que califica al Restaurante que preparo el pedido
	 * 
	 * @param puntuacion El parametro puntuacion define la calificacion del
	 *                   Restaurante
	 */
	public void calificarRestaurante(double puntuacion) {
		if (pedido.getEntregado()) {
			Oferta.Restaurante calificando = this.pedido.getRestaurante();
			Calificacion calificacionRestaurante = new Calificacion(this, puntuacion, calificando);
			calificando.agregarCalificacion(calificacionRestaurante);
		}
	}

	public void agregarCalificacion(Calificacion calificacion) {
		this.calificaciones.add(calificacion);
	}

	public String toString() {
		return this.getNombre() + ", " + this.getTelefono() + ", " + this.getComuna() + ", " + this.getClave() + ", "
				+ this.getUserName();
	}

	public List<Restaurante> verListaDeRestaurantes() {
		return Data.traerDataBaseRestaurante();
	}
	
	public String platoMasComprado(){
		int contador1 = 0;
		String aux = "";
		for (int i = 0; i < historial.size(); i++) {
			int contador = 0;
			for (int u = i; u < historial.size() - 1; u++) {
				if ((historial.get(i).getPlato().getNombre()).equals(historial.get(u).getPlato().getNombre())) {
					contador++;
				}
			}
			if (contador > contador1) {
				contador1 = contador;
				aux = historial.get(i).getPlato().getNombre();
			}
		}
		return aux;
	}
	public double cuantoHeGastado() {
		double valorGastado = 0;
		for (Pedido pedido : this.getHistorial()) { // Por cada pedido en la lista de pedidos:
			valorGastado += pedido.getPlato().getPrecio();
		}
		return valorGastado;

	}

}