package Oferta;

import java.util.ArrayList;

public class Plato {
	private String Nombre;
	private ArrayList<String> Descripcion = new ArrayList<String>();
	private float Precio;
	private boolean Bebida;
	private ArrayList<String> Modificaciones = new ArrayList<String>();
	public Restaurante Restaurante;
	public int RestriccionDeEdad;

	public Plato(String Nombre, float Precio, boolean Bebida, int Restriccion) {
		this.Nombre = Nombre;
		this.Precio = Precio;
		this.Bebida = Bebida;
		this.RestriccionDeEdad = Restriccion;
	}
	void setPrecio(float precio) {
		this.Precio = precio;
	}
	void setNombre(String nombre) {
		this.Nombre = nombre;
	}
	void setBebida(boolean Bebida) {
		this.Bebida = Bebida;
	}
	public float getPrecio() {
		return Precio;
	}
	public String getNombre() {
		return Nombre;
	}
	public Boolean getBebida() {
		return Bebida;
	}	
}