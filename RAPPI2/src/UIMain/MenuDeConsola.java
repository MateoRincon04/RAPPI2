package UIMain;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import Interaccion.*;
import Administracion.*;
import BaseDatos.Data;
/**
 * Clase MenuDeConsola
 * tiene como finalidad desplegar el menu de consola que se requiere para este trabajo
 * y asi tener una interfaz de interaccion para el usuario
 * 
 * Estructuras revelantes
 * ------------------
 * 
 * @author:Guillermo Toloza
 * @version:
 */

public class MenuDeConsola{  //Se desplega cada vez que se vaya a crear un menu diferente. El tamano
    //varia dependiendo de las opciones de cada menu.
    static ArrayList<OpcionDeMenu> menu = Data.getOpciones();
        
    public void AnadirOpcion(OpcionDeMenu OpcionMenu) {
    }
    
    public static void lanzarMenu() {
    	boolean pri = true;
    	while(1+1==2) {
    		if (pri) {
    			for(int i = 0; i<3; i++) {
    				System.out.println(i+1 + ") " + menu.get(i));
    			}
    		}
    		System.out.println("oprima el numero indicado, de la funcion que deseas realizar");
    		int opc = Main.user.nextInt();
    		menu.get(opc-1).ejecutar();
    		
    		break;
    	}
    }
    static long readLong() {
    	return Main.user.nextLong();
    }
    static String readString() {
    	Main.user.nextLine();
    	return Main.user.nextLine();
    }
//jeje

}