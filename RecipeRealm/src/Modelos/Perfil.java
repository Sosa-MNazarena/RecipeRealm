package Modelos;

public class Perfil {

	private String pseudonimo;
	private String descripcion;


	public Perfil(String pseudonimo, String descripcion) {
		this.pseudonimo = pseudonimo;
		this.descripcion = descripcion;
	}

	public String getPseudonimo() {
		return pseudonimo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setPseudonimo(String pseudonimo) {
		this.pseudonimo = pseudonimo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
 //hola
}
