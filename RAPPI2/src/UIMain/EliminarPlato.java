package UIMain;

import java.util.List;

import gestorAplicacion.Oferta.Plato;
import gestorAplicacion.Oferta.Restaurante;

public class EliminarPlato implements OpcionDeMenu {
	public void ejecutar() {
		System.out.println("Eliminará un plato del menú. ");
		Restaurante restaurante = Main.usuarioRestaurante;
		List<Plato> menuPlatos = restaurante.getMenu();
		System.out.println("Este es el menú de platos que cuenta el restaurante.");

		for (int i = 0; i < menuPlatos.size(); i++) {
			System.out.println((i + 1) + ") " + menuPlatos.get(i).getNombre());
		}
		System.out.println("Por favor, escriba el numero del plato el cual desea cambiar: ");
		int numero = Main.user.nextInt() - 1;
		Plato platoBorrar = restaurante.elegirPlatoMenu(numero);
		boolean valor = restaurante.eliminarPlato(platoBorrar);
		if (!valor) {
			System.out.println("Error borrando el plato. Intente nuevamente.");
			ejecutar();

		} else {
			System.out.println("Su plato se ha removido correctamente. ");
		}
		MenuDeConsola.lanzarMenu(Main.usuarioRestaurante);
	}

	public String toString() {
		return "Eliminar plato";
	}
}
