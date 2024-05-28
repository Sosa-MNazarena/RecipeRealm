package interfaces;

import java.util.List;

import Modelos.Cursos;

public interface CursoRepositorio {
	 	List<Cursos> getAllCursos(); // llama a todos los usuarios de la bdd
	    
	    Cursos getCursoById(int id); //hacer una búsqueda con solamente los ids? o cómo hacer las búsqueda de los cursos
	    
	    void addCurso(Cursos curso); //añade usuarios a la bdd
	    
	    void updateCurso(Cursos curso); //actualiza los usuarios de la bdd
	    
	    void deleteCurso(int id); //eliminar usuarios de la bdd
}
