package UIMain;

import BaseDatos.Data;
import Oferta.*;
import Interaccion.*;

import java.io.EOFException;
import java.util.Scanner;

import Administracion.*;

public class Main {

	public static Perfil usuario;
	public static Scanner user = new Scanner(System.in);

	public static void main(String[] args){
		Data.CargarOpciones();
		MenuDeConsola menuPrrrrr = new MenuDeConsola();
		menuPrrrrr.lanzarMenu();
		user.close();
		
	}


}
