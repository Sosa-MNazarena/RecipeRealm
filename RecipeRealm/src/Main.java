import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Main
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
		
Aficionado aficionado = new Aficionado("Juan", "juan@example.com", "password123");
        
        // Verificar que los valores se asignaron correctamente
        System.out.println("Aficionado:");
        System.out.println("Nombre: " + aficionado.getNombre());
        System.out.println("Correo: " + aficionado.getCorreo());
        System.out.println("Contraseña: " + aficionado.getContrasena());
        
        // Cambiar algunos valores y comprobar
        aficionado.setNombre("Juan Pérez");
        aficionado.setCorreo("jperez@example.com");
        
        System.out.println("Aficionado actualizado:");
        System.out.println("Nombre: " + aficionado.getNombre());
        System.out.println("Correo: " + aficionado.getCorreo());
        
        // Crear un objeto Chef que hereda de Aficionado
        Chef chef = new Chef("Ana", "ana@example.com", "cook123", true);

        // Comprobar los valores del Chef
        System.out.println("\nChef:");
        System.out.println("Nombre: " + chef.getNombre());
        System.out.println("Correo: " + chef.getCorreo());
        System.out.println("Contraseña: " + chef.getContrasena());
        System.out.println("Es verificado: " + (chef.isVerificado() ? "Sí" : "No"));
	}

}
