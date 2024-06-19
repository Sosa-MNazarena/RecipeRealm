package Vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.LineBorder;

import Controladores.RecetaControlador;
import Modelos.Perfil;
import Modelos.Receta;

public class PantallaEditarReceta extends JFrame {

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
        contentPane.setBackground(new Color(242, 242, 242));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblEditarReceta = new JLabel("Editar Receta");
        lblEditarReceta.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 26));
        lblEditarReceta.setBounds(300, 30, 200, 34);
        contentPane.add(lblEditarReceta);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblNombre.setBounds(104, 98, 100, 20);
        contentPane.add(lblNombre);

        txtNombre = new JTextField(receta.getTitulo());
        txtNombre.setBounds(214, 96, 460, 30);
        contentPane.add(txtNombre);
        txtNombre.setColumns(10);

        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblDescripcion.setBounds(104, 148, 100, 20);
        contentPane.add(lblDescripcion);

        txtDescripcion = new JTextArea(receta.getProcedimiento());
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.setBounds(214, 149, 460, 100);
        contentPane.add(txtDescripcion);

        JLabel lblIngredientes = new JLabel("Ingredientes:");
        lblIngredientes.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblIngredientes.setBounds(104, 273, 100, 20);
        contentPane.add(lblIngredientes);

        txtIngredientes = new JTextField(receta.getIngredientes());
        txtIngredientes.setBounds(214, 271, 460, 30);
        contentPane.add(txtIngredientes);
        txtIngredientes.setColumns(10);

        JLabel lblCategoria = new JLabel("Categoría:");
        lblCategoria.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblCategoria.setBounds(104, 323, 100, 20);
        contentPane.add(lblCategoria);

        txtCategoria = new JTextArea(receta.getCategorias());
        txtCategoria.setBounds(214, 324, 460, 30);
        contentPane.add(txtCategoria);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(255, 255, 255));
        btnGuardar.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                receta.setTitulo(txtNombre.getText());
                receta.setProcedimiento(txtDescripcion.getText());
                receta.setIngredientes(txtIngredientes.getText());
                receta.setCategorias(txtCategoria.getText());
                recetaControlador.updateReceta(receta);
                PantallaMisRecetas misRecetas = new PantallaMisRecetas(perfil);
                misRecetas.setVisible(true);
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
                PantallaMisRecetas misRecetas = new PantallaMisRecetas(perfil);
                misRecetas.setVisible(true);
                dispose();
            }
        });
        btnCancelar.setBounds(494, 388, 180, 41);
        contentPane.add(btnCancelar);
    }
}
