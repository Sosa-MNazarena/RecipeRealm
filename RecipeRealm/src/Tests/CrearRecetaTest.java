package Tests;
import Controladores.RecetaControlador;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import Modelos.Receta;

public class CrearRecetaTest {
	@Test
	public void CreacionCorrecta() {
		RecetaControlador controlador = new RecetaControlador();
		boolean flag = false;
		String titulo = "Receta con titulo de mas de 3 caracteres";
		String procedimiento = "Esta es una descripcion con mas de 20 caracteres";
		int numeroIngredientes = 3; // el nroingredientes debe ser igual o mayor a 1
		Receta receta = new Receta(0, titulo, procedimiento, null, numeroIngredientes, 0, null, null, null, null,
				new Date(), new ArrayList<>(), new ArrayList<>());

		// agregar la receta valida
		controlador.addReceta(receta);

		// Verificar se agrego correctamente
		Receta recetaAgregada = controlador.getRecetaByTitulo(titulo);
		if (recetaAgregada != null) {
			flag = true;
		}
		assertEquals("La receta con título válido no se agregó correctamente", true, flag);
	}
	@Test
	public void CreacionInvalida() {
	    RecetaControlador controlador = new RecetaControlador();
	    String tituloInvalido = "A"; // título inválido, debe tener mas de 3 caracteres
	    String procedimientoInvalido = "Proc invalido"; // procedimiento inválido, debe tener mas de 20 caracteres
	    int numeroIngredientesInvalido = 0; // número de ingredientes inválido, ya que debe ser igual o mayor a 1

	    Receta recetaInvalida = new Receta(0, tituloInvalido, procedimientoInvalido, null, numeroIngredientesInvalido,
	            0, null, null, null, null, new Date(), new ArrayList<>(), new ArrayList<>());

	    // agregar la receta inválida
	    controlador.addReceta(recetaInvalida);

	    // Verificar que la flag llamada recetaAgregada que se creo en el controlador de la receta sea false
	    assertEquals("No se pudo agregar la receta inválida ", false, controlador.isRecetaAgregada());
	}


}
