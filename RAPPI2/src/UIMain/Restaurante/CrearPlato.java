package UIMain.Restaurante;

import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Main;
import UIMain.OpcionDeMenu;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CrearPlato extends OpcionDeMenu {
	private String tituloCriterios = "Criterios: ";
	private String[] criterios = new String[] { "Nombre: ", "Descripcion: ", "Precio: ", "Restriccion de edad: " };
	private String tituloValores = "Valor: ";
	private String[] valores = new String[] { "", "", "", "" };
	private boolean[] habilitado = new boolean[] { true, true, true, true };
	private FieldPanel fp = new FieldPanel(tituloCriterios, criterios, tituloValores, valores, habilitado);

	public void ejecutar() {

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
	}

	public void Aceptar() {
		if (!Main.usuarioRestaurante.getMenu().equals("")) {

			Alert a = new Alert(AlertType.ERROR);
			a.setContentText(
					"El restaurante ya cuenta con su plato, si desea cambiar de plato porfavor seleccione la opcion Cambiar Plato Restaurante");
			a.show();
			for (int i = 0; i < criterios.length; i++) {
				fp.setValue(fp.criterios[i]);
			}

		} else {
			String nombre = fp.getValue(fp.criterios[0]);
			String descripcion = fp.getValue(fp.criterios[1]);
			String precio = fp.getValue(fp.criterios[2]);
			String restriccion = fp.getValue(fp.criterios[3]);
			int pr = Integer.valueOf(precio);
			int res = Integer.valueOf(restriccion);
			Main.usuarioRestaurante.crearPlato(nombre, descripcion, pr, res);
			this.Cancelar();
		}
	}

	public void Cancelar() {
		for (int i = 0; i < criterios.length; i++) {
			fp.setValue(criterios[i]);
		}
	}

	public String toString() {
		return "Crear Plato Restaurante";
	}
}
