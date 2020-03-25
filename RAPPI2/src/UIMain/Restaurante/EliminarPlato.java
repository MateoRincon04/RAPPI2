package UIMain.Restaurante;

import java.util.Optional;

import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Main;
import UIMain.OpcionDeMenu;
import UIMain.Excepciones.ErrorCancelar;
import UIMain.Excepciones.ErrorConfirmacion;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class EliminarPlato extends OpcionDeMenu {
	String[] criterios;
	FieldPanel fp;
	GridPane bonito;

	public void ejecutar() {

		String tituloCriterios = "Menu: ";
		criterios = new String[1];
		criterios[0] = "Plato: ";
		String tituloValores = "Nombre del Plato: ";
		String[] valores = new String[1];
		valores[0] = Main.usuarioRestaurante.getMenu();
		boolean[] habilitado = new boolean[1];
		habilitado[0] = false;
		
		

		if (Main.usuarioRestaurante.getMenu().equals("")) {

			Alert a = new Alert(AlertType.INFORMATION);
			a.setContentText("Usted no tiene registrada un plato en su menu");
			a.show();
		}

		fp = new FieldPanel(tituloCriterios, criterios, tituloValores, valores, habilitado);
		bonito = new GridPane();
		Label desc = new Label("Funcionalidad para eliminar el plato que posee en su menu: ");
		desc.setAlignment(Pos.CENTER);
		Label nom = new Label(Data.getOpciones().get(19).toString());
		nom.setAlignment(Pos.CENTER);
		nom.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		desc.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		bonito.add(new Label(
				"                                                                                                                        "),
				0, 0);
		bonito.add(new Label(
				"                                                                                                                        "),
				0, 2);
		bonito.add(new Label(
				"                                                                                                                        "),
				0, 1);
		bonito.add(nom, 1, 0);
		bonito.add(desc, 1, 1);
		bonito.add(fp, 1, 2);
		RestauranteEscena.root.setCenter(bonito);
	}

	public void Aceptar() {
		try {
			if (!Main.usuarioRestaurante.getMenu().equals("")) {

				try {
					Alert al = new Alert(AlertType.CONFIRMATION);
					al.setContentText("Seguro que desea eliminar su plato");
					Optional<ButtonType> res = al.showAndWait();
					if (res.get() == ButtonType.OK) {
						throw new ErrorConfirmacion();

					} else {
						this.Cancelar();
					}
				} catch (ErrorConfirmacion e) {
					String vie = Main.usuarioRestaurante.getMenu();
					Main.usuarioRestaurante.setMenu("");
					this.Cancelar();
					Label r = new Label("Usted ha eliminado el plato" + vie + " de su menu" );
					r.setAlignment(Pos.CENTER);
					r.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
					r.setFont(new Font("Arial", 15));
					bonito.add(r, 1, 3);
					bonito.add(new Label(
							"                                                                                                                        "),
							0, 3);
					RestauranteEscena.root.getChildren().remove(bonito);
					RestauranteEscena.root.setCenter(bonito);
				}

			} else {
				throw new ErrorCancelar();
			}

		} catch (ErrorCancelar e) {
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText(e.getMessage());
			a.show();
			this.Cancelar();
		}
	}

	public void Cancelar() {
		fp.setValue(criterios[0]);
	}
	
	
	public String toString() {
		return "Eliminar plato";
	}
}
