package Vistas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JDesktopPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import Controladores.CursoControlador;
import Modelos.Perfil;
import Modelos.Cursos;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JTextField;


public class PantallaVerCurso extends JFrame {
	

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Cursos curso;
    private Perfil perfil;
    
    private JTable tableComentarios;
    private DefaultTableModel tableModel;
    private JComboBox<Integer> comboEstrella;
    private JTextField inputComentario;
    private final JDesktopPane desktopPane_1 = new JDesktopPane();

    /**
     * Launch the application.
     */
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
    public PantallaVerCurso(Cursos curso, Perfil perfil) {
    	this.curso = curso;
        this.perfil = perfil;
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 856, 610);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        //fuera de las pestañas
        //boton volver
        JButton btnVolver = new JButton("Cursos");
        btnVolver.setBackground(new Color(255, 255, 204));
        btnVolver.setBounds(10, 11, 131, 23);
        btnVolver.setFont(new Font("Lucida Console", Font.PLAIN, 16));
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TablaCursos tablaCursos = new TablaCursos(perfil);
                tablaCursos.setVisible(true);
                dispose();
            }
        });
        desktopPane_1.setBounds(54, 81, 731, 409);
        contentPane.add(desktopPane_1);
        desktopPane_1.setBackground(Color.LIGHT_GRAY);
        
        JTextArea txtLugar = new JTextArea(curso.getLugar());
        txtLugar.setWrapStyleWord(true);
        txtLugar.setLineWrap(true);
        txtLugar.setFont(new Font("Courier New", Font.PLAIN, 14));
        txtLugar.setEditable(false);
        txtLugar.setBackground(new Color(255, 255, 204));
        txtLugar.setBounds(47, 281, 442, 58);
        desktopPane_1.add(txtLugar);
        
        JPanel panel_1_2_1_1 = new JPanel();
        panel_1_2_1_1.setForeground(new Color(51, 51, 0));
        panel_1_2_1_1.setBackground(new Color(255, 255, 204));
        panel_1_2_1_1.setBounds(36, 272, 464, 77);
        desktopPane_1.add(panel_1_2_1_1);
        
        JTextArea txtPrecio = new JTextArea(String.valueOf(curso.getPrecio()));
        txtPrecio.setWrapStyleWord(true);
        txtPrecio.setLineWrap(true);
        txtPrecio.setFont(new Font("Courier New", Font.PLAIN, 12));
        txtPrecio.setEditable(false);
        txtPrecio.setBackground(new Color(255, 255, 204));
        txtPrecio.setBounds(553, 282, 125, 46);
        desktopPane_1.add(txtPrecio);
        
        JLabel lblLugar = new JLabel("Lugar:");
        lblLugar.setForeground(Color.BLACK);
        lblLugar.setFont(new Font("Lucida Console", Font.PLAIN, 14));
        lblLugar.setBounds(36, 250, 107, 20);
        desktopPane_1.add(lblLugar);
        
        JPanel panel_1_1_2 = new JPanel();
        panel_1_1_2.setForeground(new Color(51, 51, 0));
        panel_1_1_2.setBackground(new Color(255, 204, 51));
        panel_1_1_2.setBounds(47, 281, 464, 84);
        desktopPane_1.add(panel_1_1_2);
        
        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setForeground(Color.BLACK);
        lblPrecio.setFont(new Font("Lucida Console", Font.PLAIN, 14));
        lblPrecio.setBackground(Color.WHITE);
        lblPrecio.setBounds(542, 250, 118, 20);
        desktopPane_1.add(lblPrecio);
        
        JPanel panel_1_2_4 = new JPanel();
        panel_1_2_4.setForeground(new Color(51, 51, 0));
        panel_1_2_4.setBackground(new Color(255, 255, 204));
        panel_1_2_4.setBounds(542, 272, 148, 66);
        desktopPane_1.add(panel_1_2_4);
        
        JPanel panel_1_4 = new JPanel();
        panel_1_4.setForeground(new Color(51, 51, 0));
        panel_1_4.setBackground(new Color(255, 204, 0));
        panel_1_4.setBounds(553, 282, 148, 66);
        desktopPane_1.add(panel_1_4);
        
        JLabel lblFecha = new JLabel("Fecha del curso:");
        lblFecha.setForeground(Color.BLACK);
        lblFecha.setFont(new Font("Lucida Console", Font.PLAIN, 14));
        lblFecha.setBackground(Color.WHITE);
        lblFecha.setBounds(36, 141, 148, 20);
        desktopPane_1.add(lblFecha);
        
        JTextArea txtFecha = new JTextArea(String.valueOf(curso.getDia()));
        txtFecha.setWrapStyleWord(true);
        txtFecha.setLineWrap(true);
        txtFecha.setFont(new Font("Courier New", Font.PLAIN, 12));
        txtFecha.setEditable(false);
        txtFecha.setBackground(new Color(255, 255, 204));
        txtFecha.setBounds(47, 168, 125, 46);
        desktopPane_1.add(txtFecha);
        
        JPanel panel_1_2_3_1 = new JPanel();
        panel_1_2_3_1.setForeground(new Color(51, 51, 0));
        panel_1_2_3_1.setBackground(new Color(255, 255, 204));
        panel_1_2_3_1.setBounds(36, 158, 148, 66);
        desktopPane_1.add(panel_1_2_3_1);
        
        JPanel panel_1_3_1 = new JPanel();
        panel_1_3_1.setForeground(new Color(51, 51, 0));
        panel_1_3_1.setBackground(new Color(255, 204, 0));
        panel_1_3_1.setBounds(47, 168, 148, 66);
        desktopPane_1.add(panel_1_3_1);
        
        JLabel lblCupo = new JLabel("Cupos disponibles:");
        lblCupo.setForeground(Color.BLACK);
        lblCupo.setFont(new Font("Lucida Console", Font.PLAIN, 14));
        lblCupo.setBackground(Color.BLACK);
        lblCupo.setBounds(542, 141, 148, 20);
        desktopPane_1.add(lblCupo);
        
        JTextArea txtCupo = new JTextArea(String.valueOf(curso.getCupo()));
        txtCupo.setWrapStyleWord(true);
        txtCupo.setLineWrap(true);
        txtCupo.setEditable(false);
        txtCupo.setBackground(new Color(255, 255, 204));
        txtCupo.setBounds(544, 169, 105, 22);
        desktopPane_1.add(txtCupo);
        
        JPanel panel_1_2_2_1 = new JPanel();
        panel_1_2_2_1.setForeground(new Color(51, 51, 0));
        panel_1_2_2_1.setBackground(new Color(255, 255, 204));
        panel_1_2_2_1.setBounds(542, 166, 148, 25);
        desktopPane_1.add(panel_1_2_2_1);
        
        JLabel lblTitulo = new JLabel(curso.getTitulo());
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setForeground(new Color(204, 51, 0));
        lblTitulo.setFont(new Font("Lucida Console", Font.BOLD, 24));
        lblTitulo.setBackground(new Color(255, 255, 204));
        lblTitulo.setBounds(57, 23, 621, 84);
        desktopPane_1.add(lblTitulo);
        
        JTextArea txtHorario = new JTextArea(String.valueOf(curso.getHorario()));
        txtHorario.setWrapStyleWord(true);
        txtHorario.setLineWrap(true);
        txtHorario.setFont(new Font("Courier New", Font.PLAIN, 12));
        txtHorario.setEditable(false);
        txtHorario.setBackground(new Color(255, 255, 204));
        txtHorario.setBounds(285, 168, 125, 46);
        desktopPane_1.add(txtHorario);
        
        JLabel lblHorario = new JLabel("Horario del curso:");
        lblHorario.setForeground(Color.BLACK);
        lblHorario.setFont(new Font("Lucida Console", Font.PLAIN, 14));
        lblHorario.setBackground(Color.WHITE);
        lblHorario.setBounds(274, 141, 148, 20);
        desktopPane_1.add(lblHorario);
        
        JPanel panel_1_2_3_1_1 = new JPanel();
        panel_1_2_3_1_1.setForeground(new Color(51, 51, 0));
        panel_1_2_3_1_1.setBackground(new Color(255, 255, 204));
        panel_1_2_3_1_1.setBounds(274, 158, 148, 66);
        desktopPane_1.add(panel_1_2_3_1_1);
        
        JPanel panel_1_3_1_1 = new JPanel();
        panel_1_3_1_1.setForeground(new Color(51, 51, 0));
        panel_1_3_1_1.setBackground(new Color(255, 204, 0));
        panel_1_3_1_1.setBounds(285, 168, 148, 66);
        desktopPane_1.add(panel_1_3_1_1);
        contentPane.add(btnVolver);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(204, 0, 0));
        panel.setBounds(73, 102, 731, 409);
        contentPane.add(panel);
        
        JButton btnTusInscripciones = new JButton("Tus Inscripciones");
        btnTusInscripciones.setFont(new Font("Lucida Console", Font.PLAIN, 16));
        btnTusInscripciones.setBackground(new Color(255, 255, 204));
        		if (!perfil.isVerificado()) {
        			btnTusInscripciones.setVisible(true);
        			btnTusInscripciones.addActionListener(new ActionListener() {
        				public void actionPerformed(ActionEvent e) {
        					Cursos curso = new Cursos(1, "", 1, "", LocalDate.now(), 20, 100.0,
        							LocalTime.now());
        			        TablaCursosInscriptos pantallaTusCursos = new TablaCursosInscriptos(perfil);
        			        pantallaTusCursos.setVisible(true);
        			        dispose();
        				}
        			});
                } else {
                	btnTusInscripciones.setVisible(false);
                }
        btnTusInscripciones.setBounds(159, 12, 213, 23);
        contentPane.add(btnTusInscripciones);
        
        
        
    }
}
