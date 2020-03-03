package UIMain;

import BaseDatos.Data;
import Oferta.Restaurante;

import java.io.IOException;
import java.util.Scanner;
import Administracion.*;

/**
 * Clase Main, su finalidad es la de ejecutar el codigo entero
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon
 */
public class Main {

	public static Perfil usuario = null;
	public static Restaurante usuarioRestaurante = null;
	public static Scanner user = new Scanner(System.in);

	public static void main(String[] args) throws IOException{
		Data.CargarOpciones();
		Data.cargarFileDataBaseAdministrador();
		Data.cargarFileDataBaseCliente();
		Data.cargarFileDataBaseTendero();
		Data.cargarFileDataBaseRestaurante();
		//Data.agregarObjetoDataBaseAdministrador(new Administrador("Admin", 1, 10, "Admin", "Admin", 5000));
		MenuDeConsola.lanzarMenu();
		user.close();
		
	}
}
