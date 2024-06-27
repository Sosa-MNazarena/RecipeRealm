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
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import Controladores.PerfilControlador;
import Modelos.Cursos;
import Modelos.Perfil;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JTextFieldDateEditor;

import Controladores.PerfilControlador;
import Modelos.Cursos;
import Modelos.Perfil;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;

public class PantallaSubirCurso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputTitulo;
	private JTextField inputLugar;
	private JTextField inputPrecio;
	private JTextField inputCupos;
	private JDateChooser dateChooser; 
	private JLabel lblErrorTitulo;
	private JLabel lblErrorLugar;
	private JLabel lblErrorCupos;
	private Perfil perfil;
	private JLabel lblExito; 
	private PerfilControlador controlador = new PerfilControlador();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		this.perfil = perfil;
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 603);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaHomeChef homeChef = new PantallaHomeChef(perfil);
				homeChef.setVisible(true);
				dispose();
			}
		});
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("Lucida Console", Font.BOLD, 16));
		btnVolver.setBackground(new Color(255, 255, 153));
		btnVolver.setBounds(10, 68, 116, 30);
		contentPane.add(btnVolver);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		horizontalBox.setBounds(46, 159, 274, 35);
		contentPane.add(horizontalBox);

		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		horizontalBox_1.setBounds(46, 254, 274, 35);
		contentPane.add(horizontalBox_1);

		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		horizontalBox_2.setBounds(412, 159, 274, 35);
		contentPane.add(horizontalBox_2);

		Box horizontalBox_3 = Box.createHorizontalBox();
		horizontalBox_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		horizontalBox_3.setBounds(412, 254, 274, 35);
		contentPane.add(horizontalBox_3);
		
		// JCalendar
		dateChooser = new JDateChooser();
		dateChooser.setBounds(46, 349, 150, 37);
		contentPane.add(dateChooser);

		JLabel lblTitulo = new JLabel("Título");
		lblTitulo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblTitulo.setBounds(48, 139, 108, 20);
		contentPane.add(lblTitulo);

		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setForeground(Color.WHITE);
		lblLugar.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblLugar.setBounds(46, 234, 108, 20);
		contentPane.add(lblLugar);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblPrecio.setBounds(412, 142, 108, 20);
		contentPane.add(lblPrecio);

		JLabel lblCupos = new JLabel("Cupos Disponibles");
		lblCupos.setForeground(Color.WHITE);
		lblCupos.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblCupos.setBounds(412, 234, 179, 20);
		contentPane.add(lblCupos);

		JLabel lblDia = new JLabel("Día");
		lblDia.setForeground(Color.WHITE);
		lblDia.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblDia.setBounds(45, 333, 30, 20);
		contentPane.add(lblDia);

		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setForeground(Color.WHITE);
		lblHorario.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblHorario.setBounds(46, 407, 87, 20);
		contentPane.add(lblHorario);

		JLabel lblErrorGeneral = new JLabel("");
		lblErrorGeneral.setForeground(new Color(128, 0, 0));
		lblErrorGeneral.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		lblErrorGeneral.setBounds(412, 407, 274, 35);
		contentPane.add(lblErrorGeneral);
		
		lblExito = new JLabel("");
		lblExito.setForeground(Color.GREEN);
		lblExito.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		lblExito.setBounds(412, 413, 274, 38);
		contentPane.add(lblExito);
		
		Box horizontalBox1 = Box.createHorizontalBox();
		horizontalBox1.setBounds(109, 407, 87, 44);
		contentPane.add(horizontalBox1);
		
		JSpinner inputHora = new JSpinner();
		horizontalBox1.add(inputHora);
		inputHora.setModel(new SpinnerNumberModel(0, 0, 24, 1));
		
		JSpinner inputMinuto = new JSpinner();
		horizontalBox1.add(inputMinuto);
		inputMinuto.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		
		JButton btnPublicar = new JButton("Publicar");
		btnPublicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idUsuario = perfil.getIdUsuario();
				LocalDate fecha = null;
				if (dateChooser.getDate() != null) {
					fecha = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				}
				int hora = (int) inputHora.getValue();
		        int minuto = (int) inputMinuto.getValue();
		        LocalTime horaCurso = LocalTime.of(hora, minuto);
				String respuesta = Cursos.publicarCurso(inputTitulo.getText(), inputLugar.getText(),
						perfil.getIdUsuario(), fecha, Integer.parseInt(inputCupos.getText()),
						Double.parseDouble(inputPrecio.getText()), horaCurso);
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
		btnPublicar.setBounds(412, 349, 274, 37);
		contentPane.add(btnPublicar);

		JLabel lblSubeTuCurso = new JLabel("Sube tu curso aquí");
		lblSubeTuCurso.setBackground(new Color(153, 0, 0));
		lblSubeTuCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubeTuCurso.setForeground(Color.WHITE);
		lblSubeTuCurso.setFont(new Font("Lucida Console", Font.BOLD, 24));
		lblSubeTuCurso.setBounds(0, 62, 768, 44);
		lblSubeTuCurso.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/libroIconMini.png")));
		contentPane.add(lblSubeTuCurso);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1_1.setBorder(null);
		panel_1_1_1.setBackground(new Color(153, 0, 0));
		panel_1_1_1.setBounds(0, 62, 906, 44);
		contentPane.add(panel_1_1_1);
		
				inputTitulo = new JTextField();
				inputTitulo.setBounds(48, 161, 272, 33);
				contentPane.add(inputTitulo);
				inputTitulo.setColumns(10);
				
						inputPrecio = new JTextField();
						inputPrecio.setBounds(412, 159, 272, 33);
						contentPane.add(inputPrecio);
						inputPrecio.setColumns(10);
						
								inputLugar = new JTextField();
								inputLugar.setBounds(46, 254, 272, 33);
								contentPane.add(inputLugar);
								inputLugar.setColumns(10);
								
										inputCupos = new JTextField();
										inputCupos.setBounds(414, 254, 272, 33);
										contentPane.add(inputCupos);
										inputCupos.setColumns(10);
										
										JLabel lblHhmm = new JLabel("hh/mm");
										lblHhmm.setHorizontalAlignment(SwingConstants.CENTER);
										lblHhmm.setForeground(new Color(255, 153, 153));
										lblHhmm.setFont(new Font("Lucida Console", Font.PLAIN, 14));
										lblHhmm.setBounds(46, 427, 53, 20);
										contentPane.add(lblHhmm);
										
										JPanel panel_1 = new JPanel();
										panel_1.setForeground(new Color(51, 51, 0));
										panel_1.setBackground(new Color(128, 0, 0));
										panel_1.setBounds(422, 359, 271, 37);
										contentPane.add(panel_1);
										
										JPanel panel_1_1_2_1 = new JPanel();
										panel_1_1_2_1.setForeground(new Color(51, 51, 0));
										panel_1_1_2_1.setBackground(new Color(255, 204, 0));
										panel_1_1_2_1.setBounds(56, 170, 274, 35);
										contentPane.add(panel_1_1_2_1);
										
										JPanel panel_1_1_2_1_1 = new JPanel();
										panel_1_1_2_1_1.setForeground(new Color(51, 51, 0));
										panel_1_1_2_1_1.setBackground(new Color(255, 204, 0));
										panel_1_1_2_1_1.setBounds(422, 170, 274, 35);
										contentPane.add(panel_1_1_2_1_1);
										
										JPanel panel_1_1_2_1_2 = new JPanel();
										panel_1_1_2_1_2.setForeground(new Color(51, 51, 0));
										panel_1_1_2_1_2.setBackground(new Color(255, 204, 0));
										panel_1_1_2_1_2.setBounds(56, 265, 274, 35);
										contentPane.add(panel_1_1_2_1_2);
										
										JPanel panel_1_1_2_1_3 = new JPanel();
										panel_1_1_2_1_3.setForeground(new Color(51, 51, 0));
										panel_1_1_2_1_3.setBackground(new Color(255, 204, 0));
										panel_1_1_2_1_3.setBounds(422, 265, 274, 35);
										contentPane.add(panel_1_1_2_1_3);
		
		
		
		
		
		
	}
}
