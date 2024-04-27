import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		// Crear objetos
        Aficionado aficionado = new Aficionado("Juan", "juan@aficionado.com", "contrasena");
        Chef chef = new Chef("Maria", "maria@chef.com", "contrasena", true);

		int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opción (1, 2, o 3):"));

		switch (opcion) {
		case 1:
			JOptionPane.showMessageDialog(null, "Menu 1");
			break;

		case 2:
			JOptionPane.showMessageDialog(null, "Menu 2");
			break;

		case 3:
			JOptionPane.showMessageDialog(null, "Menu 3");
			break;

		default:
			JOptionPane.showMessageDialog(null, "Ingrese una opción valida");
			break;
		}
		
		
	}

}
