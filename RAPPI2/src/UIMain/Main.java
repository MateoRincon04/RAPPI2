package UIMain;

import BaseDatos.Data;
import Oferta.*;
import Interaccion.*;

import java.io.EOFException;
import java.io.IOException;
import java.util.Scanner;

import Administracion.*;

public class Main {

	public static Perfil usuario;
	public static Scanner user = new Scanner(System.in);

	public static void main(String[] args) throws IOException{
		Data.CargarOpciones();
		Data.cargarFileDataBasePerfil();
		MenuDeConsola menuPrrrrr = new MenuDeConsola();
		menuPrrrrr.lanzarMenu();
		user.close();
		
	}
}
