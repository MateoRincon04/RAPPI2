package UIMain.Administrador;

import java.util.Optional;

import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Excepciones.AlertaConfirmacion;
import gestorAplicacion.Administracion.Administrador;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AdministradorScene extends Application{
	Scene scene1;
	static BorderPane root;
	GridPane gp;
	static Administrador usuario = Data.buscarAdministrador("Admin");
	public void start(Stage stage) {
		Data.CargarOpciones();
		// Manejo de la barra de menú de la vantana
		MenuBar barraMenu = new MenuBar();
		
		// Definición de menú
		Menu menu = new Menu("Archivo");
		Menu menu1 = new Menu("Procesos y consultas");
		Menu menu2= new Menu("Ayuda");
		barraMenu.getMenus().addAll(menu,menu1,menu2);
		
		//se adiciona los elementos de archivo
		MenuItem mi1 = new MenuItem("Usuario");
		MenuItem mi2 = new MenuItem("Salir");
		SeparatorMenuItem separator = new SeparatorMenuItem();
		menu.getItems().addAll(mi1,separator,mi2);
		
		//se adiciona los elementos de Procesos y consultas
		for (int i = 22; i < Data.getOpciones().size()-1; i++) {
			MenuItem mi = new MenuItem(Data.getOpciones().get(i).toString());
			mi.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					
				}
			});
			menu1.getItems().add(mi);
			menu1.getItems().add(new SeparatorMenuItem());
		}
		//se adiciona los elementos de ayuda
		MenuItem mi3 = new MenuItem("Acerca de");
		menu2.getItems().add(mi3);
		
		//se adicion la barra de menu al pane1
		root = new BorderPane();
		root.setBorder(new Border(new BorderStroke(Color.GREY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		root.setTop(barraMenu);
		//creación de la Escena
		scene1 = new Scene(root,1200,600);
		
		// programa para Archivo SALIR
		mi2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Alert conf = new Alert(AlertType.CONFIRMATION);
				conf.setTitle("Confirmacion de salida");
				conf.setContentText("¿Seguro que desea salir?");
				Optional<ButtonType> result = conf.showAndWait();
				if (result.get() == ButtonType.OK) {
					//cambia a la escena de bienvenida
					stage.setScene(scene1);
				} 
			}
		});
		
		//programa para Ayuda Acerca de
		mi3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				String[] criterios = {"Nombre","Nombre","Nombre","Nombre"};
				String[] valores = {"Mateo Rincon","Paula Andrea Taborda", "Guillermo Toloza","Santiago Tamayo"};
				boolean[] habilitado = {false,false,false,false};
				FieldPanel fp = new FieldPanel("  CRITERIO  ",criterios,"  VALOR  ",valores,habilitado);
				GridPane bonito = new GridPane();
				bonito.setVgap(10);
				bonito.setPadding(new Insets(50,300,10,370));
				Label desc = new Label("Autores ");
				desc.setFont(new Font("Arial",15));
				desc.setBorder(new Border(new BorderStroke(Color.GREY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
				desc.setAlignment(Pos.CENTER);
				desc.setTextFill(Color.BLACK);
				desc.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
				bonito.add(desc, 0, 0);
				bonito.add(fp, 0, 1);
				root.setCenter(bonito);
			}
		});
		
		//programa para Archivo USUARIO
		mi1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				String[] criterios = {"Nombre","UserName","Clave","Telefono","Comuna","Salario"};
				String[] valores = {usuario.getNombre(),usuario.getUserName(), usuario.getClave(),String.valueOf(usuario.getTelefono()),String.valueOf(usuario.getComuna()),String.valueOf(usuario.getSalario())};
				boolean[] habilitado = {true,false,false,true,true,false};
				FieldPanel fp = new FieldPanel("CRITERIO",criterios,"VALOR",valores,habilitado);
				GridPane bonito = new GridPane();
				bonito.setVgap(10);
				bonito.setPadding(new Insets(50,300,10,370));
				Label desc = new Label("Datos del usuario ");
				desc.setFont(new Font("Arial",15));
				desc.setBorder(new Border(new BorderStroke(Color.GREY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
				desc.setAlignment(Pos.CENTER);
				desc.setTextFill(Color.BLACK);
				desc.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
				bonito.add(desc, 0, 0);
				bonito.add(fp, 0, 1);
				root.setCenter(bonito);
			}
		});
		
		// Crear Administrador
				menu1.getItems().get(0).setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						try {
							Data.getOpciones().get(22).ejecutar();
						} catch (AlertaConfirmacion al) {
							Alert ala = new Alert(AlertType.ERROR);
							ala.setContentText(al.getMessage());
						}
						
					}
				});
		
		//Display scene 1 at first
		 stage.setScene(scene1);
		 stage.setTitle("Usuario: " + usuario.getNombre());
		 stage.show(); 
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
