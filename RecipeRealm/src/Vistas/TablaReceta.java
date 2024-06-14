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
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import Controladores.RecetaControlador;
import Modelos.Ingrediente;
import Modelos.Receta;

public class TablaReceta extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private RecetaControlador controlador;
    private JLabel elemento;
    private Receta seleccionado;
    
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

    public TablaReceta() {
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 894, 422);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        controlador = new RecetaControlador();
        seleccionado = new Receta(0, "", "", LocalDate.now());
        
        String[] columnNames = { "ID", "Título", "Procedimiento", "Categorías", "Ingredientes" };
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        actualizarTabla(); 

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(15, 73, 856, 190);
        contentPane.add(scrollPane);

        elemento = new JLabel("Seleccionado:");
        elemento.setFont(new Font("Leelawadee UI", Font.PLAIN, 14));
        elemento.setBounds(15, 52, 911, 14);
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
        btnEliminar.setBounds(515, 304, 356, 37);
        contentPane.add(btnEliminar);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(15, 220, 101, 22);
        contentPane.add(menuBar);
        
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
        
        JLabel lblRecetas = new JLabel("Recetas");
        lblRecetas.setFont(new Font("Leelawadee UI", Font.PLAIN, 28));
        lblRecetas.setBounds(380, 11, 101, 44);
        contentPane.add(lblRecetas);

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

                        elemento.setText("Seleccionado: ID=" + id + 
                                         ", Título=" + titulo + 
                                         ", Procedimiento=" + procedimiento +
                                         ", Categorías=" + categorias + 
                                         ", Ingredientes=" + ingredientes);

                        seleccionado.setIdReceta(id);
                        seleccionado.setTitulo(titulo);
                        seleccionado.setProcedimiento(procedimiento);
                        // Handle categorias and ingredientes if needed
                    }
                }
            }
        });
    }

    private void actualizarTabla() {
        model.setRowCount(0);
        List<Receta> recetas = controlador.getAllRecetas();

        for (Receta receta : recetas) {
            // Construir la cadena de ingredientes con sus cantidades
            StringBuilder ingredientes = new StringBuilder();
            for (Ingrediente ingrediente : receta.getIngredientes()) {
                if (ingredientes.length() > 0) {
                    ingredientes.append(", ");
                }
                ingredientes.append(ingrediente.getNombre());
                Double cantidad = ingrediente.getCantidad();
                if (cantidad != null) {
                    ingredientes.append(" - ").append(cantidad.toString());
                }
            }

            String categorias = String.join(", ", receta.getCategorias());

            Object[] fila = {
                receta.getIdReceta(),
                receta.getTitulo(),
                receta.getProcedimiento(),
                categorias,
                ingredientes.toString()
            };
            model.addRow(fila);
        }
    }


}
