package BaseDatos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import UIMain.*;

import Administracion.Perfil;
import Oferta.Restaurante;
import UIMain.OpcionDeMenu;

public class Data {
	
    private static List<OpcionDeMenu> opciones = new ArrayList<>();
    
    public static final void CargarOpciones() {
    	opciones.add(new HacerPedido());
    	opciones.add(new CalificarTendero());
    	opciones.add(new CalificarRestaurante());
    	opciones.add(new CuantoHeGastado());
    	opciones.add(new CuantosPedidosHeEntregado());
    	opciones.add(new EnCualesDirecciones());
    	opciones.add(new Invitado());
    	opciones.add(new login());
    	opciones.add(new MejorRestauranteCal());
    	opciones.add(new PlatosQueMasCompre());
    	opciones.add(new Registrarse());    	
    }
    
    public static final List<OpcionDeMenu> getOpciones(){
    	return opciones;
    }
	
	private static final String filepathPerfil = "C:\\Users\\mythe\\git\\repository\\RAPPI2\\temp\\datosPersonal";
	//private static final String filepathPlatos = "C:\\Users\\mythe\\git\\repository\\RAPPI2\\temp\\platos";
	/* lo comente porque no se para que sirve
	 */
	private static final String filepathRestaurantes = "C:\\Users\\mythe\\git\\repository\\RAPPI2\\temp\\restaurantes";
	
	
	/*
	 * se usa para crear la dataBasePerfil
	 */
	public static void CrearDataBasePefil() {
		try {
			ArrayList<Perfil> dataBase = new ArrayList<> ();
			FileOutputStream fout = new FileOutputStream(filepathPerfil);
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(dataBase);
			out.close();
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
	}
	/*acceder a la DataBasePerfil dentro del file
	 */
	public static ArrayList<Perfil> traerDataBasePerfil() {
		try { 
			FileInputStream fin = new FileInputStream(filepathPerfil);
			ObjectInputStream ois = new ObjectInputStream(fin);
			ArrayList<Perfil> dataBase = (ArrayList<Perfil>) ois.readObject();
            System.out.println("The Object has been read from the file");
            return dataBase;
 
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
	}
	/*
	 * actualizar la dataBasePerfil
	 */
	public static void actualizarDataBasePerfil(ArrayList<Perfil> dataBase) {
		try {
			FileOutputStream fout = new FileOutputStream(filepathPerfil);
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(dataBase);
			out.close();
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
	/*
	 * Agregar objeto a la dataBasePerfil
	 */
	public static boolean agreagarObjetoDataBasePerfil(Perfil obj) {
		ArrayList<Perfil> dataBase = Data.traerDataBasePerfil();
		if(!dataBase.contains(obj)) {
			dataBase.add(obj);
			Data.actualizarDataBasePerfil(dataBase);
			return true;
		}
		else {
			System.out.println("no se puede agregar el elemento a la base de datos");
			return false;
		}
	}
	/*
	 * eliminar objeto de la dataBasePerfil
	 */
	public static void eliminarObjetoDataBasePerfil(Perfil obj) {
		ArrayList<Perfil> dataBase = Data.traerDataBasePerfil();
		if(dataBase.contains(obj)) {
			dataBase.remove(obj);
			Data.actualizarDataBasePerfil(dataBase);
		}
		else {
			System.out.println("no se puede eliminar el elemento a la base de datos");
		}
	}
	/*
	 * buscar un usuario en la base de datos de perfil
	 */
	
	public static Perfil buscarUsuario(String userName, int clave) {
		Perfil perfil= null;
		ArrayList<Perfil> dataBase =Data.traerDataBasePerfil();
		Iterator<Perfil> iter = dataBase.iterator(); 
		while(iter.hasNext()) {
			if(userName.equals(((Perfil) iter).getUserName())&& clave==((Perfil) iter).getClave()) {
				perfil =(Perfil) iter;
			}
		}
		return perfil;
	}
	
	/*
	 * se usa para crear la dataBaseRestaurante
	 */
	public static void CrearDataBaseRestaurante() {
		try {
			ArrayList<Restaurante> dataBase = new ArrayList<> ();
			FileOutputStream fout = new FileOutputStream(filepathRestaurantes);
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(dataBase);
			out.close();
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
	}
	
	/*acceder a la DataBasePerfil dentro del file
	 */
	public static ArrayList<Restaurante> traerDataBaseRestaurante() {
		try { 
			FileInputStream fin = new FileInputStream(filepathRestaurantes);
			ObjectInputStream ois = new ObjectInputStream(fin);
			ArrayList<Restaurante> dataBase = (ArrayList<Restaurante>) ois.readObject();
            System.out.println("The Object has been read from the file");
            return dataBase;
 
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
	}
	/*
	 * actualizar la dataBasePerfil
	 */
	public static void actualizarDataBaseRestaurante(ArrayList<Restaurante> dataBase) {
		try {
			FileOutputStream fout = new FileOutputStream(filepathRestaurantes);
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(dataBase);
			out.close();
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
	/*
	 * Agregar objeto a la dataBasePerfil
	 */
	public static void agreagarObjetoDataBaseRestaurante(Restaurante obj) {
		ArrayList<Restaurante> dataBase = Data.traerDataBaseRestaurante();
		if(!dataBase.contains(obj)) {
			dataBase.add(obj);
			Data.actualizarDataBaseRestaurante(dataBase);
		}
		else {
			System.out.println("no se puede agregar el elemento a la base de datos");
		}
	}
	/*
	 * eliminar objeto de la dataBasePerfil
	 */
	public static void eliminarObjetoDataBaseRestaurante(Restaurante obj) {
		ArrayList<Restaurante> dataBase = Data.traerDataBaseRestaurante();
		if(dataBase.contains(obj)) {
			dataBase.remove(obj);
			Data.actualizarDataBaseRestaurante(dataBase);
		}
		else {
			System.out.println("no se puede eliminar el elemento a la base de datos");
		}
	}
	/*
	 * buscar un usuario en la base de datos de perfil
	 */
	
	public static Restaurante buscarRestaurante(String userName) {
		Restaurante restaurante= null;
		ArrayList<Restaurante> dataBase =Data.traerDataBaseRestaurante();
		Iterator<Restaurante> iter = dataBase.iterator(); 
		while(iter.hasNext()) {
			if(userName.equals(((Restaurante) iter).getNombre())) {
				restaurante =(Restaurante) iter;
			}
		}
		return restaurante;
	}
	
	public static ArrayList<Restaurante> OrganizarRestaurantesPorCalificacion(){
		ArrayList<Restaurante> historial = Data.traerDataBaseRestaurante();
		// bubble sort
				boolean ordenado = false;
				while (!ordenado) {
					ordenado = true;
					for (int i = 0; i < historial.size(); i++) {
						if ((historial.get(i)).getCalificacionPromediada() < (historial.get(i - 1)).getCalificacionPromediada()) {
							Restaurante restauranteTemp = historial.get(i);
							historial.add(i, historial.get(i - 1));
							historial.add(i - 1, restauranteTemp);
							ordenado = false;
						}
					}
				}
				return historial;
	}
}


