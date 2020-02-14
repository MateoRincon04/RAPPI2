package Administracion;




/**Clase Administrador,
 * su finalidad es poder modificar el menu de cada
 * usuario, mostrar que funcionalidades puede
 * realizar cada usuario registrado,
 * listar todas las funcionalidades en general del
 * programa, poder adicionar o eliminar funcionalidades
 * de un usuario especifico.
 * Las estructuras de datos relevantes utilizadas son
*/ 

public class Administrador extends Perfil{
    private long salario;

    public Administrador(String nombre, int telefono, int comuna, int clave, int ID, long salario){
        super(nombre, telefono, comuna, clave, ID);
        this.salario = salario;
    }

    public long getSalario(){
        return this.salario;
    }
    public void setSalario(long salario){
        this.salario = salario;
    }
public String getDatos(){
        return this.getNombre() + ", " + this.getTelefono() + ", " + this.getComuna() + ", " + this.getClave() + ", " + this.getID( )+ ", " + this.getSalario();
    }


}