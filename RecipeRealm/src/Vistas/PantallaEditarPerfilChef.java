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
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Nmbrecito
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
		
		//pseudonimo o nombreUsuario.. ¿por que esta de dos formas?
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
		
		//correo
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
		
		//contra
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
		
		//descrip
		JLabel lblDescripcion = new JLabel("Cuéntanos algo de ti...");
		lblDescripcion.setForeground(Color.WHITE);
        lblDescripcion.setFont(new Font("Lucida Console", Font.PLAIN, 14));
        lblDescripcion.setBounds(30, 293, 356, 31);
        contentPane.add(lblDescripcion);

        inputDescripcion = new JTextArea(perfil.getDescripcion());
        inputDescripcion.setBackground(new Color(255, 255, 204));
        inputDescripcion.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
        inputDescripcion.setBounds(30, 316, 356, 77);
        inputDescripcion.setBorder(new LineBorder(Color.GRAY, 2, true));
        inputDescripcion.setLineWrap(true);
        inputDescripcion.setWrapStyleWord(true);
        contentPane.add(inputDescripcion);
		
		
		//botones
		JButton btnGuardar = new JButton("Guardar cambios");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
		btnGuardar.setBackground(new Color(255, 153, 153));
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
		btnCancelar.setBackground(new Color(255, 255, 204));
		btnCancelar.setBounds(210, 459, 176, 37);
		contentPane.add(btnCancelar);
		
		JLabel lblSubTuCurso = new JLabel("Editar perfil");
		lblSubTuCurso.setBounds(89, 11, 247, 30);
		contentPane.add(lblSubTuCurso);
		lblSubTuCurso.setBackground(new Color(153, 0, 0));
		lblSubTuCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubTuCurso.setForeground(Color.WHITE);
		lblSubTuCurso.setFont(new Font("Lucida Console", Font.BOLD, 20));
		lblSubTuCurso.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/usuarioIconMini.png")));
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1_1.setBorder(null);
		panel_1_1_1.setBackground(new Color(153, 0, 0));
		panel_1_1_1.setBounds(0, 11, 436, 31);
		contentPane.add(panel_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(51, 51, 0));
		panel_1.setBackground(new Color(128, 0, 0));
		panel_1.setBounds(40, 422, 352, 32);
		contentPane.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1.setBackground(new Color(255, 204, 0));
		panel_1_1.setBounds(220, 465, 172, 37);
		contentPane.add(panel_1_1);
		
		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setForeground(new Color(51, 51, 0));
		panel_1_1_2.setBackground(new Color(255, 204, 0));
		panel_1_1_2.setBounds(38, 256, 352, 30);
		contentPane.add(panel_1_1_2);
		
		JPanel panel_1_1_2_1 = new JPanel();
		panel_1_1_2_1.setForeground(new Color(51, 51, 0));
		panel_1_1_2_1.setBackground(new Color(255, 204, 0));
		panel_1_1_2_1.setBounds(38, 196, 352, 30);
		contentPane.add(panel_1_1_2_1);
		
		JPanel panel_1_1_2_2 = new JPanel();
		panel_1_1_2_2.setForeground(new Color(51, 51, 0));
		panel_1_1_2_2.setBackground(new Color(255, 204, 0));
		panel_1_1_2_2.setBounds(38, 134, 352, 30);
		contentPane.add(panel_1_1_2_2);
		
		JPanel panel_1_1_2_3 = new JPanel();
		panel_1_1_2_3.setForeground(new Color(51, 51, 0));
		panel_1_1_2_3.setBackground(new Color(255, 204, 0));
		panel_1_1_2_3.setBounds(38, 72, 352, 30);
		contentPane.add(panel_1_1_2_3);
		
		btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }
}
