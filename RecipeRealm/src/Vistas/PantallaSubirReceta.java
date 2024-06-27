package Vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controladores.PerfilControlador;
import Modelos.Perfil;
import Modelos.Receta;

public class PantallaSubirReceta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputNombreIngrediente;
	private JTextField inputCantidadIngrediente;
	private List<String> listaIngredientes;
	private List<String> listaCategorias;
	private JPanel panelIngredientes;
	private JComboBox<String> comboBox;
	private JTextField textFieldTitulo;
	private JPanel panelCategorias;
	private JTextArea inputProcedimiento;
	private Perfil perfil;
	private PerfilControlador controlador = new PerfilControlador();
	private JLabel lblErrorIngredientes;
	private JLabel lblErrorTitulo;
	private JLabel lblErrorProcedimiento;
	private JLabel lblErrorCategorias;
	private JPanel panel_1_1;
	private JPanel panel_1_1_2;
	private JPanel panel_1_1_2_1;
	private JPanel panel;

	public PantallaSubirReceta(Perfil perfil) {
		this.perfil = perfil;
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 603);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblErrorProcedimiento = new JLabel("");
		lblErrorProcedimiento.setForeground(Color.RED);
		lblErrorProcedimiento.setBounds(363, 466, 354, 20);
		contentPane.add(lblErrorProcedimiento);

		panelCategorias = new JPanel();
		panelCategorias.setBackground(new Color(255, 51, 51));
		panelCategorias.setForeground(Color.WHITE);
		panelCategorias.setLayout(new BoxLayout(panelCategorias, BoxLayout.Y_AXIS));
		JScrollPane scrollPaneCategorias = new JScrollPane(panelCategorias);
		scrollPaneCategorias.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneCategorias.setBounds(43, 381, 284, 58);
		contentPane.add(scrollPaneCategorias);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (perfil.isVerificado()) {
					PantallaHomeChef homeChef = new PantallaHomeChef(perfil);
					homeChef.setVisible(true);
					dispose();
				} else {
					PantallaHomeAficionado homeAficionado = new PantallaHomeAficionado(perfil);
					homeAficionado.setVisible(true);
					dispose();
				}
			}
		});
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("Lucida Console", Font.BOLD, 15));
		btnVolver.setBackground(new Color(255, 255, 204));
		btnVolver.setBounds(15, 18, 116, 30);
		contentPane.add(btnVolver);

		JLabel lblNewLabel = new JLabel("Subí tu Receta acá");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Console", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 11, 763, 44);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/pergaminoIconMini.png")));

		JLabel lblTitulo = new JLabel("Título");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblTitulo.setBounds(43, 67, 108, 20);
		contentPane.add(lblTitulo);

		textFieldTitulo = new JTextField();
		textFieldTitulo.setColumns(10);
		textFieldTitulo.setBounds(43, 86, 284, 33);
		contentPane.add(textFieldTitulo);

		inputProcedimiento = new JTextArea();
		inputProcedimiento.setBackground(new Color(255, 255, 204));
		inputProcedimiento.setWrapStyleWord(true);
		inputProcedimiento.setLineWrap(true);
		inputProcedimiento.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		inputProcedimiento.setBounds(363, 86, 354, 369);
		contentPane.add(inputProcedimiento);

		JLabel lblProcedimiento = new JLabel("Procedimiento");
		lblProcedimiento.setForeground(Color.WHITE);
		lblProcedimiento.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblProcedimiento.setBounds(363, 66, 337, 22);
		contentPane.add(lblProcedimiento);

		JButton btnPublicarReceta = new JButton("Publicar Receta");
		btnPublicarReceta.setForeground(Color.BLACK);
		btnPublicarReceta.setBackground(new Color(255, 153, 153));
		btnPublicarReceta.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		btnPublicarReceta.setBounds(363, 496, 354, 29);
		contentPane.add(btnPublicarReceta);

		btnPublicarReceta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validarCampos()) {
					LocalDate fecha = LocalDate.now();
					String categorias = String.join(" - ", listaCategorias);
					String ingredientes = String.join(" \n ", listaIngredientes);

					if (perfil == null) {
						JOptionPane.showMessageDialog(null, "El perfil no está definido.");
						return;
					}

					int idUsuario = perfil.getIdUsuario();

					String respuesta = Receta.subirReceta(textFieldTitulo.getText(), inputProcedimiento.getText(),
							categorias, ingredientes, fecha, perfil.getIdUsuario());

					if (respuesta.equals("OK")) {
						JOptionPane.showMessageDialog(null, "Receta publicada correctamente");
						dispose();
						PantallaHomeChef pantallaHomeChef = new PantallaHomeChef(perfil);
						pantallaHomeChef.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, respuesta);
					}
				}
			}
		});

		inputNombreIngrediente = new JTextField();
		inputNombreIngrediente.setBounds(43, 170, 205, 26);
		contentPane.add(inputNombreIngrediente);
		inputNombreIngrediente.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		inputNombreIngrediente.setColumns(10);

		JLabel lblNombreIngrediente = new JLabel("Nombre del Ingrediente");
		lblNombreIngrediente.setForeground(Color.WHITE);
		lblNombreIngrediente.setBounds(43, 150, 205, 20);
		contentPane.add(lblNombreIngrediente);
		lblNombreIngrediente.setFont(new Font("Lucida Console", Font.PLAIN, 14));

		JButton btnAgregarIngrediente = new JButton("Agregar");
		btnAgregarIngrediente.setForeground(Color.BLACK);
		btnAgregarIngrediente.setBackground(new Color(255, 153, 153));
		btnAgregarIngrediente.setBounds(235, 200, 92, 29);
		contentPane.add(btnAgregarIngrediente);
		btnAgregarIngrediente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarIngrediente();
			}
		});

		btnAgregarIngrediente.setFont(new Font("Lucida Console", Font.PLAIN, 12));

		JLabel lblCantidadIngrediente = new JLabel("Cantidad");
		lblCantidadIngrediente.setForeground(Color.WHITE);
		lblCantidadIngrediente.setBounds(258, 150, 83, 20);
		contentPane.add(lblCantidadIngrediente);
		lblCantidadIngrediente.setFont(new Font("Lucida Console", Font.PLAIN, 14));

		inputCantidadIngrediente = new JTextField();
		inputCantidadIngrediente.setBounds(258, 170, 67, 26);
		contentPane.add(inputCantidadIngrediente);
		inputCantidadIngrediente.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		inputCantidadIngrediente.setColumns(10);

		panelIngredientes = new JPanel();
		panelIngredientes.setBounds(43, 240, 284, 136);
		contentPane.add(panelIngredientes);
		panelIngredientes.setBackground(new Color(255, 51, 51));
		panelIngredientes.setForeground(new Color(255, 255, 255));
		panelIngredientes.setLayout(null);
		panelIngredientes.setLayout(new BoxLayout(panelIngredientes, BoxLayout.Y_AXIS));
		JScrollPane scrollPaneIngredientes = new JScrollPane(panelIngredientes);
		scrollPaneIngredientes.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneIngredientes.setBounds(43, 240, 284, 136);
		contentPane.add(scrollPaneIngredientes);

		lblErrorIngredientes = new JLabel("");
		lblErrorIngredientes.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblErrorIngredientes.setForeground(Color.RED);
		lblErrorIngredientes.setBounds(43, 200, 205, 30);
		contentPane.add(lblErrorIngredientes);

		lblErrorTitulo = new JLabel("");
		lblErrorTitulo.setForeground(Color.RED);
		lblErrorTitulo.setBounds(43, 120, 284, 30);
		contentPane.add(lblErrorTitulo);

		lblErrorCategorias = new JLabel("");
		lblErrorCategorias.setForeground(Color.RED);
		lblErrorCategorias.setBounds(43, 527, 284, 20);
		contentPane.add(lblErrorCategorias);

		listaIngredientes = new ArrayList<>();
		listaCategorias = new ArrayList<>();

		comboBox = new JComboBox<>();
		comboBox.setBounds(43, 455, 291, 33);
		contentPane.add(comboBox);
		comboBox.addItem("Italia");
		comboBox.addItem("China");
		comboBox.addItem("México");
		comboBox.addItem("Argentina");
		comboBox.addItem("Brasil");
		comboBox.addItem("Colombia");
		comboBox.addItem("Dulces");
		comboBox.addItem("Japón");

		JLabel lblCategoria = new JLabel("Categorías");
		lblCategoria.setBounds(43, 437, 238, 20);
		contentPane.add(lblCategoria);
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setFont(new Font("Lucida Console", Font.PLAIN, 14));

		JButton btnAgregarCategoria = new JButton("Agregar");
		btnAgregarCategoria.setForeground(Color.BLACK);
		btnAgregarCategoria.setBackground(new Color(255, 255, 153));
		btnAgregarCategoria.setBounds(43, 493, 92, 29);
		contentPane.add(btnAgregarCategoria);
		btnAgregarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarCategoria();
			}
		});
		btnAgregarCategoria.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		
		panel_1_1 = new JPanel();
		panel_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1.setBorder(null);
		panel_1_1.setBackground(new Color(153, 0, 0));
		panel_1_1.setBounds(-52, 11, 906, 44);
		contentPane.add(panel_1_1);
		
		panel_1_1_2 = new JPanel();
		panel_1_1_2.setForeground(new Color(51, 51, 0));
		panel_1_1_2.setBackground(new Color(255, 204, 0));
		panel_1_1_2.setBounds(53, 98, 284, 30);
		contentPane.add(panel_1_1_2);
		
		panel_1_1_2_1 = new JPanel();
		panel_1_1_2_1.setForeground(new Color(51, 51, 0));
		panel_1_1_2_1.setBackground(new Color(255, 204, 0));
		panel_1_1_2_1.setBounds(373, 99, 354, 362);
		contentPane.add(panel_1_1_2_1);
		
		panel = new JPanel();
		panel.setForeground(new Color(51, 51, 0));
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(373, 505, 352, 30);
		contentPane.add(panel);
	}

	private boolean validarCampos() {
		String titulo = textFieldTitulo.getText().trim();
		String procedimiento = inputProcedimiento.getText().trim();

		boolean esValido = true;

		if (titulo.isEmpty() || titulo.length() < 3 || titulo.length() > 50) {
			lblErrorTitulo.setText("El título debe tener al menos 3 caracteres.");
			esValido = false;
		} else {
			lblErrorTitulo.setText("");
		}

		if (procedimiento.isEmpty() || procedimiento.length() < 20 || procedimiento.length() > 200) {
			lblErrorProcedimiento.setText("El procedimiento debe tener al menos 20 caracteres.");
			esValido = false;
		} else {
			lblErrorProcedimiento.setText("");
		}

		if (listaIngredientes.isEmpty()) {
			lblErrorIngredientes.setText("Debe agregar al menos un ingrediente.");
			esValido = false;
		} else {
			lblErrorIngredientes.setText("");
		}

		if (listaCategorias.isEmpty()) {
			lblErrorCategorias.setText("Debe agregar al menos una categoría.");
			esValido = false;
		} else {
			lblErrorCategorias.setText("");
		}

		return esValido;
	}

	private void agregarIngrediente() {
		String nombreIngrediente = inputNombreIngrediente.getText().trim();
		String cantidadIngredienteStr = inputCantidadIngrediente.getText().trim();

		// validar nombre ingrediente
		if (nombreIngrediente.isEmpty() || nombreIngrediente.length() < 3) {
			lblErrorIngredientes.setText("El nombre debe tener al menos 3 caracteres.");
			return;
		}

		// validar cantidad ingrediente
		double cantidadIngrediente = 0;
		try {
			cantidadIngrediente = Double.parseDouble(cantidadIngredienteStr);
			if (cantidadIngrediente <= 0) {
				lblErrorIngredientes.setText("La cantidad debe ser mayor que 0.");
				return;
			}
		} catch (NumberFormatException e) {
			lblErrorIngredientes.setText("La cantidad debe ser un número válido.");
			return;
		}

		String nuevoIngrediente = nombreIngrediente + " - " + cantidadIngredienteStr;
		listaIngredientes.add(nuevoIngrediente);

		JLabel labelIngrediente = new JLabel(nuevoIngrediente);
		labelIngrediente.setFont(new Font("Tahoma", Font.PLAIN, 14));

		int yPosition = 10 + listaIngredientes.size() * 30;
		labelIngrediente.setBounds(10, yPosition, 400, 20);
		panelIngredientes.add(labelIngrediente);

		inputNombreIngrediente.setText("");
		inputCantidadIngrediente.setText("");

		panelIngredientes.setPreferredSize(new java.awt.Dimension(301, yPosition + 30));
		panelIngredientes.revalidate();
		panelIngredientes.repaint();
	}

	private void agregarCategoria() {
		String nuevaCategoria = (String) comboBox.getSelectedItem();
		listaCategorias.add(nuevaCategoria);

		JLabel labelCategoria = new JLabel(nuevaCategoria);
		labelCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));

		int yPosition = 10 + listaCategorias.size() * 30;
		labelCategoria.setBounds(10, yPosition, 400, 20);
		panelCategorias.add(labelCategoria);

		panelCategorias.setPreferredSize(new java.awt.Dimension(354, yPosition + 30));
		panelCategorias.revalidate();
		panelCategorias.repaint();
	}
}
