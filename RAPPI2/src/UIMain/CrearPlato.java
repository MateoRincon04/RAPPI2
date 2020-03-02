package UIMain;

import Oferta.Restaurante;

public class CrearPlato implements OpcionDeMenu {
	public void ejecutar() {
		System.out.println("Ingresar� un nuevo plato a su men�.");
		System.out.println("Ingrese el nombre: ");
		String nombre = Main.user.next();
		System.out.println("Ingrese la descripci�n del plato: ");
		String descripcion = Main.user.next();
		System.out.println("Ingrese el precio: ");
		float precio = Main.user.nextFloat();
		System.out.println("ingrese la restriccion de edad del plato: ");
		int restriccion = Main.user.nextInt();
		Restaurante restaurante = Main.usuarioRestaurante;
		boolean valor = restaurante.crearPlato(nombre, descripcion, precio, restriccion);
		if (!valor) {
			ejecutar();
		}
	}
}
