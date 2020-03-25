package UIMain.Default;

import gestorAplicacion.Interaccion.Cliente;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Main;
import UIMain.OpcionDeMenu;
import UIMain.Administrador.AdministradorScene;

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
	String[] criterios = {"Nombre","UserName","Clave","Telefono","Comuna","Saldo","Direccion"};
	String tituloValores = "Valor: ";
	String[] valores = {"","","","","","",""};
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
		//AdministradorScene.root.setCenter(bonito);

		System.out.println("Usted sera registrado en el sistema.");
		System.out.println("Ingrese su nombre: ");
		String nombre = Main.user.next();
		System.out.println("Ingrese su Username: ");
		String username = Main.user.next();
		System.out.println("Ingrese su metodo de pago (efectivo,tarjeta): ");
		String metodoDePago;
		while (true) {
			metodoDePago = Main.user.next();
			if(metodoDePago.equals("efectivo")||metodoDePago.equals("tarjeta")) {
				break;
				}
			else {
				System.out.println("Ingrese una opcion valida");
				}
			}
		System.out.println("Ingrese el numero de su comuna: ");
		int comuna = Main.user.nextInt();
		System.out.println("Ingrese su clave: ");
		String clave = Main.user.next();
		System.out.println("Ingrese su telefono: ");
		int telefono = Main.user.nextInt();
		System.out.println("Ingrese su saldo: ");
		long saldo;
		while (true) {
			saldo = Main.user.nextLong();
			if (Cliente.revisarSaldo(saldo) == false) {
				System.out.println("Ingrese un saldo mayor a cero: ");
			}
			else {
				break;
			}
		}
		System.out.println("Ingrese su direccion: ");
		String direccion = Main.user.next();
		Cliente cliente = new Cliente(nombre, telefono, comuna, clave, username, saldo, metodoDePago, direccion);
		Gson gson = new Gson();
		String aux = gson.toJson(cliente);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		ArrayList<Cliente> dataBase = Data.traerDataBaseCliente();
		if (!dataBase.contains(je)) {
			Data.agregarObjetoDataBaseCliente(cliente); 
			System.out.println("Usuario creado exitosamente ");
			Main.usuario = cliente;
		} else {
			System.out.println("Usuario ya existente, por favor ingrese de nuevo ");
			ejecutar();
		}
	}
	public String toString() {
		return "Registrarse";
	}
}
