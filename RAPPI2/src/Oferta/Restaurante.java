package Oferta;

import java.util.ArrayList;
import java.util.List;

/**Clase Restaurante 
 * En esta clase, el restaurante es aquel que prepara los platos
 * tiene datos propios como el nombre de restaurante, celular de contacto, direcciónes
 * de sus sucursales, un booleano que define si el pedido esta listo para ser
 * despachado o no y su menu
 * 
 * Estructuras revelantes
 * @see #direcciones
 * @see #menu
 * @see #historial
 * 
 * @author: Guillermo Toloza, Mateo Rincon
 * @version:
 * 
 */
public class Restaurante {
	private String nombre;
	private List <String> direcciones = new ArrayList<String>();
	private String celular;
	private List<Plato> menu = new ArrayList<Plato>();
	private List<Pedido> historial = new ArrayList<Pedido>();
	
	/**
	 * Constructor de los objetos de la clase Restaurante
	 * @param nombre El parametro nombre define el nombre que tendra el Restaurante
	 * @param direccion El parametro direccion define la direccion nucleo que tendra el Restaurante
	 * @param celular El parametro celular define el telefono celular que tendra el Restaurante
	 */
	public Restaurante(String nombre, String direccion, String celular) {
		this.nombre = nombre;
		this.celular = celular;
		this.direcciones.add(direccion);
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void cambiarDireccion(String direccion, String nueva) {
		if(this.direcciones.contains(direccion)) {
			this.direcciones.set(this.direcciones.indexOf(direccion), nueva);
		}
	}
	
	public void agregarDireccion(String direccion) {
		if(!this.direcciones.contains(direccion)) {
			this.direcciones.add(direccion);
		}
		
	}
	
	public void eliminarDireccion(String direccion) {
		if(this.direcciones.contains(direccion)) {
			this.direcciones.remove(direccion);
		}
	}
	
	public List<String> getDireccion() {
		return(direcciones);
	}
	
	public void setCelular(String celular) {
		this.celular=celular;
	}
	
	public String getCelular() {
		return this.celular;
	}
	
	public void agregarPlato(Plato plato) {
		if(!this.menu.contains(plato)) {
			this.menu.add(plato);
		}
	}
	
	public void cambiarPlato(Plato plato, Plato nuevo) {
		if(this.menu.contains(plato)) {
			this.menu.set(this.menu.indexOf(plato), nuevo);
		}
	}
	
	public void eliminarPlato(Plato plato) {
		if(this.menu.contains(plato)) {
			this.menu.remove(plato);
		}
	}
	
	public List<Plato> getMenu(){
		return menu;
	}
	
	
	//cambio 
	public void elejirPlatoMenu(int indice) {
		this.menu.get(indice);
	}
	
}
