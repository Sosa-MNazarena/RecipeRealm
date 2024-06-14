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
    private Perfil perfilActual;
    private JLabel elemento;
    private Receta seleccionado;

    
    public TablaFavoritos(Perfil perfil) {
    	this.setVisible(true);
        this.perfilActual = perfil;
        controlador = new FavoritoControlador();
        seleccionado = new Receta(0, "", "", LocalDate.now());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1095, 704);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        String[] columnNames = { "ID", "Título", "Procedimiento" };
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        actualizarTabla();

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(106, 186, 856, 190);
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

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
        btnEliminar.setBackground(Color.BLACK);
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int idReceta = (int) table.getValueAt(selectedRow, 0);
                    Receta recetaSeleccionada = new Receta(idReceta, "Titulo", "Procedimiento", LocalDate.now());
                    recetaSeleccionada.setIdReceta(idReceta);
                    perfilActual.removeFavorito(recetaSeleccionada);
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

                        elemento.setText(
                                "Seleccionado: ID=" + id + ", Título=" + titulo + ", Procedimiento=" + procedimiento);

                        seleccionado.setIdReceta(id);
                        seleccionado.setTitulo(titulo);
                        seleccionado.setProcedimiento(procedimiento);
                    }
                }
            }
        });
    }

    private void actualizarTabla() {
        model.setRowCount(0);
        List<Receta> favoritos = controlador.getFavoritosByUsuario(perfilActual.getIdUsuario());

        for (Receta receta : favoritos) {
            Object[] fila = {
                receta.getIdReceta(),
                receta.getTitulo(),
                receta.getProcedimiento()
            };
            model.addRow(fila);
        }
    }
}
