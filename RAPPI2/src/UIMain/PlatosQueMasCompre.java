package UIMain;

import Interaccion.Cliente;
import Administracion.Perfil;

import java.util.ArrayList;
import java.util.List;
import Oferta.Pedido;
import Oferta.Plato;

public class PlatosQueMasCompre extends OpcionDeMenu {
	/**
	 * Clase OpcionDeMenu Aqui se crea la funcionalidad del cliente de saber cual es
	 * el plato que mas ha comprado
	 * 
	 * Estructuras revelantes --------------------------------------------------
	 * 
	 * @author: Guillermo Toloza - Santiago Tamayo
	 * @version:
	 */
	void ejecutar() {
		Cliente usuarioUno = (Cliente) Main.usuario;
		List<Pedido> historial = usuarioUno.getHistorial();
		List<Plato> platosPorPedido = new ArrayList<Plato>();
		List<String> nombreDelPlato = new ArrayList<String>();
		int contador1 = 0;
		String aux = "";
		for (int i = 0; i < historial.size(); i++) {
			int contador = 0;
			for (int u = i; u < historial.size() - 1; u++) {
				if ((historial.get(i).getPlato().getNombre()).equals(historial.get(u).getPlato().getNombre())) {
					contador++;
				}
			}
			if (contador > contador1) {
				contador1 = contador;
				aux = historial.get(i).getPlato().getNombre();
			}
		}
		System.out.println("El plato más pedido es: " + aux + "y se ha pedido: " + contador1 + " veces.");
	}

}
