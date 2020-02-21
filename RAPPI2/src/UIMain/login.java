package UIMain;

import java.util.Scanner;

import Administracion.Perfil;
import Interaccion.Cliente;
import BaseDatos.Data;

/**
 * Clase Registrarse
 * 
 * su finalidad es la implementacion de Loguearse en el sistema a partir de la
 * opcion del menu
 * 
 * @author: Guillermo Toloza
 * @version:
 */

public class login extends OpcionDeMenu {

	public void ejecutar() {
<<<<<<< HEAD
		
        Scanner user = new Scanner(System.in);
        while(true){
            try{
                System.out.println("Ingrese su usuario: ");
                String username= user.nextLine();
                System.out.println("Ingrese su clave: ");
                int clave=user.nextInt();
                //Perfil usuario=Data.buscarUsuario(username, clave);
                //Main.usuario = usuario;
                System.out.println("Datos ingresados correctamente");
                break;
                } catch (Exception e) {
                    System.out.println("Error ingresando usuario, intente nuevamente");
            }
        }
    }
}

    
    
=======
>>>>>>> 11078828b1c4d6d09754e601718721fb4346b285

		Scanner user = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("Ingrese su usuario: ");
				String username = user.nextLine();
				System.out.println("Ingrese su clave: ");
				int clave = user.nextInt();
				Perfil usuario = Data.buscarUsuario(username, clave);
				Main.usuario = usuario;
				System.out.println("Datos ingresados correctamente");
				break;
			} catch (Exception e) {
				System.out.println("Error ingresando usuario, intente nuevamente");
			}
		}
	}
}
