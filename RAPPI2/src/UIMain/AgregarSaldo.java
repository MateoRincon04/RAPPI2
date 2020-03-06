package UIMain;

import BaseDatos.Data;
import gestorAplicacion.Interaccion.Cliente;

public class AgregarSaldo implements OpcionDeMenu {
	public void ejecutar() {
		Cliente cliente = (Cliente) Main.usuario;
		System.out.println("Usted añadirá saldo a su cuenta: ");
		System.out.println("Ingrese la cantidad que va a añadir: ");
		long numero = Main.user.nextInt();
		if (numero >= 0) {
			cliente.agregarSaldo(numero);
			Data.eliminarObjetoDataBaseCliente(Data.buscarCliente(cliente.getUserName()));
			Data.agregarObjetoDataBaseCliente(cliente);
			System.out.println("Ha agregado el saldo nuevo correctamente.");
		} else {
			System.out.println("Ingrese un saldo positivo. Intente nuevamente.");
			ejecutar();
		}
		MenuDeConsola.lanzarMenu((Cliente)Main.usuario);
	}

	public String toString() {
		return "Agregar Saldo";
	}
}
