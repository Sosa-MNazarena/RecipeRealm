package Modelos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cursos {
    private int idCurso;
    private String titulo;
    private Perfil instructor;
    private String lugar;
    private LocalDate dia;
    private int cupo;
    private double precio;
    private LocalTime horario;

    public Cursos(int idCurso, String titulo, Perfil instructor, String lugar, LocalDate dia, int cupo,
                  double precio, LocalTime horario) {
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

    public Perfil getInstructor() {
        return instructor;
    }

    public void setInstructor(Perfil instructor) {
        this.instructor = instructor;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
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

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Cursos [idCurso=" + idCurso + ", titulo=" + titulo + ", instructor=" + instructor +
                ", lugar=" + lugar + ", dia=" + dia + ", cupo=" + cupo + ", precio=" + precio + ", horario=" + horario
                + "]\n";
    }
    
    public boolean publicarCurso() {
    	if (instructor.isVerificado()&&titulo.length()>=10 && cupo<=100 ) {
    		if (!lugar.isEmpty()&&!dia.isBefore(LocalDate.now())&&precio>0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
    }
}
