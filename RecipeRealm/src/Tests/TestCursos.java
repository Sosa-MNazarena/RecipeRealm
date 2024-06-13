	/*package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.swing.JOptionPane;

import org.junit.Test;
import Controladores.CursoControlador;
import Modelos.Cursos;
import Modelos.Perfil;



public class TestCursos {

	@Test
    public void testPublicarCurso_Valido() {
		CursoControlador controlador=new CursoControlador();
        Perfil perfilVerificado = new Perfil(10, "Nazarena", "nachi", "naza@gmail.com", "Contra_123", 
        		"me gusta cocinar y pasar tiempo con mi perro, preparando comidas argentinas",
                                             true);
        
        Cursos cursoValido = new Cursos(5, "Curso de Cocina Avanzada", 
                                       "San Martin 2309", LocalDate.now().plusDays(1), 20, 100.0, LocalTime.of(15,00,00));


        assertEquals(true, controlador.addCurso(cursoValido));
    }
	
	@Test
    public void testPublicarCurso_NoVerificado() {
		CursoControlador controlador=new CursoControlador();
        Perfil perfilNoVerificado = new Perfil(10, "Nazarena", "nachi", "naza@gmail.com", "Contra_123", 
                "me gusta cocinar y pasar tiempo con mi perro, preparando comidas argentinas",
                                               false);
        
        Cursos cursoNoVerificado = new Cursos(4, "Curso de Cocina Avanzada", perfilNoVerificado, 
        		"San Martin 2309", LocalDate.now().plusDays(1), 20, 100.0, LocalTime.now());

        assertEquals(controlador.addCurso(cursoNoVerificado, perfilNoVerificado), false);
    }
	
	
	@Test
    public void testPublicarCurso_TituloCorto() {
		CursoControlador controlador=new CursoControlador();
        Perfil perfilInscripcion = new Perfil(7, "Laura", "laurita", "laura@gmail.com", "contra000", 
        		"me gusta cocinar y pasar tiempo con mi perro, preparando comidas argentinas",
                                             true);

        Cursos tituloCorto = new Cursos(5, "Cocinando", perfilInscripcion, 
	                                              "Lavalle 2743", LocalDate.now().plusDays(1), 20, 100.0, LocalTime.now());

	    assertEquals(controlador.addCurso(tituloCorto, perfilInscripcion), false);
	 }
	
	@Test
	public void eliminarCurso_Valido() {
		CursoControlador controlador = new CursoControlador();
		boolean flag = false;
		for (Cursos curso : controlador.getAllCursos()) {
			if (curso.eliminarCurso(controlador, 2)) {
				flag=true;
				break;
			}
		}
		assertEquals(true,flag);
	}
	
	@Test
    public void eliminarCurso_Invalido() {
		CursoControlador controlador = new CursoControlador();
        boolean flag = false;
        int invalidCursoId = 999; 

        for (Cursos curso : controlador.getAllCursos()) {
            if (curso.eliminarCurso(controlador, invalidCursoId)) {
                flag = true;
                break;
            }
        }
	}
}*/
