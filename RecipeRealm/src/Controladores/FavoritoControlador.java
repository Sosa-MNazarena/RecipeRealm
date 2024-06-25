package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Modelos.Categoria;
import Modelos.Ingrediente;
import Modelos.Perfil;
import Modelos.Receta;
import interfaces.FavoritoRepositorio;

public class FavoritoControlador implements FavoritoRepositorio {
    private Connection connection;

    public FavoritoControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public List<Receta> getFavoritosByUsuario(Perfil perfil) {
        List<Receta> favoritos = new ArrayList<>();
        String sql = "SELECT r.* FROM receta r JOIN favorito f ON r.id_receta = f.id_receta WHERE f.id_usuario = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        	pstmt.setInt(1, perfil.getIdUsuario());
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int idReceta = rs.getInt("id_receta");
                    String titulo = rs.getString("titulo");
                    String procedimiento = rs.getString("procedimiento");
                    String categorias = rs.getString("categorias");
    				String ingredientes = rs.getString("ingredientes");
                    LocalDate fecha = rs.getDate("fecha").toLocalDate();
                    int idUsuario = rs.getInt("id_usuario");


                    Receta receta = new Receta(idReceta, titulo, procedimiento, categorias, ingredientes, fecha, idUsuario);
                    favoritos.add(receta);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener las recetas favoritas: " + e.getMessage());
        }
        return favoritos;
    }

    @Override
    public void addFavorito(Perfil perfil, int idReceta) {
        String sql = "INSERT INTO favorito (id_usuario, id_receta) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, perfil.getIdUsuario());
            pstmt.setInt(2, idReceta);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al agregar la receta a favoritos: " + e.getMessage());
        }
    }

    @Override
    public void removeFavorito(Perfil perfil, int idReceta) {
        String sql = "DELETE FROM favorito WHERE id_usuario = ? AND id_receta = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        	pstmt.setInt(1, perfil.getIdUsuario());
            pstmt.setInt(2, idReceta);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar la receta de favoritos: " + e.getMessage());
        }
    }



    
}