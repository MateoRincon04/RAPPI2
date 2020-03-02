package UIMain;

import Interaccion.Cliente;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import BaseDatos.Data;

/**
 * Clase Registrarse
 * 
 * su finalidad es la implementacion de Registrarse en el sistema a partir de la
 * opcion del menu
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon * 
 */

public class Registrarse implements OpcionDeMenu {

	public void ejecutar() {

		System.out.println("Usted sera registrado en el sistema.");
		System.out.println("Ingrese su nombre: ");
		String nombre = Main.user.next();
		System.out.println("Ingrese su Username: ");
		String username = Main.user.next();
		System.out.println("Ingrese su metodo de pago (efectivo,tarjeta): ");
		String metodoDePago;
		while (true) {
			metodoDePago = Main.user.next();
			if(metodoDePago.equals("efectivo")||metodoDePago.equals("tarjeta")) {
				break;
				}
			else {
				System.out.println("Ingrese una opcion valida");
				}
			}
		System.out.println("Ingrese el numero de su comuna: ");
		int comuna = Main.user.nextInt();
		System.out.println("Ingrese su clave: ");
		String clave = Main.user.next();
		System.out.println("Ingrese su telefono: ");
		int telefono = Main.user.nextInt();
		System.out.println("Ingrese su saldo: ");
		long saldo = Main.user.nextLong();
		System.out.println("Ingrese su direccion: ");
		String direccion = Main.user.next();
		Cliente cliente = new Cliente(nombre, telefono, comuna, clave, username, saldo, metodoDePago, direccion);
		Gson gson = new Gson();
		String aux = gson.toJson(cliente);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBaseCliente();
		if (!dataBase.contains(je)) {
			Data.agregarObjetoDataBaseCliente(cliente); 
			System.out.println("Usuario creado exitosamente ");
			Main.usuario = cliente;
		} else {
			System.out.println("Usuario ya existente, por favor ingrese de nuevo ");
			ejecutar();
		}
	}
	public String toString() {
		return "Registrarse";
	}
}
