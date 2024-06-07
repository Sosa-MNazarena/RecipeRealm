
package Modelos;

import java.util.List;
import Controladores.PerfilControlador;
import javax.swing.JOptionPane;

public class Perfil {

    private int idUsuario;
    private String nombre;
    private String pseudonimo;
    private String correo;
    private String contrasena;
    private String descripcion;
    private boolean verificado;
    
	public Perfil(int idUsuario, String nombre, String pseudonimo, String correo, String contrasena, String descripcion,
			boolean verificado) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.pseudonimo = pseudonimo;
		this.correo = correo;
		this.contrasena = contrasena;
		this.descripcion = descripcion;
		this.verificado = verificado;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPseudonimo() {
		return pseudonimo;
	}

	public void setPseudonimo(String pseudonimo) {
		this.pseudonimo = pseudonimo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isVerificado() {
		return verificado;
	}

	public void setVerificado(boolean verificado) {
		this.verificado = verificado;
	}

	@Override
	public String toString() {
		return "Perfil [idUsuario=" + idUsuario + ", nombre=" + nombre + ", pseudonimo=" + pseudonimo + ", correo="
				+ correo + ", contrasena=" + contrasena + ", descripcion=" + descripcion + ", verificado=" + verificado
				+ "]";
	}
    

	public static String IniciarSesion(String correo, String contrasena) {

		PerfilControlador controlador = new PerfilControlador();

		if (controlador.getAllPerfils().isEmpty()) {
			return "No hay usuarios registrados";
		} else {
			for (Perfil perfil : controlador.getAllPerfils()) {
				if (perfil.getCorreo().equals(correo) && perfil.getContrasena().equals(contrasena)) {
					return "rol:"+perfil.isVerificado();
				}else if (perfil.getCorreo().equals(correo) && !perfil.getContrasena().equals(contrasena)) {
					return "Contraseña inválida. Inténtelo nuevamente";
				}
			}
			return "No hay usuario registrado";
		}

	}

	public boolean RegistrarPerfil(String nombre, String pseudonimo, String correo, String contrasena,
			String descripcion) {
		if (nombre.isEmpty() || pseudonimo.isEmpty() || correo.isEmpty() || contrasena.isEmpty()
				|| descripcion.isEmpty()) {
			// Error, todos los campos son obilgatorios
			return false;
		}

		if (!esContrasenaValida(contrasena)) {
			// La contraseña no cumple con los requisitos
			return false;
		}
		return verificado;
	}

	public boolean caracteresMaxDescripcion(String descripcion) {
		if (descripcion.length() > 200) {
			// La descripcion excede el limite de caracteres
			return false;
		} else {
			return true;
		}
	}

	public static boolean esContrasenaValida(String contrasena) {
		if (contrasena.length() < 1) {
			return false;
		}
		boolean tieneMayuscula = false;
		boolean tieneMinuscula = false;
		boolean tieneDigito = false;
		boolean tieneCaracterEspecial = false;
		for (char c : contrasena.toCharArray()) {
			if (Character.isUpperCase(c)) {
				tieneMayuscula = true;
			} else if (Character.isLowerCase(c)) {
				tieneMinuscula = true;
			} else if (Character.isDigit(c)) {
				tieneDigito = true;
			} else if (!Character.isLetterOrDigit(c)) {
				tieneCaracterEspecial = true;
			}
		}
		return tieneMayuscula && tieneMinuscula && tieneDigito && tieneCaracterEspecial;
	}

	// Menues
		public void menuRecetas() {
			String[] opcionesRecetas = { "Mis recetas", "Recetas", "Volver" };
			int opcionElegida = 0;
			do {
				opcionElegida = JOptionPane.showOptionDialog(null, "Elija qué desea hacer", "Menú de Recetas", 0, 0, null,
						opcionesRecetas, opcionesRecetas[0]);
				switch (opcionElegida) {
				case 0:
					Receta.menuMisRecetas();
					break;
				case 1:

					// Funcionalidades para recetas que no son propias
					break;
				case 2:
					JOptionPane.showMessageDialog(null, "Volviendo al menú principal");
					break;
				}
			} while (opcionElegida != 2);
		}


		public static void menuPrincipalPerfil() {

			        String[] opciones = { "Perfil", "Recetas", "Favoritos", "Cursos", "Salir" };
			        int opcionElegida = 0;
			        do {
			            opcionElegida = JOptionPane.showOptionDialog(null, "Elija una opción", "Menú Principal", 0, 0, null, opciones, opciones[0]);
			            switch (opcionElegida) {
			                case 0:
			                    //menuPerfil();
			                    break;
			                case 1:
			                    Receta.menuMisRecetas();
			                    break;
			                case 2:
			                    //menuFavoritos();
			                    break;
			                case 3:
			                    //menuCursos();
			                    break;
			                case 4:
			                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
			                    break;
			            }
			        } while (opcionElegida != 4);
			    }		
	 
	 
}
