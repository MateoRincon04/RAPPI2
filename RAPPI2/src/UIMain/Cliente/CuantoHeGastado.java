package UIMain.Cliente;

import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import UIMain.Restaurante.RestauranteEscena;
import gestorAplicacion.Interaccion.Cliente;
import gestorAplicacion.Oferta.Restaurante;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Clase CuantoHeGastado, su finalidad es la de ser aquella clase que permita la
 * implementacion de opcionDeMenu y ejecute cierta funcionalidad
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon
 */
public class CuantoHeGastado extends OpcionDeMenu {
	public void ejecutar() {
		Cliente cliente = Data.buscarCliente("guille");
		String tituloCriterios = "Cuanto dinero he gastado: ";
		String[] criterios = new String[2];
		for (int cr = 0; cr < criterios.length; cr++) {
			if (cr == 0) {
				criterios[cr] = "Usted ha gastado: ";
			} else if (cr == 1) {
				criterios[cr] = "Actualmente usted tiene: ";
			}
			String tituloValores = "Valor: ";
			String[] valores = new String[2];
			for (int kr = 0; kr < valores.length; kr++) {
				if (kr == 0) {
					double valorGastado = cliente.cuantoHeGastado();
					valores[0] = String.valueOf(valorGastado);
				} else if (kr == 1) {
					valores[1] = cliente.getSaldo() + " pesos.";
				}
				boolean[] habilitado = new boolean[2];
				for (int pr = 0; pr < habilitado.length; pr++) {
					habilitado[pr] = false;
				}

				FieldPanel fp = new FieldPanel(tituloCriterios, criterios, tituloValores, valores, habilitado);
				GridPane bonito = new GridPane();
				Label desc = new Label("Funcionalidad para saber cuánto dinero ha gastado el cliente: ");
				desc.setAlignment(Pos.CENTER);
				Label nom = new Label(Data.getOpciones().get(6).toString());
				nom.setAlignment(Pos.CENTER);
				nom.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
				desc.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
				bonito.add(new Label(
						"                                                                                                                        "),
						0, 0);
				bonito.add(new Label(
						"                                                                                                                        "),
						0, 2);
				bonito.add(new Label(
						"                                                                                                                        "),
						0, 1);
				bonito.add(nom, 1, 0);
				bonito.add(desc, 1, 1);
				bonito.add(fp, 1, 2);
				EscenaCliente.root.setCenter(bonito);
			}

		}

		/*
		 * double valorGastado = cliente.cuantoHeGastado();
		 * System.out.println("Usted ha gastado: " + valorGastado);
		 * System.out.println("Actualmente usted tiene: " + cliente.getSaldo() +
		 * " pesos."); MenuDeConsola.lanzarMenu((Cliente) Main.usuario);
		 */
	}

	public String toString() {
		return "¿Cuánto he gastado?";
	}
}