package UIMain;

import Interaccion.Cliente;

/**
 * Clase CalificarRestaurante, su finalidad es la de ser aquella clase que
 * permita la implementacion de opcionDeMenu y ejecute cierta funcionalidad
 * 
 * @author Guillermo Toloza, Paula A. Taborda, Santiago Tamayo, Mateo Rincon
 */
public class CalificarRestaurante implements OpcionDeMenu {
	public void ejecutar() {

		Cliente usuario = (Cliente) Main.usuario;
		System.out.println("Ingrese una calificacion del 0 al 5 al restaurante que realizó su pedido: ");
		Double calificacion = Main.user.nextDouble();
		while (true) {
			if (calificacion >= 0 && calificacion <= 5) {
				usuario.calificarRestaurante(calificacion);
				System.out.println("Ha calificado al restaurante correctamente.");
			} else {
				System.out.println("Ingrese una calificación valida.");

			}

		}
	}

	public String toString() {
		return "Calificar Restaurante";
	}
}
