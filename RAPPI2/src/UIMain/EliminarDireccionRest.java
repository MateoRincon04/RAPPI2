package UIMain;

import Oferta.Restaurante;

public class EliminarDireccionRest implements OpcionDeMenu {
	public void ejecutar() {
		System.out.println("Ingrese la direccion a eliminar: ");
		String direccion = Main.user.next();
		Restaurante restaurante = Main.usuarioRestaurante;
		boolean valor = restaurante.eliminarDireccion(direccion);
		if (!valor) {
			ejecutar();
		}
	}
}
