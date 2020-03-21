package UIMain.Restaurante;

import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Oferta.Restaurante;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CrearPlato extends OpcionDeMenu {
	public void ejecutar() {
		String tituloCriterios = "Criterios: ";
		String[] criterios = new String[] { "Nombre: ", "Descripcion: ", "Precio: ", "Restriccion de edad: " };
		String tituloValores = "Valor: ";
		String[] valores = new String[] { "", "", "", "" };
		boolean[] habilitado = new boolean[] { true, true, true, true };
		FieldPanel fp = new FieldPanel(tituloCriterios, criterios, tituloValores, valores, habilitado);
		GridPane bonito = new GridPane();
		Label desc = new Label("Funcionalidad para crear un plato para el restaurante: ");
		desc.setAlignment(Pos.CENTER);
		Label nom = new Label(Data.getOpciones().get(15).toString());
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
		
		if (!Main.usuarioRestaurante.getMenu().equals("")) {

			Alert a = new Alert(AlertType.ERROR);
			a.setContentText("El restaurante ya cuenta con su plato, si desea cambiar de plato porfavor seleccione la opcion Cambiar Plato Restaurante");
			for(int i = 0; i<criterios.length; i++) {
				fp.setValue(criterios[i]);
			}
			
		} else {

			String nombre = fp.getValue(criterios[0]);
			String descripcion = fp.getValue(criterios[1]);
			String precio = fp.getValue(criterios[2]);
			String restriccion = fp.getValue(criterios[3]);
			Main.usuarioRestaurante.crearPlato(nombre, descripcion, Integer.getInteger(precio), Integer.getInteger(restriccion));

		}
		
		
		

		Restaurante restaurante = Main.usuarioRestaurante;
		System.out.println("Ingresará un nuevo plato a su menú.");
		System.out.println("Ingrese el nombre: ");
		String nombre = Main.user.next();
		System.out.println("Ingrese la descripción del plato: ");
		String descripcion = Main.user.next();
		System.out.println("Ingrese el precio: ");
		int precio = Main.user.nextInt();
		System.out.println("ingrese la restriccion de edad del plato: ");
		int restriccion = Main.user.nextInt();
		boolean valor = true;
		if (!restaurante.getMenu().equals("")) {
			valor = false;
		} else {
			valor = restaurante.crearPlato(nombre, descripcion, precio, restriccion);
		}
		if (!valor) {
			System.out.println(
					"El restaurante ya cuenta con su plato, si desea cambiar de plato porfavor seleccione la opcion Cambiar Plato Restaurante");
			MenuDeConsola.lanzarMenu(Main.usuarioRestaurante);
		} else {
			System.out.println("Su plato se ha creado correctamente.");
		}
		MenuDeConsola.lanzarMenu(Main.usuarioRestaurante);
	}

	public String toString() {
		return "Crear Plato Restaurante";
	}
}
