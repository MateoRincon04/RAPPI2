package BaseDatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

import com.google.gson.*;

import Administracion.Perfil;

public class Data {
	
	private static final String filepathPerfil = "C:\\Users\\mythe\\git\\repository\\RAPPI2\\temp\\datosPersonal";
	private static final String filepathPlatos = "C:\\Users\\mythe\\git\\repository\\RAPPI2\\temp\\platos";
	private static final String filepathRestaurantes = "C:\\Users\\mythe\\git\\repository\\RAPPI2\\temp\\restaurantes";
	
	
	
	
	/* forma de usar el metodo de forma general
	 * el filepath depende de que se este construyendo
	 * estan en la parte de arriba 
	 */
	public static void WriteToFile(Object obj,String filepath) {
		try {
			Gson  gson = new Gson();
			String JSON = gson.toJson(obj);
			FileOutputStream fileOut = new FileOutputStream(filepath);
			OutputStreamWriter myOutWriter = new OutputStreamWriter(fileOut);
			myOutWriter.append(JSON);
			myOutWriter.close();
			fileOut.close();
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	
	// mirar si de esta forma se puede leer el objeto de tipo json, gracias.
    public static Object ReadFromFile(String filepath) {
   	 
        try {
 
            FileInputStream fileIn = new FileInputStream(filepath);
            BufferedReader myReader = new BufferedReader(new InputStreamReader(fileIn));
            String aDataRow ="";
            String aBuffer ="";
            while ((aDataRow=myReader.readLine())!=null) {
            	aBuffer+=aDataRow;
            }
            myReader.close();
            Gson  gson = new Gson();
            Object obj =gson.fromJson(aBuffer,Object.class);
            System.out.println("The Object has been read from the file");
            return obj;
 
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    //esta es la forma de lectura que yo habia encontrado pero creo que es 
    // mejor la que plantea Mateo
    public static Object ReadFromFile1(String filepath) {
   	 
        try {
 
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            Object obj = objectIn.readObject();
 
            System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;
 
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
	
    
    
    // no borrar hasta comprobar que todo sirve
    
	/*public static void WritePerfilToFile(Object obj) {
		try {
			 
            FileOutputStream fileOut = new FileOutputStream(filepathPerfil);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(obj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
	public static void WritePlatosToFile(Object obj) {
		try {
			 
            FileOutputStream fileOut = new FileOutputStream(filepathPlatos);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(obj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
	public static void WriteRestaurantesToFile(Object obj) {
		try {
			 
            FileOutputStream fileOut = new FileOutputStream(filepathRestaurantes);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(obj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static Object ReadPerfilFromFile(String filepath) {
    	 
        try {
 
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            Object obj = objectIn.readObject();
 
            System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;
 
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static Object ReadPlatoFromFile(String filepath) {
    	 
        try {
 
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            Object obj = objectIn.readObject();
 
            System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;
 
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static Object ReadRestauranteFromFile(String filepath) {
    	 
        try {
 
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            Object obj = objectIn.readObject();
 
            System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;
 
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public static Perfil buscarUsuario (String username, int clave) {
        //Perfil usuario = new Perfil(); //con el usuario y la clave, se debe buscar en la base de datos
        //un perfil existente, luego lo devuelven para que sea usado en la clase Login, por ejemplo.
        //return usuario;
    }*/
}
