
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
	    
	    public void subirReceta() {
	    	return;
	    }
	    
	    public void verReceta() {
	    	return;
	    }
	    
	    public void eliminarReceta() {
	    	return;
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

