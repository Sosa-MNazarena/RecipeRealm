package Vistas;

import javax.swing.ButtonGroup;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelos.Perfil;
import Controladores.PerfilControlador;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

public class PantallaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField inputContrasena;
	private JTextField inputNombreUsuario;
	private JTextField inputNombre;
	private JTextField inputCorreo;
	private JRadioButton rdbtnChef;
	private JRadioButton rdbtnAficionado;
	private ButtonGroup groupRol;
	private Perfil perfil;

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
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 733);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				JLabel lblExito = new JLabel("");
				lblExito.setForeground(new Color(0, 128, 0));
				lblExito.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
				lblExito.setBounds(468, 561, 356, 22);
				contentPane.add(lblExito);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		lblNombre.setBounds(71, 144, 337, 22);
		contentPane.add(lblNombre);

		inputNombre = new JTextField();
		inputNombre.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		inputNombre.setBounds(71, 177, 356, 31);
		inputNombre.setBorder(new LineBorder(Color.GRAY, 2, true));
		contentPane.add(inputNombre);

		JLabel lblNombreUsuario = new JLabel("Nombre de usuario o pseudónimo");
		lblNombreUsuario.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		lblNombreUsuario.setBounds(71, 232, 337, 22);
		contentPane.add(lblNombreUsuario);

		inputNombreUsuario = new JTextField();
		inputNombreUsuario.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		inputNombreUsuario.setBounds(71, 265, 356, 31);
		inputNombreUsuario.setBorder(new LineBorder(Color.GRAY, 2, true));
		contentPane.add(inputNombreUsuario);

		JLabel lblCorreo = new JLabel("Correo Electrónico");
		lblCorreo.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		lblCorreo.setBounds(71, 320, 337, 22);
		contentPane.add(lblCorreo);

		inputCorreo = new JTextField();
		inputCorreo.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		inputCorreo.setBounds(71, 353, 356, 31);
		inputCorreo.setBorder(new LineBorder(Color.GRAY, 2, true));
		contentPane.add(inputCorreo);

		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		lblContrasena.setBounds(71, 408, 337, 22);
		contentPane.add(lblContrasena);

		inputContrasena = new JPasswordField();
		inputContrasena.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		inputContrasena.setBounds(71, 441, 356, 31);
		inputContrasena.setBorder(new LineBorder(Color.GRAY, 2, true));
		contentPane.add(inputContrasena);

		JLabel lblProfesional = new JLabel("¿Eres un chef profesional?");
		lblProfesional.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		lblProfesional.setBounds(71, 506, 276, 22);
		contentPane.add(lblProfesional);

		rdbtnChef = new JRadioButton("Chef");
		rdbtnChef.setBackground(new Color(255, 204, 102));
		rdbtnChef.setFont(new Font("Lucida Console", Font.BOLD, 13));
		rdbtnChef.setBounds(76, 539, 60, 23);
		contentPane.add(rdbtnChef);

		rdbtnAficionado = new JRadioButton("Aficionado");
		rdbtnAficionado.setBackground(new Color(255, 204, 51));
		rdbtnAficionado.setFont(new Font("Lucida Console", Font.BOLD, 13));
		rdbtnAficionado.setBounds(212, 539, 114, 23);
		contentPane.add(rdbtnAficionado);

		// Crear el grupo y agregar los botones
		groupRol = new ButtonGroup();
		groupRol.add(rdbtnChef);
		groupRol.add(rdbtnAficionado);

		JLabel lblDescripcion = new JLabel("Cuéntanos algo de ti...");
		lblDescripcion.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		lblDescripcion.setBounds(468, 144, 337, 22);
		contentPane.add(lblDescripcion);
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setForeground(new Color(255, 255, 255));
		btnRegistrarse.setBackground(new Color(205, 92, 92));
		btnRegistrarse.setFont(new Font("Lucida Console", Font.BOLD, 15));
		btnRegistrarse.setBounds(468, 506, 356, 44);
		contentPane.add(btnRegistrarse);

		JLabel lblErrorNombre = new JLabel("");
		lblErrorNombre.setForeground(Color.RED);
		lblErrorNombre.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		lblErrorNombre.setBounds(71, 208, 356, 14);
		contentPane.add(lblErrorNombre);

		JLabel lblErrorNombreUsuario = new JLabel("");
		lblErrorNombreUsuario.setForeground(Color.RED);
		lblErrorNombreUsuario.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		lblErrorNombreUsuario.setBounds(71, 295, 356, 14);
		contentPane.add(lblErrorNombreUsuario);

		JLabel lblErrorCorreo = new JLabel("");
		lblErrorCorreo.setForeground(Color.RED);
		lblErrorCorreo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		lblErrorCorreo.setBounds(71, 383, 356, 14);
		contentPane.add(lblErrorCorreo);

		JLabel lblErrorContrasena = new JLabel("");
		lblErrorContrasena.setForeground(Color.RED);
		lblErrorContrasena.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		lblErrorContrasena.setBounds(71, 470, 356, 37);
		contentPane.add(lblErrorContrasena);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		horizontalBox.setBounds(468, 184, 356, 288);
		contentPane.add(horizontalBox);

		JTextArea inputDescripcion = new JTextArea();
		inputDescripcion.setLineWrap(true);
		inputDescripcion.setWrapStyleWord(true);
		inputDescripcion.setRows(5);
		inputDescripcion.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		horizontalBox.add(inputDescripcion);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(51, 51, 0));
		panel_1.setBackground(new Color(128, 0, 0));
		panel_1.setBounds(478, 519, 356, 44);
		contentPane.add(panel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 153, 0), new Color(255, 255, 102), new Color(255, 255, 0), null));
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(49, 52, 813, 563);
		contentPane.add(panel);
		
				JLabel lblTitulo = new JLabel("Recipe Realm");
				panel.add(lblTitulo);
				lblTitulo.setFont(new Font("Lucida Console", Font.BOLD, 28));
				
				JPanel panel_2 = new JPanel();
				panel_2.setBorder(new LineBorder(new Color(204, 102, 51)));
				panel_2.setBackground(new Color(255, 204, 102));
				panel_2.setBounds(81, 85, 813, 564);
				contentPane.add(panel_2);

		btnRegistrarse.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				boolean verificado = false;
				if (rdbtnChef.isSelected()) {
					verificado = true;
				}
				if (rdbtnAficionado.isSelected()) {
					verificado = false;
				}
				String respuesta = Perfil.RegistrarPerfil(inputNombre.getText(), inputNombreUsuario.getText(),
						inputCorreo.getText(), inputContrasena.getText(), inputDescripcion.getText(), verificado);
				if (respuesta.equals("Perfil creado exitosamente")) {
					lblExito.setText(respuesta);
					lblExito.setVisible(true);
					PantallaInicioSesion iniciarSesion = new PantallaInicioSesion(perfil);
					iniciarSesion.setVisible(true);
					dispose();
				} else {
					if (respuesta.equals("¡Error! Todos los campos son obligatorios")) {
						lblErrorNombre.setText("El nombre no puede estar vacío");
						lblErrorNombre.setVisible(true);
					}
					if (respuesta.equals(
							"La contraseña no cumple con los requisitos: Debe contener al menos una mayúscula, una minúscula, un número y un caracter especial.")) {
						lblErrorContrasena.setText(respuesta);
						lblErrorContrasena.setVisible(true);
					}
					if (respuesta.equals("Se excede el límite de 100 caracteres.")) {
						lblErrorContrasena.setText(respuesta);
						lblErrorContrasena.setVisible(true);
					}

				}

				/*
				 * if (inputNombreUsuario.isEmpty()) {
				 * lblErrorNombre.setText("El nombre no puede estar vacío"); } else {
				 * lblErrorNombre.setText(""); }
				 * 
				 * if (pseudonimo.isEmpty()) {
				 * lblErrorNombreUsuario.setText("El nombre de usuario no puede estar vacío"); }
				 * else { lblErrorNombreUsuario.setText(""); }
				 * 
				 * if (correo.isEmpty() || !correo.contains("@")) {
				 * lblErrorCorreo.setText("Correo electrónico inválido"); } else {
				 * lblErrorCorreo.setText(""); }
				 * 
				 * if (contrasena.isEmpty()) {
				 * lblErrorContrasena.setText("La contraseña no puede estar vacía"); } else {
				 * lblErrorContrasena.setText(""); }
				 * 
				 * if (!lblErrorNombre.getText().isEmpty() ||
				 * !lblErrorNombreUsuario.getText().isEmpty() ||
				 * !lblErrorCorreo.getText().isEmpty() ||
				 * !lblErrorContrasena.getText().isEmpty()) {
				 * JOptionPane.showMessageDialog(null,
				 * "Por favor, revise los campos marcados en rojo", "Error",
				 * JOptionPane.ERROR_MESSAGE); } else { //guardar bdd }
				 */
			}
		});

	}
}
