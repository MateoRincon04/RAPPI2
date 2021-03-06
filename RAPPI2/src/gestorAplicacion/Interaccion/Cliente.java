package gestorAplicacion.Interaccion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import gestorAplicacion.Administracion.*;
import gestorAplicacion.Oferta.*;
import BaseDatos.Data;
import UIMain.Cliente.EscenaCliente;

/**
 * Clase Cliente La finalidad de esta clase es la de creacion de objetos de tipo
 * Cliente, que seran los usuarios que puedan realizar pedidos de platos a
 * restaurantes, tambien calificar los tenderos que entregan estos,
 * 
 * Las estructuras revelantes de la clase son
 * 
 * @see: {@link #opciones}
 * @see: {@link #calificaciones}
 * @see: {@link #historial}
 * 
 * @author: Santiago Tamayo, Mateo Rincon, Guillermo Toloza, Paula A. Taborda
 */
public class Cliente extends Perfil implements Interfaz, Serializable {
	private List<Integer> calificaciones = new ArrayList<Integer>();
	private String metodoDePago;
	private long saldo=0;
	private int pedido;
	private String direccion;
	private ArrayList<Integer> historial = new ArrayList<Integer>();
	public ArrayList<Integer> opciones = new ArrayList<Integer>();

	/**
	 * Constructor para los objetos de la clase Cliente
	 * 
	 * @see: {@link Administracion.Perfil#Perfil(String, int, int, String, String)
	 * @param saldo        El parametro saldo define el saldo que tiene el Cliente
	 * @param metodoDePago El parametro metodoDePago define el metodo de pago con el
	 *                     que el Cliente planea comprar platos
	 * @param direccion    El paramtro direccion define la direccion a la que el
	 *                     cliente desea que le lleguen los pedidos
	 */
	public Cliente(String nombre, int telefono, int comuna, String clave, String userName, long saldo,
			String metodoDePago, String direccion) {
		super(nombre, telefono, comuna, clave, userName);
		this.saldo=saldo;
		this.direccion = direccion;
		this.setMetodoDePago(metodoDePago);
		this.opciones.add(3);
		this.opciones.add(4);
		this.opciones.add(5);
		this.opciones.add(6);
		this.opciones.add(7);
		this.opciones.add(8);
		this.opciones.add(9);
		this.opciones.add(10);
	}

	public ArrayList<Integer> getOpciones() {
		return this.opciones;
	}

	public long getSaldo() {
		return this.saldo;
	}

	public void setSaldo(long saldo) {
		this.saldo = saldo;
	}

	public static boolean revisarSaldo(long saldo) {
		if (saldo > 0) {
			return true;
		} else {

			return false;
		}
	}
	public String getMetodoDePago() {
		return this.metodoDePago;
	}

	public void agregarSaldo(long saldo) {
		this.saldo += saldo;
	}

	/**
	 * Metodo para realizar la solicitud del pedido
	 * 
	 * @see: {@link #agregarAlHistorial(Pedido)}
	 * @param plato El parametro plato define el plato que sera solicitado por el
	 *              cliente
	 */
	public boolean hacerPedido(Plato plato) {
		if (this.getSaldo() >= plato.getPrecio()) {
			this.setSaldo((long) (this.getSaldo() - plato.getPrecio()));
			Pedido pedido = new Pedido(this, plato);
			Data.agregarObjetoDataBasePedido(pedido);
			pedido.crearNotificacion(pedido.getId());
			this.agregarAlHistorial(pedido.getId());
			this.pedido = pedido.getId();
			Data.actualizarDataBaseCliente(EscenaCliente.cliente);
			return true;
		} else {

			return false;
		}
	}

	public void agregarAlHistorial(int id) {
		this.historial.add(id);
	}

	public ArrayList<Integer> getHistorial() {
		return this.historial;
	}

	/**
	 * Metodo que calcula la calificacion promedio que le han dado los tenderos a
	 * este Cliente
	 * 
	 * @return La calificacion promedio que tiene el Cliente en escala de (0.0,5.0]
	 */
	public double getCalificacionPromediada() {
		double contadorAux = 0;
		if (!this.calificaciones.isEmpty()) {
			for (int i = 0; i < this.calificaciones.size(); i++) {
				contadorAux += Data.buscarCalificacion(this.calificaciones.get(i)).getPuntuacion();
			}
		}
		return contadorAux / this.calificaciones.size();
	}

	private void setMetodoDePago(String metodoDePago) {
		this.metodoDePago = metodoDePago;
	}

	/**
	 * Metodo que califica al Tendero que entrego la orden
	 * 
	 * @see: {@link Calificacion#Calificacion(Object, double, Object)}
	 * @param puntuacion El parametro puntuacion define la calificacion del Tendero
	 */
	public void calificarTendero(double puntuacion, String tendero) {
		if (Data.buscarTendero(tendero)!=null) {
			Tendero calificando = Data.buscarTendero(tendero);
			Calificacion calificacionTendero = new Calificacion(this.getUserName(), puntuacion,
					calificando.getUserName());
			calificando.agregarCalificacion(calificacionTendero);
			Data.actualizarDataBaseTendero(calificando);

		}
	}

	/**
	 * Metodo que califica al Restaurante que preparo el pedido
	 * 
	 * @see: {@link Calificacion#Calificacion(Object, double, Object)}
	 * @param puntuacion El parametro puntuacion define la calificacion del
	 *                   Restaurante
	 */
	public void calificarRestaurante(double puntuacion,String restaurante) {
		if ((Data.buscarRestaurante(restaurante))!=null) {
			Restaurante calificando = Data.buscarRestaurante(restaurante);
			Calificacion calificacionRestaurante = new Calificacion(this.getUserName(), puntuacion,
					calificando.getNombre());
			calificando.agregarCalificacion(calificacionRestaurante);
			Data.actualizarDataBaseRestaurante(calificando);
		}
	}

	public void agregarCalificacion(Calificacion calificacion) {
		this.calificaciones.add(calificacion.getID());
	}

	public String toString() {
		return this.getNombre() + ", " + this.getTelefono() + ", " + this.getComuna() + ", " + this.getClave() + ", "
				+ this.getUserName();
	}

	public ArrayList<Restaurante> verListaDeRestaurantes() {
		return Data.getdbRestaurante();
	}

	/**
	 * Metodo que consulta cual es el plato mas comprado por el cliente que esta
	 * preguntando.
	 * 
	 * @see: {@link #historial}
	 * @return String con el nombre del plato que mas compro el cliente
	 */
	public String platoMasComprado() {
		int contador1 = 0;
		String aux = "";
		for (int i = 0; i < historial.size(); i++) {
			int contador = 0;
			for (int u = i; u < historial.size() - 1; u++) {
				if ((Data.buscarPedido(historial.get(i)).getPlato())
						.equals(Data.buscarPedido(historial.get(u)).getPlato())) {
					contador++;
				}
			}
			if (contador > contador1) {
				contador1 = contador;
				aux = Data.buscarPedido(historial.get(i)).getPlato();
			}
		}
		return aux;
	}

	/**
	 * Metodo que me muestra cuanto dinero ha gastado el cliente a lo largo de su
	 * historia.
	 * 
	 * @return double que me da el valor total del gasto
	 */
	public double cuantoHeGastado() {
		double valorGastado = 0;
		for (int i : historial) { // Por cada pedido en la lista de pedidos:
			valorGastado += (double) Data.buscarPlato(Data.buscarPedido(i).getPlato()).getPrecio();
		}
		return valorGastado;

	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String dir) {
		this.direccion = dir;
	}

	public int getPedido() {
		return this.pedido;
	}

	public String getTipo() {
		return "Cliente";
	}

}