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
import UIMain.Administrador.*;
import UIMain.Tendero.*;
import UIMain.Cliente.*;
import UIMain.Restaurante.*;
import UIMain.Default.*;

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
	 * Metodo en el se cargan todas las opciones de menu generales.
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
		opciones.add(new cambiarContraCliente()); // 10 cliente
		opciones.add(new CuantosPedidosHeEntregado()); // 11 tendero
		opciones.add(new AceptarPedido()); // 12 tendero
		opciones.add(new cambiarContraseñaTendero()); // 13 tendero
		opciones.add(new EnCualesDirecciones()); // 14 restaurante
		opciones.add(new CrearPlato()); // 15 restaurante
		opciones.add(new AgregarDireccionRest()); // 16 restaurante
		opciones.add(new CambiarPlato()); // 17 restaurante
		opciones.add(new EliminarDireccionRest());// 18 restaurante
		opciones.add(new EliminarPlato()); // 19 restaurante
		opciones.add(new CambiarDireccionRest());// 20 restaurante
		opciones.add(new cambiarContraseñaRestaurante()); // 21 restaurante
		opciones.add(new CrearAdministrador()); // 22 Admin
		opciones.add(new CrearRestaurante()); // 23 admin
		opciones.add(new CrearTendero()); // 24 admin
		opciones.add(new TenderoReparteMas()); // 25 admin
		opciones.add(new QuitarFuncionalidades()); // 26 admin
		opciones.add(new AgregarFuncionalidades()); // 27 admin
		opciones.add(new cambiarContraseñaAdmin()); // 28 Admin
		opciones.add(new Salir()); // 29 todos
		opciones.add(new Entregado()); // 30 tendero

	}

	public static final ArrayList<OpcionDeMenu> getOpciones() {
		return opciones;
	}

	/*private static final String filepathPedido = System.getProperty("user.dir") + "\\src\\BaseDatos\\temp\\" + "pedidoGuardados.json";
	private static final String filepathCliente = System.getProperty("user.dir") + "\\src\\BaseDatos\\temp\\" + "clientesGuardados.json";
	private static final String filepathTendero = System.getProperty("user.dir") + "\\src\\BaseDatos\\temp\\" + "tenderosGuardados.json";
	private static final String filepathAdministrador = System.getProperty("user.dir") + "\\src\\BaseDatos\\temp\\" + "administradoresGuardados.json";
	private static final String filepathRestaurantes = System.getProperty("user.dir") + "\\src\\BaseDatos\\temp\\" + "restaurantesGuardados.json";
	private static final String filepathPlato = System.getProperty("user.dir") + "\\src\\BaseDatos\\temp\\" + "platosGuardados.json";
	static final String filepathNotificacion = System.getProperty("user.dir") + "\\src\\BaseDatos\\temp\\" + "NotificacionesGuardados.json";
	private static final String filepathCalificacion = System.getProperty("user.dir") + "\\src\\BaseDatos\\temp\\" + "CalificacionesGuardados.json";
	*/
	private static final String filepathPedido = "RAPPI2\\src\\BaseDatos\\temp\\" + "pedidoGuardados.json";
	private static final String filepathCliente ="RAPPI2\\src\\BaseDatos\\temp\\" + "clientesGuardados.json";
	private static final String filepathTendero ="RAPPI2\\src\\BaseDatos\\temp\\" + "tenderosGuardados.json";
	private static final String filepathAdministrador ="RAPPI2\\src\\BaseDatos\\temp\\" + "administradoresGuardados.json";
	private static final String filepathRestaurantes ="RAPPI2\\src\\BaseDatos\\temp\\" + "restaurantesGuardados.json";
	private static final String filepathPlato ="RAPPI2\\src\\BaseDatos\\temp\\" + "platosGuardados.json";
	static final String filepathNotificacion ="RAPPI2\\src\\BaseDatos\\temp\\" + "NotificacionesGuardados.json";
	private static final String filepathCalificacion ="RAPPI2\\src\\BaseDatos\\temp\\" + "CalificacionesGuardados.json";
	
	//Aca vamos a organizar el data para que todo se manede desde la ram como pide guzman 
	private static ArrayList<Administrador> dbAdmin = new ArrayList<Administrador>();
	private static ArrayList<Cliente> dbCliente = new ArrayList<Cliente>();
	private static ArrayList<Tendero> dbTendero = new ArrayList<Tendero>();
	private static ArrayList<Restaurante> dbRestaurante = new ArrayList<Restaurante>();
	private static ArrayList<Notificacion> dbNotificacion = new ArrayList<Notificacion>();
	private static ArrayList<Calificacion> dbCalificacion = new ArrayList<Calificacion>();
	private static ArrayList<Pedido> dbPedido = new ArrayList<Pedido>();
	private static ArrayList<Plato> dbPlato = new ArrayList<Plato>();

	// gets para las bases de datos
	public static ArrayList<Administrador> getdbAdmin() {
		return dbAdmin;
	}

	public static ArrayList<Cliente> getdbCliente() {
		return dbCliente;
	}

	public static ArrayList<Tendero> getdbTendero() {
		return dbTendero;
	}

	public static ArrayList<Restaurante> getdbRestaurante() {
		return dbRestaurante;
	}

	public static ArrayList<Notificacion> getdbNotificacion() {
		return dbNotificacion;
	}

	public static ArrayList<Calificacion> getdbCalificacion() {
		return dbCalificacion;
	}

	public static ArrayList<Pedido> getdbPedido() {
		return dbPedido;
	}

	public static ArrayList<Plato> getdbPlato() {
		return dbPlato;
	}

	// sin esto no podemos vivir asi que no tocar
	public static void llenarDataBases() {
		dbAdmin = Data.traerDataBaseAdministrador();
		dbCliente = Data.traerDataBaseCliente();
		dbTendero = Data.traerDataBaseTendero();
		dbRestaurante = Data.traerDataBaseRestaurante();
		dbNotificacion = Data.traerDataBaseNotificacion();
		dbCalificacion = Data.traerDataBaseCalificacion();
		dbPedido = Data.traerDataBasePedido();
		dbPlato = Data.traerDataBasePlato();

	}

	// si lo llenan mal tambien morimos
	public static void actualizarDataBases() {
		Data.actualizarDataBaseAdministrador(dbAdmin);
		Data.actualizarDataBaseCliente(dbCliente);
		Data.actualizarDataBasePedido(dbPedido);
		Data.actualizarDataBaseTendero(dbTendero);
		Data.actualizarDataBasePlato(dbPlato);
		Data.actualizarDataBaseCalificacion(dbCalificacion);
		Data.actualizarDataBaseRestaurante(dbRestaurante);
		Data.actualizarDataBaseNotificacion(dbNotificacion);
	}

	// metodos en RAM para Administrador
	/**
	 * Metodo que se usa para agregar objetos a la base de datos de administradores
	 * 
	 * @see: {@link #traerDataBaseAdministrador()}
	 * @see: {@link #actualizarDataBaseAdministrador(JsonArray)}
	 */
	public static void agregarObjetoDataBaseAdministrador(Administrador obj) {
		int index=0;
		for(int i = 0; i<dbAdmin.size();i++) {
			if(dbAdmin.get(i).getUserName().equals(obj.getUserName())) {
				index++;
				break;
			}
		}
		if(index==0) {
			dbAdmin.add(obj);
		}
		Data.actualizarDataBaseAdministrador(dbAdmin);
	}

	/**
	 * Metodo que elimina cierto objeto de la dataBaseAdministrador
	 * 
	 * @see: {@link #traerDataBaseAdministrador()}
	 * @see: {@link #actualizarDataBaseAdministrador(JsonArray)}
	 */
	public static void eliminarObjetoDataBaseAdministrador(Administrador obj) {
		String userName = obj.getUserName();
		for (int i = 0; i < dbAdmin.size(); i++) {
			if (dbAdmin.get(i).getUserName().equals(userName)) {
				dbAdmin.remove(i);
			}
		}
		Data.actualizarDataBaseAdministrador(dbAdmin);
	}

	/**
	 * Metodo para buscar un usuario en la base de datos de administrador usando
	 * solo el userName
	 * 
	 * @see: {@link #traerDataBaseAdministrador()}
	 */
	public static Administrador buscarAdministrador(String userName) {
		Administrador administrador = null;
		for (Administrador a : dbAdmin) {
			if (userName.equals(a.getUserName())) {
				administrador = a;
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
		for (Administrador a : dbAdmin) {
			if (userName.equals(a.getUserName()) && clave.equals(a.getClave())) {
				administrador = a;
			}
		}
		return administrador;
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

	// Cliente
	// metodos en RAM para Cliente
	/**
	 * Metodo que se usa para agregar objetos a la base de datos de Clientes
	 * 
	 * @see: {@link #traerDataBaseCliente()}
	 * @see: {@link #actualizarDataBaseCliente(JsonArray)}
	 */
	public static void agregarObjetoDataBaseCliente(Cliente obj) {
		int index=0;
		for(int i = 0; i<dbCliente.size();i++) {
			if(dbCliente.get(i).getUserName().equals(obj.getUserName())) {
				index++;
				break;
			}
		}
		if(index==0) {
			dbCliente.add(obj);
		}
		Data.actualizarDataBaseCliente(dbCliente);
	}

	/**
	 * Metodo que elimina cierto objeto de la dataBaseCliente
	 * 
	 * @see: {@link #traerDataBaseCliente()}
	 * @see: {@link #actualizarDataBaseCliente(JsonArray)}
	 */
	public static void eliminarObjetoDataBaseCliente(Cliente obj) {
		String userName = obj.getUserName();
		for (int i = 0; i < dbCliente.size(); i++) {
			if (dbCliente.get(i).getUserName().equals(userName)) {
				dbCliente.remove(i);
			}
		}
		Data.actualizarDataBaseCliente(dbCliente);
	}

	/**
	 * Metodo para buscar un usuario en la base de datos de Cliente usando solo el
	 * userName
	 * 
	 * @see: {@link #traerDataBaseCliente()}
	 */
	public static Cliente buscarCliente(String userName) {
		Cliente cliente = null;
		for (Cliente a : dbCliente) {
			if (userName.equals(a.getUserName())) {
				cliente = a;
			}
		}
		return cliente;
	}

	/**
	 * Metodo para buscar un usuario en la base de datos de Cliente usando el
	 * userName y la clave del usuario
	 * 
	 * @see: {@link #traerDataBaseCliente()}
	 */
	public static Cliente buscarCliente(String userName, String clave) {
		Cliente cliente = null;
		for (Cliente a : dbCliente) {
			if (userName.equals(a.getUserName()) && clave.equals(a.getClave())) {
				cliente = a;
			}
		}
		return cliente;
	}

	/**
	 * El metodo actualiza en la base de datos el cliente
	 * 
	 * @param administrador El parametro define el cliente que va a ser actualizado
	 */
	public static void actualizarDataBaseCliente(Cliente cliente) {
		Cliente aux = cliente;
		Data.eliminarObjetoDataBaseCliente(Data.buscarCliente(cliente.getUserName()));
		Data.agregarObjetoDataBaseCliente(aux);
	}

	/**
	 * Metodo que lee la base de datos de clientes desde su file y obtiene los
	 * objetos alli guardados
	 */
	public static ArrayList<Cliente> traerDataBaseCliente() {
		Gson gson = new Gson();
		JsonParser jp = new JsonParser();
		ArrayList<Cliente> clientes = new ArrayList<>();
		try (FileReader fr = new FileReader(filepathCliente)) {
			Object obj = jp.parse(fr);
			JsonArray array = (JsonArray) obj;
			for (JsonElement jsonElement : array) {
				JsonObject aux = jsonElement.getAsJsonObject();
				clientes.add(gson.fromJson(aux, Cliente.class));
			}
			return clientes;
		} catch (Exception ex) {
			System.out.println("No se puede traer la dataBaseCliente correctamente");
			return null;
		}
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

	public static void agregarObjetoDataBaseRestaurante(Restaurante obj) {
		int in = 0;
		for (int i = 0; i < dbRestaurante.size(); i++) {
			if (dbRestaurante.get(i).getNombre().equals(obj.getNombre())) {
				in++;
				break;
			}
		}
		if (in == 0) {
			dbRestaurante.add(obj);
		}
		Data.actualizarDataBaseRestaurante(dbRestaurante);
	}

	// RESTAURANTE
	// metodos en RAM para RESTAURANTE
	/**
	 * Metodo que elimina cierto objeto de la dataBaseRestaurante
	 * 
	 * @see: {@link #traerDataBaseRestaurante()}
	 * @see: {@link #actualizarDataBaseRestaurante(JsonArray)}
	 */
	public static void eliminarObjetoDataBaseRestaurante(Restaurante obj) {
		String userName = obj.getNombre();
		for (int i = 0; i < dbRestaurante.size(); i++) {
			if (dbRestaurante.get(i).getNombre().equals(userName)) {
				dbRestaurante.remove(i);
			}
		}
		Data.actualizarDataBaseRestaurante(dbRestaurante);
	}

	/**
	 * Metodo para buscar un usuario en la base de datos de restaurante usando solo
	 * el nombre
	 * 
	 * @see: {@link #traerDataBaseAdministrador()}
	 */
	public static Restaurante buscarRestaurante(String userName) {
		Restaurante restaurante = null;
		for (Restaurante r : dbRestaurante) {
			if (userName.equals(r.getNombre())) {
				restaurante = r;
			}
		}
		return restaurante;
	}

	/**
	 * Metodo para buscar un usuario en la base de datos de restaurante usando el
	 * userName y la clave del usuario
	 * 
	 * @see: {@link #traerDataBaseAdministrador()}
	 */
	public static Restaurante buscarRestaurante(String userName, String clave) {
		Restaurante restaurante = null;
		for (Restaurante r : dbRestaurante) {
			if (userName.equals(r.getNombre()) && clave.equals(r.getClave())) {
				restaurante = r;
			}
		}
		return restaurante;
	}

	/**
	 * El metodo actualiza en la base de datos del restaurante
	 * 
	 * @param administrador El parametro define el restaurante que va a ser
	 *                      actualizado
	 */
	public static void actualizarDataBaseRestaurante(Restaurante restaurante) {
		Restaurante aux = restaurante;
		Data.eliminarObjetoDataBaseRestaurante(Data.buscarRestaurante(restaurante.getNombre()));
		Data.agregarObjetoDataBaseRestaurante(aux);
	}

	// PEDIDO
	// metodos en RAM para Pedido
	/**
	 * Metodo que se usa para agregar objetos a la base de datos de Tendero
	 * 
	 * @see: {@link #traerDataBaseTendero()}
	 * @see: {@link #actualizarDataBaseTendero(JsonArray)}
	 */
	public static void agregarObjetoDataBasePedido(Pedido obj) {
		int in = 0;
		for (int i = 0; i < dbPedido.size(); i++) {
			if (dbPedido.get(i).getId() == (obj.getId())) {
				in++;
				break;
			}
		}
		if (in == 0) {
			dbPedido.add(obj);
		}

		Data.actualizarDataBasePedido(dbPedido);
	}

	/**
	 * Metodo que elimina cierto objeto de la dataBaseTendero
	 * 
	 * @see: {@link #traerDataBaseTendero()}
	 * @see: {@link #actualizarDataBaseTendero(JsonArray)}
	 */
	public static void eliminarObjetoDataBasePedido(Pedido obj) {
		int userName = obj.getId();
		for (int i = 0; i < dbPedido.size(); i++) {
			if (dbPedido.get(i).getId() == (userName)) {
				dbPedido.remove(i);
			}
		}
		Data.actualizarDataBasePedido(dbPedido);
	}

	/**
	 * Metodo para buscar un usuario en la base de datos de Pedido usando solo el ID
	 * 
	 * @see: {@link #traerDataBasePedido()}
	 */
	public static Pedido buscarPedido(int ID) {
		Pedido pedido = null;
		for (Pedido a : dbPedido) {
			if (ID == (a.getId())) {
				pedido = a;
			}
		}
		return pedido;
	}

	/**
	 * El metodo actualiza en la base de datos el Pedido
	 * 
	 * @param administrador El parametro define el Pedido que va a ser actualizado
	 */
	public static void actualizarDataBasePedido(Pedido pedido) {
		Pedido aux = pedido;
		Data.eliminarObjetoDataBasePedido(Data.buscarPedido(pedido.getId()));
		Data.agregarObjetoDataBasePedido(aux);
	}

	/**
	 * Metodo que lee la base de datos de Pedidos desde su file y obtiene los
	 * objetos alli guardados
	 */
	public static ArrayList<Pedido> traerDataBasePedido() {
		Gson gson = new Gson();
		JsonParser jp = new JsonParser();
		ArrayList<Pedido> pedidos = new ArrayList<>();
		try (FileReader fr = new FileReader(filepathPedido)) {
			Object obj = jp.parse(fr);
			JsonArray array = (JsonArray) obj;
			for (JsonElement jsonElement : array) {
				JsonObject aux = jsonElement.getAsJsonObject();
				pedidos.add(gson.fromJson(aux, Pedido.class));
			}
			return pedidos;
		} catch (Exception ex) {
			System.out.println("No se puede traer la dataBasePedido correctamente");
			return null;
		}
	}

	/**
	 * Metodo que se usa al principio del Main para cargar el file con la base de
	 * datos de pedidos
	 * 
	 * @see: {@link #traerDataBasePedido()}
	 */
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

	// TENDERO
	// metodos en RAM para Tendero
	/**
	 * Metodo que se usa para agregar objetos a la base de datos de Tendero
	 * 
	 * @see: {@link #traerDataBaseTendero()}
	 * @see: {@link #actualizarDataBaseTendero(JsonArray)}
	 */
	public static void agregarObjetoDataBaseTendero(Tendero obj) {

		int in = 0;
		for (int i = 0; i < dbTendero.size(); i++) {
			if (dbTendero.get(i).getUserName().equals(obj.getUserName())) {
				in++;
				break;
			}
		}
		if (in == 0) {
			dbTendero.add(obj);
		}
		Data.actualizarDataBaseTendero(dbTendero);
	}

	/**
	 * Metodo que elimina cierto objeto de la dataBaseTendero
	 * 
	 * @see: {@link #traerDataBaseTendero()}
	 * @see: {@link #actualizarDataBaseTendero(JsonArray)}
	 */
	public static void eliminarObjetoDataBaseTendero(Tendero obj) {
		String userName = obj.getUserName();
		for (int i = 0; i < dbTendero.size(); i++) {
			if (dbTendero.get(i).getUserName().equals(userName)) {
				dbTendero.remove(i);
			}
		}
		Data.actualizarDataBaseTendero(dbTendero);
	}

	/**
	 * Metodo para buscar un usuario en la base de datos de Tendero usando solo el
	 * userName
	 * 
	 * @see: {@link #traerDataBaseTendero()}
	 */
	public static Tendero buscarTendero(String userName) {
		Tendero tendero = null;
		for (Tendero a : dbTendero) {
			if (userName.equals(a.getUserName())) {
				tendero = a;
			}
		}
		return tendero;
	}

	/**
	 * Metodo para buscar un usuario en la base de datos de Tendero usando el
	 * userName y la clave del usuario
	 * 
	 * @see: {@link #traerDataBaseTendero()}
	 */
	public static Tendero buscarTendero(String userName, String clave) {
		Tendero tendero = null;
		for (Tendero a : dbTendero) {
			if (userName.equals(a.getUserName()) && clave.equals(a.getClave())) {
				tendero = a;
			}
		}
		return tendero;
	}

	/**
	 * El metodo actualiza en la base de datos el tendero
	 * 
	 * @param administrador El parametro define el tendero que va a ser actualizado
	 */
	public static void actualizarDataBaseTendero(Tendero tendero) {
		Tendero aux = tendero;
		Data.eliminarObjetoDataBaseTendero(Data.buscarTendero(tendero.getUserName()));
		Data.agregarObjetoDataBaseTendero(aux);
	}

	/**
	 * Metodo que lee la base de datos de tenderos desde su file y obtiene los
	 * objetos alli guardados
	 */
	public static ArrayList<Tendero> traerDataBaseTendero() {
		Gson gson = new Gson();
		JsonParser jp = new JsonParser();
		ArrayList<Tendero> tenderos = new ArrayList<>();
		try (FileReader fr = new FileReader(filepathTendero)) {
			Object obj = jp.parse(fr);
			JsonArray array = (JsonArray) obj;
			for (JsonElement jsonElement : array) {
				JsonObject aux = jsonElement.getAsJsonObject();
				tenderos.add(gson.fromJson(aux, Tendero.class));
			}
			return tenderos;
		} catch (Exception ex) {
			System.out.println("No se puede traer la dataBaseTendero correctamente");
			return null;
		}
	}

	/**
	 * Metodo que se usa al principio del Main para cargar el file con la base de
	 * datos de clientes
	 * 
	 * @see: {@link #traerDataBaseCliente()}
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

	// PLATO
	// metodos en RAM para Plato
	/**
	 * Metodo que se usa para agregar objetos a la base de datos de Platos
	 * 
	 * @see: {@link #traerDataBasePlato()}
	 * @see: {@link #actualizarDataBasePlato(JsonArray)}
	 */
	public static void agregarObjetoDataBasePlato(Plato obj) {

		int in = 0;
		for (int i = 0; i < dbPlato.size(); i++) {
			if (dbPlato.get(i).getNombre().equals(obj.getNombre())) {
				in++;
				break;
			}
		}
		if (in == 0) {
			dbPlato.add(obj);
		}

		Data.actualizarDataBasePlato(dbPlato);
	}

	/**
	 * Metodo que elimina cierto objeto de la dataBasePlato
	 * 
	 * @see: {@link #traerDataBasePlato()}
	 * @see: {@link #actualizarDataBasePlato(JsonArray)}
	 */
	public static void eliminarObjetoDataBasePlato(Plato obj) {
		String userName = obj.getNombre();
		for (int i = 0; i < dbPlato.size(); i++) {
			if (dbPlato.get(i).getNombre().equals(userName)) {
				dbPlato.remove(i);
			}
		}
		Data.actualizarDataBasePlato(dbPlato);
	}

	/**
	 * Metodo para buscar un Plato en la base de datos de Platos usando solo el
	 * nombre
	 * 
	 * @see: {@link #traerDataBasePlato()}
	 */
	public static Plato buscarPlato(String nombre) {
		Plato plato = null;
		for (Plato a : dbPlato) {
			if (nombre.equals(a.getNombre())) {
				plato = a;
			}
		}
		return plato;
	}

	/**
	 * El metodo actualiza en la base de datos el administrador
	 * 
	 * @param administrador El parametro define el administrador que va a ser
	 *                      actualizado
	 */
	public static void actualizarDataBasePlato(Plato plato) {
		Plato aux = plato;
		Data.eliminarObjetoDataBasePlato(Data.buscarPlato(plato.getNombre()));
		Data.agregarObjetoDataBasePlato(aux);
	}

	/**
	 * Metodo que lee la base de datos de Platos desde su file y obtiene los objetos
	 * alli guardados
	 */
	public static ArrayList<Plato> traerDataBasePlato() {
		Gson gson = new Gson();
		JsonParser jp = new JsonParser();
		ArrayList<Plato> platos = new ArrayList<>();
		try (FileReader fr = new FileReader(filepathPlato)) {
			Object obj = jp.parse(fr);
			JsonArray array = (JsonArray) obj;
			for (JsonElement jsonElement : array) {
				JsonObject aux = jsonElement.getAsJsonObject();
				platos.add(gson.fromJson(aux, Plato.class));
			}
			return platos;
		} catch (Exception ex) {
			System.out.println("No se puede traer la dataBasePlato correctamente");
			return null;
		}
	}

	/**
	 * Metodo que se usa al principio del Main para cargar el file con la base de
	 * datos de platos
	 * 
	 * @see: {@link #traerDataBasePlatos()}
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

	// CALIFICACION
	// metodos en RAM para Calificacion
	/**
	 * Metodo que se usa para agregar objetos a la base de datos de Calificacion
	 * 
	 * @see: {@link #traerDataBaseCalificacion()}
	 * @see: {@link #actualizarDataBaseCalificacion(JsonArray)}
	 */
	public static void agregarObjetoDataBaseCalificacion(Calificacion obj) {

		int in = 0;
		for (int i = 0; i < dbCalificacion.size(); i++) {
			if (dbCalificacion.get(i).getID() == (obj.getID())) {
				in++;
				break;
			}
		}
		if (in == 0) {
			dbCalificacion.add(obj);
		}
		Data.actualizarDataBaseCalificacion(dbCalificacion);
	}

	/**
	 * Metodo que elimina cierto objeto de la dataBaseCalificacion
	 * 
	 * @see: {@link #traerDataBaseCalificacion()}
	 * @see: {@link #actualizarDataBaseCalificacion(JsonArray)}
	 */
	public static void eliminarObjetoDataBaseCalificacion(Calificacion obj) {
		int userName = obj.getID();
		for (int i = 0; i < dbCalificacion.size(); i++) {
			if (dbCalificacion.get(i).getID() == (userName)) {
				dbCalificacion.remove(i);
			}
		}
		Data.actualizarDataBaseCalificacion(dbCalificacion);
	}

	public static void actualizarDataBaseCalificacion(ArrayList<Calificacion> array) {
		Gson gson = new Gson();
		JsonArray aux = gson.fromJson(gson.toJson(array), JsonArray.class);
		try (FileWriter fw = new FileWriter(filepathCalificacion)) {
			fw.write(aux.toString());
			fw.flush();
		} catch (IOException e) {
			System.out.println("No se puede actualizar la dataBaseCalificacion correctamente");
		}
	}

	/**
	 * Metodo para buscar un usuario en la base de datos de Calificacion usando solo
	 * el ID
	 * 
	 * @see: {@link #traerDataBasePedido()}
	 */
	public static Calificacion buscarCalificacion(int ID) {
		Calificacion calificacion = null;
		for (Calificacion a : dbCalificacion) {
			if (ID == (a.getID())) {
				calificacion = a;
			}
		}
		return calificacion;
	}

	/**
	 * El metodo actualiza en la base de datos el Pedido
	 * 
	 * @param administrador El parametro define el Pedido que va a ser actualizado
	 */
	public static void actualizarDataBaseCalificacion(Calificacion calificacion) {
		Calificacion aux = calificacion;
		Data.eliminarObjetoDataBaseCalificacion(Data.buscarCalificacion(calificacion.getID()));
		Data.agregarObjetoDataBaseCalificacion(aux);
	}

	/**
	 * Metodo que lee la base de datos de Pedidos desde su file y obtiene los
	 * objetos alli guardados
	 */
	public static ArrayList<Calificacion> traerDataBaseCalificacion() {
		Gson gson = new Gson();
		JsonParser jp = new JsonParser();
		ArrayList<Calificacion> calificacion = new ArrayList<>();
		try (FileReader fr = new FileReader(filepathCalificacion)) {
			Object obj = jp.parse(fr);
			JsonArray array = (JsonArray) obj;
			for (JsonElement jsonElement : array) {
				JsonObject aux = jsonElement.getAsJsonObject();
				calificacion.add(gson.fromJson(aux, Calificacion.class));
			}
			return calificacion;
		} catch (Exception ex) {
			System.out.println("No se puede traer la dataBaseCalificaciones correctamente");
			return null;
		}
	}

	public static void LlenarTenderos() {
		if (Data.traerDataBaseTendero().size() != 0) {
			for (Tendero je : Data.traerDataBaseTendero()) {
				if (je != null) {
					Main.tenderos.add(je.getUserName());
				}
			}
		}
	}

	// NOTIFICACION
	// metodos en RAM para NOTIFICACION
	/**
	 * Metodo que elimina cierto objeto de la dataBaseNotificacion
	 * 
	 * @see: {@link #traerDataBaseNotificacion()}
	 * @see: {@link #actualizarDataBaseNotificacion(JsonArray)}
	 */
	public static void eliminarObjetoDataBaseNotificacion(Notificacion obj) {
		int id = obj.getID();
		for (int i = 0; i < dbNotificacion.size(); i++) {
			if (dbNotificacion.get(i).getID() == id) {
				dbNotificacion.remove(i);
			}
		}
		Data.actualizarDataBaseNotificacion(dbNotificacion);
	}

	/**
	 * Metodo para buscar un usuario en la base de datos de restaurante usando solo
	 * el nombre
	 * 
	 * @see: {@link #traerDataBaseAdministrador()}
	 */
	public static Notificacion buscarNotificacion(int id) {
		Notificacion notificacion = null;
		for (Notificacion n : dbNotificacion) {
			if (id == n.getID()) {
				notificacion = n;
			}
		}
		return notificacion;
	}

	/**
	 * El metodo actualiza en la base de datos del restaurante
	 * 
	 * @param administrador El parametro define el restaurante que va a ser
	 *                      actualizado
	 */
	public static void actualizarDataBaseNotificacion(Notificacion notificacion) {
		Notificacion aux = notificacion;
		Data.eliminarObjetoDataBaseNotificacion(Data.buscarNotificacion(notificacion.getID()));
		Data.agregarObjetoDataBaseNotificacion(aux);
	}

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

	public static ArrayList<Notificacion> traerDataBaseNotificacion() {
		Gson gson = new Gson();
		JsonParser jp = new JsonParser();
		ArrayList<Notificacion> notificaciones = new ArrayList<>();
		try (FileReader fr = new FileReader(filepathNotificacion)) {
			Object obj = jp.parse(fr);
			JsonArray array = (JsonArray) obj;
			for (JsonElement jsonElement : array) {
				JsonObject aux = jsonElement.getAsJsonObject();
				notificaciones.add(gson.fromJson(aux, Notificacion.class));
			}
			return notificaciones;
		} catch (Exception ex) {
			System.out.println("No se puede traer la dataBaseNotificacion correctamente");
			return null;
		}
	}

	public static void actualizarDataBaseNotificacion(ArrayList<Notificacion> array) {
		Gson gson = new Gson();
		JsonArray aux = gson.fromJson(gson.toJson(array), JsonArray.class);
		try (FileWriter fw = new FileWriter(filepathNotificacion)) {
			fw.write(aux.toString());
			fw.flush();
		} catch (IOException e) {
			System.out.println("No se puede actualizar la dataBaseNotificacion correctamente");
		}
	}

	/*
	 * public static void actualizarDataBaseNotificacion(Notificacion notificacion)
	 * { Notificacion aux = notificacion;
	 * Data.eliminarObjetoDataBaseNotificacion(Data.buscarNotificacion(notificacion.
	 * getID())); Data.agregarObjetoDataBaseNotificacion(aux); }
	 */

	public static void agregarObjetoDataBaseNotificacion(Notificacion obj) {

		int in = 0;
		for (int i = 0; i < dbNotificacion.size(); i++) {
			if (dbNotificacion.get(i).getID() == (obj.getID())) {
				in++;
				break;
			}
		}
		if (in == 0) {
			dbNotificacion.add(obj);
		}
		Data.actualizarDataBaseNotificacion(dbNotificacion);
	}

	/*
	 * public static void eliminarObjetoDataBaseNotificacion(Notificacion obj) {
	 * ArrayList<Notificacion> dataBase = Data.traerDataBaseNotificacion(); int id =
	 * obj.getID(); for(int i = 0;i<dataBase.size();i++) {
	 * if(dataBase.get(i).getID()==id) { dataBase.remove(i); } }
	 * Data.actualizarDataBaseNotificacion(dataBase); }
	 */

	/*
	 * public static Notificacion buscarNotificacion(int ID) { Notificacion
	 * notificacion = null; ArrayList<Notificacion> dataBase =
	 * Data.traerDataBaseNotificacion(); for (Notificacion n : dataBase) { if
	 * (n.getID()==ID) { notificacion = n; } } return notificacion; }
	 */
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

	/*
	 * public static ArrayList<Calificacion> traerDataBaseCalificacion() { Gson gson
	 * = new Gson(); JsonParser jp = new JsonParser(); ArrayList<Calificacion>
	 * calificaciones = new ArrayList<>(); try (FileReader fr = new
	 * FileReader(filepathCalificacion)) { Object obj = jp.parse(fr); JsonArray
	 * array = (JsonArray) obj; for(JsonElement jsonElement : array){ JsonObject aux
	 * = jsonElement.getAsJsonObject(); calificaciones.add(gson.fromJson(aux,
	 * Calificacion.class)); } return calificaciones; } catch (Exception ex) {
	 * System.out.println("No se puede traer la dataBaseCalificacion correctamente"
	 * ); return null; } }
	 * 
	 * public static void actualizarDataBaseCalificacion(ArrayList<Calificacion>
	 * array) { Gson gson = new Gson(); JsonArray aux =
	 * gson.fromJson(gson.toJson(array), JsonArray.class); try (FileWriter fw = new
	 * FileWriter(filepathCalificacion)) { fw.write(aux.toString()); fw.flush(); }
	 * catch (IOException e) { System.out.
	 * println("No se puede actualizar la dataBaseCalificacion correctamente"); } }
	 * 
	 * public static void actualizarDataBaseCalificacion(Calificacion calificacion)
	 * { Calificacion aux = calificacion;
	 * Data.eliminarObjetoDataBaseCalificacion(Data.buscarCalificacion(calificacion.
	 * getID())); Data.agregarObjetoDataBaseCalificacion(aux); }
	 * 
	 * public static void agregarObjetoDataBaseCalificacion(Calificacion obj) {
	 * ArrayList<Calificacion> dataBase = Data.traerDataBaseCalificacion(); if
	 * (!dataBase.contains(obj)) { dataBase.add(obj);
	 * Data.actualizarDataBaseCalificacion(dataBase); } else {
	 * System.out.println("no se puede agregar la calificacion a la base de datos");
	 * } }
	 * 
	 * public static void eliminarObjetoDataBaseCalificacion(Calificacion obj) {
	 * ArrayList<Calificacion> dataBase = Data.traerDataBaseCalificacion(); int id =
	 * obj.getID(); for(int i = 0;i<dataBase.size();i++) {
	 * if(dataBase.get(i).getID()==id) { dataBase.remove(i); } }
	 * Data.actualizarDataBaseCalificacion(dataBase); }
	 * 
	 * public static Calificacion buscarCalificacion(int ID) { Calificacion
	 * calificacion = null; ArrayList<Calificacion> dataBase =
	 * Data.traerDataBaseCalificacion(); for (Calificacion c : dataBase) { if
	 * (c.getID()==ID) { calificacion = c; } } return calificacion; }
	 */
	/**
	 * Metodo que se usa al principio del Main para cargar el file con la base de
	 * datos de plato
	 * 
	 * @see: {@link #traerDataBasePlato()}
	 */
	/*
	 * public static File cargarFileDataBasePlato() throws IOException { Gson gson =
	 * new Gson(); File DataBase = new File(filepathPlato); if
	 * (Data.traerDataBasePlato() != null) {
	 * System.out.println("La dataBasePlato se ha cargado correctamente"); } else {
	 * System.out.println("La dataBasePlato se ha creado correctamente"); Plato[]
	 * aux = new Plato[0]; JsonArray array = gson.fromJson(gson.toJson(aux),
	 * JsonArray.class); try (FileWriter fw = new FileWriter(filepathPlato)) {
	 * fw.write(array.toString()); fw.flush(); } catch (IOException e) { } } return
	 * DataBase; }
	 */
	/**
	 * Metodo que se usa al principio del Main para cargar el file con la base de
	 * datos de clientes
	 * 
	 * @see: {@link #traerDataBaseCliente()}
	 */
	/*
	 * public static File cargarFileDataBaseCliente() throws IOException { Gson gson
	 * = new Gson(); File DataBase = new File(filepathCliente); if
	 * (Data.traerDataBaseCliente() != null) {
	 * System.out.println("La dataBaseCliente se ha cargado correctamente"); } else
	 * { System.out.println("La dataBaseCliente se ha creado correctamente");
	 * Cliente[] aux = new Cliente[0]; JsonArray array =
	 * gson.fromJson(gson.toJson(aux), JsonArray.class); try (FileWriter fw = new
	 * FileWriter(filepathCliente)) { fw.write(array.toString()); fw.flush(); }
	 * catch (IOException e) { } } return DataBase; }
	 */
	/**
	 * Metodo que se usa al principio del Main para cargar el file con la base de
	 * datos de tenderos
	 * 
	 * @see: {@link #traerDataBaseTendero()}
	 */

	/*
	 * public static File cargarFileDataBaseTendero() throws IOException { Gson gson
	 * = new Gson(); File DataBase = new File(filepathTendero); if
	 * (Data.traerDataBaseTendero() != null) {
	 * System.out.println("La dataBaseTendero se ha cargado correctamente"); } else
	 * { System.out.println("La dataBaseTendero se ha creado correctamente");
	 * Tendero[] aux = new Tendero[0]; JsonArray array =
	 * gson.fromJson(gson.toJson(aux), JsonArray.class); try (FileWriter fw = new
	 * FileWriter(filepathTendero)) { fw.write(array.toString()); fw.flush(); }
	 * catch (IOException e) { } } return DataBase; }
	 */
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

	/*
	 * public static File cargarFileDataBasePedido() throws IOException { Gson gson
	 * = new Gson(); File DataBase = new File(filepathPedido); if
	 * (Data.traerDataBasePedido() != null) {
	 * System.out.println("La dataBasePedido se ha cargado correctamente"); } else {
	 * System.out.println("La dataBasePedido se ha creado correctamente"); Pedido[]
	 * aux = new Pedido[0]; JsonArray array = gson.fromJson(gson.toJson(aux),
	 * JsonArray.class); try (FileWriter fw = new FileWriter(filepathPedido)) {
	 * fw.write(array.toString()); fw.flush(); } catch (IOException e) { } } return
	 * DataBase; }
	 */
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
	/*
	 * public static ArrayList<Plato> traerDataBasePlato() { Gson gson = new Gson();
	 * JsonParser jp = new JsonParser(); ArrayList<Plato> platos = new
	 * ArrayList<>(); try (FileReader fr = new FileReader(filepathPlato)) { Object
	 * obj = jp.parse(fr); JsonArray array = (JsonArray) obj; for(JsonElement
	 * jsonElement : array){ JsonObject aux = jsonElement.getAsJsonObject();
	 * platos.add(gson.fromJson(aux, Plato.class)); } return platos; } catch
	 * (Exception ex) {
	 * System.out.println("No se puede traer la dataBasePlato correctamente");
	 * return null; } }
	 */
	/**
	 * Metodo que lee la base de datos de tenderos desde su file y obtiene los
	 * objetos alli guardados
	 */

	/*
	 * public static ArrayList<Tendero> traerDataBaseTendero() { Gson gson = new
	 * Gson(); JsonParser jp = new JsonParser(); ArrayList<Tendero> tenderos = new
	 * ArrayList<>(); try (FileReader fr = new FileReader(filepathTendero)) { Object
	 * obj = jp.parse(fr); JsonArray array = (JsonArray) obj; for(JsonElement
	 * jsonElement : array){ JsonObject aux = jsonElement.getAsJsonObject();
	 * tenderos.add(gson.fromJson(aux, Tendero.class)); } return tenderos; } catch
	 * (Exception ex) {
	 * System.out.println("No se puede traer la dataBaseTendero correctamente");
	 * return null; }
	 * 
	 * }
	 */
	/**
	 * Metodo que lee la base de datos de administradores desde su file y obtiene
	 * los objetos alli guardados
	 */
	public static ArrayList<Administrador> traerDataBaseAdministrador() {
		Gson gson = new Gson();
		JsonParser jp = new JsonParser();
		ArrayList<Administrador> administradores = new ArrayList<>();
		try (FileReader fr = new FileReader(filepathAdministrador)) {
			Object obj = jp.parse(fr);
			JsonArray array = (JsonArray) obj;
			for (JsonElement jsonElement : array) {
				JsonObject aux = jsonElement.getAsJsonObject();
				administradores.add(gson.fromJson(aux, Administrador.class));
			}
			return administradores;
		} catch (Exception ex) {
			System.out.println("No se puede traer la dataBaseAdministrador correctamente");
			return null;
		}
	}

	/**
	 * Metodo que lee la base de datos de restaurantes desde su file para asi
	 * obtener aquellos objetos creados previamente
	 */
	public static ArrayList<Restaurante> traerDataBaseRestaurante() {
		Gson gson = new Gson();
		JsonParser jp = new JsonParser();
		ArrayList<Restaurante> restaurantes = new ArrayList<>();
		try (FileReader fr = new FileReader(filepathRestaurantes)) {
			Object obj = jp.parse(fr);
			JsonArray array = (JsonArray) obj;
			for (JsonElement jsonElement : array) {
				JsonObject aux = jsonElement.getAsJsonObject();
				restaurantes.add(gson.fromJson(aux, Restaurante.class));
			}
			return restaurantes;
		} catch (Exception ex) {
			System.out.println("No se puede traer la dataBaseRestaurantes correctamente");
			return null;
		}
	}

	/*
	 * public static ArrayList<Pedido> traerDataBasePedido() { Gson gson = new
	 * Gson(); JsonParser jp = new JsonParser(); ArrayList<Pedido> pedidos = new
	 * ArrayList<>(); try (FileReader fr = new FileReader(filepathPedido)) { Object
	 * obj = jp.parse(fr); JsonArray array = (JsonArray) obj; for(JsonElement
	 * jsonElement : array){ JsonObject aux = jsonElement.getAsJsonObject();
	 * pedidos.add(gson.fromJson(aux, Pedido.class)); } return pedidos; } catch
	 * (Exception ex) {
	 * System.out.println("No se puede traer la dataBasePedido correctamente");
	 * return null; } }
	 */
	/**
	 * Metodo que se usa para actualizar las bases de datos de clientes, escribiendo
	 * los nuevos objetos que se necesiten guardar
	 */
	public static void actualizarDataBasePlato(ArrayList<Plato> array) {
		Gson gson = new Gson();
		JsonArray aux = gson.fromJson(gson.toJson(array), JsonArray.class);
		try (FileWriter fw = new FileWriter(filepathPlato)) {
			fw.write(aux.toString());
			fw.flush();
		} catch (IOException e) {
			System.out.println("No se puede actualizar la dataBasePlato correctamente");
		}
	}

	/**
	 * Metodo que se usa para actualizar las bases de datos de clientes, escribiendo
	 * los nuevos objetos que se necesiten guardar
	 */
	public static void actualizarDataBaseCliente(ArrayList<Cliente> array) {
		Gson gson = new Gson();
		JsonArray aux = gson.fromJson(gson.toJson(array), JsonArray.class);
		try (FileWriter fw = new FileWriter(filepathCliente)) {
			fw.write(aux.toString());
			fw.flush();
		} catch (IOException e) {
			System.out.println("No se puede actualizar la dataBaseCliente correctamente");
		}
	}

	/**
	 * Metodo que se usa para actualizar las bases de datos de tenderos, escribiendo
	 * los nuevos objetos que se necesiten guardar
	 */
	public static void actualizarDataBaseTendero(ArrayList<Tendero> array) {
		Gson gson = new Gson();
		JsonArray aux = gson.fromJson(gson.toJson(array), JsonArray.class);
		try (FileWriter fw = new FileWriter(filepathTendero)) {
			fw.write(aux.toString());
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
	public static void actualizarDataBaseAdministrador(ArrayList<Administrador> array) {
		Gson gson = new Gson();
		JsonArray aux = gson.fromJson(gson.toJson(array), JsonArray.class);
		try (FileWriter fw = new FileWriter(filepathAdministrador)) {
			fw.write(aux.toString());
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
	public static void actualizarDataBaseRestaurante(ArrayList<Restaurante> array) {
		Gson gson = new Gson();
		JsonArray aux = gson.fromJson(gson.toJson(array), JsonArray.class);
		try (FileWriter fw = new FileWriter(filepathRestaurantes)) {
			fw.write(aux.toString());
			fw.flush();
		} catch (IOException ex) {
			System.out.println("No se puede actualizar la dataBaseRestaurante correctamente");
		}
	}

	public static void actualizarDataBasePedido(ArrayList<Pedido> array) {
		Gson gson = new Gson();
		JsonArray aux = gson.fromJson(gson.toJson(array), JsonArray.class);
		try (FileWriter fw = new FileWriter(filepathPedido)) {
			fw.write(aux.toString());
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
	/*
	 * public static void actualizarDataBaseCliente(Cliente cliente) { Cliente aux =
	 * cliente;
	 * Data.eliminarObjetoDataBaseCliente(Data.buscarCliente(cliente.getUserName()))
	 * ; Data.agregarObjetoDataBaseCliente(aux); }
	 */
	/**
	 * El metodo actualiza en la base de datos el plato
	 * 
	 * @param plato El parametro define el cliente que va a ser actualizado
	 */
	/*
	 * public static void actualizarDataBasePlato(Plato plato) {
	 * Data.agregarObjetoDataBasePlato(plato); }
	 */
	/**
	 * El metodo actualiza en la base de datos el tendero
	 * 
	 * @param tendero El parametro define el tendero que va a ser actualizado
	 */
	/*
	 * public static void actualizarDataBaseTendero(Tendero tendero) { Tendero aux =
	 * tendero;
	 * Data.eliminarObjetoDataBaseTendero(Data.buscarTendero(tendero.getUserName()))
	 * ; Data.agregarObjetoDataBaseTendero(aux); }
	 * 
	 */

	/**
	 * El metodo actualiza en la base de datos el restaurante
	 * 
	 * @param restaurante El parametro define el restaurante que va a ser
	 *                    actualizado
	 */
	/*
	 * public static void actualizarDataBaseRestaurante(Restaurante restaurante) {
	 * Restaurante aux = restaurante;
	 * Data.eliminarObjetoDataBaseRestaurante(Data.buscarRestaurante(restaurante.
	 * getNombre())); Data.agregarObjetoDataBaseRestaurante(aux); }
	 */
	/*
	 * public static void actualizarDataBasePedido(Pedido pedido) {
	 * Data.eliminarObjetoDataBasePedido(Data.buscarPedido(pedido.getId()));
	 * Data.agregarObjetoDataBasePedido(pedido); }
	 */
	/**
	 * Metodo que se usa para agregar objetos a la base de datos de plato,
	 * convirtiendo asi el objeto a guardar en un JsonElement para poder insertarlo
	 * en el archivo respectivo
	 * 
	 * @see: {@link #traerDataBasePlato()}
	 * @see: {@link #actualizarDataBasePlato(JsonArray)}
	 */
	/*
	 * public static void agregarObjetoDataBasePlato(Plato obj) { ArrayList<Plato>
	 * dataBase = Data.traerDataBasePlato(); if (!dataBase.contains(obj)) {
	 * dataBase.add(obj); Data.actualizarDataBasePlato(dataBase); } else {
	 * System.out.println("no se puede agregar el plato a la base de datos"); } }
	 */
	/**
	 * Metodo que se usa para agregar objetos a la base de datos de clientes,
	 * convirtiendo asi el objeto a guardar en un JsonElement para poder insertarlo
	 * en el archivo respectivo
	 * 
	 * @see: {@link #traerDataBaseCliente()}
	 * @see: {@link #actualizarDataBaseCliente(JsonArray)}
	 */
	/*
	 * public static void agregarObjetoDataBaseCliente(Cliente obj) {
	 * ArrayList<Cliente> dataBase = Data.traerDataBaseCliente(); if
	 * (!dataBase.contains(obj)) { dataBase.add(obj);
	 * Data.actualizarDataBaseCliente(dataBase); } else {
	 * System.out.println("no se puede agregar el cliente a la base de datos"); } }
	 */
	/**
	 * Metodo que se usa para agregar objetos a la base de datos de tenderos,
	 * convirtiendo asi el objeto a guardar en un JsonElement para poder insertarlo
	 * en el archivo respectivo
	 * 
	 * @see: {@link #traerDataBaseTendero()}
	 * @see: {@link #actualizarDataBaseTendero(JsonArray)}
	 */
	/*
	 * public static void agregarObjetoDataBaseTendero(Tendero obj) {
	 * ArrayList<Tendero> dataBase = Data.traerDataBaseTendero(); if
	 * (!dataBase.contains(obj)) { dataBase.add(obj);
	 * Data.actualizarDataBaseTendero(dataBase); } else {
	 * System.out.println("no se puede agregar el tendero a la base de datos"); } }
	 */

	/**
	 * Metodo se usa para agregar objetos a la base de datos de restaurante,
	 * conviritiendo estos objetos en los JsonElements para asi insertarlos a su
	 * respectivo archivo
	 * 
	 * @see: {@link #actualizarDataBaseRestaurante(JsonArray)}
	 * @see: {@link #traerDataBaseRestaurante()}
	 */
	/*
	 * public static void agregarObjetoDataBaseRestaurante(Restaurante obj) {
	 * ArrayList<Restaurante> dataBase = Data.traerDataBaseRestaurante(); if
	 * (!dataBase.contains(obj)) { dataBase.add(obj);
	 * Data.actualizarDataBaseRestaurante(dataBase); } else {
	 * System.out.println("no se puede agregar el restaurante a la base de datos");
	 * } }
	 */

	/*
	 * public static void agregarObjetoDataBasePedido(Pedido obj) {
	 * ArrayList<Pedido> dataBase = Data.traerDataBasePedido(); if
	 * (!dataBase.contains(obj)) { dataBase.add(obj);
	 * Data.actualizarDataBasePedido(dataBase); } else {
	 * System.out.println("no se puede agregar el pedido a la base de datos"); } }
	 */
	/**
	 * Metodo que elimina cierto objeto de la dataBasePlato
	 * 
	 * @see: {@link #traerDataBasePlato()}
	 * @see: {@link #actualizarDataBasePlato(JsonArray)}
	 */
	/*
	 * public static void eliminarObjetoDataBasePlato(Plato obj) { ArrayList<Plato>
	 * dataBase = Data.traerDataBasePlato(); String userName = obj.getNombre();
	 * for(int i = 0;i<dataBase.size();i++) {
	 * if(dataBase.get(i).getNombre().equals(userName)) { dataBase.remove(i); } }
	 * Data.actualizarDataBasePlato(dataBase); }
	 */
	/**
	 * Metodo que elimina cierto objeto de la dataBaseCliente
	 * 
	 * @see: {@link #traerDataBaseCliente()}
	 * @see: {@link #actualizarDataBaseCliente(JsonArray)}
	 */
	/*
	 * public static void eliminarObjetoDataBaseCliente(Cliente obj) {
	 * ArrayList<Cliente> dataBase = Data.traerDataBaseCliente(); String userName =
	 * obj.getUserName(); for(int i = 0;i<dataBase.size();i++) {
	 * if(dataBase.get(i).getUserName().equals(userName)) { dataBase.remove(i); } }
	 * Data.actualizarDataBaseCliente(dataBase); }
	 */
	/**
	 * Metodo que elimina cierto objeto de la dataBaseTendero
	 * 
	 * @see: {@link #traerDataBaseTendero()}
	 * @see: {@link #actualizarDataBaseTendero(JsonArray)}
	 */
	/*
	 * public static void eliminarObjetoDataBaseTendero(Tendero obj) {
	 * ArrayList<Tendero> dataBase = Data.traerDataBaseTendero(); String userName =
	 * obj.getUserName(); for(int i = 0;i<dataBase.size();i++) {
	 * if(dataBase.get(i).getUserName().equals(userName)) { dataBase.remove(i); } }
	 * Data.actualizarDataBaseTendero(dataBase); }
	 */
	/**
	 * Metodo para eliminar cierto objeto de la dataBaseRestaurante
	 * 
	 * @see: {@link #traerDataBaseRestaurante()}
	 * @see: {@link #actualizarDataBaseRestaurante(JsonArray)}
	 */
	/*
	 * public static void eliminarObjetoDataBaseRestaurante(Restaurante obj) {
	 * ArrayList<Restaurante> dataBase = Data.traerDataBaseRestaurante(); String
	 * userName = obj.getNombre(); for(int i = 0;i<dataBase.size();i++) {
	 * if(dataBase.get(i).getNombre().equals(userName)) { dataBase.remove(i); } }
	 * Data.actualizarDataBaseRestaurante(dataBase); }
	 */
	/*
	 * public static void eliminarObjetoDataBasePedido(Pedido obj) {
	 * ArrayList<Pedido> dataBase = Data.traerDataBasePedido(); int id =
	 * obj.getId(); for(int i = 0;i<dataBase.size();i++) {
	 * if(dataBase.get(i).getId()==id) { dataBase.remove(i); } }
	 * Data.actualizarDataBasePedido(dataBase); }
	 */
	/**
	 * Metodo para buscar un usuario en la base de datos de platos usando solo el
	 * userName
	 * 
	 * @see: {@link #traerDataBasepPlato()}
	 */

	/*
	 * public static Plato buscarPlato(String userName) { Plato plato = null;
	 * ArrayList<Plato> dataBase = Data.traerDataBasePlato(); for (Plato p :
	 * dataBase) { if (userName.equals(p.getNombre())) { plato = p; } } return
	 * plato; }
	 */
	/**
	 * Metodo para buscar un usuario en la base de datos de cliente usando solo el
	 * userName
	 * 
	 * @see: {@link #traerDataBaseCliente()}
	 */

	/*
	 * public static Cliente buscarCliente(String userName) { Cliente cliente =
	 * null; ArrayList<Cliente> dataBase = Data.traerDataBaseCliente(); for (Cliente
	 * c : dataBase) { if (userName.equals(c.getUserName())) { cliente = c; } }
	 * return cliente; }
	 */
	/**
	 * Metodo para buscar un usuario en la base de datos de cliente usando el
	 * userName y la clave del usuario
	 * 
	 * @see: {@link #traerDataBaseCliente()}
	 */
	/*
	 * public static Cliente buscarCliente(String userName, String clave) { Cliente
	 * cliente = null; ArrayList<Cliente> dataBase = Data.traerDataBaseCliente();
	 * for (Cliente c : dataBase) { if (userName.equals(c.getUserName()) &&
	 * clave.equals(c.getClave())) { cliente = c; } } return cliente; }
	 */
	/**
	 * Metodo para buscar un usuario en la base de datos de tendero usando solo el
	 * userName
	 * 
	 * @see: {@link #traerDataBaseTendero()}
	 */

	/*
	 * public static Tendero buscarTendero(String userName) { Tendero tendero =
	 * null; ArrayList<Tendero> dataBase = Data.traerDataBaseTendero(); for (Tendero
	 * t : dataBase) { if (userName.equals(t.getUserName())) { tendero = t; } }
	 * return tendero; }
	 */
	/**
	 * Metodo para buscar un usuario en la base de datos de tendero usando el
	 * userName y la clave del usuario
	 * 
	 * @see: {@link #traerDataBaseTendero()}
	 */
	/*
	 * public static Tendero buscarTendero(String userName, String clave) { Tendero
	 * tendero = null; ArrayList<Tendero> dataBase = Data.traerDataBaseTendero();
	 * for (Tendero t : dataBase) { if (userName.equals(t.getUserName()) &&
	 * clave.equals(t.getClave())) { tendero = t; } } return tendero; }
	 */
	/**
	 * Metodo para buscar un restaurante en la base de datos de restaurante
	 */

	/*
	 * public static Restaurante buscarRestaurante(String userName) { Restaurante
	 * restaurante = null; ArrayList<Restaurante> dataBase =
	 * Data.traerDataBaseRestaurante(); for (Restaurante r : dataBase) { if
	 * (userName.equals(r.getNombre())) { restaurante = r; } } return restaurante; }
	 */
	/**
	 * Metodo para buscar un usuario en la base de datos de restaurante usando el
	 * userName y la clave del restaurante
	 * 
	 * @see: {@link #traerDataBaseRestaurante()}
	 */

	/*
	 * public static Restaurante buscarRestaurante(String userName, String clave) {
	 * Restaurante restaurante = null; ArrayList<Restaurante> dataBase =
	 * Data.traerDataBaseRestaurante(); for (Restaurante r : dataBase) { if
	 * (userName.equals(r.getNombre()) && clave.equals(r.getClave())) { restaurante
	 * = r; } } return restaurante; }
	 */
	/*
	 * public static Pedido buscarPedido(int ID) { Pedido pedido = null;
	 * ArrayList<Pedido> dataBase = Data.traerDataBasePedido(); for (Pedido p :
	 * dataBase) { if (p.getId()==ID) { pedido = p; } } return pedido; }
	 */
	/**
	 * Metodo organiza los restaurantes de mayor a menor segun calificacion
	 */
	public static Restaurante OrganizarRestaurantesPorCalificacion() {
		ArrayList<Restaurante> historial = Data.getdbRestaurante();
		Restaurante best = null;
		double max = 0;
		for (int i = 0; i < historial.size(); i++) {
			if (max < historial.get(i).getCalificacionPromediada()) {
				best = historial.get(i);
				max = historial.get(i).getCalificacionPromediada();
			}
		}
		return best;
	}

	public static ArrayList<String> imprimirRestaurantes() {
		ArrayList<Restaurante> historial = Data.getdbRestaurante();
		ArrayList<String> lista = new ArrayList<String>();
		for (int i = 0; i < historial.size(); i++) {
			lista.add(historial.get(i).getNombre());
		}
		return lista;
	}
}