package Modelos;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

public class Cursos {
	private int idCurso;
	private String titulo;
	private Aficionado instructor;
	private String lugar;
	private String dia;
	private int cupo;
	private double precio;
	private String horario;

	public Cursos(int idCurso, String titulo, Aficionado instructor, String lugar, String dia, int cupo,
			double precio, String horario) {
		this.idCurso = idCurso;
		this.titulo = titulo;
		this.instructor = instructor;
		this.lugar = lugar;
		this.dia = dia;
		this.cupo = cupo;
		this.precio = precio;
		this.horario = horario;
	}



	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Aficionado getInstructor() {
		return instructor;
	}

	public void setInstructor(Aficionado instructor) {
		this.instructor = instructor;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	@Override
	public String toString() {
		return "Cursos [idCurso=" + idCurso + ", titulo=" + titulo + ", instructor=" + instructor + 
				", lugar=" + lugar + ", dia=" + dia + ", cupo=" + cupo + ", precio=" + precio + ", horario=" + horario
				+ "]\n";
	}
}
