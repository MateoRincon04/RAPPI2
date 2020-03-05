package UIMain;

import gestorAplicacion.Interaccion.Cliente;

import com.google.gson.Gson;

import BaseDatos.Data;
import gestorAplicacion.Oferta.*;

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
		boolean valor = false;

		System.out.println("Ingrese el nombre del restaurante a buscar: ");
		String nombre = Main.user.next();
		Restaurante restauranteElegido = Data.buscarRestaurante(nombre);
		if (restauranteElegido != null) {
			Plato platoEscogido = escogerPlato(restauranteElegido);
			if (platoEscogido != null) {
				valor = usuarioCliente.hacerPedido(platoEscogido);
			}
		} else {
			System.out.println("No se encontro restaurante con este nombre");
		}

		if (valor) {
			MenuDeConsola.lanzarMenu((Cliente) Main.usuario);
		} else {
			System.out.println("Desea volver a intentar realizar un pedido (1) o volver a su menu (2)? Escriba el numero indicado para la opcion que desee.");
			int opc = Main.user.nextInt();
			if(opc == 2) {
				MenuDeConsola.lanzarMenu((Cliente) Main.usuario);
			}else {
				ejecutar();
			}
			
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
		if (restauranteElegido.getMenu().size() <= 0) {
			System.out.println("Este restaurante no posee platos disponibles");
			return null;
		} else {
			for (int i = 0; i < restauranteElegido.getMenu().size(); i++) {
				Gson gson = new Gson();
				Plato aux = gson.fromJson(restauranteElegido.getMenu().get(i), Plato.class);
				System.out.println((i + 1) + ") " + aux.getNombre());
			}
			System.out.println("Por favor, escriba el n�mero del plato que quiere escoger del restaurante "
					+ restauranteElegido.getNombre());
			while (true) {
				int numero = Main.user.nextInt();
				Plato platoEscogido = restauranteElegido.elegirPlatoMenu(numero);
				if (platoEscogido != null) {
					return platoEscogido;
				} else {
					System.out.println("No se encontro plato con este nombre, intente de nuevo ");
				}
			}
		}
	}

	public String toString() {
		return "Hacer pedido";
	}
}