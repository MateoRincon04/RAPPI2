package UIMain.Administrador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

import BaseDatos.Data;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import UIMain.Excepciones.ErrorCancelar;
import UIMain.Excepciones.ErrorNoExiste;
import gestorAplicacion.Administracion.Administrador;
import gestorAplicacion.Interaccion.Cliente;
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
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class QuitarFuncionalidades extends OpcionDeMenu {
	TextField valor,valor1;
	GridPane fp;
	ComboBox cbx1,cbx2;
	Administrador admin;
	public void ejecutar() {
		Data.llenarDataBases();
		admin = AdministradorScene.usuario;
		GridPane bonito = new GridPane();
		Label descripcion = new Label("Podras quitarle funcionalidades al usuario que desees");
		bonito.setVgap(20);
		bonito.setPadding(new Insets(100,10,10,10));
		Label desc = new Label("Quitar Funcionalidades de alguien");
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
		String tipo[]= {"Cliente","Tendero","Restaurante"};
		cbx1 = new ComboBox(FXCollections.observableArrayList(tipo)) ;
		cbx1.setPromptText("Tipos de Usuarios");
		fp.add(cbx1, 0, 1);
		valor = new TextField("");
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
			else if(cbx1.getValue().equals("Cliente")) {
				if(Data.buscarCliente(valor.getText())==null) {
					throw new ErrorNoExiste("Cliente",valor.getText());
				}else {
					Cliente c = Data.buscarCliente(valor.getText());
					ArrayList<String> op = new ArrayList<String>();
					c.opciones.sort(Comparator.naturalOrder());
					for (int i = 0; i < c.opciones.size(); i++) {
						OpcionDeMenu aux = Data.getOpciones().get(c.opciones.get(i));
						op.add(aux.toString());
					}
					cbx2 = new ComboBox(FXCollections.observableArrayList(op));
					cbx2.setPromptText("Funcionalidades");
					fp.add(cbx2, 0, 2);
					valor1 = new TextField("");
					fp.add(valor1, 1, 2);
					cbx2.valueProperty().addListener(new ChangeListener<String>() {
						public void changed(ObservableValue ov, String t, String t1) {
							valor1.setText(t1);
						}
					});
				}
			}
			else if(cbx1.getValue().equals("Tendero")) {
				if(Data.buscarTendero(valor.getText())==null) {
					throw new ErrorNoExiste("Tendero",valor.getText());
				}else {
					Tendero c = Data.buscarTendero(valor.getText());
					ArrayList<String> op = new ArrayList<String>();
					c.opciones.sort(Comparator.naturalOrder());
					for (int i = 0; i < c.opciones.size(); i++) {
						OpcionDeMenu aux = Data.getOpciones().get(c.opciones.get(i));
						op.add(aux.toString());
					}
					cbx2 = new ComboBox(FXCollections.observableArrayList(op));
					cbx2.setPromptText("Funcionalidades");
					fp.add(cbx2, 0, 2);
					valor1 = new TextField("");
					fp.add(valor1, 1, 2);
					cbx2.valueProperty().addListener(new ChangeListener<String>() {
						public void changed(ObservableValue ov, String t, String t1) {
							valor1.setText(t1);
						}
					});
				}
			}else {
				if(Data.buscarRestaurante(valor.getText())==null) {
					throw new ErrorNoExiste("Restaurante",valor.getText());
				}else {
					Restaurante c = Data.buscarRestaurante(valor.getText());
					ArrayList<String> op = new ArrayList<String>();
					c.opciones.sort(Comparator.naturalOrder());
					for (int i = 0; i < c.opciones.size(); i++) {
						OpcionDeMenu aux = Data.getOpciones().get(c.opciones.get(i));
						op.add(aux.toString());
					}
					cbx2 = new ComboBox(FXCollections.observableArrayList(op));
					cbx2.setPromptText("Funcionalidades");
					fp.add(cbx2, 0, 2);
					valor1 = new TextField("");
					fp.add(valor1, 1, 2);
					cbx2.valueProperty().addListener(new ChangeListener<String>() {
						public void changed(ObservableValue ov, String t, String t1) {
							valor1.setText(t1);
						}
					});
				}
			}
		} catch (ErrorCancelar e) {
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText(e.getMessage());
			a.show();
		}catch(ErrorNoExiste e1) {
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText(e1.getMessage());
			a.show();
			this.Cancelar();
		}
		
	}
	public void AceptarS(){
		try {
			if(valor1.getText().equals("")) {
				throw new ErrorCancelar();
			}else {
				Alert a = new Alert(AlertType.CONFIRMATION);
				a.setContentText("seguro que quiere eliminarle a "+valor.getText() + " la funcionalidad "+ valor1.getText()+" ?");
				Optional<ButtonType> result = a.showAndWait();
				if(result.get()==ButtonType.OK) {
					admin.quitarFuncionalidad(valor.getText(), valor1.getText(),(String)cbx1.getValue() );
					Alert a5 = new Alert(AlertType.INFORMATION);
					a5.setContentText(admin.getNombre()+" has quitado exitosamente la funcionalidad "+valor1.getText()+" a "+valor.getText());
					a5.show();
				}
			}
		}catch (ErrorCancelar e) {
			Alert a1 = new Alert(AlertType.WARNING);
			a1.setContentText(e.getMessage());
			a1.show();
		}
		
	}
	
	public void Cancelar() {
		((TextField) fp.getChildren().get(3)).setText("");
	}


	public String toString() {
		return "Quitar Funcionalidades de alguien";
	}
}
