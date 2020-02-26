package UIMain;

import Interaccion.Cliente;
import Administracion.Perfil;

import java.util.ArrayList;
import java.util.List;

import Oferta.Restaurante;

public class MejorRestauranteCal extends OpcionDeMenu {
	/**
	 * Clase OpcionDeMenu Aqui se crea la funcionalidad del cliente de saber cual es
	 * el plato que mas ha comprado
	 * 
	 * Estructuras revelantes --------------------------------------------------
	 * 
	 * @author: Guillermo Toloza - Santiago Tamayo
	 * @version:
	 */
	void ejecutar() {
		Cliente usuarioUno = (Cliente) Main.usuario;
		List<Restaurante> historial = usuarioUno.verListaDeRestaurantes();
		// bubble sort
		boolean ordenado = false;
		while (!ordenado) {
			ordenado = true;
			for (int i = 0; i < historial.size(); i++) {
				if ((historial.get(i)).getCalificacionPromediada() < (historial.get(i - 1))
						.getCalificacionPromediada()) {
					Restaurante restauranteTemp = historial.get(i);
					historial.add(i, historial.get(i - 1));
					historial.add(i - 1, restauranteTemp);
					ordenado = false;
				}
			}
		}
		System.out.println("Los restaurantes mejor calificados, del mejor al peor son: ");
		for (int i = 0; i < historial.size(); i++) {
			System.out.println(i + " . " + historial.get(i).getNombre());
		}
	}

}
