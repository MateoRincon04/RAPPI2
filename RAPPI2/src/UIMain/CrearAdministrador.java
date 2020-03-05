package UIMain;

import gestorAplicacion.Administracion.Administrador;

public class CrearAdministrador implements OpcionDeMenu {
	public void ejecutar() {
		System.out.println("Usted ingresará un nuevo Administrador en el sistema.");
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
		boolean valor = admin.crearAdministrador(nombre, telefono, comuna, clave, username, salario);
		if (!valor) {
			System.out.println("Administrador ya existente, por favor ingrese de nuevo ");
			ejecutar();

		}else {
			System.out.println("Administrador creado exitosamente ");
		}
		MenuDeConsola.lanzarMenu((Administrador) Main.usuario);
	}

	public String toString() {
		return "Crear Administrador";
	}

}
