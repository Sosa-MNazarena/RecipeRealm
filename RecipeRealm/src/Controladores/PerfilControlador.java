package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Modelos.Perfil;
import interfaces.PerfilRepository;

public class PerfilControlador implements PerfilRepository {
    private final Connection connection;

    public PerfilControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public List<Perfil> getAllPerfils() {
    	List<Perfil> perfiles = new ArrayList<>();
        try {
            String sql = "SELECT id_usuario, nombre, pseudonimo, correo, contrasena, descripcion, verificado FROM usuario";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int idUsuario = resultSet.getInt("id_usuario");
                String nombre = resultSet.getString("nombre");
                String pseudonimo = resultSet.getString("pseudonimo");
                String correo = resultSet.getString("correo");
                String contrasena = resultSet.getString("contrasena");
                String descripcion = resultSet.getString("descripcion");
                boolean verificado = resultSet.getBoolean("verificado");

                Perfil perfil = new Perfil(idUsuario, nombre, pseudonimo, correo, contrasena, descripcion, verificado);
                perfiles.add(perfil);
            }
        } catch (SQLException e) {
            e.printStackTrace();
       }
        return perfiles;
    }


    @Override
    public Perfil getPerfilById(int id) {
        Perfil perfil = null;
        try {
            String query = "SELECT id_usuario, nombre, pseudonimo, correo, contrasena, descripcion, verificado FROM usuario WHERE id_usuario = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int idUsuario = resultSet.getInt("id_usuario");
                String nombre = resultSet.getString("nombre");
                String pseudonimo = resultSet.getString("pseudonimo");
                String correo = resultSet.getString("correo");
                String contrasena = resultSet.getString("contrasena");
                String descripcion = resultSet.getString("descripcion");
                boolean verificado = resultSet.getBoolean("verificado");

                // Crear un objeto Perfil con los datos obtenidos
                perfil = new Perfil(idUsuario, nombre, pseudonimo, correo, contrasena, descripcion, verificado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return perfil;
    }

    @Override
    public void addPerfil(Perfil perfil) {
    	
    	if (Perfil.esContrasenaValida(perfil.getContrasena())) {
           
        try {
        	PreparedStatement statement = connection.prepareStatement("INSERT INTO usuario (nombre, pseudonimo, correo, contrasena, descripcion, verificado) VALUES (?, ?, ?, ?, ?, ?)");
        	statement.setString(1, perfil.getNombre());
        	statement.setString(2, perfil.getPseudonimo());
        	statement.setString(3, perfil.getCorreo());
        	statement.setString(4, perfil.getContrasena());
        	statement.setString(5, perfil.getDescripcion());
        	statement.setBoolean(6, perfil.isVerificado());
        	
        	int rowsInserted = statement.executeUpdate();
        	if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Perfil creado exitosamente");
			}
			
		} catch (SQLException e) {
            e.printStackTrace();
        }
    }
    	}
    
    public Perfil autenticar(String correo, String contrasena) {
        Perfil perfil = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT id_usuario, nombre, pseudonimo, correo, contrasena, descripcion, verificado FROM usuario WHERE correo = ? AND contrasena = ?");
            statement.setString(1, correo);
            statement.setString(2, contrasena);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int idUsuario = resultSet.getInt("id_usuario");
                String nombre = resultSet.getString("nombre");
                String pseudonimo = resultSet.getString("pseudonimo");
                String correoUser = resultSet.getString("correo");
                String contrasenaUser = resultSet.getString("contrasena");
                String descripcion = resultSet.getString("descripcion");
                boolean verificado = resultSet.getBoolean("verificado");

                perfil = new Perfil(idUsuario, nombre, pseudonimo, correoUser, contrasenaUser, descripcion, verificado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return perfil;
    }

    @Override
    public void updatePerfil(Perfil perfil) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE usuario SET nombre = ?, pseudonimo = ?, correo = ?, contrasena = ?, descripcion = ?, verificado = ? WHERE id_usuario = ?");
            statement.setString(1, perfil.getNombre());
            statement.setString(2, perfil.getPseudonimo());
            statement.setString(3, perfil.getCorreo());
            statement.setString(4, perfil.getContrasena());
            statement.setString(5, perfil.getDescripcion());
            statement.setBoolean(6, perfil.isVerificado());
            statement.setInt(7, perfil.getIdUsuario());
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("El perfil fue actualizado exitosamente!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void deletePerfil(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM usuario WHERE id_usuario = ?");
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            
            if (rowsDeleted > 0) {
                System.out.println("Perfil eliminado exitosamente.");
            } else {
                System.out.println("No se encontró el perfil con el ID proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
