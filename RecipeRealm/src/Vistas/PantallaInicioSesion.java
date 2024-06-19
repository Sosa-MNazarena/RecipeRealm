package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import Modelos.Perfil;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import Controladores.PerfilControlador;
import java.awt.FlowLayout;

public class PantallaInicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputCorreo;
	private JPasswordField inputContrasena;
	private Perfil perfil;
	private PerfilControlador perfilControlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Perfil perfil = new Perfil(1, "Nombre", "Pseudónimo", "correo@example.com", "contraseña", "Descripción", true);
					PantallaInicioSesion frame = new PantallaInicioSesion(perfil);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaInicioSesion(Perfil perfil) {
		setBackground(new Color(204, 51, 0));
		setTitle("Iniciar Sesión");
		 this.perfilControlador = new PerfilControlador();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 772);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(Color.GRAY, 2, true));
		horizontalBox.setBounds(284, 242, 356, 31);
		contentPane.add(horizontalBox);
		
		inputCorreo = new JTextField();
		inputCorreo.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		horizontalBox.add(inputCorreo);
		inputCorreo.setColumns(10);
		
		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		lblContrasena.setBounds(284, 309, 163, 14);
		contentPane.add(lblContrasena);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBorder(new LineBorder(Color.GRAY, 2, true));
		horizontalBox_1.setBounds(284, 334, 356, 31);
		contentPane.add(horizontalBox_1);
		
		inputContrasena = new JPasswordField();
		inputContrasena.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		inputContrasena.setEchoChar('*');
		horizontalBox_1.add(inputContrasena);
		
		JLabel lblCorreo = new JLabel("Correo Electrónico");
		lblCorreo.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		lblCorreo.setBounds(284, 217, 163, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblErrorCorreo = new JLabel("");
		lblErrorCorreo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		lblErrorCorreo.setForeground(new Color(255, 0, 0));
		lblErrorCorreo.setBounds(284, 284, 163, 14);
		contentPane.add(lblErrorCorreo);
		
		JLabel lblErrorContrasena = new JLabel("");
		lblErrorContrasena.setForeground(Color.RED);
		lblErrorContrasena.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		lblErrorContrasena.setBounds(284, 376, 289, 14);
		contentPane.add(lblErrorContrasena);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setSelectedIcon(null);
		btnIniciarSesion.setForeground(new Color(255, 255, 255));
		btnIniciarSesion.setBackground(new Color(205, 92, 92));
		btnIniciarSesion.setFont(new Font("Lucida Console", Font.BOLD, 15));
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String correo = inputCorreo.getText();
			    String contrasena = new String(inputContrasena.getPassword());
			    lblErrorCorreo.setVisible(false);
			    lblErrorContrasena.setVisible(false);
			    
			    Perfil perfil = perfilControlador.iniciarSesion(correo, contrasena);
			    String respuesta = Perfil.IniciarSesion(inputCorreo.getText(), inputContrasena.getText());
			        
			    if (perfil != null) {
                    if (perfil.isVerificado()) {
                        PantallaHomeChef homeChef = new PantallaHomeChef(perfil);
                        homeChef.setVisible(true);
                        dispose();
                    } else {
                        PantallaHomeAficionado homeAficionado = new PantallaHomeAficionado(perfil);
                        homeAficionado.setVisible(true);
                        dispose();
                    }
				}else {
					if (respuesta.equals("Contraseña inválida. Inténtelo nuevamente")) {
						lblErrorContrasena.setText(respuesta);
						lblErrorContrasena.setVisible(true);
					} else if(respuesta.equals("No hay usuario registrado")){
						lblErrorCorreo.setText(respuesta);
						lblErrorCorreo.setVisible(true);
					}
			}
		}
		});
		btnIniciarSesion.setBounds(284, 407, 356, 37);
		contentPane.add(btnIniciarSesion);
		
		//imprimir en pantalla
		System.out.println("Perfil actual: " + perfil);

		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBackground(new Color(255, 255, 204));
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaRegistro registrarse = new PantallaRegistro();
				dispose();
			}
		});
		btnRegistrarse.setFont(new Font("Lucida Console", Font.BOLD, 15));
		btnRegistrarse.setBounds(284, 489, 356, 37);
		contentPane.add(btnRegistrarse);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox_2.setBounds(309, 466, 305, 1);
		contentPane.add(horizontalBox_2);
		
		JLabel lblNewLabel = new JLabel("RECIPE REALM");
		lblNewLabel.setFont(new Font("Lucida Console", Font.PLAIN, 28));
		lblNewLabel.setBounds(352, 118, 219, 44);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 0, 0));
		panel_1.setForeground(new Color(51, 51, 0));
		panel_1.setBounds(294, 421, 356, 37);
		contentPane.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1.setBackground(new Color(255, 204, 0));
		panel_1_1.setBounds(294, 504, 356, 37);
		contentPane.add(panel_1_1);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 153, 0), new Color(255, 255, 102), new Color(255, 255, 0), null));
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(170, 53, 583, 568);
		contentPane.add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(204, 102, 51)));
		panel_2.setBackground(new Color(255, 204, 102));
		panel_2.setBounds(197, 64, 583, 586);
		contentPane.add(panel_2);
		
		
	}
}
