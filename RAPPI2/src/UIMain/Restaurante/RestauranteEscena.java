package UIMain.Restaurante;

import java.util.ArrayList;
import java.util.Optional;
import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Main;
import UIMain.Default.InterfazInicio;
import UIMain.Excepciones.AlertaConfirmacion;
import gestorAplicacion.Oferta.Restaurante;
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

public class RestauranteEscena {
	private static Scene sceneRes;
	private HBox hb;
	static BorderPane root;
	private Restaurante usuario = Main.usuarioRestaurante;

	public RestauranteEscena() {

		/*
		 * window = stage; Data.CargarOpciones(); Data.llenarDataBases();
		 */
		InterfazInicio.window.setTitle("Usuario: " + Main.usuarioRestaurante.getNombre());
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
		for (int i = 0; i < usuario.getOpciones().size(); i++) {
			int opcion = usuario.getOpciones().get(i);
			menu1.getItems().add(new MenuItem(Data.getOpciones().get(opcion).toString()));
			menu1.getItems().add(new SeparatorMenuItem());
		}

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
				String tituloCriterios = "Datos del Restaurante";
				String[] criterios = new String[] { "Nombre: ", "Direcciones: ", "Celular: ", "Menu: ", "Clave: " };
				String tituloValores = "Valor";
				String aux = "";
				for (int in = 0; in < usuario.getDireccion().size(); in++) {
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
		// En cuales direcciones
		if (lista.contains("¿En cuáles direcciones?")) {
			menu1.getItems().get(ind.get(lista.indexOf("¿En cuáles direcciones?")))
					.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent event) {
							try {
								Data.getOpciones().get(14).ejecutar();
							} catch (AlertaConfirmacion al) {
								Alert ala = new Alert(AlertType.ERROR);
								ala.setContentText(al.getMessage());
							}

						}
					});

		}

		// Crear platos
		if (lista.contains("Crear Plato Restaurante")) {
			menu1.getItems().get(ind.get(lista.indexOf("Crear Plato Restaurante")))
					.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent event) {
							try {
								Data.getOpciones().get(15).ejecutar();
							} catch (AlertaConfirmacion al) {
								Alert ala = new Alert(AlertType.ERROR);
								ala.setContentText(al.getMessage());
							}

							Button ac = new Button("Aceptar");
							ac.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent event) {
									((CrearPlato) Data.getOpciones().get(15)).Aceptar();

								}
							});

							Button ca = new Button("Cancelar");
							ca.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent event) {
									((CrearPlato) Data.getOpciones().get(15)).Cancelar();

								}
							});
							hb = new HBox(ac, ca);
							hb.setAlignment(Pos.TOP_CENTER);
							hb.setMaxHeight(Double.MAX_VALUE);
							root.setBottom(hb);

						}
					});
		}

		// Agregar direccion al resta
		if (lista.contains("Agregar Direccion Restaurante")) {
			menu1.getItems().get(ind.get(lista.indexOf("Agregar Direccion Restaurante")))
					.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent event) {
							try {
								Data.getOpciones().get(16).ejecutar();
							} catch (AlertaConfirmacion al) {
								Alert ala = new Alert(AlertType.ERROR);
								ala.setContentText(al.getMessage());
							}

							Button ac = new Button("Aceptar");
							ac.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent event) {
									((AgregarDireccionRest) Data.getOpciones().get(16)).Aceptar();

								}
							});

							Button ca = new Button("Cancelar");
							ca.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent event) {
									((AgregarDireccionRest) Data.getOpciones().get(16)).Cancelar();

								}
							});
							hb = new HBox(ac, ca);
							hb.setAlignment(Pos.TOP_CENTER);
							hb.setMaxHeight(Double.MAX_VALUE);
							root.setBottom(hb);

						}
					});
		}

		// Cambiar plato
		if (lista.contains("Cambiar Plato Restaurante")) {
			menu1.getItems().get(ind.get(lista.indexOf("Cambiar Plato Restaurante")))
					.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent event) {
							try {
								Data.getOpciones().get(17).ejecutar();
							} catch (AlertaConfirmacion al) {
								Alert ala = new Alert(AlertType.ERROR);
								ala.setContentText(al.getMessage());
							}

							Button ac = new Button("Aceptar");
							ac.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent event) {
									((CambiarPlato) Data.getOpciones().get(17)).Aceptar();

								}
							});

							Button ca = new Button("Cancelar");
							ca.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent event) {
									((CambiarPlato) Data.getOpciones().get(17)).Cancelar();

								}
							});
							hb = new HBox(ac, ca);
							hb.setAlignment(Pos.TOP_CENTER);
							hb.setMaxHeight(Double.MAX_VALUE);
							root.setBottom(hb);

						}
					});
		}

		// Eliminar direccion
		if (lista.contains("Eliminar direccion restaurante")) {
			menu1.getItems().get(ind.get(lista.indexOf("Eliminar direccion restaurante")))
					.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent event) {
							try {
								Data.getOpciones().get(18).ejecutar();
							} catch (AlertaConfirmacion al) {
								Alert ala = new Alert(AlertType.ERROR);
								ala.setContentText(al.getMessage());
							}

							Button ac = new Button("Aceptar");
							ac.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent event) {
									((EliminarDireccionRest) Data.getOpciones().get(18)).Aceptar();

								}
							});

							Button ca = new Button("Cancelar");
							ca.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent event) {
									((EliminarDireccionRest) Data.getOpciones().get(18)).Cancelar();

								}
							});
							hb = new HBox(ac, ca);
							hb.setAlignment(Pos.TOP_CENTER);
							hb.setMaxHeight(Double.MAX_VALUE);
							root.setBottom(hb);

						}
					});
		}

		// Eliminar plato
		if (lista.contains("Eliminar plato")) {
			menu1.getItems().get(ind.get(lista.indexOf("Eliminar plato"))).setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					try {
						Data.getOpciones().get(19).ejecutar();
					} catch (AlertaConfirmacion al) {
						Alert ala = new Alert(AlertType.ERROR);
						ala.setContentText(al.getMessage());
					}

					Button ac = new Button("Aceptar");
					ac.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent event) {
							((EliminarPlato) Data.getOpciones().get(19)).Aceptar();

						}
					});

					Button ca = new Button("Cancelar");
					ca.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent event) {
							((EliminarPlato) Data.getOpciones().get(19)).Cancelar();

						}
					});
					hb = new HBox(ac, ca);
					hb.setAlignment(Pos.TOP_CENTER);
					hb.setMaxHeight(Double.MAX_VALUE);
					root.setBottom(hb);

				}
			});
		}

		// Cambiar direcciones
		if (lista.contains("Cambiar Direccion Restaurante")) {
			menu1.getItems().get(ind.get(lista.indexOf("Cambiar Direccion Restaurante")))
					.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent event) {
							try {
								Data.getOpciones().get(20).ejecutar();
							} catch (AlertaConfirmacion al) {
								Alert ala = new Alert(AlertType.ERROR);
								ala.setContentText(al.getMessage());
							}

							Button ac = new Button("Aceptar");
							ac.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent event) {
									((CambiarDireccionRest) Data.getOpciones().get(20)).Aceptar();

								}
							});

							Button ca = new Button("Cancelar");
							ca.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent event) {
									((CambiarDireccionRest) Data.getOpciones().get(20)).Cancelar();

								}
							});
							hb = new HBox(ac, ca);
							hb.setAlignment(Pos.TOP_CENTER);
							hb.setMaxHeight(Double.MAX_VALUE);
							root.setBottom(hb);

						}
					});

		}

		// Cambiar contrasena rest
		if (lista.contains("Cambiar contraseña restaurante")) {
			menu1.getItems().get(ind.get(lista.indexOf("Cambiar contraseña restaurante")))
					.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent event) {
							try {
								Data.getOpciones().get(21).ejecutar();
							} catch (AlertaConfirmacion al) {
								Alert ala = new Alert(AlertType.ERROR);
								ala.setContentText(al.getMessage());
							}

							Button ac = new Button("Aceptar");
							ac.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent event) {
									((cambiarContraseñaRestaurante) Data.getOpciones().get(21)).Aceptar();

								}
							});

							Button ca = new Button("Cancelar");
							ca.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent event) {
									((cambiarContraseñaRestaurante) Data.getOpciones().get(21)).Cancelar();

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
			menu1.getItems().get(ind.get(lista.indexOf("Salir")))
					.setOnAction(new EventHandler<ActionEvent>() {
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
								Main.usuarioRestaurante = null;
								InterfazInicio.window.setScene(UIMain.Default.InterfazInicio.getScene());
								InterfazInicio.window.setTitle("RAPPI2");

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

	}

	public Scene getScene() {
		return sceneRes;
	}

}