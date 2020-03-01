package UIMain;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import Interaccion.*;
import Administracion.*;
import BaseDatos.Data;

/**
 * Clase MenuDeConsola tiene como finalidad desplegar el menu de consola que se
 * requiere para este trabajo y asi tener una interfaz de interaccion para el
 * usuario
 * 
 * Estructuras revelantes ------------------
 * 
 * @author:Guillermo Toloza
 * @version:
 */

public class MenuDeConsola { // Se desplega cada vez que se vaya a crear un menu diferente. El tamano
	// varia dependiendo de las opciones de cada menu.
	static ArrayList<OpcionDeMenu> menu = Data.getOpciones();

	public void AnadirOpcion(OpcionDeMenu OpcionMenu) {
	}

	public static void lanzarMenu() {
		boolean pri = true;
		while (1 + 1 == 2) {
			if (pri) {
				for (int i = 0; i < 3; i++) {
					System.out.println(i + 1 + ") " + menu.get(i));
				}
				pri = false;
			}
			System.out.println("oprima el numero indicado, de la funcion que deseas realizar");
			String valor;
			while (true) {
				valor = Main.user.next();
				try {
					int opc = Integer.parseInt(valor);
					if (opc > 0 && opc <= 3) {
						menu.get(opc - 1).ejecutar();
						break;
					} else {
						System.out.println("Ingrese un numero valido");
					}
				} catch (Exception e) {
					System.out.println("Ingrese un valor valido.");
				}

			}
			break;
		}
		lanzarMenu();
	}

	public static void lanzarMenu(Perfil usuario) {

		if (usuario instanceof Administrador) {
			// no tenemos definidas funcionalidades del administrador aún

		}

		else if (usuario instanceof Cliente) {
			boolean pri = true;
			while (true) {
				if (pri) {
					for (int i = 3; i < 10; i++) {
						System.out.println(i - 2 + ") " + menu.get(i));
					}
					pri = false;
				}
				System.out.println("oprima el numero indicado, de la funcion que deseas realizar, usuario"
						+ Main.usuario.getNombre());
				String valor;
				while (true) {
					valor = Main.user.next();
					try {
						int opc = Integer.parseInt(valor);
						if (opc > 0 && opc <= 7) {
							menu.get(opc+2).ejecutar();
							break;
						} else {
							System.out.println("Ingrese un numero valido");
						}
					} catch (Exception e) {
						System.out.println("Ingrese un valor valido.");
					}

				}
				break;
			}
		}

		else if (usuario instanceof Tendero) {
			boolean pri = true;
			while (true) {
				if (pri) {

					System.out.println(1 + ") " + menu.get(10));

					pri = false;
				}
				System.out.println("oprima el numero indicado, de la funcion que deseas realizar, tendero"
						+ Main.usuario.getNombre());
				String valor;
				while (true) {
					valor = Main.user.next();
					try {
						int opc = Integer.parseInt(valor);
						if (opc == 1) {
							menu.get(10).ejecutar();
							break;
						} else {
							System.out.println("Ingrese un numero valido");
						}
					} catch (Exception e) {
						System.out.println("Ingrese un valor valido.");
					}

				}
			}

		}

	}
}