package UIMain;

import java.util.ArrayList;
import BaseDatos.Data;
import gestorAplicacion.Administracion.Administrador;
import gestorAplicacion.Interaccion.Cliente;

public class AgregarFuncionalidades implements OpcionDeMenu {
	public void ejecutar() {
		Administrador admin = (Administrador) Main.usuario;
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
			ArrayList<OpcionDeMenu> listaCliente = null;
			for (int i = 3; i < 9; i++) {
				listaCliente.add(Data.getOpciones().get(i));
				System.out.println((i - 2) + ") " + Data.getOpciones().get(i).toString());
			}
			System.out.println("Escoja el numero de la funcionalidad que desea agregarle al cliente "
					+ cliente.getNombre() + " :");
			int numerito = Main.user.nextInt()+2;
			cliente.getOpciones().add(Data.getOpciones().get(numerito));
		}
	}
}
