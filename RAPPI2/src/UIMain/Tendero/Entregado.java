package UIMain.Tendero;

import java.util.ArrayList;

import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Main;
import UIMain.OpcionDeMenu;
import UIMain.Excepciones.ErrorCancelar;
import gestorAplicacion.Interaccion.Notificacion;
import gestorAplicacion.Interaccion.Tendero;
import gestorAplicacion.Oferta.Pedido;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

public class Entregado extends OpcionDeMenu {

	private String tituloCriterios = "Pedido en Curso: ";
	private String[] criterios = new String[] { "Nombre: ", "Restaurante: " };
	private String tituloValores = "Valor: ";
	private String[] valores;
	private boolean[] habilitado = new boolean[] { false, false };
	private FieldPanel fp;
	private Tendero usu = (Tendero) Main.usuario;

	public void ejecutar() {

		String nomRes = Data.buscarPedido(usu.getPedido()).getRestaurante();
		String nomPlato = Data.buscarPedido(usu.getPedido()).getPlato();
		valores = new String[] { nomPlato, nomRes };
		fp = new FieldPanel(tituloCriterios, criterios, tituloValores, valores, habilitado);

		GridPane bonito = new GridPane();
		Label desc = new Label("Funcionalidad para dar por terminado el pedido que tengo a cargo");
		desc.setAlignment(Pos.CENTER);
		Label nom = new Label(Data.getOpciones().get(30).toString());
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
		TenderoEscena.root.setCenter(bonito);
	}

	public void Aceptar() {
		try {
			if (usu.getPedido() == -1) {
				throw new ErrorCancelar();
			} else {
				usu.setPedido(-1);
				usu.setEstaDisponible();
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
		return "Terminar pedido";
	}
}
