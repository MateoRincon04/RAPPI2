package gestorAplicacion.Interaccion;

import java.util.ArrayList;
import java.util.List;
import gestorAplicacion.Administracion.Perfil;
import gestorAplicacion.Oferta.Pedido;

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

public class Tendero extends Perfil {
	private Pedido pedido;
	private boolean estaDisponible;
	private static List<Notificacion> notificaciones = new ArrayList<Notificacion>();
	private List<Calificacion> calificaciones = new ArrayList<Calificacion>();
	public List<Integer> opciones = new ArrayList<Integer>();

	private long salario;

	/**
	 * Constructor de objetos de la clase Tendero
	 * 
	 * @see Administracion.Perfil#Perfil(String, int, int, int, String)
	 * @param salario El parametro salario define el salario que tiene el Tendero
	 */

	public Tendero(String nombre, int telefono, int comuna, String clave, String userName, long salario) {
		super(nombre, telefono, comuna, clave, userName);
		this.opciones.add(9);
		this.opciones.add(10);
		this.opciones.add(20);
		this.salario = salario;
		this.estaDisponible = true;
	}

	public List<Notificacion> getNotificaciones() {
		return notificaciones;
	}

	public List<Calificacion> getCalificaciones() {
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
		this.estaDisponible = !this.estaDisponible;
	}

	public boolean getEstaDisponible() {
		return estaDisponible;
	}

	public void agregarNotificacion(Notificacion notificacion) {
		notificaciones.add(notificacion);
	}

	public void agregarCalificacion(Calificacion calificacion) {
		this.calificaciones.add(calificacion);
	}

	/**
	 * Metodo por el cual el Tendero podra encargarse de un Pedido para su
	 * transportaci�n
	 */
	public boolean aceptarPedido() {
		Notificacion Aux = notificaciones.get(notificaciones.size() - 1);
		if (!Aux.getPedido().getEntregado() && (Aux.getPedido().getTendero() == null)) {
			Aux.setTomarPedido();
			System.out.println("Usted tiene a su cargo el pedido: " + Aux.getPedido().getPlato());
			notificaciones.remove(notificaciones.size() - 1);
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
		if (pedido.getEntregado()) {
			gestorAplicacion.Interaccion.Cliente calificando = this.pedido.getCliente();
			Calificacion calificacionCliente = new Calificacion(this, puntuacion, calificando);
			calificando.agregarCalificacion(calificacionCliente);
		}
	}

	/**
	 * Metodo sirve para saber la cantidad de pedios entregados por un tendero
	 * recordar que es obligatorio calificar el tendero cada que es finalizada la
	 * entrega.
	 */
	public int cantidadDePedidosEntregados() {
		return this.getCalificaciones().size();
	}
}
