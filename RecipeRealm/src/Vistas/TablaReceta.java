package Vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Modelos.Perfil;
import Controladores.FavoritoControlador;
import Controladores.RecetaControlador;
import Modelos.Receta;
import javax.swing.SwingConstants;

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
    private JTextField txtBusqueda;

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
        this.perfilActual = perfil;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1002, 665);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // inicializar controlador
        controlador = new RecetaControlador();
        favControlador = new FavoritoControlador();
        seleccionado = new Receta(0, "", "", "", "", LocalDate.now(),0);

        // tabla y modelo
        String[] columnNames = { "ID", "Título", "Procedimiento", "Categorías", "Ingredientes", "Fecha" };
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        actualizarTabla();

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(63, 214, 856, 309);
        contentPane.add(scrollPane);

        JLabel lblRecetas = new JLabel("Recetas");
        lblRecetas.setHorizontalAlignment(SwingConstants.RIGHT);
        lblRecetas.setForeground(Color.WHITE);
        lblRecetas.setFont(new Font("Lucida Console", Font.BOLD, 20));
        lblRecetas.setBounds(818, 11, 155, 36);
        contentPane.add(lblRecetas);

        JButton btnAddFavorito = new JButton("Agregar a favorito");
        btnAddFavorito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (seleccionado.getIdReceta() != 0) {
					favControlador.addFavorito(perfil, seleccionado.getIdReceta());
					JOptionPane.showMessageDialog(null, "Agregado a favoritos");
					actualizarTabla();
				}else {
                    JOptionPane.showMessageDialog(null, "Seleccione una receta");
                }
            }
        });
        btnAddFavorito.setForeground(new Color(0, 0, 0));
        btnAddFavorito.setFont(new Font("Lucida Console", Font.BOLD, 14));
        btnAddFavorito.setBackground(new Color(255, 153, 153));
        btnAddFavorito.setBounds(63, 562, 198, 30);
        contentPane.add(btnAddFavorito);
        
        JButton btnMisRecetas = new JButton("Mis recetas");
        btnMisRecetas.setForeground(Color.BLACK);
		btnMisRecetas.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Receta receta = new Receta(1, "Nombre de la receta", "Descripción de la receta", "Categoría", "Ingredientes", LocalDate.now(), 1);

		        PantallaMisRecetas pantallaMisRecetas = new PantallaMisRecetas(perfil);
		        pantallaMisRecetas.setVisible(true);
		        dispose();
		    }
		});
		btnMisRecetas.setFont(new Font("Lucida Console", Font.BOLD, 16));
		btnMisRecetas.setBackground(new Color(255, 255, 204));
		btnMisRecetas.setBounds(136, 11, 155, 30);
		contentPane.add(btnMisRecetas);

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
        btnVolver.setForeground(new Color(0, 0, 0));
        btnVolver.setFont(new Font("Lucida Console", Font.BOLD, 16));
        btnVolver.setBackground(new Color(255, 255, 204));
        btnVolver.setBounds(15, 11, 116, 30);
        contentPane.add(btnVolver);

        // campo de búsqueda y botón de búsqueda
        txtBusqueda = new JTextField();
        txtBusqueda.setBounds(63, 93, 300, 30);
        contentPane.add(txtBusqueda);
        txtBusqueda.setColumns(10);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(new Color(255, 153, 153));
        btnBuscar.setForeground(new Color(0, 0, 0));
        btnBuscar.setFont(new Font("Lucida Console", Font.PLAIN, 12));
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String criterio = txtBusqueda.getText();
                buscarReceta(criterio);
            }
        });
        btnBuscar.setBounds(360, 93, 130, 30);
        contentPane.add(btnBuscar);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Lucida Console", Font.PLAIN, 11));
        comboBox.setBounds(500, 93, 294, 30);
        contentPane.add(comboBox);
        comboBox.addItem("Italia");
        comboBox.addItem("China");
        comboBox.addItem("México");
        comboBox.addItem("Argentina");
        comboBox.addItem("Brasil");
        comboBox.addItem("Colombia");
        comboBox.addItem("Dulces");
        comboBox.addItem("Japón");
        
        
       
        JButton btnFiltrar = new JButton("Filtrar");
        btnFiltrar.setBackground(new Color(255, 153, 153));
        btnFiltrar.setFont(new Font("Lucida Console", Font.PLAIN, 12));
        btnFiltrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		actualizarPorFiltro((String)comboBox.getSelectedItem());
        	}
        });
        btnFiltrar.setBounds(789, 93, 130, 30);
        contentPane.add(btnFiltrar);
        
        JButton btnVer = new JButton("Ver Receta");
        btnVer.setForeground(new Color(0, 0, 0));
        btnVer.setFont(new Font("Lucida Console", Font.BOLD, 14));
        btnVer.setBackground(new Color(255, 153, 153));
        btnVer.setBounds(721, 562, 198, 30);
        contentPane.add(btnVer);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 204, 0));
        panel_2.setBounds(83, 236, 856, 309);
        contentPane.add(panel_2);
        
        JPanel panel_2_1 = new JPanel();
        panel_2_1.setBackground(new Color(255, 255, 204));
        panel_2_1.setBounds(63, 152, 853, 46);
        contentPane.add(panel_2_1);
        
                elemento = new JLabel("Seleccionado:");
                panel_2_1.add(elemento);
                elemento.setVerticalAlignment(SwingConstants.TOP);
                elemento.setBackground(new Color(255, 255, 204));
                elemento.setHorizontalAlignment(SwingConstants.CENTER);
                elemento.setFont(new Font("Lucida Console", Font.PLAIN, 10));
                
                JPanel panel_1 = new JPanel();
                panel_1.setBackground(new Color(204, 0, 51));
                panel_1.setBounds(73, 102, 853, 30);
                contentPane.add(panel_1);
                
                JLabel lblBuscarTituloTex = new JLabel("Buscar recetas por título:");
                lblBuscarTituloTex.setVerticalAlignment(SwingConstants.BOTTOM);
                lblBuscarTituloTex.setForeground(new Color(255, 153, 153));
                lblBuscarTituloTex.setFont(new Font("Lucida Console", Font.PLAIN, 14));
                lblBuscarTituloTex.setBounds(63, 69, 337, 22);
                contentPane.add(lblBuscarTituloTex);
                
                JLabel lblFiltrarPorCategora = new JLabel("Filtrar recetas por categoría:");
                lblFiltrarPorCategora.setVerticalAlignment(SwingConstants.BOTTOM);
                lblFiltrarPorCategora.setForeground(new Color(255, 153, 153));
                lblFiltrarPorCategora.setFont(new Font("Lucida Console", Font.PLAIN, 14));
                lblFiltrarPorCategora.setBounds(501, 69, 337, 22);
                contentPane.add(lblFiltrarPorCategora);
                
                JPanel panel_1_1 = new JPanel();
                panel_1_1.setBackground(new Color(204, 0, 51));
                panel_1_1.setBounds(66, 568, 203, 30);
                contentPane.add(panel_1_1);
                
                JPanel panel_1_1_1 = new JPanel();
                panel_1_1_1.setBackground(new Color(204, 0, 51));
                panel_1_1_1.setBounds(724, 568, 203, 30);
                contentPane.add(panel_1_1_1);
        
        btnVer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (seleccionado.getIdReceta() != 0) {
                    PantallaVerRecetaComentarios verRecetaComentarios = new PantallaVerRecetaComentarios(seleccionado, perfilActual);
                    verRecetaComentarios.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una receta");
                }
            }
        });

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
    
    private void actualizarPorFiltro(String categoria) {
        model.setRowCount(0);
        List<Receta> recetas = controlador.getAllRecetas();

        for (Receta receta : recetas) {
            if (receta.getCategorias().toLowerCase().contains(categoria.toLowerCase())) {
                Object[] fila = { receta.getIdReceta(), receta.getTitulo(), receta.getProcedimiento(),
                        receta.getCategorias(), receta.getIngredientes(), receta.getFecha() };
                model.addRow(fila);
            }
        }
    }
}
