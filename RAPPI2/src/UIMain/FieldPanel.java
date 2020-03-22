package UIMain;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class FieldPanel extends Pane {
	String tituloCriterios;
	public String[] criterios;
	String tituloValores;
	String[] valores;
	TextField[] entradas;
	boolean[] habilitado;
	GridPane root;

	public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, String[] valores,
			boolean[] habilitado) {
		entradas = new TextField[criterios.length];
		this.tituloCriterios = tituloCriterios;
		this.criterios = criterios;
		this.tituloValores = tituloValores;
		this.valores = valores;
		this.habilitado = habilitado;
		root = new GridPane();
		root.setPadding(new Insets(10, 100, 10, 100));
		root.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		root.setHgap(5);
		root.setVgap(5);
		Label tc = new Label(tituloCriterios);
		tc.setTextFill(Color.BLUE);
		tc.setPadding(new Insets(2, 2, 2, 2));
		tc.setBorder(new Border(
				new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		root.add(tc, 0, 0);
		Label tv = new Label(tituloValores);
		tv.setTextFill(Color.BLUE);
		tv.setPadding(new Insets(2, 2, 2, 2));
		tv.setBorder(new Border(
				new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		root.add(tv, 1, 0);
		for (int i = 0; i < criterios.length; i++) {
			root.add(new Label(criterios[i]), 0, i + 1);
			TextField taux = new TextField(valores[i]);
			if (habilitado != null) {
				taux.setEditable(habilitado[i]);
			}
			entradas[i] = taux;
			root.add(taux, 1, i + 1);
		}
		root.setAlignment(Pos.CENTER);
		this.getChildren().add(root);
	}

	public String getValue(String criterio) {
		String aux = null;
		for (int i = 0; i < this.criterios.length; i++) {

			if (this.criterios[i] == criterio) {
				aux = ((TextField) this.root.getChildren().get(this.root.getChildren().indexOf(entradas[i]))).getText();
				
			}
		}
		return aux;
	}

	public void setValue(String criterio) {
		for (int i = 0; i < criterios.length; i++) {
			if (criterios[i] == criterio) {
				((TextField) this.root.getChildren().get(this.root.getChildren().indexOf(entradas[i]))).setText("");
			}
		}
	}
}
