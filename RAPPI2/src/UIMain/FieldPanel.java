package UIMain;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class FieldPanel extends Pane{
	String tituloCriterios;
	String[] criterios;
	String tituloValores;
	String[] valores;
	boolean[] habilitado;
	GridPane root;
	public FieldPanel(String tituloCriterios,String[] criterios, String tituloValores, String[] valores,boolean[] habilitado) {
		root = new GridPane();
		root.setHgap(5);
		root.setVgap(5);
		root.setAlignment(Pos.CENTER);
		Label tc = new Label(tituloCriterios);
		root.add(tc, 0, 0);
		Label tv =new Label(tituloValores);
		root.add(tv, 1, 0);
		for(int i = 0; i<criterios.length; i++) {
			root.add(new Label(criterios[i]), 0, i+1);
			TextField taux =new TextField(valores[i]);
			if(habilitado!=null) {
				taux.setEditable(habilitado[i]);
			}
			root.add(taux, 1, i+1);
		}
		root.setAlignment(Pos.CENTER);
		this.getChildren().add(root);
	}
}
