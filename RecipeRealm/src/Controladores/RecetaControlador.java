package Controladores;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Statement;
import Modelos.Perfil;
import Modelos.Receta;
import interfaces.RecetaRepository;

public class RecetaControlador implements RecetaRepository {
	private List<Receta> recetas;
	private boolean recetaAgregada;
	private Connection connection;

	public RecetaControlador() {
		this.connection = DatabaseConnection.getInstance().getConnection();
		this.recetas = new ArrayList<>();
		cargarRecetasDesdeBaseDeDatos();

	}

	private void cargarRecetasDesdeBaseDeDatos() {
		String sql = "SELECT id_receta, titulo, procedimiento, categorias, ingredientes, fecha, id_usuario FROM receta";

		try (PreparedStatement pstmt = connection.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				int idReceta = rs.getInt("id_receta");
				String titulo = rs.getString("titulo");
				String procedimiento = rs.getString("procedimiento");
				String categorias = rs.getString("categorias");
				String ingredientes = rs.getString("ingredientes");
				LocalDate fecha = rs.getDate("fecha").toLocalDate();
				int idUsuario = rs.getInt("id_usuario");

				Receta receta = new Receta(idReceta, titulo, procedimiento, categorias, ingredientes, fecha, idUsuario);
				recetas.add(receta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al cargar las recetas desde la base de datos: " + e.getMessage());
		}
	}

	public int addRecetaSegunId(Receta receta) throws SQLException {
		int idRecetaGenerado = 0;
		String query = "INSERT INTO receta (titulo, procedimiento, categorias, ingredientes, fecha, id_usuario) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(query,
				PreparedStatement.RETURN_GENERATED_KEYS)) {

			statement.setString(1, receta.getTitulo());
			statement.setString(2, receta.getProcedimiento());
			statement.setString(3, receta.getCategorias());
			statement.setString(4, receta.getIngredientes());
			statement.setDate(5, Date.valueOf(receta.getFecha()));
			statement.setInt(6, receta.getIdUsuario());

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
	public boolean updateReceta(Receta receta) {
		boolean actualizado = false;
		String query = "UPDATE receta SET titulo = ?, procedimiento = ?, ingredientes = ?,categorias = ? WHERE id_receta = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, receta.getTitulo());
			statement.setString(2, receta.getProcedimiento());

			statement.setString(3, receta.getIngredientes());
			statement.setString(4, receta.getCategorias());
			statement.setInt(5, receta.getIdReceta());
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Receta actualizada exitosamente.");
				actualizado = true;

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al actualizar la receta en la base de datos: " + e.getMessage());
		}
		return actualizado;
	}

	@Override
	public Receta getRecetaById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Receta> getAllRecetas() {
		return recetas;
	}

	@Override
	public void addReceta(Receta receta) {
		// TODO Auto-generated method stub

	}
	

	@Override
	public void deleteReceta(int id) {
		try {
	        String deleteFavoritoSQL = "DELETE FROM favorito WHERE id_receta = ?";
	        PreparedStatement pstmt1 = connection.prepareStatement(deleteFavoritoSQL);
	        pstmt1.setInt(1, id);
	        pstmt1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	    String query = "DELETE FROM receta WHERE id_receta = ?";
	    try (PreparedStatement statement = connection.prepareStatement(query)) {
	        statement.setInt(1, id);
	        int rowsDeleted = statement.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println("Receta eliminada exitosamente.");
	            recetas.removeIf(receta -> receta.getIdReceta() == id);
	        } else {
	            System.out.println("No se encontró la receta con el ID proporcionado.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Error al eliminar la receta en la base de datos: " + e.getMessage());
	    }
	}


	@Override
	public Receta getRecetaByUsuario(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
