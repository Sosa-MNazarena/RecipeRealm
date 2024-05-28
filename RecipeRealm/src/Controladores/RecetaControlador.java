package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;
import Modelos.Ingrediente;
import Modelos.Receta;
import Modelos.Categoria;
import interfaces.RecetaRepository;

public class RecetaControlador implements RecetaRepository {

	private Connection connection;

	public RecetaControlador() {
		this.connection = DatabaseConnection.getInstance().getConnection();
	}

	@Override
	public List<Receta> getAllRecetas() {
		String sql = "SELECT id_receta, titulo, procedimiento, nro_ingredientes, fecha FROM receta";
		LinkedList<Receta> recetas = new LinkedList<>();

		try (PreparedStatement pstmt = connection.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				int idReceta = rs.getInt("id_receta");
				String titulo = rs.getString("titulo");
				String procedimiento = rs.getString("procedimiento");
				int nroIngredientes = rs.getInt("nro_ingredientes");
				Date fecha = new Date(rs.getDate("fecha").getTime());

				// usar un metodo para traer los ingredientes y cada cantidad del mismo 
				ArrayList<Ingrediente> ingredientes = getIngredientesByRecetaId(idReceta);
				ArrayList<Categoria> categorias = new ArrayList<>();

				// crear el objeto Receta y agregarlo a la lista que se va a mostrar
				Receta receta = new Receta(idReceta, titulo, procedimiento, null, nroIngredientes, 0, null, null, null,
						null, fecha, ingredientes, categorias);
				recetas.add(receta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al obtener todas las recetas: " + e.getMessage());
		}

		return recetas;
	}

	private ArrayList<Ingrediente> getIngredientesByRecetaId(int idReceta) {
	    String sql = "SELECT ingrediente.nombre, receta_ingrediente.cantidad " +
	                 "FROM ingrediente " +
	                 "JOIN receta_ingrediente ON ingrediente.id_ingrediente = receta_ingrediente.id_ingrediente " +
	                 "WHERE receta_ingrediente.id_receta = ?";
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


	public void addReceta(Receta receta) {
		String sqlReceta = "INSERT INTO receta (titulo, procedimiento, nro_ingredientes, fecha) VALUES (?, ?, ?, ?)";
		String sqlIngrediente = "INSERT INTO ingrediente (nombre) VALUES (?)";
		String sqlRecetaIngrediente = "INSERT INTO receta_ingrediente (id_receta, id_ingrediente, cantidad) VALUES (?, ?, ?)";

		try (PreparedStatement pstmtReceta = connection.prepareStatement(sqlReceta,
				PreparedStatement.RETURN_GENERATED_KEYS);
				PreparedStatement pstmtIngrediente = connection.prepareStatement(sqlIngrediente,
						PreparedStatement.RETURN_GENERATED_KEYS);
				PreparedStatement pstmtRecetaIngrediente = connection.prepareStatement(sqlRecetaIngrediente)) {

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
						// Insertar el ingrediente
						pstmtIngrediente.setString(1, ingrediente.getNombre());
						pstmtIngrediente.executeUpdate();

						// Obtener el ID del ingrediente insertado
						ResultSet rsIngrediente = pstmtIngrediente.getGeneratedKeys();
						int idIngrediente;
						if (rsIngrediente.next()) {
							idIngrediente = rsIngrediente.getInt(1);
						} else {
							throw new SQLException("Failed to insert ingredient, no ID obtained.");
						}

						// Insertar la relación receta-ingrediente con la cantidad ingresada manualmente
						// (que esta guardada en ingrediente.java)
						pstmtRecetaIngrediente.setInt(1, idReceta);
						pstmtRecetaIngrediente.setInt(2, idIngrediente);
						pstmtRecetaIngrediente.setDouble(3, ingrediente.getCantidad());
						pstmtRecetaIngrediente.executeUpdate();
					}

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
	public Receta getRecetaByUsuario(int id) {
		return null;
	}

	@Override
	public void updateReceta(Receta receta) {
	}

	
	@Override
	public void deleteReceta(int idReceta) {
	    String sqlDeleteRecetaIngrediente = "DELETE FROM receta_ingrediente WHERE id_receta = ?";
	    String sqlDeleteReceta = "DELETE FROM receta WHERE id_receta = ?";

	    try (Connection connection = DatabaseConnection.getInstance().getConnection();
	         PreparedStatement pstmtDeleteRecetaIngrediente = connection.prepareStatement(sqlDeleteRecetaIngrediente);
	         PreparedStatement pstmtDeleteReceta = connection.prepareStatement(sqlDeleteReceta)) {

	        // primero se eliminan los registros en la tabla receta_ingrediente
	        pstmtDeleteRecetaIngrediente.setInt(1, idReceta);
	        pstmtDeleteRecetaIngrediente.executeUpdate();

	        // luego se elimina la receta en si
	        pstmtDeleteReceta.setInt(1, idReceta);
	        int affectedRows = pstmtDeleteReceta.executeUpdate();

	        if (affectedRows > 0) {
	            System.out.println("La receta con ID " + idReceta + " ha sido eliminada correctamente.");
	        } else {
	            System.out.println("No se encontró ninguna receta con ID " + idReceta + ".");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Error al eliminar la receta con ID " + idReceta + ": " + e.getMessage());
	    }
	}


	@Override
	public Receta getRecetaById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
