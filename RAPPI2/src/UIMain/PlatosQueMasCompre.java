package UIMain;

import Interaccion.Cliente;
import Administracion.Perfil;

import java.util.ArrayList;
import java.util.List;
import Oferta.Pedido;
import Oferta.Plato;

public class PlatosQueMasCompre implements OpcionDeMenu {
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
		String nomPlato = usuarioUno.platoMasComprado();
		System.out.println("El plato más comprado es: " + nomPlato);
	}
	public String ToString() {
		return "Platos que más compré";
	}
}
