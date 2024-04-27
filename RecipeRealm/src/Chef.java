import javax.swing.JOptionPane;

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
	    //SubMenuReceta
	    public void subirRecetaVerificada() {
	    	return;
	    }
	    
	    public void verReceta() {
	    	return;
	    }
	    
	    public void eliminarReceta() {
	    	return;
	    }
	    
	    //Menu
	    public void menuRecetas() {
	    	  String[] opcionesRecetas = {
	    	            "Subir receta", "Ver receta", "Eliminar receta", "Volver"
	    	        };
	    	        int opcionElegida = 0;
	    	        do {
	    	            opcionElegida = JOptionPane.showOptionDialog(null, "Elija qué desea hacer", "Menú de Recetas", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcionesRecetas, opcionesRecetas[0]);
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
	    	                    JOptionPane.showMessageDialog(null, "Su receta se elimno exitosamente");
	    	                    break;
	    	                case 3:
	    	                    JOptionPane.showMessageDialog(null, "Volviendo al menú principal");
	    	                    break;
	    	            }
	    	        } while (opcionElegida != 3);
	    	    }

	    public void menuFavoritos() {
	    	String[] opcionesRecetas = {
	            "Ver recetas favoritas", "Eliminar recetas de favoritas", "Volver"
	        };
	        int opcionElegida = 0;
	        do {
	            opcionElegida = JOptionPane.showOptionDialog(null, "Elija qué desea hacer", "Menú de Recetas", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcionesRecetas, opcionesRecetas[0]);
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
	    	return;
	    }


}
