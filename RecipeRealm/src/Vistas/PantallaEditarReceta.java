package Vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.SQLException;

import Modelos.Perfil;
import Modelos.Receta;
import Controladores.RecetaControlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaEditarReceta extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Receta receta;
    private Perfil perfil;
    private RecetaControlador recetaControlador;

    private JTextField txtNombre;
    private JTextArea txtDescripcion;
    private JTextField txtIngredientes;
    private JTextArea txtCategoria;

    public PantallaEditarReceta(Receta receta, Perfil perfil) {
        this.receta = receta;
        this.perfil = perfil;
        this.recetaControlador = new RecetaControlador(); 

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblEditarReceta = new JLabel("Editar Receta");
        lblEditarReceta.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 26));
        lblEditarReceta.setBounds(300, 30, 200, 34);
        contentPane.add(lblEditarReceta);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblNombre.setBounds(50, 100, 100, 20);
        contentPane.add(lblNombre);

        txtNombre = new JTextField(receta.getTitulo());
        txtNombre.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
        txtNombre.setBounds(160, 100, 500, 25);
        contentPane.add(txtNombre);
        txtNombre.setColumns(10);

        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblDescripcion.setBounds(50, 150, 100, 20);
        contentPane.add(lblDescripcion);

        JScrollPane scrollPaneDescripcion = new JScrollPane();
        scrollPaneDescripcion.setBounds(160, 150, 500, 100);
        contentPane.add(scrollPaneDescripcion);

        txtDescripcion = new JTextArea(receta.getProcedimiento());
        txtDescripcion.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
        txtDescripcion.setLineWrap(true);
        scrollPaneDescripcion.setViewportView(txtDescripcion);

        JLabel lblIngredientes = new JLabel("Ingredientes:");
        lblIngredientes.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblIngredientes.setBounds(50, 270, 100, 20);
        contentPane.add(lblIngredientes);

        txtIngredientes = new JTextField(receta.getIngredientes());
        txtIngredientes.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
        txtIngredientes.setBounds(160, 270, 500, 25);
        contentPane.add(txtIngredientes);
        txtIngredientes.setColumns(10);

        JLabel lblInstrucciones = new JLabel("Instrucciones:");
        lblInstrucciones.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblInstrucciones.setBounds(50, 320, 100, 20);
        contentPane.add(lblInstrucciones);

        JScrollPane scrollPaneInstrucciones = new JScrollPane();
        scrollPaneInstrucciones.setBounds(160, 320, 500, 100);
        contentPane.add(scrollPaneInstrucciones);

        txtCategoria = new JTextArea(receta.getCategorias());
        txtCategoria.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
        txtCategoria.setLineWrap(true);
        scrollPaneInstrucciones.setViewportView(txtCategoria);

        JButton btnGuardarCambios = new JButton("Guardar Cambios");
        btnGuardarCambios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        btnGuardarCambios.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        btnGuardarCambios.setBounds(200, 450, 180, 34);
        btnGuardarCambios.setBackground(Color.LIGHT_GRAY);
        contentPane.add(btnGuardarCambios);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              //IR HACIA ATRAS
            }
        });
        btnCancelar.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        btnCancelar.setBounds(400, 450, 180, 34);
        btnCancelar.setBackground(Color.LIGHT_GRAY);
        contentPane.add(btnCancelar);
    }
    
    
}
