package Administracion;

import Interaccion.Tendero;
import Oferta.Restaurante;
import UIMain.Main;
import Interaccion.Cliente;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import BaseDatos.Data;

/**
 * Clase Administrador, su finalidad es poder modificar el menu de cada usuario,
 * mostrar que funcionalidades puede realizar cada usuario registrado, listar
 * todas las funcionalidades en general del programa, poder adicionar o eliminar
 * funcionalidades de un usuario especifico.
 * 
 * 
 * @author: Mateo Rincon, Guillermo Toloza, Andrea Taborda, Santiago Tamayo
 * @version:
 */

public class Administrador extends Perfil {
	private long salario;

	/**
	 * Contructor para los objetos Administrador
	 * 
	 * @see {@link Perfil#Perfil(String, int, int, int, String)}
	 * @param salario El parametro salario define el salario que tendra el
	 *                Administrador
	 */
	public Administrador(String nombre, int telefono, int comuna, String clave, String userName, long salario) {
		super(nombre, telefono, comuna, clave, userName);
		this.salario = salario;
	}// Cierre del constructor

	public long getSalario() {
		return this.salario;
	}

	public void setSalario(long salario) {
		this.salario = salario;
	}

	public String toString() {
		return this.getNombre() + ", " + this.getTelefono() + ", " + this.getComuna() + ", " + this.getClave() + ", "
				+ this.getUserName() + ", " + this.getSalario();
	}

	/**
	 * Metodo que crea un objeto de clase Tendero
	 * 
	 * @param nombre   El parametro nombre define el nombre que tendra el Tendero
	 * @param telefono El parametro telefono define el telefono que tendra el
	 *                 Tendero
	 * @param comuna   El parametro comuna define la comuna en la que trabajara el
	 *                 Tendero
	 * @param clave    El parametro clave define la clave que tendra el Tendero para
	 *                 registrarse
	 * @param userName El parametro userName define el userName que tendra el
	 *                 Tendero para registrarse
	 * @param salario  El parametro salario define el salario que tendra el Tendero
	 */
	public boolean crearTendero(String nombre, int telefono, int comuna, String clave, String userName, long salario) {
		Gson gson = new Gson();
		Tendero tendero = new Tendero(nombre,telefono,comuna,clave,userName,salario);
		String aux = gson.toJson(tendero);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBaseTendero();
		if (!dataBase.contains(je)) {
			Data.agregarObjetoDataBaseTendero(tendero);
			System.out.println("Tendero creado exitosamente ");
			return true;
		} else {
			System.out.println("Tendero ya existente, por favor ingrese de nuevo ");
			return false;
		}
	}

	/**
	 * Metodo que crea un objeto de clase Restaurante
	 * 
	 * @param nombre    El parametro nombre define el nombre que tendra el
	 *                  Restaurante
	 * @param direccion El parametro direccion define la direccion nucleo del
	 *                  restaurante
	 * @param celular   El parametro celular define el telefono celular que tendra
	 *                  el Restaurante
	 */
	public boolean crearRestaurante(String nombre, String direccion, String celular) {
		Gson gson = new Gson();
		Restaurante restaurante = new Restaurante(nombre,direccion,celular);
		String aux = gson.toJson(restaurante);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBaseRestaurante();
		if (!dataBase.contains(je)) {
			Data.agregarObjetoDataBaseRestaurante(restaurante);
			System.out.println("Restaurante creado exitosamente ");
			return true;
		} else {
			System.out.println("Restaurante ya existente, por favor ingrese de nuevo ");
			return false;
		}
	}

	public void setOpciones(int posicion) {
		Perfil usuario = null;
		posicion = posicion - 1;
		while (true) {
			if (posicion >= 0 && posicion <= 10) {
				if (usuario instanceof Cliente) {
					while (true) {
						if (posicion == 3 | posicion == 4 | posicion == 5 | posicion == 6 | posicion == 7 | posicion == 8
								| posicion == 9) {
							usuario = (Cliente) Main.usuario;
							((Cliente) usuario).opciones.add(posicion);
						} else {
							System.out.println("Ingresa un numero valido");
						}
					}
				} else if (usuario instanceof Tendero) {
					while (true) {
						if (posicion == 10) {
							usuario = (Tendero) Main.usuario;
							((Tendero) usuario).opciones.add(posicion);
						} else {
							System.out.println("Ingrese un numero valido");
						}
					}
				}
			}
		}
	}
}
