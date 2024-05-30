package Modelos;

import javax.swing.*;

public class Chef extends Perfil {
    public Chef(int id, String nombre, String pseudonimo, String correo, String contrasena, String descripcion, boolean verificado) {
        super(id, nombre, pseudonimo, correo, contrasena, descripcion, verificado);
    }

    public void menuPrincipalChef() {
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
	 /*	    
	    public Chef(String nombre, String correo, String contrasena, boolean esVerificado) {
	        super(nombre, correo, contrasena, contrasena, contrasena, esVerificado);
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
*/
	 
