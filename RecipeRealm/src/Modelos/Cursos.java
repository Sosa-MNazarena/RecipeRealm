package Modelos;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import Controladores.CursoControlador;

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
    
    public static String publicarCurso(String titulo, String lugar, LocalDate dia, int cupo, Double precio, LocalTime horario) {
        if (titulo.isEmpty() || titulo.length() < 3) {
            return "Título inválido, debe tener más de 3 caracteres.";
        }

        if (lugar.isEmpty() || lugar.length() < 5) {
            return "Lugar inválido, más de 3 caracteres.";
        }

        if (dia.isBefore(LocalDate.now())) {
            return "Fecha inválida.";
        }

        if (cupo < 10) {
            return "Cupos inválidos, debe ser una cantidad mayor a 10";
        }


        Cursos curso = new Cursos(0, titulo, null, lugar, dia, cupo, precio, horario);
        curso.setTitulo(titulo);
        curso.setLugar(lugar);
        curso.setDia(dia);
        curso.setCupo(cupo);
        curso.setPrecio(precio);
        curso.setHorario(horario);

        CursoControlador cursoControlador = new CursoControlador();
        try {
            cursoControlador.addCurso(curso);
            return "El curso se ha subido exitosamente.";
        } catch (Exception e) {
            return "El curso no se ha subido exitosamente.";
        }
    }

    
    public boolean eliminarCurso(CursoControlador cursoControlador, int idCurso) {
        boolean exito = cursoControlador.deleteCurso(idCurso);
        if (exito) {
            JOptionPane.showMessageDialog(null, "Se ha eliminado el curso exitosamente");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido eliminar el curso");
            return false;
        }
    }
    
    public static Cursos BuscarCurso(CursoControlador controlar) {
		String[] listaCursos = new String[controlar.getAllCursos().size()];
		
		for (int i = 0; i < listaCursos.length; i++) {
			listaCursos[i] = Integer.toString(controlar.getAllCursos().get(i).getIdCurso());
		}
		String elegido =(String) JOptionPane.showInputDialog(null, "Elija un id", null, 0, null, listaCursos, listaCursos[0]);
		
		Cursos nuevo = controlar.getCursoById(Integer.parseInt(elegido));
		return nuevo;
	}

}
