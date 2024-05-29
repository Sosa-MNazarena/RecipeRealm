package Modelos;

public class Ingrediente {
	private int id;
	private String nombre;
	private double cantidad;

	public Ingrediente(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

}
