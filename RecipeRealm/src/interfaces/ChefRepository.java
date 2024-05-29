package interfaces;

import java.util.List;
import Modelos.Chef;

public interface ChefRepository {
	List<Chef> getAllChefs();
    Chef getChefById(int id);
}
