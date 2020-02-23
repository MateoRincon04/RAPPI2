package BaseDatos;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import Administracion.Perfil;

public class ContenedorData {
	private static JsonArray dataBase = new JsonArray();
	
	public static JsonArray getDataBase () {
		return dataBase;
	}
	
	public static void agregarObjetoDataBase(Object obj) {
		Gson  gson = new Gson();
		String JSON = gson.toJson(obj);
		dataBase.add(JSON);
	}
	
	public static void eliminarObjetoDataBase(Object obj) {
		Gson  gson = new Gson();
		String JSON = gson.toJson(obj);
		JsonObject jsonO = null;
		if(jsonO.equals(JSON)) {
			dataBase.remove(jsonO);
		}
		else {
			System.out.println("no ha sido encontrado el elemento para eliminarlo");
		}
	}
	
	public static boolean buscarExistenciaObjetoDataBase(Object obj) {
		Gson  gson = new Gson();
		String JSON = gson.toJson(obj);
		for (int i = 0; i < dataBase.size(); i++) {
		        JsonObject jsonO = (JsonObject) dataBase.get(i);
		        if (jsonO.equals(JSON)) {
		        	return true; 
		        }
		}
		return false;
	}
	
	public static Perfil buscarUsuario(String userName, String password) {
		Gson  gson = new Gson();
		for (int i = 0; i < dataBase.size(); i++) {
		        Perfil comparador = gson.fromJson(dataBase.get(i), Perfil.class);
		        if (userName.equals(comparador.getUserName()) && password.equals(comparador.getClave())) {
		        	return comparador; 
		        }
		}
		return null;
	}
	
}
