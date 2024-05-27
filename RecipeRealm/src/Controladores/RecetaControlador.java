package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Modelos.Ingrediente;
import Modelos.Receta;
import interfaces.RecetaRepository;

public class RecetaControlador implements RecetaRepository {

	private Connection connection;

	public RecetaControlador() {
		this.connection = DatabaseConnection.getInstance().getConnection();
	}

	@Override
	public List<Receta> getAllRecetas() {
		return null;
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
	public Receta getRecetaById(int id) {
		return null;
	}

	@Override
	public void updateReceta(Receta receta) {
	}

	@Override
	public void deleteReceta(int idReceta) {
		
	}

}
