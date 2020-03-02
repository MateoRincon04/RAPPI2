package UIMain;

import Oferta.Restaurante;

public class CambiarPlato implements OpcionDeMenu {
	public void ejecutar() {
		System.out.println("Ingrese el nombre del plato que desea cambiar: ");
		String nombre = Main.user.next();
		Restaurante restaurante = Main.usuarioRestaurante;
		//restaurante.cambiarPlato(plato, nuevo); pensar bien
	}
}
