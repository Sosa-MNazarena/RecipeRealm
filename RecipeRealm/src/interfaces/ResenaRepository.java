package interfaces;

import java.sql.SQLException;
import java.util.List;
import Modelos.Resena;

public interface ResenaRepository {
    List<Resena> getResenasByRecetaId(int idReceta);
    
	boolean updateResena(Resena resena);
	boolean deleteResena(int idResena);
	void addResena(Resena resena, int idReceta) throws SQLException;
}
