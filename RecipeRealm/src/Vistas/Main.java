package Vistas;
import javax.swing.JOptionPane;
import Controladores.CursoControlador;
import Modelos.Aficionado;
import Modelos.Categoria;
import Modelos.Ingrediente;
import Modelos.Perfil;
import Modelos.Resena;
import Controladores.DatabaseConnection;
import Controladores.PerfilControlador;
import Modelos.Cursos;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import Modelos.Receta;
import Controladores.RecetaControlador;

import javax.swing.ImageIcon;

public class Main {

	public static void main(String[] args) {
		
		//TESTEO DE CONTROLADOR CURSOS
		
		/*CursoControlador controlar = new CursoControlador();
		
		String[] opciones = {
				"Agregar curso","Ver curso","Buscar curso por id","Editar curso","Eliminar curso","Salir"
		};
		int opcion=0;
		
	opcion = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones, opciones[0]);
		switch (opcion) {
		case 0:
			  String titulo = JOptionPane.showInputDialog("Ingrese titulo");
              String lugar = JOptionPane.showInputDialog("Ingrese lugar");
              LocalDate dia = LocalDate.parse(JOptionPane.showInputDialog("Ingrese dia (YYYY-MM-DD)"));
              int cupo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de cupos"));
              Double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio"));
              LocalTime horario = LocalTime.parse(JOptionPane.showInputDialog("Ingrese horario (HH:MM)"));
              controlar.addCurso(new Cursos(0, titulo, null, lugar, dia, cupo, precio, horario));		
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
			LocalDate nuevoDia = LocalDate.parse(JOptionPane.showInputDialog("Ingrese nuevo dia "+encontrado.getDia()));
			int nuevoCupo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nueva cantidad de cupos "+encontrado.getCupo()));
			Double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese nuevo precio "+encontrado.getPrecio() ));
			LocalTime nuevoHorario =LocalTime.parse(JOptionPane.showInputDialog("Ingrese nuevo horario "+encontrado.getHorario()));
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
		
	} while (opcion!=5);*/
	
	
	String[] opcionesInicioSesion = { "Iniciar sesión", "Registrar", "Ver" };
    int opcionn=0;
    PerfilControlador perfilControlador = new PerfilControlador();
    
    do {
        ImageIcon iconBienvenida = new ImageIcon(Main.class.getResource("/imagenes/Bienvenida.png"));
        JOptionPane.showMessageDialog(null, "", "Bienvenid@", 0, iconBienvenida);

        opcionn = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Inicio de sesión", 0, 0, null,
                opcionesInicioSesion, opcionesInicioSesion[0]);

        switch (opcionn) {
            case 0: // Iniciar sesión
                String correo = JOptionPane.showInputDialog("Ingrese su correo:");
                String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña:");
                Perfil perfil = perfilControlador.iniciarSesion(correo, contrasena);
                Perfil.menuPrincipalPerfil();
                /*if (perfil != null) {
                    if (perfil.isVerificado()) {
                        Chef chef = new Chef(perfil.getIdUsuario(), perfil.getNombre(), perfil.getPseudonimo(), perfil.getCorreo(), perfil.getContrasena(), perfil.getDescripcion(), perfil.isVerificado());
                        chef.menuPrincipalChef();
                    } else {
                        Aficionado aficionado = new Aficionado(perfil.getIdUsuario(), perfil.getNombre(), perfil.getPseudonimo(), perfil.getCorreo(), perfil.getContrasena(), perfil.getDescripcion(), perfil.isVerificado());
                        aficionado.menuPrincipalAficionado();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Correo o contraseña incorrectos.");
                }*/
                break;

            case 1: // Registrar
                String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
                String pseudonimo = JOptionPane.showInputDialog("Ingrese su pseudónimo:");
                correo = JOptionPane.showInputDialog("Ingrese su correo:");
                contrasena = JOptionPane.showInputDialog("Ingrese su contraseña:");
                String descripcion = JOptionPane.showInputDialog("Ingrese una descripción:");
                boolean verificado = JOptionPane.showInputDialog("¿Es Chef? (true/false)").equals("true");
                Perfil nuevoPerfil = new Perfil(0, nombre, pseudonimo, correo, contrasena, descripcion, verificado);
                perfilControlador.addPerfil(nuevoPerfil);
                break;

            case 2: // Salir
            	JOptionPane.showMessageDialog(null, perfilControlador.getAllPerfils());	
    			break;
        		
           
        }
    } while (opcionn != 2);
}
		
	public static Perfil BuscarCurso(PerfilControlador perfilControlador) {
		String[] listaCursos = new String[perfilControlador.getAllPerfils().size()];
		
		for (int i = 0; i < listaCursos.length; i++) {
			listaCursos[i] = Integer.toString(perfilControlador.getAllPerfils().get(i).getIdUsuario());
		}
		String elegido =(String) JOptionPane.showInputDialog(null, "Elija un id", null, 0, null, listaCursos, listaCursos[0]);
		
		Perfil nuevo = perfilControlador.getPerfilById(Integer.parseInt(elegido));
		return nuevo;
	}
	
	/*public static Cursos BuscarCurso(CursoControlador controlar) {
		String[] listaCursos = new String[controlar.getAllCursos().size()];
		
		for (int i = 0; i < listaCursos.length; i++) {
			listaCursos[i] = Integer.toString(controlar.getAllCursos().get(i).getIdCurso());
		}
		String elegido =(String) JOptionPane.showInputDialog(null, "Elija un id", null, 0, null, listaCursos, listaCursos[0]);
		
		Cursos nuevo = controlar.getCursoById(Integer.parseInt(elegido));
		return nuevo;
	}*/
	
	
	
		
	
	
}
