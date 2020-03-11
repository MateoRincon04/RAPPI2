package UIMain.Tendero;

import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Interaccion.Tendero;

/**
 * Clase CuantosPedidoHeEntrgado, su finalidad es la de ser aquella clase que permita la implementacion de opcionDeMenu y ejecute cierta funcionalidad 
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon
 */
public class CuantosPedidosHeEntregado extends OpcionDeMenu {
	public void ejecutar() {

		Tendero usuario = (Tendero) Main.usuario;
		int aux = usuario.cantidadDePedidosEntregados();
		System.out.println("Usted ha entregado: " + aux + " pedidos.");
		MenuDeConsola.lanzarMenu((Tendero) Main.usuario);
	}
	public String toString() {
		return "¿Cuántos pedidos he entregado?";
	}
}
