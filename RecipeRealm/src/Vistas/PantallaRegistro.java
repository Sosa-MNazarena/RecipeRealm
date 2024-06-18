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
		setBounds(100, 100, 940, 772);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		lblNombre.setBounds(71, 201, 337, 22);
		contentPane.add(lblNombre);

		inputNombre = new JTextField();
		inputNombre.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		inputNombre.setBounds(71, 234, 356, 31);
		inputNombre.setBorder(new LineBorder(Color.GRAY, 2, true));
		contentPane.add(inputNombre);

		JLabel lblNombreUsuario = new JLabel("Nombre de usuario o pseudónimo");
		lblNombreUsuario.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		lblNombreUsuario.setBounds(71, 289, 337, 22);
		contentPane.add(lblNombreUsuario);

		inputNombreUsuario = new JTextField();
		inputNombreUsuario.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		inputNombreUsuario.setBounds(71, 322, 356, 31);
		inputNombreUsuario.setBorder(new LineBorder(Color.GRAY, 2, true));
		contentPane.add(inputNombreUsuario);

		JLabel lblCorreo = new JLabel("Correo Electrónico");
		lblCorreo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		lblCorreo.setBounds(71, 377, 337, 22);
		contentPane.add(lblCorreo);

		inputCorreo = new JTextField();
		inputCorreo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		inputCorreo.setBounds(71, 410, 356, 31);
		inputCorreo.setBorder(new LineBorder(Color.GRAY, 2, true));
		contentPane.add(inputCorreo);

		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		lblContrasena.setBounds(71, 465, 337, 22);
		contentPane.add(lblContrasena);

		inputContrasena = new JPasswordField();
		inputContrasena.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		inputContrasena.setBounds(71, 498, 356, 31);
		inputContrasena.setBorder(new LineBorder(Color.GRAY, 2, true));
		contentPane.add(inputContrasena);

		JLabel lblProfesional = new JLabel("¿Eres un chef profesional?");
		lblProfesional.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		lblProfesional.setBounds(71, 563, 276, 22);
		contentPane.add(lblProfesional);

		rdbtnChef = new JRadioButton("Chef");
		rdbtnChef.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 13));
		rdbtnChef.setBounds(76, 596, 109, 23);
		contentPane.add(rdbtnChef);

		rdbtnAficionado = new JRadioButton("Aficionado");
		rdbtnAficionado.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 13));
		rdbtnAficionado.setBounds(212, 596, 109, 23);
		contentPane.add(rdbtnAficionado);

		// Crear el grupo y agregar los botones
		groupRol = new ButtonGroup();
		groupRol.add(rdbtnChef);
		groupRol.add(rdbtnAficionado);

		JLabel lblTitulo = new JLabel("Recipe Realm");
		lblTitulo.setFont(new Font("Leelawadee UI", Font.PLAIN, 28));
		lblTitulo.setBounds(356, 119, 176, 44);
		contentPane.add(lblTitulo);

		JLabel lblDescripcion = new JLabel("Cuéntanos algo de ti...");
		lblDescripcion.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		lblDescripcion.setBounds(489, 201, 337, 22);
		contentPane.add(lblDescripcion);
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setForeground(new Color(255, 255, 255));
		btnRegistrarse.setBackground(new Color(0, 0, 0));
		btnRegistrarse.setFont(new Font("Leelawadee UI", Font.PLAIN, 15));
		btnRegistrarse.setBounds(489, 563, 356, 44);
		contentPane.add(btnRegistrarse);

		JLabel lblErrorNombre = new JLabel("");
		lblErrorNombre.setForeground(Color.RED);
		lblErrorNombre.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		lblErrorNombre.setBounds(71, 268, 356, 14);
		contentPane.add(lblErrorNombre);

		JLabel lblErrorNombreUsuario = new JLabel("");
		lblErrorNombreUsuario.setForeground(Color.RED);
		lblErrorNombreUsuario.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		lblErrorNombreUsuario.setBounds(71, 353, 356, 14);
		contentPane.add(lblErrorNombreUsuario);

		JLabel lblErrorCorreo = new JLabel("");
		lblErrorCorreo.setForeground(Color.RED);
		lblErrorCorreo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		lblErrorCorreo.setBounds(71, 441, 356, 14);
		contentPane.add(lblErrorCorreo);

		JLabel lblErrorContrasena = new JLabel("");
		lblErrorContrasena.setForeground(Color.RED);
		lblErrorContrasena.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		lblErrorContrasena.setBounds(71, 530, 356, 14);
		contentPane.add(lblErrorContrasena);

		JLabel lblExito = new JLabel("");
		lblExito.setForeground(new Color(0, 128, 0));
		lblExito.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		lblExito.setBounds(489, 621, 356, 22);
		contentPane.add(lblExito);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		horizontalBox.setBounds(489, 241, 356, 288);
		contentPane.add(horizontalBox);

		JTextArea inputDescripcion = new JTextArea();
		inputDescripcion.setLineWrap(true);
		inputDescripcion.setWrapStyleWord(true);
		inputDescripcion.setRows(5);
		inputDescripcion.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		horizontalBox.add(inputDescripcion);

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
