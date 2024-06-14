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

	public List<String> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}
	// Metodos de las recetas

	// ----------------------------------- Subir una receta
	// -------------------------------------

	public static String subirReceta(String titulo, String procedimiento, LocalDate fecha,
			List<String> listaIngredientes, List<String> listaCategorias) {
		// fecha = LocalDate.now();
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

			// Recorrer la lista de ingredientes y agregarlos a la receta en la base de
			// datos
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
	}

	public void agregarCategoria(String categoria) {
		categorias.add(categoria);
	}

	public void agregarIngrediente(Ingrediente ingrediente) {
		this.ingredientes.add(ingrediente);
	}


}
