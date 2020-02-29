package BaseDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import UIMain.*;
import Administracion.Perfil;
import Oferta.Restaurante;
import UIMain.OpcionDeMenu;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class Data {
	
    private static ArrayList<OpcionDeMenu> opciones = new ArrayList<>();
    
    public static final void CargarOpciones() {
    	opciones.add(new Registrarse());
    	opciones.add(new login());
    	opciones.add(new Invitado());
    	opciones.add(new HacerPedido());
    	opciones.add(new CalificarTendero());
    	opciones.add(new CalificarRestaurante());
    	opciones.add(new CuantoHeGastado());
    	opciones.add(new MejorRestauranteCal());
    	opciones.add(new PlatosQueMasCompre());
    	opciones.add(new CuantosPedidosHeEntregado());
    	opciones.add(new EnCualesDirecciones());	   	
    }
    
    public static final ArrayList<OpcionDeMenu> getOpciones(){
    	return opciones;
    }
	
	private static final String filepathPerfil = "temp\\perfilesGuardados.json";
	private static final String filepathRestaurantes = "temp\\restaurantesGuardados.json";
	/*
	 * se usa al principio del Main para cargar el file con la base de datos de perfiles
	 */
	public static File cargarFileDataBasePerfil() throws IOException {
		File DataBase = new File(filepathPerfil);
		if(DataBase.exists()) {
			System.out.println("La dataBasePerfil se ha cargado correctamente");
		}else {
			System.out.println("La dataBasePerfil se ha creado correctamente");
			Gson gson = new Gson();
			ArrayList<Perfil> arreglo = new ArrayList<>();
			BufferedWriter bw = new BufferedWriter(new FileWriter(DataBase));
			bw.write(gson.toJson(arreglo));
			bw.close();
		}
		return DataBase;
	}
	/*
	 * se usa al principio del Main para cargar el file con la base de datos de restaurantes
	 */
	public static File cargarFileDataBaseRestaurante() throws IOException {
		File DataBase = new File(filepathRestaurantes);
		if(DataBase.exists()) {
			System.out.println("La dataBaseRestaurante se ha cargado correctamente");
		}else {
			System.out.println("La dataRestaurante se ha creado correctamente");
			Gson gson = new Gson();
			ArrayList<Perfil> arreglo = new ArrayList<>();
			BufferedWriter bw = new BufferedWriter(new FileWriter(DataBase));
			bw.write(gson.toJson(arreglo));
			bw.close();
		}
		return DataBase;
	}
	/*
	 * trae la base de datos de perfiles desde su file
	 */
	public static ArrayList<Perfil> traerDataBasePerfil() {
		try {
			Gson gson = new Gson();
			BufferedReader br = new BufferedReader(new FileReader(Data.cargarFileDataBasePerfil()));
			ArrayList<Perfil> perfiles = (ArrayList<Perfil>) gson.fromJson(br,new TypeToken<ArrayList<Perfil>>() {}.getType());
			br.close();
			return perfiles;
		}catch(Exception ex) {
			System.out.println("No se puede traer la dataBasePerfil correctamente");
			return null;
		}
	}
	/*
	 * trae la base de datos de restaurantes desde su file
	 */
	public static ArrayList<Restaurante> traerDataBaseRestaurante() {
		try {
			Gson gson = new Gson();
			BufferedReader br = new BufferedReader(new FileReader(Data.cargarFileDataBaseRestaurante()));
			ArrayList<Restaurante> restaurantes = (ArrayList<Restaurante>) gson.fromJson(br,new TypeToken<ArrayList<Restaurante>>() {}.getType());
			br.close();
			return restaurantes;
		}catch(Exception ex) {
			System.out.println("No se puede traer la dataBaseRestaurante correctamente");
			return null;
		}
	}
	/*
	 * se usa para actualizar las bases de datos de perfiles
	 */
	public static void actualizarDataBasePerfil(ArrayList<Perfil> arreglo) {
		try {
			Gson gson = new Gson();
			BufferedWriter bw = new BufferedWriter(new FileWriter(Data.cargarFileDataBasePerfil()));
			bw.write(gson.toJson(arreglo));
			bw.close();
		}catch(Exception ex) {
			System.out.println("No se puede actualizar la dataBasePerfil correctamente");
		}
	}
	/*
	 * se usa para actualizar las bases de datos de restaurantes
	 */
	public static void actualizarDataBaseRestaurante(ArrayList<Restaurante> arreglo) {
		try {
			Gson gson = new Gson();
			BufferedWriter bw = new BufferedWriter(new FileWriter(Data.cargarFileDataBaseRestaurante()));
			bw.write(gson.toJson(arreglo));
			bw.close();
		}catch(Exception ex) {
			System.out.println("No se puede actualizar la dataBaseRestaurante correctamente");
		}
	}
	/*
	 * se usa para agregar objetos a la base de datos de perfiles
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
	 * se usa para agregar objetos a la base de datos de perfiles
	 */
	public static boolean agreagarObjetoDataBaseRestaurante(Restaurante obj) {
		ArrayList<Restaurante> dataBase = Data.traerDataBaseRestaurante();
		if(!dataBase.contains(obj)) {
			dataBase.add(obj);
			Data.actualizarDataBaseRestaurante(dataBase);
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
	 * eliminar objeto de la dataBaseRestaurante
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
	 * buscar un usuario en la base de datos de perfil con sobrecarga
	 */
	
	public static Perfil buscarUsuario(String userName) {
		Perfil perfil= null;
		ArrayList<Perfil> dataBase =Data.traerDataBasePerfil();
		Iterator<Perfil> iter = dataBase.iterator(); 
		while(iter.hasNext()) {
			if(userName.equals(((Perfil) iter).getUserName())) {
				perfil =(Perfil) iter;
			}
		}
		return perfil;
	}
	
	public static Perfil buscarUsuario(String userName, String clave) {
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
	 * buscar un restaurante en la base de datos de restaurante
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
	/*
	 * organiza los restaurantes de mayor a menor segun calificacion
	 */
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

