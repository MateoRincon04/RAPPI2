package BaseDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
	
	private static final String filepathPerfil = "perfilesGuardados.json";
	private static final String filepathRestaurantes = "restaurantesGuardados.json";
	/*
	 * se usa al principio del Main para cargar el file con la base de datos de perfiles
	 */
	public static File cargarFileDataBasePerfil() throws IOException {
		File DataBase = new File(filepathPerfil);
		if(DataBase.exists()) {
			System.out.println("La dataBasePerfil se ha cargado correctamente");
		}else {
			System.out.println("La dataBasePerfil se ha creado correctamente");
			JsonArray array = new JsonArray();
			try(FileWriter fw = new FileWriter(filepathPerfil) ){
				fw.write(array.toString());
				fw.flush();
			}catch(IOException e) {
				e.printStackTrace();
			}
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
			JsonArray array = new JsonArray();
			try(FileWriter fw = new FileWriter(filepathPerfil) ){
				fw.write(array.toString());
				fw.flush();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return DataBase;
	}
	/*
	 * trae la base de datos de perfiles desde su file
	 */
	public static JsonArray traerDataBasePerfil(){
		JsonParser jp = new JsonParser();
		try (FileReader fr = new FileReader(filepathPerfil)){
			Object obj = jp.parse(fr);
			JsonArray array = (JsonArray) obj;
			return array;
		}catch(Exception ex) {
			System.out.println("No se puede traer la dataBasePerfil correctamente");
			return null;
		}
	}
	/*
	 * trae la base de datos de restaurantes desde su file
	 */
	public static JsonArray traerDataBaseRestaurante() {
		JsonParser jp = new JsonParser();
		try (FileReader fr = new FileReader(filepathRestaurantes)){
			Object obj = jp.parse(fr);
			JsonArray array = (JsonArray) obj;
			return array;
		}catch(Exception ex) {
			System.out.println("No se puede traer la dataBaseRestaurantes correctamente");
			return null;
		}
	}
	/*
	 * se usa para actualizar las bases de datos de perfiles
	 */
	public static void actualizarDataBasePerfil(JsonArray array) {
		try(FileWriter fw = new FileWriter(filepathPerfil) ){
			fw.write(array.toString());
			fw.flush();
		}catch(IOException e) {
			System.out.println("No se puede actualizar la dataBasePerfil correctamente");
			e.printStackTrace();
		}
	}
	/*
	 * se usa para actualizar las bases de datos de restaurantes
	 */
	public static void actualizarDataBaseRestaurante(JsonArray array) {
		try(FileWriter fw = new FileWriter(filepathRestaurantes) ){
			fw.write(array.toString());
			fw.flush();
		}catch(IOException ex) {
			System.out.println("No se puede actualizar la dataBaseRestaurante correctamente");
		}
	}
	/*
	 * se usa para agregar objetos a la base de datos de perfiles
	 */
	public static boolean agreagarObjetoDataBasePerfil(Perfil obj) {
		Gson gson = new Gson();
		String aux = gson.toJson(obj);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBasePerfil();
		if(!dataBase.contains(je)) {
			dataBase.add(je);
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
		Gson gson = new Gson();
		String aux = gson.toJson(obj);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBaseRestaurante();
		if(!dataBase.contains(je)) {
			dataBase.add(je);
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
		Gson gson = new Gson();
		String aux = gson.toJson(obj);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBasePerfil();
		if(dataBase.contains(je)) {
			dataBase.remove(je);
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
		Gson gson = new Gson();
		String aux = gson.toJson(obj);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBaseRestaurante();
		if(dataBase.contains(je)) {
			dataBase.remove(je);
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
		JsonArray dataBase =Data.traerDataBasePerfil();
		Iterator<JsonElement> iter = dataBase.iterator(); 
		while(iter.hasNext()) {
			if(userName.equals(((Perfil) iter).getUserName())) {
				perfil =(Perfil) iter;
			}
		}
		return perfil;
	}
	
	public static Perfil buscarUsuario(String userName, String clave) {
		Perfil perfil= null;
		JsonArray dataBase =Data.traerDataBasePerfil();
		Iterator<JsonElement> iter = dataBase.iterator(); 
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
		JsonArray dataBase =Data.traerDataBaseRestaurante();
		Iterator<JsonElement> iter = dataBase.iterator(); 
		while(iter.hasNext()) {
			if(userName.equals(((Restaurante) iter).getNombre())) {
				restaurante =(Restaurante) iter;
			}
		}
		return restaurante;
	}
	/*
	 * organiza los restaurantes de mayor a menor segun calificacion
	 
	public static ArrayList<Restaurante> OrganizarRestaurantesPorCalificacion(){
		JsonArray historial = Data.traerDataBaseRestaurante();
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
	*/
}
