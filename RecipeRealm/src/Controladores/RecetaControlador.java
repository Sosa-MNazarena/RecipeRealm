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
		String sql = "SELECT id_receta, titulo, procedimiento, categorias, ingredientes, fecha FROM receta";

		try (PreparedStatement pstmt = connection.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				int idReceta = rs.getInt("id_receta");
				String titulo = rs.getString("titulo");
				String procedimiento = rs.getString("procedimiento");
				String categorias = rs.getString("categorias");
				String ingredientes = rs.getString("ingredientes");
				LocalDate fecha = rs.getDate("fecha").toLocalDate();

				Receta receta = new Receta(idReceta, titulo, procedimiento, categorias, ingredientes, fecha);
				recetas.add(receta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al cargar las recetas desde la base de datos: " + e.getMessage());
		}
	}

	public int addRecetaSegunId(Receta receta) throws SQLException {
		int idRecetaGenerado = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO receta (titulo, procedimiento, categorias, ingredientes, fecha) VALUES (?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, receta.getTitulo());
			statement.setString(2, receta.getProcedimiento());
			statement.setString(3, receta.getCategorias());
			statement.setString(4, receta.getIngredientes());
			statement.setDate(5, Date.valueOf(receta.getFecha()));

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
	public void updateReceta(Receta receta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteReceta(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Receta getRecetaByUsuario(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
