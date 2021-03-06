package gestorAplicacion.Oferta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import gestorAplicacion.Interaccion.Calificacion;

/**
 * Clase Plato
 * Esta clase define objetos con la finalidad de ser el intermediario entre el restaurte
 * que es el que decide que platos tiene en su menu y el cliente que es el que ordena
 * que plato desea comprar.
 * 
 * Estructuras de datos revelantes son
 * @see #calificaciones
 * 
 * @author: Paula A. Taborda, Mateo Rincon, Santiago Tamayo, Guillermo Toloza
 */
public class Plato {
	private String nombre;
	private String descripcion;
	private int precio;
	private List<Calificacion> calificaciones= new ArrayList<Calificacion>();
	public String restaurante;
	public int restriccionDeEdad;
	/**
	 * Contructor para todo objeto de Plato
	 * @param nombre El parametro nombre define el nombre del Plato
	 * @param descripcion El parametro descripcion define la descripcion general del Plato
	 * @param precio El parametro precio define el precio del Plato
	 * @param restriccion El parametro defil si el Plato posee algun tipo de impedimento con respecto a la edad del Cliente 
	 * @param restaurante El parametro define a que Restaurante pertenece el Plato
	 */
	public Plato(String nombre,String descripcion, int precio, int restriccion, Restaurante restaurante) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.restriccionDeEdad = restriccion;
		this.restaurante = restaurante.getNombre();
	}
	
	void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	void setPrecio(int precio) {
		this.precio = precio;
	}
	
	void setRestriccionDeEdad(int restriccion) {
		this.restriccionDeEdad = restriccion;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public float getPrecio() {
		return this.precio;
	}
	
	public String getRestaurante() {
		return this.restaurante;
	}
	
	public int getRestriccionDeEdad() {
		return this.restriccionDeEdad;
	}
	
	/**
	 * Método para dar la calificacion del plato de manera promediada para asi saber
	 * cual es la calificacion general de cada plato de cada Restaurante.
	 * 
	 * @return double con la calificación del plato
	 */
    public double getCalificacionPromediada() {
    	double contadorAux = 0;
    	if(!this.calificaciones.isEmpty()) {
    		Iterator<Calificacion> iterator = this.calificaciones.iterator();
    		while(iterator.hasNext()) {
    			contadorAux += iterator.next().getPuntuacion();
    		}
    	}
    	return contadorAux/this.calificaciones.size();
    	
    }
}