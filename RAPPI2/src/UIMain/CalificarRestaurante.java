package UIMain;

import java.util.List;
import java.util.ArrayList;
import Interaccion.Cliente;
import Administracion.Administrador;
import Oferta.*;


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

	public String ToString() {
		return "Calificar Restaurante";
	}
}
