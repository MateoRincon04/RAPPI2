package Interaccion;

import java.util.ArrayList;
import java.util.List;
import Administracion.Perfil;
import Oferta.Pedido;

public class Tendero extends Perfil{
	private Pedido pedido;
	private boolean estaDisponible;
	private List<Notificacion> notificaciones = new ArrayList<Notificacion>();
	private List<Calificacion> calificaciones= new ArrayList<Calificacion>();
	private long salario;
	
	public Tendero(String nombre, int telefono, int comuna, int clave, String userName, long salario) {
		super(nombre, telefono, comuna, clave, userName);
		this.salario = salario;
		this.calificacion = 5;
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
	public void agregarCalificacion(Calificacion calificacion) {
		this.calificaciones.add(calificacion);
	}
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