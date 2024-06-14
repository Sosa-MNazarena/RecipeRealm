package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.border.LineBorder;

import Modelos.Cursos;

import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.event.ActionEvent;

public class PantallaSubirCurso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputTitulo;
	private JTextField inputLugar;
	private JTextField inputPrecio;
	private JTextField inputCupos;
	private JTextField inputFecha;
	private JTextField inputHorario;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaSubirCurso frame = new PantallaSubirCurso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PantallaSubirCurso() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 724);
		contentPane = new JPanel();
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
		lblTitulo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblTitulo.setBounds(109, 183, 108, 20);
		contentPane.add(lblTitulo);

		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblLugar.setBounds(109, 267, 108, 33);
		contentPane.add(lblLugar);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblPrecio.setBounds(489, 183, 108, 20);
		contentPane.add(lblPrecio);

		JLabel lblCupos = new JLabel("Cupos Disponibles");
		lblCupos.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblCupos.setBounds(489, 273, 129, 20);
		contentPane.add(lblCupos);

		JLabel lblDa = new JLabel("Día");
		lblDa.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblDa.setBounds(109, 379, 30, 20);
		contentPane.add(lblDa);

		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblHorario.setBounds(235, 379, 57, 20);
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
				String respuesta = Cursos.publicarCurso(inputTitulo.getText(), inputLugar.getText(),
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
		btnPublicar.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
		btnPublicar.setBackground(Color.BLACK);
		btnPublicar.setBounds(489, 379, 274, 37);
		contentPane.add(btnPublicar);

		JLabel lblNewLabel = new JLabel("Subí tu curso acá");
		lblNewLabel.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 23));
		lblNewLabel.setBounds(350, 109, 188, 35);
		contentPane.add(lblNewLabel);

	}
}
