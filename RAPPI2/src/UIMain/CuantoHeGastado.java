package UIMain;

import Administracion.Administrador;
import Oferta.*;

import Interaccion.Cliente;

public class CuantoHeGastado extends OpcionDeMenu {
	void ejecutar() {
		if (Main.usuario.getTipo().equals("cliente")) {
			Cliente cliente = (Cliente) Main.usuario;
			int valorGastado = 0;
			for (Pedido pedido : cliente.getHistorial()) { // Por cada pedido en la lista de pedidos:
				valorGastado += pedido.getPlato().getPrecio(); // no sab�a usar for each jeje pero ya aprend�
			}
			System.out.println("Usted ha gastado: " + valorGastado);
			System.out.println("Actualmente usted tiene: " + cliente.getSaldo() + " pesos.");
		}

	}
}
