package Modelos;

import Modelos.Receta;
import java.util.ArrayList;
import javax.swing.*;
import Controladores.RecetaControlador;

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

/*
 * package Modelos;
 * 
 * import Controladores.DatabaseConnection; import java.sql.Connection; import
 * java.sql.Date; import java.sql.PreparedStatement; import java.sql.ResultSet;
 * import java.sql.SQLException; import java.util.LinkedList; import
 * Controladores.RecetaControlador; import javax.swing.JOptionPane;
 * 
 * public class Aficionado { private int idUsuario; private String nombre;
 * private String pseudonimo; private String correo; private String contrasena;
 * private String descripcion; private int verificado; private Connection
 * connection;
 * 
 * public Aficionado(String nombre, String pseudonimo, String correo, String
 * contrasena, String descripcion, int verificado) { this.nombre = nombre;
 * this.pseudonimo = pseudonimo; this.correo = correo; this.contrasena =
 * contrasena; this.descripcion = descripcion; this.verificado = verificado;
 * this.connection = DatabaseConnection.getInstance().getConnection(); //
 * Conectar a la base de datos }
 * 
 * public int getIdUsuario() { return idUsuario; }
 * 
 * public String getNombre() { return nombre; }
 * 
 * public String getPseudonimo() { return pseudonimo; }
 * 
 * public String getCorreo() { return correo; }
 * 
 * public String getContrasena() { return contrasena; }
 * 
 * public String getDescripcion() { return descripcion; }
 * 
 * public int isVerificado() { return verificado; }
 * 
 * public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
 * 
 * public void setNombre(String nombre) { this.nombre = nombre; }
 * 
 * public void setPseudonimo(String pseudonimo) { this.pseudonimo = pseudonimo;
 * }
 * 
 * public void setCorreo(String correo) { this.correo = correo; }
 * 
 * public void setContrasena(String contrasena) { this.contrasena = contrasena;
 * }
 * 
 * public void setDescripcion(String descripcion) { this.descripcion =
 * descripcion; }
 * 
 * public void setVerificado(int verificado) { this.verificado = verificado; }
 * 
 * // Agregar un usuario aficionado a la bdd public boolean agregarAficionado()
 * { String sql =
 * "INSERT INTO usuario (nombre, pseudonimo, correo, contrasena, descripcion, verificado) VALUES (?, ?, ?, ?, ?, ?)"
 * ; try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
 * pstmt.setString(1, this.getNombre()); pstmt.setString(2,
 * this.getPseudonimo()); pstmt.setString(3, this.getCorreo());
 * pstmt.setString(4, this.getContrasena()); pstmt.setString(5,
 * this.getDescripcion()); pstmt.setInt(6, this.isVerificado());
 * pstmt.executeUpdate(); JOptionPane.showMessageDialog(null,
 * "Aficionado insertado exitosamente."); return true; } catch (SQLException e)
 * { e.printStackTrace(); JOptionPane.showMessageDialog(null,
 * "Error al insertar el aficionado: " + e.getMessage()); return false; } }
 * 
 * public void mostrarAficionados() { LinkedList<Aficionado> aficionados = new
 * LinkedList<>(); String sql = "SELECT * FROM usuario"; try (PreparedStatement
 * stmt = connection.prepareStatement(sql); ResultSet resultados =
 * stmt.executeQuery()) { while (resultados.next()) { String[] datos = new
 * String[6]; datos[0] = resultados.getString("id_usuario"); datos[1] =
 * resultados.getString("nombre"); datos[2] =
 * resultados.getString("pseudonimo"); datos[3] =
 * resultados.getString("correo"); datos[4] =
 * resultados.getString("contrasena"); datos[5] =
 * resultados.getString("descripcion"); int verificado =
 * resultados.getInt("verificado");
 * 
 * Aficionado aficionado = new Aficionado(datos[1], datos[2], datos[3],
 * datos[4], datos[5], verificado);
 * aficionado.setIdUsuario(Integer.parseInt(datos[0]));
 * aficionados.add(aficionado); } if (aficionados.isEmpty()) {
 * JOptionPane.showMessageDialog(null, "No hay aficionados."); } else { String
 * message = "Lista de aficionados:\n"; for (Aficionado aficionado :
 * aficionados) { message += "ID: " + aficionado.getIdUsuario() + "\n"; message
 * += "Nombre: " + aficionado.getNombre() + "\n"; message += "Pseudónimo: " +
 * aficionado.getPseudonimo() + "\n"; message += "Correo: " +
 * aficionado.getCorreo() + "\n"; message += "Descripción: " +
 * aficionado.getDescripcion() + "\n"; message += "Verificado: " +
 * aficionado.isVerificado() + "\n"; message +=
 * "--------------------------------------\n"; }
 * JOptionPane.showMessageDialog(null, message); } } catch (SQLException e) {
 * e.printStackTrace(); JOptionPane.showMessageDialog(null,
 * "Error al recuperar los aficionados: " + e.getMessage()); } }
 * 
 * // Menues public void menuRecetas() { String[] opcionesRecetas = {
 * "Mis recetas", "Recetas", "Volver" }; int opcionElegida = 0; do {
 * opcionElegida = JOptionPane.showOptionDialog(null, "Elija qué desea hacer",
 * "Menú de Recetas", 0, 0, null, opcionesRecetas, opcionesRecetas[0]); switch
 * (opcionElegida) { case 0: Receta.menuRecetas(); break; case 1: //
 * Funcionalidades para recetas que no son propias break; case 2:
 * JOptionPane.showMessageDialog(null, "Volviendo al menú principal"); break; }
 * } while (opcionElegida != 2); }
 * 
 * 
 * public void menuFavoritos() { String[] opcionesFavoritos = {
 * "Ver recetas favoritas", "Eliminar recetas de favoritas", "Volver" }; int
 * opcionElegida = 0; do { opcionElegida = JOptionPane.showOptionDialog(null,
 * "Elija qué desea hacer", "Menú de Recetas", 0, 0, null, opcionesFavoritos,
 * opcionesFavoritos[0]); switch (opcionElegida) { case 0: // subirReceta();
 * JOptionPane.showMessageDialog(null,
 * "Hola, Soy una lista de recetas favoritas c:"); break; case 1: //verReceta();
 * JOptionPane.showMessageDialog(null, "Esta receta se elimino con exito");
 * break; case 2: JOptionPane.showMessageDialog(null,
 * "Volviendo al menú principal"); break; } } while (opcionElegida != 2); }
 * 
 * public void menuBusqueda() { String[] opcionesBusqueda = {
 * "Buscar un perfil", "Buscar una receta", "Volver" }; int opcionElegida = 0;
 * do { opcionElegida = JOptionPane.showOptionDialog(null,
 * "Elija qué desea hacer", "Menú de Recetas", 0, 0, null, opcionesBusqueda,
 * opcionesBusqueda[0]); switch (opcionElegida) { case 0: // subirReceta();
 * JOptionPane.showMessageDialog(null, "Nada de stalckear a tu ex"); break; case
 * 1: //verReceta(); JOptionPane.showMessageDialog(null, "Esta es tu receta");
 * break; case 2: JOptionPane.showMessageDialog(null,
 * "Volviendo al menú principal"); break; } } while (opcionElegida != 2); }
 * 
 * }
 */
