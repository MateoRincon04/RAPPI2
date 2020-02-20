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
	 * @author: Guillermo Toloza
	 * @version:
	 */
	void ejecutar() {
		Cliente usuarioUno = (Cliente) Main.usuario;
		List<Pedido> historial = usuarioUno.getHistorial();
		List<Plato> platosPorPedido = new ArrayList<Plato>();
		List<String> nombreDelPlato = new ArrayList<String>();
		for (int i = 0; i < historial.size(); i++) {
			platosPorPedido.add(historial.get(i).getPlato());
		}
		for (int i = 0; i < platosPorPedido.size(); i++) {
			nombreDelPlato.add((platosPorPedido.get(i)).getNombre());
		}
		for (int i = 0; i < nombreDelPlato.size(); i++) {
			if () {
				
			}
		}
		// Tengo que comparar cada nombre escrito en la lista de los diferentes que hay
		// y imprimir aquel que mas se repita.

	}

}
