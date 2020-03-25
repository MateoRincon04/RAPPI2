package UIMain.Administrador;

import java.util.Optional;

import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import UIMain.Excepciones.AlertaConfirmacion;
import UIMain.Excepciones.ErrorCancelar;
import UIMain.Excepciones.ErrorConfirmacion;
import gestorAplicacion.Administracion.Administrador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class cambiarContraseñaAdmin extends OpcionDeMenu {
	String tituloCriterios = "Datos";
	String[] criterios = {"Contraseña actual: ","Nueva contraseña: ","Confirmar nueva contraseña: "};
	String tituloValores = "Valor: ";
	String[] valores = {"","",""};
	Label descripcion = new Label("Usted cambiara su contraseña");
	FieldPanel fp = new FieldPanel(tituloCriterios,criterios,tituloValores,valores,null);
	Administrador admin ;
	public void ejecutar() throws AlertaConfirmacion {
		 // funcion unica del Admin
		try {
			admin = AdministradorScene.usuario;
			GridPane bonito = new GridPane();
			bonito.setVgap(20);
			bonito.setPadding(new Insets(100,10,10,10));
			Label desc = new Label("Cambiar contraseña administrador");
			desc.setFont(new Font("Arial",15));
			desc.setBorder(new Border(new BorderStroke(Color.GREY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
			desc.setAlignment(Pos.CENTER);
			desc.setTextFill(Color.BLACK);
			desc.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			descripcion.setBorder(new Border(new BorderStroke(Color.GREY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
			descripcion.setAlignment(Pos.CENTER);
			descripcion.setTextFill(Color.BLACK);
			descripcion.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			bonito.add(desc, 0, 0);
			bonito.add(descripcion, 0, 1);
			bonito.add(fp, 0, 2);
			bonito.setAlignment(Pos.TOP_CENTER);
			AdministradorScene.root.setCenter(bonito);
		}catch (Exception e) {
			throw new AlertaConfirmacion();
		}
	}
	
	public void Aceptar() {
		String conVieja = fp.getValue(fp.criterios[0]);
		String conNueva = fp.getValue(fp.criterios[1]);
		String conFNueva = fp.getValue(fp.criterios[2]);
		try {
			if (admin.getClave().equals(conVieja)) {

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
					admin.setClave(conNueva);
					try {
						this.ejecutar();
					} catch (AlertaConfirmacion al) {
						Alert ala = new Alert(AlertType.ERROR);
						ala.setContentText(al.getMessage());
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
		fp.setValue(criterios[0]);
		fp.setValue(criterios[1]);
		fp.setValue(criterios[2]);
	}

	public String toString() {
		return "Cambiar contraseña administrador";
	}
}
