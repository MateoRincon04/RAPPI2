package UIMain;

import java.util.Scanner;
import Interaccion.Cliente;

public class Invitado extends OpcionDeMenu {
	void ejecutar() {

		Scanner user = new Scanner(System.in);
		// Datos necesarios= direccion de envio, metodo de pago, saldo y comuna
		while (true) {
			try {
				System.out.println("Ingrese la direcci�n del env�o: ");
				String direccion = user.nextLine();
				System.out.println("Ingrese su metodo de pago: ");
				String metodo = user.nextLine();
				System.out.println("Ingrese el saldo para pagar su pedido : ");
				int saldoTemporal = user.nextInt();
				System.out.println("Ingrese el numero de la comuna donde reside: ");
				int comunaTemporal = user.nextInt();
				Cliente invitado = new Cliente("Invitado", 0, comunaTemporal, 0, "Invitado,", saldoTemporal, metodo);
				Main.usuario = invitado;
			} catch (Exception e) {
				System.out.println("Error al ingresar datos necesarios. Por favor intente nuevamente.");
			}
		}
		
		
		// Siento que podr�a dar una inconsistencia si alg�n impedido se nombra como Cliente registrado "Invitado"
		//�C�mo corrijo eso?
		
					
	}
}
