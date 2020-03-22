package UIMain.Administrador;

import BaseDatos.Data;
import UIMain.FieldPanel;
import gestorAplicacion.Administracion.Administrador;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdministradorScene extends Application{
	Scene scene1;
	GridPane gp;
	Administrador usuario = Data.buscarAdministrador("Admin");
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
		BorderPane root = new BorderPane();
		root.setTop(barraMenu);
		//creación de la Escena
		scene1 = new Scene(root,1200,600);
		
		
		//programa para Ayuda Acerca de
		mi3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				String[] criterios = {"Nombre","Nombre","Nombre","Nombre"};
				String[] valores = {"Mateo Rincon","Paula Andrea Taborda", "Guillermo Toloza","Santiago Tamayo"};
				boolean[] habilitado = {false,false,false,false};
				FieldPanel fp = new FieldPanel("CRITERIO",criterios,"VALOR",valores,habilitado);
				root.setCenter(fp);
			}
		});
		
		//programa para Archivo USUARIO
		mi1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				String[] criterios = {"Nombre","UserName","Clave","Telefono","Comuna","Salario"};
				String[] valores = {usuario.getNombre(),usuario.getUserName(), usuario.getClave(),String.valueOf(usuario.getTelefono()),String.valueOf(usuario.getComuna()),String.valueOf(usuario.getSalario())};
				boolean[] habilitado = {true,false,false,true,true,false};
				FieldPanel fp = new FieldPanel("CRITERIO",criterios,"VALOR",valores,habilitado);
				root.setCenter(fp);
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
