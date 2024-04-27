import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		// Options for initial role selection
        String[] Ingreso = {
            "Aficionado", "Chef", "Salir"
        };
        int opcion = 0;
        do {
            opcion = JOptionPane.showOptionDialog(null, "Elija el rol para ingresar", "Selección de Rol", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Ingreso, Ingreso[0]);

            switch (opcion) {
                case 0: // Aficionado
                    Aficionado aficionado = new Aficionado("Juan", "juan@aficionado.com", "contrasena");
                    JOptionPane.showMessageDialog(null, "Bienvenido " + aficionado.getNombre());
                    String[] opciones = {
                        "Subir receta", "Ver receta", "Eliminar receta", "Salir"
                    };
                    int opcionElegida = 0;
                    do {
                        opcionElegida = JOptionPane.showOptionDialog(null, "Elija que desea hacer", "Acciones de Aficionado", opcion, opcion, null, opciones, opciones[0]);
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
                    Chef chef = new Chef("Maria", "maria@chef.com", "contrasena", true);
                    String[] opcionesChef = {
                        "Subir receta verificada", "Ver receta", "Eliminar receta", "Salir"
                    };
                    int opcionElegidaChef = 0;
                    do {
                        opcionElegidaChef = JOptionPane.showOptionDialog(null, "Elija que desea hacer", "Acciones de Chef",opcion, opcion, null, opcionesChef, opcionesChef[0]);
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


