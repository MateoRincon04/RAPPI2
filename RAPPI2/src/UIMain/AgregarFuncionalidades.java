package UIMain;

import BaseDatos.Data;
import gestorAplicacion.Interaccion.Cliente;
import gestorAplicacion.Interaccion.Tendero;
import gestorAplicacion.Oferta.Restaurante;

public class AgregarFuncionalidades implements OpcionDeMenu {
	public void ejecutar() {
		System.out.println("¿A qué tipo de usuario desea agregar las funcionalidades? Ingrese el número: ");
		System.out.println("1) Cliente");
		System.out.println("2) Tendero");
		System.out.println("3) Restaurante");
		int opcion = Main.user.nextInt();
		if (opcion == 1) {
			System.out.println("agregará una funcionalidad a algún cliente.");
			System.out.println("Ingrese el UserName del cliente: ");
			String username = Main.user.next();
			Cliente cliente = Data.buscarCliente(username);
			System.out.println("Estas son las funcionalidades del cliente " + cliente.getNombre() + " :");
			for (int i = 0; i < cliente.getOpciones().size(); i++) {
				System.out.println((i + 1) + ") " + cliente.getOpciones().get(i));

			}
			System.out.println("Estas son todas las funcionalidades para un cliente disponibles: ");
			for (int i = 3; i < 9; i++) {
				System.out.println((i - 2) + ") " + Data.getOpciones().get(i));
			}
			System.out.println("Escoja el numero de la funcionalidad que desea agregarle al cliente "
					+ cliente.getNombre() + " :");
			int numerito = Main.user.nextInt() + 2;
			if (cliente.getOpciones().contains(numerito)) {
				System.out.println("La funcionalidad ya existe. Intente nuevamente.");
				ejecutar();
			} else {
				cliente.getOpciones().add(numerito);
				System.out.println("Se ha agregado correctamente la funcionalidad.");
			}

		}
		if (opcion == 2) {
			System.out.println("agregará una funcionalidad a algún Tendero.");
			System.out.println("Ingrese el UserName del Tendero: ");
			String username = Main.user.next();
			Tendero tendero = Data.buscarTendero(username);
			System.out.println("Estas son las funcionalidades del Tendero " + tendero.getNombre() + " :");
			for (int i = 0; i < tendero.getOpciones().size(); i++) {
				System.out.println((i + 1) + ") " + tendero.getOpciones().get(i));

			}
			System.out.println("Estas son todas las funcionalidades para un Tendero disponibles: ");
			for (int i = 9; i < 11; i++) {
				System.out.println((i - 8) + ") " + Data.getOpciones().get(i));
			}
			System.out.println("Escoja el numero de la funcionalidad que desea agregarle al Tendero "
					+ tendero.getNombre() + " :");
			int numerito = Main.user.nextInt() + 8;
			if (tendero.getOpciones().contains(numerito)) {
				System.out.println("La funcionalidad ya existe. Intente nuevamente.");
				ejecutar();
			} else {
				tendero.getOpciones().add(numerito);
				System.out.println("Se ha agregado correctamente la funcionalidad.");
			}
		}

		if (opcion == 3) {
			System.out.println("agregará una funcionalidad a algún Restaurante.");
			System.out.println("Ingrese el UserName del Restaurante: ");
			String username = Main.user.next();
			Restaurante restaurante = Data.buscarRestaurante(username);
			System.out.println("Estas son las funcionalidades del restaurante " + restaurante.getNombre() + " :");
			for (int i = 0; i < restaurante.getOpciones().size(); i++) {
				System.out.println((i + 1) + ") " + restaurante.getOpciones().get(i));

			}
			System.out.println("Estas son todas las funcionalidades para un Restaurante disponibles: ");
			for (int i = 11; i < 17; i++) {
				System.out.println((i - 10) + ") " + Data.getOpciones().get(i));
			}
			System.out.println("Escoja el numero de la funcionalidad que desea agregarle al Restaurante "
					+ restaurante.getNombre() + " :");
			int numerito = Main.user.nextInt() + 10;
			if (restaurante.getOpciones().contains(numerito)) {
				System.out.println("La funcionalidad ya existe. Intente nuevamente.");
				ejecutar();
			} else {
				restaurante.getOpciones().add(numerito);
				System.out.println("Se ha agregado correctamente la funcionalidad.");
			}

		}

	}

	public String toString() {
		return "Agregar Funcionalidades de alguien";
	}
}
