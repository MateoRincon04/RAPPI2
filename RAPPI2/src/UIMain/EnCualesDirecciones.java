package UIMain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Administracion.Administrador;
import Interaccion.Cliente;
import Oferta.Restaurante;

public class EnCualesDirecciones extends OpcionDeMenu {
	void ejecutar() {

		if (Main.usuario.getTipo().equals("cliente")) {
			Cliente usuario = (Cliente) Main.usuario;
			List<Restaurante> listaRestaurantes = new ArrayList<Restaurante>();
			Restaurante restauranteElegido = escogerRestaurante(listaRestaurantes);
			List<String> direccionesDisponibles = restauranteElegido.getDireccion();
			System.out.println(
					"Estas son las direcciones disponibles para el restaurante: " + restauranteElegido.getNombre());
			for (int i = 0; i < direccionesDisponibles.size(); i++) {
				System.out.println(direccionesDisponibles.get(i));
			}

		}
	}

	private Restaurante escogerRestaurante(List<Restaurante> listaRestaurantes) {
		Scanner user = Main.user;
		listaRestaurantes = Administrador.getRestaurante();
		System.out.println("Estos son los restaurantes disponibles: ");
		for (int i = 0; i < listaRestaurantes.size(); i++) {
			System.out.println(i + ") " + listaRestaurantes.get(i).getNombre());
		}
		System.out.println(
				"Por favor, escoja el número del restaurante al cual quiere saber las direcciones disponibles: ");
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
}
