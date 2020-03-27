package UIMain.Cliente;

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
import gestorAplicacion.Interaccion.Cliente;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

public class cambiarContraCliente extends OpcionDeMenu {
	String[] criterios;
	FieldPanel fp;
	Cliente cliente;
	public void ejecutar() throws AlertaConfirmacion {
		try {
			cliente = EscenaCliente.cliente;
			String tituloCriterios = "Contrase�as: ";
			criterios = new String[3];
			criterios[0] = "Contrase�a actual: ";
			criterios[1] = "Nueva contrase�a: ";
			criterios[2] = "Confirmar nueva contrase�a: ";
			String tituloValores = "Valor: ";
			String[] valores = new String[3];
			valores[0] = "";
			valores[1] = "";
			valores[2] = "";
			boolean[] habilitado = new boolean[3];
			habilitado[0] = true;
			habilitado[1] = true;
			habilitado[2] = true;

			fp = new FieldPanel(tituloCriterios, criterios, tituloValores, valores, habilitado);
			GridPane bonito = new GridPane();
			Label desc = new Label("Funcionalidad para cambiar la contrase�a del Cliente: ");
			desc.setAlignment(Pos.CENTER);
			Label nom = new Label(Data.getOpciones().get(10).toString());
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
		} catch (Exception e) {
			throw new AlertaConfirmacion();
		}
	}

	public void Aceptar() {
		
		String conVieja = fp.getValue(fp.criterios[0]);
		String conNueva = fp.getValue(fp.criterios[1]);
		String conFNueva = fp.getValue(fp.criterios[2]);
		try {
			if (cliente.getClave().equals(conVieja)) {

				try {
					if (conNueva.equals(conFNueva)) {
						Alert al = new Alert(AlertType.CONFIRMATION);
						al.setContentText("Seguro que desea realizar este cambio");
						Optional<ButtonType> res = al.showAndWait();
						if (res.get() == ButtonType.OK) {
							throw new ErrorConfirmacion();

						} else {
							this.Cancelar();
						}
					} else {
						throw new ErrorCancelar();
					}

				} catch (ErrorConfirmacion e) {
					cliente.setClave(conNueva);
					Data.actualizarDataBaseCliente(cliente);
					try {
						this.ejecutar();
					} catch (AlertaConfirmacion al) {
						Alert ala = new Alert(AlertType.ERROR);
						ala.setContentText(al.getMessage());
					}

				}

			} else {
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
		fp.setValue(criterios[1]);
		fp.setValue(criterios[2]);
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 /*	
	 
	 
	 
	 System.out.println("Ingrese su contrase�a actual: ");
		String contra = Main.user.next();
		if (contra.equals(cliente.getClave())) {
			System.out.println("Ingrese la nueva contrase�a: ");
			String nueva = Main.user.next();
			System.out.println("Ingrese de nuevo la nueva contrase�a: ");
			String nueva2 = Main.user.next();
			if (nueva.equals(nueva2)) {
				cliente.setClave(nueva2);
				System.out.println("Su clave ha sido cambiada correctamente.");
				Data.actualizarDataBaseCliente(cliente);
			} else {
				System.out.println("Las contrase�as no coinciden. intente nuevamente:");
				ejecutar();
			}

		} else {
			System.out.println("Esta no es su contrase�a actual. Intente nuevamente: ");
			ejecutar();
		}
		MenuDeConsola.lanzarMenu((Cliente) Main.usuario);
	}
*/
	public String toString() {
		return "Cambiar contrase�a cliente";
	}
}
