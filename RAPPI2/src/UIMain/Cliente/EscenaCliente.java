package UIMain.Cliente;

import java.util.Optional;

import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Main;
import gestorAplicacion.Interaccion.Cliente;
import gestorAplicacion.Oferta.Restaurante;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EscenaCliente extends Application {
	Scene escenaCliente;
	GridPane panel;
	Cliente cliente = Data.buscarCliente("guille");
	

	public void start(Stage stage) {
		
		MenuBar barraArriba = new MenuBar();
		Menu menu = new Menu("Archivo");
		Menu menu1 = new Menu("Procesos y consultas");
		Menu menu2 = new Menu("Ayuda");
		barraArriba.getMenus().addAll(menu, menu1, menu2);
		MenuItem mi1 = new MenuItem("Usuario");
		MenuItem mi2 = new MenuItem("Salir");
		SeparatorMenuItem separator = new SeparatorMenuItem();
		menu.getItems().addAll(mi1, separator, mi2);
		for (int i = 3; i < 12; i++) {
			menu1.getItems().add(new MenuItem(Data.getOpciones().get(i).toString()));
			menu1.getItems().add(new SeparatorMenuItem());
		}
		menu1.getItems().add(new MenuItem(Data.getOpciones().get(29).toString()));
		menu1.getItems().add(new SeparatorMenuItem());

		MenuItem mi3 = new MenuItem("Acerca de");
		menu2.getItems().add(mi3);

		BorderPane root = new BorderPane();
		root.setTop(barraArriba);
	
		escenaCliente = new Scene(root, 1200, 600);

		mi2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Alert conf = new Alert(AlertType.CONFIRMATION);
				conf.setTitle("Confirmacion de salida");
				conf.setContentText("¿Seguro que desea salir?");
				Optional<ButtonType> result = conf.showAndWait();
				if (result.get() == ButtonType.OK) {
					Data.getOpciones().get(29).ejecutar();
					System.exit(0);
				} else {

				}
			}
		});

		mi1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				String[] criterios = {"Nombre","UserName","Clave","Telefono","Comuna","Saldo"};
				String[] valores = {cliente.getNombre(),cliente.getUserName(), cliente.getClave(),String.valueOf(cliente.getTelefono()),String.valueOf(cliente.getComuna()),String.valueOf(cliente.getSaldo())};
				boolean[] habilitado = {true,false,false,true,true,false};
				FieldPanel fp = new FieldPanel("Criterios",criterios,"Valores",valores,habilitado);
				
				root.setCenter(fp);
			
			}
		});
		mi3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				String[] criterios = {"Nombre","Nombre","Nombre","Nombre"};
				String[] valores = {"Mateo Rincon","Paula Andrea Taborda", "Guillermo Toloza","Santiago Tamayo"};
				boolean[] habilitado = {false,false,false,false};
				FieldPanel fp = new FieldPanel("Acerca de",criterios,"los autores",valores,habilitado);
				root.setCenter(fp);
				root.setAlignment(fp, Pos.CENTER);
			}
		});
		stage.setScene(escenaCliente);
		stage.setTitle("Usuario: " + cliente.getNombre());
		stage.show();

	}

	

	public static void main(String[] args) {
		Data.CargarOpciones();
		launch(args);
	}
}
