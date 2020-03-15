package UIMain.Cliente;

import java.awt.Button;

import UIMain.Main;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MenuCliente extends Application {
	public void start(Stage myStage) {
		myStage.setTitle("Usuario: "+Main.usuario.getNombre());
		BorderPane panel = new BorderPane();
		FlowPane parteSuperior = new FlowPane();
		Button archivos = new Button("Archivos");
		Button procesosYConsultas = new Button("Procesos y Consultas");
		Button ayuda = new Button("Ayuda");
		parteSuperior.getChildren().add(archivos);
		parteSuperior.setHgap(5);
	}
}
