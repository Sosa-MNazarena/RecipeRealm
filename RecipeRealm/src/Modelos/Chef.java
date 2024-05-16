package Modelos;
import javax.swing.JOptionPane;

public class Chef extends Aficionado {
	 private boolean esVerificado;

	    
	    public Chef(String nombre, String correo, String contrasena, boolean esVerificado) {
	        super(nombre, correo, contrasena);
	        this.esVerificado = esVerificado;
	    }

	    public boolean isVerificado() {
	        return esVerificado;
	    }
	   
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
	    	            opcionElegida = JOptionPane.showOptionDialog(null, "Elija qué desea hacer", "Menú de Recetas", 0, 0, null, opcionesRecetas, opcionesRecetas[0]);
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
	    	String[] opcionesFavoritos = {
	            "Ver recetas favoritas", "Eliminar recetas de favoritas", "Volver"
	        };
	        int opcionElegida = 0;
	        do {
	            opcionElegida = JOptionPane.showOptionDialog(null, "Elija qué desea hacer", "Menú de Recetas", 0, 0, null, opcionesFavoritos, opcionesFavoritos[0]);
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
	    	String[] opcionesBusqueda = {
		            "Buscar un perfil", "Buscar una receta", "Volver"
		        };
		        int opcionElegida = 0;
		        do {
		            opcionElegida = JOptionPane.showOptionDialog(null, "Elija qué desea hacer", "Menú de Recetas", 0, 0, null, opcionesBusqueda, opcionesBusqueda[0]);
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
