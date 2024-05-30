package interfaces;

import java.util.List;


import Modelos.Cursos;
import Modelos.Perfil;

public interface CursoRepositorio {
	 	List<Cursos> getAllCursos(); 
	    
	    Cursos getCursoById(int id); 
	    
	    boolean addCurso(Cursos curso, Perfil perfil); 
	    
	    void updateCurso(Cursos curso); 
	    
	    boolean deleteCurso(int id); 

		boolean inscribirCurso(int idUsuario, int idCurso);
}
