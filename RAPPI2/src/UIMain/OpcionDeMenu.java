package UIMain;
import java.util.ArrayList;
import Interaccion.Cliente;

/**
 * Clase OpcionDeMenu
 * su finalidad es la implementacion de las diferentes interfaces dinamicas con sus
 * respectivas funcionalidades
 * 
 * Estructuras revelantes
 * --------------------------------------------------
 * 
 * @author: Guillermo Toloza
 * @version:
 */

public interface OpcionDeMenu {
	
	//desde el men� se accede a la opci�n uno
	//posicion 0. guarda la funcionalidad "registrarse" si el usuario escoge esa, se ejecuta
	//la funcionalidad.
	void ejecutar();
	
	
}



//ligadura est�tica: si no sobreescribo un metodo del hijo y el padre, agarro directamente el del padre
//ligadura din�mica: si sobreescribo un metodo del padre y el apuntador es padre pero apunta a hijo, priorizo
//el metodo del hijo.


/*debo crear una clase por cada funcionalidad.
Creo una lista que contenga los objetos (funcionalidades) para ejecutar. Luego el usuario pide la acci�n 
por numeros. 
le resto uno y tengo el indice de la acci�n en la lista. debo crear una clase por cada acci�n para que
por ligadura din�mica, se ejecute el metodo ejecutar de cada clase. cumpliendo as� lo que busca el usuario.
opcion de menu debe ser padre de todas las clases que heredan.*/