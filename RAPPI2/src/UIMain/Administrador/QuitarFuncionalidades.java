package UIMain.Administrador;

import BaseDatos.Data;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Administracion.Administrador;
import gestorAplicacion.Interaccion.Cliente;
import gestorAplicacion.Interaccion.Tendero;
import gestorAplicacion.Oferta.Restaurante;

public class QuitarFuncionalidades extends OpcionDeMenu {
	public void ejecutar() {
		System.out.println("¿A qué tipo de usuario desea eliminar las funcionalidades? Ingrese el número: ");
		System.out.println("1) Cliente");
		System.out.println("2) Tendero");
		System.out.println("3) Restaurante");
		int opcion = Main.user.nextInt();
		if (opcion == 1) {
			System.out.println("Eliminará una funcionalidad de algún cliente.");
			System.out.println("Ingrese el UserName del cliente: ");
			String username = Main.user.next();
			Cliente cliente = Data.buscarCliente(username);
			System.out.println("Estas son las funcionalidades del cliente " + cliente.getNombre() + " :");
			for (int i = 0; i < cliente.getOpciones().size(); i++) {
				System.out.println((i + 1) + ") " + Data.getOpciones().get(cliente.getOpciones().get(i)));

			}
			System.out.println("Escriba el numero de la funcionalidad que desea eliminar: ");
			int eliminar = Main.user.nextInt() - 1;
			if (eliminar < cliente.getOpciones().size()) {
				cliente.getOpciones().remove(eliminar);
				System.out.println("La funcionalidad se ha eliminado correctamente.");
				Data.eliminarObjetoDataBaseCliente(Data.buscarCliente(username));
				Data.agregarObjetoDataBaseCliente(cliente);
				MenuDeConsola.lanzarMenu((Administrador) Main.usuario);
				

			} else {
				System.out.println("No se puede eliminar la funcionalidad. No existe.");
				MenuDeConsola.lanzarMenu((Administrador) Main.usuario);
			}
		}
		
		else if (opcion == 2) {
			System.out.println("Eliminará una funcionalidad de algún tendero.");
			System.out.println("Ingrese el UserName del Tendero: ");
			String username = Main.user.next();
			Tendero tendero = Data.buscarTendero(username);
			System.out.println("Estas son las funcionalidades del tendero" + tendero.getNombre() + " :");
			for (int i = 0; i < tendero.getOpciones().size(); i++) {
				System.out.println((i + 1) + ") " + Data.getOpciones().get(tendero.getOpciones().get(i)));

			}
			System.out.println("Escriba el numero de la funcionalidad que desea eliminar: ");
			int eliminar = Main.user.nextInt() - 1;
			if (tendero.getOpciones().contains(eliminar)) {
				tendero.getOpciones().remove(eliminar);
				System.out.println("La funcionalidad se ha eliminado correctamente.");
				Data.eliminarObjetoDataBaseTendero(Data.buscarTendero(username));
				Data.agregarObjetoDataBaseTendero(tendero);
				MenuDeConsola.lanzarMenu((Administrador) Main.usuario);

			} else {
				System.out.println("No se puede eliminar la funcionalidad. No existe.");
				MenuDeConsola.lanzarMenu((Administrador) Main.usuario);
			}
		}
		else if (opcion == 3) {
			System.out.println("Eliminará una funcionalidad de algún restaurante.");
			System.out.println("Ingrese el UserName del Restaurante: ");
			String username = Main.user.next();
			Restaurante restaurante = Data.buscarRestaurante(username);
			System.out.println("Estas son las funcionalidades del restaurante" + restaurante.getNombre() + " :");
			for (int i = 0; i < restaurante.getOpciones().size(); i++) {
				System.out.println((i + 1) + ") " + Data.getOpciones().get(restaurante.getOpciones().get(i)));

			}
			System.out.println("Escriba el numero de la funcionalidad que desea eliminar: ");
			int eliminar = Main.user.nextInt() - 1;
			if (restaurante.getOpciones().contains(eliminar)) {
				restaurante.getOpciones().remove(eliminar);
				System.out.println("La funcionalidad se ha eliminado correctamente.");
				Data.eliminarObjetoDataBaseRestaurante(Data.buscarRestaurante(username));
				Data.agregarObjetoDataBaseRestaurante(restaurante);
				MenuDeConsola.lanzarMenu((Administrador) Main.usuario);

			} else {
				System.out.println("No se puede eliminar la funcionalidad. No existe.");
				MenuDeConsola.lanzarMenu((Administrador) Main.usuario);;
			}
		}
	}

	public String toString() {
		return "Quitar Funcionalidades de alguien";
	}
}
