package Vistas;

import java.awt.Color;
import java.awt.EventQueue;
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

import Controladores.RecetaControlador;
import Modelos.Receta;

public class TablaReceta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private RecetaControlador controlador;
	private JLabel elemento;
	private Receta seleccionado;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TablaReceta frame = new TablaReceta();
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
	public TablaReceta() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//inicializar controlador
		controlador = new RecetaControlador();
		seleccionado = new Receta(1, "Ejemplo de Receta", "Procedimiento ejemplo", null, 0, 0, null, null, null, null, new java.util.Date(), null, null);

		
		//tabla y modelito
		String[] columnNames = { "ID", "Título", "Procedimiento", "Nro ingredientes", "Id Usuario", "Id Reseña", "Fecha" };
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
			btnEliminar.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
			btnEliminar.setForeground(new Color(255, 255, 255));
			btnEliminar.setBackground(new Color(0, 0, 0));
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (seleccionado.getIdReceta() != 0) {
						controlador.deleteReceta(seleccionado.getIdReceta());
						JOptionPane.showMessageDialog(null, "Eliminado");
						actualizarTabla();
					} else {
						JOptionPane.showMessageDialog(null, "Seleccione una receta");
					}
				}
			});
			btnEliminar.setBounds(515, 304, 356, 37);
		    contentPane.add(btnEliminar);
			
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBounds(15, 220, 101, 22);
			contentPane.add(menuBar);
			
			JLabel lblNewLabel = new JLabel("Recetas");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 17));
			lblNewLabel.setBounds(292, 11, 277, 38);
			contentPane.add(lblNewLabel);
			
			JButton btnEditar = new JButton("Editar");
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnEditar.setForeground(Color.WHITE);
			btnEditar.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
			btnEditar.setBackground(Color.BLACK);
			btnEditar.setBounds(15, 304, 356, 37);
			contentPane.add(btnEditar);

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
				            String procedimiento = (String) table.getValueAt(selectedRow, 2);
				            int nroIngredientes = (int) table.getValueAt(selectedRow, 3);
				            int idUsuario = (int) table.getValueAt(selectedRow, 4);
				            int idResena = (int) table.getValueAt(selectedRow, 5);
				            String fecha = (String) table.getValueAt(selectedRow, 6);


							 elemento.setText("Seleccionado: ID=" + id + ", Título=" + titulo + ", Procedimiento=" + procedimiento +
		                                ", NroIngredientes=" + nroIngredientes + ", IdUsuario=" + idUsuario + ", IdResena=" + idResena +
		                                ", Fecha=" + fecha);
							
							 seleccionado.setIdReceta(id);
		                        seleccionado.setTitulo(titulo);
		                        seleccionado.setProcedimiento(procedimiento);
		                        seleccionado.setnroIngredientes(nroIngredientes);
		                        seleccionado.setIdUsuario(null);
		                        seleccionado.setIdResena(null);
		                        seleccionado.setFecha(LocalDate.parse(fecha)); 
		                    }
					}
				}
			});
	}
	private void actualizarTabla() {
		// limpia
		model.setRowCount(0);
				
		// lista nueva
		List<Receta> receta = controlador.getAllRecetas();

		// agrega datos
		for (Receta receta : recetas) {
		    model.addRow(new Object[]{
		        receta.getIdReceta(), 
		        receta.getTitulo(), 
		        receta.getProcedimiento(),
		        receta.getnroIngredientes(), 
		        receta.getIdUsuario(), 
		        receta.getIdResena(), 
		        receta.getFecha().toString()
		    });
		}
	}

}
