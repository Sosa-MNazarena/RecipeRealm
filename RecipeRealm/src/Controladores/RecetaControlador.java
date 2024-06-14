package Controladores;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import Modelos.Categoria;
import Modelos.Ingrediente;
import Modelos.Receta;
import Modelos.RecetaSingleton;
import interfaces.RecetaRepository;

public class RecetaControlador implements RecetaRepository {
	private List<Receta> recetas;

	private boolean recetaAgregada;

	private Connection connection;

	public RecetaControlador() {
		this.connection = DatabaseConnection.getInstance().getConnection();
		this.recetas = new ArrayList<>();

	//	cargarRecetasDesdeBaseDeDatos();
	}
/*
	private void cargarRecetasDesdeBaseDeDatos() { // cargar las recetas al singleton
		String sql = "SELECT id_receta, titulo, procedimiento, nro_ingredientes, fecha FROM receta";
		try (PreparedStatement pstmt = connection.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				int idReceta = rs.getInt("id_receta");
				String titulo = rs.getString("titulo");
				String procedimiento = rs.getString("procedimiento");
				int nroIngredientes = rs.getInt("nro_ingredientes");
				Date fecha = new Date(rs.getDate("fecha").getTime());

				ArrayList<Ingrediente> ingredientes = getIngredientesByRecetaId(idReceta);
				ArrayList<Categoria> categorias = getCategoriasByRecetaId(idReceta);

				Receta receta = new Receta(idReceta, titulo, procedimiento, null);
				RecetaSingleton.getInstance().addReceta(receta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al cargar las recetas desde la base de datos: " + e.getMessage());
		}
	}*/

	@Override
	public List<Receta> getAllRecetas() {
		// try catch como validacion
		try {
			return RecetaSingleton.getInstance().getRecetas();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al obtener todas las recetas: " + e.getMessage());
			return new ArrayList<>();
		}
	}

	private ArrayList<Ingrediente> getIngredientesByRecetaId(int idReceta) {
		String sql = "SELECT ingrediente.nombre, receta_ingrediente.cantidad " + "FROM ingrediente "
				+ "JOIN receta_ingrediente ON ingrediente.id_ingrediente = receta_ingrediente.id_ingrediente "
				+ "WHERE receta_ingrediente.id_receta = ?";
		ArrayList<Ingrediente> ingredientes = new ArrayList<>();

		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setInt(1, idReceta);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					String nombreIngrediente = rs.getString("nombre");
					double cantidad = rs.getDouble("cantidad");

					Ingrediente ingrediente = new Ingrediente(nombreIngrediente);
					ingrediente.setCantidad(cantidad);
					ingredientes.add(ingrediente);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al obtener los ingredientes de la receta: " + e.getMessage());
		}

		return ingredientes;
	}

	private ArrayList<Categoria> getCategoriasByRecetaId(int idReceta) {
		String sql = "SELECT categoria.id_categoria, categoria.nombre_categoria " + "FROM categoria "
				+ "JOIN receta_categoria ON categoria.id_categoria = receta_categoria.id_categoria "
				+ "WHERE receta_categoria.id_receta = ?";
		ArrayList<Categoria> categorias = new ArrayList<>();

		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setInt(1, idReceta);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					int idCategoria = rs.getInt("id_categoria");
					String nombreCategoria = rs.getString("nombre_categoria");

					Categoria categoria = new Categoria(idCategoria, nombreCategoria);
					categorias.add(categoria);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al obtener las categorías de la receta: " + e.getMessage());
		}

		return categorias;
	}

	private boolean validarReceta(Receta receta) {
		if (receta == null) {
			return false;
		}
		if (receta.getTitulo() == null || receta.getTitulo().length() < 3) {
			return false;
		}
		if (receta.getProcedimiento() == null || receta.getProcedimiento().length() < 20) {
			return false;
		}
		return true;
	}

	public void addReceta(Receta receta) {
		reiniciarRecetas();
		recetaAgregada = false;

		/*if (!validarReceta(receta)) {
			System.out.println("La receta no es válida y no se puede agregar.");
			return;
		}*/

		try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO receta (titulo, procedimiento, fecha) VALUES (?, ?, ?)");
            statement.setString(1, receta.getTitulo());
            statement.setString(2, receta.getProcedimiento());
            statement.setDate(3, Date.valueOf(receta.getFecha()));

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Receta cargada exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public boolean isRecetaAgregada() {
		return recetaAgregada;
	}
	public int addRecetaSegunId(Receta receta) throws SQLException {
		int idRecetaGenerado = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO receta (titulo, procedimiento, fecha) VALUES (?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, receta.getTitulo());
			statement.setString(2, receta.getProcedimiento());
			statement.setDate(3, Date.valueOf(receta.getFecha()));

			int rowsInserted = statement.executeUpdate();

			if (rowsInserted > 0) {
				ResultSet generatedKeys = statement.getGeneratedKeys();
				if (generatedKeys.next()) {
					idRecetaGenerado = generatedKeys.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Error al insertar la receta en la base de datos: " + e.getMessage());
		}
		return idRecetaGenerado;
	}
	@Override
	public void deleteReceta(int idReceta) {
		String sqlDeleteRecetaCategoria = "DELETE FROM receta_categoria WHERE id_receta = ?";
		String sqlDeleteRecetaIngrediente = "DELETE FROM receta_ingrediente WHERE id_receta = ?";
		String sqlDeleteReceta = "DELETE FROM receta WHERE id_receta = ?";

		try (Connection connection = DatabaseConnection.getInstance().getConnection();
				PreparedStatement pstmtDeleteRecetaCategoria = connection.prepareStatement(sqlDeleteRecetaCategoria);
				PreparedStatement pstmtDeleteRecetaIngrediente = connection
						.prepareStatement(sqlDeleteRecetaIngrediente);
				PreparedStatement pstmtDeleteReceta = connection.prepareStatement(sqlDeleteReceta)) {

			// primero se borran los datos de receta_categoria
			pstmtDeleteRecetaCategoria.setInt(1, idReceta);
			pstmtDeleteRecetaCategoria.executeUpdate();

			// luego receta_ingrediente
			pstmtDeleteRecetaIngrediente.setInt(1, idReceta);
			pstmtDeleteRecetaIngrediente.executeUpdate();

			pstmtDeleteReceta.setInt(1, idReceta);
			int affectedRows = pstmtDeleteReceta.executeUpdate();

			if (affectedRows > 0) {
				JOptionPane.showMessageDialog(null, "La receta se eliminó exitosamente");

				// eliminar la receta del singleton
				Receta recetaAEliminar = null;
				for (Receta receta : RecetaSingleton.getInstance().getRecetas()) {
					if (receta.getIdReceta() == idReceta) {
						recetaAEliminar = receta;
						break;
					}
				}

				if (recetaAEliminar != null) {
					RecetaSingleton.getInstance().removeReceta(recetaAEliminar);
				}
			} else {
				System.out.println("No se encontró ninguna receta con ID " + idReceta + ".");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al eliminar la receta con ID " + idReceta + ": " + e.getMessage());
		}
	}

	public List<String> getTitulosRecetas() {
		List<String> titulosRecetas = new ArrayList<>();
		List<Receta> recetas = getAllRecetas();
		for (Receta receta : recetas) {
			titulosRecetas.add(receta.getTitulo());
		}
		return titulosRecetas;
	}
	public void insertarCategoriasReceta(int idReceta, List<String> categorias) {
	    try {
	        insertarCategoriasRecetaEnBD(idReceta, categorias);
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Error al insertar las categorías de la receta en la base de datos: " + e.getMessage());
	    }
	}

	private void insertarCategoriasRecetaEnBD(int idReceta, List<String> categorias) throws SQLException {
	    String sql = "INSERT INTO receta_categoria (id_receta, id_categoria) VALUES (?, ?)";
	    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	        for (String categoria : categorias) {
	            int idCategoria = obtenerIdCategoria(categoria);

	            // Insertar en la relacin entre receta-categoría
	            pstmt.setInt(1, idReceta);
	            pstmt.setInt(2, idCategoria);
	            pstmt.executeUpdate();
	        }
	    }
	}

	private int obtenerIdCategoria(String nombreCategoria) throws SQLException {
	    int idCategoria = 0;
	    String sql = "SELECT id_categoria FROM categoria WHERE nombre_categoria = ?";
	    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	        pstmt.setString(1, nombreCategoria);
	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            idCategoria = rs.getInt("id_categoria");
	        } else {
	            // Insertar la nueva categoría si no existe
	            idCategoria = insertarNuevaCategoria(nombreCategoria);
	        }
	    }
	    return idCategoria;
	}

	private int insertarNuevaCategoria(String nombreCategoria) throws SQLException {
	    int idCategoriaGenerado = 0;
	    String sql = "INSERT INTO categoria (nombre_categoria) VALUES (?)";
	    try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	        pstmt.setString(1, nombreCategoria);
	        pstmt.executeUpdate();
	        ResultSet generatedKeys = pstmt.getGeneratedKeys();
	        if (generatedKeys.next()) {
	            idCategoriaGenerado = generatedKeys.getInt(1);
	        }
	    }
	    return idCategoriaGenerado;
	}



	@Override
	public Receta getRecetaByUsuario(int id) {
		return null;
	}

	@Override
	public void updateReceta(Receta receta) {
	}

	@Override
	public Receta getRecetaById(int id) {
		return null;
	}

	public Receta getRecetaByTitulo(String titulo) {
		List<Receta> recetas = RecetaSingleton.getInstance().getRecetas();
		for (Receta receta : recetas) {
			if (receta.getTitulo().equals(titulo)) {
				return receta;
			}
		}
		return null;
	}

	public void reiniciarRecetas() {
		RecetaSingleton.getInstance().getRecetas().clear();
		recetaAgregada = false;
	}

	@Override
	public void insertarIngredienteReceta(int idReceta, Ingrediente ingrediente) {
		// TODO Auto-generated method stub
		
	}


}
