package UIMain;

import Interaccion.Cliente;

/**
 * Clase PlatosQueMasCompre, su finalidad es la de ser aquella clase que permita la
 * implementacion de opcionDeMenu y ejecute cierta funcionalidad
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon
 */
public class PlatosQueMasCompre implements OpcionDeMenu {

	public void ejecutar() {
		Cliente usuarioUno = (Cliente) Main.usuario;
		String nomPlato = usuarioUno.platoMasComprado();
		System.out.println("El plato más comprado es: " + nomPlato);
	}

	public String toString() {
		return "Platos que más compré";
	}
}
