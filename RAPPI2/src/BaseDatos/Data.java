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
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import UIMain.*;
import Interaccion.Cliente;

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
    	opciones.add(new EnCualesDirecciones());
    	opciones.add(new CuantosPedidosHeEntregado());
    		   	
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
		if(Data.traerDataBasePerfil()!=null) {
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
		if(Data.traerDataBasePerfil()!=null) {
			System.out.println("La dataBaseRestaurantes se ha cargado correctamente");
		}else {
			System.out.println("La dataBaseRestaurantes se ha creado correctamente");
			JsonArray array = new JsonArray();
			try(FileWriter fw = new FileWriter(filepathRestaurantes) ){
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
	public static void agregarObjetoDataBasePerfil(Perfil obj) {
		Gson gson = new Gson();
		String aux = gson.toJson(obj);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBasePerfil();
		if(!dataBase.contains(je)) {
			dataBase.add(je);
			Data.actualizarDataBasePerfil(dataBase);
		}
		else {
			System.out.println("no se puede agregar el elemento a la base de datos");
		}
	}
	/*
	 * se usa para agregar objetos a la base de datos de perfiles
	 */
	public static void agregarObjetoDataBaseRestaurante(Restaurante obj) {
		Gson gson = new Gson();
		String aux = gson.toJson(obj);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBaseRestaurante();
		if(!dataBase.contains(je)) {
			dataBase.add(je);
			Data.actualizarDataBaseRestaurante(dataBase);
		}
		else {
			System.out.println("no se puede agregar el elemento a la base de datos");
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
		Gson gson = new Gson();
		Perfil perfil= null;
		JsonArray dataBase =Data.traerDataBasePerfil(); 
		for (JsonElement jsonElement : dataBase) {
			JsonObject obj = jsonElement.getAsJsonObject();
			if(userName.equals(obj.get("userName").getAsString())) {
				perfil = gson.fromJson(obj, Perfil.class);
			}
		}
		return perfil;
	}
	
	public static Perfil buscarUsuario(String userName, String clave) {
		Perfil perfil= null;
		Gson gson = new Gson();
		JsonArray dataBase =Data.traerDataBasePerfil();
		for (JsonElement jsonElement : dataBase) {
			JsonObject obj = jsonElement.getAsJsonObject();
			if(userName.equals(obj.get("userName").getAsString()) && clave.equals(obj.get("clave").getAsString())) {
				perfil = gson.fromJson(obj, Perfil.class) ;
			}
		}
		return perfil;
	}
	/*
	 * buscar un restaurante en la base de datos de restaurante
	 */
	
	public static Restaurante buscarRestaurante(String userName) {
		Restaurante restaurante= null;
		Gson gson = new Gson();
		JsonArray dataBase =Data.traerDataBaseRestaurante();
		for (JsonElement jsonElement : dataBase) {
			JsonObject obj = jsonElement.getAsJsonObject();
			if(userName.equals(obj.get("userName").getAsString())) {
				restaurante = gson.fromJson(obj, Restaurante.class) ;
			}
		}
		return restaurante;
	}
	/*
	 * organiza los restaurantes de mayor a menor segun calificacion
	 */
	public static ArrayList<Restaurante> OrganizarRestaurantesPorCalificacion(){
		Gson gson = new Gson();
		JsonArray historial = Data.traerDataBaseRestaurante();
		ArrayList<Restaurante> best = new ArrayList<Restaurante>();
		// bubble sort
				boolean ordenado = false;
				while (!ordenado) {
					ordenado = true;
					for (int i = 0; i < historial.size(); i++) {
						Restaurante aux1 = gson.fromJson(historial.get(i), Restaurante.class) ;
						Restaurante aux2 = gson.fromJson(historial.get(i-1), Restaurante.class) ;
						if (aux1.getCalificacionPromediada() < aux2.getCalificacionPromediada()) {
							Restaurante restauranteTemp = aux1;
							best.add(i, aux1);
							best.add(i - 1, restauranteTemp);
							ordenado = false;
						}
					}
				}
				return best;
	}
	
}