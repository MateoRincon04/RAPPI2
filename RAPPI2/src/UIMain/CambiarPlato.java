package UIMain;


import com.google.gson.Gson;
import com.google.gson.JsonArray;

import gestorAplicacion.Oferta.Plato;
import gestorAplicacion.Oferta.Restaurante;

public class CambiarPlato implements OpcionDeMenu {
	public void ejecutar() {
		System.out.println("Cambiará un plato del menú. ");
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
		Plato platoBase = restaurante.elegirPlatoMenu(numero);
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
		boolean valor = restaurante.cambiarPlato(platoBase, platoCambio);
		if (!valor) {
			ejecutar();
		}
		MenuDeConsola.lanzarMenu(Main.usuarioRestaurante);
	}

	public String toString() {
		return "Cambiar Plato Restaurante";
	}
}