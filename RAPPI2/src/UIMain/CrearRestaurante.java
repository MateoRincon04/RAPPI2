package UIMain;

import Administracion.Administrador;

public class CrearRestaurante implements OpcionDeMenu {
	public void ejecutar() { // funcion unica del Admin
		System.out.println("Usted ingresará un Restaurante en el sistema.");
		System.out.println("Ingrese el nombre: ");
		String nombre = Main.user.next();
		System.out.println("Ingrese la direccion: ");
		String direccion = Main.user.next();
		System.out.println("Ingrese el celular: ");
		String celular = Main.user.next();
		System.out.println("Ingrese la clave: ");
		String clave = Main.user.next();
		Administrador admin = (Administrador) Main.usuario;
		boolean valor = admin.crearRestaurante(nombre, direccion, celular, clave);
		if (!valor) {
			ejecutar();
		}
		MenuDeConsola.lanzarMenu((Administrador) Main.usuario);
	}
	public String toString() {
		return "Crear Restaurante";
	}
}
