package Modelos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import Controladores.RecetaControlador;

public class Receta {

	private int idReceta;
	private String titulo;
	private String procedimiento;
	private Ingrediente idIngrediente;
	private int nroIngredientes;
	private int cantidadDeIngrediente;
	private Aficionado idUsuario;
	private Categoria idCategoria;
	private Resena idResena;
	private Date fecha;
	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<Categoria> categorias;

	public Receta(int idReceta, String titulo, String procedimiento, Ingrediente idIngrediente, int nroIngredientes,
			int cantidadDeIngrediente, Aficionado idUsuario, Categoria idCategoria, Resena idResena, Aficionado autor,
			Date fecha, ArrayList<Ingrediente> ingredientes, ArrayList<Categoria> categorias) {
		this.idReceta = idReceta;
		this.titulo = titulo;
		this.procedimiento = procedimiento;
		this.idIngrediente = idIngrediente;
		this.nroIngredientes = nroIngredientes;
		this.cantidadDeIngrediente = cantidadDeIngrediente;
		this.idUsuario = idUsuario;
		this.idCategoria = idCategoria;
		this.idResena = idResena;
		this.fecha = fecha;
		this.ingredientes = ingredientes;
		this.categorias = categorias;
	}

	public int getIdReceta() {
		return idReceta;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getProcedimiento() {
		return procedimiento;
	}

	public Ingrediente getidIngrediente() {
		return idIngrediente;
	}

	public int getnroIngredientes() {
		return nroIngredientes;
	}

	public int getcantidadDeIngrediente() {
		return cantidadDeIngrediente;
	}

	public Aficionado getIdUsuario() {
		return idUsuario;
	}

	public Categoria getIdCategoria() {
		return idCategoria;
	}

	public Resena getIdResena() {
		return idResena;
	}

	public Date getFecha() {
		return fecha;
	}

	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}

	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	public void setIdIngrediente(Ingrediente idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public void setnroIngredientes(int nroIngredientes) {
		this.nroIngredientes = nroIngredientes;
	}

	public void setcantidadDeIngrediente(int cantidadDeIngrediente) {
		this.cantidadDeIngrediente = cantidadDeIngrediente;
	}

	public void setIdUsuario(Aficionado idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setIdCategoria(Categoria idCategoria) {
		this.idCategoria = idCategoria;
	}

	public void setIdResena(Resena idResena) {
		this.idResena = idResena;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public void setCategorias(ArrayList<Categoria> categorias) {
		this.categorias = categorias;
	}

	// Menu Mis Recetas
	public static void menuRecetas() {
		String[] opcionesRecetas = { "Subir receta", "Ver mis recetas creadas", "Eliminar receta", "Volver" };
		int opcionElegida = 0;
		do {
			opcionElegida = JOptionPane.showOptionDialog(null, "Elija qué desea hacer", "Menú de Recetas", 0, 0, null,
					opcionesRecetas, opcionesRecetas[0]);
			switch (opcionElegida) {
			case 0:
				subirReceta();
				break;
			case 1:
				verReceta();
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

	private static void subirReceta() {
		String titulo = JOptionPane.showInputDialog("Ingrese el título de la receta:");
		String procedimiento = JOptionPane.showInputDialog("Ingrese el procedimiento de la receta:");
		Date fecha = new Date(System.currentTimeMillis());

		int numIngredientes = Integer
				.parseInt(JOptionPane.showInputDialog("Ingrese el número de ingredientes que va a tener su receta:"));
		ArrayList<Ingrediente> ingredientes = new ArrayList<>();
		for (int i = 0; i < numIngredientes; i++) {
			String nombreIngrediente = JOptionPane
					.showInputDialog("Ingrese el nombre del ingrediente " + (i + 1) + ":");
			double cantidad = Double
					.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de " + nombreIngrediente + ":"));
			Ingrediente ingrediente = new Ingrediente(nombreIngrediente);
			ingrediente.setCantidad(cantidad); // Establecer la cantidad en el ingrediente
			ingredientes.add(ingrediente);
		}

		ArrayList<Categoria> categorias = new ArrayList<>();
		String nombreCategoria;
		while (true) {
			nombreCategoria = JOptionPane.showInputDialog(
					"Ingrese de a una las categorías que tendrá su receta (o ingrese 0 para terminar de ingresarlas):");
			if (nombreCategoria.equals("0")) {
				break;
			}
			categorias.add(new Categoria(numIngredientes, nombreCategoria));
		}

		Receta receta = new Receta(1, titulo, procedimiento, null, numIngredientes, 0, null, null, null, null, fecha,
				ingredientes, categorias);
		receta.setTitulo(titulo);
		receta.setProcedimiento(procedimiento);
		receta.setFecha(fecha);
		receta.setIngredientes(ingredientes);
		receta.setCategorias(categorias);

		RecetaControlador recetaControlador = new RecetaControlador();
		recetaControlador.addReceta(receta);
	}

	// ------------------------------------ Ver una receta
	// --------------------------------------------
	private static void verReceta() {
		RecetaControlador recetaControlador = new RecetaControlador();
		List<Receta> recetas = recetaControlador.getAllRecetas();

		String[] titulosRecetas = new String[recetas.size()];
		for (int i = 0; i < recetas.size(); i++) {
			titulosRecetas[i] = recetas.get(i).getTitulo();
		}

		// Mostrar los titulos para que el usuario seleccione una receta
		String recetaSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione la receta a ver:",
				"Ver Receta", JOptionPane.QUESTION_MESSAGE, null, titulosRecetas, titulosRecetas[0]);

		if (recetaSeleccionada != null) {
			Receta receta = null;
			for (Receta r : recetas) {
				if (r.getTitulo().equals(recetaSeleccionada)) {
					receta = r;
					break;
				}
			}

			// se muestran los detalles de la receta seleccionada
			if (receta != null) {
				StringBuilder detalles = new StringBuilder();
				detalles.append("Título: ").append(receta.getTitulo()).append("\n");
				detalles.append("Procedimiento: ").append(receta.getProcedimiento()).append("\n");
				detalles.append("Fecha: ").append(receta.getFecha()).append("\n");
				detalles.append("Ingredientes:\n");
				for (Ingrediente ing : receta.getIngredientes()) {
					detalles.append("- ").append(ing.getNombre()).append(" - Cantidad: ").append(ing.getCantidad())
							.append("\n");
				}
				detalles.append("Categorías:\n");
				for (Categoria cat : receta.getCategorias()) {
					detalles.append("- ").append(cat.getNombreCategoria()).append("\n");
				}

				JOptionPane.showMessageDialog(null, detalles.toString(), "Detalles de la Receta",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "No se seleccionó ninguna receta para ver.");
		}
	}

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
