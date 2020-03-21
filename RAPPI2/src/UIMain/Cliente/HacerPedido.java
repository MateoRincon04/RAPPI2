package UIMain.Cliente;

import gestorAplicacion.Interaccion.Cliente;
import BaseDatos.Data;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Oferta.*;

/**
 * Clase HacerPedido, su finalidad es la de ser aquella clase que permita la
 * implementacion de opcionDeMenu y ejecute cierta funcionalidad
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon
 */
public class HacerPedido extends OpcionDeMenu {

	public void ejecutar() {
		// se esta definiendo la forma como hace el pedido el usuario
		Cliente usuarioCliente = (Cliente) (Main.usuario);
		boolean valor = false;

		System.out.println("Ingrese el nombre del restaurante a buscar: ");
		String nombre = Main.user.next();
		String restaurante = null;
		for(int i : usuarioCliente.getHistorial()) {
			if(Data.buscarPedido(i).getEntregado().equals("noEntegrado")) {
				restaurante = Data.buscarPedido(i).getRestaurante();
			}
		}
		if(restaurante!=null) {
			System.out.println("tiene un pedido en curso en "+ restaurante);
			System.out.println(
					"¿Desea volver a hacer un pedido (1) o volver a su menu (2)? Escriba el numero indicado para la opcion que desee.");
			int opc = Main.user.nextInt();
			if (opc == 2) {
				MenuDeConsola.lanzarMenu((Cliente) Main.usuario);
			} else {
				ejecutar();
			}
		}else {
			Restaurante restauranteElegido = Data.buscarRestaurante(nombre);
			Plato platoEscogido = null;
			if (restauranteElegido != null) {
				platoEscogido = escogerPlato(restauranteElegido);
				if (platoEscogido != null) {
					valor = usuarioCliente.hacerPedido(platoEscogido);
					System.out.println("Su pedido se ha realizado correctamente.");
				}
			} else {
				System.out.println("No se encontro restaurante con este nombre");
			}

			if (!valor && restauranteElegido != null && platoEscogido != null) {
				System.out.println("Usted no cuenta con saldo suficiente para pedir este plato.");
				MenuDeConsola.lanzarMenu((Cliente) Main.usuario);
			} else {
				System.out.println(
						"¿Desea volver a hacer un pedido (1) o volver a su menu (2)? Escriba el numero indicado para la opcion que desee.");
				int opc = Main.user.nextInt();
				if (opc == 2) {
					MenuDeConsola.lanzarMenu((Cliente) Main.usuario);
				} else {
					ejecutar();
				}
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
		Plato plato =null;
		System.out.println("Este es el menu de platos con el que cuenta el restaurante.");
		System.out.println(restauranteElegido.getMenu());
		if (restauranteElegido.getMenu().equals("")) {
			System.out.println("Este restaurante no posee platos disponibles");
			return null;
		} else {
			plato= Data.buscarPlato(restauranteElegido.getMenu());
			System.out.println("pedido en proceso");
		}
		return plato;
	}

	public String toString() {
		return "Hacer pedido";
	}
}