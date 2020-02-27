package UIMain;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import Interaccion.*;
import Administracion.*;
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

    public MenuDeConsola(int size){
        ArrayList<OpcionDeMenu> menu = new ArrayList<>();        
    }
    public void AnadirOpcion(OpcionDeMenu OpcionMenu) {
    }
    
    public void LanzarMenu() {
    	return 
    }
    static long readLong() {
    	return Main.user.nextLong();
    }
    static String readString() {
    	Main.user.nextLine();
    	return Main.user.nextLine();
    }
//jeje

    public static void main (String args[]) {
    	MenuDeConsola MenuInicio = new MenuDeConsola(3); //Size: , registro, cliente, cliente sin registrar
    	
	
    }
}