package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.JSlider;
import java.awt.Choice;
import javax.swing.JSpinner;
import javax.swing.JLabel;

public class PantallaSubirCurso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputTitulo;
	private JTextField inputLugar;
	private JTextField inputPrecio;
	private JTextField inputCupos;

	
	public PantallaSubirCurso() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1033, 807);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIniciarSesion = new JButton("Publicar ");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIniciarSesion.setForeground(Color.WHITE);
		btnIniciarSesion.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
		btnIniciarSesion.setBackground(Color.BLACK);
		btnIniciarSesion.setBounds(544, 447, 356, 37);
		contentPane.add(btnIniciarSesion);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		horizontalBox.setBounds(125, 264, 352, 37);
		contentPane.add(horizontalBox);
		
		inputTitulo = new JTextField();
		horizontalBox.add(inputTitulo);
		inputTitulo.setColumns(10);
		
		Box horizontalBox_1_1 = Box.createHorizontalBox();
		horizontalBox_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		horizontalBox_1_1.setBounds(125, 357, 352, 37);
		contentPane.add(horizontalBox_1_1);
		
		inputLugar = new JTextField();
		horizontalBox_1_1.add(inputLugar);
		inputLugar.setColumns(10);
		
		Box horizontalBox_1_1_1 = Box.createHorizontalBox();
		horizontalBox_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		horizontalBox_1_1_1.setBounds(544, 357, 352, 37);
		contentPane.add(horizontalBox_1_1_1);
		
		inputCupos = new JTextField();
		horizontalBox_1_1_1.add(inputCupos);
		inputCupos.setColumns(10);
		
		Box horizontalBox_1_1_1_1 = Box.createHorizontalBox();
		horizontalBox_1_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		horizontalBox_1_1_1_1.setBounds(544, 264, 352, 37);
		contentPane.add(horizontalBox_1_1_1_1);
		
		inputPrecio = new JTextField();
		horizontalBox_1_1_1_1.add(inputPrecio);
		inputPrecio.setColumns(10);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		horizontalBox_1.setBounds(166, 447, 104, 33);
		contentPane.add(horizontalBox_1);
		
		JSpinner inputHora = new JSpinner();
		horizontalBox_1.add(inputHora);
		
		JSpinner input = new JSpinner();
		horizontalBox_1.add(input);
		
		JLabel lblTitulo = new JLabel("Título");
		lblTitulo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		lblTitulo.setBounds(125, 237, 123, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		lblLugar.setBounds(125, 325, 123, 21);
		contentPane.add(lblLugar);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		lblPrecio.setBounds(544, 232, 123, 21);
		contentPane.add(lblPrecio);
		
		JLabel lblCuposDisponibles = new JLabel("Cupos Disponibles");
		lblCuposDisponibles.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		lblCuposDisponibles.setBounds(544, 325, 123, 21);
		contentPane.add(lblCuposDisponibles);
		
		JLabel lblDa = new JLabel("Día");
		lblDa.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		lblDa.setBounds(125, 455, 42, 21);
		contentPane.add(lblDa);
		
		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		lblHorario.setBounds(297, 455, 62, 21);
		contentPane.add(lblHorario);
		
		Box horizontalBox_1_2 = Box.createHorizontalBox();
		horizontalBox_1_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		horizontalBox_1_2.setBounds(366, 447, 111, 33);
		contentPane.add(horizontalBox_1_2);
		
		JSpinner spinner_3 = new JSpinner();
		horizontalBox_1_2.add(spinner_3);
		
		JSpinner spinner_1 = new JSpinner();
		horizontalBox_1_2.add(spinner_1);
		
		JLabel lblNewLabel_1 = new JLabel("Subí tu curso acá");
		lblNewLabel_1.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(413, 150, 205, 37);
		contentPane.add(lblNewLabel_1);
	}
}
