package BaseDatos;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import UIMain.*;
import gestorAplicacion.Interaccion.Calificacion;
import gestorAplicacion.Interaccion.Cliente;
import gestorAplicacion.Interaccion.Notificacion;
import gestorAplicacion.Interaccion.Tendero;
import gestorAplicacion.Administracion.Administrador;
import gestorAplicacion.Oferta.Pedido;
import gestorAplicacion.Oferta.Plato;
import gestorAplicacion.Oferta.Restaurante;
import UIMain.OpcionDeMenu;
import com.google.gson.*;

/**
 * La clase Data tiene como finalidad la obtencio y contencion de datos en
 * formato Json para el correcto funcionamiento de la aplicacion.
 * 
 * Estructuras importantes:
 * 
 * @see: {@link #opciones}
 * 
 * @author: Santiago Tamayo, Paula A. Taborda, Mateo Rincon, Guillermo Toloza
 */
public class Data {

	private static ArrayList<OpcionDeMenu> opciones = new ArrayList<>();

	/**
	 * M�todo en el se cargan todas las opciones de menu generales.
	 */
	public static final void CargarOpciones() {
		opciones.add(new Registrarse());// 0
		opciones.add(new login());// 1
		opciones.add(new Invitado());// 2
		opciones.add(new HacerPedido());// 3 cliente
		opciones.add(new CalificarTendero());// 4 cliente
		opciones.add(new CalificarRestaurante()); // 5 cliente
		opciones.add(new CuantoHeGastado()); // 6 cliente
		opciones.add(new MejorRestauranteCal()); // 7 cliente
		opciones.add(new PlatosQueMasCompre()); // 8 cliente
		opciones.add(new AgregarSaldo());// 9 cliente
		opciones.add(new CuantosPedidosHeEntregado()); // 10 tendero
		opciones.add(new AceptarPedido()); // 11 tendero
		opciones.add(new EnCualesDirecciones()); // 12 restaurante
		opciones.add(new CrearPlato()); // 13 restaurante
		opciones.add(new AgregarDireccionRest()); // 14 restaurante
		opciones.add(new CambiarPlato()); // 15 restaurante
		opciones.add(new EliminarDireccionRest());// 16 restaurante
		opciones.add(new EliminarPlato()); // 17 restaurante
		opciones.add(new CrearAdministrador()); // 18 Admin
		opciones.add(new CrearRestaurante()); // 19 admin
		opciones.add(new CrearTendero()); // 20 admin
		opciones.add(new TenderoReparteMas()); // 21 admin
		opciones.add(new QuitarFuncionalidades()); // 22 admin
		opciones.add(new AgregarFuncionalidades()); // 23 admin
		opciones.add(new Salir()); // 24 todos

	}

	public static final ArrayList<OpcionDeMenu> getOpciones() {
		return opciones;
	}

	private static final String filepathPedido = "RAPPI2\\src\\BaseDatos\\temp\\pedidoGuardados.json";
	private static final String filepathCliente = "RAPPI2\\src\\BaseDatos\\temp\\clientesGuardados.json";
	private static final String filepathTendero = "RAPPI2\\src\\BaseDatos\\temp\\tenderosGuardados.json";
	private static final String filepathAdministrador = "RAPPI2\\src\\BaseDatos\\temp\\administradoresGuardados.json";
	private static final String filepathRestaurantes = "RAPPI2\\src\\BaseDatos\\temp\\restaurantesGuardados.json";
	private static final String filepathPlato = "RAPPI2\\src\\BaseDatos\\temp\\platosGuardados.json";
	private static final String filepathNotificacion = "RAPPI2\\src\\BaseDatos\\temp\\NotificacionesGuardados.json";
	private static final String filepathCalificacion = "RAPPI2\\src\\BaseDatos\\temp\\CalificacionesGuardados.json";

	/**
	 * Metodo que se usa al principio del Main para cargar el file con la base de
	 * datos de Notificaciones
	 * 
	 * @see: {@link #traerDataBaseNotificacion()}
	 */
	public static File cargarFileDataNotificacion() throws IOException {
		Gson gson = new Gson();
		File DataBase = new File(filepathNotificacion);
		if (Data.traerDataBaseNotificacion() != null) {
			System.out.println("La dataBaseNotificacion se ha cargado correctamente");
		} else {
			System.out.println("La dataBaseNotificacion se ha creado correctamente");
			Notificacion[] aux = new Notificacion[0];
			JsonArray array = gson.fromJson(gson.toJson(aux), JsonArray.class);
			try (FileWriter fw = new FileWriter(filepathNotificacion)) {
				fw.write(array.toString());
				fw.flush();
			} catch (IOException e) {
			}
		}
		return DataBase;
	}

	public static JsonArray traerDataBaseNotificacion() {
		JsonParser jp = new JsonParser();
		try (FileReader fr = new FileReader(filepathNotificacion)) {
			Object obj = jp.parse(fr);
			JsonArray array = (JsonArray) obj;
			return array;
		} catch (Exception ex) {
			System.out.println("No se puede traer la dataBaseNotificacion correctamente");
			return null;
		}
	}

	public static void actualizarDataBaseNotificacion(JsonArray array) {
		try (FileWriter fw = new FileWriter(filepathNotificacion)) {
			fw.write(array.toString());
			fw.flush();
		} catch (IOException e) {
			System.out.println("No se puede actualizar la dataBaseNotificacion correctamente");
		}
	}

	public static void actualizarDataBaseNotificacion(Notificacion notificacion) {
		Notificacion aux = notificacion;
		Data.eliminarObjetoDataBaseNotificacion(Data.buscarNotificacion(notificacion.getID()));
		Data.agregarObjetoDataBaseNotificacion(aux);
	}

	public static void agregarObjetoDataBaseNotificacion(Notificacion obj) {
		Gson gson = new Gson();
		String aux = gson.toJson(obj);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBaseNotificacion();
		if (!dataBase.contains(je)) {
			dataBase.add(je);
			Data.actualizarDataBaseNotificacion(dataBase);
		} else {
			System.out.println("no se puede agregar el elemento a la base de datos");
		}
	}

	public static void eliminarObjetoDataBaseNotificacion(Notificacion obj) {
		Gson gson = new Gson();
		String aux = gson.toJson(obj);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBaseNotificacion();
		if (dataBase.contains(je)) {
			dataBase.remove(je);
			Data.actualizarDataBaseNotificacion(dataBase);
		} else {
			System.out.println("no se puede eliminar el elemento a la base de datos");
		}
	}

	public static Notificacion buscarNotificacion(int ID) {
		Gson gson = new Gson();
		Notificacion notificacion = null;
		String x = String.valueOf(ID);
		JsonArray dataBase = Data.traerDataBaseNotificacion();
		for (JsonElement jsonElement : dataBase) {
			JsonObject obj = jsonElement.getAsJsonObject();
			if (x.equals(obj.get("ID").getAsString())) {
				notificacion = gson.fromJson(obj, Notificacion.class);
			}
		}
		return notificacion;
	}

	/**
	 * Metodo que se usa al principio del Main para cargar el file con la base de
	 * datos de Calificaciones
	 * 
	 * @see: {@link #traerDataBaseCalificacion()}
	 */
	public static File cargarFileDataCalificacion() throws IOException {
		Gson gson = new Gson();
		File DataBase = new File(filepathCalificacion);
		if (Data.traerDataBaseCalificacion() != null) {
			System.out.println("La dataBaseCalificacion se ha cargado correctamente");
		} else {
			System.out.println("La dataBaseCalificacion se ha creado correctamente");
			Calificacion[] aux = new Calificacion[0];
			JsonArray array = gson.fromJson(gson.toJson(aux), JsonArray.class);
			try (FileWriter fw = new FileWriter(filepathCalificacion)) {
				fw.write(array.toString());
				fw.flush();
			} catch (IOException e) {
			}
		}
		return DataBase;
	}

	public static JsonArray traerDataBaseCalificacion() {
		JsonParser jp = new JsonParser();
		try (FileReader fr = new FileReader(filepathCalificacion)) {
			Object obj = jp.parse(fr);
			JsonArray array = (JsonArray) obj;
			return array;
		} catch (Exception ex) {
			System.out.println("No se puede traer la dataBaseCalificacion correctamente");
			return null;
		}
	}

	public static void actualizarDataBaseCalificacion(JsonArray array) {
		try (FileWriter fw = new FileWriter(filepathCalificacion)) {
			fw.write(array.toString());
			fw.flush();
		} catch (IOException e) {
			System.out.println("No se puede actualizar la dataBaseCalificacion correctamente");
		}
	}

	public static void actualizarDataBaseCalificacion(Calificacion calificacion) { /////////////////////
		Calificacion aux = calificacion;
		Data.eliminarObjetoDataBaseCalificacion(Data.buscarCalificacion(calificacion.getID()));
		Data.agregarObjetoDataBaseCalificacion(aux);
	}

	public static void agregarObjetoDataBaseCalificacion(Calificacion obj) {
		Gson gson = new Gson();
		String aux = gson.toJson(obj);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBaseCalificacion();
		if (!dataBase.contains(je)) {
			dataBase.add(je);
			Data.actualizarDataBaseCalificacion(dataBase);
		} else {
			System.out.println("no se puede agregar el elemento a la base de datos");
		}
	}

	public static void eliminarObjetoDataBaseCalificacion(Calificacion obj) {
		Gson gson = new Gson();
		String aux = gson.toJson(obj);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBaseCalificacion();
		if (dataBase.contains(je)) {
			dataBase.remove(je);
			Data.actualizarDataBaseCalificacion(dataBase);
		} else {
			System.out.println("no se puede eliminar el elemento a la base de datos");
		}
	}

	public static Calificacion buscarCalificacion(int ID) {
		Gson gson = new Gson();
		Calificacion calificacion = null;
		String x = String.valueOf(ID);
		JsonArray dataBase = Data.traerDataBaseCalificacion();
		for (JsonElement jsonElement : dataBase) {
			JsonObject obj = jsonElement.getAsJsonObject();
			if (x.equals(obj.get("ID").getAsString())) {
				calificacion = gson.fromJson(obj, Calificacion.class);
			}
		}
		return calificacion;
	}



	/**
	 * Metodo que se usa al principio del Main para cargar el file con la base de
	 * datos de plato
	 * 
	 * @see: {@link #traerDataBasePlato()}
	 */
	public static File cargarFileDataBasePlato() throws IOException {
		Gson gson = new Gson();
		File DataBase = new File(filepathPlato);
		if (Data.traerDataBasePlato() != null) {
			System.out.println("La dataBasePlato se ha cargado correctamente");
		} else {
			System.out.println("La dataBasePlato se ha creado correctamente");
			Plato[] aux = new Plato[0];
			JsonArray array = gson.fromJson(gson.toJson(aux), JsonArray.class);
			try (FileWriter fw = new FileWriter(filepathPlato)) {
				fw.write(array.toString());
				fw.flush();
			} catch (IOException e) {
			}
		}
		return DataBase;
	}

	/**
	 * Metodo que se usa al principio del Main para cargar el file con la base de
	 * datos de clientes
	 * 
	 * @see: {@link #traerDataBaseCliente()}
	 */
	public static File cargarFileDataBaseCliente() throws IOException {
		Gson gson = new Gson();
		File DataBase = new File(filepathCliente);
		if (Data.traerDataBaseCliente() != null) {
			System.out.println("La dataBaseCliente se ha cargado correctamente");
		} else {
			System.out.println("La dataBaseCliente se ha creado correctamente");
			Cliente[] aux = new Cliente[0];
			JsonArray array = gson.fromJson(gson.toJson(aux), JsonArray.class);
			try (FileWriter fw = new FileWriter(filepathCliente)) {
				fw.write(array.toString());
				fw.flush();
			} catch (IOException e) {
			}
		}
		return DataBase;
	}

	/**
	 * Metodo que se usa al principio del Main para cargar el file con la base de
	 * datos de tenderos
	 * 
	 * @see: {@link #traerDataBaseTendero()}
	 */
	public static File cargarFileDataBaseTendero() throws IOException {
		Gson gson = new Gson();
		File DataBase = new File(filepathTendero);
		if (Data.traerDataBaseTendero() != null) {
			System.out.println("La dataBaseTendero se ha cargado correctamente");
		} else {
			System.out.println("La dataBaseTendero se ha creado correctamente");
			Tendero[] aux = new Tendero[0];
			JsonArray array = gson.fromJson(gson.toJson(aux), JsonArray.class);
			try (FileWriter fw = new FileWriter(filepathTendero)) {
				fw.write(array.toString());
				fw.flush();
			} catch (IOException e) {
			}
		}
		return DataBase;
	}

	/**
	 * Metodo que se usa al principio del Main para cargar el file con la base de
	 * datos de administradores
	 * 
	 * @see: {@link #traerDataBaseAdministrador()}
	 */
	public static File cargarFileDataBaseAdministrador() throws IOException {
		Gson gson = new Gson();
		File DataBase = new File(filepathAdministrador);
		if (Data.traerDataBaseAdministrador() != null) {
			System.out.println("La dataBaseAdministrador se ha cargado correctamente");
		} else {
			System.out.println("La dataBaseAdministrador se ha creado correctamente");
			Administrador[] aux = new Administrador[0];
			JsonArray array = gson.fromJson(gson.toJson(aux), JsonArray.class);
			try (FileWriter fw = new FileWriter(filepathAdministrador)) {
				fw.write(array.toString());
				fw.flush();
			} catch (IOException e) {
			}
		}
		return DataBase;
	}

	/**
	 * Metodo que se usa al principio del Main para cargar el file con la base de
	 * datos de restaurantes
	 * 
	 * @see: {@link #traerDataBaseRestaurante()}
	 */
	public static File cargarFileDataBaseRestaurante() throws IOException {
		Gson gson = new Gson();
		File DataBase = new File(filepathRestaurantes);
		if (Data.traerDataBaseRestaurante() != null) {
			System.out.println("La dataBaseRestaurantes se ha cargado correctamente");
		} else {
			System.out.println("La dataBaseRestaurantes se ha creado correctamente");
			Restaurante[] aux = new Restaurante[0];
			JsonArray array = gson.fromJson(gson.toJson(aux), JsonArray.class);
			try (FileWriter fw = new FileWriter(filepathRestaurantes)) {
				fw.write(array.toString());
				fw.flush();
			} catch (IOException e) {
			}
		}
		return DataBase;
	}

	public static File cargarFileDataBasePedido() throws IOException {
		Gson gson = new Gson();
		File DataBase = new File(filepathPedido);
		if (Data.traerDataBasePedido() != null) {
			System.out.println("La dataBasePedido se ha cargado correctamente");
		} else {
			System.out.println("La dataBasePedido se ha creado correctamente");
			Pedido[] aux = new Pedido[0];
			JsonArray array = gson.fromJson(gson.toJson(aux), JsonArray.class);
			try (FileWriter fw = new FileWriter(filepathPedido)) {
				fw.write(array.toString());
				fw.flush();
			} catch (IOException e) {
			}
		}
		return DataBase;
	}

	/**
	 * Metodo que se usa al principio del Main para cargar el file con la base de
	 * datos de platos
	 * 
	 * @see: {@link #traerDataBasePlato()}
	 */

	/**
	 * Metodo que lee la base de datos de clientes desde su file y obtiene los
	 * objetos alli guardados
	 */
	public static JsonArray traerDataBaseCliente() {
		JsonParser jp = new JsonParser();
		try (FileReader fr = new FileReader(filepathCliente)) {
			Object obj = jp.parse(fr);
			JsonArray array = (JsonArray) obj;
			return array;
		} catch (Exception ex) {
			System.out.println("No se puede traer la dataBaseCliente correctamente");
			return null;
		}
	}

	/**
	 * Metodo que lee la base de datos de clientes desde su file y obtiene los
	 * objetos alli guardados
	 */
	public static JsonArray traerDataBasePlato() {
		JsonParser jp = new JsonParser();
		try (FileReader fr = new FileReader(filepathPlato)) {
			Object obj = jp.parse(fr);
			JsonArray array = (JsonArray) obj;
			return array;
		} catch (Exception ex) {
			System.out.println("No se puede traer la dataBasePlato correctamente");
			return null;
		}
	}

	/**
	 * Metodo que lee la base de datos de tenderos desde su file y obtiene los
	 * objetos alli guardados
	 */
	public static JsonArray traerDataBaseTendero() {
		JsonParser jp = new JsonParser();
		try (FileReader fr = new FileReader(filepathTendero)) {
			Object obj = jp.parse(fr);
			JsonArray array = (JsonArray) obj;
			return array;
		} catch (Exception ex) {
			System.out.println("No se puede traer la dataBaseTendero correctamente");
			return null;
		}
	}

	/**
	 * Metodo que lee la base de datos de administradores desde su file y obtiene
	 * los objetos alli guardados
	 */
	public static JsonArray traerDataBaseAdministrador() {
		JsonParser jp = new JsonParser();
		try (FileReader fr = new FileReader(filepathAdministrador)) {
			Object obj = jp.parse(fr);
			JsonArray array = (JsonArray) obj;
			return array;
		} catch (Exception ex) {
			System.out.println("No se puede traer la dataBaseAdministrador correctamente");
			return null;
		}
	}

	/**
	 * Metodo que lee la base de datos de restaurantes desde su file para asi
	 * obtener aquellos objetos creados previamente
	 */
	public static JsonArray traerDataBaseRestaurante() {
		JsonParser jp = new JsonParser();
		try (FileReader fr = new FileReader(filepathRestaurantes)) {
			Object obj = jp.parse(fr);
			JsonArray array = (JsonArray) obj;
			return array;
		} catch (Exception ex) {
			System.out.println("No se puede traer la dataBaseRestaurantes correctamente");
			return null;
		}
	}

	public static JsonArray traerDataBasePedido() {
		JsonParser jp = new JsonParser();
		try (FileReader fr = new FileReader(filepathPedido)) {
			Object obj = jp.parse(fr);
			JsonArray array = (JsonArray) obj;
			return array;
		} catch (Exception ex) {
			System.out.println("No se puede traer la dataBasePedido correctamente");
			return null;
		}
	}

	/**
	 * Metodo que se usa para actualizar las bases de datos de clientes, escribiendo
	 * los nuevos objetos que se necesiten guardar
	 */
	public static void actualizarDataBasePlato(JsonArray array) {
		try (FileWriter fw = new FileWriter(filepathPlato)) {
			fw.write(array.toString());
			fw.flush();
		} catch (IOException e) {
			System.out.println("No se puede actualizar la dataBasePlato correctamente");
		}
	}

	/**
	 * Metodo que se usa para actualizar las bases de datos de clientes, escribiendo
	 * los nuevos objetos que se necesiten guardar
	 */
	public static void actualizarDataBaseCliente(JsonArray array) {
		try (FileWriter fw = new FileWriter(filepathCliente)) {
			fw.write(array.toString());
			fw.flush();
		} catch (IOException e) {
			System.out.println("No se puede actualizar la dataBaseCliente correctamente");
		}
	}

	/**
	 * Metodo que se usa para actualizar las bases de datos de tenderos, escribiendo
	 * los nuevos objetos que se necesiten guardar
	 */
	public static void actualizarDataBaseTendero(JsonArray array) {
		try (FileWriter fw = new FileWriter(filepathTendero)) {
			fw.write(array.toString());
			fw.flush();
		} catch (IOException e) {
			System.out.println("No se puede actualizar la dataBaseTendero correctamente");
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que se usa para actualizar las bases de datos de administradores,
	 * escribiendo los nuevos objetos que se necesiten guardar
	 */
	public static void actualizarDataBaseAdministrador(JsonArray array) {
		try (FileWriter fw = new FileWriter(filepathAdministrador)) {
			fw.write(array.toString());
			fw.flush();
		} catch (IOException e) {
			System.out.println("No se puede actualizar la dataBaseAdministrador correctamente");
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que se usa para actualizar las bases de datos de restaurantes,
	 * escribiendo aquellos nuevos restaurantes que se vayan a tener en cuenta en la
	 * oferta
	 */
	public static void actualizarDataBaseRestaurante(JsonArray array) {
		try (FileWriter fw = new FileWriter(filepathRestaurantes)) {
			fw.write(array.toString());
			fw.flush();
		} catch (IOException ex) {
			System.out.println("No se puede actualizar la dataBaseRestaurante correctamente");
		}
	}

	public static void actualizarDataBasePedido(JsonArray array) {
		try (FileWriter fw = new FileWriter(filepathPedido)) {
			fw.write(array.toString());
			fw.flush();
		} catch (IOException e) {
			System.out.println("No se puede actualizar la dataBasePedido correctamente");
		}
	}

	/**
	 * El metodo actualiza en la base de datos el cliente
	 * 
	 * @param cliente El parametro define el cliente que va a ser actualizado
	 */
	public static void actualizarDataBaseCliente(Cliente cliente) {
		Cliente aux = cliente;
		Data.eliminarObjetoDataBaseCliente(Data.buscarCliente(cliente.getUserName()));
		Data.agregarObjetoDataBaseCliente(aux);
	}

	/**
	 * El metodo actualiza en la base de datos el plato
	 * 
	 * @param plato El parametro define el cliente que va a ser actualizado
	 */
	public static void actualizarDataBasePlato(Plato plato) {
		;
		Data.eliminarObjetoDataBasePlato(Data.buscarPlato(plato.getNombre()));
		Data.agregarObjetoDataBasePlato(plato);
	}

	/**
	 * El metodo actualiza en la base de datos el tendero
	 * 
	 * @param tendero El parametro define el tendero que va a ser actualizado
	 */
	public static void actualizarDataBaseTendero(Tendero tendero) {
		Tendero aux = tendero;
		Data.eliminarObjetoDataBaseTendero(Data.buscarTendero(tendero.getUserName()));
		Data.agregarObjetoDataBaseTendero(aux);
	}

	/**
	 * El metodo actualiza en la base de datos el administrador
	 * 
	 * @param administrador El parametro define el administrador que va a ser
	 *                      actualizado
	 */
	public static void actualizarDataBaseAdministrador(Administrador administrador) {
		Administrador aux = administrador;
		Data.eliminarObjetoDataBaseAdministrador(Data.buscarAdministrador(administrador.getUserName()));
		Data.agregarObjetoDataBaseAdministrador(aux);
	}

	/**
	 * El metodo actualiza en la base de datos el restaurante
	 * 
	 * @param restaurante El parametro define el restaurante que va a ser
	 *                    actualizado
	 */
	public static void actualizarDataBaseRestaurante(Restaurante restaurante) {
		Restaurante aux = restaurante;
		Data.eliminarObjetoDataBaseRestaurante(Data.buscarRestaurante(restaurante.getNombre()));
		Data.agregarObjetoDataBaseRestaurante(aux);
	}

	public static void actualizarDataBasePedido(Pedido pedido) {
		Data.eliminarObjetoDataBasePedido(Data.buscarPedido(pedido.getId()));
		Data.agregarObjetoDataBasePedido(pedido);
	}

	/**
	 * Metodo que se usa para agregar objetos a la base de datos de plato,
	 * convirtiendo asi el objeto a guardar en un JsonElement para poder insertarlo
	 * en el archivo respectivo
	 * 
	 * @see: {@link #traerDataBasePlato()}
	 * @see: {@link #actualizarDataBasePlato(JsonArray)}
	 */
	public static void agregarObjetoDataBasePlato(Plato obj) {
		Gson gson = new Gson();
		String aux = gson.toJson(obj);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBasePlato();
		if (!dataBase.contains(je)) {
			dataBase.add(je);
			Data.actualizarDataBasePlato(dataBase);
		} else {
			System.out.println("no se puede agregar el elemento a la base de datos");
		}
	}

	/**
	 * Metodo que se usa para agregar objetos a la base de datos de clientes,
	 * convirtiendo asi el objeto a guardar en un JsonElement para poder insertarlo
	 * en el archivo respectivo
	 * 
	 * @see: {@link #traerDataBaseCliente()}
	 * @see: {@link #actualizarDataBaseCliente(JsonArray)}
	 */
	public static void agregarObjetoDataBaseCliente(Cliente obj) {
		Gson gson = new Gson();
		String aux = gson.toJson(obj);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBaseCliente();
		if (!dataBase.contains(je)) {
			dataBase.add(je);
			Data.actualizarDataBaseCliente(dataBase);
		} else {
			System.out.println("no se puede agregar el elemento a la base de datos");
		}
	}

	/**
	 * Metodo que se usa para agregar objetos a la base de datos de tenderos,
	 * convirtiendo asi el objeto a guardar en un JsonElement para poder insertarlo
	 * en el archivo respectivo
	 * 
	 * @see: {@link #traerDataBaseTendero()}
	 * @see: {@link #actualizarDataBaseTendero(JsonArray)}
	 */
	public static void agregarObjetoDataBaseTendero(Tendero obj) {
		Gson gson = new Gson();
		String aux = gson.toJson(obj);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBaseTendero();
		if (!dataBase.contains(je)) {
			dataBase.add(je);
			Data.actualizarDataBaseTendero(dataBase);
		} else {
			System.out.println("no se puede agregar el elemento a la base de datos");
		}
	}

	/**
	 * Metodo que se usa para agregar objetos a la base de datos de administradores,
	 * convirtiendo asi el objeto a guardar en un JsonElement para poder insertarlo
	 * en el archivo respectivo
	 * 
	 * @see: {@link #traerDataBaseAdministrador()}
	 * @see: {@link #actualizarDataBaseAdministrador(JsonArray)}
	 */
	public static void agregarObjetoDataBaseAdministrador(Administrador obj) {
		Gson gson = new Gson();
		String aux = gson.toJson(obj);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBaseAdministrador();
		if (!dataBase.contains(je)) {
			dataBase.add(je);
			Data.actualizarDataBaseAdministrador(dataBase);
		} else {
			System.out.println("no se puede agregar el elemento a la base de datos");
		}
	}

	/**
	 * Metodo se usa para agregar objetos a la base de datos de restaurante,
	 * conviritiendo estos objetos en los JsonElements para asi insertarlos a su
	 * respectivo archivo
	 * 
	 * @see: {@link #actualizarDataBaseRestaurante(JsonArray)}
	 * @see: {@link #traerDataBaseRestaurante()}
	 */
	public static void agregarObjetoDataBaseRestaurante(Restaurante obj) {
		Gson gson = new Gson();
		String aux = gson.toJson(obj);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBaseRestaurante();
		if (!dataBase.contains(je)) {
			dataBase.add(je);
			Data.actualizarDataBaseRestaurante(dataBase);
		} else {
			System.out.println("no se puede agregar el elemento a la base de datos");
		}
	}

	public static void agregarObjetoDataBasePedido(Pedido obj) {
		Gson gson = new Gson();
		String aux = gson.toJson(obj);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBasePedido();
		if (!dataBase.contains(je)) {
			dataBase.add(je);
			Data.actualizarDataBasePedido(dataBase);
		} else {
			System.out.println("no se puede agregar el elemento a la base de datos");
		}
	}

	/**
	 * Metodo que elimina cierto objeto de la dataBasePlato
	 * 
	 * @see: {@link #traerDataBasePlato()}
	 * @see: {@link #actualizarDataBasePlato(JsonArray)}
	 */
	public static void eliminarObjetoDataBasePlato(Plato obj) {
		Gson gson = new Gson();
		String aux = gson.toJson(obj);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBasePlato();
		if (dataBase.contains(je)) {
			dataBase.remove(je);
			Data.actualizarDataBasePlato(dataBase);
		} else {
			System.out.println("no se puede eliminar el elemento a la base de datos");
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
		if (dataBase.contains(je)) {
			dataBase.remove(je);
			Data.actualizarDataBaseCliente(dataBase);
		} else {
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
		if (dataBase.contains(je)) {
			dataBase.remove(je);
			Data.actualizarDataBaseTendero(dataBase);
		} else {
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
		if (dataBase.contains(je)) {
			dataBase.remove(je);
			Data.actualizarDataBaseAdministrador(dataBase);
		} else {
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
		for (int i = 0; i < dataBase.size(); i++) {
			JsonObject jo = dataBase.get(i).getAsJsonObject();
			if (obj.getNombre().equals(jo.get("nombre").getAsString())) {
				dataBase.remove(i);
			}
		}
		if (dataBase.contains(je)) {
			dataBase.remove(je);
			Data.actualizarDataBaseRestaurante(dataBase);
		} else {
			System.out.println("no se puede eliminar el elemento a la base de datos");
		}
	}

	public static void eliminarObjetoDataBasePedido(Pedido obj) {
		Gson gson = new Gson();
		String aux = gson.toJson(obj);
		JsonElement je = gson.fromJson(aux, JsonElement.class);
		JsonArray dataBase = Data.traerDataBasePedido();
		if (dataBase.contains(je)) {
			dataBase.remove(je);
			Data.actualizarDataBasePedido(dataBase);
		} else {
			System.out.println("no se puede eliminar el elemento a la base de datos");
		}
	}

	/**
	 * Metodo para buscar un usuario en la base de datos de platos usando solo el
	 * userName
	 * 
	 * @see: {@link #traerDataBasepPlato()}
	 */

	public static Plato buscarPlato(String userName) {
		Gson gson = new Gson();
		Plato plato = null;
		JsonArray dataBase = Data.traerDataBasePlato();
		for (JsonElement jsonElement : dataBase) {
			JsonObject obj = jsonElement.getAsJsonObject();
			if (userName.equals(obj.get("nombre").getAsString())) {
				plato = gson.fromJson(obj, Plato.class);
			}
		}
		return plato;
	}

	/**
	 * Metodo para buscar un usuario en la base de datos de cliente usando solo el
	 * userName
	 * 
	 * @see: {@link #traerDataBaseCliente()}
	 */

	public static Cliente buscarCliente(String userName) {
		Gson gson = new Gson();
		Cliente cliente = null;
		JsonArray dataBase = Data.traerDataBaseCliente();
		for (JsonElement jsonElement : dataBase) {
			JsonObject obj = jsonElement.getAsJsonObject();
			if (userName.equals(obj.get("userName").getAsString())) {
				cliente = gson.fromJson(obj, Cliente.class);
			}
		}
		return cliente;
	}

	/**
	 * Metodo para buscar un usuario en la base de datos de cliente usando el
	 * userName y la clave del usuario
	 * 
	 * @see: {@link #traerDataBaseCliente()}
	 */
	public static Cliente buscarCliente(String userName, String clave) {
		Cliente cliente = null;
		Gson gson = new Gson();
		JsonArray dataBase = Data.traerDataBaseCliente();
		for (JsonElement jsonElement : dataBase) {
			JsonObject obj = jsonElement.getAsJsonObject();
			if (userName.equals(obj.get("userName").getAsString()) && clave.equals(obj.get("clave").getAsString())) {
				cliente = gson.fromJson(obj, Cliente.class);
			}
		}
		return cliente;
	}

	/**
	 * Metodo para buscar un usuario en la base de datos de tendero usando solo el
	 * userName
	 * 
	 * @see: {@link #traerDataBaseTendero()}
	 */

	public static Tendero buscarTendero(String userName) {
		Gson gson = new Gson();
		Tendero tendero = null;
		JsonArray dataBase = Data.traerDataBaseTendero();
		for (JsonElement jsonElement : dataBase) {
			JsonObject obj = jsonElement.getAsJsonObject();
			if (userName.equals(obj.get("userName").getAsString())) {
				tendero = gson.fromJson(obj, Tendero.class);
			}
		}
		return tendero;
	}

	/**
	 * Metodo para buscar un usuario en la base de datos de tendero usando el
	 * userName y la clave del usuario
	 * 
	 * @see: {@link #traerDataBaseTendero()}
	 */
	public static Tendero buscarTendero(String userName, String clave) {
		Tendero tendero = null;
		Gson gson = new Gson();
		JsonArray dataBase = Data.traerDataBaseTendero();
		for (JsonElement jsonElement : dataBase) {
			JsonObject obj = jsonElement.getAsJsonObject();
			if (userName.equals(obj.get("userName").getAsString()) && clave.equals(obj.get("clave").getAsString())) {
				tendero = gson.fromJson(obj, Tendero.class);
			}
		}
		return tendero;
	}

	/**
	 * Metodo para buscar un usuario en la base de datos de administrador usando
	 * solo el userName
	 * 
	 * @see: {@link #traerDataBaseAdministrador()}
	 */

	public static Administrador buscarAdministrador(String userName) {
		Gson gson = new Gson();
		Administrador administrador = null;
		JsonArray dataBase = Data.traerDataBaseAdministrador();
		for (JsonElement jsonElement : dataBase) {
			JsonObject obj = jsonElement.getAsJsonObject();
			if (userName.equals(obj.get("userName").getAsString())) {
				administrador = gson.fromJson(obj, Administrador.class);
			}
		}
		return administrador;
	}

	/**
	 * Metodo para buscar un usuario en la base de datos de administrador usando el
	 * userName y la clave del usuario
	 * 
	 * @see: {@link #traerDataBaseAdministrador()}
	 */
	public static Administrador buscarAdministrador(String userName, String clave) {
		Administrador administrador = null;
		Gson gson = new Gson();
		JsonArray dataBase = Data.traerDataBaseAdministrador();
		for (JsonElement jsonElement : dataBase) {
			JsonObject obj = jsonElement.getAsJsonObject();
			if (userName.equals(obj.get("userName").getAsString()) && clave.equals(obj.get("clave").getAsString())) {
				administrador = gson.fromJson(obj, Administrador.class);
			}
		}
		return administrador;
	}

	/**
	 * Metodo para buscar un restaurante en la base de datos de restaurante
	 */

	public static Restaurante buscarRestaurante(String userName) {
		Restaurante restaurante = null;
		Gson gson = new Gson();
		JsonArray dataBase = Data.traerDataBaseRestaurante();
		for (JsonElement jsonElement : dataBase) {
			JsonObject obj = jsonElement.getAsJsonObject();
			if (userName.equals(obj.get("nombre").getAsString())) {
				restaurante = gson.fromJson(obj, Restaurante.class);
			}
		}
		return restaurante;
	}

	/**
	 * Metodo para buscar un usuario en la base de datos de restaurante usando el
	 * userName y la clave del restaurante
	 * 
	 * @see: {@link #traerDataBaseRestaurante()}
	 */
	public static Restaurante buscarRestaurante(String userName, String clave) {
		Restaurante restaurante = null;
		Gson gson = new Gson();
		JsonArray dataBase = Data.traerDataBaseRestaurante();
		for (JsonElement jsonElement : dataBase) {
			JsonObject obj = jsonElement.getAsJsonObject();
			if (userName.equals(obj.get("nombre").getAsString()) && clave.equals(obj.get("clave").getAsString())) {
				restaurante = gson.fromJson(obj, Restaurante.class);
			}
		}
		return restaurante;
	}

	public static Pedido buscarPedido(int ID) {
		Pedido pedido = null;
		String x = String.valueOf(ID);
		Gson gson = new Gson();
		JsonArray dataBase = Data.traerDataBasePedido();
		for (JsonElement jsonElement : dataBase) {
			JsonObject obj = jsonElement.getAsJsonObject();
			if (x.equals(obj.get("ID").getAsString())) {
				pedido = gson.fromJson(obj, Pedido.class);
			}
		}
		return pedido;
	}

	/**
	 * Metodo organiza los restaurantes de mayor a menor segun calificacion
	 */
	public static ArrayList<Restaurante> OrganizarRestaurantesPorCalificacion() {
		Gson gson = new Gson();
		JsonArray historial = Data.traerDataBaseRestaurante();
		ArrayList<Restaurante> best = new ArrayList<Restaurante>();
		// bubble sort
		boolean ordenado = false;
		while (!ordenado) {
			ordenado = true;
			for (int i = 0; i < historial.size(); i++) {
				Restaurante aux1 = gson.fromJson(historial.get(i), Restaurante.class);
				Restaurante aux2 = gson.fromJson(historial.get(i - 1), Restaurante.class);
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

	public static void imprimirRestaurantes() {
		Gson gson = new Gson();
		JsonArray historial = Data.traerDataBaseRestaurante();
		for (int i = 0; i < historial.size(); i++) {
			Restaurante aux1 = gson.fromJson(historial.get(i), Restaurante.class);
			System.out.println(i + ") " + aux1.getNombre());

		}
	}
}