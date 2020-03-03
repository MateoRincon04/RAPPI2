package UIMain;

import Administracion.Administrador;
import BaseDatos.Data;
import Interaccion.Tendero;
import Oferta.Restaurante;

public class TenderoReparteMas implements OpcionDeMenu {
	public void ejecutar() {
		// debo buscar qué tendero es el que ha repartido más pedidos de cierto
		// restaurante en específico.
		System.out.println("Este es el menú de restaurantes. ");
		Administrador administrador = (Administrador) Main.usuario;
		Data.imprimirRestaurantes();
		System.out.println("ingrese el nombre del restaurante que va a elegir: ");
		String nombre = Main.user.next();
		Restaurante restaurante = Data.buscarRestaurante(nombre);
		System.out
				.println("El tendero que más pedidos ha entregado al restaurante " + restaurante.getNombre() + " es: ");
		Tendero tendero = restaurante.tenderoQueMasMeEntrega();
		System.out.println(tendero.getNombre());
		MenuDeConsola.lanzarMenu((Administrador) Main.usuario);
	}

	public String toString() {
		return "El tendero que mas reparte";
	}
}
