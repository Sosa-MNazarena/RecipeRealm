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
	private LocalDate fecha;
	private String categorias;
	private String ingredientes;

	public Receta(int idReceta, String titulo, String procedimiento, String categorias, String ingredientes,
			LocalDate fecha) {
		this.idReceta = idReceta;
		this.titulo = titulo;
		this.procedimiento = procedimiento;
		this.categorias = categorias;
		this.fecha = fecha;
		this.categorias = categorias;
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

	public String getCategorias() {
		return categorias;
	}

	public void setCategorias(String categorias) {
		this.categorias = categorias;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	// Metodos de las recetas
	public static String subirReceta(String titulo, String procedimiento, LocalDate fecha, String categorias,
	        String ingredientes) {
	    // Validación de los campos título, procedimiento y ingredientes
	    if (titulo.isEmpty() || titulo.length() < 3) {
	        return "Título inválido, debe tener más de 3 caracteres.";
	    }

	    if (procedimiento.isEmpty() || procedimiento.length() < 5) {
	        return "Procedimiento inválido, debe tener más de 5 caracteres.";
	    }

	    if (ingredientes.isEmpty()) {
	        return "Debe ingresar al menos un ingrediente.";
	    }

	    Receta receta = new Receta(0, titulo, procedimiento, categorias, ingredientes, fecha);
	    RecetaControlador recetaControlador = new RecetaControlador();

	    try {
	        int idRecetaAgregada = recetaControlador.addRecetaSegunId(receta);

	        if (idRecetaAgregada <= 0) {
	            JOptionPane.showMessageDialog(null, "No se pudo agregar la receta.");
	            return "La receta no se ha subido exitosamente.";
	        }

	        JOptionPane.showMessageDialog(null, "La receta se ha subido exitosamente.");
	        return "La receta se ha subido exitosamente.";

	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Ha ocurrido un error al subir la receta: " + e.getMessage());
	        return "La receta no se ha subido exitosamente.";
	    }
	}


}
