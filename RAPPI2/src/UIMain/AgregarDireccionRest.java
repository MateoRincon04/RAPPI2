package UIMain;

import Oferta.Restaurante;

public class AgregarDireccionRest implements OpcionDeMenu {
	public void ejecutar() {
		System.out.println("Ingrese la nueva direccion a registrar: ");
		String direccion = Main.user.next();
		Restaurante restaurante = Main.usuarioRestaurante;
		boolean valor = restaurante.agregarDireccion(direccion);
		if (!valor) {
			ejecutar();
		}
	}

	public String toString() {
		return "Agregar Direccion Restaurante";
	}
}
