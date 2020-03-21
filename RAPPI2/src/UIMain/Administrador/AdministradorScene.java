package UIMain.Administrador;

import BaseDatos.Data;
import gestorAplicacion.Administracion.Administrador;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
			menu1.getItems().add(new MenuItem(Data.getOpciones().get(i).toString()));
			menu1.getItems().add(new SeparatorMenuItem());
		}
		//se adiciona los elementos de ayuda
		MenuItem mi3 = new MenuItem("Acerca de");
		menu2.getItems().add(mi3);
		
		//se adicion la barra de menu al pane1
		BorderPane root = new BorderPane();
		root.setTop(barraMenu);
		//creación de la Escena
		scene1 = new Scene(root,600,600);
		
		
		//programa para Archivo USUARIO
		mi1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				//se crea la ventana con la informacion basica del Administrador
				gp = new GridPane();
				//crear los nodos del grid
				Label lb1 = new Label("Nombre");
				TextField t1 = new TextField(usuario.getNombre());
				t1.setEditable(false);
				Label lb2 = new Label("UserName");
				TextField t2 = new TextField(usuario.getUserName());
				t2.setEditable(false);
				Label lb3 = new Label("Clave");
				String claveAux ="";
				for (int i =0;i<usuario.getClave().length();i++) {
					claveAux =claveAux+"*";
				}
				TextField t3 = new TextField(claveAux);
				t3.setEditable(false);
				t3.setOnMouseEntered(new EventHandler<MouseEvent>(){
					public void handle(MouseEvent mouseEvent) {
						t3.setText(usuario.getClave());
					}
				});
				t3.setOnMouseExited(new EventHandler<MouseEvent>(){
					public void handle(MouseEvent mouseEvent) {
						String claveAux ="";
						for (int i =0;i<usuario.getClave().length();i++) {
							claveAux =claveAux+"*";
						}
						t3.setText(claveAux);
					}
				});
				Label lb4 = new Label("Telefono");
				TextField t4 = new TextField(String.valueOf(usuario.getTelefono()));
				t4.setEditable(false);
				Label lb5 = new Label("Comuna");
				TextField t5 = new TextField(String.valueOf(usuario.getComuna()));
				t5.setEditable(false);
				Label lb6 = new Label("Salario");
				TextField t6 = new TextField(String.valueOf(usuario.getSalario()));
				t6.setEditable(false);
				//especificaciones del grip
				gp.setHgap(5);
				gp.setVgap(5);
				gp.setAlignment(Pos.CENTER);
				//agregar los nodos al grip
				gp.add(lb1,0,0);
				gp.add(t1,1,0);
				gp.add(lb2,0,1);
				gp.add(t2,1,1);
				gp.add(lb3,0,2);
				gp.add(t3,1,2);
				gp.add(lb4,0,3);
				gp.add(t4,1,3);
				gp.add(lb5,0,4);
				gp.add(t5,1,4);
				gp.add(lb6,0,5);
				gp.add(t6,1,5);
				gp.setAlignment(Pos.CENTER);
				root.setCenter(gp); 
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
