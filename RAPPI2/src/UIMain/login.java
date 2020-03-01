package UIMain;

import Administracion.*;
import Interaccion.Cliente;
import Interaccion.Tendero;
import BaseDatos.Data;

/**
 * Clase Registrarse
 * 
 * su finalidad es la implementacion de Loguearse en el sistema a partir de la
 * opcion del menu
 * 
 * @author: Guillermo Toloza
 * @version:
 */

public class login implements OpcionDeMenu {

	public void ejecutar() {
		Perfil usuario = null;
		try {
			System.out.println("Ingrese su usuario: ");
			String userName = Main.user.next();
			System.out.println("Ingrese su clave: ");
			String clave = Main.user.next();
			usuario = Data.buscarUsuario(userName, clave);
			Main.usuario = usuario;
			System.out.println("Datos ingresados correctamente");

		} catch (Exception e) {
			System.out.println("Error ingresando usuario, intente nuevamente");
			ejecutar();
		}
		if (usuario instanceof Cliente) {
			usuario = (Cliente) Main.usuario;
			System.out.println("Bienvenido Cliente " + usuario.getNombre());
		} else if (usuario instanceof Tendero) {
			usuario = (Tendero) Main.usuario;
			System.out.println("Bienvenido Tendero " + usuario.getNombre());
		} else if (usuario instanceof Administrador) {
			usuario = (Administrador) Main.usuario;
			System.out.println("Bienvenido Administrador " + usuario.getNombre());
		}
	}
	public String toString() {
		return "Log In";
	}
}
