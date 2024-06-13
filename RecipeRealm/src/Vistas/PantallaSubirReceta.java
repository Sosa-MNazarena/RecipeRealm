package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class PantallaSubirReceta extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField inputNombreIngrediente;
    private JTextField inputCantidadIngrediente;
    private List<String> listaIngredientes;
    private JPanel panelIngredientes;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    
    
    private JTextField textFieldTitulo; 
    private JTextArea inputProcedimiento; 
    private JTextField textFieldFecha; 
    private JTextField textFieldCategoria;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PantallaSubirReceta frame = new PantallaSubirReceta();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PantallaSubirReceta() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        panelIngredientes = new JPanel();
        panelIngredientes.setBounds(43, 262, 301, 258);
        contentPane.add(panelIngredientes);
        panelIngredientes.setLayout(null);

        JLabel lblNewLabel = new JLabel("Subí tu Receta acá");
        lblNewLabel.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 23));
        lblNewLabel.setBounds(298, 11, 188, 35);
        contentPane.add(lblNewLabel);
        
        JLabel lblTitulo = new JLabel("Título");
        lblTitulo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblTitulo.setBounds(43, 68, 108, 20);
        contentPane.add(lblTitulo);
        
        textFieldTitulo = new JTextField();
        textFieldTitulo.setColumns(10);
        textFieldTitulo.setBounds(44, 100, 272, 33);
        contentPane.add(textFieldTitulo);
        
        inputProcedimiento = new JTextArea();
        inputProcedimiento.setWrapStyleWord(true);
        inputProcedimiento.setLineWrap(true);
        inputProcedimiento.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
        inputProcedimiento.setBounds(363, 102, 354, 286);
        contentPane.add(inputProcedimiento);
        
        JLabel lblProcedimiento = new JLabel("Procedimiento");
        lblProcedimiento.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
        lblProcedimiento.setBounds(368, 67, 337, 22);
        contentPane.add(lblProcedimiento);
        
        JLabel lblFecha = new JLabel("Fecha");
        lblFecha.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblFecha.setBounds(363, 410, 60, 20);
        contentPane.add(lblFecha);
        
        textFieldFecha = new JTextField();
        textFieldFecha.setColumns(10);
        textFieldFecha.setBounds(363, 433, 85, 33);
        contentPane.add(textFieldFecha);
        
        JButton btnPublicarReceta = new JButton("Publicar Receta");
        btnPublicarReceta.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
        btnPublicarReceta.setBounds(363, 489, 354, 29);
        contentPane.add(btnPublicarReceta);
        btnPublicarReceta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                publicarReceta();
            }
        });
        
        textFieldCategoria = new JTextField();
        textFieldCategoria.setColumns(10);
        textFieldCategoria.setBounds(479, 433, 238, 33);
        contentPane.add(textFieldCategoria);
        
        JLabel lblCategoria = new JLabel("Categoria");
        lblCategoria.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblCategoria.setBounds(479, 410, 238, 20);
        contentPane.add(lblCategoria);

        inputNombreIngrediente = new JTextField();
        inputNombreIngrediente.setBounds(43, 189, 205, 26);
        contentPane.add(inputNombreIngrediente);
        inputNombreIngrediente.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
        inputNombreIngrediente.setColumns(10);
        
        JLabel lblNombreIngrediente = new JLabel("Nombre del Ingrediente");
        lblNombreIngrediente.setBounds(47, 158, 179, 20);
        contentPane.add(lblNombreIngrediente);
        lblNombreIngrediente.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        
        JButton btnAgregarIngrediente = new JButton("Agregar");
        btnAgregarIngrediente.setBounds(47, 226, 92, 29);
        contentPane.add(btnAgregarIngrediente);
        btnAgregarIngrediente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarIngrediente();
            }
        });
        
        btnAgregarIngrediente.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
        
        JLabel lblCantidadIngrediente = new JLabel("Cantidad");
        lblCantidadIngrediente.setBounds(261, 158, 67, 20);
        contentPane.add(lblCantidadIngrediente);
        lblCantidadIngrediente.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        
        inputCantidadIngrediente = new JTextField();
        inputCantidadIngrediente.setBounds(258, 189, 67, 26);
        contentPane.add(inputCantidadIngrediente);
        inputCantidadIngrediente.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
        inputCantidadIngrediente.setColumns(10);

        listaIngredientes = new ArrayList<>();
    }

    private void agregarIngrediente() {
        String nombreIngrediente = inputNombreIngrediente.getText();
        String cantidadIngrediente = inputCantidadIngrediente.getText();
        String nuevoIngrediente = nombreIngrediente + " - " + cantidadIngrediente;

        JLabel labelIngrediente = new JLabel(nuevoIngrediente);
        labelIngrediente.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelIngrediente.setBounds(10, 10 + listaIngredientes.size() * 30, 400, 20);
        panelIngredientes.add(labelIngrediente);

        listaIngredientes.add(nuevoIngrediente);

        panelIngredientes.setPreferredSize(new java.awt.Dimension(301, (listaIngredientes.size() + 1) * 30));
        panelIngredientes.revalidate();
        panelIngredientes.repaint();

        inputNombreIngrediente.setText("");
        inputCantidadIngrediente.setText("");
    }
    
    private void publicarReceta() {
        String titulo = textFieldTitulo.getText();
        String procedimiento = inputProcedimiento.getText();
        String fecha = textFieldFecha.getText();
        String categoria = textFieldCategoria.getText();

        System.out.println("Título: " + titulo);
        System.out.println("Procedimiento: " + procedimiento);
        System.out.println("Fecha: " + fecha);
        System.out.println("Categoría: " + categoria);

        System.out.println("Ingredientes:");
        for (String ingrediente : listaIngredientes) {
            System.out.println(ingrediente);
        }
    }
}
