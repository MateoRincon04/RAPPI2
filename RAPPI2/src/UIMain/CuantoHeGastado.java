package UIMain;

import Administracion.Administrador;
import Oferta.*;

import Interaccion.Cliente;

public class CuantoHeGastado implements OpcionDeMenu {
	public void ejecutar() {
			Cliente cliente = (Cliente) Main.usuario;
			int valorGastado = 0;
			for (Pedido pedido : cliente.getHistorial()) { // Por cada pedido en la lista de pedidos:
				valorGastado += pedido.getPlato().getPrecio(); // no sabía usar for each jeje pero ya aprendí
			}
			System.out.println("Usted ha gastado: " + valorGastado);
			System.out.println("Actualmente usted tiene: " + cliente.getSaldo() + " pesos.");
		

	}
}
