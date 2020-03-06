package UIMain;

import BaseDatos.Data;

/**
 * Clase Invitado, su finalidad es la de ser aquella clase que permita la implementacion de opcionDeMenu y ejecute cierta funcionalidad 
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon
 */
public class Invitado implements OpcionDeMenu {
	public void ejecutar() {
		System.out.println("Estas son las opciones que un cliente registrado puede hacer en nuestra plataforma");
		for(int i = 3; i < 9; i++) {
			System.out.println(Data.getOpciones().get(i));
		}
		MenuDeConsola.lanzarMenu();
	}
	public String toString() {
		return "Invitado";
	}
}
