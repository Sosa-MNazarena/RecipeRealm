package Modelos;

import java.util.Date;

public class Resena {
	private int idResena;
	private String comentario;
	private int estrellas;
	private Aficionado idUsuario; // (autor de la reseña)
	private Date fecha;

	// Constructor
	public Resena(int idResena, String comentario, int estrellas, Aficionado idUsuario, Date fecha) {
		this.idResena = idResena;
		this.comentario = comentario;
		this.idUsuario = idUsuario;
		this.fecha = fecha;

		// Para que las estrellas estén entre 1 y 5
		if (estrellas < 1) {
			this.estrellas = 1;
		} else if (estrellas > 5) {
			this.estrellas = 5;
		} else {
			this.estrellas = estrellas;
		}
	}

	public int getIdResena() {
		return idResena;
	}

	public void setIdResena(int idResena) {
		this.idResena = idResena;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getEstrellas() {
		return estrellas;
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

	public Aficionado getidUsuario() {
		return idUsuario;
	}

	public void setidUsuario(Aficionado idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
