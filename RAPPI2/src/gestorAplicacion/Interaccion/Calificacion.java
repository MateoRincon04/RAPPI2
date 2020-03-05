package gestorAplicacion.Interaccion;


/**
 * Clase Calificacion
 * Esta clase tiene como finalidad hacer la conexion entre el calificado y el calificador
 * para saber cada dato de estos
 * 
 * @author: Santiago Tamayo, Mateo Rinc�n, Paula A. Taborda, Guillermo Toloza
 */

public class Calificacion {
	private Object calificado;
	private double puntuacion= 5.0;
	private Object calificador;
	
	/**
	 * Constructor de los objetos de la clase Calificacion
	 * @param calificado El parametro calificado define el objeto que fue calificado
	 * @param puntuacion El parametro puntuacion define la puntuaci�n que le dio el calificador a el calificado
	 * @param calificador El parametro calificador define el objeto que realizo la calificacion
	 */
	
	public Calificacion(Object calificado,double puntuacion,Object calificador) {
		this.setCalificado(calificado);
		this.setCalificador(calificador);
		this.puntuacion = puntuacion;
	}
	
	public double getPuntuacion() {
		return this.puntuacion;
	}
	
	public void setPuntuacion(float puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Object getCalificado() {
		return calificado;
	}

	public void setCalificado(Object calificado) {
		this.calificado = calificado;
	}

	public Object getCalificador() {
		return calificador;
	}

	public void setCalificador(Object calificador) {
		this.calificador = calificador;
	}
	
}