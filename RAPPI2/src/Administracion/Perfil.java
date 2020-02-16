package Administracion;


/**
 * Clase perfil
 * su finalidad es poder optimizar la escritura de codigo, teniendo la herencia y el ser
 * clase abstracta como principios para esto, ya que tanto a la clase administrador, como a
 * cliente y tendero se les quiere guardar la informacion de estos atributos
 * 
 * @author: Mateo Rinc�n
 * @version:
*/ 
import java.util.HashMap;
import BaseDatos.Data;

abstract public class Perfil{
    private String nombre;
    private int telefono;
    private int comuna;
    private int clave;
    private String userName;
    
    /**
     * Constructor generico para las subclases de Perfil
     * @param nombre El parametro nombre define el nombre que tendra el Objeto
     * @param telefono El parametro telefono define el telefono que tendra el Objeto
     * @param comuna El parametro comuna define la comuna deonde se encontrara el Objeto
     * @param clave El parametro clavve define la clave con la cual se registrara el Objeto
     * @param userName El parametro userName define el userName con el cual se registrara el Objeto
     */
    public Perfil(String nombre, int telefono, int comuna, int clave, String userName){
        this.nombre = nombre;
        this.telefono = telefono;
        this.comuna = comuna;
        this.clave = clave;
        this.userName = userName;
        
    }
    
    /**
     * M�todo abtracto que definira cada subclase a su manera
     */
    public abstract String toString();

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
   }
    public void setTelefono(int telefono){
        this.telefono = telefono;
    }

    public int getTelefono(){
        return this.telefono;
   }
    public void setComuna(int comuna){
        this.comuna = comuna;
    }

    public int getComuna(){
        return this.comuna;
   }
    public void setClave(int clave){
        this.clave = clave;
    }

    public int getClave(){
        return this.clave;
   }
    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return this.userName;
   }
}