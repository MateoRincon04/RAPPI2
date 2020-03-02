package UIMain;

import Interaccion.Tendero;

/**
 * Clase CuantosPedidoHeEntrgado, su finalidad es la de ser aquella clase que permita la implementacion de opcionDeMenu y ejecute cierta funcionalidad 
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon
 */
public class CuantosPedidosHeEntregado implements OpcionDeMenu {
	public void ejecutar() {

		Tendero usuario = (Tendero) Main.usuario;
		int aux = usuario.cantidadDePedidosEntregados();
		System.out.println("Usted ha entregado: " + aux + " pedidos.");
	}
	public String toString() {
		return "�Cu�ntos pedidos he entregado?";
	}
}
