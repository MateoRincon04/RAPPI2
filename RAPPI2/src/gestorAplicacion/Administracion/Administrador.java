package gestorAplicacion.Administracion;

import gestorAplicacion.Interaccion.Tendero;
import gestorAplicacion.Oferta.Restaurante;
import UIMain.Main;
import gestorAplicacion.Interaccion.Cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

import BaseDatos.Data;

/**
 * Clase Administrador, su finalidad es poder modificar el menu de cada usuario,
 * mostrar que funcionalidades puede realizar cada usuario registrado, listar
 * todas las funcionalidades en general del programa, poder adicionar o eliminar
 * funcionalidades de un usuario especifico.
 * 
 * 
 * @author: Mateo Rincon, Guillermo Toloza, Paula A. Taborda, Santiago Tamayo
 */

public class Administrador extends Perfil implements Serializable{
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
	}

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
		Tendero tendero = new Tendero(nombre, telefono, comuna, clave, userName, salario);
		Main.tenderos.add(tendero.getUserName());
		ArrayList<Tendero> dataBase = Data.getdbTendero();
		if (!dataBase.contains(tendero)) {
			Data.agregarObjetoDataBaseTendero(tendero);

			return true;
		} else {

			return false;
		}
	}

	public boolean crearAdministrador(String nombre, int telefono, int comuna, String clave, String userName,long salario) {
		Administrador administrador = new Administrador(nombre, telefono, comuna, clave, userName, salario);
		ArrayList<Administrador> dataBase = Data.getdbAdmin();
		if (!dataBase.contains(administrador)) {
			Data.agregarObjetoDataBaseAdministrador(administrador);
			return true;
		} else {
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
	public boolean crearRestaurante(String nombre, String direccion, String celular, String clave) {
		Restaurante restaurante = new Restaurante(nombre, direccion, celular, clave);
		ArrayList<Restaurante> dataBase = Data.getdbRestaurante();
		if (!dataBase.contains(restaurante)) {
			Data.agregarObjetoDataBaseRestaurante(restaurante);

			return true;
		} else {

			return false;
		}
	}

	public boolean setOpciones(int posicion) {

		Perfil usuario = null;
		posicion = posicion - 1;
		while (true) {
			if (posicion >= 0 && posicion <= 10) {
				if (usuario instanceof Cliente) {
					while (true) {
						if (posicion == 3 | posicion == 4 | posicion == 5 | posicion == 6 | posicion == 7
								| posicion == 8 | posicion == 9) {
							usuario = (Cliente) Main.usuario;
							return true;
						} else {
							// System.out.println("Ingresa un numero valido");
							return false;
						}

					}
				} else if (usuario instanceof Tendero) {
					while (true) {
						if (posicion == 10) {
							usuario = (Tendero) Main.usuario;
							((Tendero) usuario).opciones.add(posicion);
							return true;
						} else {
							return false;
						}
					}
				}
			}
		}
	}
	
	public void quitarFuncionalidad(String userName,String funcionalidad,String tipo) {
		if(tipo.equals("Cliente")) {
			Cliente c= Data.buscarCliente(userName);
			c.opciones.sort(Comparator.naturalOrder());
			for(int i =0 ;i<31;i++) {
				if(funcionalidad.equals(Data.getOpciones().get(i).toString())) {
					c.opciones.remove(i-3);
				}
			}
			Data.actualizarDataBaseCliente(c);
		}
		else if(tipo.equals("Tendero")) {
			Tendero t = Data.buscarTendero(userName);
			t.opciones.sort(Comparator.naturalOrder());
			for(int i =0 ;i<Data.getOpciones().size();i++) {
				if(funcionalidad.equals(Data.getOpciones().get(i).toString())) {
					if(funcionalidad.equals("Entregado")&&t.opciones.get(t.opciones.size()-1)==30) {
						t.opciones.remove(t.opciones.size()-1);
					}else {
						t.opciones.remove(i-9);
					}
				}
			}
			Data.actualizarDataBaseTendero(t);
		}else {
			Restaurante r = Data.buscarRestaurante(userName);
			r.opciones.sort(Comparator.naturalOrder());
			for(int i =0 ;i<Data.getOpciones().size();i++) {
				if(funcionalidad.equals(Data.getOpciones().get(i).toString())) {
					r.opciones.remove(i-12);
				}
			}
			Data.actualizarDataBaseRestaurante(r);
		}
	}
	
	public void agregarFuncionalidad(String userName,String funcionalidad,String tipo) {
		if(tipo.equals("Cliente")) {
			Cliente c= Data.buscarCliente(userName);
			for(int i =0 ;i<Data.getOpciones().size();i++) {
				if(funcionalidad.equals(Data.getOpciones().get(i).toString())) {
					if(!c.opciones.contains(i)) {
						c.opciones.add(i);
					}
				}
			}
			c.opciones.sort(Comparator.naturalOrder());
			Data.actualizarDataBaseCliente(c);
		}
		else if(tipo.equals("Tendero")) {
			Tendero t = Data.buscarTendero(userName);
			for(int i =0 ;i<Data.getOpciones().size();i++) {
				if(funcionalidad.equals(Data.getOpciones().get(i).toString())) {
					if(!t.opciones.contains(i)) {
						t.opciones.add(i);
					}
				}
			}
			t.opciones.sort(Comparator.naturalOrder());
			Data.actualizarDataBaseTendero(t);
		}else {
			Restaurante r = Data.buscarRestaurante(userName);
			for(int i =0 ;i<Data.getOpciones().size();i++) {
				if(funcionalidad.equals(Data.getOpciones().get(i).toString())) {
					if(!r.opciones.contains(i)) {
						r.opciones.add(i);
					}
				}
			}
			r.opciones.sort(Comparator.naturalOrder());
			Data.actualizarDataBaseRestaurante(r);
		}
	}
	
	public String getTipo() {
		return "Administrador";
	}
}
