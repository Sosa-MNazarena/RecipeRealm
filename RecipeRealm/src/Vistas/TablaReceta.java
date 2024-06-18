package Vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Modelos.Perfil;
import Controladores.FavoritoControlador;
import Controladores.RecetaControlador;
import Modelos.Receta;

public class TablaReceta extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private RecetaControlador controlador;
    private FavoritoControlador favControlador;
    private Perfil perfilActual;
    private JLabel elemento;
    private Receta seleccionado;
    private JTextField txtBusqueda;	private Perfil perfil;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Perfil perfil = new Perfil(1, "Nombre", "Pseudónimo", "correo@example.com", "contraseña",
                            "Descripción", true);
                    TablaReceta frame = new TablaReceta(perfil);
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
	public TablaReceta(Perfil perfil) {
		this.setVisible(true);
		this.perfil = perfil;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(15, 131, 856, 190);
        contentPane.add(scrollPane);

		// inicializar controlador
		controlador = new RecetaControlador();
		favControlador = new FavoritoControlador();
		seleccionado = new Receta(0, "", "", "", "", LocalDate.now());
    // tabla y modelito
        String[] columnNames = { "ID", "Título", "Procedimiento", "Categorías", "Ingredientes", "Fecha" };
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        actualizarTabla();
        elemento = new JLabel("Seleccionado:");
        elemento.setFont(new Font("Leelawadee UI", Font.PLAIN, 14));
        elemento.setBounds(15, 95, 911, 14);
        contentPane.add(elemento);

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
        btnEliminar.setBounds(647, 464, 224, 37);
        contentPane.add(btnEliminar);

        JLabel lblRecetas = new JLabel("Recetas");
        lblRecetas.setFont(new Font("Leelawadee UI", Font.BOLD, 28));
        lblRecetas.setBounds(380, 29, 101, 44);
        contentPane.add(lblRecetas);
        JButton btnAddFavorito = new JButton("Agregar a favorito");
		btnAddFavorito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (seleccionado.getIdReceta() != 0) {
					favControlador.addFavorito(perfil, seleccionado.getIdReceta());
					JOptionPane.showMessageDialog(null, "Agregado a favoritos");
					actualizarTabla();
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione una receta");
				}
			}
		});
		btnAddFavorito.setForeground(Color.WHITE);
		btnAddFavorito.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
		btnAddFavorito.setBackground(Color.BLACK);
		btnAddFavorito.setBounds(336, 363, 233, 37);
		contentPane.add(btnAddFavorito);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaHomeChef homeChef = new PantallaHomeChef(perfil);
				homeChef.setVisible(true);
				dispose();
			}
		});


        // campo de búsqueda y botón de búsqueda
        txtBusqueda = new JTextField();
        txtBusqueda.setBounds(15, 382, 287, 37);
        contentPane.add(txtBusqueda);
        txtBusqueda.setColumns(10);

        JButton btnBuscar = new JButton("Buscar por Nombre");
        btnBuscar.setBackground(new Color(255, 255, 255));
        btnBuscar.setForeground(new Color(0, 0, 0));
        btnBuscar.setFont(new Font("Leelawadee UI", Font.PLAIN, 14));
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String criterio = txtBusqueda.getText();
                buscarReceta(criterio);
            }
        });
        btnBuscar.setBounds(312, 382, 169, 37);
        contentPane.add(btnBuscar);
       // Configurar el modelo de selección
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);



        // escuchador de selección
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        int id = (int) table.getValueAt(selectedRow, 0);
                        String titulo = (String) table.getValueAt(selectedRow, 1);
                        String procedimiento = (String) table.getValueAt(selectedRow, 2);
                        String categorias = (String) table.getValueAt(selectedRow, 3);
                        String ingredientes = (String) table.getValueAt(selectedRow, 4);
                        elemento.setText("Seleccionado: ID=" + id + ", Título=" + titulo + ", Procedimiento="
                                + procedimiento + ", Categorías=" + categorias + " , Ingredientes=" + ingredientes);

                        seleccionado.setIdReceta(id);
                        seleccionado.setTitulo(titulo);
                        seleccionado.setProcedimiento(procedimiento);
                        seleccionado.setCategorias(categorias);
                        seleccionado.setIngredientes(ingredientes);
                    }
                }
            }
        });
    }

    private void actualizarTabla() {
        model.setRowCount(0); // Limpiar todas las filas
        List<Receta> recetas = controlador.getAllRecetas();

        for (Receta receta : recetas) {
            Object[] fila = { receta.getIdReceta(), receta.getTitulo(), receta.getProcedimiento(), receta.getCategorias(),
                    receta.getIngredientes(), receta.getFecha() };
            model.addRow(fila);
        }
    }

    private void buscarReceta(String criterio) {
        model.setRowCount(0);
        List<Receta> recetas = controlador.getAllRecetas();

        for (Receta receta : recetas) {
            if (receta.getTitulo().toLowerCase().contains(criterio.toLowerCase())) {
                Object[] fila = { receta.getIdReceta(), receta.getTitulo(), receta.getProcedimiento(),
                        receta.getCategorias(), receta.getIngredientes(), receta.getFecha() };
                model.addRow(fila);
            }
        }
    }
}
