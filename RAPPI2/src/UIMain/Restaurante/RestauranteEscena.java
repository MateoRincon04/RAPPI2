package UIMain.Restaurante;

import java.util.Optional;

import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Main;
import gestorAplicacion.Oferta.Restaurante;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RestauranteEscena extends Application {
	private Scene sceneRes;
	private GridPane gp;
	static BorderPane root;
	private Restaurante usuario = Main.usuarioRestaurante;

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
		root = new BorderPane();
		root.setTop(barraMenu);
		// creación de la Escena
		sceneRes = new Scene(root, 1200, 600);

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
				String[] criterios = new String[] { "Nombre: ", "Direcciones: ", "Celular: ", "Menu: ", "Clave: " };
				String tituloValores = "valor";
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
				boolean[] habilitado = new boolean[] { false, false, false, false, false };

				FieldPanel fp = new FieldPanel(tituloCriterios, criterios, tituloValores, valores, habilitado);
				GridPane bonito = new GridPane();
				Label desc = new Label("Datos de el usuario: ");
				desc.setAlignment(Pos.CENTER);
				desc.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
				bonito.add(new Label(
						"                                                                                                                        "),
						0, 0);
				bonito.add(new Label(
						"                                                                                                                        "),
						0, 1);
				bonito.add(desc, 1, 0);
				bonito.add(fp, 1, 1);
				root.setCenter(bonito);
			}
		});

		// Programa para las funcionalidades
		// En cuales direcciones
		menu1.getItems().get(0).setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Data.getOpciones().get(14).ejecutar();
			}
		});

		// Crear platos
		
		menu1.getItems().get(2).setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Data.getOpciones().get(15).ejecutar();
				
				Button ac = new Button("Aceptar");
				ac.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						((CrearPlato)Data.getOpciones().get(15)).Aceptar();
						
						
						
					}
				});

				Button ca = new Button("Cancelar");
				ca.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						((CrearPlato)Data.getOpciones().get(15)).Cancelar();
						
						
						
					}
				});
				HBox hb = new HBox(ac,ca);
				hb.setAlignment(Pos.TOP_CENTER);
				hb.setMaxHeight(Double.MAX_VALUE);
				root.setBottom(hb);

			}
		});

		// programa para Ayuda Acerca de
		mi3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				String[] criterios = { "Nombre: ", "Nombre: ", "Nombre: ", "Nombre: " };
				String[] valores = { "Mateo Rincon", "Paula Andrea Taborda", "Guillermo Toloza", "Santiago Tamayo" };
				boolean[] habilitado = { false, false, false, false };
				FieldPanel fp = new FieldPanel("Lista", criterios, "Nombres", valores, habilitado);
				GridPane bonito = new GridPane();
				Label desc = new Label("Nombre de los autores: ");
				desc.setAlignment(Pos.CENTER);
				desc.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
				bonito.add(new Label(
						"                                                                                                                        "),
						0, 0);
				bonito.add(new Label(
						"                                                                                                                        "),
						0, 1);
				bonito.add(desc, 1, 0);
				bonito.add(fp, 1, 1);
				root.setCenter(bonito);
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