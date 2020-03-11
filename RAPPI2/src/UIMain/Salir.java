package UIMain;

import com.google.gson.Gson;

import BaseDatos.Data;
import gestorAplicacion.Administracion.Administrador;
import gestorAplicacion.Interaccion.Cliente;
import gestorAplicacion.Interaccion.Tendero;

/**
 * Clase Salir, su finalidad es la de ser aquella clase que permita la
 * implementacion de opcionDeMenu y ejecute cierta funcionalidad
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon
 */
public class Salir extends OpcionDeMenu {
	public void ejecutar() {
		if(Main.usuarioRestaurante != null) {
			Gson gson = new Gson();
			//System.out.println(gson.toJson(Main.usuarioRestaurante));
			Data.actualizarDataBaseRestaurante(Main.usuarioRestaurante);
		}
		else {
			if(Main.usuario instanceof Cliente) {
				Data.actualizarDataBaseCliente((Cliente) Main.usuario);
			}else if(Main.usuario instanceof Tendero) {
				Data.actualizarDataBaseTendero((Tendero) Main.usuario);
			}else {
				Data.actualizarDataBaseAdministrador((Administrador) Main.usuario);
			}
			
		}

	}
	public String toString() {
		return "Salir";
	}
}