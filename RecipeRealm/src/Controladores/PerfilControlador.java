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
        // TODO: Implementar la lógica para obtener todos los perfiles
        return null;
    }

    @Override
    public Perfil getPerfilById(int id) {
        // TODO: Implementar la lógica para obtener un perfil por ID
        return null;
    }

    @Override
    public void addPerfil(Perfil perfil) {
        try {
        	PreparedStatement statement = connection.prepareStatement("INSERT INTO usuarios (nombre, pseudonimo, correo, contrasena, descripcion, verificado) VALUES (?, ?, ?, ?, ?, ?)");
        	statement.setString(1, perfil.getNombre());
        	statement.setString(2, perfil.getPseudonimo());
        	statement.setString(3, perfil.getCorreo());
        	statement.setString(4, perfil.getContrasena());
        	statement.setString(5, perfil.getDescripcion());
        	statement.setBoolean(6, perfil.getisVerificado());
        	
        	int rowsInserted = statement.executeUpdate();
        	if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Perfil creado exitosamente");
			}
			
		} catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Perfil iniciarSesion(String correo, String contrasena) {
        return perfilRepository.findByCorreoAndContrasena(correo, contrasena);
    }

    @Override
    public void updatePerfil(Perfil perfil) {
        // TODO: Implementar la lógica para actualizar un perfil
    }

    @Override
    public void deletePerfil(int id) {
        // TODO: Implementar la lógica para eliminar un perfil por ID
    }
}
