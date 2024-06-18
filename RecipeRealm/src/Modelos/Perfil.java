
package Modelos;

import java.util.List;
import Controladores.PerfilControlador;
import Controladores.FavoritoControlador;
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

	public static String RegistrarPerfil(String nombre, String pseudonimo, String correo, String contrasena,
			String descripcion, boolean verificado) {
		if (nombre.isEmpty() || pseudonimo.isEmpty() || correo.isEmpty() || contrasena.isEmpty()
				|| descripcion.isEmpty()) {
			return " ¡Error! Todos los campos son obligatorios";
		}

		if (!esContrasenaValida(contrasena)) {
			return "La contraseña no cumple con los requisitos: Debe contener al menos una mayúscula, una minúscula, un número y un caracter especial.";
		}
		
		if (caracteresMaxDescripcion(descripcion)) {
			return "Se excede el límite de 100 caracteres.";
		}
		
		 Perfil perfil = new Perfil(0, nombre,pseudonimo,correo,contrasena,descripcion,verificado);
	        perfil.setNombre(nombre);
	        perfil.setPseudonimo(pseudonimo);
	        perfil.setCorreo(correo);
	        perfil.setContrasena(contrasena);
	        perfil.setDescripcion(descripcion);
	        perfil.setVerificado(verificado);

	       	PerfilControlador perfilControlar = new PerfilControlador();
	        try {
	            perfilControlar.addPerfil(perfil);
	            return "Perfil creado exitosamente";
	        } catch (Exception e) {
	            return "No se ha podido crear el perfil. Inténtelo más tarde.";
	        }
	
	}

	public static boolean caracteresMaxDescripcion(String descripcion) {
		if (descripcion.length() > 100) {
			return true;
		}
		return false;
		
	}

	public static boolean esContrasenaValida(String contrasena) {
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

	
}
