package Modelos;
import Modelos.Receta;
import java.util.ArrayList;
import Controladores.DatabaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import Controladores.RecetaControlador;
import javax.swing.JOptionPane;

public class Aficionado {
	private int idUsuario;
	private String nombre;
	private String pseudonimo;
	private String correo;
	private String contrasena;
	private String descripcion;
	private int verificado;


	public Aficionado(String nombre, String pseudonimo, String correo, String contrasena, String descripcion,
			int esVerificado) {
		this.nombre = nombre;
		this.pseudonimo = pseudonimo;
		this.correo = correo;
		this.contrasena = contrasena;
		this.descripcion = descripcion;
		this.verificado = esVerificado;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPseudonimo() {
		return pseudonimo;
	}

	public String getCorreo() {
		return correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int isVerificado() {
		return verificado;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPseudonimo(String pseudonimo) {
		this.pseudonimo = pseudonimo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setVerificado(int verificado) {
		this.verificado = verificado;
	}

	
	

}
