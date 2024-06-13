package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;

public class PantallaSubirReceta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputTitulo;
	private JTextField inputFecha;

	/**
	 * Launch the application.
	 */

	
	public PantallaSubirReceta() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		inputTitulo = new JTextField();
		inputTitulo.setBounds(87, 93, 264, 31);
		inputTitulo.setColumns(10);
		contentPane.add(inputTitulo);
		
		JLabel lblTitulo = new JLabel("Título");
		lblTitulo.setBounds(87, 66, 38, 22);
		lblTitulo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		contentPane.add(lblTitulo);

	        inputIngredientes = new JTextArea();
	        JScrollPane scrollPaneIngredientes = new JScrollPane(inputIngredientes);
	        scrollPaneIngredientes.setBounds(220, 155, 500, 100);
	        contentPane.add(scrollPaneIngredientes);
		
		JLabel lblSubTuReceta = new JLabel("Subí tu receta");
		lblSubTuReceta.setBounds(294, 10, 139, 31);
		lblSubTuReceta.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 23));
		contentPane.add(lblSubTuReceta);
		
		JLabel lblDa = new JLabel("Fecha");
		lblDa.setBounds(99, 331, 64, 22);
		lblDa.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		contentPane.add(lblDa);
		
		inputFecha = new JTextField();
		inputFecha.setBounds(99, 352, 96, 31);
		inputFecha.setColumns(10);
		contentPane.add(inputFecha);
		
		JButton btnPublicar = new JButton("Publicar");
		btnPublicar.setBounds(205, 354, 89, 29);
		btnPublicar.setForeground(Color.WHITE);
		btnPublicar.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
		btnPublicar.setBackground(Color.BLACK);
		contentPane.add(btnPublicar);
		
		JTextArea inputProcedimiento = new JTextArea();
		inputProcedimiento.setWrapStyleWord(true);
		inputProcedimiento.setRows(5);
		inputProcedimiento.setLineWrap(true);
		inputProcedimiento.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		inputProcedimiento.setBounds(361, 94, 354, 286);
		contentPane.add(inputProcedimiento);
		
		JLabel lblProcedimiento = new JLabel("Procedimiento");
		lblProcedimiento.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		lblProcedimiento.setBounds(361, 66, 337, 22);
		contentPane.add(lblProcedimiento);
		
		JLabel lblTitulo_1 = new JLabel("Título");
		lblTitulo_1.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblTitulo_1.setBounds(87, 132, 38, 22);
		contentPane.add(lblTitulo_1);
	}
}
