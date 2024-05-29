package interfaces;
import java.util.List;
import Modelos.Aficionado;

public interface AficionadoRepository {
	    List<Aficionado> getAllAficionados();
	    Aficionado getAficionadoById(int id);
}
