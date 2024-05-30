package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import Modelos.Categoria;
import Modelos.Ingrediente;
import Modelos.Receta;
import Modelos.RecetaSingleton;
import interfaces.RecetaRepository;

public class RecetaControlador implements RecetaRepository {
	private Connection connection;

	public RecetaControlador() {
		this.connection = DatabaseConnection.getInstance().getConnection();
		cargarRecetasDesdeBaseDeDatos();
	}

	private void cargarRecetasDesdeBaseDeDatos() {
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

				Receta receta = new Receta(idReceta, titulo, procedimiento, null, nroIngredientes, 0, null, null, null,
						null, fecha, ingredientes, categorias);
				RecetaSingleton.getInstance().addReceta(receta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al cargar las recetas desde la base de datos: " + e.getMessage());
		}
	}

	@Override
	public List<Receta> getAllRecetas() {
		return RecetaSingleton.getInstance().getRecetas();
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

	public void addReceta(Receta receta) {
		String sqlReceta = "INSERT INTO receta (titulo, procedimiento, nro_ingredientes, fecha) VALUES (?, ?, ?, ?)";
		String sqlIngrediente = "INSERT INTO ingrediente (nombre) VALUES (?)";
		String sqlRecetaIngrediente = "INSERT INTO receta_ingrediente (id_receta, id_ingrediente, cantidad) VALUES (?, ?, ?)";
		String sqlRecetaCategoria = "INSERT INTO receta_categoria (id_receta, id_categoria) VALUES (?, ?)";
		String sqlBuscarCategoria = "SELECT id_categoria FROM categoria WHERE nombre_categoria = ?";
		String sqlInsertarCategoria = "INSERT INTO categoria (nombre_categoria) VALUES (?)";

		try (PreparedStatement pstmtReceta = connection.prepareStatement(sqlReceta,
				PreparedStatement.RETURN_GENERATED_KEYS);
				PreparedStatement pstmtIngrediente = connection.prepareStatement(sqlIngrediente,
						PreparedStatement.RETURN_GENERATED_KEYS);
				PreparedStatement pstmtRecetaIngrediente = connection.prepareStatement(sqlRecetaIngrediente);
				PreparedStatement pstmtRecetaCategoria = connection.prepareStatement(sqlRecetaCategoria);
				PreparedStatement pstmtBuscarCategoria = connection.prepareStatement(sqlBuscarCategoria);
				PreparedStatement pstmtInsertarCategoria = connection.prepareStatement(sqlInsertarCategoria,
						PreparedStatement.RETURN_GENERATED_KEYS)) {

			// Insertar la receta
			pstmtReceta.setString(1, receta.getTitulo());
			pstmtReceta.setString(2, receta.getProcedimiento());
			pstmtReceta.setInt(3, receta.getnroIngredientes());
			pstmtReceta.setDate(4, new java.sql.Date(receta.getFecha().getTime()));

			int affectedRows = pstmtReceta.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Hubo un fallo al insertar la receta");
			}

			try (ResultSet generatedKeys = pstmtReceta.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					int idReceta = generatedKeys.getInt(1);

					// Insertar los ingredientes de la receta y las relaciones en la tabla
					// receta_ingrediente
					for (Ingrediente ingrediente : receta.getIngredientes()) {
						pstmtIngrediente.setString(1, ingrediente.getNombre());
						pstmtIngrediente.executeUpdate();

						ResultSet rsIngrediente = pstmtIngrediente.getGeneratedKeys();
						int idIngrediente;
						if (rsIngrediente.next()) {
							idIngrediente = rsIngrediente.getInt(1);
						} else {
							throw new SQLException("Failed to insert ingredient, no ID obtained.");
						}

						pstmtRecetaIngrediente.setInt(1, idReceta);
						pstmtRecetaIngrediente.setInt(2, idIngrediente);
						pstmtRecetaIngrediente.setDouble(3, ingrediente.getCantidad());
						pstmtRecetaIngrediente.executeUpdate();
					}

					// Insertar las categorías de la receta
					for (Categoria categoria : receta.getCategorias()) {
						int idCategoria;

						// buscar la categoría
						pstmtBuscarCategoria.setString(1, categoria.getNombreCategoria());
						try (ResultSet rsCategoria = pstmtBuscarCategoria.executeQuery()) {
							if (rsCategoria.next()) {
								idCategoria = rsCategoria.getInt("id_categoria");
							} else {
								// crear la categoria si no existe
								pstmtInsertarCategoria.setString(1, categoria.getNombreCategoria());
								pstmtInsertarCategoria.executeUpdate();

								try (ResultSet rsNuevaCategoria = pstmtInsertarCategoria.getGeneratedKeys()) {
									if (rsNuevaCategoria.next()) {
										idCategoria = rsNuevaCategoria.getInt(1);
									} else {
										throw new SQLException("Fallo al insertar la nueva categoría.");
									}
								}
							}
						}

						pstmtRecetaCategoria.setInt(1, idReceta);
						pstmtRecetaCategoria.setInt(2, idCategoria);
						pstmtRecetaCategoria.executeUpdate();
					}

					// Agregar la receta al singleton
					RecetaSingleton.getInstance().addReceta(receta);

				} else {
					throw new SQLException("Fallo al insertar la receta");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al insertar la receta: " + e.getMessage());
		}
	}

	@Override
	public void deleteReceta(int idReceta) {
		String sqlDeleteRecetaIngrediente = "DELETE FROM receta_ingrediente WHERE id_receta = ?";
		String sqlDeleteReceta = "DELETE FROM receta WHERE id_receta = ?";

		try (Connection connection = DatabaseConnection.getInstance().getConnection();
				PreparedStatement pstmtDeleteRecetaIngrediente = connection
						.prepareStatement(sqlDeleteRecetaIngrediente);
				PreparedStatement pstmtDeleteReceta = connection.prepareStatement(sqlDeleteReceta)) {

			// primero se eliminan los registros en la tabla receta_ingrediente
			pstmtDeleteRecetaIngrediente.setInt(1, idReceta);
			pstmtDeleteRecetaIngrediente.executeUpdate();

			// despues se elimina la receta en si
			pstmtDeleteReceta.setInt(1, idReceta);
			int affectedRows = pstmtDeleteReceta.executeUpdate();

			if (affectedRows > 0) {
				System.out.println("La receta con ID " + idReceta + " ha sido eliminada correctamente.");

				// Eliminar la receta del singleton
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

	@Override
	public Receta getRecetaByUsuario(int id) {
		// Implementación según sea necesario
		return null;
	}

	@Override
	public void updateReceta(Receta receta) {
		// Implementación según sea necesario
	}

	@Override
	public Receta getRecetaById(int id) {
		// Implementación según sea necesario
		return null;
	}
}