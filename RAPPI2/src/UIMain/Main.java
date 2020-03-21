package UIMain;

import BaseDatos.Data;
import gestorAplicacion.Oferta.Restaurante;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicacion.Administracion.*;

/**
 * Clase Main, su finalidad es la de ejecutar el codigo entero
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon
 */
public class Main {

	public static Perfil usuario;
	public static Restaurante usuarioRestaurante = new Restaurante("MC","calle10","1243412","MC");
	public static Scanner user = new Scanner(System.in);
	public static ArrayList<String> tenderos = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		Data.CargarOpciones();
		Data.cargarFileDataBaseAdministrador();
		Data.cargarFileDataBaseCliente();
		Data.cargarFileDataBaseTendero();
		Data.cargarFileDataBaseRestaurante();
		Data.cargarFileDataBasePlato();
		Data.cargarFileDataBasePedido();
		Data.cargarFileDataCalificacion();
		Data.cargarFileDataNotificacion();
		Data.LlenarTenderos();
		Data.agregarObjetoDataBaseAdministrador(new Administrador("Admin", 1, 10, "Admin", "Admin", 5000));
		MenuDeConsola.lanzarMenu();
		user.close();

	}
}
