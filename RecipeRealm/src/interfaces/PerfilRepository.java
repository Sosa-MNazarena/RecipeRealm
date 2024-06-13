package interfaces;

import java.util.List;

import Modelos.Perfil;

public interface PerfilRepository {
 
	    List<Perfil> getAllPerfils(); 
	    
	    Perfil getPerfilById(int id); 
	    
	    void addPerfil(Perfil Perfil); 
	    
	    Perfil autenticar(String correo, String contrasena);
	    
	    void updatePerfil(Perfil Perfil); 
	    
	    void deletePerfil(int id);

		Perfil iniciarSesion(String correo, String contrasena); 
	    
}
