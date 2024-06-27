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

	private JTextField inputNombre;
	private JTextField inputPseudonimo;
	private JTextField inputCorreo;
	private JPasswordField inputContrasena;
	private JTextArea inputDescripcion;
	private Perfil perfil;
	private PerfilControlador controlador = new PerfilControlador();

	/**
	 * Create the frame.
	 */
	public PantallaEditarPerfilChef(Perfil perfil) {
		this.perfil = perfil;
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 555);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Nombre
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblNombre.setBounds(30, 45, 337, 22);
		contentPane.add(lblNombre);

		inputNombre = new JTextField(perfil.getNombre());
		inputNombre.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		inputNombre.setBounds(30, 66, 356, 31);
		inputNombre.setBorder(new LineBorder(Color.GRAY, 2, true));
		contentPane.add(inputNombre);

		JLabel lblErrorNombre = new JLabel("");
		lblErrorNombre.setForeground(Color.RED);
		lblErrorNombre.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		lblErrorNombre.setBounds(30, 97, 356, 14);
		contentPane.add(lblErrorNombre);

		// Pseudónimo
		JLabel lblPseudonimo = new JLabel("Nombre de usuario o pseudónimo");
		lblPseudonimo.setForeground(Color.WHITE);
		lblPseudonimo.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblPseudonimo.setBounds(30, 108, 337, 22);
		contentPane.add(lblPseudonimo);

		inputPseudonimo = new JTextField(perfil.getPseudonimo());
		inputPseudonimo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		inputPseudonimo.setBounds(30, 128, 356, 31);
		inputPseudonimo.setBorder(new LineBorder(Color.GRAY, 2, true));
		contentPane.add(inputPseudonimo);

		JLabel lblErrorPseudonimo = new JLabel("");
		lblErrorPseudonimo.setForeground(Color.RED);
		lblErrorPseudonimo.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		lblErrorPseudonimo.setBounds(30, 159, 356, 14);
		contentPane.add(lblErrorPseudonimo);

		// Correo
		JLabel lblCorreo = new JLabel("Correo Electrónico");
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblCorreo.setBounds(30, 170, 337, 22);
		contentPane.add(lblCorreo);

		inputCorreo = new JTextField(perfil.getCorreo());
		inputCorreo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		inputCorreo.setBounds(30, 189, 356, 31);
		inputCorreo.setBorder(new LineBorder(Color.GRAY, 2, true));
		contentPane.add(inputCorreo);

		JLabel lblErrorCorreo = new JLabel("");
		lblErrorCorreo.setForeground(Color.RED);
		lblErrorCorreo.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		lblErrorCorreo.setBounds(30, 220, 356, 14);
		contentPane.add(lblErrorCorreo);

		// Contraseña
		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setForeground(Color.WHITE);
		lblContrasena.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblContrasena.setBounds(30, 231, 337, 22);
		contentPane.add(lblContrasena);

		inputContrasena = new JPasswordField(perfil.getContrasena());
		inputContrasena.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		inputContrasena.setBounds(30, 251, 356, 31);
		inputContrasena.setBorder(new LineBorder(Color.GRAY, 2, true));
		contentPane.add(inputContrasena);

		JLabel lblErrorContrasena = new JLabel("");
		lblErrorContrasena.setForeground(Color.RED);
		lblErrorContrasena.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		lblErrorContrasena.setBounds(30, 282, 356, 14);
		contentPane.add(lblErrorContrasena);

		// Descripción
		JLabel lblDescripcion = new JLabel("Cuéntanos algo de ti...");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblDescripcion.setBounds(30, 293, 356, 22);
		contentPane.add(lblDescripcion);

		inputDescripcion = new JTextArea(perfil.getDescripcion());
		inputDescripcion.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		inputDescripcion.setBackground(new Color(255, 255, 204));
		inputDescripcion.setBounds(30, 316, 356, 77);
		inputDescripcion.setBorder(new LineBorder(Color.GRAY, 2, true));
		inputDescripcion.setLineWrap(true);
		inputDescripcion.setWrapStyleWord(true);
		contentPane.add(inputDescripcion);

		JLabel lblErrorDescripcion = new JLabel("");
		lblErrorDescripcion.setForeground(Color.RED);
		lblErrorDescripcion.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		lblErrorDescripcion.setBounds(30, 395, 356, 14);
		contentPane.add(lblErrorDescripcion);

		// Botones
		JButton btnGuardar = new JButton("Guardar cambios");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
		btnGuardar.setBackground(new Color(255, 153, 153));
		btnGuardar.setBounds(30, 431, 356, 37);
		contentPane.add(btnGuardar);

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Validaciones
				boolean valid = true;

				String nombre = inputNombre.getText().trim();
				if (nombre.isEmpty()) {
					lblErrorNombre.setText("Debe ingresar un nombre");
					valid = false;
				} else {
					lblErrorNombre.setText("");
				}

				String pseudonimo = inputPseudonimo.getText().trim();
				if (pseudonimo.isEmpty()) {
					lblErrorPseudonimo.setText("Debe ingresar un pseudónimo");
					valid = false;
				} else {
					lblErrorPseudonimo.setText("");
				}

				String correo = inputCorreo.getText().trim();
				if (correo.isEmpty()) {
					lblErrorCorreo.setText("Debe ingresar un correo electrónico");
					valid = false;
				} else {
					lblErrorCorreo.setText("");
				}

				String contrasena = new String(inputContrasena.getPassword());
				if (contrasena.isEmpty()) {
					lblErrorContrasena.setText("Debe ingresar una contraseña");
					valid = false;
				} else {
					lblErrorContrasena.setText("");
				}

				String descripcion = inputDescripcion.getText().trim();
				if (descripcion.isEmpty()) {
					lblErrorDescripcion.setText("Debe ingresar una descripción");
					valid = false;
				} else {
					lblErrorDescripcion.setText("");
				}

				// Mostrar mensaje de error general si hay campos vacíos
				if (!valid) {
					JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos.");
					return;
				}

				// Verificar cambios
				boolean cambios = !nombre.equals(perfil.getNombre()) || !pseudonimo.equals(perfil.getPseudonimo())
						|| !correo.equals(perfil.getCorreo()) || !contrasena.equals(perfil.getContrasena())
						|| !descripcion.equals(perfil.getDescripcion());

				if (!cambios) {
					JOptionPane.showMessageDialog(null, "No se han realizado cambios.");
					return;
				}

				// Guardar perfil si es válido y se realizaron cambios
				if (valid && cambios) {
					perfil.setNombre(nombre);
					perfil.setPseudonimo(pseudonimo);
					perfil.setCorreo(correo);
					perfil.setContrasena(contrasena);
					perfil.setDescripcion(descripcion);

					if (controlador.updatePerfil(perfil)) {
						JOptionPane.showMessageDialog(null, "Perfil actualizado correctamente");
						PantallaHomeChef homeChef = new PantallaHomeChef(perfil);
						homeChef.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Error al actualizar el perfil");
					}
				}
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
		btnCancelar.setBackground(new Color(255, 255, 204));
		btnCancelar.setBounds(210, 479, 176, 37);
		contentPane.add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		// Título
		JLabel lblTitulo = new JLabel("Editar perfil");
		lblTitulo.setBounds(89, 11, 247, 30);
		contentPane.add(lblTitulo);
		lblTitulo.setBackground(new Color(153, 0, 0));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Lucida Console", Font.BOLD, 24));
	}
}
