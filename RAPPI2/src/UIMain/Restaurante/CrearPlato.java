package UIMain.Restaurante;

import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Main;
import UIMain.OpcionDeMenu;
import UIMain.Excepciones.ErrorCancelar;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class CrearPlato extends OpcionDeMenu {
	private String tituloCriterios = "Criterios: ";
	private String[] criterios = new String[] { "Nombre: ", "Descripcion: ", "Precio: ", "Restriccion de edad: " };
	private String tituloValores = "Valor: ";
	private String[] valores = new String[] { "", "", "", "" };
	private boolean[] habilitado = new boolean[] { true, true, true, true };
	private FieldPanel fp = new FieldPanel(tituloCriterios, criterios, tituloValores, valores, habilitado);
	GridPane bonito;

	public void ejecutar() {

		bonito = new GridPane();
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
		try {
			if (!Main.usuarioRestaurante.getMenu().equals("")) {
			throw new ErrorCancelar();

		} else {
			String nombre = fp.getValue(fp.criterios[0]);
			String descripcion = fp.getValue(fp.criterios[1]);
			String precio = fp.getValue(fp.criterios[2]);
			String restriccion = fp.getValue(fp.criterios[3]);
			int pr = Integer.valueOf(precio);
			int res = Integer.valueOf(restriccion);
			Main.usuarioRestaurante.crearPlato(nombre, descripcion, pr, res);
			this.Cancelar();
			Label r = new Label("Usted tiene como plato en su menu un nuevo plato llamado " + nombre);
			r.setAlignment(Pos.CENTER);
			r.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			r.setFont(new Font("Arial", 15));
			bonito.add(r, 1, 3);
			bonito.add(new Label(
					"                                                                                                                        "),
					0, 3);
			RestauranteEscena.root.getChildren().remove(bonito);
			RestauranteEscena.root.setCenter(bonito);
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
		return "Crear Plato Restaurante";
	}
}
