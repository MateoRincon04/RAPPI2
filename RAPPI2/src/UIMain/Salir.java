package UIMain;

import com.google.gson.Gson;

import BaseDatos.Data;

/**
 * Clase Salir, su finalidad es la de ser aquella clase que permita la
 * implementacion de opcionDeMenu y ejecute cierta funcionalidad
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon
 */
public class Salir implements OpcionDeMenu {
	public void ejecutar() {
		Gson gson = new Gson();
		System.out.println(gson.toJson(Main.usuarioRestaurante));
		Data.actualizarDataBaseRestaurante(Main.usuarioRestaurante);
	}
	public String toString() {
		return "Salir";
	}
}