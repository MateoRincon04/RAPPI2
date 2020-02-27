package UIMain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Administracion.Administrador;
import BaseDatos.Data;
import Interaccion.Cliente;
import Oferta.Restaurante;

public class EnCualesDirecciones implements OpcionDeMenu {
	public void ejecutar() {
		Scanner user = Main.user;
		Cliente usuario = (Cliente) Main.usuario;
		System.out.println("Ingrese el nombre del restaurante a buscar: ");
		String nombre = user.nextLine();
		Restaurante restauranteElegido = Data.buscarRestaurante(nombre);
		List<String> direccionesDisponibles = restauranteElegido.getDireccion();

		System.out.println(
				"Estas son las direcciones disponibles para el restaurante: " + restauranteElegido.getNombre());
		for (int i = 0; i < direccionesDisponibles.size(); i++) {
			System.out.println(direccionesDisponibles.get(i));
		}

	}

}
