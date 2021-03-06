package gestorAplicacion.Interaccion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import BaseDatos.Data;
import gestorAplicacion.Administracion.Perfil;

/**
 * Clase Tendero La finalidad de esta clase es de crear los objetos de tipo
 * Tendero que seran otro tipo de usuario en nuestra plataforma y estos podrian
 * aceptar pedidos y asi encargarse de su desplazamiento desde el Restaurante
 * hasta el Cliente, tambien
 * 
 * Estructuras revelantes de la clase Tendero
 * 
 * @see #notificaciones
 * @see #calificaciones
 * 
 * @author Guillermo Toloza, Mateo Rincon, Santiago Tamayo, Paula A. Taborda
 */

public class Tendero extends Perfil implements Serializable {
	private int pedido = -1;
	private String estaDisponible;
	private int entregados;
	private ArrayList<Integer> notificaciones = new ArrayList<Integer>();
	private ArrayList<Integer> calificaciones = new ArrayList<Integer>();
	public ArrayList<Integer> opciones = new ArrayList<Integer>();
	private long salario;

	/**
	 * Constructor de objetos de la clase Tendero
	 * 
	 * @see Administracion.Perfil#Perfil(String, int, int, int, String)
	 * @param salario El parametro salario define el salario que tiene el Tendero
	 */

	public Tendero(String nombre, int telefono, int comuna, String clave, String userName, long salario) {
		super(nombre, telefono, comuna, clave, userName);
		this.opciones.add(11);
		this.opciones.add(12);
		this.opciones.add(13);
		this.opciones.add(30);
		this.salario = salario;
		this.entregados = 0;
		this.estaDisponible = "disponible";
	}

	public ArrayList<Integer> getNotificaciones() {
		return notificaciones;
	}

	public ArrayList<Integer> getCalificaciones() {
		return calificaciones;
	}

	public List<Integer> getOpciones() {
		return this.opciones;
	}

	public void setSalario(long salario) {
		this.salario = salario;
	}

	public long getSalario() {
		return salario;
	}

	public void setEstaDisponible() {
		if (estaDisponible.equals("disponible")) {
			this.estaDisponible = "noDisponible";
		} else {
			this.estaDisponible = "disponible";
		}

	}

	public String getEstaDisponible() {
		return estaDisponible;
	}

	public void agregarNotificacion(Notificacion notificacion) {
		notificaciones.add(notificacion.getID());
	}

	public void agregarCalificacion(Calificacion calificacion) {
		Data.agregarObjetoDataBaseCalificacion(calificacion);
		this.calificaciones.add(calificacion.getID());
	}

	/**
	 * Metodo por el cual el Tendero podra encargarse de un Pedido para su
	 * transportacion
	 */
	public boolean aceptarPedido() {
		Notificacion Aux = Data.buscarNotificacion(notificaciones.get(notificaciones.size() - 1));
		if (!Data.buscarPedido(Aux.getPedido()).getEntregado().equals("entregado") && (Data.buscarPedido(Aux.getPedido()).getTendero()).equals("nadie")) {
			Aux.setTomarPedido();
			this.setPedido(Aux.getPedido());
			this.setEstaDisponible();
			Data.actualizarDataBaseNotificacion(Aux);
			this.setEntregados(this.getEntregados() + 1);
			Data.actualizarDataBaseTendero(this);
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		return this.getNombre() + ", " + this.getTelefono() + ", " + this.getComuna() + ", " + this.getClave() + ", "
				+ this.getUserName() + ", " + this.getSalario();
	}

	/**
	 * Metodo que califica al Cliente que realizo el Pedido
	 * 
	 * @param puntuacion El parametro puntuacion define la calificacion del Cliente
	 */
	public void calificarCliente(double puntuacion) {
		if (Data.buscarPedido(pedido).getEntregado().equals("entregado")) {
			Cliente calificando = Data.buscarCliente(Data.buscarPedido(pedido).getCliente());
			Calificacion calificacionCliente = new Calificacion(this.getUserName(), puntuacion,
					calificando.getUserName());
			Data.agregarObjetoDataBaseCalificacion(calificacionCliente);
			calificando.agregarCalificacion(calificacionCliente);
		}
	}
	
	public int getPedido() {
		return this.pedido;
	}
	
	public void setPedido(int pedido) {
		this.pedido = pedido;
	}

	/**
	 * Metodo sirve para saber la cantidad de pedios entregados por un tendero
	 * recordar que es obligatorio calificar el tendero cada que es finalizada la
	 * entrega.
	 */
	public int cantidadDePedidosEntregados() {
		return this.getEntregados();
	}

	public double getCalificacionPromediada() {
		double contadorAux = 0;
		if (!this.calificaciones.isEmpty()) {
			for (int i = 0; i < this.calificaciones.size(); i++) {
				contadorAux += Data.buscarCalificacion(this.calificaciones.get(i)).getPuntuacion();
			}
		}
		return contadorAux / this.calificaciones.size();
	}

	public String getTipo() {
		return "Tendero";
	}

	public void quitarNotificacion() {
		int index = notificaciones.size()-1;
		notificaciones.remove(index);
	}

	public int getEntregados() {
		return entregados;
	}

	public void setEntregados(int entregados) {
		this.entregados = entregados;
	}
}
