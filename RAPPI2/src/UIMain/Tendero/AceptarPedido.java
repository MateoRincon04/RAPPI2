package UIMain.Tendero;

import java.util.ArrayList;

import BaseDatos.Data;
import UIMain.FieldPanel;
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
import javafx.scene.text.Font;

public class AceptarPedido extends OpcionDeMenu {

	private String tituloCriterios = "Pedido pendiente: ";
	private String[] criterios = new String[] { "Nombre: ", "Restaurante: " };
	private String tituloValores = "Valor: ";
	private String[] valores;
	private boolean[] habilitado = new boolean[] { false, false };
	private FieldPanel fp;
	private Tendero usu;
	GridPane bonito;

	public void ejecutar() {
		usu = TenderoEscena.usuario;

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
		bonito = new GridPane();
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
		usu = TenderoEscena.usuario;
		try {
			if (usu.getNotificaciones().size() < 1) {
				throw new ErrorCancelar();
			} else {
				boolean b = usu.aceptarPedido();
				if (b) {
					Notificacion notificacion = Data.buscarNotificacion(usu.getNotificaciones().get(usu.getNotificaciones().size() - 1));
					Pedido pedido = Data.buscarPedido(notificacion.getPedido());
					pedido.setTendero(usu);
					usu.setPedido(pedido.getId());
					pedido.setEntregado();
					ArrayList<Tendero> historial = Data.getdbTendero();
					for (int i = 0; i < historial.size(); i++) {
						historial.get(i).quitarNotificacion();
						Data.actualizarDataBaseTendero(historial.get(i));
					}
					Data.actualizarDataBasePedido(pedido);
					Data.actualizarDataBaseTendero(usu);
					Label r = new Label("Usted esta encargado de el pedido: " + pedido.getId() + " del cliente: " + pedido.getCliente() + " al restaurante: " + pedido.getRestaurante() + " sobre el plato: " + pedido.getPlato());
					r.setAlignment(Pos.CENTER);
					r.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
					r.setFont(new Font("Arial", 15));
					bonito.add(r, 1, 3);
					bonito.add(new Label(
							"                                                                                                                        "),
							0, 3);
					TenderoEscena.root.getChildren().remove(bonito);
					TenderoEscena.root.setCenter(bonito);
					this.Cancelar();
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
		usu = TenderoEscena.usuario;
		for (int i = 0; i < criterios.length; i++) {
			fp.setValue(criterios[i]);
		}
	}


	public String toString() {
		return "Aceptar pedido";
	}
}
