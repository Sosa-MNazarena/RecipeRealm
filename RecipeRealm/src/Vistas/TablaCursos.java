package Vistas;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controladores.CursoControlador;
import Modelos.Cursos;
import Modelos.Perfil;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class TablaCursos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private CursoControlador controlador;
	private JLabel elemento;
	private Perfil perfilActual;
	private Cursos seleccionado;
	private JTextField txtBusqueda;
	private JTextField txtPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Perfil perfil = new Perfil(1, "Nombre", "Pseudónimo", "correo@example.com", "contraseña",
							"Descripción", true);
					TablaCursos frame = new TablaCursos(perfil);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TablaCursos(Perfil perfil) {
		this.setVisible(true);
		this.perfilActual = perfil;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 926, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Inicializar controlador y curso seleccionado
		controlador = new CursoControlador();
		seleccionado = new Cursos(1, "Título del Curso", 0, "Lugar del Curso", LocalDate.now(), 20, 100.0,
				LocalTime.now());

		// Crear la tabla y el modelo
		String[] columnNames = { "ID", "Título", "Lugar", "Fecha", "Cupo", "Precio", "Horario" };
		model = new DefaultTableModel(columnNames, 0);
		table = new JTable(model);
		actualizarTabla();

		// Crear el JScrollPane y agregar la tabla
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(15, 73, 856, 190);
		contentPane.add(scrollPane);

		// Crear el JLabel para mostrar la selección
		elemento = new JLabel("Seleccionado:");
		elemento.setFont(new Font("Leelawadee UI", Font.PLAIN, 14));
		elemento.setBounds(15, 52, 911, 14);
		contentPane.add(elemento);

		// Crear el botón de volver
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
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
		btnVolver.setBackground(new Color(192, 192, 192));
		btnVolver.setBounds(15, 11, 87, 37);
		contentPane.add(btnVolver);

		// Crear el botón de eliminar
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setBackground(new Color(0, 0, 0));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (seleccionado.getIdCurso() != 0) {
					controlador.deleteCurso(seleccionado.getIdCurso());
					JOptionPane.showMessageDialog(null, "Eliminado");
					actualizarTabla();
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione un curso");
				}
			}
		});
		btnEliminar.setBounds(515, 304, 356, 37);
		contentPane.add(btnEliminar);

		// Campo de búsqueda y botón de búsqueda
		txtBusqueda = new JTextField();
		txtBusqueda.setBounds(15, 348, 250, 37);
		contentPane.add(txtBusqueda);
		txtBusqueda.setColumns(10);

		JButton btnBuscar = new JButton("Buscar por Título");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String criterio = txtBusqueda.getText();
				buscarCurso(criterio);
			}
		});
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
		btnBuscar.setBackground(Color.BLACK);
		btnBuscar.setBounds(275, 348, 230, 37);
		contentPane.add(btnBuscar);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(15, 304, 250, 37);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valor =Integer.parseInt(txtPrecio.getText()) ;
				buscarCursoPrecio(valor);
			}
		});
		btnFiltrar.setForeground(Color.WHITE);
		btnFiltrar.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
		btnFiltrar.setBackground(Color.BLACK);
		btnFiltrar.setBounds(275, 304, 230, 37);
		contentPane.add(btnFiltrar);
		
		
		//para implementar después la parte de "mis cursos" para el chef, y "incribite" para el aficionado
		JButton btnNewButton = new JButton("New button");
		if (perfil.isVerificado()) {
			
			btnNewButton.setVisible(true);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton.setBounds(561, 368, 198, 41);
			contentPane.add(btnNewButton);
        } else {
        	btnNewButton.setVisible(false);
        }
		
		
		
		

		// Configurar el modelo de selección
		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Agregar un escuchador de selección
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = table.getSelectedRow();
					if (selectedRow != -1) {
						int id = (int) table.getValueAt(selectedRow, 0);
						String titulo = (String) table.getValueAt(selectedRow, 1);
						String lugar = (String) table.getValueAt(selectedRow, 2);
						String fecha = (String) table.getValueAt(selectedRow, 3);
						int cupo = (int) table.getValueAt(selectedRow, 4);
						double precio = (double) table.getValueAt(selectedRow, 5);
						String horario = (String) table.getValueAt(selectedRow, 6);

						elemento.setText(
								"Seleccionado: ID=" + id + ", Título=" + titulo + ", Lugar=" + lugar + ", Fecha="
										+ fecha + ", Cupo=" + cupo + ", Precio=" + precio + ", Horario=" + horario);

						seleccionado.setIdCurso(id);
						seleccionado.setTitulo(titulo);
						seleccionado.setLugar(lugar);
						seleccionado.setDia(LocalDate.parse(fecha));
						seleccionado.setCupo(cupo);
						seleccionado.setPrecio(precio);
						seleccionado.setHorario(LocalTime.parse(horario));
					}
				}
			}
		});
	}

	private void actualizarTabla() {
		model.setRowCount(0);

		List<Cursos> cursos = controlador.getAllCursos();

		for (Cursos curso : cursos) {
			Object[] fila = { curso.getIdCurso(), curso.getTitulo(), curso.getLugar(),
					curso.getDia().toString(), curso.getCupo(), curso.getPrecio(), curso.getHorario().toString() };
			model.addRow(fila);
		}
	}

	private void buscarCurso(String criterio) {
		model.setRowCount(0);

		List<Cursos> cursos = controlador.getAllCursos();

		for (Cursos curso : cursos) {
			if (curso.getTitulo().toLowerCase().contains(criterio.toLowerCase())) {
				Object fila[] = { curso.getIdCurso(), curso.getTitulo(), curso.getLugar(), curso.getDia().toString(),
						curso.getCupo(), curso.getPrecio(), curso.getHorario().toString() };
				model.addRow(fila);

			}
		}
	}
	
	private void buscarCursoPrecio(int valor) {
		model.setRowCount(0);

		List<Cursos> cursos = controlador.getAllCursos();

		for (Cursos curso : cursos) {
			if (curso.getPrecio()<valor) {
				Object fila[] = { curso.getIdCurso(), curso.getTitulo(), curso.getLugar(), curso.getDia().toString(),
						curso.getCupo(), curso.getPrecio(), curso.getHorario().toString() };
				model.addRow(fila);

			}
		}
	}
}
