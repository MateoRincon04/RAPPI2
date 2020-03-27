package UIMain.Cliente;

import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import UIMain.Excepciones.AccionExitosa;
import UIMain.Excepciones.ErrorCancelar;
import gestorAplicacion.Interaccion.Cliente;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

/**
 * Clase CalificarRestaurante, su finalidad es la de ser aquella clase que
 * permita la implementacion de opcionDeMenu y ejecute cierta funcionalidad
 * 
 * @author Guillermo Toloza, Paula A. Taborda, Santiago Tamayo, Mateo Rincon
 */
public class CalificarRestaurante extends OpcionDeMenu {
	private String tituloCriterios = "Criterios: ";
	private String[] criterios = new String[] { "Ingrese la calificación al restaurante que preparó su pedido:", "Ingrese el nombre del restaurante que preparó su pedido:" };
	private String tituloValores = "Calificación: ";
	private String[] valores = new String[] { "","" };
	private boolean[] habilitado = new boolean[] { true,true };
	private FieldPanel fp = new FieldPanel(tituloCriterios, criterios, tituloValores, valores, habilitado);
	Cliente usuario;

	public void ejecutar() {

		usuario = EscenaCliente.cliente;
		GridPane bonito = new GridPane();
		Label desc = new Label("Funcionalidad para calificar a un restaurante que preparó el pedido a un cliente: ");
		desc.setAlignment(Pos.CENTER);
		Label nom = new Label(Data.getOpciones().get(5).toString());
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
		EscenaCliente.root.setCenter(bonito);
	}

	public void Aceptar() {
		try {
			try {

				double calificacion = Double.parseDouble((fp.getValue(fp.criterios[0])));
				String restaurante = fp.getValue(fp.criterios[1]);
				if (calificacion >= 0 && calificacion <= 5) {
					usuario.calificarRestaurante(calificacion, restaurante);
					throw new AccionExitosa();

				} else {
					throw new ErrorCancelar();
				}
			} catch (AccionExitosa a) {
				Alert b = new Alert(AlertType.INFORMATION);
				b.setContentText(a.getMessage());
				b.show();
				this.Cancelar();
			} catch (Exception e) {
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
	}

	/*
	 * System.out.
	 * println("Ingrese una calificacion del 0 al 5 al restaurante que realizó su pedido: "
	 * ); Double calificacion = Main.user.nextDouble(); Boolean valor = false; if
	 * (calificacion >= 0 && calificacion <= 5) {
	 * usuario.calificarRestaurante(calificacion);
	 * System.out.println("Ha calificado al restaurante correctamente."); valor =
	 * true;
	 * 
	 * } else { System.out.println("Ingrese una calificación valida."); valor =
	 * false; } if (valor) { MenuDeConsola.lanzarMenu((Cliente) Main.usuario); }
	 * else { ejecutar(); } }
	 */
	public String toString() {
		return "Calificar Restaurante";
	}
}
