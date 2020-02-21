package UIMain;

import java.util.List;

import Administracion.Administrador;
import Interaccion.Tendero;
import Interaccion.Calificacion;
import Interaccion.Notificacion;
import Administracion.Perfil;

public class CuantosPedidosHeEntregado extends OpcionDeMenu {
	void ejecutar() {
		
		if (Main.usuario.getTipo().equals("tendero")) {
			Tendero usuario = (Tendero) Main.usuario;
			List<Calificacion> calificaciones = usuario.getCalificaciones();
			int contadorCalificaciones=0;
			for (int i = 0; i < calificaciones.size(); i++) {
				contadorCalificaciones++;
			}
			System.out.println("Usted ha entregado: "+contadorCalificaciones+" pedidos.");
		} else {
			
		}
	}
}
