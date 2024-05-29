package interfaces;

import java.util.List;

import Modelos.Aficionado;
import Modelos.Cursos;

public interface CursoRepositorio {
	 	List<Cursos> getAllCursos(); 
	    
	    Cursos getCursoById(int id); 
	    
	    void addCurso(Cursos curso); 
	    
	    void updateCurso(Cursos curso); 
	    
	    void deleteCurso(int id); 

		void inscribirCurso(Aficionado aficionado, int idCurso);
}
