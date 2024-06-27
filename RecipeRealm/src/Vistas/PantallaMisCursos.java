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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controladores.CursoControlador;
import Modelos.Cursos;
import Modelos.Perfil;

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
                    Cursos curso = new Cursos(1, "", 1, "", LocalDate.now(), 20, 100.0, LocalTime.now());

                    Perfil perfil = new Perfil(1, "Nombre", "Pseudónimo", "correo@example.com", "contraseña",
                            "Descripción", true);
                    PantallaMisCursos frame = new PantallaMisCursos(perfil);
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
        setBounds(100, 100, 1002, 665);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Inicialización del controlador de cursos
        controlador = new CursoControlador();
        seleccionado = new Cursos(1, "", 1, "", LocalDate.now(), 20, 100.0, LocalTime.now());

        // Configuración de la tabla y modelo
        String[] columnNames = { "ID", "Título", "Lugar", "Día", "Horario", "Cupo", "Precio" };
        model = new DefaultTableModel(columnNames, 0);

        JButton btnEditarCurso = new JButton("Editar curso");
        btnEditarCurso.setForeground(Color.BLACK);
        btnEditarCurso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (seleccionado.getIdCurso() != 0) {
                    PantallaEditarCurso pantallaEditarCurso = new PantallaEditarCurso(seleccionado, perfil);
                    pantallaEditarCurso.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un curso");
                }
            }
        });
        btnEditarCurso.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
        btnEditarCurso.setBackground(new Color(255, 153, 153));
        btnEditarCurso.setBounds(711, 538, 198, 30);
        contentPane.add(btnEditarCurso);

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(61, 147, 856, 350);
        contentPane.add(scrollPane);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
        btnEliminar.setForeground(Color.BLACK);
        btnEliminar.setBackground(new Color(255, 153, 153));
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (seleccionado.getIdCurso() != 0) {
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar este curso?",
                            "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (opcion == JOptionPane.YES_OPTION) {
                        controlador.deleteCurso(seleccionado.getIdCurso());
                        JOptionPane.showMessageDialog(null, "Curso eliminado correctamente");
                        actualizarTabla();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un curso");
                }
            }
        });
        btnEliminar.setBounds(61, 538, 198, 30);
        contentPane.add(btnEliminar);

        JLabel lblMisCursos = new JLabel("Mis Cursos");
        lblMisCursos.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMisCursos.setForeground(Color.WHITE);
        lblMisCursos.setFont(new Font("Lucida Console", Font.BOLD, 20));
        lblMisCursos.setBounds(818, 11, 155, 36);
        contentPane.add(lblMisCursos);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaHomeChef homeChef = new PantallaHomeChef(perfil);
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
        panel_2_1.add(elemento);
        elemento.setFont(new Font("Lucida Console", Font.PLAIN, 10));

        JPanel panel_1_1_1 = new JPanel();
        panel_1_1_1.setBackground(new Color(204, 0, 51));
        panel_1_1_1.setBounds(71, 548, 198, 30);
        contentPane.add(panel_1_1_1);

        JPanel panel_1_1_1_1 = new JPanel();
        panel_1_1_1_1.setBackground(new Color(204, 0, 51));
        panel_1_1_1_1.setBounds(721, 548, 198, 30);
        contentPane.add(panel_1_1_1_1);

        JPanel panel_1_1_1_2 = new JPanel();
        panel_1_1_1_2.setBackground(new Color(204, 0, 51));
        panel_1_1_1_2.setBounds(71, 90, 855, 46);
        contentPane.add(panel_1_1_1_2);

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

                        elemento.setText("Seleccionado: ID=" + id + ", Título=" + titulo + ", Lugar=" + lugar
                                + ", Fecha=" + fecha + ", Cupo=" + cupo + ", Precio=" + precio + ", Horario="
                                + horario);

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
