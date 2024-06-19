package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelos.Perfil;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Vistas.PantallaEditarPerfilChef;

public class PantallaHomeChef extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Perfil perfil;

	
	public PantallaHomeChef(Perfil perfil) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1058, 845);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenidoChef = new JLabel("Bienvenido Chef");
		lblBienvenidoChef.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 26));
		lblBienvenidoChef.setBounds(424, 130, 194, 34);
		contentPane.add(lblBienvenidoChef);
		
		JButton btnSubirReceta = new JButton("Subir Receta");
		btnSubirReceta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaSubirReceta subirReceta = new PantallaSubirReceta(perfil);
				dispose();
			}
		});
		btnSubirReceta.setIcon(new ImageIcon("D:\\Mis Datos\\Downloads\\recipe.png"));
		btnSubirReceta.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnSubirReceta.setBackground(Color.LIGHT_GRAY);
		btnSubirReceta.setBounds(147, 213, 205, 191);
		contentPane.add(btnSubirReceta);
		
		JButton btnMisFavoritos = new JButton("Mis Favoritos");
		btnMisFavoritos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablaFavoritos tablaFav = new TablaFavoritos(perfil);
				dispose();
				
			}
		});
		btnMisFavoritos.setIcon(new ImageIcon("D:\\Mis Datos\\Downloads\\opinion-del-cliente (2).png"));
		btnMisFavoritos.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnMisFavoritos.setBackground(Color.LIGHT_GRAY);
		btnMisFavoritos.setBounds(413, 213, 205, 191);
		contentPane.add(btnMisFavoritos);
		
		JButton btnMenuRecetas = new JButton("Recetas");
		btnMenuRecetas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablaReceta tablaRecetas = new TablaReceta(perfil);
				dispose();
			}
		});
		btnMenuRecetas.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		btnMenuRecetas.setBackground(Color.LIGHT_GRAY);
		btnMenuRecetas.setBounds(272, 453, 480, 63);
		contentPane.add(btnMenuRecetas);
		
		JButton btnMenuCursos = new JButton("Cursos");
		btnMenuCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablaCursos tablaCursos = new TablaCursos();
				dispose();
			}
		});
		btnMenuCursos.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		btnMenuCursos.setBackground(Color.LIGHT_GRAY);
		btnMenuCursos.setBounds(272, 546, 480, 63);
		contentPane.add(btnMenuCursos);
		
		JButton btnEditarPerfil = new JButton("Editar Perfil");
		btnEditarPerfil.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            PantallaEditarPerfilChef editarPerfil = new PantallaEditarPerfilChef(perfil);
	            editarPerfil.setVisible(true);
	        }
	    });
		
		btnEditarPerfil.setForeground(Color.WHITE);
		btnEditarPerfil.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 17));
		btnEditarPerfil.setBackground(Color.GRAY);
		btnEditarPerfil.setBounds(272, 661, 205, 54);
		contentPane.add(btnEditarPerfil);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 17));
		btnCerrarSesion.setBackground(Color.BLACK);
		btnCerrarSesion.setBounds(547, 661, 205, 54);
		contentPane.add(btnCerrarSesion);
		
		JButton btnSubirCurso = new JButton("Subir Curso");
		btnSubirCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaSubirCurso subirCurso = new PantallaSubirCurso();
				dispose();
			}
		});
		btnSubirCurso.setIcon(new ImageIcon("D:\\Mis Datos\\Downloads\\revista.png"));
		btnSubirCurso.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnSubirCurso.setBackground(Color.LIGHT_GRAY);
		btnSubirCurso.setBounds(673, 213, 205, 191);
		contentPane.add(btnSubirCurso);
	}
}
