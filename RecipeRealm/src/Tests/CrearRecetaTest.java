package Tests;
import Controladores.RecetaControlador;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;

import Modelos.Categoria;
import Modelos.Receta;

public class CrearRecetaTest {

	@Test
	public void CreacionCorrecta() {
	    RecetaControlador controlador = new RecetaControlador();
	    boolean flag = false;
	    String titulo = "Receta con titulo de mas de 3 caracteres";
	    String procedimiento = "Esta es una descripcion con mas de 20 caracteres";
	    int numeroIngredientes = 3; // el nroingredientes debe ser igual o mayor a 1
	    int numeroCategorias = 2; // numero de categorias valida (igual o mayor a 1)
	    Receta receta = new Receta(0, titulo, procedimiento, null, numeroIngredientes, 0, null, null, null, null,
	            new Date(), new ArrayList<>(), new ArrayList<>());

	    // agregar las categorías a la receta de prueba
	    for (int i = 0; i < numeroCategorias; i++) {
	        receta.getCategorias().add(new Categoria(i, "Categoria " + (i + 1)));
	    }

	    // Agregar la receta válida
	    controlador.addReceta(receta);

	    // Verificar que se agregó correctamente
	    Receta recetaAgregada = controlador.getRecetaByTitulo(titulo);
	    if (recetaAgregada != null && recetaAgregada.getCategorias().size() >= 1) {
	        flag = true;
	    }
	    assertEquals("La receta con título/descripcion válidos no se agregó correctamente o no tiene al menos una categoría",
	            true, flag);
	}

	@Test
	public void CreacionInvalida() {
	    RecetaControlador controlador = new RecetaControlador();
	    String tituloInvalido = "A"; // título inválido, debe tener más de 3 caracteres
	    String procedimientoInvalido = "Proc invalido"; // procedimiento invalido, debe tener más de 20 caracteres
	    int numeroIngredientesInvalido = 0; // número de ingredientes inválido, ya que debe ser igual o mayor a 1

	    Receta recetaInvalida = new Receta(0, tituloInvalido, procedimientoInvalido, null, numeroIngredientesInvalido,
	            0, null, null, null, null, new Date(), new ArrayList<>(), new ArrayList<>());

	    // agregar la receta inválida
	    controlador.addReceta(recetaInvalida);

	    // verificar que la flag llamada recetaAgregada que se creó en el controlador de la receta sea false
	    assertEquals("No se pudo agregar la receta inválida ", false, controlador.isRecetaAgregada());   
	}



}
