package UIMain.Cliente;

import BaseDatos.Data;
import UIMain.FieldPanel;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Interaccion.Cliente;
import java.util.ArrayList;
import gestorAplicacion.Oferta.Restaurante;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Clase MejorRestauranteCal, su finalidad es la de ser aquella clase que permita la implementacion de opcionDeMenu y ejecute cierta funcionalidad 
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon
 */
public class MejorRestauranteCal extends OpcionDeMenu {
	Cliente usuarioUno;
	public void ejecutar() {
		usuarioUno = EscenaCliente.cliente;
		String tituloCriterios = "Mejor restaurante calificado: ";
		String[] criterios = new String[2];
		criterios[0]="El restaurante mejor calificado de los actualmente disponibles es:";
		criterios[1]="Con una calificación promediada de: ";
		Restaurante res = Data.OrganizarRestaurantesPorCalificacion();
		String tituloValores = "restaurante: ";
		String[] valores = new String[2];
		if(res != null) {
			valores[0]=res.getNombre(); //hay que conectar bien.
		}else {
			valores[0]= "No se ha calificado ningun restaurante"; //hay que conectar bien.
		}
		
		valores[1]=String.valueOf(res.getCalificacionPromediada());
		boolean[] habilitado = new boolean[2];
		habilitado[0]=false;
		habilitado[1]=false;

		FieldPanel fp = new FieldPanel(tituloCriterios,criterios,tituloValores,valores,habilitado);
		GridPane bonito = new GridPane();
		Label desc = new Label("Funcionalidad para saber cual es el mejor restaurante calificado de los disponibles: ");
		desc.setAlignment(Pos.CENTER);
		Label nom = new Label(Data.getOpciones().get(7).toString());
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
		
		
		
		
		
		
		
		
		/*System.out.println("El mejor restaurante por su calificacion es: ");
		Restaurante res = Data.OrganizarRestaurantesPorCalificacion();
		System.out.println(res.getNombre());
		System.out.println("");
		MenuDeConsola.lanzarMenu((Cliente)Main.usuario);
	}
	*/
	public String toString() {
		return "Mejor restaurante";
	}
}
