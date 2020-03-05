package UIMain;

import gestorAplicacion.Oferta.Restaurante;

public class EliminarDireccionRest implements OpcionDeMenu {
	public void ejecutar() {
		System.out.println("Estas son sus direcciones: ");
		for (int i = 0; i < Main.usuarioRestaurante.getDireccion().size(); i++) {
			System.out.println(Main.usuarioRestaurante.getDireccion().get(i));
		}
		System.out.println("Ingrese la direccion a eliminar: ");
		String direccion = Main.user.next();
		Restaurante restaurante = Main.usuarioRestaurante;
		boolean valor = restaurante.eliminarDireccion(direccion);
		if (!valor) {
			System.out.println("la direccion no se encuentra en el directorio.");
			ejecutar();
		}else {
			System.out.println("La direccion se ha eliminado correctamente.");
		}
		MenuDeConsola.lanzarMenu(Main.usuarioRestaurante);
	}

	public String toString() {
		return "Eliminar direccion restaurante";
	}
}
