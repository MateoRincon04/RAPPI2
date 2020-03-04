package UIMain;

import java.util.List;
import Interaccion.Cliente;
import BaseDatos.Data;
import Oferta.*;
import Interaccion.Notificacion;

/**
 * Clase HacerPedido, su finalidad es la de ser aquella clase que permita la
 * implementacion de opcionDeMenu y ejecute cierta funcionalidad
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon
 */
public class HacerPedido implements OpcionDeMenu {

	public void ejecutar() {
		// se esta definiendo la forma como hace el pedido el usuario
		Cliente usuarioCliente = (Cliente) (Main.usuario);

		System.out.println("Ingrese el nombre del restaurante a buscar: ");
		String nombre = Main.user.next();
		Restaurante restauranteElegido = Data.buscarRestaurante(nombre);
		Plato platoEscogido = escogerPlato(restauranteElegido);
		boolean valor = usuarioCliente.hacerPedido(platoEscogido);
		if (valor) {
			Pedido pedidoUltimo = usuarioCliente.getHistorial().get(usuarioCliente.getHistorial().size() - 1);
			Notificacion notificacion = new Notificacion(pedidoUltimo); // notifico una vez hecho el pedido

			MenuDeConsola.lanzarMenu((Cliente) Main.usuario);

		} else {
			ejecutar();
		}

	}

	/**
	 * Metodo que le permite al cliente escoger que plato desea pedir
	 * 
	 * @param restauranteElegido El parametro restauranteElegido define cual fue el
	 *                           restaurante del cual el cliente selecciono el plato
	 *                           que desea
	 * 
	 * @return El plato que fue seleccionado
	 */
	private Plato escogerPlato(Restaurante restauranteElegido) {

		System.out.println("Este es el men� de platos que cuenta el restaurante.");

		for (int i = 0; i < restauranteElegido.getMenu().size(); i++) {
			System.out.println((i + 1) + ") " + restauranteElegido.getMenu().get(i).getNombre());
		}
		System.out.println("Por favor, escriba el n�mero del plato que quiere escoger del restaurante "
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

	public String toString() {
		return "Hacer pedido";
	}
}