
public class Ingrediente {
	private String nombre;
	private double cantidad;

	public Ingrediente(String nombre, double cantidad, String unidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

}
