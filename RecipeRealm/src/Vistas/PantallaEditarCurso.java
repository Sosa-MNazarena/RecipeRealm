package Vistas;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.LineBorder;

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
    private JTextField txtDia;
    private JTextField txtHorario;

    public PantallaEditarCurso(Cursos curso, Perfil perfil) {
    	this.setVisible(true);
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
        txtLugar.setBounds(214, 271, 460, 30);
        contentPane.add(txtLugar);
        txtLugar.setColumns(10);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblPrecio.setBounds(104, 273, 100, 20);
        contentPane.add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(214, 271, 460, 30);
        contentPane.add(txtPrecio);
        txtPrecio.setColumns(10);

        JLabel lblCupos = new JLabel("Cupos Disponibles:");
        lblCupos.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblCupos.setBounds(104, 323, 100, 20);
        contentPane.add(lblCupos);

        txtCupos = new JTextField(curso.getCupo());
        txtCupos.setBounds(214, 324, 460, 30);
        contentPane.add(txtCupos);
        
        JLabel lblDia = new JLabel("Día:");
        lblDia.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblDia.setBounds(104, 323, 100, 20);
        contentPane.add(lblDia);

        txtDia = new JTextField();
        txtDia.setBounds(214, 324, 460, 30);
        contentPane.add(txtDia);
        
        JLabel lblHorario = new JLabel("Horario:");
        lblHorario.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblHorario.setBounds(104, 323, 100, 20);
        contentPane.add(lblHorario);

        txtHorario = new JTextField();
        txtHorario.setBounds(214, 324, 460, 30);
        contentPane.add(txtHorario);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(255, 255, 255));
        btnGuardar.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	curso.setTitulo(txtTitulo.getText());
                curso.setLugar(txtLugar.getText());
                curso.setPrecio(Double.parseDouble(txtPrecio.getText()));
                curso.setCupo(Integer.parseInt(txtCupos.getText()));
                curso.setDia(LocalDate.parse(txtPrecio.getText()));
                curso.setHorario(LocalTime.parse(txtCupos.getText()));
                controlador.updateCurso(curso);
                PantallaMisCursos misCursos = new PantallaMisCursos(perfil);
                misCursos.setVisible(true);
                dispose();
            }
        });
        btnGuardar.setBounds(104, 388, 180, 41);
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
        btnCancelar.setBounds(494, 388, 180, 41);
        contentPane.add(btnCancelar);
    
	}

}
