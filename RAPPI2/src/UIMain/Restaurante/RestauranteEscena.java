package UIMain.Restaurante;

import java.util.ArrayList;
import java.util.Optional;

import javax.swing.JComboBox;

import BaseDatos.Data;
import UIMain.Main;
import gestorAplicacion.Administracion.Administrador;
import gestorAplicacion.Oferta.Restaurante;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class RestauranteEscena extends Application {
	Scene sceneRes;
	GridPane gp;
	Restaurante usuario = Main.usuarioRestaurante;

	public void start(Stage stage) {

		// Manejo de la barra de menú de la vantana
		MenuBar barraMenu = new MenuBar();

		// Definición de menú
		Menu menu = new Menu("Archivo");
		Menu menu1 = new Menu("Procesos y consultas");
		Menu menu2 = new Menu("Ayuda");
		barraMenu.getMenus().addAll(menu, menu1, menu2);

		// se adiciona los elementos de archivo
		MenuItem mi1 = new MenuItem("Usuario");
		MenuItem mi2 = new MenuItem("Salir");
		SeparatorMenuItem separator = new SeparatorMenuItem();
		menu.getItems().addAll(mi1, separator, mi2);

		// se adiciona los elementos de Procesos y consultas
		for (int i = 14; i < 22; i++) {
			menu1.getItems().add(new MenuItem(Data.getOpciones().get(i).toString()));
			menu1.getItems().add(new SeparatorMenuItem());
		}
		menu1.getItems().add(new MenuItem(Data.getOpciones().get(29).toString()));
		menu1.getItems().add(new SeparatorMenuItem());

		// se adiciona los elementos de ayuda
		MenuItem mi3 = new MenuItem("Acerca de");
		menu2.getItems().add(mi3);

		// se adicion la barra de menu al pane1
		BorderPane root = new BorderPane();
		root.setTop(barraMenu);
		// creación de la Escena
		sceneRes = new Scene(root, 600, 600);

		// programa para Archivo SALIR
		mi2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Alert conf = new Alert(AlertType.CONFIRMATION);
				conf.setTitle("Confirmacion de salida");
				conf.setContentText("¿Seguro que desea salir?");
				Optional<ButtonType> result = conf.showAndWait();
				if (result.get() == ButtonType.OK) {
					Data.getOpciones().get(29).ejecutar();
				} else {
					// nada
				}
			}
		});

		// programa para Archivo USUARIO
		mi1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// informacion del restaurante por medio de el FieldPanel
				String tituloCriterios = "Datos del Restaurante";
				String[] criterios = new String[] { "Nombre", "Direcciones", "Celular", "Menu", "Clave" };
				String tituloValores = "";
				String aux = "";
				for (int in = 0; in < Main.usuarioRestaurante.getDireccion().size(); in++) {
					if (in == 0) {
						aux = usuario.getDireccion().get(0);

					} else {
						aux = aux + ", " + usuario.getDireccion().get(in);
					}

				}
				String[] valores = new String[] { usuario.getNombre(), aux, usuario.getCelular(), usuario.getMenu(),
						usuario.getClave() };
				boolean[] habilitado = new boolean[] { false, true, true, true, false };

				// FieldPanel fp = new FieldPanel(tituloCriterios,criterios,tituloValores,valores,habilitado);

				// se crea la ventana con la informacion basica del Administrador
				gp = new GridPane();
				// crear los nodos del grid
				Label lb1 = new Label("Nombre");
				TextField t1 = new TextField(usuario.getNombre());
				t1.setEditable(false);
				Label lb2 = new Label("UserName");
				TextField t2 = new TextField(usuario.getUserName());
				t2.setEditable(false);
				Label lb3 = new Label("Clave");
				String claveAux = "";
				for (int i = 0; i < usuario.getClave().length(); i++) {
					claveAux = claveAux + "*";
				}
				TextField t3 = new TextField(claveAux);
				t3.setEditable(false);
				t3.setOnMouseEntered(new EventHandler<MouseEvent>() {
					public void handle(MouseEvent mouseEvent) {
						t3.setText(usuario.getClave());
					}
				});
				t3.setOnMouseExited(new EventHandler<MouseEvent>() {
					public void handle(MouseEvent mouseEvent) {
						String claveAux = "";
						for (int i = 0; i < usuario.getClave().length(); i++) {
							claveAux = claveAux + "*";
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
				// especificaciones del grip
				gp.setHgap(5);
				gp.setVgap(5);
				gp.setAlignment(Pos.CENTER);
				// agregar los nodos al grip
				gp.add(lb1, 0, 0);
				gp.add(t1, 1, 0);
				gp.add(lb2, 0, 1);
				gp.add(t2, 1, 1);
				gp.add(lb3, 0, 2);
				gp.add(t3, 1, 2);
				gp.add(lb4, 0, 3);
				gp.add(t4, 1, 3);
				gp.add(lb5, 0, 4);
				gp.add(t5, 1, 4);
				gp.add(lb6, 0, 5);
				gp.add(t6, 1, 5);
				gp.setAlignment(Pos.CENTER);
				root.setCenter(gp);
			}
		});

		// Programa para las funcionalidades
		// En cuales direcciones
		menu1.getItems().get(0).setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				String tituloCriterios = "Datos necesarios para la operacion";
				String[] criterios = new String[] { "Nombre", "Direcciones", "Celular", "Menu", "Clave" };
				String tituloValores = "";
				String aux = "";
				for (int in = 0; in < Main.usuarioRestaurante.getDireccion().size(); in++) {
					if (in == 0) {
						aux = usuario.getDireccion().get(0);

					} else {
						aux = aux + ", " + usuario.getDireccion().get(in);
					}

				}
				String[] valores = new String[] { usuario.getNombre(), aux, usuario.getCelular(), usuario.getMenu(),
						usuario.getClave() };
				boolean[] habilitado = new boolean[] { false, true, true, true, false };

				// FieldPanel fp = new FieldPanel(tituloCriterios,criterios,tituloValores,valores,habilitado);

			}
		});

		// Display sceneRes at first
		stage.setScene(sceneRes);
		stage.setTitle("Usuario: " + usuario.getNombre());
		stage.show();

	}

	public static void main(String[] args) {
		Data.CargarOpciones();
		launch(args);
	}
}