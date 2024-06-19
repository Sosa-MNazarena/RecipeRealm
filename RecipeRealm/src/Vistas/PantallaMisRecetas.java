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
                    Perfil perfil = new Perfil(1, "Nombre", "Pseudónimo", "correo@example.com", "contraseña", "Descripción", true);
                    PantallaMisRecetas frame = new PantallaMisRecetas(perfil);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PantallaMisRecetas(Perfil perfil) {
        this.perfilActual = perfil;  // Asignación del perfil actual
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Inicialización del controlador de recetas
        controlador = new RecetaControlador();
        seleccionado = new Receta(0, "", "", "", "", LocalDate.now(), 0);

        // Configuración de la tabla y modelo
        String[] columnNames = { "ID", "Título", "Procedimiento", "Categorías", "Ingredientes", "Fecha" };
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(15, 131, 756, 378);
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
                if (seleccionado.getIdReceta() != 0) {
                    controlador.deleteReceta(seleccionado.getIdReceta());
                    JOptionPane.showMessageDialog(null, "Receta eliminada");
                    actualizarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una receta");
                }
            }
        });
        btnEliminar.setBounds(588, 520, 183, 37);
        contentPane.add(btnEliminar);

        JLabel lblMisRecetas = new JLabel("Mis Recetas");
        lblMisRecetas.setFont(new Font("Leelawadee UI", Font.BOLD, 28));
        lblMisRecetas.setBounds(303, 29, 176, 44);
        contentPane.add(lblMisRecetas);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaHomeChef homeChef = new PantallaHomeChef(perfilActual);
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

        mostrarRecetasDeUsuarioLocal("");
        
        this.setVisible(true);
    }

    private void mostrarRecetasDeUsuarioLocal(String criterio) {
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
        mostrarRecetasDeUsuarioLocal(""); 
    }
}