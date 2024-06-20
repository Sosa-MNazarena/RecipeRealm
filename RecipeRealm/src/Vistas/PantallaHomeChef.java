package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Modelos.Receta;
import Modelos.Perfil;
import Modelos.Cursos;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.event.ActionEvent;
import Vistas.PantallaEditarPerfilChef;
import Vistas.PantallaMisRecetas;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class PantallaHomeChef extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Perfil perfil;

	public PantallaHomeChef(Perfil perfil) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1058, 845);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBienvenidoChef = new JLabel("Recipe Realm");
		lblBienvenidoChef.setForeground(new Color(255, 255, 255));
		lblBienvenidoChef.setBackground(new Color(255, 255, 255));
		lblBienvenidoChef.setFont(new Font("Lucida Console", Font.BOLD, 20));
		lblBienvenidoChef.setBounds(877, 7, 155, 36);
		contentPane.add(lblBienvenidoChef);

		JButton btnSubirReceta = new JButton("Subir Receta");
		btnSubirReceta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaSubirReceta subirReceta = new PantallaSubirReceta(perfil);
				dispose();
			}
		});
		btnSubirReceta.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/pergaminoIcon.png")));
		btnSubirReceta.setFont(new Font("Lucida Console", Font.BOLD, 18));
		btnSubirReceta.setBackground(new Color(255, 255, 255));
		btnSubirReceta.setBounds(141, 116, 694, 93);
		contentPane.add(btnSubirReceta);

		JButton btnMisFavoritos = new JButton("Mis Favoritos");
		btnMisFavoritos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablaFavoritos tablaFav = new TablaFavoritos(perfil);
				dispose();

			}
		});
		btnMisFavoritos.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/corazonIcon.png")));
		btnMisFavoritos.setFont(new Font("Lucida Console", Font.BOLD, 18));
		btnMisFavoritos.setBackground(new Color(255, 255, 255));
		btnMisFavoritos.setBounds(141, 242, 694, 93);
		contentPane.add(btnMisFavoritos);

		JButton btnMenuRecetas = new JButton("Recetas");
		btnMenuRecetas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablaReceta tablaRecetas = new TablaReceta(perfil);
				dispose();
			}
		});
		btnMenuRecetas.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/menuIcon.png")));
		btnMenuRecetas.setFont(new Font("Lucida Console", Font.BOLD, 18));
		btnMenuRecetas.setBackground(new Color(255, 255, 255));
		btnMenuRecetas.setBounds(138, 482, 694, 93);
		contentPane.add(btnMenuRecetas);

		JButton btnMenuCursos = new JButton("Cursos");
		btnMenuCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablaCursos tablaCursos = new TablaCursos(perfil);
				dispose();
			}
		});
		btnMenuCursos.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/cerditoIcon.png")));
		btnMenuCursos.setFont(new Font("Lucida Console", Font.BOLD, 18));
		btnMenuCursos.setBackground(new Color(255, 255, 255));
		btnMenuCursos.setBounds(139, 600, 694, 93);
		contentPane.add(btnMenuCursos);

		JButton btnEditarPerfil = new JButton("Editar Perfil");
		btnEditarPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaEditarPerfilChef editarPerfil = new PantallaEditarPerfilChef(perfil);
				editarPerfil.setVisible(true);
			}
		});
		
		btnEditarPerfil.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/usuarioIconMini.png")));

		btnEditarPerfil.setForeground(Color.WHITE);
		btnEditarPerfil.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 17));
		btnEditarPerfil.setBackground(Color.GRAY);
		btnEditarPerfil.setBounds(141, 718, 338, 54);
		contentPane.add(btnEditarPerfil);

		JButton btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 17));
		btnCerrarSesion.setBackground(Color.BLACK);
		btnCerrarSesion.setBounds(497, 718, 338, 54);
		contentPane.add(btnCerrarSesion);

		JButton btnSubirCurso = new JButton("Subir Curso");
		btnSubirCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaSubirCurso subirCurso = new PantallaSubirCurso(perfil);
				dispose();
			}
		});
		btnSubirCurso.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/libroIcon.png")));
		btnSubirCurso.setFont(new Font("Lucida Console", Font.BOLD, 18));
		btnSubirCurso.setBackground(new Color(255, 255, 255));
		btnSubirCurso.setBounds(140, 362, 694, 93);
		contentPane.add(btnSubirCurso);
		JButton btnMisRecetas = new JButton("Prueba de mis recetas");
		btnMisRecetas.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Receta receta = new Receta(1, "Nombre de la receta", "Descripción de la receta", "Categoría", "Ingredientes", LocalDate.now(), 1);

		        PantallaMisRecetas pantallaMisRecetas = new PantallaMisRecetas(perfil);
		        pantallaMisRecetas.setVisible(true);
		        dispose();
		    }
		});
		btnMisRecetas.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnMisRecetas.setBackground(Color.LIGHT_GRAY);
		btnMisRecetas.setBounds(861, 583, 205, 34);
		contentPane.add(btnMisRecetas);
		
		JButton btnMisRecetas_1 = new JButton("Prueba de mis cursos");
		btnMisRecetas_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cursos curso = new Cursos(1, "", 1, "", LocalDate.now(), 20, 100.0,
						LocalTime.now());

		        PantallaMisCursos pantallaMisCursos = new PantallaMisCursos(perfil);
		        pantallaMisCursos.setVisible(true);
		        dispose();
			}
		});
		btnMisRecetas_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnMisRecetas_1.setBackground(Color.LIGHT_GRAY);
		btnMisRecetas_1.setBounds(861, 628, 205, 34);
		contentPane.add(btnMisRecetas_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1.setBackground(new Color(255, 255, 102));
		panel_1_1.setBounds(148, 126, 699, 97);
		contentPane.add(panel_1_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1_1.setBackground(new Color(255, 204, 0));
		panel_1_1_1.setBounds(149, 250, 699, 97);
		contentPane.add(panel_1_1_1);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1_1_1.setBackground(new Color(255, 153, 51));
		panel_1_1_1_1.setBounds(147, 372, 699, 97);
		contentPane.add(panel_1_1_1_1);
		
		JPanel panel_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1_1_1_1.setBackground(new Color(255, 102, 0));
		panel_1_1_1_1_1.setBounds(145, 490, 699, 97);
		contentPane.add(panel_1_1_1_1_1);
		
		JPanel panel_1_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1_1_1_1_1.setBackground(new Color(153, 0, 0));
		panel_1_1_1_1_1_1.setBounds(147, 610, 699, 97);
		contentPane.add(panel_1_1_1_1_1_1);
		
		JLabel lblParaChefs = new JLabel("para chefs");
		lblParaChefs.setHorizontalAlignment(SwingConstants.RIGHT);
		lblParaChefs.setForeground(new Color(255, 255, 102));
		lblParaChefs.setFont(new Font("Book Antiqua", Font.BOLD, 15));
		lblParaChefs.setBackground(Color.WHITE);
		lblParaChefs.setBounds(873, 29, 155, 25);
		contentPane.add(lblParaChefs);
		
	}
}
