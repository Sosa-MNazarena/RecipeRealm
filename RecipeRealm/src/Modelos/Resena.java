package Modelos;
import java.util.Date;

public class Resena {
	private String comentario;
	private int estrellas;
	private Aficionado autor;
	private Date fecha;
	
	// Constructor
	public Resena(String comentario, int estrellas, Aficionado autor, Date fecha) {
		this.comentario = comentario;
		this.autor = autor;
		this.fecha = fecha;

		// Para que las estrellas esten entre 1 y 5
		if (estrellas < 1) {
			this.estrellas = 1; 
		} else if (estrellas > 5) {
			this.estrellas = 5; 
		} else {
			this.estrellas = estrellas; 
		}
	}

	public String getComentario() {
		return comentario;
	}

	public int getEstrellas() {
		return estrellas;
	}

	public Aficionado getAutor() {
		return autor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	 public void setEstrellas(int estrellas) {
	        if (estrellas < 1) {
	            this.estrellas = 1; 
	        } else if (estrellas > 5) {
	            this.estrellas = 5; 
	        } else {
	            this.estrellas = estrellas;
	        }
	    }
}
