package UIMain.Administrador;

import BaseDatos.Data;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Administracion.Administrador;

public class cambiarContraseñaAdmin extends OpcionDeMenu {
	public void ejecutar() {
		Administrador admin = (Administrador) Main.usuario;
		System.out.println("Ingrese su contraseña actual: ");
		String contra = Main.user.next();
		if (contra.equals(admin.getClave())) {
			System.out.println("Ingrese la nueva contraseña: ");
			String nueva = Main.user.next();
			System.out.println("Ingrese de nuevo la nueva contraseña: ");
			String nueva2 = Main.user.next();
			if (nueva.equals(nueva2)) {
				admin.setClave(nueva2);
				System.out.println("Su clave ha sido cambiada correctamente.");
				Data.actualizarDataBaseAdministrador(admin);
			} else {
				System.out.println("Las contraseñas no coinciden. intente nuevamente:");
				ejecutar();
			}

		} else {
			System.out.println("Esta no es su contraseña actual. Intente nuevamente: ");
			ejecutar();
		}
		MenuDeConsola.lanzarMenu((Administrador) Main.usuario);
	}

	public String toString() {
		return "Cambiar contraseña administrador";
	}
}
