package Interaccion;

import java.util.ArrayList;
import java.util.List;
import Administracion.Perfil;
import Oferta.Pedido;

/**
 * Clase Tendero
 * La finalidad de esta clase es de crear los objetos de tipo Tendero que seran otro tipo
 * de usuario en nuestra plataforma y estos podrian aceptar pedidos y asi encargarse de 
 * su desplazamiento desde el Restaurante hasta el Cliente, tambien 
 * 
 * Estructuras revelantes de la clase Tendero
 * @see #notificaciones
 * @see #calificaciones
 * 
 * @author Guillermo Toloza, Mateo Rincón
 * @version: 
 *
 */
public class Tendero extends Perfil{
	private Pedido pedido;
	private boolean estaDisponible;
	private List<Notificacion> notificaciones = new ArrayList<Notificacion>();
	private long salario;
	
	/**
	 * Constructor de objetos de la clase Tendero
	 * @see Administracion.Perfil#Perfil(String, int, int, int, String)
	 * @param salario El parametro salario define el salario que tiene el Tendero
	 */
	public Tendero(String nombre, int telefono, int comuna, int clave, String userName, long salario) {
		super(nombre, telefono, comuna, clave, userName);
		this.salario = salario;
		this.estaDisponible = true;
	}
	
	public void setSalario(long salario) {
		this.salario=salario;
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
		this.notificaciones.add(notificacion);
	}
	
	/**
	 * Método por el cual el Tendero podra encargarse de un Pedido para su transportación
	 */
	public void aceptarPedido() {
		Notificacion Aux = notificaciones.get(notificaciones.size()-1);
		if(!Aux.getPedido().getEntregado()) {
			Aux.setTomarPedido();
		}
	}
	
    public String toString(){
        return this.getNombre() + ", " + this.getTelefono() + ", " + this.getComuna() + ", " + this.getClave() + ", " + this.getUserName( )+ ", " + this.getSalario();
    }
}