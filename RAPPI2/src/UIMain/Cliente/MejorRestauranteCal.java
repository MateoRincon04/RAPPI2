package UIMain.Cliente;

import BaseDatos.Data;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Interaccion.Cliente;
import java.util.ArrayList;
import gestorAplicacion.Oferta.Restaurante;

/**
 * Clase MejorRestauranteCal, su finalidad es la de ser aquella clase que permita la implementacion de opcionDeMenu y ejecute cierta funcionalidad 
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon
 */
public class MejorRestauranteCal extends OpcionDeMenu {

	public void ejecutar() {
		System.out.println("El mejor restaurante por su calificacion es: ");
		Restaurante res = Data.OrganizarRestaurantesPorCalificacion();
		System.out.println(res.getNombre());
		System.out.println("");
		MenuDeConsola.lanzarMenu((Cliente)Main.usuario);
	}
	public String toString() {
		return "Mejor restaurante";
	}
}
