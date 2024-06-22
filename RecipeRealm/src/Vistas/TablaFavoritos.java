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

public class TablaFavoritos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private FavoritoControlador controlador;
    private Perfil perfil;
    private JLabel elemento;
    private Receta seleccionado;

    
    public TablaFavoritos(Perfil perfil) {
    	this.setVisible(true);
        this.perfil = perfil;
        controlador = new FavoritoControlador();
        seleccionado = new Receta(0, "", "", "", "", LocalDate.now(), 0);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1095, 704);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        String[] columnNames = { "ID", "Título", "Procedimiento", "Categorías", "Ingredientes", "Fecha"  };
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        actualizarTabla();

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(106, 178, 856, 190);
        contentPane.add(scrollPane);

        elemento = new JLabel("Seleccionado:");
        elemento.setFont(new Font("Leelawadee UI", Font.PLAIN, 14));
        elemento.setBounds(106, 128, 911, 14);
        contentPane.add(elemento);

        JLabel lblNewLabel = new JLabel("Mis Favoritos");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 17));
        lblNewLabel.setBounds(389, 56, 277, 38);
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
        btnVolver.setForeground(new Color(255, 255, 255));
        btnVolver.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
        btnVolver.setBackground(new Color(192, 192, 192));
        btnVolver.setBounds(15, 11, 87, 37);
        contentPane.add(btnVolver);
        
        JButton btnVer = new JButton("Ver Receta");
        btnVer.setForeground(Color.WHITE);
        btnVer.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
        btnVer.setBackground(Color.LIGHT_GRAY);
        btnVer.setBounds(615, 537, 155, 37);
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
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
        btnEliminar.setBackground(Color.BLACK);
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
        btnEliminar.setBounds(606, 463, 356, 37);
        contentPane.add(btnEliminar);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(15, 220, 101, 22);
        contentPane.add(menuBar);

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
