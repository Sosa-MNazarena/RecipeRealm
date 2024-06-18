package Vistas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import Modelos.Perfil;
import Controladores.PerfilControlador;

public class PantallaEditarPerfilChef extends JFrame {
	
	private JTextField inputNombre, inputPseudonimo, inputCorreo;
    private JPasswordField inputContrasena;
    private JTextArea inputDescripcion;
    private Perfil perfil;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public PantallaEditarPerfilChef(Perfil perfil) {
		this.perfil = perfil;
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 678);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Nmbrecito
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		lblNombre.setBounds(20, 41, 337, 22);
		contentPane.add(lblNombre);

		inputNombre = new JTextField(perfil.getNombre());
		inputNombre.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		inputNombre.setBounds(20, 62, 356, 31);
		inputNombre.setBorder(new LineBorder(Color.GRAY, 2, true));
		contentPane.add(inputNombre);
		
		//pseudonimo o nombreUsuario.. ¿por que esta de dos formas?
		JLabel lblPseudonimo = new JLabel("Nombre de usuario o pseudónimo");
		lblPseudonimo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		lblPseudonimo.setBounds(20, 104, 337, 22);
		contentPane.add(lblPseudonimo);

		inputPseudonimo = new JTextField(perfil.getPseudonimo());
		inputPseudonimo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		inputPseudonimo.setBounds(20, 124, 356, 31);
		inputPseudonimo.setBorder(new LineBorder(Color.GRAY, 2, true));
		contentPane.add(inputPseudonimo);
		
		JLabel lblEditarPerfil = new JLabel("Editar perfil");
		lblEditarPerfil.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 23));
		lblEditarPerfil.setBounds(193, 11, 188, 35);
		contentPane.add(lblEditarPerfil);
		
		//correo
		JLabel lblCorreo = new JLabel("Correo Electrónico");
		lblCorreo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		lblCorreo.setBounds(20, 166, 337, 22);
		contentPane.add(lblCorreo);

		inputCorreo = new JTextField(perfil.getCorreo());
		inputCorreo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		inputCorreo.setBounds(20, 185, 356, 31);
		inputCorreo.setBorder(new LineBorder(Color.GRAY, 2, true));
		contentPane.add(inputCorreo);
		
		//contra
		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		lblContrasena.setBounds(20, 227, 337, 22);
		contentPane.add(lblContrasena);

		inputContrasena = new JPasswordField(perfil.getContrasena());
		inputContrasena.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		inputContrasena.setBounds(20, 247, 356, 31);
		inputContrasena.setBorder(new LineBorder(Color.GRAY, 2, true));
		contentPane.add(inputContrasena);
		
		//descrip
		JLabel lblDescripcion = new JLabel("Cuéntanos algo de ti...");
		lblDescripcion.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		lblDescripcion.setBounds(20, 289, 356, 31);
		contentPane.add(lblDescripcion);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		horizontalBox.setBounds(20, 314, 356, 31);
		contentPane.add(horizontalBox);
		
		JTextArea inputDescripcion_1 = new JTextArea();
		inputDescripcion_1.setBounds(20, 314, 354, 29);
		contentPane.add(inputDescripcion_1);
		inputDescripcion_1.setLineWrap(true);
		inputDescripcion_1.setWrapStyleWord(true);
		inputDescripcion_1.setRows(5);
		inputDescripcion_1.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		
		
		
		
		
	}
}
