package interfaces;

import java.util.List;


import Modelos.Cursos;
import Modelos.Perfil;

public interface CursoRepositorio {
	 	List<Cursos> getAllCursos(); 
	    
	    Cursos getCursoById(int id); 
	    
	    void addCurso(Cursos curso); 
	    
	    void updateCurso(Cursos curso); 
	    
	    boolean deleteCurso(int id); 

		boolean inscribirCurso(Perfil perfil, int idCurso);
		
		List<Cursos> getCursosInscriptos(Perfil perfil);
}
