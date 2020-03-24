package UIMain.Administrador;

import gestorAplicacion.Administracion.Administrador;
import BaseDatos.Data;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import UIMain.Excepciones.ErrorCancelar;
import UIMain.Excepciones.ErrorNoExiste;
import gestorAplicacion.Interaccion.Tendero;
import gestorAplicacion.Oferta.Restaurante;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TenderoReparteMas extends OpcionDeMenu {
	TextField valor;
	GridPane fp;
	public void ejecutar() {
		GridPane bonito = new GridPane();
		Label descripcion = new Label("Podras observar al tendero que mas pedidos ha entregado");
		bonito.setVgap(20);
		bonito.setPadding(new Insets(100,10,10,10));
		Label desc = new Label("El tendero que mas reparte");
		//creacion pane 
		fp = new GridPane();
		fp.setPadding(new Insets(10,100,10,100));
		fp.setBorder(new Border(new BorderStroke(Color.GREY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		fp.setHgap(40);
		fp.setVgap(5);
		Label tc = new Label("Lista de restaurantes");
		tc.setTextFill(Color.BLUE);
		tc.setPadding(new Insets(2,2,2,2));
		tc.setBorder(new Border(new BorderStroke(Color.BLUE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		tc.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		tc.setAlignment(Pos.CENTER);
		fp.add(tc, 0, 0);
		Label tv = new Label("Restaurante seleccionado");
		tv.setTextFill(Color.BLUE);
		tv.setPadding(new Insets(2,2,2,2));
		tv.setBorder(new Border(new BorderStroke(Color.BLUE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		tv.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		tv.setAlignment(Pos.CENTER);
		fp.add(tv, 1, 0);
		ComboBox cbx1 = new ComboBox(FXCollections.observableArrayList(Data.imprimirRestaurantes()));
		cbx1.setPromptText("Lista Restaurantes");
		fp.add(cbx1, 0, 1);
		valor = new TextField();
		fp.add(valor, 1, 1);
		cbx1.valueProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue ov, String t, String t1) {
				valor.setText(t1);
			}
		});
		
		desc.setFont(new Font("Arial",15));
		desc.setBorder(new Border(new BorderStroke(Color.GREY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		desc.setAlignment(Pos.CENTER);
		desc.setTextFill(Color.BLACK);
		desc.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		descripcion.setBorder(new Border(new BorderStroke(Color.GREY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		descripcion.setAlignment(Pos.CENTER);
		descripcion.setTextFill(Color.BLACK);
		descripcion.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		bonito.add(desc, 0, 0);
		bonito.add(descripcion, 0, 1);
		bonito.add(fp, 0, 2);
		bonito.setAlignment(Pos.TOP_CENTER);
		AdministradorScene.root.setCenter(bonito);
	}
	
	public void Aceptar() {
		Alert al = new Alert(AlertType.NONE);
		try {
			Restaurante rAux = Data.buscarRestaurante(valor.getText());
			if (rAux.tenderoQueMasMeEntrega()==null) {
			throw new ErrorNoExiste("Tendero",rAux.tenderoQueMasMeEntrega().getUserName());
		} else {
				al.setAlertType(AlertType.INFORMATION);
				al.setContentText("el tendero que mas pedidos ha entregado en "+ rAux.getNombre()+" es " + rAux.tenderoQueMasMeEntrega().getNombre());
				al.show();
			}
			this.Cancelar();
		} catch (ErrorNoExiste e) {
			al.setAlertType(AlertType.WARNING);
			al.setContentText(e.getMessage());
			al.show();
			this.Cancelar();
		}
		
	}
	
	public void Cancelar() {
		((TextField) fp.getChildren().get(3)).setText("");
	}

	public String toString() {
		return "El tendero que mas reparte";
	}
}
