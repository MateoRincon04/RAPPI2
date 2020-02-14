package Administracion;


/**
 * Clase perfil
 * su finalidad es poder optimizar la escritura de codigo, teniendo la herencia y el ser
 * clase abstracta como principios para esto, ya que tanto a la clase administrador, como a
 * cliente y tendero se les quiere guardar la informacion de estos atributos
*/ 

abstract class Perfil{
    private String nombre;
    private int telefono;
    private int comuna;
    private int clave;
    private int ID;

    protected Perfil(String nombre, int telefono, int comuna, int clave, int ID){
        this.nombre = nombre;
        this.telefono = telefono;
        this.comuna = comuna;
        this.clave = clave;
        this.ID = ID;
        
    }

    public abstract String getDatos();

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
    public void setID(int ID){
        this.ID = ID;
    }

    public int getID(){
        return this.ID;
   }
   
}