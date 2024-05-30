package Modelos;

import javax.swing.*;

public class Aficionado extends Perfil {
    public Aficionado(int id, String nombre, String pseudonimo, String correo, String contrasena, String descripcion, boolean verificado) {
        super(id, nombre, pseudonimo, correo, contrasena, descripcion, verificado);
    }

    public void menuPrincipalAficionado() {
        String[] opciones = { "Perfil", "Recetas", "Favoritos", "Cursos", "Salir" };
        int opcionElegida = 0;
        do {
            opcionElegida = JOptionPane.showOptionDialog(null, "Elija una opción", "Menú Principal", 0, 0, null, opciones, opciones[0]);
            switch (opcionElegida) {
                case 0:
                    menuPerfil();
                    break;
                case 1:
                    menuRecetas();
                    break;
                case 2:
                    menuFavoritos();
                    break;
                case 3:
                    menuCursos();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    break;
            }
        } while (opcionElegida != 4);
    }
    
    private void menuPerfil() {
        String[] opcionesPerfil = { "Ver perfil", "Editar perfil", "Eliminar perfil", "Volver" };
        int opcionElegida = 0;
        do {
            opcionElegida = JOptionPane.showOptionDialog(null, "Elija una opción", "Menú de Perfil", 0, 0, null, opcionesPerfil, opcionesPerfil[0]);
            switch (opcionElegida) {
                case 0: 
                    verPerfil();
                    break;
                case 1: 
                    editarPerfil();
                    break;
                case 2: 
                    eliminarPerfil();
                    break;
                case 3: 
                    JOptionPane.showMessageDialog(null, "Volviendo al menú principal");
                    break;
            }
        } while (opcionElegida != 3);
    }
    
    private void verPerfil() {
    }
    
    private void editarPerfil() {
    }
    
    private void eliminarPerfil() {
    }
    
    private void menuRecetas() {
        //Menu de recetas
    }
    
    private void menuFavoritos() {
        // Menu de favoritos
    }
    
   /* private void menuBusqueda() {
        // En caso de que se llegue a hacer lo de busqueda
    }
    */
    
    private void menuCursos() {
        // Aca van los cursillos
    }

}

/*package Modelos;

import Controladores.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Aficionado {
	private int idUsuario;
	private String nombre;
	private String pseudonimo;
	private String correo;
	private String contrasena;
	private String descripcion;
	private int verificado;
	private Connection connection;

	public Aficionado(String nombre, String pseudonimo, String correo, String contrasena, String descripcion,
			int verificado) {
		this.nombre = nombre;
		this.pseudonimo = pseudonimo;
		this.correo = correo;
		this.contrasena = contrasena;
		this.descripcion = descripcion;
		this.verificado = verificado;
		this.connection = DatabaseConnection.getInstance().getConnection(); // Conectar a la base de datos
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

	// Agregar un usuario aficionado a la bdd
	public boolean agregarAficionado() {
		String sql = "INSERT INTO usuario (nombre, pseudonimo, correo, contrasena, descripcion, verificado) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setString(1, this.getNombre());
			pstmt.setString(2, this.getPseudonimo());
			pstmt.setString(3, this.getCorreo());
			pstmt.setString(4, this.getContrasena());
			pstmt.setString(5, this.getDescripcion());
			pstmt.setInt(6, this.isVerificado());
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Aficionado insertado exitosamente.");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al insertar el aficionado: " + e.getMessage());
			return false;
		}
	}

	private void eliminarReceta() {
		// TODO Auto-generated method stub

	}

	private void verReceta() {
		// TODO Auto-generated method stub

	}

	private void subirReceta() {
		// TODO Auto-generated method stub

	}

	// Menu
	public void menuRecetas() {
		String[] opcionesRecetas = { "Subir receta", "Ver receta", "Eliminar receta", "Volver" };
		int opcionElegida = 0;
		do {
			opcionElegida = JOptionPane.showOptionDialog(null, "Elija qué desea hacer", "Menú de Recetas", 0, 0, null,
					opcionesRecetas, opcionesRecetas[0]);
			switch (opcionElegida) {
			case 0:
				subirReceta();
				JOptionPane.showMessageDialog(null, "Su receta se subio exitosamente");
				break;
			case 1:
				verReceta();
				JOptionPane.showMessageDialog(null, "Hola, soy una receta");
				break;
			case 2:
				eliminarReceta();
				JOptionPane.showMessageDialog(null, "Su receta se elimino exitosamente");
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Volviendo al menú principal");
				break;
			}
		} while (opcionElegida != 3);
	}

	public void menuFavoritos() {
		String[] opcionesFavoritos = { "Ver recetas favoritas", "Eliminar recetas de favoritas", "Volver" };
		int opcionElegida = 0;
		do {
			opcionElegida = JOptionPane.showOptionDialog(null, "Elija qué desea hacer", "Menú de Recetas", 0, 0, null,
					opcionesFavoritos, opcionesFavoritos[0]);
			switch (opcionElegida) {
			case 0:
				subirReceta();
				JOptionPane.showMessageDialog(null, "Hola, Soy una lista de recetas favoritas c:");
				break;
			case 1:
				verReceta();
				JOptionPane.showMessageDialog(null, "Esta receta se elimino con exito");
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Volviendo al menú principal");
				break;
			}
		} while (opcionElegida != 2);
	}

	public void menuBusqueda() {
		String[] opcionesBusqueda = { "Buscar un perfil", "Buscar una receta", "Volver" };
		int opcionElegida = 0;
		do {
			opcionElegida = JOptionPane.showOptionDialog(null, "Elija qué desea hacer", "Menú de Recetas", 0, 0, null,
					opcionesBusqueda, opcionesBusqueda[0]);
			switch (opcionElegida) {
			case 0:
				subirReceta();
				JOptionPane.showMessageDialog(null, "Nada de stalckear a tu ex");
				break;
			case 1:
				verReceta();
				JOptionPane.showMessageDialog(null, "Esta es tu receta");
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Volviendo al menú principal");
				break;
			}
		} while (opcionElegida != 2);
	}

}
*/
