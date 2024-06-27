package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Modelos.Receta;
import Modelos.Perfil;
import Modelos.Cursos;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import javax.swing.JScrollBar;

public class PantallaHomeChef extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Perfil perfil;

	public PantallaHomeChef(Perfil perfil) {
		this.setVisible(true);
		this.perfil=perfil;
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
		btnSubirReceta.setBounds(141, 86, 694, 93);
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
		btnMisFavoritos.setBounds(141, 210, 694, 93);
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
		btnMenuRecetas.setBounds(141, 454, 694, 93);
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
		btnMenuCursos.setBounds(141, 572, 694, 93);
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
		btnEditarPerfil.setBounds(141, 690, 205, 54);
		contentPane.add(btnEditarPerfil);

		JButton btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarSesion();
				PantallaInicioSesion iniciarSesion = new PantallaInicioSesion(perfil);
				iniciarSesion.setVisible(true);
				dispose();
			}
		});
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setFont(new Font("Lucida Console", Font.BOLD, 17));
		btnCerrarSesion.setBackground(new Color(255, 153, 153));
		btnCerrarSesion.setBounds(632, 692, 205, 54);
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
		btnSubirCurso.setBounds(141, 332, 694, 93);
		contentPane.add(btnSubirCurso);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1.setBackground(new Color(255, 255, 102));
		panel_1_1.setBounds(148, 96, 699, 97);
		contentPane.add(panel_1_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1_1.setBackground(new Color(255, 204, 0));
		panel_1_1_1.setBounds(149, 218, 699, 97);
		contentPane.add(panel_1_1_1);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1_1_1.setBackground(new Color(255, 153, 51));
		panel_1_1_1_1.setBounds(148, 342, 699, 97);
		contentPane.add(panel_1_1_1_1);
		
		JPanel panel_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1_1_1_1.setBackground(new Color(255, 102, 0));
		panel_1_1_1_1_1.setBounds(148, 462, 699, 97);
		contentPane.add(panel_1_1_1_1_1);
		
		JPanel panel_1_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1_1_1_1_1.setBackground(new Color(153, 0, 0));
		panel_1_1_1_1_1_1.setBounds(149, 582, 699, 97);
		contentPane.add(panel_1_1_1_1_1_1);
		
		JLabel lblParaChefs = new JLabel("para chefs");
		lblParaChefs.setHorizontalAlignment(SwingConstants.RIGHT);
		lblParaChefs.setForeground(new Color(255, 255, 102));
		lblParaChefs.setFont(new Font("Book Antiqua", Font.BOLD, 15));
		lblParaChefs.setBackground(Color.WHITE);
		lblParaChefs.setBounds(873, 29, 155, 25);
		contentPane.add(lblParaChefs);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(51, 51, 0));
		panel_1.setBackground(new Color(102, 0, 0));
		panel_1.setBounds(642, 703, 205, 54);
		contentPane.add(panel_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setForeground(new Color(51, 51, 0));
		panel_1_2.setBackground(new Color(102, 0, 0));
		panel_1_2.setBounds(151, 703, 205, 54);
		contentPane.add(panel_1_2);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(0, 0, 17, 806);
		contentPane.add(scrollBar);
	}
		
		 private void cerrarSesion() {
		        perfil = null;
		        System.out.println("Sesión cerrada");
		        JOptionPane.showMessageDialog(null, "Sesión cerrada exitosamente");
		    }
}
