package Vistas;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

import Controladores.RecetaControlador;
import Modelos.Perfil;
import Modelos.Receta;

public class PantallaEditarReceta extends JFrame {

	private JPanel contentPane;
	private Receta receta;
	private Perfil perfil;
	private RecetaControlador recetaControlador;

	private JTextField txtNombre;
	private JTextArea txtDescripcion;
	private JTextField txtIngredientes;
	private JTextArea txtCategoria;

	private JLabel lblErrorNombre;
	private JLabel lblErrorDescripcion;
	private JLabel lblErrorIngredientes;
	private JLabel lblErrorCategoria;

	public PantallaEditarReceta(Receta receta, Perfil perfil) {
		this.receta = receta;
		this.perfil = perfil;
		this.recetaControlador = new RecetaControlador();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 560);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEditarReceta = new JLabel("Editar Receta");
		lblEditarReceta.setForeground(new Color(255, 255, 255));
		lblEditarReceta.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarReceta.setFont(new Font("Lucida Console", Font.BOLD, 26));
		lblEditarReceta.setBounds(0, 20, 786, 44);
		contentPane.add(lblEditarReceta);
		lblEditarReceta
				.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/pergaminoIconMini.png")));

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		lblNombre.setBounds(104, 81, 100, 20);
		contentPane.add(lblNombre);

		txtNombre = new JTextField(receta.getTitulo());
		txtNombre.setBounds(214, 79, 460, 30);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		lblErrorNombre = new JLabel("");
		lblErrorNombre.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		lblErrorNombre.setForeground(Color.RED);
		lblErrorNombre.setBounds(224, 117, 460, 20);
		contentPane.add(lblErrorNombre);

		JLabel lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblDescripcion.setBounds(104, 137, 111, 20);
		contentPane.add(lblDescripcion);

		txtDescripcion = new JTextArea(receta.getProcedimiento());
		txtDescripcion.setBackground(new Color(255, 255, 204));
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setWrapStyleWord(true);
		txtDescripcion.setBounds(214, 138, 460, 100);
		contentPane.add(txtDescripcion);

		lblErrorDescripcion = new JLabel("");
		lblErrorDescripcion.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		lblErrorDescripcion.setForeground(Color.RED);
		lblErrorDescripcion.setBounds(214, 238, 460, 20);
		contentPane.add(lblErrorDescripcion);

		JLabel lblIngredientes = new JLabel("Ingredientes:");
		lblIngredientes.setForeground(Color.WHITE);
		lblIngredientes.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblIngredientes.setBounds(104, 262, 118, 20);
		contentPane.add(lblIngredientes);

		txtIngredientes = new JTextField(receta.getIngredientes());
		txtIngredientes.setBounds(214, 260, 460, 30);
		contentPane.add(txtIngredientes);
		txtIngredientes.setColumns(10);

		lblErrorIngredientes = new JLabel("");
		lblErrorIngredientes.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		lblErrorIngredientes.setForeground(Color.RED);
		lblErrorIngredientes.setBounds(214, 293, 460, 37);
		contentPane.add(lblErrorIngredientes);

		JLabel lblCategoria = new JLabel("Categoría:");
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblCategoria.setBounds(104, 332, 100, 20);
		contentPane.add(lblCategoria);

		txtCategoria = new JTextArea(receta.getCategorias());
		txtCategoria.setBounds(214, 333, 460, 30);
		contentPane.add(txtCategoria);

		lblErrorCategoria = new JLabel("");
		lblErrorCategoria.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		lblErrorCategoria.setForeground(Color.RED);
		lblErrorCategoria.setBounds(214, 365, 460, 20);
		contentPane.add(lblErrorCategoria);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(255, 153, 153));
		btnGuardar.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validarCampos()) {
					receta.setTitulo(txtNombre.getText());
					receta.setProcedimiento(txtDescripcion.getText());
					receta.setIngredientes(txtIngredientes.getText());
					receta.setCategorias(txtCategoria.getText());
					recetaControlador.updateReceta(receta);
					PantallaMisRecetas misRecetas = new PantallaMisRecetas(perfil);
					misRecetas.setVisible(true);
					dispose();
				}
			}
		});
		btnGuardar.setBounds(379, 396, 295, 41);
		contentPane.add(btnGuardar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 255, 204));
		btnCancelar.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaMisRecetas misRecetas = new PantallaMisRecetas(perfil);
				misRecetas.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(525, 451, 149, 41);
		contentPane.add(btnCancelar);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1_1.setBorder(null);
		panel_1_1_1.setBackground(new Color(153, 0, 0));
		panel_1_1_1.setBounds(0, 20, 786, 44);
		contentPane.add(panel_1_1_1);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(51, 51, 0));
		panel_1.setBackground(new Color(128, 0, 0));
		panel_1.setBounds(389, 401, 290, 44);
		contentPane.add(panel_1);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1.setBackground(new Color(255, 204, 0));
		panel_1_1.setBounds(535, 458, 144, 41);
		contentPane.add(panel_1_1);

		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setForeground(new Color(51, 51, 0));
		panel_1_1_2.setBackground(new Color(255, 204, 0));
		panel_1_1_2.setBounds(220, 341, 458, 30);
		contentPane.add(panel_1_1_2);

		JPanel panel_1_1_2_1 = new JPanel();
		panel_1_1_2_1.setForeground(new Color(51, 51, 0));
		panel_1_1_2_1.setBackground(new Color(255, 204, 0));
		panel_1_1_2_1.setBounds(220, 267, 458, 30);
		contentPane.add(panel_1_1_2_1);

		JPanel panel_1_1_2_2 = new JPanel();
		panel_1_1_2_2.setForeground(new Color(51, 51, 0));
		panel_1_1_2_2.setBackground(new Color(255, 204, 0));
		panel_1_1_2_2.setBounds(220, 85, 458, 30);
		contentPane.add(panel_1_1_2_2);
	}

	private boolean validarCampos() {
		String titulo = txtNombre.getText().trim();
		String descripcion = txtDescripcion.getText().trim();
		String ingredientes = txtIngredientes.getText().trim();
		String categoria = txtCategoria.getText().trim();

		boolean esValido = true;

		if (titulo.isEmpty() || titulo.length() < 3) {
			lblErrorNombre.setText("El título debe tener al menos 3 caracteres.");
			esValido = false;
		} else {
			lblErrorNombre.setText("");
		}

		if (descripcion.isEmpty() || descripcion.length() < 20) {
			lblErrorDescripcion.setText("La descripción debe tener al menos 20 caracteres.");
			esValido = false;
		} else {
			lblErrorDescripcion.setText("");
		}
		if (ingredientes.isEmpty()) {
			lblErrorIngredientes.setText("Debe agregar al menos un ingrediente.");
			esValido = false;
		} else {
			boolean ingredienteValido = false;
			String[] ingredientesArray = ingredientes.split(",");
			for (String ingrediente : ingredientesArray) {
				String[] partes = ingrediente.trim().split(" ");
				if (partes.length > 1) {
					try {
						int cantidad = Integer.parseInt(partes[0]);
						if (cantidad > 0 && partes[1].length() > 3) {
							ingredienteValido = true;
							break;
						}
					} catch (NumberFormatException ex) {
					
					}
				}
			}
			if (!ingredienteValido) {
				lblErrorIngredientes.setText(
						"Cada ingrediente debe tener una cantidad mayor a 0 y un nombre de más de 3 caracteres.");
				esValido = false;
			} else {
				lblErrorIngredientes.setText("");
			}
		}
		if (categoria.isEmpty()) {
			lblErrorCategoria.setText("Debe agregar al menos una categoría.");
			esValido = false;
		} else {
			lblErrorCategoria.setText("");
		}

		return esValido;
	}
}
