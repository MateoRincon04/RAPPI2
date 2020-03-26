package UIMain.Tendero;

import java.util.ArrayList;
import java.util.Optional;
import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Main;
import UIMain.Default.InterfazInicio;
import UIMain.Excepciones.AlertaConfirmacion;
import gestorAplicacion.Interaccion.Tendero;
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

public class TenderoEscena {
	private Scene sceneTen;
	private HBox hb;
	static BorderPane root;
	static Tendero usuario;

	public TenderoEscena() {

		Data.CargarOpciones();
		Data.llenarDataBases();
		usuario = (Tendero) Main.usuario;

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
		for (int i = 11; i < 14; i++) {
			menu1.getItems().add(new MenuItem(Data.getOpciones().get(i).toString()));
			menu1.getItems().add(new SeparatorMenuItem());
		}
		menu1.getItems().add(new MenuItem(Data.getOpciones().get(30).toString()));
		menu1.getItems().add(new SeparatorMenuItem());

		menu1.getItems().add(new MenuItem(Data.getOpciones().get(29).toString()));
		menu1.getItems().add(new SeparatorMenuItem());

		// se adiciona los elementos de ayuda
		MenuItem mi3 = new MenuItem("Acerca de");
		menu2.getItems().add(mi3);

		// se adicion la barra de menu al pane1
		root = new BorderPane();
		root.setTop(barraMenu);
		// creación de la Escena
		sceneTen = new Scene(root, 1200, 600);

		// programa para Archivo SALIR
		mi2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Alert conf = new Alert(AlertType.CONFIRMATION);
				conf.setTitle("Confirmacion de salida");
				conf.setContentText("¿Seguro que desea salir?");
				Optional<ButtonType> result = conf.showAndWait();
				if (result.get() == ButtonType.OK) {
					try {
						Data.getOpciones().get(29).ejecutar();
					} catch (AlertaConfirmacion al) {
						Alert ala = new Alert(AlertType.ERROR);
						ala.setContentText(al.getMessage());
					}
					InterfazInicio.window.setScene(UIMain.Default.InterfazInicio.getScene());

				} else {
					// nada
				}
			}
		});

		// programa para Archivo USUARIO
		mi1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// informacion del restaurante por medio de el FieldPanel
				String tituloCriterios = "Datos del Tendero";
				String[] criterios = new String[] { "Nombre: ", "Telefono: ", "Comuna: ", "Clave: ", "Username: ",
						"Salario: " };
				String tituloValores = "Valor";
				String tel = String.valueOf(usuario.getTelefono());
				String com = String.valueOf(usuario.getComuna());
				String sal = String.valueOf(usuario.getSalario());
				String[] valores = new String[] { usuario.getNombre(), tel, com, usuario.getClave(),
						usuario.getUserName(), sal };
				boolean[] habilitado = new boolean[] { false, false, false, false, false, false };

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
				root.getChildren().remove(hb);
			}
		});

		ArrayList<Object> lista = new ArrayList<>();
		ArrayList<Integer> ind = new ArrayList<>();
		for (int i = 0; i < menu1.getItems().size(); i = i + 2) {
			lista.add(menu1.getItems().get(i).getText());
			ind.add(i);
		}

		// Programa para las funcionalidades
		// Cuantos pedidos he entregado
		if (lista.contains("¿Cuántos pedidos he entregado?")) {
			menu1.getItems().get(ind.get(lista.indexOf("¿Cuántos pedidos he entregado?")))
					.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent event) {
							try {
								Data.getOpciones().get(11).ejecutar();
							} catch (AlertaConfirmacion al) {
								Alert ala = new Alert(AlertType.ERROR);
								ala.setContentText(al.getMessage());
							}

						}
					});
		}

		// Aceptar Pedido
		if (lista.contains("Aceptar pedido")) {
			menu1.getItems().get(ind.get(lista.indexOf("Aceptar pedido"))).setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					try {
						Data.getOpciones().get(12).ejecutar();
					} catch (AlertaConfirmacion al) {
						Alert ala = new Alert(AlertType.ERROR);
						ala.setContentText(al.getMessage());
					}

					Button ac = new Button("Aceptar");
					ac.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent event) {
							((AceptarPedido) Data.getOpciones().get(12)).Aceptar();

						}
					});

					Button ca = new Button("Cancelar");
					ca.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent event) {
							((AceptarPedido) Data.getOpciones().get(12)).Cancelar();

						}
					});
					hb = new HBox(ac, ca);
					hb.setAlignment(Pos.TOP_CENTER);
					hb.setMaxHeight(Double.MAX_VALUE);
					root.setBottom(hb);

				}
			});
		}
		// Cambiar Contraseña Tendero
		if (lista.contains("Cambiar contraseña tendero")) {
			menu1.getItems().get(ind.get(lista.indexOf("Cambiar contraseña tendero"))).setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					Data.getOpciones().get(13).ejecutar();
				} catch (AlertaConfirmacion al) {
					Alert ala = new Alert(AlertType.ERROR);
					ala.setContentText(al.getMessage());
				}

				Button ac = new Button("Aceptar");
				ac.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						((cambiarContraseñaTendero) Data.getOpciones().get(13)).Aceptar();

					}
				});

				Button ca = new Button("Cancelar");
				ca.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						((cambiarContraseñaTendero) Data.getOpciones().get(13)).Cancelar();

					}
				});
				hb = new HBox(ac, ca);
				hb.setAlignment(Pos.TOP_CENTER);
				hb.setMaxHeight(Double.MAX_VALUE);
				root.setBottom(hb);

			}
		});
		}

		// Entregado
		if (lista.contains("Terminar pedido")) {
			menu1.getItems().get(ind.get(lista.indexOf("Terminar pedido"))).setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					Data.getOpciones().get(30).ejecutar();
				} catch (AlertaConfirmacion al) {
					Alert ala = new Alert(AlertType.ERROR);
					ala.setContentText(al.getMessage());
				}

				Button ac = new Button("Aceptar");
				ac.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						((Entregado) Data.getOpciones().get(30)).Aceptar();

					}
				});

				Button ca = new Button("Cancelar");
				ca.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						((Entregado) Data.getOpciones().get(30)).Cancelar();

					}
				});
				hb = new HBox(ac, ca);
				hb.setAlignment(Pos.TOP_CENTER);
				hb.setMaxHeight(Double.MAX_VALUE);
				root.setBottom(hb);

			}
		});
		}
		// Salir
		if (lista.contains("Salir")) {
			menu1.getItems().get(ind.get(lista.indexOf("Salir"))).setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Alert conf = new Alert(AlertType.CONFIRMATION);
				conf.setTitle("Confirmacion de salida");
				conf.setContentText("¿Seguro que desea salir?");
				Optional<ButtonType> result = conf.showAndWait();
				if (result.get() == ButtonType.OK) {
					try {
						Data.getOpciones().get(29).ejecutar();
					} catch (AlertaConfirmacion al) {
						Alert ala = new Alert(AlertType.ERROR);
						ala.setContentText(al.getMessage());
					}
					InterfazInicio.window.setScene(UIMain.Default.InterfazInicio.getScene());

				} else {
					// nada
				}
			}
		});
		}
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
				root.getChildren().remove(hb);
			}
		});
		InterfazInicio.window.setTitle("Usuario: " + usuario.getNombre());

		// Display sceneRes at first
		/*
		 * stage.setScene(sceneTen); stage.show();
		 */

	}

	public Scene getScene() {
		return sceneTen;
	}
}
