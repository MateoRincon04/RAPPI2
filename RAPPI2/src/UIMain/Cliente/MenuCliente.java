package UIMain.Cliente;

import BaseDatos.Data;
import UIMain.Main;
import gestorAplicacion.Interaccion.Cliente;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MenuCliente extends Application {
	Button archivos;
	Button procesosYConsultas;
	Button ayuda;
	BorderPane panel;
	GridPane ayudaPane;
	BorderPane panelcin;

	public void start(Stage myStage) {
		// myStage.setTitle("Usuario: " + Main.usuario.getNombre());
			panel = new BorderPane();
			FlowPane parteSuperior = new FlowPane();
			archivos = new Button("Archivos");
			HanderClass handler = new HanderClass();
			procesosYConsultas = new Button("Procesos y Consultas");
			ayuda = new Button("Ayuda");
			archivos.setOnAction(handler);
			procesosYConsultas.setOnAction(handler);
			ayuda.setOnAction(handler);
			parteSuperior.getChildren().add(archivos);
			parteSuperior.getChildren().add(procesosYConsultas);
			parteSuperior.getChildren().add(ayuda);
			parteSuperior.setHgap(5);
			panel.setTop(parteSuperior);
			Scene scene = new Scene(panel, 1200, 600);
			myStage.setScene(scene);
			myStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	class HanderClass implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			Object control = e.getSource();
			if (control instanceof Button) {
				if (control.equals(archivos)) {
					Cliente cliente = Data.buscarCliente("santiago");
					BorderPane panelcito = new BorderPane();
					GridPane nuevoPanel = new GridPane();
					Label saludo = new Label("Estos son los datos del Cliente: ");
					panelcito.setTop(saludo);
					panelcito.setAlignment(saludo, Pos.CENTER);
					Label nombre = new Label(" Nombre: ");
					Label valorNombre = new Label(" " + cliente.getNombre() + " ");
					Label clave = new Label(" clave: ");
					Label valorClave = new Label(" " + cliente.getClave() + " ");
					Label username = new Label(" username: ");
					Label valorUsername = new Label(" " + cliente.getUserName() + " ");
					Label telefono = new Label(" Telefono: ");
					Label valorTelefono = new Label(" " + String.valueOf(cliente.getTelefono()) + " ");
					Label comuna = new Label(" Comuna: ");
					Label valorComuna = new Label(" " + String.valueOf(cliente.getComuna()) + " ");
					Label metodoDePago = new Label(" Metodo de Pago: ");
					Label valorMetodoDePago = new Label(" " + cliente.getMetodoDePago() + " ");
					Label saldo = new Label(" Saldo: ");
					Label valorSaldo = new Label(" " + String.valueOf(cliente.getSaldo()) + " ");
					Label direccion = new Label(" Direccion: ");
					Label valorDireccion = new Label(" " + cliente.getDireccion() + " ");
					nuevoPanel.add(nombre, 0, 0);
					nuevoPanel.add(valorNombre, 1, 0);
					nuevoPanel.add(username, 0, 1);
					nuevoPanel.add(valorUsername, 1, 1);
					nuevoPanel.add(clave, 0, 2);
					nuevoPanel.add(valorClave, 1, 2);
					nuevoPanel.add(telefono, 0, 3);
					nuevoPanel.add(valorTelefono, 1, 3);
					nuevoPanel.add(comuna, 0, 4);
					nuevoPanel.add(valorComuna, 1, 4);
					nuevoPanel.add(metodoDePago, 0, 5);
					nuevoPanel.add(valorMetodoDePago, 1, 5);
					nuevoPanel.add(saldo, 0, 6);
					nuevoPanel.add(valorSaldo, 1, 6);
					nuevoPanel.add(direccion, 0, 7);
					nuevoPanel.add(valorDireccion, 1, 7);
					nuevoPanel.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
					panelcito.setCenter(nuevoPanel);
					nuevoPanel.setAlignment(Pos.CENTER);
					panel.setCenter(panelcito);

				} else if (control.equals(procesosYConsultas)) {
					panelcin = new BorderPane();
					GridPane hola = new GridPane();
					Label descripcion = new Label("  aqui va la descripcion  ");
					hola.add(descripcion, 0, 0);
					hola.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
					hola.setAlignment(Pos.CENTER);
					panel.setCenter(hola);

				} else if (control.equals(ayuda)) {
					ayudaPane = new GridPane();
					Label ay = new Label("Ayuda para el uso de tu menu, escriba su duda: ");
					Label nom = new Label("Nombres de los autores: ");
					Label espacio = new Label(" ");
					Label nombres = new Label("Santiago Tamayo, Paula Andrea Taborda, Guillermo Toloza, Mateo Rincón");
					TextField tf = new TextField();
					ayudaPane.add(nom, 0, 0);
					ayudaPane.add(nombres, 0, 1);
					ayudaPane.add(espacio, 0, 2);
					ayudaPane.add(ay, 0, 3);
					ayudaPane.add(tf, 0, 4);
					ayudaPane.setAlignment(Pos.CENTER);
					panel.setCenter(ayudaPane);

				} else {

				}
			}
		}
	}
}
