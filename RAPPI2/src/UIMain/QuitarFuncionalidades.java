package UIMain;

import BaseDatos.Data;
import gestorAplicacion.Administracion.Administrador;
import gestorAplicacion.Interaccion.Cliente;
import gestorAplicacion.Interaccion.Tendero;
import gestorAplicacion.Oferta.Restaurante;

public class QuitarFuncionalidades implements OpcionDeMenu {
	public void ejecutar() {
		Administrador admin = (Administrador) Main.usuario;
		System.out.println("�A qu� tipo de usuario desea eliminar las funcionalidades? Ingrese el n�mero: ");
		System.out.println("1) Cliente");
		System.out.println("2) Tendero");
		System.out.println("3) Restaurante");
		int opcion = Main.user.nextInt();
		if (opcion == 1) {
			System.out.println("Eliminar� una funcionalidad de alg�n cliente.");
			System.out.println("Ingrese el UserName del cliente: ");
			String username = Main.user.next();
			Cliente cliente = Data.buscarCliente(username);
			System.out.println("Estas son las funcionalidades del cliente " + cliente.getNombre()+ " :");
			for (int i = 0; i < cliente.getOpciones().size(); i++) {
				System.out.println((i + 1) + ") " + cliente.getOpciones().get(i));

			}
			System.out.println("Escriba el numero de la funcionalidad que desea eliminar: ");
			int eliminar = Main.user.nextInt();
			cliente.getOpciones().remove(eliminar - 1);
			System.out.println("La funcionalidad se ha eliminado correctamente.");
		} else if (opcion == 2) {
			System.out.println("Eliminar� una funcionalidad de alg�n tendero.");
			System.out.println("Ingrese el UserName del Tendero: ");
			String username = Main.user.next();
			Tendero tendero = Data.buscarTendero(username);
			System.out.println("Estas son las funcionalidades del tendero" +tendero.getNombre()+" :");
			for (int i = 0; i < tendero.getOpciones().size(); i++) {
				System.out.println((i + 1) + ") " + tendero.getOpciones().get(i));

			}
			System.out.println("Escriba el numero de la funcionalidad que desea eliminar: ");
			int eliminar = Main.user.nextInt();
			tendero.getOpciones().remove(eliminar - 1);
			System.out.println("La funcionalidad se ha eliminado correctamente.");
		}else if (opcion == 3) {
			System.out.println("Eliminar� una funcionalidad de alg�n restaurante.");
			System.out.println("Ingrese el UserName del Restaurante: ");
			String username = Main.user.next();
			Restaurante restaurante = Data.buscarRestaurante(username);
			System.out.println("Estas son las funcionalidades del restaurante" +restaurante.getNombre()+" :");
			for (int i = 0; i < restaurante.getOpciones().size(); i++) {
				System.out.println((i + 1) + ") " + restaurante.getOpciones().get(i));

			}
			System.out.println("Escriba el numero de la funcionalidad que desea eliminar: ");
			int eliminar = Main.user.nextInt();
			restaurante.getOpciones().remove(eliminar - 1);
			System.out.println("La funcionalidad se ha eliminado correctamente.");
		}
	}
}
