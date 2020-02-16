package Interaccion;

public class Calificacion {
	final private Object calificado;
	static private double puntuacion= 5.0;
	final private Object calificador;
	
	public Calificacion(Object calificado,double puntuacion,Object calificador) {
		this.calificado = calificado;
		this.calificador = calificador;
		this.puntuacion = puntuacion;
	}
	
	public double getPuntuacion() {
		return this.puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
}