package UIMain.Restaurante;

import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Oferta.Restaurante;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class AgregarDireccionRest extends OpcionDeMenu {
	public void ejecutar() {
		System.out.println("Ingrese la nueva direccion a registrar: ");
		String direccion = Main.user.next();
		Restaurante restaurante = Main.usuarioRestaurante;
		boolean valor = restaurante.agregarDireccion(direccion);
		if (!valor) {
			System.out.println("La direccion ya existe. Intente nuevamente");
			ejecutar();
		} else {
			System.out.println("La direccion ha sido agregada correctamente.");
			MenuDeConsola.lanzarMenu(Main.usuarioRestaurante);
		}
	}

	public String toString() {
		return "Agregar Direccion Restaurante";
	}

	public void ejecutar(String t1) {
		if (t1.equals("Agregar Direccion Restaurante")) {
			Label des = new Label("Se desea agregar a el restaurante" + Main.usuarioRestaurante.getNombre() + "una nueva direccion");
			RestauranteEscena.bp.setCenter(des);
			Label yaTengo = new Label("direcciones actuales:  ");
			String aux = "";
			for (int i = 0; i < Main.usuarioRestaurante.getDireccion().size(); i++) {
				String la = Main.usuarioRestaurante.getDireccion().get(i);
				if (i == 0) {
					aux = la;
				} else {
					aux = aux + ", " + la;
				}

			}
			Label tengo = new Label(aux);
			Label nueva = new Label("direccion que desea añadir");
			TextField val = new TextField();
			Button ac = new Button("Aceptar");
			ac.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					boolean dup = Main.usuarioRestaurante.agregarDireccion(val.getText());

					if (!dup) {
						Alert a = new Alert(AlertType.ERROR);
					}
				}
			});
			GridPane gp = new GridPane();
			
			
			RestauranteEscena.bp.setBottom(gp);

		}
	}
}