package UIMain.Cliente;

import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Interaccion.Cliente;

/**
 * Clase CalificarRestaurante, su finalidad es la de ser aquella clase que
 * permita la implementacion de opcionDeMenu y ejecute cierta funcionalidad
 * 
 * @author Guillermo Toloza, Paula A. Taborda, Santiago Tamayo, Mateo Rincon
 */
public class CalificarRestaurante extends OpcionDeMenu {
	public void ejecutar() {

		Cliente usuario = (Cliente) Main.usuario;
		System.out.println("Ingrese una calificacion del 0 al 5 al restaurante que realizó su pedido: ");
		Double calificacion = Main.user.nextDouble();
		Boolean valor = false;
		if (calificacion >= 0 && calificacion <= 5) {
			usuario.calificarRestaurante(calificacion);
			System.out.println("Ha calificado al restaurante correctamente.");
			valor = true;

		} else {
			System.out.println("Ingrese una calificación valida.");
			valor = false;
		}
		if (valor) {
			MenuDeConsola.lanzarMenu((Cliente) Main.usuario);
		} else {
			ejecutar();
		}
	}

	public String toString() {
		return "Calificar Restaurante";
	}
}
