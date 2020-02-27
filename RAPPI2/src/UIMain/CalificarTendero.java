package UIMain;

import java.util.List;
import java.util.ArrayList;
import Interaccion.Cliente;
import Administracion.Administrador;
import Oferta.*;
import java.util.Scanner;

public class CalificarTendero implements OpcionDeMenu {
	public void ejecutar() {
		Scanner user = new Scanner(System.in);
		if (Main.usuario.getTipo().equals("cliente")) {
			Cliente usuario = (Cliente) Main.usuario;
			System.out.println("Ingrese una calificacion del 0 al 5 al tendero que realizó su pedido: ");
			Double calificacion = user.nextDouble();
			while (true) {
				if (calificacion >= 0 && calificacion <= 5) {
					usuario.calificarTendero(calificacion);
					System.out.println("Ha calificado al tendero correctamente.");
				} else {
					System.out.println("Ingrese una calificación valida.");

				}

			}
		}

	}
}
