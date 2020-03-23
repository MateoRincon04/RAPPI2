package UIMain.Cliente;

import gestorAplicacion.Interaccion.Cliente;

import java.util.Optional;

import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import UIMain.Excepciones.AlertaConfirmacion;
import UIMain.Excepciones.ErrorCancelar;
import UIMain.Excepciones.ErrorConfirmacion;
import UIMain.Restaurante.RestauranteEscena;
import gestorAplicacion.Oferta.*;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

/**
 * Clase HacerPedido, su finalidad es la de ser aquella clase que permita la
 * implementacion de opcionDeMenu y ejecute cierta funcionalidad
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon
 */
public class HacerPedido extends OpcionDeMenu {
	private String tituloCriterios = "Criterios: ";
	private String[] criterios = new String[] { "El restaurante al cual hará un pedido: " };
	private String tituloValores = "Nombre del restaurante:  ";
	private String[] valores = new String[] { "", };
	private boolean[] habilitado = new boolean[] { true };
	private FieldPanel fp = new FieldPanel(tituloCriterios, criterios, tituloValores, valores, habilitado);
	Cliente usuarioCliente = Data.buscarCliente("guille");

	public void ejecutar() throws AlertaConfirmacion {
		// se esta definiendo la forma como hace el pedido el usuario

		GridPane bonito = new GridPane();
		Label desc = new Label("Funcionalidad para que el cliente haga un pedido: ");
		desc.setAlignment(Pos.CENTER);
		Label nom = new Label(Data.getOpciones().get(3).toString());
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
			String nombre = fp.getValue(fp.criterios[0]);
			Restaurante res = Data.buscarRestaurante(nombre);
			if (res != null) {
				Alert a = new Alert(AlertType.INFORMATION);
				a.setContentText(res.getMenu());
				a.setHeaderText("Este es el plato del menú");
				a.show();
				Alert b = new Alert(AlertType.CONFIRMATION);
				b.setContentText("Está seguro de hacer el pedido al restaurante: " + res.getNombre() + " y el plato "
						+ res.getMenu() + " ?");
				Optional<ButtonType> but = a.showAndWait();
				if (but.get() == ButtonType.OK) {

					Plato plato = escogerPlato(res);
					if (plato != null) {
						usuarioCliente.hacerPedido(plato);
						Alert q = new Alert(AlertType.INFORMATION);
						q.setContentText(res.getMenu());
						q.setHeaderText("Su pedido se ha realizado correctamente");
						q.setTitle("Pedido Exitoso");
						q.show();
						throw new ErrorConfirmacion();

					} else {
						Alert q = new Alert(AlertType.INFORMATION);
						q.setContentText(res.getMenu());
						q.setHeaderText("Este restaurante no cuenta con platos que estén disponibles");
						q.setTitle("Problema al realizar su pedido");
						q.show();
						throw new ErrorCancelar();
					}
				} else {
					this.Cancelar();
				}

			}
			Alert q = new Alert(AlertType.INFORMATION);
			q.setContentText(res.getMenu());
			q.setHeaderText("No existe un restaurante con esos datos.");
			q.setTitle("Problema al realizar su pedido");
			q.show();
			throw new ErrorCancelar();

		} catch (ErrorCancelar e) {
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText(e.getMessage());
			a.show();
			this.Cancelar();
		} catch (ErrorConfirmacion e) {
			try {
				this.ejecutar();
			} catch (AlertaConfirmacion al) {
				Alert ala = new Alert(AlertType.ERROR);
				ala.setContentText(al.getMessage());
			}
		}

	}

	public void Cancelar() {
		for (int i = 0; i < criterios.length; i++) {
			fp.setValue(criterios[i]);
		}
	}

	/*
	 * boolean valor = false;
	 * 
	 * System.out.println("Ingrese el nombre del restaurante a buscar: "); String
	 * nombre = Main.user.next(); String restaurante = null;for( int
	 * i:usuarioCliente.getHistorial()) { if
	 * (Data.buscarPedido(i).getEntregado().equals("noEntegrado")) { restaurante =
	 * Data.buscarPedido(i).getRestaurante(); } }if(restaurante!=null) {
	 * System.out.println("tiene un pedido en curso en " + restaurante);
	 * System.out.println(
	 * "¿Desea volver a hacer un pedido (1) o volver a su menu (2)? Escriba el numero indicado para la opcion que desee."
	 * ); int opc = Main.user.nextInt(); if (opc == 2) {
	 * MenuDeConsola.lanzarMenu((Cliente) Main.usuario); } else { ejecutar(); }
	 * }else { Restaurante restauranteElegido = Data.buscarRestaurante(nombre);
	 * Plato platoEscogido = null; if (restauranteElegido != null) { platoEscogido =
	 * escogerPlato(restauranteElegido); if (platoEscogido != null) { valor =
	 * usuarioCliente.hacerPedido(platoEscogido);
	 * System.out.println("Su pedido se ha realizado correctamente."); } } else {
	 * System.out.println("No se encontro restaurante con este nombre"); }
	 * 
	 * if (!valor && restauranteElegido != null && platoEscogido != null) {
	 * System.out.
	 * println("Usted no cuenta con saldo suficiente para pedir este plato.");
	 * MenuDeConsola.lanzarMenu((Cliente) Main.usuario); } else {
	 * System.out.println(
	 * "¿Desea volver a hacer un pedido (1) o volver a su menu (2)? Escriba el numero indicado para la opcion que desee."
	 * ); int opc = Main.user.nextInt(); if (opc == 2) {
	 * MenuDeConsola.lanzarMenu((Cliente) Main.usuario); } else { ejecutar(); } } }
	 * }
	 */
	/**
	 * Metodo que le permite al cliente escoger que plato desea pedir
	 * 
	 * @param restauranteElegido El parametro restauranteElegido define cual fue el
	 *                           restaurante del cual el cliente selecciono el plato
	 *                           que desea
	 * 
	 * @return El plato que fue seleccionado
	 */
	private Plato escogerPlato(Restaurante restauranteElegido) {
		Plato plato = null;
		System.out.println("Este es el menu de platos con el que cuenta el restaurante.");
		System.out.println(restauranteElegido.getMenu());
		if (restauranteElegido.getMenu().equals("")) {
			System.out.println("Este restaurante no posee platos disponibles");
			return null;
		} else {
			plato = Data.buscarPlato(restauranteElegido.getMenu());
			System.out.println("pedido en proceso");
		}
		return plato;
	}

	public String toString() {
		return "Hacer pedido";
	}
}