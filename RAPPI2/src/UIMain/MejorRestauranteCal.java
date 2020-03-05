package UIMain;

import BaseDatos.Data;
import gestorAplicacion.Interaccion.Cliente;
import java.util.ArrayList;
import gestorAplicacion.Oferta.Restaurante;

/**
 * Clase MejorRestauranteCal, su finalidad es la de ser aquella clase que permita la implementacion de opcionDeMenu y ejecute cierta funcionalidad 
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon
 */
public class MejorRestauranteCal implements OpcionDeMenu {

	public void ejecutar() {
		ArrayList<Restaurante> lista = Data.OrganizarRestaurantesPorCalificacion();
		System.out.println("Los restaurantes mejor calificados, del mejor al peor son: ");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(i + " . " + lista.get(i).getNombre());
		}
		MenuDeConsola.lanzarMenu((Cliente)Main.usuario);
	}
	public String toString() {
		return "Mejor restaurante";
	}
}
