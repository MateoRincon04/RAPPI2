package UIMain;

import java.util.Scanner;
import Interaccion.Cliente;
import BaseDatos.Data;

/**
 * Clase Registrarse
 * 
 * su finalidad es la implementacion  de Registrarse en el sistema a partir de la opcion del menu
 * 
 * 
 * 
 * @author: Guillermo Toloza
 * @version:
 */

//para usar la base de datos necesito el main, as� poder acceder a ella y comparar y/o agregar usuarios
//que se van a registrar
public class Registrarse extends OpcionDeMenu {
	public void FinalizarRegistroCliente (Cliente cliente) { 
		if ((data.readPerfilFromFile(cliente))==null){   //no se como acceder a la base de datos jeje
			data.writePerfilToFile(cliente);
			System.out.println("Ha sido registrado en el sistema.");
		}else {
			System.out.println("Usted ya est� registrado en el sistema");
		}
	}
	public void ejecutar() {
		
		Scanner user = new Scanner(System.in);
		System.out.println("Usted ser� registrado en el sistema.");
		System.out.println("Ingrese su nombre: ");
		String nombre=user.nextLine();
		System.out.println("Ingrese su Username: ");
		String username=user.nextLine();
		System.out.println("Ingrese su metodo de pago: ");
		String metodoDePago=user.nextLine();
		System.out.println("Ingrese el n�mero de su comuna: ");
		int comuna=user.nextInt();
		System.out.println("Ingrese su clave: ");
		int clave= user.nextInt();
		System.out.println("Ingrese su tel�fono ");
		int telefono= user.nextInt();
		System.out.println("Ingrese su saldo: ");
		long saldo= user.nextLong();
		Cliente cliente=new Cliente(nombre,telefono,comuna,clave,username,saldo,metodoDePago);
		FinalizarRegistroCliente(cliente);
		
		
	}
}
