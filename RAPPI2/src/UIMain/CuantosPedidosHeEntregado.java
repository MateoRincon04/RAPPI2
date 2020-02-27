package UIMain;

import java.util.List;

import Administracion.Administrador;
import Interaccion.Tendero;
import Interaccion.Calificacion;
import Interaccion.Notificacion;
import Administracion.Perfil;

public class CuantosPedidosHeEntregado implements OpcionDeMenu {
	public void ejecutar() {
		
		if (Main.usuario.getTipo().equals("tendero")) {
			Tendero usuario = (Tendero) Main.usuario;
			int aux = usuario.cantidadDePedidosEntregados();
			System.out.println("Usted ha entregado: "+aux+" pedidos.");
		} else {
			
		}
	}
}
