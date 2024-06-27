package Vistas;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.awt.event.ActionEvent;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

import Controladores.CursoControlador;
import Modelos.Perfil;
import Modelos.Cursos;

public class PantallaEditarCurso extends JFrame {

	private JPanel contentPane;
	private Cursos curso;
	private Perfil perfil;
	private CursoControlador controlador;
	private JTextField txtTitulo;
	private JTextField txtLugar;
	private JTextField txtPrecio;
	private JTextField txtCupos;
	private JDateChooser dateChooser;
	private JLabel lblErrorGeneral;
	private JLabel lblErrorTitulo;
	private JLabel lblErrorLugar;
	private JLabel lblErrorPrecio;
	private JSpinner inputHora;
	private JSpinner inputMinuto;
	private JLabel lblErrorCupos;

	public PantallaEditarCurso(Cursos curso, Perfil perfil) {
		this.curso = curso;
		this.perfil = perfil;
		this.controlador = new CursoControlador();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEditarCursos = new JLabel("Editar Cursos");
		lblEditarCursos.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarCursos.setForeground(Color.WHITE);
		lblEditarCursos.setFont(new Font("Lucida Console", Font.BOLD, 26));
		lblEditarCursos.setBounds(0, 20, 786, 44);
		lblEditarCursos.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/libroIconMini.png")));
		contentPane.add(lblEditarCursos);

		JLabel lblTitulo = new JLabel("Título:");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblTitulo.setBounds(104, 77, 100, 20);
		contentPane.add(lblTitulo);

		txtTitulo = new JTextField(curso.getTitulo());
		txtTitulo.setBounds(214, 75, 460, 30);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);

		lblErrorTitulo = new JLabel("");
		lblErrorTitulo.setForeground(Color.RED);
		lblErrorTitulo.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblErrorTitulo.setBounds(224, 115, 460, 20);
		contentPane.add(lblErrorTitulo);

		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setForeground(Color.WHITE);
		lblLugar.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblLugar.setBounds(104, 148, 100, 20);
		contentPane.add(lblLugar);

		txtLugar = new JTextField(curso.getLugar());
		txtLugar.setBounds(214, 146, 460, 30);
		contentPane.add(txtLugar);
		txtLugar.setColumns(10);

		lblErrorLugar = new JLabel("");
		lblErrorLugar.setForeground(Color.RED);
		lblErrorLugar.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblErrorLugar.setBounds(214, 182, 460, 20);
		contentPane.add(lblErrorLugar);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblPrecio.setBounds(104, 209, 100, 20);
		contentPane.add(lblPrecio);

		txtPrecio = new JTextField(String.valueOf(curso.getPrecio()));
		txtPrecio.setBounds(214, 207, 460, 30);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		lblErrorPrecio = new JLabel("");
		lblErrorPrecio.setForeground(Color.RED);
		lblErrorPrecio.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblErrorPrecio.setBounds(214, 248, 460, 20);
		contentPane.add(lblErrorPrecio);

		JLabel lblCupos = new JLabel("Cupos Disponibles:");
		lblCupos.setForeground(Color.WHITE);
		lblCupos.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblCupos.setBounds(104, 281, 150, 20);
		contentPane.add(lblCupos);

		txtCupos = new JTextField(String.valueOf(curso.getCupo()));
		txtCupos.setBounds(264, 279, 410, 30);
		contentPane.add(txtCupos);
		txtCupos.setColumns(10);

		lblErrorCupos = new JLabel("");
		lblErrorCupos.setForeground(Color.RED);
		lblErrorCupos.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblErrorCupos.setBounds(264, 323, 410, 20);
		contentPane.add(lblErrorCupos);

		JLabel lblDia = new JLabel("Día:");
		lblDia.setForeground(Color.WHITE);
		lblDia.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblDia.setBounds(104, 343, 100, 20);
		contentPane.add(lblDia);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(214, 344, 150, 37);
		dateChooser.setDate(Date.from(curso.getDia().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		contentPane.add(dateChooser);

		lblErrorGeneral = new JLabel("");
		lblErrorGeneral.setForeground(Color.RED);
		lblErrorGeneral.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblErrorGeneral.setBounds(84, 491, 385, 20);
		contentPane.add(lblErrorGeneral);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(255, 153, 153));
		btnGuardar.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nuevoTitulo = txtTitulo.getText();
				String nuevoLugar = txtLugar.getText();
				String nuevoPrecioStr = txtPrecio.getText();
				String nuevoCuposStr = txtCupos.getText();
				LocalDate nuevaFecha = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				int nuevaHora = (int) inputHora.getValue();
				int nuevoMinuto = (int) inputMinuto.getValue();

				// Validaciones
				boolean isValid = true;
				LocalDate fechaActual = LocalDate.now();
				if (nuevaFecha.isBefore(fechaActual)) {
					lblErrorGeneral.setText("La fecha seleccionada no puede ser anterior a la fecha actual.");
					return;
				}

				if (nuevoTitulo.length() < 3) {
					lblErrorTitulo.setText("El título debe tener al menos 4 caracteres.");
					isValid = false;
				} else {
					lblErrorTitulo.setText("");
				}

				if (nuevoLugar.length() < 3) {
					lblErrorLugar.setText("El lugar debe tener al menos 4 caracteres.");
					isValid = false;
				} else {
					lblErrorLugar.setText("");
				}

				double nuevoPrecio = 0.0;
				try {
					nuevoPrecio = Double.parseDouble(nuevoPrecioStr);
					if (nuevoPrecio <= 0) {
						lblErrorPrecio.setText("El precio debe ser mayor que 0.");
						isValid = false;
					} else {
						lblErrorPrecio.setText("");
					}
				} catch (NumberFormatException ex) {
					lblErrorPrecio.setText("Ingrese un precio válido.");
					isValid = false;
				}

				int nuevoCupos = 0;
				try {
					nuevoCupos = Integer.parseInt(nuevoCuposStr);
					if (nuevoCupos < 10 || nuevoCupos > 100) {
						lblErrorCupos.setText("Los cupos deben estar entre 10 y 100.");
						isValid = false;
					} else {
						lblErrorCupos.setText("");
					}
				} catch (NumberFormatException ex) {
					lblErrorCupos.setText("Ingrese un número válido para los cupos.");
					isValid = false;
				}

				if (!isValid) {
					lblErrorGeneral.setText("Por favor corrija los errores.");
					return;
				}

				if (nuevoTitulo.equals(curso.getTitulo()) && nuevoLugar.equals(curso.getLugar())
						&& nuevoPrecioStr.equals(String.valueOf(curso.getPrecio()))
						&& nuevoCuposStr.equals(String.valueOf(curso.getCupo())) && nuevaFecha.equals(curso.getDia())
						&& nuevaHora == curso.getHorario().getHour() && nuevoMinuto == curso.getHorario().getMinute()) {
					lblErrorGeneral.setText("No se han realizado cambios.");
					return;
				}
				curso.setTitulo(nuevoTitulo);
				curso.setLugar(nuevoLugar);
				curso.setPrecio(nuevoPrecio);
				curso.setCupo(nuevoCupos);
				curso.setDia(nuevaFecha);
				curso.setHorario(LocalTime.of(nuevaHora, nuevoMinuto));

				controlador.updateCurso(curso);
				PantallaMisCursos misCursos = new PantallaMisCursos(perfil);
				misCursos.setVisible(true);
				dispose();
			}
		});
		btnGuardar.setBounds(403, 450, 271, 30);
		contentPane.add(btnGuardar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 255, 153));
		btnCancelar.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaMisCursos misCursos = new PantallaMisCursos(perfil);
				misCursos.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(494, 491, 180, 30);
		contentPane.add(btnCancelar);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1_1.setBorder(null);
		panel_1_1_1.setBackground(new Color(153, 0, 0));
		panel_1_1_1.setBounds(-51, 20, 906, 44);
		contentPane.add(panel_1_1_1);

		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setForeground(Color.WHITE);
		lblHorario.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblHorario.setBounds(104, 391, 100, 20);
		contentPane.add(lblHorario);

		JLabel lblHhmm = new JLabel("hh/mm");
		lblHhmm.setHorizontalAlignment(SwingConstants.CENTER);
		lblHhmm.setForeground(new Color(255, 153, 153));
		lblHhmm.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblHhmm.setBounds(84, 409, 100, 20);
		contentPane.add(lblHhmm);

		JPanel panel_1_1_2_1 = new JPanel();
		panel_1_1_2_1.setForeground(new Color(51, 51, 0));
		panel_1_1_2_1.setBackground(new Color(255, 204, 0));
		panel_1_1_2_1.setBounds(224, 79, 460, 35);
		contentPane.add(panel_1_1_2_1);

		JPanel panel_1_1_2_1_1 = new JPanel();
		panel_1_1_2_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1_2_1_1.setBackground(new Color(255, 204, 0));
		panel_1_1_2_1_1.setBounds(224, 150, 460, 35);
		contentPane.add(panel_1_1_2_1_1);

		JPanel panel_1_1_2_1_2 = new JPanel();
		panel_1_1_2_1_2.setForeground(new Color(51, 51, 0));
		panel_1_1_2_1_2.setBackground(new Color(255, 204, 0));
		panel_1_1_2_1_2.setBounds(224, 213, 460, 35);
		contentPane.add(panel_1_1_2_1_2);

		JPanel panel_1_1_2_1_3 = new JPanel();
		panel_1_1_2_1_3.setForeground(new Color(51, 51, 0));
		panel_1_1_2_1_3.setBackground(new Color(255, 204, 0));
		panel_1_1_2_1_3.setBounds(274, 286, 410, 35);
		contentPane.add(panel_1_1_2_1_3);

		JPanel panel_1_1_2_1_4 = new JPanel();
		panel_1_1_2_1_4.setForeground(new Color(51, 51, 0));
		panel_1_1_2_1_4.setBackground(new Color(255, 204, 0));
		panel_1_1_2_1_4.setBounds(224, 411, 100, 30);
		contentPane.add(panel_1_1_2_1_4);

		inputHora = new JSpinner();
		panel_1_1_2_1_4.add(inputHora);
		inputHora.setModel(new SpinnerNumberModel(0, 0, 24, 1));

		inputMinuto = new JSpinner();
		panel_1_1_2_1_4.add(inputMinuto);
		inputMinuto.setModel(new SpinnerNumberModel(0, 0, 59, 1));

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(51, 51, 0));
		panel_1.setBackground(new Color(128, 0, 0));
		panel_1.setBounds(224, 343, 153, 44);
		contentPane.add(panel_1);

		setVisible(true);
	}
}
