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

public class AgregarSaldo extends OpcionDeMenu {
	public void ejecutar() {
		
		Cliente cliente = (Cliente) Main.usuario;
		
		String tituloCriterios = "Direcciones: ";
		String[] criterios = new String[Main.usuarioRestaurante.getDireccion().size()];
		for(int cr = 0; cr<criterios.length; cr++) {
			criterios[cr] = "Direccion: ";
		}
		String tituloValores = "Valor: ";
		String[] valores = new String[Main.usuarioRestaurante.getDireccion().size()];
		for(int cr = 0; cr<valores.length; cr++) {
			valores[cr] = Main.usuarioRestaurante.getDireccion().get(cr);
		}
		boolean[] habilitado = new boolean[Main.usuarioRestaurante.getDireccion().size()];
		for(int cr = 0; cr<habilitado.length; cr++) {
			habilitado[cr] = false;
		}
		
		
		FieldPanel fp = new FieldPanel(tituloCriterios,criterios,tituloValores,valores,habilitado);
		
		
		GridPane bonito = new GridPane();
		Label desc = new Label("Funcionalidad para saber y agregar saldo: ");
		desc.setAlignment(Pos.CENTER);
		Label nom = new Label(Data.getOpciones().get(9).toString());
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
		
		
		
		
		
		
		
		
		System.out.println("Usted añadirá saldo a su cuenta: ");
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
		MenuDeConsola.lanzarMenu((Cliente)Main.usuario);
	}

	public String toString() {
		return "Agregar Saldo";
	}
}
