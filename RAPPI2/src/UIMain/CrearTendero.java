package UIMain;

import Administracion.Administrador;

public class CrearTendero implements OpcionDeMenu {

	@Override
	public void ejecutar() { // funcion unica del Admin

		System.out.println("Usted ingresará un tendero en el sistema.");
		System.out.println("Ingrese el nombre: ");
		String nombre = Main.user.next();
		System.out.println("Ingrese la clave: ");
		String clave = Main.user.next();
		System.out.println("Ingrese el username: ");
		String username = Main.user.next();
		System.out.println("Ingrese el numero de telefono: ");
		int telefono = Main.user.nextInt();
		System.out.println("Ingrese el salario: ");
		int salario = Main.user.nextInt();
		System.out.println("Ingrese la comuna: ");
		int comuna = Main.user.nextInt();
		Administrador admin = (Administrador) Main.usuario;
		boolean valor = admin.crearTendero(nombre, telefono, comuna, clave, username, salario);
		if (!valor) {
			ejecutar();

		}
		MenuDeConsola.lanzarMenu((Administrador) Main.usuario);
	}
	public String toString() {
		return "Crear Tendero";
	}
}