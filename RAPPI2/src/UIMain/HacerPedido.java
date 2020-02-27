package UIMain;

import java.util.List;
import java.util.ArrayList;
import Interaccion.Cliente;
import Administracion.Administrador;
import Oferta.*;
import java.util.Scanner;

public class HacerPedido implements OpcionDeMenu {

	public void ejecutar() {
		Scanner user = new Scanner(System.in);
		if (Main.usuario.getTipo().equals("cliente")) {
			/* se esta definiendo la forma como hace el pedido el usuario*/
			Cliente usuarioCliente = (Cliente) (Main.usuario);
			List<Restaurante> listaRestaurantes = new ArrayList<Restaurante>();
			Restaurante restauranteElegido = escogerRestaurante(listaRestaurantes);
			Plato platoEscogido = escogerPlato(restauranteElegido);
			usuarioCliente.hacerPedido(platoEscogido);

		}
	}

	private Restaurante escogerRestaurante(List<Restaurante> listaRestaurantes) {
		Scanner user = new Scanner(System.in);
		listaRestaurantes = Administrador.getRestaurante();
		System.out.println("Estos son los restaurantes disponibles: ");
		for (int i = 0; i < listaRestaurantes.size(); i++) {
			System.out.println(i + ") " + listaRestaurantes.get(i).getNombre());
		}
		System.out.println("Por favor, escriba el número del restaurante al cuál hará un pedido.");
		while (true) {
			try {
				int numero = user.nextInt();
				Restaurante restauranteEscogido = listaRestaurantes.get(numero);
				user.close();
				return restauranteEscogido;
			} catch (Exception e) {
				System.out.println("Por favor, intente nuevamente.");
			}
		}
	}

	private Plato escogerPlato(Restaurante restauranteElegido) {
		Scanner user = new Scanner(System.in);
		List<Plato> listaPlatos = restauranteElegido.getMenu();
		System.out.println("Este es el menú de platos del restaurante elegido: ");
		for (int i = 0; i < listaPlatos.size(); i++) {
			System.out.println(i + ") " + listaPlatos.get(i).getNombre());
		}
		System.out.println("Por favor, escriba el número del plato que quiere escoger del restaurante "
				+ restauranteElegido.getNombre());
		while (true) {
			try {
				int numero = user.nextInt();
				Plato platoEscogido = restauranteElegido.elegirPlatoMenu(numero);
				user.close();
				return platoEscogido;
			} catch (Exception e) {
				System.out.println("Por favor, intente nuevamente.");
			}
		}
	}
}