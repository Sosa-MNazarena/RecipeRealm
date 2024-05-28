package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Modelos.Cursos;
import interfaces.CursoRepositorio;

public class CursoControlador implements CursoRepositorio{
	private final Connection connection;

    public CursoControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

	@Override
	public List<Cursos> getAllCursos() {
		List<Cursos> curso = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT id_curso, titulo, lugar, dia, cupo, precio, horario FROM cursos");
            ResultSet resultSet = statement.executeQuery();
       
            while (resultSet.next()) {
            	int idCurso = resultSet.getInt("id_curso");
                String titulo = resultSet.getString("titulo");
                String lugar = resultSet.getString("lugar");
                String dia = resultSet.getString("dia");
                int cupo = resultSet.getInt("cupo");
                double precio = resultSet.getDouble("precio");
                String horario = resultSet.getString("horario"); 
                

                Cursos cursito = new Cursos(idCurso, titulo, null, lugar, dia, cupo, precio, horario);
                curso.add(cursito);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return curso;
    }
	

	@Override
	public Cursos getCursoById(int id_curso) {
		Cursos cursito = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cursos WHERE id_curso = ?");
            statement.setInt(1, id_curso);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
            	int idCurso = resultSet.getInt("id_curso");
                String titulo = resultSet.getString("titulo");
                String lugar = resultSet.getString("lugar");
                String dia = resultSet.getString("dia");
                int cupo = resultSet.getInt("cupo");
                double precio = resultSet.getDouble("precio");
                String horario = resultSet.getString("horario"); 
                cursito = new Cursos(idCurso, titulo, null, lugar, dia, cupo, precio, horario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cursito;
	}

	@Override
	public void addCurso(Cursos curso) {
		 try {
	            PreparedStatement statement = connection.prepareStatement("INSERT INTO cursos (titulo, lugar, dia, cupo, precio, horario) VALUES (?, ?, ?, ?, ?, ?)");
	            statement.setString(1, curso.getTitulo());
	            statement.setString(2, curso.getLugar());
	            statement.setString(3, curso.getDia());
	            statement.setInt(4, curso.getCupo());
	            statement.setDouble(5, curso.getPrecio());
	            statement.setString(6, curso.getHorario());
	            
	            int rowsInserted = statement.executeUpdate();
	            if (rowsInserted > 0) {
	                JOptionPane.showMessageDialog(null, "Curso cargado exitosamente");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public void updateCurso(Cursos curso) {
		try {
            PreparedStatement statement = connection.prepareStatement("UPDATE cursos SET titulo = ?, lugar = ?, dia = ? , cupo = ? , precio = ?, horario = ?  WHERE id_curso = ?");
            statement.setString(1, curso.getTitulo());
            statement.setString(2, curso.getLugar());
            statement.setString(3, curso.getDia());
            statement.setInt(4, curso.getCupo());
            statement.setDouble(5, curso.getPrecio());
            statement.setString(6, curso.getHorario());
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
            	JOptionPane.showMessageDialog(null, "Curso actualizado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void deleteCurso(int id_curso) {
		try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM cursos WHERE id_curso = ?");
            statement.setInt(1, id_curso);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
            	JOptionPane.showMessageDialog(null, "Curso eliminado exitosamente");            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
}
