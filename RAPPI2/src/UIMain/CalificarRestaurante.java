package UIMain;

import java.util.List;
import java.util.ArrayList;
import Interaccion.Cliente;
import Administracion.Administrador;
import Oferta.*;
import java.util.Scanner;

public class CalificarRestaurante implements OpcionDeMenu {
	public void ejecutar() {
		Scanner user = new Scanner(System.in);
		if (Main.usuario.getTipo().equals("cliente")) {
			try {
				Cliente usuario = (Cliente) Main.usuario;
				System.out.println("Ingrese una calificacion al restaurante que realizó su pedido: ");
				Double calificacion = user.nextDouble();
				usuario.calificarRestaurante(calificacion);
				System.out.println("Ha calificado al restaurante correctamente.");
			} catch (Exception e) {
				System.out.println("Ingrese una calificación valida.");
				ejecutar();
			}
		}
	}
}
