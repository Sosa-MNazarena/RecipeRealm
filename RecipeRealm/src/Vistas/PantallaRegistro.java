package Vistas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;

public class PantallaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField inputContrasena;		private JTextField inputNombreUsuario;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaRegistro frame = new PantallaRegistro();
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
	public PantallaRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 772);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCorreo = new JLabel("¿Eres un chef profesional?");
		lblCorreo.setBounds(76, 639, 276, 22);
		lblCorreo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		contentPane.add(lblCorreo);	
		
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(71, 473, 356, 31);
		horizontalBox.setBackground(new Color(255, 255, 255));
		horizontalBox.setBorder(new LineBorder(Color.GRAY, 2, true));
		contentPane.add(horizontalBox);
		
		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setBounds(71, 538, 163, 14);
		lblContrasena.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		contentPane.add(lblContrasena);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBounds(71, 563, 356, 31);
		horizontalBox_1.setBorder(new LineBorder(Color.GRAY, 2, true));
		contentPane.add(horizontalBox_1);
		JLabel lblNewLabel = new JLabel("Recipe Realm");
		lblNewLabel.setBounds(374, 118, 176, 44);
		lblNewLabel.setFont(new Font("Leelawadee UI", Font.PLAIN, 28));
		contentPane.add(lblNewLabel);
		
		JLabel lblNombreUSuario = new JLabel("Nombre de usuario o pseudónimo");
		lblNombreUSuario.setBounds(71, 297, 337, 14);
		lblNombreUSuario.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		contentPane.add(lblNombreUSuario);
		
		Box horizontalBox_1_1 = Box.createHorizontalBox();
		horizontalBox_1_1.setBounds(71, 322, 356, 31);
		horizontalBox_1_1.setBorder(new LineBorder(Color.GRAY, 2, true));
		contentPane.add(horizontalBox_1_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Chef");
		rdbtnNewRadioButton.setFont(new Font("Leelawadee UI", Font.PLAIN, 11));
		rdbtnNewRadioButton.setBounds(76, 668, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Aficionado");
		rdbtnNewRadioButton_1.setFont(new Font("Leelawadee UI", Font.PLAIN, 11));
		rdbtnNewRadioButton_1.setBounds(212, 668, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel lblCorreo_1 = new JLabel("Correo Electrónico");
		lblCorreo_1.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		lblCorreo_1.setBounds(71, 447, 163, 14);
		contentPane.add(lblCorreo_1);

	}
}
