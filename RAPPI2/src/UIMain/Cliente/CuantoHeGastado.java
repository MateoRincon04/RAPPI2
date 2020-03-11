package UIMain.Cliente;

import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Interaccion.Cliente;

/**
 * Clase CuantoHeGastado, su finalidad es la de ser aquella clase que permita la
 * implementacion de opcionDeMenu y ejecute cierta funcionalidad
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon
 */
public class CuantoHeGastado extends OpcionDeMenu {
	public void ejecutar() {
		Cliente cliente = (Cliente) Main.usuario;
		double valorGastado = cliente.cuantoHeGastado();
		System.out.println("Usted ha gastado: " + valorGastado);
		System.out.println("Actualmente usted tiene: " + cliente.getSaldo() + " pesos.");
		MenuDeConsola.lanzarMenu((Cliente) Main.usuario);
	}

	public String toString() {
		return "¿Cuánto he gastado?";
	}
}