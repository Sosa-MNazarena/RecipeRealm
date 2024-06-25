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
        contentPane.setBackground(new Color(242, 242, 242));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblEditarCursos = new JLabel("Editar Cursos");
        lblEditarCursos.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 26));
        lblEditarCursos.setBounds(300, 30, 200, 34);
        contentPane.add(lblEditarCursos);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblTitulo.setBounds(104, 98, 100, 20);
        contentPane.add(lblTitulo);

        txtTitulo = new JTextField(curso.getTitulo());
        txtTitulo.setBounds(214, 96, 460, 30);
        contentPane.add(txtTitulo);
        txtTitulo.setColumns(10);

        JLabel lblLugar = new JLabel("Lugar:");
        lblLugar.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblLugar.setBounds(104, 148, 100, 20);
        contentPane.add(lblLugar);

        txtLugar = new JTextField(curso.getLugar());
        txtLugar.setBounds(214, 146, 460, 30);
        contentPane.add(txtLugar);
        txtLugar.setColumns(10);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblPrecio.setBounds(104, 198, 100, 20);
        contentPane.add(lblPrecio);

        txtPrecio = new JTextField(String.valueOf(curso.getPrecio()));
        txtPrecio.setBounds(214, 196, 460, 30);
        contentPane.add(txtPrecio);
        txtPrecio.setColumns(10);

        JLabel lblCupos = new JLabel("Cupos Disponibles:");
        lblCupos.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblCupos.setBounds(104, 248, 150, 20);
        contentPane.add(lblCupos);

        txtCupos = new JTextField(String.valueOf(curso.getCupo()));
        txtCupos.setBounds(264, 246, 410, 30);
        contentPane.add(txtCupos);
        txtCupos.setColumns(10);

        JLabel lblDia = new JLabel("Día:");
        lblDia.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblDia.setBounds(104, 298, 100, 20);
        contentPane.add(lblDia);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(214, 296, 460, 30);
        dateChooser.setDate(Date.from(curso.getDia().atStartOfDay(ZoneId.systemDefault()).toInstant())); 
        contentPane.add(dateChooser);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(255, 255, 255));
        btnGuardar.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
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
        btnGuardar.setBounds(104, 348, 180, 41);
        contentPane.add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(255, 255, 255));
        btnCancelar.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaMisCursos misCursos = new PantallaMisCursos(perfil);
                misCursos.setVisible(true);
                dispose();
            }
        });
        btnCancelar.setBounds(494, 348, 180, 41);
        contentPane.add(btnCancelar);

        setVisible(true);
    }
}
