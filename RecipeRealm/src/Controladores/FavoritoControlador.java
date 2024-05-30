/*package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Modelos.Receta;
import interfaces.FavoritoRepositorio;

public class FavoritoControlador implements FavoritoRepositorio {
	private final Connection connection;

    public FavoritoControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

	@Override
	public List<Receta> getAllFavoritos(int idUsuario) {
		List<Receta> favoritos = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                "SELECT r.id_receta, r.titulo, r.procedimiento, r.id_usuario, r.id_categoria, r.fecha " +
                "FROM favoritos f " +
                "JOIN recetas r ON f.id_receta = r.id_receta " +
                "WHERE f.id_usuario = ?"
            );
            statement.setInt(1, idUsuario);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idReceta = resultSet.getInt("id_receta");
                String titulo = resultSet.getString("titulo");
                String procedimiento = resultSet.getString("procedimiento");
                int idUsuarioReceta = resultSet.getInt("id_usuario");
                int idCategoria = resultSet.getInt("id_categoria");
                LocalDate fecha = resultSet.getDate("fecha").toLocalDate();

                Receta receta = new Receta(idReceta, titulo, procedimiento, idUsuarioReceta, 
                        null , null, fecha, 
                        new ArrayList<>(), new ArrayList<>());
                favoritos.add(receta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return favoritos;
    }
	}

	@Override
	public void agregarRecetaFavoritos(int idUsuario, int idReceta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarRecetaFavoritos(int idUsuario, int idReceta) {
		// TODO Auto-generated method stub
		
	}

}*/
