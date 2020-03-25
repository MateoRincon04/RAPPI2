package gestorAplicacion.Interaccion;

import BaseDatos.Data;

/**
 * Clase Calificacion Esta clase tiene como finalidad hacer la conexion entre el
 * calificado y el calificador para saber cada dato de estos
 * 
 * @author: Santiago Tamayo, Mateo Rincón, Paula A. Taborda, Guillermo Toloza
 */

public class Calificacion {
	private String calificado;
	private double puntuacion = 5.0;
	private String calificador;
	private int ID = 0;

	/**
	 * Constructor de los objetos de la clase Calificacion
	 * 
	 * @param calificado  El parametro calificado define el objeto que fue
	 *                    calificado
	 * @param puntuacion  El parametro puntuacion define la puntuación que le dio el
	 *                    calificador a el calificado
	 * @param calificador El parametro calificador define el objeto que realizo la
	 *                    calificacion
	 */

	public Calificacion(String calificado, double puntuacion, String calificador) {
		this.setCalificado(calificado);
		this.setCalificador(calificador);
		this.puntuacion = puntuacion;
		if(!Data.getdbCalificacion().isEmpty()) {
			this.ID=Data.getdbCalificacion().size()+1;
		}else {
			this.ID=1;
		}
	}

	public int getID() {
		return ID;
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

	public void setCalificado(String calificado) {
		this.calificado = calificado;
	}

	public Object getCalificador() {
		return calificador;
	}

	public void setCalificador(String calificador) {
		this.calificador = calificador;
	}

}