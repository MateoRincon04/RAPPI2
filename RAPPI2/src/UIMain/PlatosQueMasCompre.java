package UIMain;

import Interaccion.Cliente;
import Administracion.Perfil;

import java.util.ArrayList;
import java.util.List;
import Oferta.Pedido;
import Oferta.Plato;
public class PlatosQueMasCompre extends OpcionDeMenu {

	//aqu� se ejecuta la funcionalidad de los platos que m�s compr� el cliente
	void ejecutar() {
		Cliente usuarioUno = (Cliente)Main.usuario;
		List<Pedido> historial = usuarioUno.getHistorial();
		List<Plato> platosPorPedido = new ArrayList<Plato>();
		List<String> nombreDelPlato = new ArrayList<String>();
		for (int i = 0; i < historial.size(); i++){
			platosPorPedido.add( historial.get(i).getPlato() );
		}
		for (int i = 0; i < platosPorPedido.size(); i++){
			nombreDelPlato.add((platosPorPedido.get(i)).getNombre());
		}
		//Tengo que comparar cada nombre escrito en la lista de los diferentes que hay
		// y imprimir aquel que mas se repita.
			
		}
	

		
	}


