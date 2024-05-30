package Modelos;
import javax.swing.JOptionPane;

public class Chef extends Aficionado {
	 private int esVerificado;

	public int getEsVerificado() {
		return esVerificado;
	}

	public void setEsVerificado(int esVerificado) {
		this.esVerificado = esVerificado;
	}

	public Chef(String nombre, String pseudonimo, String correo, String contrasena, String descripcion,
			int esVerificado) {
		super(nombre, pseudonimo, correo, contrasena, descripcion, esVerificado);
		this.esVerificado = esVerificado;
	}

	@Override
	public String toString() {
		return "Chef [esVerificado=" + esVerificado + "]";
	}

	   

}
