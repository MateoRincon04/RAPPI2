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

public class FieldPanel extends Pane{
	String tituloCriterios;
	String[] criterios;
	String tituloValores;
	String[] valores;
	boolean[] habilitado;
	GridPane root;
	public FieldPanel(String tituloCriterios,String[] criterios, String tituloValores, String[] valores,boolean[] habilitado) {
		root = new GridPane();
		root.setPadding(new Insets(10,100,10,100));
		root.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		root.setHgap(5);
		root.setVgap(5);
		Label tc = new Label(tituloCriterios);
		tc.setPadding(new Insets(2,2,2,2));
		tc.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		root.add(tc, 0, 0);
		Label tv =new Label(tituloValores);
		tv.setPadding(new Insets(2,2,2,2));
		tv.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		root.add(tv, 1, 0);
		for(int i = 0; i<criterios.length; i++) {
			root.add(new Label(criterios[i]), 0, i+1);
			TextField taux =new TextField(valores[i]);
			if(habilitado!=null) {
				taux.setEditable(habilitado[i]);
			}
			root.add(taux, 1, i+1);
		}
		this.getChildren().add(root);
		//this.setAlignment(Pos.CENTER);
	}
}
