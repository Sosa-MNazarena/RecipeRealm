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

public class FavoritoControlador {
    private Connection connection;

    public FavoritoControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    
    public List<Receta> getFavoritosByUsuario(int idUsuario) {
        List<Receta> favoritos = new ArrayList<>();
        String sql = "SELECT r.* FROM receta r JOIN favorito f ON r.id_receta = f.id_receta WHERE f.id_usuario = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, idUsuario);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int idReceta = rs.getInt("id_receta");
                    String titulo = rs.getString("titulo");
                    String procedimiento = rs.getString("procedimiento");
                    int nroIngredientes = rs.getInt("nro_ingredientes");
                    LocalDate fecha = rs.getDate("fecha").toLocalDate();

                    ArrayList<Ingrediente> ingredientes = getIngredientesByRecetaId(idReceta);
                    ArrayList<Categoria> categorias = getCategoriasByRecetaId(idReceta);

                    Receta receta = new Receta(idReceta, titulo, procedimiento, null);
                    favoritos.add(receta);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener las recetas favoritas: " + e.getMessage());
        }
        return favoritos;
    }


    public void addFavorito(int perfilActual, int idReceta) {
        String sql = "INSERT INTO favorito (id_usuario, id_receta) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, perfilActual);
            pstmt.setInt(2, idReceta);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al agregar la receta a favoritos: " + e.getMessage());
        }
    }

   
    public void removeFavorito(int idUsuario, int idReceta) {
        String sql = "DELETE FROM favorito WHERE id_usuario = ? AND id_receta = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, idUsuario);
            pstmt.setInt(2, idReceta);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar la receta de favoritos: " + e.getMessage());
        }
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

    private ArrayList<Categoria> getCategoriasByRecetaId(int idReceta) {
        String sql = "SELECT categoria.id_categoria, categoria.nombre_categoria " +
                     "FROM categoria " +
                     "JOIN receta_categoria ON categoria.id_categoria = receta_categoria.id_categoria " +
                     "WHERE receta_categoria.id_receta = ?";
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
}
