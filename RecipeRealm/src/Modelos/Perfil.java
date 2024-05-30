package Modelos;

public class Perfil {

    private int idUsuario;
    private String nombre;
    private String pseudonimo;
    private String correo;
    private String contrasena;
    private String descripcion;
    private boolean verificado;


    public Perfil(int idUsuario, String nombre, String pseudonimo, String correo, String contrasena, String descripcion, boolean verificado) {
        this.setIdUsuario(idUsuario);
        this.setNombre(nombre);
        this.setPseudonimo(pseudonimo);
        this.setCorreo(correo);
        this.setContrasena(contrasena);
        this.setDescripcion(descripcion);
        this.setVerificado(verificado);
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


	public boolean getisVerificado() {
		// TODO Auto-generated method stub
		return false;
	}



}
