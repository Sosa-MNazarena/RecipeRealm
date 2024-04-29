import javax.swing.JOptionPane;


public class Aficionado implements Menu {
	// Create aficionado
	  	private String nombre;
	    private String correo;
	    private String contrasena;

	    // Constructor 
	    public Aficionado(String nombre, String correo, String contrasena) {
	        this.nombre = nombre;
	        this.correo = correo;
	        this.contrasena = contrasena;
	    }

	
	    public String getNombre() {
	        return nombre;
	    }

	    public String getCorreo() {
	        return correo;
	    }

	  
	    public String getContrasena() {
	        return contrasena;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public void setCorreo(String correo) {
	        this.correo = correo;
	    }

	    public void setContrasena(String contrasena) {
	        this.contrasena = contrasena;
	    }
	    
	    public void mostrarMenu() {
	        System.out.println("1. Realizar actividad");
	        System.out.println("2. Salir");
	    }
	    
	    //SubMenuRecetas
	    public void subirReceta() {
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
		            opcionElegida = JOptionPane.showOptionDialog(null, "Elija qué desea hacer", "Menú de Recetas", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcionesFavoritos, opcionesFavoritos[0]);
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
		            opcionElegida = JOptionPane.showOptionDialog(null, "Elija qué desea hacer", "Menú de Recetas", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcionesBusqueda, opcionesBusqueda[0]);
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

	    @Override
	    public void seleccionarOpcion(int opcion) {
	        switch (opcion) {
	            case 1:
	                realizarActividad();
	                break;
	            case 2:
	                System.out.println("Saliendo...");
	                System.exit(0);
	                break;
	            default:
	                System.out.println("Opción no válida");
	                mostrarMenu();
	        }
	    }

	    public void realizarActividad() {
	        System.out.println(this.nombre + " está realizando una actividad.");
	    }
	

	  
	}

