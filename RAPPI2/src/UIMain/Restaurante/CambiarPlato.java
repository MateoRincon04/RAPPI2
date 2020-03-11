package UIMain.Restaurante;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Oferta.Plato;
import gestorAplicacion.Oferta.Restaurante;

public class CambiarPlato extends OpcionDeMenu {
	public void ejecutar() {
		System.out.println("Cambiará un plato del menú. ");
		Restaurante restaurante = Main.usuarioRestaurante;
		System.out.println("Este es el menú de platos que cuenta el restaurante.");
		System.out.println(restaurante.getMenu());
		System.out.println("Ingrese los datos del nuevo plato: ");
		System.out.println("Ingrese el nombre: ");
		String nombre = Main.user.next();
		System.out.println("Ingrese la descripción del plato: ");
		String descripcion = Main.user.next();
		System.out.println("Ingrese el precio: ");
		float precio = Main.user.nextFloat();
		System.out.println("ingrese la restriccion de edad del plato: ");
		int restriccion = Main.user.nextInt();
		Plato platoCambio = new Plato(nombre, descripcion, precio, restriccion, restaurante);
		boolean valor = restaurante.cambiarPlato(platoCambio);
		if (!valor) {
			System.out.println("No se encuentra el plato para el cambio. Intente nuevamente.");
			ejecutar();
		} else {
			System.out.println("Su plato se ha cambiado correctamente");
		}
		MenuDeConsola.lanzarMenu(Main.usuarioRestaurante);
	}

	public String toString() {
		return "Cambiar Plato Restaurante";
	}
}