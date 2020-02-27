package UIMain;

import java.util.Scanner;
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
        OpcionDeMenu[] Menu = new OpcionDeMenu[size];        
    }
    public void AnadirOpcion(OpcionDeMenu OpcionMenu) {
    }
    
    public String LanzarMenu() {
    	return 
    }
    static Scanner teclado = new Scanner(System.in);
    static long readLong() {
    	return teclado.nextLong();
    }
    static String readString() {
    	teclado.nextLine();
    	return teclado.nextLine();
    }


    public static void main (String args[]) {
    	MenuDeConsola MenuInicio = new MenuDeConsola(3); //Size: , registro, cliente, cliente sin registrar
    	
	
    }
}