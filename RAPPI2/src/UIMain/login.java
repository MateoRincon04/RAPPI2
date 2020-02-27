package UIMain;

import java.util.Scanner;
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
		Scanner user = Main.user;
		try {
			System.out.println("Ingrese su usuario: ");
			String userName = user.nextLine();
			System.out.println("Ingrese su clave: ");
			int clave = user.nextInt();
			usuario = Data.buscarUsuario(userName, clave);
			Main.usuario = usuario;
			System.out.println("Datos ingresados correctamente");

		} catch (Exception e) {
			System.out.println("Error ingresando usuario, intente nuevamente");
			ejecutar();
		}
		if (usuario instanceof Cliente) {
			usuario = (Cliente) Main.usuario;
		} else if (usuario instanceof Tendero) {
			usuario = (Tendero) Main.usuario;
		} else if (usuario instanceof Administrador) {
			usuario = (Administrador) Main.usuario;
		}

	}
}
