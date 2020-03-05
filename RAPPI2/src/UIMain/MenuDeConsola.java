package UIMain;

import java.util.ArrayList;
import gestorAplicacion.Interaccion.*;
import gestorAplicacion.Oferta.Restaurante;
import gestorAplicacion.Administracion.*;
import BaseDatos.Data;

/**
 * Clase MenuDeConsola tiene como finalidad desplegar el menu de consola que se
 * requiere para este trabajo y asi tener una interfaz de interaccion para el
 * usuario
 * 
 * 
 * @author Paula A. Taborda, Guillermo Toloza, Santiago Tamayo, Mateo Rincon
 */

public class MenuDeConsola { // Se desplega cada vez que se vaya a crear un menu diferente. El tamano
	// varia dependiendo de las opciones de cada menu.
	static ArrayList<OpcionDeMenu> menu = Data.getOpciones();

	public void AnadirOpcion(OpcionDeMenu OpcionMenu) {
	}

	/**
	 * Metodo para lanzar el menu principal e incial
	 */
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
		try {
			lanzarMenu((Tendero) Main.usuario);
		} catch (Exception e) {
			try {
				lanzarMenu((Cliente) Main.usuario);
			} catch (Exception e1) {
				try {
					lanzarMenu((Restaurante) Main.usuarioRestaurante);
				} catch (Exception e2) {
					try {
						lanzarMenu((Administrador) Main.usuario); // entra a esta opción, no se por qué. Así sale en
																	// debug
						// no se puede hacer ese casteo, tira error.

					} catch (NullPointerException e3) {
						e3.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * Metodo para lanzar el menu siendo ya registrado como Cliente
	 * 
	 * @param usuario El parametro usuario define el cliente que esta usando el menu
	 */
	public static void lanzarMenu(Cliente usuario) {
		boolean pri = true;
		while (true) {
			if (pri) {
				for (int i = 0; i < usuario.opciones.size(); i++) {
					System.out.println(i + 1 + ") " + menu.get(usuario.opciones.get(i)));
				}
				pri = false;
			}
			System.out.println("oprima el numero indicado, de la funcion que deseas realizar, usuario "
					+ Main.usuario.getNombre());
			String valor;
			while (true) {
				valor = Main.user.next();
				try {
					int opc = Integer.parseInt(valor);
					if (opc > 0 && opc <= usuario.opciones.size()) {
						menu.get(usuario.opciones.get(opc - 1)).ejecutar();
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

	/**
	 * Metodo para lanzar el menu siendo ya registrado como Tendero
	 * 
	 * @param usuario El parametro usuario define el cliente que esta usando el menu
	 */
	public static void lanzarMenu(Tendero usuario) {
		boolean pri = true;
		while (true) {
			if (pri) {
				for (int i = 0; i < usuario.opciones.size(); i++) {
					System.out.println(i + 1 + ") " + menu.get(usuario.opciones.get(i)));
				}
				pri = false;
			}
			System.out.println("oprima el numero indicado, de la funcion que deseas realizar, usuario "
					+ Main.usuario.getNombre());
			String valor;
			while (true) {
				valor = Main.user.next();
				try {
					int opc = Integer.parseInt(valor);
					if (opc > 0 && opc <= usuario.opciones.size()) {
						menu.get(usuario.opciones.get(opc - 1)).ejecutar();
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

	/**
	 * Metodo para lanzar el menu siendo ya registrado como Administrador
	 * 
	 * @param usuario El parametro usuario define el cliente que esta usando el menu
	 */
	public static void lanzarMenu(Administrador usuario) {
		System.out.println("Se metio aca");
		boolean pri = true;
		while (true) {

			if (pri) {
				System.out.println("");
				System.out.println("Estas son todas las funcionalidades del sistema: ");
				for (int i = 0; i < menu.size(); i++) {
					System.out.println(menu.get(i));
				}

				System.out.println("");
				System.out.println("");

				for (int i = 16; i < menu.size(); i++) {
					System.out.println(i - 15 + ") " + menu.get(i));
				}
				pri = false;
			}
			System.out.println("oprima el numero indicado, de la funcion que deseas realizar, usuario "
					+ Main.usuario.getNombre());
			String valor;
			while (true) {
				valor = Main.user.next();
				//try {
					int opc = Integer.parseInt(valor);
					if (opc > 0 && opc <= menu.size() - 15) {
						menu.get(opc + 15).ejecutar();
						break;
					} else {
						System.out.println("Ingrese un numero valido");
					}
				//} catch (Exception e) {
			//		System.out.println("Ingrese un valor valido.");
				//}
			}
			break;
		}
	}

	public static void lanzarMenu(Restaurante usuarioR) {
		boolean pri = true;
		while (true) {
			if (pri) {
				for (int i = 0; i < usuarioR.opciones.size(); i++) {
					System.out.println(i + 1 + ") " + menu.get(usuarioR.opciones.get(i)));
				}
				pri = false;
			}
			System.out.println("oprima el numero indicado, de la funcion que deseas realizar, usuario "
					+ Main.usuarioRestaurante.getNombre());
			String valor;
			while (true) {
				valor = Main.user.next();
				try {
					int opc = Integer.parseInt(valor);
					if (opc > 0 && opc <= usuarioR.opciones.size()) {
						menu.get(usuarioR.opciones.get(opc - 1)).ejecutar();
						break;
					} else {
						System.out.println("Ingrese un numero valido");
						lanzarMenu(usuarioR);
					}
				} catch (Exception e) {
					System.out.println("Ingrese un valor valido.");
					lanzarMenu(usuarioR);
				}
			}
			break;
		}
	}
}
