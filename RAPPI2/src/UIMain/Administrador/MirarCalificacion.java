package UIMain.Administrador;

import java.util.ArrayList;

import BaseDatos.Data;
import UIMain.OpcionDeMenu;
import UIMain.Excepciones.ErrorCancelar;
import UIMain.Excepciones.ErrorNoExiste;
import gestorAplicacion.Administracion.Administrador;
import gestorAplicacion.Interaccion.Tendero;
import gestorAplicacion.Oferta.Restaurante;
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

public class MirarCalificacion extends OpcionDeMenu  {
	TextField valor,valor1;
	GridPane fp;
	ComboBox cbx1,cbx2;
	Administrador admin;
	public void ejecutar() {
		admin = AdministradorScene.usuario;
		GridPane bonito = new GridPane();
		Label descripcion = new Label("Podras mirar la calificacion de un tendero o restaurante");
		bonito.setVgap(20);
		bonito.setPadding(new Insets(100,10,10,10));
		Label desc = new Label("Mirar calificacion de alguien");
		//creacion pane 
		fp = new GridPane();
		fp.setPadding(new Insets(10,100,10,100));
		fp.setBorder(new Border(new BorderStroke(Color.GREY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		fp.setHgap(40);
		fp.setVgap(5);
		Label tc = new Label("Tipo de Usuario");
		tc.setTextFill(Color.BLUE);
		tc.setPadding(new Insets(2,2,2,2));
		tc.setBorder(new Border(new BorderStroke(Color.BLUE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		tc.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		tc.setAlignment(Pos.CENTER);
		fp.add(tc, 0, 0);
		Label tv = new Label("Nombre Usuario");
		tv.setTextFill(Color.BLUE);
		tv.setPadding(new Insets(2,2,2,2));
		tv.setBorder(new Border(new BorderStroke(Color.BLUE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		tv.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		tv.setAlignment(Pos.CENTER);
		fp.add(tv, 1, 0);
		String tipo[]= {"Tendero","Restaurante"};
		cbx1 = new ComboBox(FXCollections.observableArrayList(tipo)) ;
		cbx1.setPromptText("Tipos de Usuarios");
		fp.add(cbx1, 0, 1);
		valor = new TextField();
		fp.add(valor, 1, 1);

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
		try {
			if(valor.getText().equals("")) {
				this.ejecutar();
				throw new ErrorCancelar();
			}
			else if(cbx1.getValue().equals("Tendero")) {
				if(Data.buscarTendero(valor.getText())==null) {
					throw new ErrorNoExiste("Tendero",valor.getText());
				}else {
					Tendero t= Data.buscarTendero(valor.getText());
					Alert a = new Alert(AlertType.WARNING);
					a.setContentText("la calificacion promediada de "+ t.getNombre()+"es "+ t.getCalificacionPromediada());
					a.show();
				}
			}else {
				if(Data.buscarRestaurante(valor.getText())==null) {
					throw new ErrorNoExiste("Restaurante",valor.getText());
				}else {
					Restaurante c = Data.buscarRestaurante(valor.getText());
					Alert a = new Alert(AlertType.WARNING);
					a.setContentText("la calificacion promediada de "+ c.getNombre()+"es "+ c.getCalificacionPromediada());
					a.show();
				}
			}
		} catch (ErrorCancelar e) {
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText(e.getMessage());
			a.show();
			this.Cancelar();
		}catch(ErrorNoExiste e1) {
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText(e1.getMessage());
			a.show();
			this.Cancelar();
		}
		
	}public void Cancelar() {
		((TextField) fp.getChildren().get(1)).setText("");
	}
}
