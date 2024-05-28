package Modelos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cursos {
    private int idCurso;
    private String titulo;
    private Aficionado instructor;
    private String lugar;
    private LocalDate dia;
    private int cupo;
    private double precio;
    private LocalTime horario;

    public Cursos(int idCurso, String titulo, Aficionado instructor, String lugar, LocalDate dia, int cupo,
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

    // Getters y setters...

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
}
