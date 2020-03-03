package UIMain;


import java.util.List;
import UIMain.Main;
import BaseDatos.Data;
import Oferta.Restaurante;

/**
 * Clase EnCualesDirecciones, su finalidad es la de ser aquella clase que permita la implementacion de opcionDeMenu y ejecute cierta funcionalidad 
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon
 */
public class EnCualesDirecciones implements OpcionDeMenu {
	public void ejecutar() {
		Restaurante restauranteElegido = Data.buscarRestaurante(Main.usuarioRestaurante.getNombre());
		List<String> direccionesDisponibles = restauranteElegido.getDireccion();
		System.out.println("Estas son las direcciones disponibles para el restaurante: " + restauranteElegido.getNombre());
		for (int i = 0; i < direccionesDisponibles.size(); i++) {
			System.out.println(direccionesDisponibles.get(i));
		}
		MenuDeConsola.lanzarMenu(Main.usuarioRestaurante);
	}
	public String toString() {
		return "¿En cuáles direcciones?";
	}

}
