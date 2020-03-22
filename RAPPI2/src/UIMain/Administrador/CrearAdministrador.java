package UIMain.Administrador;

import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Administracion.Administrador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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

public class CrearAdministrador extends OpcionDeMenu {
	public void ejecutar() {
		String tituloCriterios = "Datos";
		String[] criterios = {"Nombre","UserName","Clave","Telefono","Comuna","Salario"};
		String tituloValores = "Valor: ";
		String[] valores = {"Nombre","UserName","Clave","0","0","0"};
		Label descripcion = new Label("Usted ingresará un nuevo Administrador en el sistema.");
		FieldPanel fp = new FieldPanel(tituloCriterios,criterios,tituloValores,valores,null);
		Button ac = new Button("Aceptar");
		Button ca = new Button("Cancelar");
		GridPane aux = (GridPane) fp.getChildren().get(0);
		aux.add(ac, 0, 7);
		aux.add(ca, 1, 7);
		GridPane bonito = new GridPane();
		bonito.setVgap(10);
		bonito.setPadding(new Insets(50,300,10,370));
		Label desc = new Label("Crear administrador ");
		desc.setFont(new Font("Arial",15));
		desc.setBorder(new Border(new BorderStroke(Color.GREY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		desc.setAlignment(Pos.CENTER);
		desc.setTextFill(Color.BLACK);
		desc.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		bonito.add(desc, 0, 0);
		bonito.add(fp, 0, 1);
		AdministradorScene.root.setCenter(bonito);
		Administrador admin = AdministradorScene.usuario;
		ac.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {	
				Alert conf = new Alert(AlertType.NONE);
				boolean valor = admin.crearAdministrador(fp.getValue("Nombre"), Integer.parseInt(fp.getValue("Telefono")), Integer.parseInt(fp.getValue("Comuna")), fp.getValue("Clave"), fp.getValue("UserName"), Long.parseLong(fp.getValue("Salario")));
				if (!valor) {
					conf.setAlertType(AlertType.ERROR);
					conf.setContentText("Administrador ya existente, por favor ingrese de nuevo ");
				}else {
					conf.setAlertType(AlertType.CONFIRMATION);
					conf.setContentText("Administrador creado exitosamente ");
				}
			}
		});
	}

	public String toString() {
		return "Crear Administrador";
	}

}
