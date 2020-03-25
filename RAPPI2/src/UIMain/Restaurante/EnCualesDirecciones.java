package UIMain.Restaurante;

import UIMain.FieldPanel;
import UIMain.Main;
import UIMain.OpcionDeMenu;
import BaseDatos.Data;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Clase EnCualesDirecciones, su finalidad es la de ser aquella clase que permita la implementacion de opcionDeMenu y ejecute cierta funcionalidad 
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon
 */
public class EnCualesDirecciones extends OpcionDeMenu {
	public void ejecutar() {
		
		String tituloCriterios = "Direcciones: ";
		String[] criterios = new String[Main.usuarioRestaurante.getDireccion().size()];
		for(int cr = 0; cr<criterios.length; cr++) {
			criterios[cr] = "Direccion: ";
		}
		String tituloValores = "Valor: ";
		String[] valores = new String[Main.usuarioRestaurante.getDireccion().size()];
		for(int cr = 0; cr<valores.length; cr++) {
			valores[cr] = Main.usuarioRestaurante.getDireccion().get(cr);
		}
		boolean[] habilitado = new boolean[Main.usuarioRestaurante.getDireccion().size()];
		for(int cr = 0; cr<habilitado.length; cr++) {
			habilitado[cr] = false;
		}

		FieldPanel fp = new FieldPanel(tituloCriterios,criterios,tituloValores,valores,habilitado);
		GridPane bonito = new GridPane();
		Label desc = new Label("Funcionalidad para saber cuales son las direcciones que posee el restaurante: ");
		desc.setAlignment(Pos.CENTER);
		Label nom = new Label(Data.getOpciones().get(14).toString());
		nom.setAlignment(Pos.CENTER);
		nom.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		desc.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		bonito.add(new Label("                                                                                                                        "), 0, 0);
		bonito.add(new Label("                                                                                                                        "), 0, 2);
		bonito.add(new Label("                                                                                                                        "), 0, 1);
		bonito.add(nom, 1, 0);
		bonito.add(desc, 1, 1);
		bonito.add(fp, 1, 2);
		RestauranteEscena.root.setCenter(bonito);
	}
	public String toString() {
		return "¿En cuáles direcciones?";
	}

}
