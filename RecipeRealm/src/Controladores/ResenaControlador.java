package Controladores;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Modelos.Perfil;
import Modelos.Resena;
import interfaces.ResenaRepository;

public class ResenaControlador implements ResenaRepository {
    private Connection connection;
    private List<Resena> resenas;

    public ResenaControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
        this.resenas = new ArrayList<>();
        cargarResenasDesdeBaseDeDatos();
    }
    

    private void cargarResenasDesdeBaseDeDatos() {
        String sql = "SELECT id_resena, id_usuario, comentario, estrella, id_receta, fecha FROM resena";
        try (PreparedStatement pstmt = connection.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int idResena = rs.getInt("id_resena");
                int idUsuario = rs.getInt("id_usuario");
                String comentario = rs.getString("comentario");
                int estrella = rs.getInt("estrella");
                int idReceta = rs.getInt("id_receta");
                LocalDate fecha = rs.getDate("fecha").toLocalDate();

                Resena resena = new Resena(idResena, idUsuario, comentario, estrella, idReceta, fecha);
                resenas.add(resena);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al cargar las reseñas desde la base de datos: " + e.getMessage());
        }
    }
    
    public int getRecetaIdByTitulo(String titulo) {
        String query = "SELECT id_receta FROM receta WHERE titulo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, titulo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_receta");
                } else {
                    System.out.println("No se encontró la receta con el título: " + titulo);
                    return -1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al buscar id_receta: " + e.getMessage());
            return -1;
        }
    }
    @Override
    public List<Resena> getResenasByRecetaId(int idReceta) {
        List<Resena> resenasPorReceta = new ArrayList<>();
        for (Resena resena : resenas) {
            if (resena.getIdReceta() == idReceta) {
                resenasPorReceta.add(resena);
            }
        }
        return resenasPorReceta;
    }

    @Override
    public void addResena(Resena resena, int idReceta) throws SQLException {
    	 String query = "INSERT INTO resena (id_usuario, comentario, estrella, fecha, id_receta) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
        	statement.setInt(1, resena.getidUsuario());
        	statement.setString(1, resena.getPseudonimoUsuario());
            statement.setString(2, resena.getComentario());
            statement.setInt(3, resena.getEstrella());
            statement.setDate(4, Date.valueOf(resena.getFecha()));
            statement.setInt(5, idReceta);
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Reseña agregada correctamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error al insertar la reseña en la base de datos: " + e.getMessage());
        }
    }

    @Override
    public boolean updateResena(Resena resena) {
        String query = "UPDATE resena SET comentario = ?, estrella = ? WHERE id_resena = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
        	statement.setString(1, resena.getComentario());
        	statement.setInt(2, resena.getEstrella());
        	statement.setInt(3, resena.getIdResena());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar la reseña: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteResena(int idResena) {
        String query = "DELETE FROM resena WHERE id_resena = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idResena);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
               
                resenas.removeIf(resena -> resena.getIdResena() == idResena);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar la reseña: " + e.getMessage());
        }
        return false;
    }

}
