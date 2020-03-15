package UIMain.Restaurante;


import java.util.List;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import BaseDatos.Data;
import gestorAplicacion.Oferta.Restaurante;

/**
 * Clase EnCualesDirecciones, su finalidad es la de ser aquella clase que permita la implementacion de opcionDeMenu y ejecute cierta funcionalidad 
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon
 */
public class EnCualesDirecciones extends OpcionDeMenu {
	public void ejecutar() {
		Restaurante restauranteElegido = Main.usuarioRestaurante;
		List<String> direccionesDisponibles = restauranteElegido.getDireccion();
		System.out.println("Estas son las direcciones disponibles para el restaurante: " + restauranteElegido.getNombre());
		for (int i = 0; i < direccionesDisponibles.size(); i++) {
			System.out.println(direccionesDisponibles.get(i));
		}
		System.out.println("");
		MenuDeConsola.lanzarMenu(Main.usuarioRestaurante);
	}
	public String toString() {
		return "�En cu�les direcciones?";
	}

}