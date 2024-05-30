package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JOptionPane;

import org.junit.Test;
import Controladores.CursoControlador;
import Modelos.Cursos;
import Modelos.Perfil;


public class TestCursos {
	
	@Test
    public void testPublicarCurso_Valido() {
		CursoControlador controlador=new CursoControlador();
        Perfil perfilVerificado = new Perfil(10, "Nazarena", "nachi", "naza@gmail.com", "contra123", 
                                             "descripción larga del instructor que cumple con el mínimo requerido",
                                             true);
        
        Cursos cursoValido = new Cursos(5, "Curso de Cocina Avanzada", perfilVerificado, 
                                        "Cocina Central", LocalDate.now().plusDays(1), 20, 100.0, LocalTime.of(15,00,00));


        assertEquals(controlador.addCurso(cursoValido), true);
    }
	
	@Test
    public void testPublicarCurso_NoVerificado() {
		CursoControlador controlador=new CursoControlador();
        Perfil perfilNoVerificado = new Perfil(10, "Nazarena", "nachi", "naza@gmail.com", "contra123", 
                "descripción larga del instructor que cumple con el mínimo requerido",
                                               false);
        
        Cursos cursoNoVerificado = new Cursos(4, "Curso de Cocina Avanzada", perfilNoVerificado, 
                                              "Cocina Central", LocalDate.now().plusDays(1), 20, 100.0, LocalTime.now());

        assertEquals(controlador.addCurso(cursoNoVerificado), false);
    }
	
	
	
	@Test
    public void testPublicarCurso_CupoExcedido() {
		CursoControlador controlador=new CursoControlador();
        Perfil perfilVerificado = new Perfil(7, "Laura", "laurita", "laura@gmail.com", "contra000", 
        		"descripción larga del instructor que cumple con el mínimo requerido",
                                             true);

        Cursos cursoCupoExcedido = new Cursos(5, "Curso de Cocina Avanzada", perfilVerificado, 
	                                              "Cocina Central", LocalDate.now().plusDays(1), 101, 100.0, LocalTime.now());

	    assertEquals(controlador.addCurso(cursoCupoExcedido), false);
	 }

}
