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

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class TablaCursos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private CursoControlador controlador;
	private JLabel elemento;
	private Cursos seleccionado;
	private JButton Editar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TablaCursos frame = new TablaCursos();
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
	public TablaCursos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Inicializar controlador y curso seleccionado
		controlador = new CursoControlador();
		seleccionado = new Cursos(1, "Título del Curso", null, "Lugar del Curso", LocalDate.now(), 20, 100.0,
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

		// Crear el botón de eliminar
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(new Color(0, 0, 0));
		btnEliminar.setBackground(new Color(255, 255, 255));
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
		btnEliminar.setBounds(523, 290, 187, 58);
	    contentPane.add(btnEliminar);
		
		// Crear el botón de editar
		Editar = new JButton("Editar");
		Editar.setForeground(new Color(0, 0, 0));
		Editar.setBackground(new Color(255, 255, 255));
		Editar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (seleccionado.getIdCurso() != 0) {
		            // Crear el formulario de edición y pasar los datos del curso seleccionado
		        	
		        	// Falta resolver  ---
		            // EditarCurso editarCurso = new EditarCurso(seleccionado);
		            dispose(); 
		        } else {
		            JOptionPane.showMessageDialog(null, "Seleccione un curso");
		        }
		    }
		});
		Editar.setBounds(172, 290, 166, 58);
		contentPane.add(Editar);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(15, 220, 101, 22);
		contentPane.add(menuBar);
		
		JLabel lblNewLabel = new JLabel("Cursos disponibles");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Leelawadee UI", Font.BOLD, 17));
		lblNewLabel.setBounds(292, 11, 277, 38);
		contentPane.add(lblNewLabel);

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
		// Limpiar el modelo de la tabla
		model.setRowCount(0);

		// Obtener la lista actualizada de cursos
		List<Cursos> cursos = controlador.getAllCursos();

		// Agregar los datos al modelo
		for (Cursos curso : cursos) {
			model.addRow(new Object[] { curso.getIdCurso(), curso.getTitulo(), curso.getLugar(),
					curso.getDia().toString(), curso.getCupo(), curso.getPrecio(), curso.getHorario().toString() });
		}
	}
}
