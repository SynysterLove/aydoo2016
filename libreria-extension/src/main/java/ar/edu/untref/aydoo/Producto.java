package ar.edu.untref.aydoo;

public abstract class Producto {

	private double precio;
	private String nombre;

	public double getPrecio() {

		return this.precio;

	}

	public void setPrecio(double precio) {

		this.precio = precio;

	}

	public void setNombre(String nombre) {

		this.nombre = nombre;

	}
	
	public String getNombre(){

		return this.nombre;

	}
}
