package UIMain;

import Administracion.Administrador;
import Interaccion.Tendero;
import Interaccion.Notificacion;
import Administracion.Perfil;

public class CuantosPedidosHeEntregado extends OpcionDeMenu {
	void ejecutar() {
		Perfil usuario = (Tendero)Main.usuario;
		if (Main.usuario.getTipo().equals("tendero")) {
			
			
		}else {
			
		}
	}
}
