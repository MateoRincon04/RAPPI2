package UIMain;

import Interaccion.Cliente;

/**
 * Clase CalificarTendero, su finalidad es la de ser aquella clase que permita
 * la implementacion de opcionDeMenu y ejecute cierta funcionalidad
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon
 *
 */
public class CalificarTendero implements OpcionDeMenu {
	public void ejecutar() {

		Cliente usuario = (Cliente) Main.usuario;
		System.out.println("Ingrese una calificacion del 0 al 5 al tendero que realizó su pedido: ");
		Double calificacion = Main.user.nextDouble();
		while (true) {
			if (calificacion >= 0 && calificacion <= 5) {
				usuario.calificarTendero(calificacion);
				System.out.println("Ha calificado al tendero correctamente.");
				MenuDeConsola.lanzarMenu((Cliente)Main.usuario);
			} else {
				System.out.println("Ingrese una calificación valida.");
			}
		}
	}

	public String toString() {
		return "Calificar Tendero";
	}
}
