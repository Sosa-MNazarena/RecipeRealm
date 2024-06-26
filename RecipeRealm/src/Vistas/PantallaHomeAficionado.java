package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Box;
import javax.swing.border.LineBorder;

import Modelos.Perfil;
import Vistas.PantallaEditarPerfilChef;
import javax.swing.SwingConstants;

public class PantallaHomeAficionado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Perfil perfil;

	
	public PantallaHomeAficionado(Perfil perfil) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 856);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSubirReceta = new JButton("Subir Receta");
		btnSubirReceta.setForeground(new Color(0, 0, 0));
		btnSubirReceta.setBackground(Color.WHITE);
		btnSubirReceta.setFont(new Font("Lucida Console", Font.BOLD, 16));
		btnSubirReceta.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/pergaminoIcon.png")));
		btnSubirReceta.setBounds(179, 94, 694, 93);
		contentPane.add(btnSubirReceta);
		btnSubirReceta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaSubirReceta subirReceta = new PantallaSubirReceta(perfil);
				dispose();
			}
		});
		
		
		JButton btnMenuRecetas = new JButton("Recetas");
		btnMenuRecetas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablaReceta tablaRecetas = new TablaReceta(perfil);
				dispose();
			}
		});
		btnMenuRecetas.setBackground(Color.WHITE);
		btnMenuRecetas.setFont(new Font("Lucida Console", Font.BOLD, 18));
		btnMenuRecetas.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/menuIcon.png")));
		btnMenuRecetas.setBounds(179, 338, 694, 93);
		contentPane.add(btnMenuRecetas);
		
		JButton btnEditarPerfil = new JButton("Editar Perfil");
		btnEditarPerfil.setForeground(new Color(0, 0, 0));
		btnEditarPerfil.setFont(new Font("Lucida Console", Font.BOLD, 17));
		btnEditarPerfil.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/usuarioIcon.png")));
		btnEditarPerfil.setBackground(Color.WHITE);
		btnEditarPerfil.setBounds(179, 580, 694, 93);
		contentPane.add(btnEditarPerfil);
		
		btnEditarPerfil.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            PantallaEditarPerfilChef editarPerfil = new PantallaEditarPerfilChef(perfil);
	            editarPerfil.setVisible(true);
	        }
	    });
		
		JButton btnMisFavoritos = new JButton("Mis Favoritos");
		btnMisFavoritos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablaFavoritos tablaFav = new TablaFavoritos(perfil);
				dispose();
			}
		});
		btnMisFavoritos.setForeground(new Color(0, 0, 0));
		btnMisFavoritos.setBackground(Color.WHITE);
		btnMisFavoritos.setFont(new Font("Lucida Console", Font.BOLD, 16));
		btnMisFavoritos.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/corazonIcon.png")));
		btnMisFavoritos.setBounds(179, 217, 694, 93);
		contentPane.add(btnMisFavoritos);
		
		JButton btnMenuCursos = new JButton("Cursos");
		btnMenuCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablaCursos tablaCursos = new TablaCursos(perfil);
				dispose();
			}
		});
		btnMenuCursos.setForeground(new Color(0, 0, 0));
		btnMenuCursos.setBackground(Color.WHITE);
		btnMenuCursos.setFont(new Font("Lucida Console", Font.BOLD, 18));
		btnMenuCursos.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/cerditoIcon.png")));
		btnMenuCursos.setBounds(179, 462, 694, 93);
		contentPane.add(btnMenuCursos);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarSesion();
				PantallaInicioSesion iniciarSesion = new PantallaInicioSesion(perfil);
				iniciarSesion.setVisible(true);
				dispose();
			}
		});
		btnCerrarSesion.setBackground(new Color(255, 153, 153));
		btnCerrarSesion.setForeground(new Color(255, 255, 255));
		btnCerrarSesion.setFont(new Font("Lucida Console", Font.BOLD, 17));
		btnCerrarSesion.setBounds(668, 715, 205, 54);
		contentPane.add(btnCerrarSesion);
		
		JLabel lblBienvenidoChef = new JLabel("Recipe Realm");
		lblBienvenidoChef.setForeground(Color.WHITE);
		lblBienvenidoChef.setFont(new Font("Lucida Console", Font.BOLD, 20));
		lblBienvenidoChef.setBackground(Color.WHITE);
		lblBienvenidoChef.setBounds(841, 11, 155, 36);
		contentPane.add(lblBienvenidoChef);
		
		JLabel lblParaChefs = new JLabel("para aficionados");
		lblParaChefs.setHorizontalAlignment(SwingConstants.RIGHT);
		lblParaChefs.setForeground(new Color(255, 51, 51));
		lblParaChefs.setFont(new Font("Dialog", Font.BOLD, 15));
		lblParaChefs.setBackground(new Color(255, 255, 255));
		lblParaChefs.setBounds(837, 33, 155, 36);
		contentPane.add(lblParaChefs);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1.setBackground(new Color(255, 255, 102));
		panel_1_1.setBounds(189, 109, 699, 97);
		contentPane.add(panel_1_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1_1.setBackground(new Color(255, 204, 0));
		panel_1_1_1.setBounds(189, 230, 699, 97);
		contentPane.add(panel_1_1_1);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1_1_1.setBackground(new Color(255, 153, 51));
		panel_1_1_1_1.setBounds(189, 354, 699, 97);
		contentPane.add(panel_1_1_1_1);
		
		JPanel panel_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1_1_1_1.setBackground(new Color(255, 102, 0));
		panel_1_1_1_1_1.setBounds(189, 472, 699, 97);
		contentPane.add(panel_1_1_1_1_1);
		
		JPanel panel_1_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1_1_1_1_1.setBackground(new Color(153, 0, 0));
		panel_1_1_1_1_1_1.setBounds(189, 592, 699, 97);
		contentPane.add(panel_1_1_1_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(51, 51, 0));
		panel_1.setBackground(new Color(102, 0, 0));
		panel_1.setBounds(678, 726, 210, 54);
		contentPane.add(panel_1);
	}
	
	 private void cerrarSesion() {
	        perfil = null;
	        System.out.println("Sesión cerrada");
	        JOptionPane.showMessageDialog(null, "Sesión cerrada exitosamente");
	    }
}
