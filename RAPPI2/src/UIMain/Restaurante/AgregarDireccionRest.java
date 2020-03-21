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

}