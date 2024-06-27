package Vistas;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.event.ActionEvent;
import javax.swing.*;
import com.toedter.calendar.JDateChooser; 

import Controladores.CursoControlador;
import Modelos.Perfil;
import Modelos.Cursos;

public class PantallaEditarCurso extends JFrame {

    private JPanel contentPane;
    private Cursos curso;
    private Perfil perfil;
    private CursoControlador controlador;
    private JTextField txtTitulo;
    private JTextField txtLugar;
    private JTextField txtPrecio;
    private JTextField txtCupos;
    private JDateChooser dateChooser; 

    public PantallaEditarCurso(Cursos curso, Perfil perfil) {
        this.curso = curso;
        this.perfil = perfil;
        this.controlador = new CursoControlador();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblEditarCursos = new JLabel("Editar Cursos");
        lblEditarCursos.setHorizontalAlignment(SwingConstants.CENTER);
        lblEditarCursos.setForeground(Color.WHITE);
        lblEditarCursos.setFont(new Font("Lucida Console", Font.BOLD, 26));
        lblEditarCursos.setBounds(0, 20, 786, 44);
        lblEditarCursos.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/libroIconMini.png")));
        contentPane.add(lblEditarCursos);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Lucida Console", Font.PLAIN, 12));
        lblTitulo.setBounds(104, 98, 100, 20);
        contentPane.add(lblTitulo);

        txtTitulo = new JTextField(curso.getTitulo());
        txtTitulo.setBounds(214, 96, 460, 30);
        contentPane.add(txtTitulo);
        txtTitulo.setColumns(10);

        JLabel lblLugar = new JLabel("Lugar:");
        lblLugar.setForeground(Color.WHITE);
        lblLugar.setFont(new Font("Lucida Console", Font.PLAIN, 12));
        lblLugar.setBounds(104, 148, 100, 20);
        contentPane.add(lblLugar);

        txtLugar = new JTextField(curso.getLugar());
        txtLugar.setBounds(214, 146, 460, 30);
        contentPane.add(txtLugar);
        txtLugar.setColumns(10);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setForeground(Color.WHITE);
        lblPrecio.setFont(new Font("Lucida Console", Font.PLAIN, 12));
        lblPrecio.setBounds(104, 198, 100, 20);
        contentPane.add(lblPrecio);

        txtPrecio = new JTextField(String.valueOf(curso.getPrecio()));
        txtPrecio.setBounds(214, 196, 460, 30);
        contentPane.add(txtPrecio);
        txtPrecio.setColumns(10);

        JLabel lblCupos = new JLabel("Cupos Disponibles:");
        lblCupos.setForeground(Color.WHITE);
        lblCupos.setFont(new Font("Lucida Console", Font.PLAIN, 12));
        lblCupos.setBounds(104, 248, 150, 20);
        contentPane.add(lblCupos);

        txtCupos = new JTextField(String.valueOf(curso.getCupo()));
        txtCupos.setBounds(264, 246, 410, 30);
        contentPane.add(txtCupos);
        txtCupos.setColumns(10);

        JLabel lblDia = new JLabel("Día:");
        lblDia.setForeground(Color.WHITE);
        lblDia.setFont(new Font("Lucida Console", Font.PLAIN, 12));
        lblDia.setBounds(104, 298, 100, 20);
        contentPane.add(lblDia);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(214, 299, 150, 37);
        dateChooser.setDate(Date.from(curso.getDia().atStartOfDay(ZoneId.systemDefault()).toInstant())); 
        contentPane.add(dateChooser);

        Box horizontalBox1 = Box.createHorizontalBox();
		horizontalBox1.setBounds(264, 347, 100, 44);
		contentPane.add(horizontalBox1);
		
		JSpinner inputHora = new JSpinner();
		horizontalBox1.add(inputHora);
		inputHora.setModel(new SpinnerNumberModel(0, 0, 24, 1));
		
		JSpinner inputMinuto = new JSpinner();
		horizontalBox1.add(inputMinuto);
		inputMinuto.setModel(new SpinnerNumberModel(0, 0, 59, 1));

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(255, 153, 153));
        btnGuardar.setFont(new Font("Lucida Console", Font.PLAIN, 16));
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                curso.setTitulo(txtTitulo.getText());
                curso.setLugar(txtLugar.getText());
                curso.setPrecio(Double.parseDouble(txtPrecio.getText()));
                curso.setCupo(Integer.parseInt(txtCupos.getText()));
                curso.setDia(dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()); 
                controlador.updateCurso(curso); 
                PantallaMisCursos misCursos = new PantallaMisCursos(perfil); 
                misCursos.setVisible(true);
                dispose();
            }
        });
        btnGuardar.setBounds(403, 298, 271, 30);
        contentPane.add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(255, 255, 153));
        btnCancelar.setFont(new Font("Lucida Console", Font.PLAIN, 16));
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaMisCursos misCursos = new PantallaMisCursos(perfil);
                misCursos.setVisible(true);
                dispose();
            }
        });
        btnCancelar.setBounds(494, 347, 180, 30);
        contentPane.add(btnCancelar);
        
        JPanel panel_1_1_1 = new JPanel();
        panel_1_1_1.setForeground(new Color(51, 51, 0));
        panel_1_1_1.setBorder(null);
        panel_1_1_1.setBackground(new Color(153, 0, 0));
        panel_1_1_1.setBounds(-51, 20, 906, 44);
        contentPane.add(panel_1_1_1);
        
        JLabel lblHorario = new JLabel("Horario:");
        lblHorario.setForeground(Color.WHITE);
        lblHorario.setFont(new Font("Lucida Console", Font.PLAIN, 12));
        lblHorario.setBounds(104, 347, 100, 20);
        contentPane.add(lblHorario);
        
        JLabel lblHhmm = new JLabel("hh/mm");
        lblHhmm.setHorizontalAlignment(SwingConstants.CENTER);
        lblHhmm.setForeground(new Color(255, 153, 153));
        lblHhmm.setFont(new Font("Lucida Console", Font.PLAIN, 12));
        lblHhmm.setBounds(84, 365, 100, 20);
        contentPane.add(lblHhmm);
        
        JPanel panel_1_1_2_1 = new JPanel();
        panel_1_1_2_1.setForeground(new Color(51, 51, 0));
        panel_1_1_2_1.setBackground(new Color(255, 204, 0));
        panel_1_1_2_1.setBounds(224, 100, 460, 35);
        contentPane.add(panel_1_1_2_1);
        
        JPanel panel_1_1_2_1_1 = new JPanel();
        panel_1_1_2_1_1.setForeground(new Color(51, 51, 0));
        panel_1_1_2_1_1.setBackground(new Color(255, 204, 0));
        panel_1_1_2_1_1.setBounds(224, 150, 460, 35);
        contentPane.add(panel_1_1_2_1_1);
        
        JPanel panel_1_1_2_1_2 = new JPanel();
        panel_1_1_2_1_2.setForeground(new Color(51, 51, 0));
        panel_1_1_2_1_2.setBackground(new Color(255, 204, 0));
        panel_1_1_2_1_2.setBounds(224, 202, 460, 35);
        contentPane.add(panel_1_1_2_1_2);
        
        JPanel panel_1_1_2_1_3 = new JPanel();
        panel_1_1_2_1_3.setForeground(new Color(51, 51, 0));
        panel_1_1_2_1_3.setBackground(new Color(255, 204, 0));
        panel_1_1_2_1_3.setBounds(274, 253, 410, 35);
        contentPane.add(panel_1_1_2_1_3);
        
        JPanel panel_1_1_2_1_4 = new JPanel();
        panel_1_1_2_1_4.setForeground(new Color(51, 51, 0));
        panel_1_1_2_1_4.setBackground(new Color(255, 204, 0));
        panel_1_1_2_1_4.setBounds(504, 356, 180, 30);
        contentPane.add(panel_1_1_2_1_4);
        
        JPanel panel_1 = new JPanel();
        panel_1.setForeground(new Color(51, 51, 0));
        panel_1.setBackground(new Color(128, 0, 0));
        panel_1.setBounds(413, 304, 271, 32);
        contentPane.add(panel_1);

        setVisible(true);
    }
}
