package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import Controladores.CursoControlador;
import Controladores.PerfilControlador;
import Modelos.Cursos;
import Modelos.Perfil;

import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PantallaSubirCurso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputTitulo;
	private JTextField inputLugar;
	private JTextField inputPrecio;
	private JTextField inputCupos;
	private JTextField inputFecha;
	private JTextField inputHorario;
	private Perfil perfil;
	private PerfilControlador controlador = new PerfilControlador();

	 public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    Cursos curso = new Cursos(1, "", 1, "", LocalDate.now(), 20, 100.0,
					LocalTime.now());

	                    Perfil perfil = new Perfil(1, "Nombre", "Pseudónimo", "correo@example.com", "contraseña",
	                            "Descripción", true);
	                    PantallaSubirCurso frame = new PantallaSubirCurso(perfil);
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	public PantallaSubirCurso(Perfil perfil) {
		
		this.perfil=perfil;
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 552);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		horizontalBox.setBounds(109, 214, 274, 35);
		contentPane.add(horizontalBox);

		inputTitulo = new JTextField();
		horizontalBox.add(inputTitulo);
		inputTitulo.setColumns(10);

		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		horizontalBox_1.setBounds(109, 304, 274, 35);
		contentPane.add(horizontalBox_1);

		inputLugar = new JTextField();
		horizontalBox_1.add(inputLugar);
		inputLugar.setColumns(10);

		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		horizontalBox_2.setBounds(489, 214, 274, 35);
		contentPane.add(horizontalBox_2);

		inputPrecio = new JTextField();
		horizontalBox_2.add(inputPrecio);
		inputPrecio.setColumns(10);

		Box horizontalBox_3 = Box.createHorizontalBox();
		horizontalBox_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		horizontalBox_3.setBounds(489, 304, 274, 35);
		contentPane.add(horizontalBox_3);

		inputCupos = new JTextField();
		horizontalBox_3.add(inputCupos);
		inputCupos.setColumns(10);

		Box horizontalBox_1_1 = Box.createHorizontalBox();
		horizontalBox_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		horizontalBox_1_1.setBounds(138, 379, 87, 35);
		contentPane.add(horizontalBox_1_1);

		inputFecha = new JTextField();
		horizontalBox_1_1.add(inputFecha);
		inputFecha.setColumns(10);

		Box horizontalBox_1_1_1 = Box.createHorizontalBox();
		horizontalBox_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		horizontalBox_1_1_1.setBounds(296, 379, 87, 35);
		contentPane.add(horizontalBox_1_1_1);

		inputHorario = new JTextField();
		horizontalBox_1_1_1.add(inputHorario);
		inputHorario.setColumns(10);

		JLabel lblTitulo = new JLabel("Título");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblTitulo.setBounds(109, 197, 108, 20);
		contentPane.add(lblTitulo);

		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setForeground(Color.WHITE);
		lblLugar.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblLugar.setBounds(109, 285, 108, 20);
		contentPane.add(lblLugar);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblPrecio.setBounds(489, 197, 108, 20);
		contentPane.add(lblPrecio);

		JLabel lblCupos = new JLabel("Cupos Disponibles");
		lblCupos.setForeground(Color.WHITE);
		lblCupos.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblCupos.setBounds(488, 285, 179, 20);
		contentPane.add(lblCupos);

		JLabel lblDa = new JLabel("Día");
		lblDa.setForeground(Color.WHITE);
		lblDa.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblDa.setBounds(109, 379, 30, 20);
		contentPane.add(lblDa);

		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setForeground(Color.WHITE);
		lblHorario.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblHorario.setBounds(235, 379, 87, 20);
		contentPane.add(lblHorario);

		JLabel lblErrorTitulo = new JLabel("");
		lblErrorTitulo.setForeground(Color.RED);
		lblErrorTitulo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		lblErrorTitulo.setBounds(109, 260, 163, 14);
		contentPane.add(lblErrorTitulo);

		JLabel lblErrorLugar = new JLabel("");
		lblErrorLugar.setForeground(Color.RED);
		lblErrorLugar.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		lblErrorLugar.setBounds(109, 350, 163, 14);
		contentPane.add(lblErrorLugar);

		JLabel lblErrorPrecio = new JLabel("");
		lblErrorPrecio.setForeground(Color.RED);
		lblErrorPrecio.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		lblErrorPrecio.setBounds(489, 260, 163, 14);
		contentPane.add(lblErrorPrecio);

		JLabel lblErrorCupos = new JLabel("");
		lblErrorCupos.setForeground(Color.RED);
		lblErrorCupos.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		lblErrorCupos.setBounds(489, 350, 163, 14);
		contentPane.add(lblErrorCupos);

		JLabel lblExito = new JLabel("");
		lblExito.setForeground(new Color(0, 128, 0));
		lblExito.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		lblExito.setBounds(489, 427, 274, 14);
		contentPane.add(lblExito);

		JLabel lblErrorGeneral = new JLabel("");
		lblErrorGeneral.setForeground(new Color(128, 0, 0));
		lblErrorGeneral.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		lblErrorGeneral.setBounds(489, 427, 274, 14);
		contentPane.add(lblErrorGeneral);

		JLabel lblErrorFecha = new JLabel("");
		lblErrorFecha.setForeground(Color.RED);
		lblErrorFecha.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		lblErrorFecha.setBounds(109, 425, 163, 14);
		contentPane.add(lblErrorFecha);

		JButton btnPublicar = new JButton("Publicar");
		btnPublicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idUsuario = perfil.getIdUsuario();
				String respuesta = Cursos.publicarCurso(inputTitulo.getText(), inputLugar.getText(),perfil.getIdUsuario(),
						LocalDate.parse(inputFecha.getText()), Integer.parseInt(inputCupos.getText()),
						Double.parseDouble(inputPrecio.getText()), LocalTime.parse(inputHorario.getText()));
				if (respuesta.equals("El curso se ha subido exitosamente.")) {
					lblExito.setText(respuesta);
					lblExito.setVisible(true);
				} else if (respuesta.equals("El curso no se ha podido subir")) {
					lblErrorGeneral.setText(respuesta);
					lblErrorGeneral.setVisible(true);
				} else {
					if (respuesta.equals("Título inválido, más de 3 caracteres.")) {
						lblErrorTitulo.setText(respuesta);
						lblErrorTitulo.setVisible(true);
					} else if (respuesta.equals("Lugar inválido, más de 3 caracteres.")) {
						lblErrorLugar.setText(respuesta);
						lblErrorLugar.setVisible(true);
					} else if (respuesta.equals("Fecha inválida.")) {
						lblErrorFecha.setText(respuesta);
						lblErrorFecha.setVisible(true);
					} else if (respuesta.equals("Cupos inválidos, debe ser una cantidad mayor a 10")) {
						lblErrorCupos.setText(respuesta);
						lblErrorCupos.setVisible(true);
					}
				}
			}
		});
		btnPublicar.setForeground(Color.WHITE);
		btnPublicar.setFont(new Font("Lucida Console", Font.BOLD, 15));
		btnPublicar.setBackground(new Color(255, 153, 153));
		btnPublicar.setBounds(489, 379, 274, 37);
		contentPane.add(btnPublicar);
		
		JLabel lblSubTuCurso = new JLabel("Subí tu curso acá");
		lblSubTuCurso.setBackground(new Color(153, 0, 0));
		lblSubTuCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubTuCurso.setForeground(Color.WHITE);
		lblSubTuCurso.setFont(new Font("Lucida Console", Font.BOLD, 24));
		lblSubTuCurso.setBounds(0, 94, 901, 44);
		contentPane.add(lblSubTuCurso);
		lblSubTuCurso.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/libroIconMini.png")));
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1_1.setBorder(null);
		panel_1_1_1.setBackground(new Color(153, 0, 0));
		panel_1_1_1.setBounds(0, 94, 901, 44);
		contentPane.add(panel_1_1_1);
		
		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setForeground(new Color(51, 51, 0));
		panel_1_1_2.setBackground(new Color(255, 204, 0));
		panel_1_1_2.setBounds(489, 219, 270, 30);
		contentPane.add(panel_1_1_2);
		
		JPanel panel_1_1_3 = new JPanel();
		panel_1_1_3.setForeground(new Color(51, 51, 0));
		panel_1_1_3.setBackground(new Color(255, 204, 0));
		panel_1_1_3.setBounds(499, 228, 270, 30);
		contentPane.add(panel_1_1_3);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1.setBackground(new Color(255, 204, 0));
		panel_1_1.setBounds(119, 316, 270, 30);
		contentPane.add(panel_1_1);
		
		JPanel panel_1_1_4 = new JPanel();
		panel_1_1_4.setForeground(new Color(51, 51, 0));
		panel_1_1_4.setBackground(new Color(255, 204, 0));
		panel_1_1_4.setBounds(499, 316, 270, 30);
		contentPane.add(panel_1_1_4);
		
		JPanel panel_1_1_5 = new JPanel();
		panel_1_1_5.setForeground(new Color(51, 51, 0));
		panel_1_1_5.setBackground(new Color(255, 204, 0));
		panel_1_1_5.setBounds(119, 228, 270, 30);
		contentPane.add(panel_1_1_5);
		
		JPanel panel_1_1_6 = new JPanel();
		panel_1_1_6.setForeground(new Color(51, 51, 0));
		panel_1_1_6.setBackground(new Color(255, 204, 0));
		panel_1_1_6.setBounds(306, 392, 85, 30);
		contentPane.add(panel_1_1_6);
		
		JPanel panel_1_1_6_1 = new JPanel();
		panel_1_1_6_1.setForeground(new Color(51, 51, 0));
		panel_1_1_6_1.setBackground(new Color(255, 204, 0));
		panel_1_1_6_1.setBounds(148, 392, 85, 30);
		contentPane.add(panel_1_1_6_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(51, 51, 0));
		panel_1.setBackground(new Color(128, 0, 0));
		panel_1.setBounds(499, 385, 274, 37);
		contentPane.add(panel_1);

	}
}
