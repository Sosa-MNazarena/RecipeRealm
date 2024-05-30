package interfaces;

import java.util.List;

import Modelos.Receta;

public interface FavoritoRepositorio {
	List<Receta> getAllFavoritos(int idUsuario);
	void agregarRecetaFavoritos(int idUsuario, int idReceta);
	void eliminarRecetaFavoritos(int idUsuario, int idReceta);
	

}
