package Modelos;
import java.util.List;
import javax.swing.JOptionPane;
import Controladores.RecetaControlador;
import java.time.LocalDate;
import java.util.ArrayList;

public class Receta {

	private int idReceta;
	private String titulo;
	private String procedimiento;
	private List<Ingrediente> ingredientes;
	private LocalDate fecha;
	private List<String> categorias;

	public Receta(int idReceta, String titulo, String procedimiento, LocalDate fecha) {
		this.idReceta = idReceta;
		this.titulo = titulo;
		this.procedimiento = procedimiento;
		this.ingredientes = new ArrayList<>();
		this.categorias = new ArrayList<>();

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

	

	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}
	// Metodos de las recetas

	// ----------------------------------- Subir una receta
	// -------------------------------------

	public static String subirReceta(String titulo, String procedimiento, LocalDate fecha,
			List<String> listaIngredientes, List<String> listaCategorias) {
		// Validación de los campos título y procedimiento
		if (titulo.isEmpty() || titulo.length() < 3) {
			return "Título inválido, debe tener más de 3 caracteres.";
		}

		if (procedimiento.isEmpty() || procedimiento.length() < 5) {
			return "Procedimiento inválido, debe tener más de 5 caracteres.";
		}

		// Creación de una instancia de Receta con los datos recibidos
		Receta receta = new Receta(0, titulo, procedimiento, fecha);
		RecetaControlador recetaControlador = new RecetaControlador();

		try {
			int idRecetaAgregada = recetaControlador.addRecetaSegunId(receta);

			if (idRecetaAgregada <= 0) {
				JOptionPane.showMessageDialog(null, "No se pudo agregar la receta.");
				return "La receta no se ha subido exitosamente.";
			}

			// Recorrer la lista de ingredientes y agregarlos a la receta en la base de datos
			for (String nombreIngrediente : listaIngredientes) {
				Ingrediente ingrediente = new Ingrediente(nombreIngrediente);
				recetaControlador.insertarIngredienteReceta(idRecetaAgregada, ingrediente);
			}

			// Recorrer la lista de categorías y agregarlas a la receta en la base de datos
			  for (String nombreCategoria : listaCategorias) {
	                receta.agregarCategoria(nombreCategoria);
	                Categoria categoria = new Categoria(idRecetaAgregada, nombreCategoria); 
	                recetaControlador.insertarCategoriasReceta(idRecetaAgregada, listaCategorias);
	            }

			JOptionPane.showMessageDialog(null, "La receta se ha subido exitosamente.");
			return "La receta se ha subido exitosamente.";

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error al subir la receta: " + e.getMessage());
			return "La receta no se ha subido exitosamente.";
		}
	}public void agregarCategoria(String categoria) {
	    categorias.add(categoria);
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

	
	
}
