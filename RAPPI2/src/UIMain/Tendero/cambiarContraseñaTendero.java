package UIMain.Tendero;

import BaseDatos.Data;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Interaccion.Tendero;

public class cambiarContrase�aTendero extends OpcionDeMenu {
	public void ejecutar() {
		Tendero tendero = (Tendero) Main.usuario;
		System.out.println("Ingrese su contrase�a actual: ");
		String contra = Main.user.next();
		if (contra.equals(tendero.getClave())) {
			System.out.println("Ingrese la nueva contrase�a: ");
			String nueva = Main.user.next();
			System.out.println("Ingrese de nuevo la nueva contrase�a: ");
			String nueva2 = Main.user.next();
			if (nueva.equals(nueva2)) {
				tendero.setClave(nueva2);
				System.out.println("Su clave ha sido cambiada correctamente.");
				Data.actualizarDataBaseTendero(tendero);
			} else {
				System.out.println("Las contrase�as no coinciden. intente nuevamente:");
				ejecutar();
			}

		} else {
			System.out.println("Esta no es su contrase�a actual. Intente nuevamente: ");
			ejecutar();
		}
		MenuDeConsola.lanzarMenu((Tendero) Main.usuario);
	}

	public String toString() {
		return "Cambiar contrase�a tendero";
	}
}
