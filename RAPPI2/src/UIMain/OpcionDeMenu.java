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
public abstract class OpcionDeMenu {
	ArrayList<OpcionDeMenu> menuObjetos = new ArrayList();
	
	//desde el menú se accede a la opción uno
	//posicion 0. guarda la funcionalidad "registrarse" si el usuario escoge esa, se ejecuta
	//la funcionalidad.
	abstract void ejecutar();
	
	
}



//ligadura estática: si no sobreescribo un metodo del hijo y el padre, agarro directamente el del padre
//ligadura dinámica: si sobreescribo un metodo del padre y el apuntador es padre pero apunta a hijo, priorizo
//el metodo del hijo.


//debo crear una clase por cada funcionalidad.
//Creo una lista que contenga los objetos (funcionalidades) para ejecutar. Luego el usuario pide la acción 
//por numeros. 
//le resto uno y tengo el indice de la acción en la lista. debo crear una clase por cada acción para que
//por ligadura dinámica, se ejecute el metodo ejecutar de cada clase. cumpliendo así lo que busca el usuario.
//opcion de menu debe ser padre de todas las clases que heredan.