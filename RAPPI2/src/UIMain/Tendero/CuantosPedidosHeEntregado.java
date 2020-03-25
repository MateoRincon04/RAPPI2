package UIMain.Tendero;

import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Main;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Interaccion.Tendero;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Clase CuantosPedidoHeEntrgado, su finalidad es la de ser aquella clase que permita la implementacion de opcionDeMenu y ejecute cierta funcionalidad 
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon
 */
public class CuantosPedidosHeEntregado extends OpcionDeMenu {
	
	public void ejecutar() {
		String tituloCriterios = "Pedidos: ";
		String[] criterios = new String[] {"Cantidad de pedidos: "};
		String tituloValores = "Valor: ";
		String[] valores = new String[] {String.valueOf(((Tendero)Main.usuario).getEntregados())};
		boolean[] habilitado = new boolean[] {false};
		FieldPanel fp = new FieldPanel(tituloCriterios,criterios,tituloValores,valores,habilitado);
		
		GridPane bonito = new GridPane();
		Label desc = new Label("Funcionalidad para saber cuantos pedidos he realizado a lo largo de mi trabajo: ");
		desc.setAlignment(Pos.CENTER);
		Label nom = new Label(Data.getOpciones().get(11).toString());
		nom.setAlignment(Pos.CENTER);
		nom.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		desc.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		bonito.add(new Label("                                                                                                                        "), 0, 0);
		bonito.add(new Label("                                                                                                                        "), 0, 2);
		bonito.add(new Label("                                                                                                                        "), 0, 1);
		bonito.add(nom, 1, 0);
		bonito.add(desc, 1, 1);
		bonito.add(fp, 1, 2);
		TenderoEscena.root.setCenter(bonito);
	}
	
	public String toString() {
		return "¿Cuántos pedidos he entregado?";
	}
}
