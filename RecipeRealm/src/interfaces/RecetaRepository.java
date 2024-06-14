package interfaces;

import java.util.List;

import Modelos.Ingrediente;
import Modelos.Receta;

public interface RecetaRepository {
	List<Receta> getAllRecetas();

	Receta getRecetaById(int id);

	void addReceta(Receta receta);

	void updateReceta(Receta receta);

	void deleteReceta(int id);

	Receta getRecetaByUsuario(int id);

	void insertarIngredienteReceta(int idReceta, Ingrediente ingrediente);
}
