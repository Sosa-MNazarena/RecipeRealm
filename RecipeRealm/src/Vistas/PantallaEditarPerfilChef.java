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
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public PantallaEditarPerfilChef(Perfil perfil) {
		this.perfil = perfil;
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 555);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Nmbrecito
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		lblNombre.setBounds(30, 45, 337, 22);
		contentPane.add(lblNombre);

		inputNombre = new JTextField(perfil.getNombre());
		inputNombre.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		inputNombre.setBounds(30, 66, 356, 31);
		inputNombre.setBorder(new LineBorder(Color.GRAY, 2, true));
		contentPane.add(inputNombre);
		
		//pseudonimo o nombreUsuario.. ¿por que esta de dos formas?
		JLabel lblPseudonimo = new JLabel("Nombre de usuario o pseudónimo");
		lblPseudonimo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		lblPseudonimo.setBounds(30, 108, 337, 22);
		contentPane.add(lblPseudonimo);

		inputPseudonimo = new JTextField(perfil.getPseudonimo());
		inputPseudonimo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		inputPseudonimo.setBounds(30, 128, 356, 31);
		inputPseudonimo.setBorder(new LineBorder(Color.GRAY, 2, true));
		contentPane.add(inputPseudonimo);
		
		JLabel lblEditarPerfil = new JLabel("Editar perfil");
		lblEditarPerfil.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 23));
		lblEditarPerfil.setBounds(156, 11, 150, 35);
		contentPane.add(lblEditarPerfil);
		
		//correo
		JLabel lblCorreo = new JLabel("Correo Electrónico");
		lblCorreo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		lblCorreo.setBounds(30, 170, 337, 22);
		contentPane.add(lblCorreo);

		inputCorreo = new JTextField(perfil.getCorreo());
		inputCorreo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		inputCorreo.setBounds(30, 189, 356, 31);
		inputCorreo.setBorder(new LineBorder(Color.GRAY, 2, true));
		contentPane.add(inputCorreo);
		
		//contra
		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		lblContrasena.setBounds(30, 231, 337, 22);
		contentPane.add(lblContrasena);

		inputContrasena = new JPasswordField(perfil.getContrasena());
		inputContrasena.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		inputContrasena.setBounds(30, 251, 356, 31);
		inputContrasena.setBorder(new LineBorder(Color.GRAY, 2, true));
		contentPane.add(inputContrasena);
		
		//descrip
		JLabel lblDescripcion = new JLabel("Cuéntanos algo de ti...");
        lblDescripcion.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
        lblDescripcion.setBounds(30, 293, 356, 31);
        contentPane.add(lblDescripcion);

        inputDescripcion = new JTextArea(perfil.getDescripcion());
        inputDescripcion.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
        inputDescripcion.setBounds(30, 323, 356, 70);
        inputDescripcion.setBorder(new LineBorder(Color.GRAY, 2, true));
        inputDescripcion.setLineWrap(true);
        inputDescripcion.setWrapStyleWord(true);
        contentPane.add(inputDescripcion);
		
		
		//botones
		JButton btnGuardar = new JButton("Guardar cambios");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
		btnGuardar.setBackground(Color.BLACK);
		btnGuardar.setBounds(30, 411, 356, 37);
		contentPane.add(btnGuardar);
		
		btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                perfil.setNombre(inputNombre.getText());
                perfil.setPseudonimo(inputPseudonimo.getText());
                perfil.setCorreo(inputCorreo.getText());
                perfil.setContrasena(new String(inputContrasena.getPassword()));
                perfil.setDescripcion(inputDescripcion.getText());

                if (controlador.updatePerfil(perfil)) {
                    JOptionPane.showMessageDialog(null, "Perfil actualizado correctamente");
                    PantallaHomeChef homeChef = new PantallaHomeChef(perfil);
                    homeChef.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el perfil");
                }
            }
        });
        

		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
		btnCancelar.setBackground(Color.BLACK);
		btnCancelar.setBounds(210, 459, 176, 37);
		contentPane.add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }
}
