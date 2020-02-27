package UIMain;

import Administracion.Administrador;
import Oferta.*;

import Interaccion.Cliente;

public class CuantoHeGastado implements OpcionDeMenu {
	public void ejecutar() {
		Cliente cliente = (Cliente) Main.usuario;
		double valorGastado = cliente.cuantoHeGastado();
		System.out.println("Usted ha gastado: " + valorGastado);
		System.out.println("Actualmente usted tiene: " + cliente.getSaldo() + " pesos.");

	}
}
