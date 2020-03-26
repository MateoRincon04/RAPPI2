package UIMain.Default;

import gestorAplicacion.Administracion.*;
import gestorAplicacion.Interaccion.Cliente;
import gestorAplicacion.Interaccion.Tendero;
import gestorAplicacion.Oferta.Restaurante;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;

import java.util.Optional;

import BaseDatos.Data;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import UIMain.Excepciones.AlertaConfirmacion;
import UIMain.Restaurante.RestauranteEscena;
import UIMain.Tendero.TenderoEscena;

/**
 * Clase login
 * 
 * su finalidad es la implementacion de Loguearse en el sistema a partir de la
 * opcion del menu
 * 
 * @author: Guillermo Toloza, Paula A. Taborda, Mateo Rincon, Santiago Tamayo
 */

public class login extends OpcionDeMenu {

	public void ejecutar() {

		Label user = new Label("Username: ");
		Label clave = new Label("Clave: ");
		TextField us = new TextField("");
		TextField cl = new TextField("");
		Button ac = new Button("Aceptar");
		Button can = new Button("Cancelar");
		HBox hb = new HBox(user, us, clave, cl, ac, can);
		hb.setPadding(new Insets(5));
		InterfazInicio.P3.setTop(hb);
		
		ac.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				String usu = us.getText();
				String cla = cl.getText();
				if(usu.equals("") || cla.equals("")) {
					Alert al = new Alert(AlertType.ERROR);
					al.setContentText("Ingrese los valores necesarios para realizar un inicio de sesion");
					al.show();
				}else {
					if(Data.buscarAdministrador(usu, cla) != null) {
						Main.usuario = Data.buscarAdministrador(usu);
						//InterfazInicio.setScene();
					}else if(Data.buscarCliente(usu, cla) != null) {
						Main.usuario = Data.buscarCliente(usu);
						//InterfazInicio.setScene();
					}else if(Data.buscarTendero(usu, cla) != null) {
						Main.usuario = Data.buscarTendero(usu);
						TenderoEscena ten= new TenderoEscena();
						InterfazInicio.setScene(ten.getScene());
					}else if(Data.buscarRestaurante(usu, cla) != null) {
						Main.usuarioRestaurante = Data.buscarRestaurante(usu);
						RestauranteEscena res= new RestauranteEscena();
						InterfazInicio.setScene(res.getScene());
					}else {
						Alert al = new Alert(AlertType.ERROR);
						al.setContentText("No se encotro usuario con dichos datos");
						al.show();
					}
				}
				us.setText("");
				cl.setText("");
				
			}
		});
		
		can.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				us.setText("");
				cl.setText("");
				InterfazInicio.P3.getChildren().remove(hb);
				InterfazInicio.P3.setTop(InterfazInicio.f1);
				
			}
		});
		
	}

	public String toString() {
		return "Log In";
	}
}