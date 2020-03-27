package UIMain.Cliente;

import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import UIMain.Restaurante.RestauranteEscena;
import gestorAplicacion.Interaccion.Cliente;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Clase PlatosQueMasCompre, su finalidad es la de ser aquella clase que permita la
 * implementacion de opcionDeMenu y ejecute cierta funcionalidad
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon
 */
public class PlatosQueMasCompre extends OpcionDeMenu {
	Cliente usuarioUno;
	public void ejecutar() {
		usuarioUno = EscenaCliente.cliente;
		String tituloCriterios = "Platos que más he comprado: ";
		String[] criterios = new String[1];
		criterios[0]="El plato que usted más ha comprado es:";
		
		String tituloValores = "Usuario "+usuarioUno.getNombre();
		String[] valores = new String[1];
		valores[0]=usuarioUno.platoMasComprado();
		boolean[] habilitado = new boolean[1];
		habilitado[0]=false;

		FieldPanel fp = new FieldPanel(tituloCriterios,criterios,tituloValores,valores,habilitado);
		GridPane bonito = new GridPane();
		Label desc = new Label("Funcionalidad para saber cuales son los platos que más ha comprado el cliente: ");
		desc.setAlignment(Pos.CENTER);
		Label nom = new Label(Data.getOpciones().get(8).toString());
		nom.setAlignment(Pos.CENTER);
		nom.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		desc.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		bonito.add(new Label("                                                                                                                        "), 0, 0);
		bonito.add(new Label("                                                                                                                        "), 0, 2);
		bonito.add(new Label("                                                                                                                        "), 0, 1);
		bonito.add(nom, 1, 0);
		bonito.add(desc, 1, 1);
		bonito.add(fp, 1, 2);
		EscenaCliente.root.setCenter(bonito);
	}
		//String nomPlato = usuarioUno.platoMasComprado();
		//System.out.println("El plato más comprado es: " + nomPlato);
		//MenuDeConsola.lanzarMenu((Cliente)Main.usuario);
	//}

	public String toString() {
		return "Platos que más compré";
	}
}
