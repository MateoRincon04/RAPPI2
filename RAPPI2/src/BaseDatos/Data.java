package BaseDatos;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import Administracion.Perfil;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Data {
	
	private static final String filepathPerfil = "C:\\Users\\mythe\\git\\repository\\RAPPI2\\temp\\datosPersonal";
	private static final String filepathPlatos = "C:\\Users\\mythe\\git\\repository\\RAPPI2\\temp\\platos";
	private static final String filepathRestaurantes = "C:\\Users\\mythe\\git\\repository\\RAPPI2\\temp\\restaurantes";
	
	
	public static void WritePerfilToFile(Object obj) {
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
        Perfil usuario = new Perfil(); //con el usuario y la clave, se debe buscar en la base de datos
        //un perfil existente, luego lo devuelven para que sea usado en la clase Login, por ejemplo.
        return usuario;
    }
}
