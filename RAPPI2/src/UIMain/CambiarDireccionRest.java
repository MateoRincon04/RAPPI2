package UIMain;

import Oferta.Restaurante;

public class CambiarDireccionRest implements OpcionDeMenu {
	public void ejecutar() {
		System.out.println("Cambiará una de las direcciones del restaurante");
		System.out.println("Ingrese la direccion que desea cambiar: ");
		String direccion = Main.user.next();
		System.out.println("Ingrese la nueva direccion: ");
		String direccionNueva = Main.user.next();
		Restaurante restaurante = Main.usuarioRestaurante;
		boolean valor = restaurante.cambiarDireccion(direccion, direccionNueva);
		if (!valor) {
			ejecutar();
		}
		MenuDeConsola.lanzarMenu(Main.usuarioRestaurante);
	}

	public String toString() {
		return "Cambiar Direccion Restaurante";
	}
}
