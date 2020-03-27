package UIMain.Cliente;

import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import UIMain.Excepciones.ErrorCancelar;
import UIMain.Restaurante.RestauranteEscena;
import gestorAplicacion.Interaccion.Cliente;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

public class AgregarSaldo extends OpcionDeMenu {
	private String tituloCriterios = "Agregar saldo a su cuenta: ";
	private String[] criterios = new String[] { "Usted agregará más dinero a su cuenta: " };
	private String tituloValores = "Dinero: ";
	private String[] valores = new String[] { "" };
	private boolean[] habilitado = new boolean[] { true };
	private FieldPanel fp = new FieldPanel(tituloCriterios, criterios, tituloValores, valores, habilitado);
	Cliente cliente;
	public void ejecutar() {
		cliente = EscenaCliente.cliente;
		GridPane bonito = new GridPane();
		Label desc = new Label("Funcionalidad para agregar saldo a la cuenta del cliente: ");
		desc.setAlignment(Pos.CENTER);
		Label nom = new Label(Data.getOpciones().get(9).toString());
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
				
				long num = Long.parseLong((fp.getValue(fp.criterios[0])));
				if(num>=0) {
					cliente.agregarSaldo(num);
					Data.actualizarDataBaseCliente(cliente);
					this.Cancelar();
				}else {
					throw new ErrorCancelar();
				}
			}catch(Exception e1) {
				//System.out.println(e1.getMessage());
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
		for (int i = 0; i < criterios.length; i++) {
			fp.setValue(criterios[i]);
		}
	}

		
		
		
		
		
		/*System.out.println("Usted añadirá saldo a su cuenta: ");
		System.out.println("Ingrese la cantidad que va a añadir: ");
		long numero = Main.user.nextInt();
		if (numero >= 0) {
			cliente.agregarSaldo(numero);
			Data.eliminarObjetoDataBaseCliente(Data.buscarCliente(cliente.getUserName()));
			Data.agregarObjetoDataBaseCliente(cliente);
			System.out.println("Ha agregado el saldo nuevo correctamente.");
		} else {
			System.out.println("Ingrese un saldo positivo. Intente nuevamente.");
			ejecutar();
		}
		MenuDeConsola.lanzarMenu((Cliente)Main.usuario);xd
	}
*/
	public String toString() {
		return "Agregar Saldo";
	}
}
