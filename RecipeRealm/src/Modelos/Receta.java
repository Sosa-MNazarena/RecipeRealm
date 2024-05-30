package Modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
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
		String titulo;
		do {
			titulo = JOptionPane.showInputDialog("Ingrese el título de la receta:");
			if (titulo.isEmpty()) {
				JOptionPane.showMessageDialog(null, "El título no puede estar vacío.");
			}
		} while (titulo.isEmpty());

		String procedimiento;
		do {
			procedimiento = JOptionPane.showInputDialog("Ingrese el procedimiento de la receta:");
			if (procedimiento.isEmpty()) {
				JOptionPane.showMessageDialog(null, "El procedimiento no puede estar vacío.");
			}
		} while (procedimiento.isEmpty());

		Date fecha = new Date(System.currentTimeMillis());

		int numIngredientes = 0;
		while (numIngredientes <= 0) {
			try {
				numIngredientes = Integer.parseInt(
						JOptionPane.showInputDialog("Ingrese el número de ingredientes que va a tener su receta:"));
				if (numIngredientes <= 0) {
					JOptionPane.showMessageDialog(null, "Debe ingresar al menos un ingrediente.");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
			}
		}

		ArrayList<Ingrediente> ingredientes = new ArrayList<>();
		for (int i = 0; i < numIngredientes; i++) {
			String nombreIngrediente = JOptionPane
					.showInputDialog("Ingrese el nombre del ingrediente " + (i + 1) + ":");
			double cantidad = 0;
			while (cantidad <= 0) {
				try {
					cantidad = Double.parseDouble(
							JOptionPane.showInputDialog("Ingrese la cantidad de " + nombreIngrediente + ":"));
					if (cantidad <= 0) {
						JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor que 0.");
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
				}
			}
			Ingrediente ingrediente = new Ingrediente(nombreIngrediente);
			ingrediente.setCantidad(cantidad);
			ingredientes.add(ingrediente);
		}

		ArrayList<Categoria> categorias = new ArrayList<>();
		String nombreCategoria;
		do {
			nombreCategoria = JOptionPane.showInputDialog(
					"Ingrese de a una las categorías que tendrá su receta (o ingrese 0 para terminar de ingresarlas):");
			if (!nombreCategoria.equals("0")) {
				categorias.add(new Categoria(numIngredientes, nombreCategoria));
			}
		} while (!nombreCategoria.equals("0") || categorias.isEmpty());

		if (categorias.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe ingresar al menos una categoría.");
			return;
		}

		Receta receta = new Receta(1, titulo, procedimiento, null, numIngredientes, 0, null, null, null, null, fecha,
				ingredientes, categorias);
		receta.setTitulo(titulo);
		receta.setProcedimiento(procedimiento);
		receta.setFecha(fecha);
		receta.setIngredientes(ingredientes);
		receta.setCategorias(categorias);

		RecetaControlador recetaControlador = new RecetaControlador();
		try {
			recetaControlador.addReceta(receta);
			JOptionPane.showMessageDialog(null, "La receta se ha subido exitosamente.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error al subir la receta: " + e.getMessage());
		}
	}

	// ------------------------------------ Ver una receta
	// --------------------------------------------
	private static void verReceta() {
		RecetaControlador RecetaControlador = new RecetaControlador();
		List<String> titulosRecetas = RecetaControlador.getTitulosRecetas();

		// dar un mennsaje al usuario si no se encuentra ninguna receta creada
		if (titulosRecetas.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No se encontraron recetas disponibles.");
			return; // Salir del método si no hay recetas disponibles
		}
		// Mostrar los titulos para que el usuario seleccione una receta
		String recetaSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione la receta a ver:",
				"Ver Receta", JOptionPane.QUESTION_MESSAGE, null, titulosRecetas.toArray(), titulosRecetas.get(0));

		if (recetaSeleccionada != null) {
			Receta receta = RecetaControlador.getRecetaByTitulo(recetaSeleccionada);
			if (receta != null) {
				// Se muestran los detalles de la receta seleccionada
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

				String[] opciones = { "Eliminar Receta", "Volver" };
				int opcionSeleccionada = JOptionPane.showOptionDialog(null, detalles.toString(),
						"Detalles de la Receta", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
						opciones, opciones[0]);

				switch (opcionSeleccionada) {
				case 0:
					// Eliminar receta
					int confirmacion = JOptionPane.showConfirmDialog(null,
							"¿Estás seguro de que quieres eliminar la receta \"" + recetaSeleccionada + "\"?",
							"Eliminar Receta", JOptionPane.YES_NO_OPTION);
					if (confirmacion == JOptionPane.YES_OPTION) {
						RecetaControlador.deleteReceta(receta.getIdReceta());
						JOptionPane.showMessageDialog(null,
								"La receta \"" + recetaSeleccionada + "\" ha sido eliminada.");
					}
					break;

				case 1:
					// Volver
					break;
				default:
					break;
				}
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró la receta seleccionada.");
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
