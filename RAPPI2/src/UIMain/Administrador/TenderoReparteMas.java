package UIMain.Administrador;

import gestorAplicacion.Administracion.Administrador;
import BaseDatos.Data;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Interaccion.Tendero;
import gestorAplicacion.Oferta.Restaurante;

public class TenderoReparteMas extends OpcionDeMenu {
	public void ejecutar() {
		// debo buscar qu� tendero es el que ha repartido m�s pedidos de cierto
		// restaurante en espec�fico.
		System.out.println("De que restaurante desea saber que tendero ha repartido mas pedidos: ");
		Data.imprimirRestaurantes();
		System.out.println("ingrese el nombre del restaurante que va a elegir: ");
		String nombre = Main.user.next();
		Restaurante restaurante = Data.buscarRestaurante(nombre);
		System.out.println("El tendero que m�s pedidos ha entregado al restaurante " + restaurante.getNombre() + " es: ");
		Tendero tendero = restaurante.tenderoQueMasMeEntrega();
		if(tendero != null) {
			System.out.println(tendero.getNombre());
		} else {
			System.out.println("Aun no hay tendero que haya entregado pedidos del restaurante");
		}
		
		MenuDeConsola.lanzarMenu((Administrador) Main.usuario);
	}

	public String toString() {
		return "El tendero que mas reparte";
	}
}