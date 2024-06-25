package interfaces;

import java.util.List;

import Modelos.Perfil;
import Modelos.Receta;

public interface FavoritoRepositorio {
	List<Receta> getFavoritosByUsuario(Perfil perfil);
	void addFavorito(Perfil perfil, int idReceta);
	void removeFavorito(Perfil perfil, int idReceta);
	

}
