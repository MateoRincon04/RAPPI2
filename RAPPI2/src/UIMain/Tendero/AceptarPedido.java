package UIMain.Tendero;

import BaseDatos.Data;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Interaccion.Notificacion;
import gestorAplicacion.Interaccion.Tendero;
import gestorAplicacion.Oferta.Pedido;

public class AceptarPedido extends OpcionDeMenu {
	public void ejecutar() {
		Tendero tendero = (Tendero) Main.usuario;
		if (tendero.getNotificaciones().size() > 0) {
			System.out.println("Tiene un pedido nuevo. ¿Desea aceptarlo?");
			System.out.println("Presione (1) para sí, (2) para no");
			int opcion = Main.user.nextInt();
			if (opcion == 1 | opcion == 2) {
				if (opcion == 1) {
					boolean valor = tendero.aceptarPedido();
					if (valor) {
						Notificacion notificacion = Data.buscarNotificacion(tendero.getNotificaciones().get(tendero.getNotificaciones().size()-1));
						Pedido pedido = Data.buscarPedido(notificacion.getPedido());
						pedido.setTendero(tendero);
						Data.actualizarDataBasePedido(pedido);
						System.out.println("Usted tiene a su cargo el pedido: " + pedido.getPlato());

					}
				} else {
					System.out.println("No ha aceptado el pedido. ");
				}
			} else {
				System.out.println("Ingrese un valor válido: ");
				ejecutar();
			}
		} else {
			System.out.println("No se han realizado pedidos. ");
		}
		MenuDeConsola.lanzarMenu((Tendero) Main.usuario);
	}

	public String toString() {
		return "Aceptar pedido";
	}
}
