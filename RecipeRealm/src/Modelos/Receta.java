package Modelos;
import java.util.List;
import javax.swing.JOptionPane;
import Controladores.RecetaControlador;
import java.time.LocalDate;


public class Receta {

	private int idReceta;
	private String titulo;
	private String procedimiento;
	private LocalDate fecha;
	private List<Ingrediente> ingredientes;


	public Receta(int idReceta, String titulo, String procedimiento, LocalDate fecha) {
		this.idReceta = idReceta;
		this.titulo = titulo;
		this.procedimiento = procedimiento;
		this.fecha = fecha;
	}


	public int getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}



	// Menu Mis Recetas
	public static void menuMisRecetas() {
		String[] opcionesRecetas = { "Subir receta", "Ver mis recetas creadas", "Eliminar receta", "Volver" };
		int opcionElegida = 0;
		do {
			opcionElegida = JOptionPane.showOptionDialog(null, "Elija qué desea hacer", "Menú de Recetas", 0, 0, null,
					opcionesRecetas, opcionesRecetas[0]);
			switch (opcionElegida) {
			case 0:
				// subirReceta();
				break;
			case 1:
				/* verReceta(); */
				break;
			case 2:
				eliminarReceta(opcionElegida);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Volviendo al menú principal");
				break;
			}
		} while (opcionElegida != 3);
	}

	// Metodos de las recetas

	// ----------------------------------- Subir una receta
	// -------------------------------------

	 public static String subirReceta(String titulo, String procedimiento, LocalDate fecha) {
	        if (titulo.isEmpty() || titulo.length() < 3) {
	            return "Título inválido, debe tener más de 3 caracteres.";
	        }

	        if (procedimiento.isEmpty() || procedimiento.length() < 5) {
	            return "Procedimiento inválido, debe tener más de 5 caracteres.";
	        }

	        Receta receta = new Receta(0, titulo, procedimiento, fecha); 

	        RecetaControlador recetaControlador = new RecetaControlador();
	        try {
	            recetaControlador.addReceta(receta);
	            JOptionPane.showMessageDialog(null, "La receta se ha subido exitosamente.");
	            return "La receta se ha subido exitosamente.";

	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al subir la receta: " + e.getMessage());
	            return "La receta no se ha subido exitosamente.";
	        }
	    }
	 public static void main(String[] args) {
	    
	        String resultado = subirReceta("Torta de Chocolate", "Batir los ingredientes y hornear", LocalDate.now());
	        System.out.println(resultado); // Imprimir el resultado
	    }
	/*
	 * // ------------------------------------ Ver una receta //
	 * -------------------------------------------- private static void verReceta()
	 * { RecetaControlador RecetaControlador = new RecetaControlador(); List<String>
	 * titulosRecetas = RecetaControlador.getTitulosRecetas();
	 * 
	 * // dar un mennsaje al usuario si no se encuentra ninguna receta creada if
	 * (titulosRecetas.isEmpty()) { JOptionPane.showMessageDialog(null,
	 * "No se encontraron recetas disponibles."); return; // Salir del método si no
	 * hay recetas disponibles } // Mostrar los titulos para que el usuario
	 * seleccione una receta String recetaSeleccionada = (String)
	 * JOptionPane.showInputDialog(null, "Seleccione la receta a ver:",
	 * "Ver Receta", JOptionPane.QUESTION_MESSAGE, null, titulosRecetas.toArray(),
	 * titulosRecetas.get(0));
	 * 
	 * if (recetaSeleccionada != null) { Receta receta =
	 * RecetaControlador.getRecetaByTitulo(recetaSeleccionada); if (receta != null)
	 * { // Se muestran los detalles de la receta seleccionada StringBuilder
	 * detalles = new StringBuilder();
	 * detalles.append("Título: ").append(receta.getTitulo()).append("\n");
	 * detalles.append("Procedimiento: ").append(receta.getProcedimiento()).append(
	 * "\n"); detalles.append("Fecha: ").append(receta.getFecha()).append("\n");
	 * detalles.append("Ingredientes:\n"); for (Ingrediente ing :
	 * receta.getIngredientes()) {
	 * detalles.append("- ").append(ing.getNombre()).append(" - Cantidad: ").append(
	 * ing.getCantidad()) .append("\n"); } detalles.append("Categorías:\n"); for
	 * (Categoria cat : receta.getCategorias()) {
	 * detalles.append("- ").append(cat.getNombreCategoria()).append("\n"); }
	 * 
	 * String[] opciones = { "Eliminar Receta", "Volver" }; int opcionSeleccionada =
	 * JOptionPane.showOptionDialog(null, detalles.toString(),
	 * "Detalles de la Receta", JOptionPane.DEFAULT_OPTION,
	 * JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
	 * 
	 * switch (opcionSeleccionada) { case 0: // Eliminar receta int confirmacion =
	 * JOptionPane.showConfirmDialog(null,
	 * "¿Estás seguro de que quieres eliminar la receta \"" + recetaSeleccionada +
	 * "\"?", "Eliminar Receta", JOptionPane.YES_NO_OPTION); if (confirmacion ==
	 * JOptionPane.YES_OPTION) {
	 * RecetaControlador.deleteReceta(receta.getIdReceta());
	 * JOptionPane.showMessageDialog(null, "La receta \"" + recetaSeleccionada +
	 * "\" ha sido eliminada."); } break;
	 * 
	 * case 1: // Volver break; default: break; } } else {
	 * JOptionPane.showMessageDialog(null,
	 * "No se encontró la receta seleccionada."); } } else {
	 * JOptionPane.showMessageDialog(null,
	 * "No se seleccionó ninguna receta para ver."); } }
	 */

	// ------------------------------- Eliminar una receta
	// --------------------------------------
	private static void eliminarReceta(int opcionElegida) {
		// recetas disponibles
		RecetaControlador recetaControlador = new RecetaControlador();
		List<Receta> recetas = recetaControlador.getAllRecetas();

		// array de strings con los títulos de las recetas
		String[] titulosRecetas = new String[recetas.size()];
		for (int i = 0; i < recetas.size(); i++) {
			titulosRecetas[i] = recetas.get(i).getTitulo();
		}

		// mostrar titulos de las recetas para que el usuario elija cual eliminar
		String recetaSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione la receta a eliminar:",
				"Eliminar Receta", JOptionPane.QUESTION_MESSAGE, null, titulosRecetas, titulosRecetas[0]);

		// verificar si el usuario seleccionó una receta y eliminarla del sistema
		if (recetaSeleccionada != null) {
			for (Receta receta : recetas) {
				if (receta.getTitulo().equals(recetaSeleccionada)) {
					recetaControlador.deleteReceta(receta.getIdReceta());
					JOptionPane.showMessageDialog(null, "La receta \"" + recetaSeleccionada + "\" ha sido eliminada.");
					break;
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "No se seleccionó ninguna receta para eliminar.");
		}
	}

}
