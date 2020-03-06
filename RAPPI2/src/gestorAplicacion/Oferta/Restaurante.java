package gestorAplicacion.Oferta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import BaseDatos.Data;
import gestorAplicacion.Interaccion.Calificacion;
import gestorAplicacion.Interaccion.Notificacion;
import gestorAplicacion.Interaccion.Tendero;

/**
 * Clase Restaurante En esta clase, el restaurante es aquel que prepara los
 * platos tiene datos propios como el nombre de restaurante, celular de
 * contacto, direcciones de sus sucursales, un booleano que define si el
 * pedido esta listo para ser despachado o no y su menu
 * 
 * Estructuras revelantes
 * 
 * @see #direcciones
 * @see #menu
 * @see #historial
 * @see #notificaciones
 * 
 * @author: Guillermo Toloza, Mateo Rincon, Paula A. Taborda, Santiago Tamayo
 * @version:
 * 
 */
public class Restaurante implements Serializable {
	private String nombre;
	private JsonArray notificaciones = new JsonArray();
	private JsonArray calificaciones = new JsonArray();
	private List<String> direcciones = new ArrayList<String>();
	public List<Integer> opciones = new ArrayList<Integer>();
	private String celular;
	private String menu = "";
	private String clave;

	/**
	 * Constructor de los objetos de la clase Restaurante
	 * 
	 * @param nombre    El parametro nombre define el nombre que tendra el
	 *                  Restaurante
	 * @param direccion El parametro direccion define la direccion nucleo que tendra
	 *                  el Restaurante
	 * @param celular   El parametro celular define el telefono celular que tendra
	 *                  el Restaurante
	 */
	public Restaurante(String nombre, String direccion, String celular, String clave) {
		this.nombre = nombre;
		this.opciones.add(11);
		this.opciones.add(12);
		this.opciones.add(13);
		this.opciones.add(14);
		this.opciones.add(15);
		this.opciones.add(16);
		this.opciones.add(23);
		this.celular = celular;
		this.direcciones.add(direccion);
		this.clave = clave;
	}
	public List<Integer> getOpciones() {
		return opciones;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public boolean cambiarDireccion(String direccion, String nueva) {
		if (this.direcciones.contains(direccion)) {
			this.direcciones.set(this.direcciones.indexOf(direccion), nueva);
			return true;
		} else {
			return false;
		}
	}

	public boolean agregarDireccion(String direccion) {
		if (!this.direcciones.contains(direccion)) {
			this.direcciones.add(direccion);
			
			return true;
		} else {
			
			return false;
		}

	}

	public boolean eliminarDireccion(String direccion) {
		if (this.direcciones.contains(direccion)) {
			int index = this.direcciones.indexOf(direccion);
			this.direcciones.remove(index);
			System.out.println("La direccion se ha eliminado correctamente.");
			return true;
		} else {
			
			return false;
		}
	}

	public List<String> getDireccion() {
		return (direcciones);
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCelular() {
		return this.celular;
	}

	/**
	 * Metodo que le permite a el restaurante crear un plato para su a�adirlo a su
	 * menu
	 * 
	 * @param nombre      El parametro nombre define el nombre que tendra este nuevo
	 *                    plato
	 * @param descripcion El parametro descripcion define la descripcion del plato
	 * @param precio      El parametro precio define el precio en el mercado que
	 *                    poseera el plato
	 * @param restriccion El parametro restriccion define si el plato tiene algun
	 *                    tipo de sustancia, la cual para ser consumida necesita de
	 *                    cierta edad del cliente
	 */
	public boolean crearPlato(String nombre, String descripcion, float precio, int restriccion) {
		Gson gson =new Gson();
		Plato plato= new Plato(nombre, descripcion, precio, restriccion, this);
		Data.agregarObjetoDataBasePlato(plato);
		this.menu=nombre;
		return true;	
	}

	public boolean cambiarPlato( Plato platoCambio) {
		if (Data.buscarPlato(platoCambio.getNombre())==null) {
			this.menu=platoCambio.getNombre();
			Data.actualizarDataPlato(platoCambio);
			System.out.println("Su plato se ha cambiado correctamente");
			return true;
		} else {
			
			return false;
		}
	}
	
	public String getMenu() {
		return this.menu;
	}

	public void agregarNotificacion(Notificacion notificacion) {
		Gson gson = new Gson();
		JsonElement aux = gson.fromJson(gson.toJson(notificacion), JsonElement.class);
		notificaciones.add(aux);
	}

	public void agregarCalificacion(Calificacion calificacion) {
		Gson gson = new Gson();
		JsonElement aux = gson.fromJson(gson.toJson(calificacion), JsonElement.class);
		this.calificaciones.add(aux);
	}

	public void setEstaListo(Pedido pedido) {
		pedido.setEstaListo(true);
	}

	public String elegirPlatoMenu(int indice) {
		return this.getMenu();
	}

	/**
	 * @see Plato#getCalificacionPromediada()
	 */
	public double getCalificacionPromediada() {
		double contadorAux = 0;
		if (!this.calificaciones.isJsonArray()) {
			Iterator<JsonElement> iterator = this.calificaciones.iterator();
			while (iterator.hasNext()) {
				Gson gson = new Gson();
				Calificacion aux = gson.fromJson(iterator.next(), Calificacion.class);
				contadorAux += aux.getPuntuacion();
			}
		}
		return contadorAux / this.calificaciones.size();

	}

	public Tendero tenderoQueMasMeEntrega() {
		Tendero nuevo = null;
		int numero = 0;
		for (int i = 0; i < this.notificaciones.size(); i++) {
			Gson gson = new Gson();
			Notificacion aux = gson.fromJson(notificaciones.get(i), Notificacion.class);
			int f = 0;
			for (int j = 0; j < notificaciones.size(); j++) {
				Notificacion aux1 = gson.fromJson(notificaciones.get(j), Notificacion.class);
				if (aux.getPedido().getTendero().equals(aux1.getPedido().getTendero())) {
					f++;
				}
			}
			if (f > numero) {
				numero = f;
				nuevo = aux.getPedido().getTendero();
			}
		}
		return nuevo;
	}


	public String getClave() {
		return clave;
	}
	
}