package UIMain.Restaurante;

import BaseDatos.Data;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;

public class EliminarPlato extends OpcionDeMenu {
	public void ejecutar() {
		System.out.println("Eliminará su plato del menu");
		System.out.println("Esta seguro que desea eliminarlo, ingrese 1 confirmando el borrado, o ingrese 0 para cancelar");
		int opc = Main.user.nextInt();
		if(opc == 1) {
			if(!Main.usuarioRestaurante.getMenu().equals("")) {
				Data.eliminarObjetoDataBasePlato(Data.buscarPlato(Main.usuarioRestaurante.getMenu()));
				Main.usuarioRestaurante.setMenu("");
				Data.actualizarDataBaseRestaurante(Main.usuarioRestaurante);
				System.out.println("Plato borrado");
				MenuDeConsola.lanzarMenu(Main.usuarioRestaurante);
			}
			
		}
		else {
			System.out.println("Operacion cancelada");
			MenuDeConsola.lanzarMenu(Main.usuarioRestaurante);
		}
	}

	public String toString() {
		return "Eliminar plato";
	}
}
