package UIMain.Tendero;

import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Main;
import UIMain.OpcionDeMenu;
import UIMain.Excepciones.ErrorCancelar;
import gestorAplicacion.Interaccion.Tendero;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class Entregado extends OpcionDeMenu {

	private String tituloCriterios = "Pedido en Curso: ";
	private String[] criterios = new String[] { "Nombre: ", "Restaurante: " };
	private String tituloValores = "Valor: ";
	private String[] valores;
	private boolean[] habilitado = new boolean[] { false, false };
	private FieldPanel fp;
	private Tendero usu;
	GridPane bonito;

	public void ejecutar() {

		usu = (Tendero)Main.usuario;
		if(usu.getPedido() != -1) {
		String nomRes = Data.buscarPedido(usu.getPedido()).getRestaurante();
		String nomPlato = Data.buscarPedido(usu.getPedido()).getPlato();
		valores = new String[] { nomPlato, nomRes };
		}
		else {
			valores = new String[] { "", "" };
		}
		fp = new FieldPanel(tituloCriterios, criterios, tituloValores, valores, habilitado);

		bonito = new GridPane();
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
		usu = TenderoEscena.usuario;
		try {
			if (usu.getPedido() == -1) {
				throw new ErrorCancelar();
			} else {
				usu.setEstaDisponible();
				Data.actualizarDataBaseTendero(usu);
				this.Cancelar();
				Label r = new Label("Usted ha entregado el pedido: " + usu.getPedido() + " al cliente: " + Data.buscarPedido(usu.getPedido()).getCliente());
				r.setAlignment(Pos.CENTER);
				r.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
				r.setFont(new Font("Arial", 15));
				bonito.add(r, 1, 3);
				bonito.add(new Label(
						"                                                                                                                        "),
						0, 3);
				TenderoEscena.root.getChildren().remove(bonito);
				TenderoEscena.root.setCenter(bonito);
				usu.setPedido(-1);

			}

		} catch (ErrorCancelar e) {
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText(e.getMessage());
			a.show();
			this.Cancelar();
		}

	}

	public void Cancelar() {
		usu = TenderoEscena.usuario;
		for (int i = 0; i < criterios.length; i++) {
			fp.setValue(criterios[i]);
		}
	}

	public String toString() {
		return "Terminar pedido";
	}
}
