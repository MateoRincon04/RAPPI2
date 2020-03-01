package BaseDatos;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import UIMain.*;
import Interaccion.Cliente;
import Interaccion.Tendero;
import Administracion.Administrador;
import Oferta.Restaurante;
import UIMain.OpcionDeMenu;
import com.google.gson.*;

/**
 * La clase Data tiene como finalidad la obtencio y contencion de datos en formato Json
 * para el correcto funcionamiento de la aplicacion.
 * 
 * Estructuras importantes:
 * @see: {@link #opciones}
 * 
 * @author: Santiago Tamayo
 * @version:
 */
public class Data {
	
    private static ArrayList<OpcionDeMenu> opciones = new ArrayList<>();
    
    
    /**
     * Método en el se cargan todas las opciones de menu generales. 
     */
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
	
	private static final String filepathCliente = "temp\\clientesGuardados.json";
	private static final String filepathTendero = "temp\\tenderosGuardados.json";
	private static final String filepathAdministrador = "temp\\administradoresGuardados.json";
	private static final String filepathRestaurantes = "temp\\restaurantesGuardados.json";
	
	/**
	 * Metodo que se usa al principio del Main para cargar el file con la base de datos de clientes
	 * 
	 * @see: {@link #traerDataBaseCliente()}
	 */
	public static File cargarFileDataBaseCliente() throws IOException {
		File DataBase = new File(filepathCliente);
		if(Data.traerDataBaseCliente()!=null) {
			System.out.println("La dataBasePerfil se ha cargado correctamente");
		}else {
			System.out.println("La dataBasePerfil se ha creado correctamente");
			JsonArray array = new JsonArray();
			try(FileWriter fw = new FileWriter(filepathCliente) ){
				fw.write(array.toString());
				fw.flush();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return DataBase;
	}
	
	/**
	 * Metodo que se usa al principio del Main para cargar el file con la base de datos de tenderos
	 * 
	 * @see: {@link #traerDataBaseTendero()}
	 */
	public static File cargarFileDataBaseTendero() throws IOException {
		File DataBase = new File(filepathTendero);
		if(Data.traerDataBaseTendero()!=null) {
			System.out.println("La dataBasePerfil se ha cargado correctamente");
		}else {
			System.out.println("La dataBasePerfil se ha creado correctamente");
			JsonArray array = new JsonArray();
			try(FileWriter fw = new FileWriter(filepathTendero) ){
				fw.write(array.toString());
				fw.flush();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return DataBase;
	}
	
	/**
	 * Metodo que se usa al principio del Main para cargar el file con la base de datos de administradores
	 * 
	 * @see: {@link #traerDataBaseAdministrador()}
	 */
	public static File cargarFileDataBaseAdministrador() throws IOException {
		File DataBase = new File(filepathAdministrador);
		if(Data.traerDataBaseAdministrador()!=null) {
			System.out.println("La dataBasePerfil se ha cargado correctamente");
		}else {
			System.out.println("La dataBasePerfil se ha creado correctamente");
			JsonArray array = new JsonArray();
			try(FileWriter fw = new FileWriter(filepathAdministrador) ){
				fw.write(array.toString());
				fw.flush();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return DataBase;
	}
	
	/**
	 * Metodo que se usa al principio del Main para cargar el file con la base de datos de restaurantes
	 * 
	 * @see: {@link #traerDataBaseRestaurante()}
	 */
	public static File cargarFileDataBaseRestaurante() throws IOException {
		File DataBase = new File(filepathRestaurantes);
		if(Data.traerDataBaseRestaurante()!=null) {
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
	
	/**
	 * Metodo que lee la base de datos de clientes desde su file y obtiene los objetos alli guardados
	 */
	public static JsonArray traerDataBaseCliente(){
		JsonParser jp = new JsonParser();
		try (FileReader fr = new FileReader(filepathCliente)){
			Object obj = jp.parse(fr);
			JsonArray array = (JsonArray) obj;
			return array;
		}catch(Exception ex) {
			System.out.println("No se puede traer la dataBasePerfil correctamente");
			return null;
		}
	}
	
	/**
	 * Metodo que lee la base de datos de tenderos desde su file y obtiene los objetos alli guardados
	 */
	public static JsonArray traerDataBaseTendero(){
		JsonParser jp = new JsonParser();
		try (FileReader fr = new FileReader(filepathTendero)){
			Object obj = jp.parse(fr);
			JsonArray array = (JsonArray) obj;
			return array;
		}catch(Exception ex) {
			System.out.println("No se puede traer la dataBasePerfil correctamente");
			return null;
		}
	}
	
	/**
	 * Metodo que lee la base de datos de administradores desde su file y obtiene los objetos alli guardados
	 */
	public static JsonArray traerDataBaseAdministrador(){
		JsonParser jp = new JsonParser();
		try (FileReader fr = new FileReader(filepathAdministrador)){
			Object obj = jp.parse(fr);
			JsonArray array = (JsonArray) obj;
			return array;
		}catch(Exception ex) {
			System.out.println("No se puede traer la dataBasePerfil correctamente");
			return null;
		}
	}
	
	/**
	 * Metodo que lee la base de datos de restaurantes desde su file para asi obtener aquellos objetos creados previamente
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
	
	/**
	 * Metodo que se usa para actualizar las bases de datos de clientes, escribiendo los nuevos objetos que se necesiten guardar
	 */
	public static void actualizarDataBaseCliente(JsonArray array) {
		try(FileWriter fw = new FileWriter(filepathCliente) ){
			fw.write(array.toString());
			fw.flush();
		}catch(IOException e) {
			System.out.println("No se puede actualizar la dataBasePerfil correctamente");
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que se usa para actualizar las bases de datos de tenderos, escribiendo los nuevos objetos que se necesiten guardar
	 */
	public static void actualizarDataBaseTendero(JsonArray array) {
		try(FileWriter fw = new FileWriter(filepathTendero) ){
			fw.write(array.toString());
			fw.flush();
		}catch(IOException e) {
			System.out.println("No se puede actualizar la dataBasePerfil correctamente");
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que se usa para actualizar las bases de datos de administradores, escribiendo los nuevos objetos que se necesiten guardar
	 */
	public static void actualizarDataBaseAdministrador(JsonArray array) {
		try(FileWriter fw = new FileWriter(filepathAdministrador) ){
			fw.write(array.toString());
			fw.flush();
		}catch(IOException e) {
			System.out.println("No se puede actualizar la dataBasePerfil correctamente");
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que se usa para actualizar las bases de datos de restaurantes, escribiendo aquellos nuevos restaurantes que se vayan a tener en cuenta en la oferta
	 */
	public static void actualizarDataBaseRestaurante(JsonArray array) {
		try(FileWriter fw = new FileWriter(filepathRestaurantes) ){
			fw.write(array.toString());
			fw.flush();
		}catch(IOException ex) {
			System.out.println("No se puede actualizar la dataBaseRestaurante correctamente");
		}
	}
	
	/**
	 * Metodo que se usa para agregar objetos a la base de datos de clientes, convirtiendo asi el objeto a guardar en un JsonElement para
	 * poder insertarlo en el archivo respectivo
	 * 
	 * @see: {@link #traerDataBaseCliente()}
	 * @see: {@link #actualizarDataBaseCliente(JsonArray)}
	 */
	public static void agregarObjetoDataBaseCliente(Cliente obj) {
		Gson gson = new Gson();
		String aux = gson.toJson(obj);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBaseCliente();
		if(!dataBase.contains(je)) {
			dataBase.add(je);
			Data.actualizarDataBaseCliente(dataBase);
		}
		else {
			System.out.println("no se puede agregar el elemento a la base de datos");
		}
	}
	
	/**
	 * Metodo que se usa para agregar objetos a la base de datos de tenderos, convirtiendo asi el objeto a guardar en un JsonElement para
	 * poder insertarlo en el archivo respectivo
	 * 
	 * @see: {@link #traerDataBaseTendero()}
	 * @see: {@link #actualizarDataBaseTendero(JsonArray)}
	 */
	public static void agregarObjetoDataBaseTendero(Tendero obj) {
		Gson gson = new Gson();
		String aux = gson.toJson(obj);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBaseTendero();
		if(!dataBase.contains(je)) {
			dataBase.add(je);
			Data.actualizarDataBaseTendero(dataBase);
		}
		else {
			System.out.println("no se puede agregar el elemento a la base de datos");
		}
	}
	
	/**
	 * Metodo que se usa para agregar objetos a la base de datos de administradores, convirtiendo asi el objeto a guardar en un JsonElement para
	 * poder insertarlo en el archivo respectivo
	 * 
	 * @see: {@link #traerDataBaseAdministrador()}
	 * @see: {@link #actualizarDataBaseAdministrador(JsonArray)}
	 */
	public static void agregarObjetoDataBaseAdministrador(Administrador obj) {
		Gson gson = new Gson();
		String aux = gson.toJson(obj);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBaseAdministrador();
		if(!dataBase.contains(je)) {
			dataBase.add(je);
			Data.actualizarDataBaseAdministrador(dataBase);
		}
		else {
			System.out.println("no se puede agregar el elemento a la base de datos");
		}
	}
	
	/**
	 * Metodo se usa para agregar objetos a la base de datos de restaurante, conviritiendo estos objetos en los JsonElements para 
	 * asi insertarlos a su respectivo archivo
	 * 
	 * @see: {@link #actualizarDataBaseRestaurante(JsonArray)}
	 * @see: {@link #traerDataBaseRestaurante()}
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
	
	/**
	 * Metodo que elimina cierto objeto de la dataBaseCliente
	 * 
	 * @see: {@link #traerDataBaseCliente()}
	 * @see: {@link #actualizarDataBaseCliente(JsonArray)}
	 */
	public static void eliminarObjetoDataBaseCliente(Cliente obj) {
		Gson gson = new Gson();
		String aux = gson.toJson(obj);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBaseCliente();
		if(dataBase.contains(je)) {
			dataBase.remove(je);
			Data.actualizarDataBaseCliente(dataBase);
		}
		else {
			System.out.println("no se puede eliminar el elemento a la base de datos");
		}
	}
	
	/**
	 * Metodo que elimina cierto objeto de la dataBaseTendero
	 * 
	 * @see: {@link #traerDataBaseTendero()}
	 * @see: {@link #actualizarDataBaseTendero(JsonArray)}
	 */
	public static void eliminarObjetoDataBaseTendero(Tendero obj) {
		Gson gson = new Gson();
		String aux = gson.toJson(obj);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBaseTendero();
		if(dataBase.contains(je)) {
			dataBase.remove(je);
			Data.actualizarDataBaseTendero(dataBase);
		}
		else {
			System.out.println("no se puede eliminar el elemento a la base de datos");
		}
	}
	
	/**
	 * Metodo que elimina cierto objeto de la dataBaseAdministrador
	 * 
	 * @see: {@link #traerDataBaseAdministrador()}
	 * @see: {@link #actualizarDataBaseAdministrador(JsonArray)}
	 */
	public static void eliminarObjetoDataBaseAdministrador(Administrador obj) {
		Gson gson = new Gson();
		String aux = gson.toJson(obj);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBaseAdministrador();
		if(dataBase.contains(je)) {
			dataBase.remove(je);
			Data.actualizarDataBaseAdministrador(dataBase);
		}
		else {
			System.out.println("no se puede eliminar el elemento a la base de datos");
		}
	}
	
	/**
	 * Metodo para eliminar cierto objeto de la dataBaseRestaurante
	 * 
	 * @see: {@link #traerDataBaseRestaurante()}
	 * @see: {@link #actualizarDataBaseRestaurante(JsonArray)}
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
	
	/**
	 * Metodo para buscar un usuario en la base de datos de cliente usando solo el userName
	 * 
	 * @see: {@link #traerDataBaseCliente()}
	 */
	
	public static Cliente buscarCliente(String userName) {
		Gson gson = new Gson();
		Cliente cliente= null;
		JsonArray dataBase =Data.traerDataBaseCliente(); 
		for (JsonElement jsonElement : dataBase) {
			JsonObject obj = jsonElement.getAsJsonObject();
			if(userName.equals(obj.get("userName").getAsString())) {
				cliente = gson.fromJson(obj, Cliente.class);
			}
		}
		return cliente;
	}
	
	/**
	 * Metodo para buscar un usuario en la base de datos de cliente usando el userName y la clave del usuario
	 * 
	 * @see: {@link #traerDataBaseCliente()}
	 */
	public static Cliente buscarCliente(String userName, String clave) {
		Cliente cliente= null;
		Gson gson = new Gson();
		JsonArray dataBase =Data.traerDataBaseCliente();
		for (JsonElement jsonElement : dataBase) {
			JsonObject obj = jsonElement.getAsJsonObject();
			if(userName.equals(obj.get("userName").getAsString()) && clave.equals(obj.get("clave").getAsString())) {
				cliente = gson.fromJson(obj, Cliente.class) ;
			}
		}
		return cliente;
	}
	
	
	/**
	 * Metodo para buscar un usuario en la base de datos de tendero usando solo el userName
	 * 
	 * @see: {@link #traerDataBaseTendero()}
	 */
	
	public static Tendero buscarTendero(String userName) {
		Gson gson = new Gson();
		Tendero tendero= null;
		JsonArray dataBase =Data.traerDataBaseTendero(); 
		for (JsonElement jsonElement : dataBase) {
			JsonObject obj = jsonElement.getAsJsonObject();
			if(userName.equals(obj.get("userName").getAsString())) {
				tendero = gson.fromJson(obj, Tendero.class);
			}
		}
		return tendero;
	}
	
	/**
	 * Metodo para buscar un usuario en la base de datos de tendero usando el userName y la clave del usuario
	 * 
	 * @see: {@link #traerDataBaseTendero()}
	 */
	public static Tendero buscarTendero(String userName, String clave) {
		Tendero tendero= null;
		Gson gson = new Gson();
		JsonArray dataBase =Data.traerDataBaseTendero();
		for (JsonElement jsonElement : dataBase) {
			JsonObject obj = jsonElement.getAsJsonObject();
			if(userName.equals(obj.get("userName").getAsString()) && clave.equals(obj.get("clave").getAsString())) {
				tendero = gson.fromJson(obj, Tendero.class) ;
			}
		}
		return tendero;
	}
	
	
	/**
	 * Metodo para buscar un usuario en la base de datos de administrador usando solo el userName
	 * 
	 * @see: {@link #traerDataBaseAdministrador()}
	 */
	
	public static Administrador buscarAdministrador(String userName) {
		Gson gson = new Gson();
		Administrador administrador= null;
		JsonArray dataBase =Data.traerDataBaseAdministrador(); 
		for (JsonElement jsonElement : dataBase) {
			JsonObject obj = jsonElement.getAsJsonObject();
			if(userName.equals(obj.get("userName").getAsString())) {
				administrador = gson.fromJson(obj, Administrador.class);
			}
		}
		return administrador;
	}
	
	/**
	 * Metodo para buscar un usuario en la base de datos de administrador usando el userName y la clave del usuario
	 * 
	 * @see: {@link #traerDataBaseAdministrador()}
	 */
	public static Administrador buscarAdministrador(String userName, String clave) {
		Administrador administrador= null;
		Gson gson = new Gson();
		JsonArray dataBase =Data.traerDataBaseAdministrador();
		for (JsonElement jsonElement : dataBase) {
			JsonObject obj = jsonElement.getAsJsonObject();
			if(userName.equals(obj.get("userName").getAsString()) && clave.equals(obj.get("clave").getAsString())) {
				administrador = gson.fromJson(obj, Administrador.class) ;
			}
		}
		return administrador;
	}
	
	
	/**
	 * Metodo para buscar un restaurante en la base de datos de restaurante
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
	
	/**
	 * Metodo organiza los restaurantes de mayor a menor segun calificacion
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