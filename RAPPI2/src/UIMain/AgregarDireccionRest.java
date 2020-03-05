package UIMain;

import gestorAplicacion.Oferta.Restaurante;

public class AgregarDireccionRest implements OpcionDeMenu {
	public void ejecutar() {
		System.out.println("Ingrese la nueva direccion a registrar: ");
		String direccion = Main.user.next();
		Restaurante restaurante = Main.usuarioRestaurante;
		boolean valor = restaurante.agregarDireccion(direccion);
		if (!valor) {
			System.out.println("La direccion ya existe. Intente nuevamente");
			ejecutar();
		} else {
			System.out.println("La direccion ha sido agregada correctamente.");
			MenuDeConsola.lanzarMenu(Main.usuarioRestaurante);
		}
	}

	public String toString() {
		return "Agregar Direccion Restaurante";
	}
}
