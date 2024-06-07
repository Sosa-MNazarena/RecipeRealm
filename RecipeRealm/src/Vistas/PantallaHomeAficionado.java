package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.border.LineBorder;

public class PantallaHomeAficionado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public PantallaHomeAficionado() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 856);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSubirReceta = new JButton("Subir Receta");
		btnSubirReceta.setBackground(new Color(192, 192, 192));
		btnSubirReceta.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnSubirReceta.setIcon(new ImageIcon("D:\\Mis Datos\\Downloads\\recipe.png"));
		btnSubirReceta.setBounds(250, 183, 205, 191);
		contentPane.add(btnSubirReceta);
		
		JButton btnMenuRecetas = new JButton("Recetas");
		btnMenuRecetas.setBackground(new Color(192, 192, 192));
		btnMenuRecetas.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		btnMenuRecetas.setBounds(250, 423, 480, 63);
		contentPane.add(btnMenuRecetas);
		
		JButton btnEditarPerfil = new JButton("Editar Perfil");
		btnEditarPerfil.setForeground(new Color(255, 255, 255));
		btnEditarPerfil.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 17));
		btnEditarPerfil.setBackground(new Color(128, 128, 128));
		btnEditarPerfil.setBounds(250, 631, 205, 54);
		contentPane.add(btnEditarPerfil);
		
		JButton btnMisFavoritos = new JButton("Mis Favoritos");
		btnMisFavoritos.setBackground(new Color(192, 192, 192));
		btnMisFavoritos.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnMisFavoritos.setIcon(new ImageIcon("D:\\Mis Datos\\Downloads\\opinion-del-cliente (2).png"));
		btnMisFavoritos.setBounds(525, 183, 205, 191);
		contentPane.add(btnMisFavoritos);
		
		JButton btnMenuCursos = new JButton("Cursos");
		btnMenuCursos.setBackground(new Color(192, 192, 192));
		btnMenuCursos.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
		btnMenuCursos.setBounds(250, 516, 480, 63);
		contentPane.add(btnMenuCursos);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.setBackground(new Color(0, 0, 0));
		btnCerrarSesion.setForeground(new Color(255, 255, 255));
		btnCerrarSesion.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 17));
		btnCerrarSesion.setBounds(525, 631, 205, 54);
		contentPane.add(btnCerrarSesion);
		
		JLabel lblNewLabel = new JLabel("Bienvenido Aficionado");
		lblNewLabel.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 26));
		lblNewLabel.setBounds(361, 100, 263, 34);
		contentPane.add(lblNewLabel);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		horizontalBox.setBounds(116, 51, 746, 704);
		contentPane.add(horizontalBox);
	}
}
