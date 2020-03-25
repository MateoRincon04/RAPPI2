package UIMain.Restaurante;

import java.util.Optional;
import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Main;
import UIMain.OpcionDeMenu;
import UIMain.Excepciones.AlertaConfirmacion;
import UIMain.Excepciones.ErrorCancelar;
import UIMain.Excepciones.ErrorConfirmacion;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class EliminarDireccionRest extends OpcionDeMenu {
	String[] criterios;
	FieldPanel fp;
	GridPane bonito;

	public void ejecutar() throws AlertaConfirmacion{

		try {
		String tituloCriterios = "Direcciones: ";
		criterios = new String[Main.usuarioRestaurante.getDireccion().size() + 1];
		for (int cr = 0; cr < criterios.length - 1; cr++) {
			criterios[cr] = "Direccion: ";
		}
		criterios[Main.usuarioRestaurante.getDireccion().size()] = "Eliminar direccion: ";
		String tituloValores = "Valor: ";
		String[] valores = new String[Main.usuarioRestaurante.getDireccion().size() + 1];
		for (int cr = 0; cr < valores.length - 1; cr++) {
			valores[cr] = Main.usuarioRestaurante.getDireccion().get(cr);
		}
		valores[Main.usuarioRestaurante.getDireccion().size()] = "";
		boolean[] habilitado = new boolean[Main.usuarioRestaurante.getDireccion().size() + 1];
		for (int cr = 0; cr < habilitado.length - 1; cr++) {
			habilitado[cr] = false;
		}
		habilitado[Main.usuarioRestaurante.getDireccion().size()] = true;

		if (Main.usuarioRestaurante.getDireccion().size() == 0) {

			Alert a = new Alert(AlertType.INFORMATION);
			a.setContentText("Usted no tiene registrada ninguna direccion aun");
			a.show();
			habilitado[Main.usuarioRestaurante.getDireccion().size()] = false;
		}

		fp = new FieldPanel(tituloCriterios, criterios, tituloValores, valores, habilitado);
		bonito = new GridPane();
		Label desc = new Label("Funcionalidad para eliminar una de las direcciones de mis registros: ");
		desc.setAlignment(Pos.CENTER);
		Label nom = new Label(Data.getOpciones().get(18).toString());
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
		} catch(Exception e) {
			throw new AlertaConfirmacion();
		}
	}

	public void Aceptar() {
		String direEliminar = fp.getValue(fp.criterios[Main.usuarioRestaurante.getDireccion().size()]);
		try {
			if (Main.usuarioRestaurante.getDireccion().contains(direEliminar)) {

				try {
					Alert al = new Alert(AlertType.CONFIRMATION);
					al.setContentText("Seguro que desea eliminar dicha direccion");
					Optional<ButtonType> res = al.showAndWait();
					if (res.get() == ButtonType.OK) {
						throw new ErrorConfirmacion();

					} else {
						this.Cancelar();
					}
				} catch (ErrorConfirmacion e) {
					Main.usuarioRestaurante.eliminarDireccion(direEliminar);
					try {
						this.ejecutar();
					} catch (AlertaConfirmacion e1) {
					}
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
		for (int i = 0; i < criterios.length; i++) {
			fp.setValue(criterios[i]);
		}
	}
	
	public String toString() {
		return "Eliminar direccion restaurante";
	}
}
