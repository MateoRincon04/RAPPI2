package UIMain;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import gestorAplicacion.Oferta.Plato;
import gestorAplicacion.Oferta.Restaurante;

public class EliminarPlato implements OpcionDeMenu {
	public void ejecutar() {
		System.out.println("Eliminará un plato del menú. ");
		Restaurante restaurante = Main.usuarioRestaurante;
		JsonArray menuPlatos = restaurante.getMenu();
		System.out.println("Este es el menú de platos que cuenta el restaurante.");

		for (int i = 0; i < menuPlatos.size(); i++) {
			Gson gson = new Gson();
			Plato aux = gson.fromJson(menuPlatos.get(i), Plato.class);
			System.out.println((i + 1) + ") " + aux.getNombre());
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
