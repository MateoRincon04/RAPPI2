package UIMain;

import java.util.List;
import java.util.ArrayList;
import Interaccion.Cliente;
import Administracion.Administrador;
import BaseDatos.Data;
import Oferta.*;

public class HacerPedido implements OpcionDeMenu {

	public void ejecutar() {
		/* se esta definiendo la forma como hace el pedido el usuario */
		Cliente usuarioCliente = (Cliente) (Main.usuario);
		System.out.println("Ingrese el nombre del restaurante a buscar: ");
		String nombre = Main.user.nextLine();
		Restaurante restauranteElegido = Data.buscarRestaurante(nombre);
		Plato platoEscogido = escogerPlato(restauranteElegido);
		usuarioCliente.hacerPedido(platoEscogido);

	}

	private Plato escogerPlato(Restaurante restauranteElegido) {
		List<Plato> listaPlatos = restauranteElegido.getMenu();
		System.out.println("Este es el menú de platos del restaurante elegido: ");
		for (int i = 0; i < listaPlatos.size(); i++) {
			System.out.println(i + ") " + listaPlatos.get(i).getNombre());
		}
		System.out.println("Por favor, escriba el número del plato que quiere escoger del restaurante "
				+ restauranteElegido.getNombre());
		while (true) {
			try {
				int numero = Main.user.nextInt();
				Plato platoEscogido = restauranteElegido.elegirPlatoMenu(numero);
				return platoEscogido;
			} catch (Exception e) {
				System.out.println("Por favor, intente nuevamente.");
			}
		}
	}
}