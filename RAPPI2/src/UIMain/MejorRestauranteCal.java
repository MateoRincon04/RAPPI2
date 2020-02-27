package UIMain;

import Interaccion.Cliente;
import Administracion.Perfil;
import BaseDatos.Data;
import java.util.ArrayList;
import java.util.List;

import Oferta.Restaurante;

public class MejorRestauranteCal implements OpcionDeMenu {
	/**
	 * Clase OpcionDeMenu Aqui se crea la funcionalidad del cliente de saber cual es
	 * el plato que mas ha comprado
	 * 
	 * Estructuras revelantes --------------------------------------------------
	 * 
	 * @author: Guillermo Toloza - Santiago Tamayo
	 * @version:
	 */
	public void ejecutar() {
		Cliente usuarioUno = (Cliente) Main.usuario;
		ArrayList<Restaurante> lista = Data.OrganizarRestaurantesPorCalificacion();
		System.out.println("Los restaurantes mejor calificados, del mejor al peor son: ");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(i + " . " + lista.get(i).getNombre());
		}
	}
	public String toString() {
		return "Mejor restaurante";
	}
}
