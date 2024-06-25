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
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.Box;
import javax.swing.JTextArea;

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
		setBounds(100, 100, 999, 666);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
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
		table.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table.setBackground(new Color(255, 255, 204));
		actualizarTabla();

		// Crear el JScrollPane y agregar la tabla
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(63, 214, 856, 309);
		contentPane.add(scrollPane);

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
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("Lucida Console", Font.BOLD, 16));
		btnVolver.setBackground(new Color(255, 255, 204));
		btnVolver.setBounds(15, 11, 116, 30);
		contentPane.add(btnVolver);
	
    
		// Crear el botón de eliminar
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Lucida Console", Font.BOLD, 15));
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setBackground(new Color(255, 153, 153));
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
		btnEliminar.setBounds(721, 562, 198, 30);
		contentPane.add(btnEliminar);
								
								JPanel panel_2 = new JPanel();
								panel_2.setBackground(new Color(255, 204, 0));
								panel_2.setBounds(83, 236, 856, 309);
								contentPane.add(panel_2);
										
										JPanel panel = new JPanel();
										panel.setBackground(new Color(255, 255, 204));
										panel.setBounds(63, 152, 853, 46);
										contentPane.add(panel);
										
												// Crear el JLabel para mostrar la selección
												elemento = new JLabel("Seleccionado:");
												panel.add(elemento);
												elemento.setHorizontalAlignment(SwingConstants.CENTER);
												elemento.setBackground(new Color(255, 255, 204));
												elemento.setFont(new Font("Lucida Console", Font.PLAIN, 10));
												
												JLabel lblCursos = new JLabel("Cursos ");
												lblCursos.setHorizontalAlignment(SwingConstants.RIGHT);
												lblCursos.setForeground(Color.WHITE);
												lblCursos.setFont(new Font("Lucida Console", Font.BOLD, 20));
												lblCursos.setBackground(Color.WHITE);
												lblCursos.setBounds(818, 11, 155, 36);
												contentPane.add(lblCursos);
		
		
		//para implementar después la parte de "mis cursos" para el chef, y "incribite" para el aficionado
		JButton btnNewButton = new JButton("Mis cursos");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(255, 255, 204));
		btnNewButton.setFont(new Font("Lucida Console", Font.BOLD, 16));
		if (perfil.isVerificado()) {
			
			btnNewButton.setVisible(true);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cursos curso = new Cursos(1, "", 1, "", LocalDate.now(), 20, 100.0,
							LocalTime.now());
			        PantallaMisCursos pantallaMisCursos = new PantallaMisCursos(perfil);
			        pantallaMisCursos.setVisible(true);
			        dispose();
				}
			});
			
        } else {
        	btnNewButton.setVisible(false);
        }
		btnNewButton.setBounds(136, 11, 155, 30);
		contentPane.add(btnNewButton);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(789, 93, 130, 30);
		contentPane.add(btnFiltrar);
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valor =Integer.parseInt(txtPrecio.getText()) ;
				buscarCursoPrecio(valor);
			}
		});
		btnFiltrar.setForeground(Color.BLACK);
		btnFiltrar.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		btnFiltrar.setBackground(new Color(255, 153, 153));
		
				JButton btnBuscarPorTitulo = new JButton("Buscar");
				btnBuscarPorTitulo.setBounds(360, 93, 130, 30);
				contentPane.add(btnBuscarPorTitulo);
				btnBuscarPorTitulo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String criterio = txtBusqueda.getText();
						buscarCurso(criterio);
					}
				});
				btnBuscarPorTitulo.setForeground(Color.BLACK);
				btnBuscarPorTitulo.setFont(new Font("Lucida Console", Font.PLAIN, 12));
				btnBuscarPorTitulo.setBackground(new Color(255, 153, 153));
				
				txtPrecio = new JTextField();
				txtPrecio.setBounds(500, 93, 300, 30);
				contentPane.add(txtPrecio);
				txtPrecio.setFont(new Font("Lucida Console", Font.PLAIN, 11));
				txtPrecio.setToolTipText("");
				txtPrecio.setColumns(10);
				
						// Campo de búsqueda y botón de búsqueda
						txtBusqueda = new JTextField();
						txtBusqueda.setBounds(63, 93, 300, 30);
						contentPane.add(txtBusqueda);
						txtBusqueda.setFont(new Font("Lucida Console", Font.PLAIN, 11));
						txtBusqueda.setColumns(10);
						
						JPanel panel_1 = new JPanel();
						panel_1.setBackground(new Color(204, 0, 51));
						panel_1.setBounds(73, 102, 853, 30);
						contentPane.add(panel_1);
						
						JLabel lblBuscarCursosPor = new JLabel("Buscar cursos por título:");
						lblBuscarCursosPor.setVerticalAlignment(SwingConstants.BOTTOM);
						lblBuscarCursosPor.setForeground(new Color(255, 153, 153));
						lblBuscarCursosPor.setFont(new Font("Lucida Console", Font.PLAIN, 14));
						lblBuscarCursosPor.setBounds(63, 69, 337, 22);
						contentPane.add(lblBuscarCursosPor);
						
						JLabel lblFiltrarCursosPor = new JLabel("Filtrar cursos por precio \"menor a\":");
						lblFiltrarCursosPor.setVerticalAlignment(SwingConstants.BOTTOM);
						lblFiltrarCursosPor.setForeground(new Color(255, 153, 153));
						lblFiltrarCursosPor.setFont(new Font("Lucida Console", Font.PLAIN, 14));
						lblFiltrarCursosPor.setBounds(501, 69, 337, 22);
						contentPane.add(lblFiltrarCursosPor);
						
						JPanel panel_1_1 = new JPanel();
						panel_1_1.setBackground(new Color(204, 0, 51));
						panel_1_1.setBounds(724, 568, 203, 30);
						contentPane.add(panel_1_1);
		
		
		

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
