package UIMain;

import Administracion.*;
import Interaccion.Cliente;
import Interaccion.Tendero;
import Oferta.Restaurante;
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
		Perfil usuario = null;
		Restaurante usuarioRestaurante=null;
		try {
			System.out.println("Ingrese su usuario: ");
			String userName = Main.user.next();
			System.out.println("Ingrese su clave: ");
			String clave = Main.user.next();
				if(Data.buscarCliente(userName, clave)!=null) {
					usuario = Data.buscarCliente(userName, clave);
				}else {
					if(Data.buscarAdministrador(userName, clave)!=null) {
						usuario = Data.buscarAdministrador(userName, clave);
					}else {
						if(Data.buscarTendero(userName, clave)!=null) {
							usuario = Data.buscarTendero(userName, clave);
						}else {
							if(Data.buscarRestaurante(userName, clave)!=null) {
								usuarioRestaurante = Data.buscarRestaurante(userName, clave);
							}else {
								System.out.println("Usuario no existente");
							}
						}
					}
				}
			Main.usuario = usuario;
			Main.usuarioRestaurante=usuarioRestaurante;
			
			System.out.println("Datos ingresados correctamente");
		}catch (Exception e4) {
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