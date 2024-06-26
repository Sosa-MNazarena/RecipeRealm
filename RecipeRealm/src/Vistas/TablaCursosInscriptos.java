package Vistas;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import Controladores.CursoControlador;
import Modelos.Cursos;
import Modelos.Perfil;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class TablaCursosInscriptos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private CursoControlador controlador;
    private Perfil perfil;
    private JLabel elemento;
    private Cursos seleccionado;
    private JTextField textField;
    private JTextField txtBusqueda;
	private JTextField txtPrecio;

    
    public TablaCursosInscriptos(Perfil perfil) {
    	this.setVisible(true);
        this.perfil = perfil;
        controlador = new CursoControlador();
        seleccionado = new Cursos(1, "Título del Curso", 0, "Lugar del Curso", LocalDate.now(), 20, 100.0,
				LocalTime.now());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1002, 665);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        String[] columnNames = { "ID", "Título", "Lugar", "Fecha", "Cupo", "Precio", "Horario" };
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        table.setBackground(new Color(255, 255, 204));
        actualizarTabla();

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(63, 214, 856, 309);
        contentPane.add(scrollPane);

        JLabel lblNewLabel = new JLabel("Tus Inscripciones");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setFont(new Font("Lucida Console", Font.BOLD, 20));
        lblNewLabel.setBounds(754, 11, 219, 36);
        contentPane.add(lblNewLabel);
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TablaCursos cursitosTabla = new TablaCursos(perfil);
                cursitosTabla.setVisible(true);
                dispose();
            }
        });
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setFont(new Font("Lucida Console", Font.BOLD, 16));
        btnVolver.setBackground(new Color(255, 255, 204));
        btnVolver.setBounds(15, 11, 116, 30);
        contentPane.add(btnVolver);
        
        JButton btnVer = new JButton("Ver Curso");
        btnVer.setForeground(Color.BLACK);
        btnVer.setFont(new Font("Lucida Console", Font.BOLD, 14));
        btnVer.setBackground(new Color(255, 153, 153));
        btnVer.setBounds(721, 562, 198, 30);
        contentPane.add(btnVer);
        
        btnVer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (seleccionado.getIdCurso() != 0) {
                    PantallaVerCurso verCurso= new PantallaVerCurso(seleccionado, perfil);
                    verCurso.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una curso");
                }
               
            }
        });
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 204, 0));
        panel_2.setBounds(83, 236, 856, 309);
        contentPane.add(panel_2);
        
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBackground(new Color(204, 0, 51));
        panel_1_1.setBounds(724, 568, 203, 30);
        contentPane.add(panel_1_1);
        
        JPanel panel_1_1_2 = new JPanel();
        panel_1_1_2.setForeground(Color.BLACK);
        panel_1_1_2.setBackground(new Color(255, 255, 204));
        panel_1_1_2.setBounds(63, 152, 853, 46);
        contentPane.add(panel_1_1_2);
        
                elemento = new JLabel("Seleccionado:");
                panel_1_1_2.add(elemento);
                elemento.setFont(new Font("Lucida Console", Font.PLAIN, 10));
                
                JLabel lblBuscarTituloTex = new JLabel("Buscar curso por título:");
                lblBuscarTituloTex.setVerticalAlignment(SwingConstants.BOTTOM);
                lblBuscarTituloTex.setForeground(new Color(255, 153, 153));
                lblBuscarTituloTex.setFont(new Font("Lucida Console", Font.PLAIN, 14));
                lblBuscarTituloTex.setBounds(63, 70, 337, 22);
                contentPane.add(lblBuscarTituloTex);
                
                JLabel lblFiltrarCursosPor = new JLabel("Filtrar cursos por precio \"menor a\":");
                lblFiltrarCursosPor.setVerticalAlignment(SwingConstants.BOTTOM);
                lblFiltrarCursosPor.setForeground(new Color(255, 153, 153));
                lblFiltrarCursosPor.setFont(new Font("Lucida Console", Font.PLAIN, 14));
                lblFiltrarCursosPor.setBounds(501, 70, 337, 22);
                contentPane.add(lblFiltrarCursosPor);
                
                txtPrecio = new JTextField();
                txtPrecio.setColumns(10);
                txtPrecio.setBounds(501, 94, 287, 30);
                contentPane.add(txtPrecio);
                
                JButton btnBuscar = new JButton("Buscar");
                btnBuscar.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		String criterio = txtBusqueda.getText();
						buscarCurso(criterio);
                	}
                });
                btnBuscar.setForeground(Color.BLACK);
                btnBuscar.setFont(new Font("Lucida Console", Font.PLAIN, 12));
                btnBuscar.setBackground(new Color(255, 153, 153));
                btnBuscar.setBounds(360, 94, 130, 30);
                contentPane.add(btnBuscar);
                
                JButton btnFiltrar = new JButton("Filtrar");
                btnFiltrar.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		if (txtPrecio.getText().isEmpty()) {
                			actualizarTabla();
						} else {
							int valor =Integer.parseInt(txtPrecio.getText()) ;
	        				buscarCursoPrecio(valor);
						}
                		
                	}
                });
                btnFiltrar.setForeground(Color.BLACK);
                btnFiltrar.setFont(new Font("Lucida Console", Font.PLAIN, 12));
                btnFiltrar.setBackground(new Color(255, 153, 153));
                btnFiltrar.setBounds(789, 94, 130, 30);
                contentPane.add(btnFiltrar);
                
                txtBusqueda = new JTextField();
                txtBusqueda.setColumns(10);
                txtBusqueda.setBounds(63, 94, 300, 30);
                contentPane.add(txtBusqueda);
                
                JPanel panel_1 = new JPanel();
                panel_1.setBackground(new Color(204, 0, 51));
                panel_1.setBounds(73, 103, 853, 30);
                contentPane.add(panel_1);

        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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
        actualizarTabla();
    }

    private void actualizarTabla() {
		model.setRowCount(0);

		List<Cursos> cursos = controlador.getCursosInscriptos(perfil);

		for (Cursos curso : cursos) {
			Object[] fila = { curso.getIdCurso(), curso.getTitulo(), curso.getLugar(),
					curso.getDia().toString(), curso.getCupo(), curso.getPrecio(), curso.getHorario().toString() };
			model.addRow(fila);
		}
	}
    
    private void buscarCurso(String criterio) {
		model.setRowCount(0);

		List<Cursos> cursos = controlador.getCursosInscriptos(perfil);

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

		List<Cursos> cursos = controlador.getCursosInscriptos(perfil);

		for (Cursos curso : cursos) {
			if (curso.getPrecio()<valor) {
				Object fila[] = { curso.getIdCurso(), curso.getTitulo(), curso.getLugar(), curso.getDia().toString(),
						curso.getCupo(), curso.getPrecio(), curso.getHorario().toString() };
				model.addRow(fila);

			}
		}
	}
}

