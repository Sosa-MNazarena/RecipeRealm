
public class Chef extends Aficionado {
	 private boolean esVerificado; // Atributo adicional

	    // Constructor que llama al constructor de la superclase y añade esVerificado
	    public Chef(String nombre, String correo, String contrasena, boolean esVerificado) {
	        super(nombre, correo, contrasena);
	        this.esVerificado = esVerificado;
	    }

	    // Getter para esVerificado
	    public boolean isVerificado() {
	        return esVerificado;
	    }

	    // Setter para esVerificado
	    public void setVerificado(boolean esVerificado) {
	        this.esVerificado = esVerificado;
	    }

	    public void subirRecetaVerificada() {
	    	return;
	    }
	    
	    public void verReceta() {
	    	return;
	    }
	    
	    public void eliminarReceta() {
	    	return;
	    }

}
