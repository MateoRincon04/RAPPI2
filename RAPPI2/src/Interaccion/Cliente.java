package Interaccion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Administracion.Perfil;
import Oferta.Pedido;

/**
 * 
 * @author mythe
 *
 */
public class Cliente extends Perfil {
	private List<Calificacion> calififcaciones= new ArrayList<Calificacion>();
	//private Carrito carrito;
	private String metodoDePago;
	private int referencia;
	private long saldo;
	private Pedido pedido;
	private List<Pedido> historial= new ArrayList<Pedido>();
	
	public Cliente(String nombre, int telefono, int comuna, int clave, String userName ,long saldo,String metodoDePago) {
		super(nombre, telefono, comuna, clave, userName);
		this.saldo = saldo;
		this.metodoDePago = metodoDePago;
	}
	
    public long getSaldo(){
        return this.saldo;
    }
    public void setSaldo(long saldo){
        this.saldo = saldo;
    }
    public void hacerPedido() {
    	
    }
    public double getCalificacion() {
    	double contadorAux = 0;
    	if(!this.calififcaciones.isEmpty()) {
    		Iterator<Calificacion> iterator = this.calififcaciones.iterator();
    		while(iterator.hasNext()) {
    			contadorAux += iterator.next().getPuntuacion();
    		}
    	}
    	return contadorAux;
    	
    }
    private void setMetodoDePago(String metodoDePago) {
    	this.metodoDePago = metodoDePago;
    }
    public void calificarTendero() {
    	if(pedido.getEntregado()) {
    		double puntuacion = 5.0;
    		Interaccion.Tendero calificando = this.pedido.getTendero();
    		Calificacion calificacionTendero = new Calificacion(this,puntuacion,calificando);
    	}
    }
    public String toString(){
    	return this.getNombre() + ", " + this.getTelefono() + ", " + this.getComuna() + ", " + this.getClave() + ", " + this.getUserName( );
    }
    
}