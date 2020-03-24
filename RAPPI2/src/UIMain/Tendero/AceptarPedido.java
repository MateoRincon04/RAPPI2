package UIMain.Tendero;

import java.util.ArrayList;

import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import UIMain.Excepciones.ErrorCancelar;
import UIMain.Restaurante.RestauranteEscena;
import gestorAplicacion.Interaccion.Notificacion;
import gestorAplicacion.Interaccion.Tendero;
import gestorAplicacion.Oferta.Pedido;
import gestorAplicacion.Oferta.Plato;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

public class AceptarPedido extends OpcionDeMenu {

	private String tituloCriterios = "Pedido pendiente: ";
	private String[] criterios = new String[] { "Nombre: ", "Restaurante: " };
	private String tituloValores = "Valor: ";
	private String[] valores;
	private boolean[] habilitado = new boolean[] { false, false };
	private FieldPanel fp;
	private Tendero usu = (Tendero) Main.usuario;

	public void ejecutar() {

		if (usu.getNotificaciones().size() < 1) {
			valores = new String[] { "", "" };
			Alert n = new Alert(AlertType.INFORMATION);
			n.setContentText("No tiene pedidos pendientes para aceptar y realizar");
			n.show();

		} else {
			String nomRes = Data.buscarPedido(usu.getNotificaciones().get(usu.getNotificaciones().size() - 1))
					.getRestaurante();
			String nomPlato = Data.buscarPedido(usu.getNotificaciones().get(usu.getNotificaciones().size() - 1))
					.getPlato();
			valores = new String[] { nomPlato, nomRes };
		}
		fp = new FieldPanel(tituloCriterios, criterios, tituloValores, valores, habilitado);
		GridPane bonito = new GridPane();
		Label desc = new Label("Se va a aceptar un pedido, y estare a cargo de la entrega de este");
		desc.setAlignment(Pos.CENTER);
		Label nom = new Label(Data.getOpciones().get(12).toString());
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
			if (usu.getNotificaciones().size() < 1) {
				throw new ErrorCancelar();
			} else {
				+++++
				boolean b = usu.aceptarPedido();
				if (b) {
					Notificacion notificacion = Data.buscarNotificacion(usu.getNotificaciones().get(usu.getNotificaciones().size() - 1));
					Pedido pedido = Data.buscarPedido(notificacion.getPedido());
					pedido.setTendero(usu);
					pedido.setEntregado();
					ArrayList<Tendero> historial = Data.traerDataBaseTendero();
					for (int i = 0; i < historial.size(); i++) {
						historial.get(i).quitarNotificacion();
						Data.actualizarDataBaseTendero(historial.get(i));
					}
					Data.actualizarDataBasePedido(pedido);
					Data.actualizarDataBaseTendero((Tendero) Main.usuario);
					this.ejecutar();
				}

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
		return "Aceptar pedido";
	}
}
