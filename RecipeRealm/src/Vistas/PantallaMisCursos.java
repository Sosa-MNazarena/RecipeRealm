package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import Controladores.CursoControlador;
import Modelos.Perfil;
import Modelos.Receta;
import Modelos.Cursos;
import Controladores.PerfilControlador;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class PantallaMisCursos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
    private DefaultTableModel model;
    private CursoControlador controlador;
    private Perfil perfil;
    private JLabel elemento;
    private Cursos seleccionado;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Cursos curso = new Cursos(1, "", 1, "", LocalDate.now(), 20, 100.0,
				LocalTime.now());

                    Perfil perfil = new Perfil(1, "Nombre", "Pseudónimo", "correo@example.com", "contraseña",
                            "Descripción", true);
                    PantallaMisRecetas frame = new PantallaMisRecetas(perfil);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

	
	public PantallaMisCursos(Perfil perfil) {
		this.setVisible(true);
		this.perfil = perfil;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Inicialización del controlador de cursos
        controlador = new CursoControlador();
        seleccionado = new Cursos(1, "", 1, "", LocalDate.now(), 20, 100.0,
				LocalTime.now());
     // Configuración de la tabla y modelo
        String[] columnNames = { "ID", "Título", "Lugar", "Día", "Horario", "Cupo", "Precio" };
        model = new DefaultTableModel(columnNames, 0);
        
        JButton btnEditarReceta = new JButton("Editar Receta");
        btnEditarReceta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (seleccionado.getIdCurso() != 0) {
                    PantallaEditarCurso pantallaEditarCurso = new PantallaEditarCurso(seleccionado, perfil);
                    pantallaEditarCurso.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una receta");
                }
            }
        });
        btnEditarReceta.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
        btnEditarReceta.setBackground(Color.LIGHT_GRAY);
        btnEditarReceta.setBounds(15, 513, 205, 37);
        contentPane.add(btnEditarReceta);

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(15, 131, 756, 350);
        contentPane.add(scrollPane);

        elemento = new JLabel("Seleccionado:");
        elemento.setFont(new Font("Leelawadee UI", Font.PLAIN, 14));
        elemento.setBounds(15, 95, 756, 14);
        contentPane.add(elemento);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
        btnEliminar.setForeground(new Color(255, 255, 255));
        btnEliminar.setBackground(new Color(0, 0, 0));
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (seleccionado.getIdCurso() != 0) {
                    controlador.deleteCurso(seleccionado.getIdCurso());
                    JOptionPane.showMessageDialog(null, "Receta eliminada");
                    actualizarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una receta");
                }
            }
        });
        btnEliminar.setBounds(588, 513, 183, 37);
        contentPane.add(btnEliminar);
        
        JLabel lblMisRecetas = new JLabel("Mis Cursos");
        lblMisRecetas.setFont(new Font("Leelawadee UI", Font.BOLD, 28));
        lblMisRecetas.setBounds(303, 29, 176, 44);
        contentPane.add(lblMisRecetas);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaHomeChef homeChef = new PantallaHomeChef(perfil);
                homeChef.setVisible(true);
                dispose();
            }
        });
        btnVolver.setForeground(new Color(255, 255, 255));
        btnVolver.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
        btnVolver.setBackground(new Color(192, 192, 192));
        btnVolver.setBounds(15, 29, 87, 37);
        contentPane.add(btnVolver);

        // Configuración del modelo de selección
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
     		mostrarCursosDeUsuarioLocal();

    }
	
	private void mostrarCursosDeUsuarioLocal() {
	    model.setRowCount(0);
	    List<Cursos> cursos = controlador.getAllCursos();
	
	    for (Cursos curso : cursos) {
	        if (curso.getIdUsuario() == perfil.getIdUsuario()) {
	        	Object fila[] = { curso.getIdCurso(), curso.getTitulo(), curso.getLugar(), curso.getDia().toString(),
						curso.getCupo(), curso.getPrecio(), curso.getHorario().toString() };
	            model.addRow(fila);
	        }
	    }
	}
	private void actualizarTabla() {
        mostrarCursosDeUsuarioLocal();
    } 
        
}

