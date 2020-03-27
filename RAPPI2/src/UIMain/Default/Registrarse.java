package UIMain.Default;

import gestorAplicacion.Administracion.Administrador;
import gestorAplicacion.Interaccion.Cliente;
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
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Main;
import UIMain.OpcionDeMenu;
import UIMain.Administrador.AdministradorScene;
import UIMain.Cliente.EscenaCliente;
import UIMain.Excepciones.ErrorCancelar;
import UIMain.Excepciones.ErrorExistente;

/**
 * Clase Registrarse
 * 
 * su finalidad es la implementacion de Registrarse en el sistema a partir de la
 * opcion del menu
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon * 
 */

public class Registrarse extends OpcionDeMenu {
	
	String tituloCriterios = "Datos";
	String[] criterios = {"Nombre","UserName","Clave","Telefono","Comuna","Saldo","Direccion","Metodo de pago"};
	String tituloValores = "Valor: ";
	String[] valores = {"","","","","","","",""};
	Label descripcion = new Label("Usted será registrado en el sistema.");
	FieldPanel fp = new FieldPanel(tituloCriterios,criterios,tituloValores,valores,null);
	public void ejecutar() {
		GridPane bonito = new GridPane();
		bonito.setVgap(20);
		bonito.setPadding(new Insets(100,10,10,10));
		Label desc = new Label("Registrarse");
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
		InterfazInicio.P3.setCenter(bonito);

	}
	public void Aceptar() {
		try {
			if (Data.buscarCliente(fp.getValue(fp.criterios[1]))!=null) {
			throw new ErrorExistente();
		} else {
			String nombre = fp.getValue(fp.criterios[0]);
			String userName = fp.getValue(fp.criterios[1]);
			String clave = fp.getValue(fp.criterios[2]);
			String telefono = fp.getValue(fp.criterios[3]);
			String comuna = fp.getValue(fp.criterios[4]);
			String saldo = fp.getValue(fp.criterios[5]);
			String direccion = fp.getValue(fp.criterios[6]);
			String metodopago = fp.getValue(fp.criterios[7]);
			
			if(nombre.equals("")||userName.equals("")||clave.equals("")||telefono.equals("")||comuna.equals("")||saldo.equals("")||direccion.equals("")||metodopago.equals("")) {
				throw new ErrorCancelar();
			}
			if(isNumeric(telefono)==false) {
				Alert al = new Alert(AlertType.WARNING);
				al.setContentText("El telefono debe tener solo numeros");
				al.show();
			}
			 if(isNumeric(saldo)==false ) {
				Alert al = new Alert(AlertType.WARNING);
				al.setContentText("El saldo debe tener solo numeros");
				al.show();
			}
			 if(Integer.valueOf(saldo)<0) {
					Alert al = new Alert(AlertType.WARNING);
					al.setContentText("El saldo debe ser mayor que cero");
					al.show();
				}
			 if(!metodopago.equals("efectivo")||!metodopago.equals("tarjeta")) {
					Alert al = new Alert(AlertType.WARNING);
					al.setContentText("El metodo de pago debe ser efectivo o tarjeta");
					al.show();
				}
			else {
				try {
					int tel = Integer.valueOf(telefono);
					int com = Integer.valueOf(comuna);
					int sal = Integer.valueOf(saldo);
					Alert a = new Alert(AlertType.CONFIRMATION);
					a.setContentText("seguro que desea registrarse "+ userName+" ?");
					Optional<ButtonType> result = a.showAndWait();
					if(result.get()==ButtonType.OK) {
						Cliente cliente = new Cliente(nombre, tel, com, clave, userName, sal, metodopago, direccion);
						cliente = (Cliente) Main.usuario;
						Data.agregarObjetoDataBaseCliente(cliente);
						EscenaCliente cli = new EscenaCliente();
						InterfazInicio.setScene(cli.getScene());
					}
				}catch(Exception e2) {
					throw new ErrorCancelar();
				}
				this.Cancelar();
				}
			}
		}catch(ErrorExistente e1) {
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText(e1.getMessage());
			a.show();
			this.Cancelar();
		}
		catch (ErrorCancelar e) {
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
		return "Registrarse";
	}
	
	private static boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
}
