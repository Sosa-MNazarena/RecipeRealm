package Modelos;

import java.time.LocalDate;
import java.util.Date;

public class Resena {
	private int idResena;
	private String comentario;
	private int estrella;
	private int idUsuario;
	private LocalDate fecha;
	private int idReceta;
	private String pseudonimoUsuario;

	// Constructor
	public Resena(int idResena, int idUsuario, String comentario, int estrella, int idReceta, LocalDate fecha) {
		this.idResena = idResena;
		this.pseudonimoUsuario = pseudonimoUsuario;
		this.comentario = comentario;
		this.estrella = estrella;
		this.idUsuario = idUsuario;
		this.idReceta = idReceta;
		this.fecha = fecha;

	}

	public Resena(String Nombre, String Comentario, int id_receta, LocalDate now) {
		// TODO Auto-generated constructor stub
	}
	public String getPseudonimoUsuario() {
        return pseudonimoUsuario;
    }

    public void setPseudonimoUsuario(String pseudonimoUsuario) {
        this.pseudonimoUsuario = pseudonimoUsuario;
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

	public int getEstrella() {
        return estrella;
    }

    public void setEstrella(int estrella) {
        this.estrella = estrella;
    }


	public int getidUsuario() {
		return idUsuario;
	}

	public void setidUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public int getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void add(Resena resena) {
		// TODO Auto-generated method stub
		
	}
}
