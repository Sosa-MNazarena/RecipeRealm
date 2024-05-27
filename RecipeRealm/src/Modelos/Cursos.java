package Modelos;

import java.sql.Date;
import java.sql.Time;

public class Cursos {
	private int idCurso;
	private String titulo;
	private Aficionado instructor;
	private double valor;
	private String lugar;
	private Date dia;
	private int cupo;
	private double precio;
	private Time horario;

	public Cursos(int idCurso, String titulo, Aficionado instructor, double valor, String lugar, Date dia, int cupo,
			double precio, Time horario) {
		this.idCurso = idCurso;
		this.titulo = titulo;
		this.instructor = instructor;
		this.valor = valor;
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
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

	public Time getHorario() {
		return horario;
	}

	public void setHorario(Time horario) {
		this.horario = horario;
	}

}
