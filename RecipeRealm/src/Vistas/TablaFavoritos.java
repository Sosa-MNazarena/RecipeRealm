package Vistas;

import java.awt.EventQueue;
import java.awt.Color;
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
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import Controladores.FavoritoControlador;
import Modelos.Perfil;
import Modelos.Receta;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class TablaFavoritos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private FavoritoControlador controlador;
    private Perfil perfil;
    private JLabel elemento;
    private Receta seleccionado;
    private JTextField textField;

    
    public TablaFavoritos(Perfil perfil) {
    	this.setVisible(true);
        this.perfil = perfil;
        controlador = new FavoritoControlador();
        seleccionado = new Receta(0, "", "", "", "", LocalDate.now(), 0);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1002, 665);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        String[] columnNames = { "ID", "Título", "Procedimiento", "Categorías", "Ingredientes", "Fecha"  };
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        actualizarTabla();

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(63, 214, 856, 309);
        contentPane.add(scrollPane);

        JLabel lblNewLabel = new JLabel("Mis Favoritos");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setFont(new Font("Lucida Console", Font.BOLD, 20));
        lblNewLabel.setBounds(754, 11, 219, 36);
        contentPane.add(lblNewLabel);
        
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
        
        JButton btnVer = new JButton("Ver Receta");
        btnVer.setForeground(Color.BLACK);
        btnVer.setFont(new Font("Lucida Console", Font.BOLD, 14));
        btnVer.setBackground(new Color(255, 153, 153));
        btnVer.setBounds(721, 562, 198, 30);
        contentPane.add(btnVer);
        
        btnVer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (seleccionado.getIdReceta() != 0) {
                    PantallaVerRecetaComentarios verRecetaComentarios = new PantallaVerRecetaComentarios(seleccionado, perfil);
                    verRecetaComentarios.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una receta");
                }
            }
        });

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setForeground(Color.BLACK);
        btnEliminar.setFont(new Font("Lucida Console", Font.BOLD, 14));
        btnEliminar.setBackground(new Color(255, 153, 153));
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int idReceta = (int) table.getValueAt(selectedRow, 0);
                    Receta recetaSeleccionada = new Receta(idReceta, "Titulo", "Procedimiento", "Categorias", "Ingredientes", LocalDate.now(), 0);
                    recetaSeleccionada.setIdReceta(idReceta);
                    controlador.removeFavorito(perfil, idReceta);
                    JOptionPane.showMessageDialog(null, "Receta eliminada de favoritos.");
                    actualizarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una receta.");
                }
            }
        });
        btnEliminar.setBounds(63, 562, 198, 30);
        contentPane.add(btnEliminar);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(15, 220, 101, 22);
        contentPane.add(menuBar);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 204, 0));
        panel_2.setBounds(83, 236, 856, 309);
        contentPane.add(panel_2);
        
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBackground(new Color(204, 0, 51));
        panel_1_1.setBounds(724, 568, 203, 30);
        contentPane.add(panel_1_1);
        
        JPanel panel_1_1_1 = new JPanel();
        panel_1_1_1.setBackground(new Color(204, 0, 51));
        panel_1_1_1.setBounds(66, 568, 203, 30);
        contentPane.add(panel_1_1_1);
        
        JPanel panel_1_1_2 = new JPanel();
        panel_1_1_2.setForeground(Color.BLACK);
        panel_1_1_2.setBackground(new Color(255, 255, 204));
        panel_1_1_2.setBounds(63, 152, 853, 46);
        contentPane.add(panel_1_1_2);
        
                elemento = new JLabel("Seleccionado:");
                panel_1_1_2.add(elemento);
                elemento.setFont(new Font("Lucida Console", Font.PLAIN, 10));
                
                JLabel lblBuscarTituloTex = new JLabel("Buscar recetas por título:");
                lblBuscarTituloTex.setVerticalAlignment(SwingConstants.BOTTOM);
                lblBuscarTituloTex.setForeground(new Color(255, 153, 153));
                lblBuscarTituloTex.setFont(new Font("Lucida Console", Font.PLAIN, 14));
                lblBuscarTituloTex.setBounds(63, 70, 337, 22);
                contentPane.add(lblBuscarTituloTex);
                
                JLabel lblFiltrarPorCategora = new JLabel("Filtrar recetas por categoría:");
                lblFiltrarPorCategora.setVerticalAlignment(SwingConstants.BOTTOM);
                lblFiltrarPorCategora.setForeground(new Color(255, 153, 153));
                lblFiltrarPorCategora.setFont(new Font("Lucida Console", Font.PLAIN, 14));
                lblFiltrarPorCategora.setBounds(501, 70, 337, 22);
                contentPane.add(lblFiltrarPorCategora);
                
                JComboBox comboBox = new JComboBox();
                comboBox.setFont(new Font("Lucida Console", Font.PLAIN, 11));
                comboBox.setBounds(500, 94, 294, 30);
                contentPane.add(comboBox);
                
                JButton btnBuscar = new JButton("Buscar");
                btnBuscar.setForeground(Color.BLACK);
                btnBuscar.setFont(new Font("Lucida Console", Font.PLAIN, 12));
                btnBuscar.setBackground(new Color(255, 153, 153));
                btnBuscar.setBounds(360, 94, 130, 30);
                contentPane.add(btnBuscar);
                
                JButton btnFiltrar = new JButton("Filtrar");
                btnFiltrar.setForeground(Color.BLACK);
                btnFiltrar.setFont(new Font("Lucida Console", Font.PLAIN, 12));
                btnFiltrar.setBackground(new Color(255, 153, 153));
                btnFiltrar.setBounds(789, 94, 130, 30);
                contentPane.add(btnFiltrar);
                
                textField = new JTextField();
                textField.setColumns(10);
                textField.setBounds(63, 94, 300, 30);
                contentPane.add(textField);
                
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
        model.setRowCount(0);
        List<Receta> favoritos = controlador.getFavoritosByUsuario(perfil);

        for (Receta receta : favoritos) {
            Object[] fila = {
                receta.getIdReceta(),
                receta.getTitulo(),
                receta.getProcedimiento(),
                receta.getCategorias(),
                receta.getIngredientes(), 
                receta.getFecha()
            };
            model.addRow(fila);
        }
    }
}
