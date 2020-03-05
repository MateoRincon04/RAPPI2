package UIMain;

import gestorAplicacion.Administracion.*;
import gestorAplicacion.Interaccion.Cliente;
import gestorAplicacion.Interaccion.Tendero;
import gestorAplicacion.Oferta.Restaurante;
import BaseDatos.Data;

/**
 * Clase login
 * 
 * su finalidad es la implementacion de Loguearse en el sistema a partir de la
 * opcion del menu
 * 
 * @author: Guillermo Toloza, Paula A. Taborda, Mateo Rincon, Santiago Tamayo
 */

public class login implements OpcionDeMenu {
	public void ejecutar() {
		Object usuario = null;
		try {
			System.out.println("Ingrese su usuario: ");
			String userName = Main.user.next();
			System.out.println("Ingrese su clave: ");
			String clave = Main.user.next();
			if (Data.buscarCliente(userName, clave) != null) {
				usuario = Data.buscarCliente(userName, clave);
				Main.usuario =(Cliente) usuario;
				System.out.println("Datos ingresados correctamente");
			} else if (Data.buscarAdministrador(userName, clave) != null) {
				usuario = Data.buscarAdministrador(userName, clave);
				Main.usuario =(Administrador) usuario;
				System.out.println("Datos ingresados correctamente");
			} else if (Data.buscarTendero(userName, clave) != null) {
				usuario = Data.buscarTendero(userName, clave);
				Main.usuario =(Tendero) usuario;
				System.out.println("Datos ingresados correctamente");
			} else if (Data.buscarRestaurante(userName, clave) != null) {
				usuario = Data.buscarRestaurante(userName, clave);
				Main.usuarioRestaurante =(Restaurante) usuario;
				System.out.println("Datos ingresados correctamente");
			} else {
				System.out.println("Usuario no existente");
				MenuDeConsola.lanzarMenu();
			}
		} catch (Exception e4) {
			System.out.println("Error ingresando usuario, intente nuevamente");
			ejecutar();
		}
		if (usuario instanceof Cliente) {
			usuario = (Cliente) Main.usuario;
			System.out.println("Bienvenido Cliente " + ((Cliente) usuario).getNombre());
		} else if (usuario instanceof Tendero) {
			usuario = (Tendero) Main.usuario;
			System.out.println("Bienvenido Tendero " +((Tendero) usuario).getNombre());
		} else if (usuario instanceof Administrador) {
			usuario = (Administrador) Main.usuario;
			System.out.println("Bienvenido Administrador " +((Administrador) usuario).getNombre());
		} else if (usuario instanceof Restaurante) {
			usuario = (Restaurante) Main.usuarioRestaurante;
			System.out.println("Bienvenido Restaurante " + ((Restaurante) usuario).getNombre());
		}
	}

	public String toString() {
		return "Log In";
	}
}