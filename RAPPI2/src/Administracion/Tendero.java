package Administracion;

/*En esta clase el tendero es aquel que entrega el pedido del restaurante
 * al usuario. Tiene una opcion en la cual el usuario da una calificacion sobre 
 * la entrega hecha por el tendero, un boolean si el tendero está disponible (o está libre)
 * para poder entregar un pedido), un salario que se le da y las notificaciones de pedido.
 * 
 */
public class Tendero extends Perfil{
	private Pedido pedido;
	private float calificacion;
	private boolean estaDisponible;
	private Pedido[] notificaciones;
	private long salario;
	
	public Tendero(String nombre, int telefono, int comuna, int clave, int ID, long salario) {
		super(nombre, telefono, comuna, clave, ID);
		this.salario = salario;
		this.calificacion = 5;
		this.estaDisponible = true;
	}
	
	public void setSalario(long salario) {
		this.salario=salario;
	
	}
	public long getSalario() {
		return salario;
	}
	public void setCalificacion(float calificacion) {
		this.calificacion = (this.getCalificacion() + calificacion)/2;
	}
	public float getCalificacion() {
		return calificacion;
	}
	public void setEstaDisponible(boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
	}
	public boolean getEstaDisponible() {
		return estaDisponible;
	}
	public String getDatos(){
	    return this.getNombre() + ", " + this.getTelefono() + ", " + this.getComuna() + ", " + this.getClave() + ", " + this.getID( )+ ", " + this.getSalario() + ", " + this.getCalificacion() + ", " + this.getEstaDisponible();
	}

}
