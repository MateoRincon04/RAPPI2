package UIMain.Tendero;

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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class cambiarContraseņaTendero extends OpcionDeMenu {
	
	String[] criterios;
	FieldPanel fp;
	GridPane bonito;

	public void ejecutar() throws AlertaConfirmacion {

		try {
			String tituloCriterios = "Contraseņas: ";
			criterios = new String[3];
			criterios[0] = "Contraseņa actual: ";
			criterios[1] = "Nueva contraseņa: ";
			criterios[2] = "Confirmar nueva contraseņa: ";
			String tituloValores = "Valor: ";
			String[] valores = new String[3];
			valores[0] = "";
			valores[1] = "";
			valores[2] = "";
			boolean[] habilitado = new boolean[3];
			habilitado[0] = true;
			habilitado[1] = true;
			habilitado[2] = true;

			fp = new FieldPanel(tituloCriterios, criterios, tituloValores, valores, habilitado);
			bonito = new GridPane();
			Label desc = new Label("Funcionalidad para cambiar la contraseņa del usuario: ");
			desc.setAlignment(Pos.CENTER);
			Label nom = new Label(Data.getOpciones().get(13).toString());
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
			TenderoEscena.root.setCenter(bonito);
		} catch (Exception e) {
			throw new AlertaConfirmacion();
		}
	}

	public void Aceptar() {
		String conVieja = fp.getValue(fp.criterios[0]);
		String conNueva = fp.getValue(fp.criterios[1]);
		String conFNueva = fp.getValue(fp.criterios[2]);
		try {
			if (Main.usuario.getClave().equals(conVieja)) {

				try {
					if (conNueva.equals(conFNueva)) {
						Alert al = new Alert(AlertType.CONFIRMATION);
						al.setContentText("Seguro que desea realizar este cambio");
						Optional<ButtonType> res = al.showAndWait();
						if (res.get() == ButtonType.OK) {
							throw new ErrorConfirmacion();

						} else {
							this.Cancelar();
						}
					} else {
						throw new ErrorCancelar();
					}

				} catch (ErrorConfirmacion e) {
					Main.usuario.setClave(conNueva);
					Label r = new Label("Usted cambio su clave de: " +conVieja + " por su nueva clave: " + conNueva);
					r.setAlignment(Pos.CENTER);
					r.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
					r.setFont(new Font("Arial", 15));
					bonito.add(r, 1, 3);
					bonito.add(new Label(
							"                                                                                                                        "),
							0, 3);
					TenderoEscena.root.getChildren().remove(bonito);
					TenderoEscena.root.setCenter(bonito);
					this.Cancelar();

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
		fp.setValue(criterios[1]);
		fp.setValue(criterios[2]);
	}

	public String toString() {
		return "Cambiar contraseņa tendero";
	}
}
