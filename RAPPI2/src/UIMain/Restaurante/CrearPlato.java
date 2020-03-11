package UIMain.Restaurante;

import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Oferta.Restaurante;

public class CrearPlato extends OpcionDeMenu {
	public void ejecutar() {
		Restaurante restaurante = Main.usuarioRestaurante;
		System.out.println("Ingresará un nuevo plato a su menú.");
		System.out.println("Ingrese el nombre: ");
		String nombre = Main.user.next();
		System.out.println("Ingrese la descripción del plato: ");
		String descripcion = Main.user.next();
		System.out.println("Ingrese el precio: ");
		float precio = Main.user.nextFloat();
		System.out.println("ingrese la restriccion de edad del plato: ");
		int restriccion = Main.user.nextInt();
		boolean valor = true;
		if(restaurante.getMenu().equals("")) {
			valor = false;
		}else {
			valor = restaurante.crearPlato(nombre, descripcion, precio, restriccion);
		}
		if (!valor) {
			System.out.println("El restaurante ya cuenta con su plato, si desea cambiar de plato porfavor seleccione la opcion Cambiar Plato Restaurante");
			MenuDeConsola.lanzarMenu(Main.usuarioRestaurante);
		} else {
			System.out.println("Su plato se ha creado correctamente.");
		}
		MenuDeConsola.lanzarMenu(Main.usuarioRestaurante);
	}

	public String toString() {
		return "Crear Plato Restaurante";
	}
}
