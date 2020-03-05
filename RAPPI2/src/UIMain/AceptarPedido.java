package UIMain;

import Interaccion.Tendero;

public class AceptarPedido implements OpcionDeMenu {
	public void ejecutar() {
		Tendero tendero = (Tendero) Main.usuario;
		if (tendero.getNotificaciones() != null) {
			System.out.println("Tiene un pedido nuevo. ¿Desea aceptarlo?");
			System.out.println("Presione (1) para sí, (2) para no");
			int opcion = Main.user.nextInt();
			if (opcion == 1 | opcion == 2) {
				if (opcion == 1) {

					tendero.aceptarPedido();
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
