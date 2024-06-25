package Vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import Controladores.RecetaControlador;
import Modelos.Perfil;
import Modelos.Receta;

public class PantallaMisRecetas extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private RecetaControlador controlador;
    private Perfil perfilActual;
    private JLabel elemento;
    private Receta seleccionado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Receta receta = new Receta(1, "Nombre", "Procedimiento", "Categorias", "Ingredientes",
                            LocalDate.now(), 1);

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

    public PantallaMisRecetas(Perfil perfil) {
        this.perfilActual = perfil;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1002, 665);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Inicialización del controlador de recetas
        controlador = new RecetaControlador();
        seleccionado = new Receta(0, "", "", "", "", LocalDate.now(), 0);

        // Configuración de la tabla y modelo
        String[] columnNames = { "ID", "Título", "Procedimiento", "Categorías", "Ingredientes", "Fecha" };
        model = new DefaultTableModel(columnNames, 0);

        JButton btnEditarReceta = new JButton("Editar Receta");
        btnEditarReceta.setForeground(Color.BLACK);
        btnEditarReceta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (seleccionado.getIdReceta() != 0) {
                    PantallaEditarReceta pantallaEditarReceta = new PantallaEditarReceta(seleccionado, perfilActual);
                    pantallaEditarReceta.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una receta");
                }
            }
        });
        btnEditarReceta.setFont(new Font("Lucida Console", Font.BOLD, 16));
        btnEditarReceta.setBackground(new Color(255, 153, 153));
        btnEditarReceta.setBounds(711, 538, 198, 30);
        contentPane.add(btnEditarReceta);

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(61, 146, 856, 350);
        contentPane.add(scrollPane);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Lucida Console", Font.BOLD, 16));
        btnEliminar.setForeground(Color.BLACK);
        btnEliminar.setBackground(new Color(255, 153, 153));
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (seleccionado.getIdReceta() != 0) {
                    controlador.deleteReceta(seleccionado.getIdReceta());
                    JOptionPane.showMessageDialog(null, "Receta eliminada");
                    actualizarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una receta");
                }
            }
        });
        btnEliminar.setBounds(61, 538, 198, 30);
        contentPane.add(btnEliminar);

        JLabel lblMisRecetas = new JLabel("Mis Recetas");
        lblMisRecetas.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMisRecetas.setForeground(Color.WHITE);
        lblMisRecetas.setFont(new Font("Lucida Console", Font.BOLD, 20));
        lblMisRecetas.setBounds(818, 11, 155, 36);
        contentPane.add(lblMisRecetas);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaHomeChef homeChef = new PantallaHomeChef(perfilActual);
                homeChef.setVisible(true);
                dispose();
            }
        });
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setFont(new Font("Lucida Console", Font.BOLD, 16));
        btnVolver.setBackground(new Color(255, 255, 204));
        btnVolver.setBounds(15, 11, 116, 30);
        contentPane.add(btnVolver);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 204, 0));
        panel_2.setBounds(81, 167, 856, 344);
        contentPane.add(panel_2);
        
        JPanel panel_2_1 = new JPanel();
        panel_2_1.setBackground(new Color(255, 153, 153));
        panel_2_1.setBounds(61, 80, 853, 46);
        contentPane.add(panel_2_1);
        
                elemento = new JLabel("Seleccionado:");
                elemento.setForeground(Color.BLACK);
                panel_2_1.add(elemento);
                elemento.setFont(new Font("Lucida Console", Font.PLAIN, 10));
                
                JPanel panel_1_1_1_2 = new JPanel();
                panel_1_1_1_2.setBackground(new Color(204, 0, 51));
                panel_1_1_1_2.setBounds(71, 90, 855, 46);
                contentPane.add(panel_1_1_1_2);
                
                JPanel panel_1_1_1 = new JPanel();
                panel_1_1_1.setBackground(new Color(204, 0, 51));
                panel_1_1_1.setBounds(71, 548, 198, 30);
                contentPane.add(panel_1_1_1);
                
                JPanel panel_1_1_1_1 = new JPanel();
                panel_1_1_1_1.setBackground(new Color(204, 0, 51));
                panel_1_1_1_1.setBounds(721, 548, 198, 30);
                contentPane.add(panel_1_1_1_1);

        // Configuración del modelo de selección
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Listener de selección
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

        mostrarRecetasDeUsuarioLocal();
    }

    private void mostrarRecetasDeUsuarioLocal() {
        model.setRowCount(0);
        List<Receta> recetas = controlador.getAllRecetas();

        for (Receta receta : recetas) {
            if (receta.getIdUsuario() == perfilActual.getIdUsuario()) {
                Object[] fila = { receta.getIdReceta(), receta.getTitulo(), receta.getProcedimiento(),
                        receta.getCategorias(), receta.getIngredientes(), receta.getFecha() };
                model.addRow(fila);
            }
        }
    }

    private void actualizarTabla() {
        mostrarRecetasDeUsuarioLocal();
    }
}
