package Vistas;

import javax.swing.JOptionPane;


import Controladores.CursoControlador;
import Controladores.DatabaseConnection;

import Modelos.Cursos;

import java.sql.Connection;
import javax.swing.ImageIcon;

public class Main {

	public static void main(String[] args) {
		
		//TESTEO DE CONTROLADOR CURSOS
		
CursoControlador controlar = new CursoControlador();
		
		
		String[] opciones = {
				"Agregar curso","Ver curso","Buscar curso por id","Editar curso","Eliminar curso","Salir"
		};
		int opcion=0;
	do {
		
	opcion = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones, opciones[0]);
		switch (opcion) {
		case 0:
			String titulo = JOptionPane.showInputDialog( "Ingrese titulo");
			String lugar = JOptionPane.showInputDialog("Ingrese lugar");
			String dia = JOptionPane.showInputDialog("Ingrese dia");
			int cupo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de cupos"));
			Double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio"));
			String horario = JOptionPane.showInputDialog("Ingrese horario");
			controlar.addCurso(new Cursos(cupo, titulo,null, lugar,dia,cupo,precio,horario));		
			break;
		case 1:
			JOptionPane.showMessageDialog(null, controlar.getAllCursos());	
			break;
		case 2:
			Cursos nuevo = BuscarCurso(controlar);
			JOptionPane.showMessageDialog(null, nuevo);
			break;
		case 3:
			Cursos encontrado = BuscarCurso(controlar);
			String nuevoTitulo = JOptionPane.showInputDialog( "Ingrese el nuevo titulo de "+ encontrado.getTitulo());
			String nuevoLugar = JOptionPane.showInputDialog("Ingrese el nuevo lugar de "+encontrado.getLugar());
			String nuevoDia = JOptionPane.showInputDialog("Ingrese nuevo dia "+encontrado.getDia());
			int nuevoCupo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nueva cantidad de cupos "+encontrado.getCupo()));
			Double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese nuevo precio "+encontrado.getPrecio() ));
			String nuevoHorario = JOptionPane.showInputDialog("Ingrese nuevo horario "+encontrado.getHorario());
			encontrado.setTitulo(nuevoTitulo);
			encontrado.setLugar(nuevoLugar);
			encontrado.setDia(nuevoDia);
			encontrado.setCupo(nuevoCupo);
			encontrado.setPrecio(nuevoPrecio);
			encontrado.setHorario(nuevoHorario);
			controlar.updateCurso(encontrado);
			break;
		case 4:
			Cursos eliminar = BuscarCurso(controlar);
			controlar.deleteCurso(eliminar.getIdCurso());
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "Salir");
			break;
		default:
			break;
		}
	} while (opcion!=5);
	
		
	}
	public static Cursos BuscarCurso(CursoControlador controlar) {
		String[] listaCursos = new String[controlar.getAllCursos().size()];
		
		
		for (int i = 0; i < listaCursos.length; i++) {
			listaCursos[i] = Integer.toString(controlar.getAllCursos().get(i).getIdCurso());
		}
		String elegido =(String) JOptionPane.showInputDialog(null, "Elija un id", null, 0, null, listaCursos, listaCursos[0]);
		
		Cursos nuevo = controlar.getCursoById(Integer.parseInt(elegido));
		return nuevo;
	}
	
	/*DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
	Connection connection = databaseConnection.getConnection();

	// Verificar si la conexión fue exitosa
	if (connection == null) {
		JOptionPane.showMessageDialog(null, "No se pudo establecer la conexión a la base de datos.");
		System.exit(0);
	}

	// Selección de roles
	String[] Ingreso = { "Aficionado", "Chef", "Salir" };
	int opcion = 0;
	do {
		ImageIcon iconBienvenida = new ImageIcon(Main.class.getResource("/imagenes/Bienvenida.png"));
		JOptionPane.showMessageDialog(null, "", "Bienvenid@", 0, iconBienvenida);

		opcion = JOptionPane.showOptionDialog(null, "Elija el rol para ingresar", "Selección de Rol", 0, 0, null,
				Ingreso, Ingreso[0]);

		switch (opcion) {
		case 0: // Aficionado
			ImageIcon iconAficionado = new ImageIcon(Main.class.getResource("/imagenes/aficionado.png"));
			Aficionado aficionado = new Aficionado("Juan", "Juancito", "juan@aficionado.com", "contrasena",
					"mi nombre es juan", Integer.parseInt("1"));
			JOptionPane.showMessageDialog(null, "Bienvenido " + aficionado.getNombre(), "Aficionado", 0,
					iconAficionado);
			String[] opciones = { "Agregar aficionado", "Recetas", "Favoritos", "Busqueda", "Salir" };
			int opcionElegida = 0;
			do {
				opcionElegida = JOptionPane.showOptionDialog(null, "Elija que desea hacer",
						"Acciones de Aficionado", opcion, opcion, null, opciones, opciones[0]);
				switch (opcionElegida) {

				case 0:
					aficionado.agregarAficionado();
					break;
				case 1:
					ImageIcon iconRecetas = new ImageIcon(Main.class.getResource("/imagenes/Recetas.png"));
					JOptionPane.showMessageDialog(null, "", "Bienvenid@", 0, iconRecetas);
					aficionado.menuRecetas();
					break;
				case 2:
					ImageIcon iconFavoritos = new ImageIcon(Main.class.getResource("/imagenes/Favoritos.png"));
					JOptionPane.showMessageDialog(null, "", "Bienvenid@", 0, iconFavoritos);
					aficionado.menuFavoritos();
					break;
				case 3:
					aficionado.menuBusqueda();
					break;
				case 4:
					JOptionPane.showMessageDialog(null, "Salir del perfil");
					break;
				}
			} while (opcionElegida != 3);
			break;
		
		 * case 1: // Chef ImageIcon iconChef = new
		 * ImageIcon(Main.class.getResource("/imagenes/chef.png")); Chef chef = new
		 * Chef("Maria", "maria@chef.com", "contrasena", true);
		 * JOptionPane.showMessageDialog(null, "Bienvenido " + chef.getNombre(), "Chef",
		 * 0, iconChef); String[] opcionesChef = {"Recetas", "Favoritos", "Busqueda",
		 * "Salir"}; int opcionElegidaChef = 0; do { opcionElegidaChef =
		 * JOptionPane.showOptionDialog(null, "Elija que desea hacer",
		 * "Acciones de Chef", opcion, opcion, null, opcionesChef, opcionesChef[0]);
		 * switch (opcionElegidaChef) { case 0: ImageIcon iconRecetas = new
		 * ImageIcon(Main.class.getResource("/imagenes/Recetas.png"));
		 * JOptionPane.showMessageDialog(null, "", "Bienvenid@", 0, iconRecetas);
		 * chef.menuRecetas(); break; case 1: ImageIcon iconFavoritos = new
		 * ImageIcon(Main.class.getResource("/imagenes/Favoritos.png"));
		 * JOptionPane.showMessageDialog(null, "", "Bienvenid@", 0, iconFavoritos);
		 * chef.menuFavoritos(); break; case 2: ImageIcon iconBusqueda = new
		 * ImageIcon(Main.class.getResource("/imagenes/Busqueda.png"));
		 * JOptionPane.showMessageDialog(null, "", "Bienvenid@", 0, iconBusqueda);
		 * chef.menuBusqueda(); break; case 3: JOptionPane.showMessageDialog(null,
		 * "Salir del perfil"); break; } } while (opcionElegidaChef != 3); break;
		 
		case 2: // Salir
			ImageIcon iconSalir = new ImageIcon(Main.class.getResource("/imagenes/Salir.png"));
			JOptionPane.showMessageDialog(null, "Gracias por usar el sistema", "Chef", 0, iconSalir);
			break;
		}
	} while (opcion != 2); 
	*/
	
}
