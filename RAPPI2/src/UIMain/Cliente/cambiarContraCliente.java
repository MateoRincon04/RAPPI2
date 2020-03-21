package UIMain.Cliente;

import BaseDatos.Data;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Interaccion.Cliente;

public class cambiarContraCliente extends OpcionDeMenu {
	public void ejecutar() {
		Cliente cliente = (Cliente) Main.usuario;
		System.out.println("Ingrese su contrase�a actual: ");
		String contra = Main.user.next();
		if (contra.equals(cliente.getClave())) {
			System.out.println("Ingrese la nueva contrase�a: ");
			String nueva = Main.user.next();
			System.out.println("Ingrese de nuevo la nueva contrase�a: ");
			String nueva2 = Main.user.next();
			if (nueva.equals(nueva2)) {
				cliente.setClave(nueva2);
				System.out.println("Su clave ha sido cambiada correctamente.");
				Data.actualizarDataBaseCliente(cliente);
			} else {
				System.out.println("Las contrase�as no coinciden. intente nuevamente:");
				ejecutar();
			}

		} else {
			System.out.println("Esta no es su contrase�a actual. Intente nuevamente: ");
			ejecutar();
		}
		MenuDeConsola.lanzarMenu((Cliente) Main.usuario);
	}

	public String toString() {
		return "Cambiar contrase�a cliente";
	}
}