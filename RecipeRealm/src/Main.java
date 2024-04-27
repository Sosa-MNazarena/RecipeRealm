import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Main {

	public static void main(String[] args) {

		// Options for initial role selection
        String[] Ingreso = {
            "Aficionado", "Chef", "Salir"
        };
        int opcion = 0;
        do {
        	ImageIcon iconBienvenida = new ImageIcon(Main.class.getResource("/imagenes/Bienvenida.png"));
        	 JOptionPane.showMessageDialog(null, "", "Bienvenida", JOptionPane.PLAIN_MESSAGE, iconBienvenida);
             
            opcion = JOptionPane.showOptionDialog(null, "Elija el rol para ingresar", "Selección de Rol", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Ingreso, Ingreso[0]);

            switch (opcion) {
                case 0: // Aficionado
                	ImageIcon iconAficionado = new ImageIcon(Main.class.getResource("/imagenes/aficionado.png"));
                	Aficionado aficionado = new Aficionado("Juan", "juan@aficionado.com", "contrasena");
                    JOptionPane.showMessageDialog(null, "Bienvenido " + aficionado.getNombre(), "Aficionado", JOptionPane.PLAIN_MESSAGE, iconAficionado);
                    String[] opciones = {
                        "Subir receta", "Ver receta", "Eliminar receta", "Salir"
                    };
                    int opcionElegida = 0;
                    do {
                        opcionElegida = JOptionPane.showOptionDialog(null, "Elija que desea hacer", "Acciones de Aficionado", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
                        switch (opcionElegida) {
                            case 0:
                                aficionado.subirReceta();
                                break;
                            case 1:
                                aficionado.verReceta();
                                break;
                            case 2:
                                aficionado.eliminarReceta();
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Salir del perfil");
                                break;
                        }
                    } while (opcionElegida != 3);
                    break;

                case 1: // Chef
                	ImageIcon iconChef = new ImageIcon(Main.class.getResource("/imagenes/chef.png"));
                    Chef chef = new Chef("Maria", "maria@chef.com", "contrasena", true);
                    JOptionPane.showMessageDialog(null, "Bienvenido " + chef.getNombre(), "Chef", JOptionPane.PLAIN_MESSAGE, iconChef);
                    String[] opcionesChef = {
                        "Subir receta verificada", "Ver receta", "Eliminar receta", "Salir"
                    };
                    int opcionElegidaChef = 0;
                    do {
                        opcionElegidaChef = JOptionPane.showOptionDialog(null, "Elija que desea hacer", "Acciones de Chef", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcionesChef, opcionesChef[0]);
                        
                        switch (opcionElegidaChef) {
                            case 0:
                                chef.subirRecetaVerificada();
                                break;
                            case 1:
                                chef.verReceta();
                                break;
                            case 2:
                                chef.eliminarReceta();
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Salir del perfil");
                                break;
                        }
                    } while (opcionElegidaChef != 3);
                    break;

                case 2: // Salir
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema");
                    break;
            }
        } while (opcion != 2);
    
		//hola
		
	}

}


