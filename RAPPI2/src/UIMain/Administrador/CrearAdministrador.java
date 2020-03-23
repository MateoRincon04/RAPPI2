package UIMain.Administrador;

import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Main;
import UIMain.OpcionDeMenu;
import UIMain.Excepciones.ErrorCancelar;
import gestorAplicacion.Administracion.Administrador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
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
	String tituloCriterios = "Datos";
	String[] criterios = {"Nombre","UserName","Clave","Telefono","Comuna","Salario"};
	String tituloValores = "Valor: ";
	String[] valores = {"","","","","",""};
	Label descripcion = new Label("Usted ingresará un nuevo Administrador en el sistema.");
	FieldPanel fp = new FieldPanel(tituloCriterios,criterios,tituloValores,valores,null);
	Administrador admin = AdministradorScene.usuario;
	
	public void ejecutar() {
		GridPane bonito = new GridPane();
		bonito.setVgap(20);
		bonito.setPadding(new Insets(100,10,10,10));
		Label desc = new Label("Crear Administrador ");
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
	}
	
	public void Aceptar() {
		try {
			if (Data.buscarAdministrador(fp.getValue(fp.criterios[1]))!=null) {
			throw new ErrorCancelar();
		} else {
			String nombre = fp.getValue(fp.criterios[0]);
			String userName = fp.getValue(fp.criterios[1]);
			String clave = fp.getValue(fp.criterios[2]);
			String telefono = fp.getValue(fp.criterios[3]);
			String comuna = fp.getValue(fp.criterios[4]);
			String salario = fp.getValue(fp.criterios[5]);
			int tel = Integer.valueOf(telefono);
			int com = Integer.valueOf(comuna);
			int sal = Integer.valueOf(salario);
			admin.crearAdministrador(nombre, tel, com, clave, userName, sal);
			this.Cancelar();
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
		return "Crear Administrador";
	}

}
