package UIMain.Restaurante;

import java.util.ArrayList;
import java.util.Optional;

import javax.swing.JComboBox;

import BaseDatos.Data;
import UIMain.Main;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class RestauranteEscena extends Application {

	Stage window;
	Button Archivo;
	Button ProcYConsul;
	Button edit;
	Button Ayuda;
	ComboBox cbx1;
	Scene scene;
	FlowPane root;
	BorderPane bord;
	GridPane grid;
	static BorderPane bp;
	Alert a;
	Label lbl = new Label();
	FlowPane fl;
	GridPane ayuda;
	String dondeAndo = "";
	Scene sceneEdit;
	BorderPane proc;
	SwingNode sw = new SwingNode();
	JComboBox<String> comboBox;

	public void start(Stage stage) {

		window = stage;
		Archivo = new Button("Archivo");
		ProcYConsul = new Button("Procesos y Consultas");
		Ayuda = new Button("Ayuda");

		Handler handler = new Handler();
		Archivo.setOnAction(handler);
		ProcYConsul.setOnAction(handler);
		Ayuda.setOnAction(handler);
		// FlowPane
		root = new FlowPane();
		root.setVgap(8);
		root.setHgap(4);
		root.getChildren().add(Archivo);
		root.getChildren().add(ProcYConsul);
		root.getChildren().add(Ayuda);

		// BorderPane
		bord = new BorderPane();
		bord.setTop(root);
		scene = new Scene(bord, 1200, 600);

		window.setTitle("Usuario: " + Main.usuarioRestaurante.getNombre()); // + Main.usuarioRestaurante.getNombre()
		window.setScene(scene);
		window.show();

	}

	class Handler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			Object control = e.getSource();
			if (control instanceof Button) {
				if (control.equals(Archivo)) {
					if (dondeAndo.equals("Procesos y Consultas")) {
						//bord.getChildren().remove();

					} else if (dondeAndo.equals("Ayuda")) {
						//bord.getChildren().remove();
					}

					grid = new GridPane();
					Label lab1 = new Label("Nombre: ");
					Label lab2 = new Label("Direcciones: ");
					Label lab3 = new Label("Celular: ");
					Label lab4 = new Label("Clave: ");
					Label ins = new Label("separe las direcciones por ,");
					String aux = "";
					Label lab1_1 = new Label(Main.usuarioRestaurante.getNombre());
					for (int i = 0; i < Main.usuarioRestaurante.getDireccion().size(); i++) {
						String la = Main.usuarioRestaurante.getDireccion().get(i);
						if (i == 0) {
							aux = la;
						} else {
							aux = aux + ", " + la;
						}

					}
					Label lab1_2 = new Label(aux);
					Label lab1_3 = new Label(Main.usuarioRestaurante.getCelular());
					Label lab1_4 = new Label(Main.usuarioRestaurante.getClave());

					TextField tx_1 = new TextField();
					tx_1.setText(Main.usuarioRestaurante.getNombre());
					tx_1.setEditable(false);
					TextField tx_2 = new TextField();
					tx_2.setText(aux);
					TextField tx_3 = new TextField();
					tx_3.setText(Main.usuarioRestaurante.getCelular());
					TextField tx_4 = new TextField();
					tx_4.setText(Main.usuarioRestaurante.getClave());
					tx_4.setEditable(false);

					grid = new GridPane();
					grid.add(new Label("Datos del restaurante: "), 0, 0);
					grid.add(lab1, 0, 1);
					grid.add(lab2, 0, 2);
					grid.add(lab3, 0, 3);
					grid.add(lab4, 0, 4);
					grid.add(lab1_1, 1, 1);
					grid.add(lab1_2, 1, 2);
					grid.add(lab1_3, 1, 3);
					grid.add(lab1_4, 1, 4);

					grid.setPadding(new Insets(10, 10, 10, 10));
					grid.setVgap(5);
					grid.setHgap(5);
					grid.setAlignment(Pos.CENTER);
					bord.setCenter(grid);

					Button can = new Button("Cancelar");

					Button acep = new Button("Aceptar cambios");
					acep.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							a = new Alert(AlertType.CONFIRMATION);
							a.setTitle("Confirmacion");
							a.setContentText("Confirmacion de los cambio realizados");
							Optional<ButtonType> result = a.showAndWait();
							if (result.get() == ButtonType.OK) {
								Main.usuarioRestaurante.setCelular(tx_3.getText());
								Main.usuarioRestaurante.setDireccion(tx_2.getText());
								bord.getChildren().remove(grid);
								grid.getChildren().remove(tx_1);
								grid.getChildren().remove(tx_2);
								grid.getChildren().remove(tx_3);
								grid.getChildren().remove(tx_4);
								grid.getChildren().remove(acep);
								grid.getChildren().remove(ins);
								grid.getChildren().remove(can);
								grid.add(lab1_1, 1, 1);
								grid.add(lab1_2, 1, 2);
								grid.add(lab1_3, 1, 3);
								grid.add(lab1_4, 1, 4);
								bord.setCenter(grid);

							} else {
								bord.getChildren().remove(grid);
								grid.getChildren().remove(tx_1);
								grid.getChildren().remove(tx_2);
								grid.getChildren().remove(tx_3);
								grid.getChildren().remove(tx_4);
								grid.getChildren().remove(acep);
								grid.getChildren().remove(ins);
								grid.getChildren().remove(can);
								grid.add(lab1_1, 1, 1);
								grid.add(lab1_2, 1, 2);
								grid.add(lab1_3, 1, 3);
								grid.add(lab1_4, 1, 4);
								bord.setCenter(grid);
							}

						}
					});

					can.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							bord.getChildren().remove(grid);
							grid.getChildren().remove(tx_1);
							grid.getChildren().remove(tx_2);
							grid.getChildren().remove(tx_3);
							grid.getChildren().remove(tx_4);
							grid.getChildren().remove(acep);
							grid.getChildren().remove(ins);
							grid.getChildren().remove(can);
							grid.add(lab1_1, 1, 1);
							grid.add(lab1_2, 1, 2);
							grid.add(lab1_3, 1, 3);
							grid.add(lab1_4, 1, 4);
							bord.setCenter(grid);
						}

					});

					edit = new Button("Editar");
					edit.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							bord.getChildren().remove(grid);
							grid.getChildren().remove(lab1_1);
							grid.getChildren().remove(lab1_2);
							grid.getChildren().remove(lab1_3);
							grid.getChildren().remove(lab1_4);
							grid.add(tx_1, 1, 1);
							grid.add(tx_2, 1, 2);
							grid.add(tx_3, 1, 3);
							grid.add(tx_4, 1, 4);
							grid.add(acep, 1, 5);
							grid.add(ins, 2, 2);
							grid.add(can, 2, 5);
							bord.setCenter(grid);

						}
					});

					dondeAndo = "Archivo";
					bord.setBottom(edit);
					window.setScene(scene);
					window.show();

				} else if (control.equals(ProcYConsul)) {
					if (dondeAndo.equals("Archivo")) {
						bord.getChildren().remove(edit);
						bord.getChildren().remove(grid);
					} else if (dondeAndo.equals("Ayuda")) {

					}

					bp = new BorderPane();

					ArrayList<String> opciones = new ArrayList<String>();
					for (int i = 0; i < Main.usuarioRestaurante.getOpciones().size(); i++) {
						opciones.add(Data.getOpciones().get(Main.usuarioRestaurante.getOpciones().get(i)).toString());
					}

					cbx1 = new ComboBox(FXCollections.observableArrayList(opciones));
					cbx1.setPromptText("Opciones");
					cbx1.valueProperty().addListener(change);

					bp.setTop(cbx1);

					bord.setCenter(bp);
					dondeAndo = "Procesos y Consultas";
					window.setScene(scene);
					window.show();

				} else if (control.equals(Ayuda)) {
					ayuda = new GridPane();
					Label ay = new Label("Ayuda para el uso de tu menu, escriba su duda: ");
					Label nom = new Label("Nombres de los autores: ");
					Label espacio = new Label(" ");
					Label nombres = new Label("Santiago Tamayo, Paula Andrea Taborda, Guillermo Toloza, Mateo Rincón");
					TextField tf = new TextField();
					ayuda.add(nom, 0, 0);
					ayuda.add(nombres, 0, 1);
					ayuda.add(espacio, 0, 2);
					ayuda.add(ay, 0, 3);
					ayuda.add(tf, 0, 4);

				}
			}
		}

	}

	ChangeListener<String> change = new ChangeListener<String>() {

		public void changed(ObservableValue ov, String t, String t1) {
			if (t1.equals("Agregar Direccion Restaurante")) {
				bp.setCenter(((AgregarDireccionRest) Data.getOpciones().get(14)).ejecutar(t1));
			}

		};
	};

	public static void main(String[] args) {
		Data.CargarOpciones();
		launch(args);
	}

}
