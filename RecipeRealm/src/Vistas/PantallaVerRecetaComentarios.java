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
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JDesktopPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.time.LocalDate;

import Controladores.RecetaControlador;
import Controladores.ResenaControlador;
import Modelos.Perfil;
import Modelos.Receta;
import Modelos.Resena;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;


public class PantallaVerRecetaComentarios extends JFrame {
	

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Receta receta;
    private Perfil perfil;

    private JLabel lblNombre;
    private JTextArea txtIngredientes;
    private JTextArea txtCategoria;
    private JTextArea txtDescripcion;
    
    private JTable tableComentarios;
    private DefaultTableModel tableModel;
    private JTextArea txtNuevoComentario;
    private JComboBox<Integer> comboEstrella;
    private JTextField inputComentario;
	private ResenaControlador resenaControlador;

    /**
     * Launch the application.
     */
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                Perfil perfil = new Perfil(1, "Nombre", "Pseudónimo", "correo@example.com", "contraseña", "Descripción", true);
	                LocalDate fechaReceta = LocalDate.of(2024, 6, 27);
	                Receta receta = new Receta(1, "Título", "Procedimiento", "Categorías", "Ingredientes", fechaReceta, 1);
	                PantallaVerRecetaComentarios frame = new PantallaVerRecetaComentarios(receta, perfil);
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
    public PantallaVerRecetaComentarios(Receta receta, Perfil perfil) {
    	this.receta = receta;
        this.perfil = perfil;
        this.resenaControlador = new ResenaControlador();
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 856, 610);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setForeground(new Color(255, 255, 255));
        tabbedPane.setBackground(new Color(204, 51, 0));
        tabbedPane.setBounds(39, 42, 769, 508);
        contentPane.add(tabbedPane);
        //pestaña receta
        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setBackground(Color.LIGHT_GRAY);
        tabbedPane.addTab("Receta", null, desktopPane, null);
        
        txtDescripcion = new JTextArea(receta.getProcedimiento());
        txtDescripcion.setFont(new Font("Courier New", Font.PLAIN, 14));
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setEditable(false);
        txtDescripcion.setBackground(new Color(255, 255, 204));
        txtDescripcion.setBounds(47, 212, 683, 229);
        desktopPane.add(txtDescripcion);
        
        JPanel panel_1_2_1 = new JPanel();
        panel_1_2_1.setForeground(new Color(51, 51, 0));
        panel_1_2_1.setBackground(new Color(255, 255, 204));
        panel_1_2_1.setBounds(36, 203, 706, 250);
        desktopPane.add(panel_1_2_1);
        
                txtIngredientes = new JTextArea(receta.getIngredientes());
                txtIngredientes.setWrapStyleWord(true);
                txtIngredientes.setLineWrap(true);
                txtIngredientes.setFont(new Font("Courier New", Font.PLAIN, 12));
                txtIngredientes.setBackground(new Color(255, 255, 204));
                txtIngredientes.setBounds(47, 48, 219, 129);
                desktopPane.add(txtIngredientes);
                txtIngredientes.setEditable(false);

        // prcedimiento
        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setForeground(new Color(0, 0, 0));
        lblDescripcion.setFont(new Font("Lucida Console", Font.PLAIN, 14));
        lblDescripcion.setBounds(644, 181, 107, 20);
        desktopPane.add(lblDescripcion);
        
        
        JPanel panel_1_1 = new JPanel();
		panel_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1.setBackground(new Color(255, 204, 51));
		panel_1_1.setBounds(47, 212, 704, 252);
		desktopPane.add(panel_1_1);
		
		        // ingredientes
		        JLabel lblIngredientes = new JLabel("Ingredientes:");
		        lblIngredientes.setBackground(Color.WHITE);
		        lblIngredientes.setBounds(36, 21, 118, 20);
		        desktopPane.add(lblIngredientes);
		        lblIngredientes.setForeground(new Color(0, 0, 0));
		        lblIngredientes.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		        //lblTitulo.setColumns(10);

		        lblNombre = new JLabel(receta.getTitulo());
		        lblNombre.setBackground(new Color(255, 255, 204));
		        lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		        lblNombre.setBounds(306, 38, 429, 118);
		        desktopPane.add(lblNombre);
		        lblNombre.setForeground(new Color(204, 51, 0));
		        lblNombre.setFont(new Font("Lucida Console", Font.BOLD, 24));
		        
		        JPanel panel_1_2 = new JPanel();
		        panel_1_2.setForeground(new Color(51, 51, 0));
		        panel_1_2.setBackground(new Color(255, 255, 204));
		        panel_1_2.setBounds(36, 38, 241, 147);
		        desktopPane.add(panel_1_2);
		        
		        JPanel panel_1 = new JPanel();
		        panel_1.setForeground(new Color(51, 51, 0));
		        panel_1.setBackground(new Color(255, 204, 0));
		        panel_1.setBounds(47, 48, 241, 147);
		        desktopPane.add(panel_1);
		        
		        JPanel panel_1_2_2 = new JPanel();
		        panel_1_2_2.setForeground(new Color(51, 51, 0));
		        panel_1_2_2.setBackground(new Color(255, 255, 204));
		        panel_1_2_2.setBounds(578, 11, 173, 25);
		        desktopPane.add(panel_1_2_2);
		        
		                txtCategoria = new JTextArea(receta.getCategorias());
		                panel_1_2_2.add(txtCategoria);
		                txtCategoria.setEditable(false);
		                txtCategoria.setBackground(new Color(255, 255, 204));
		                txtCategoria.setLineWrap(true);
		                txtCategoria.setWrapStyleWord(true);
        
        JLabel lblCategoria = new JLabel("Categoría:");
        lblCategoria.setForeground(Color.WHITE);
        lblCategoria.setFont(new Font("Lucida Console", Font.PLAIN, 14));
        lblCategoria.setBounds(104, 393, 100, 20);
        contentPane.add(lblCategoria);
        
        //pestaña comentarios
        JDesktopPane desktopPane_1 = new JDesktopPane();
        tabbedPane.addTab("Comentarios", null, desktopPane_1, null);

        String[] columnNames = { "Nombre", "Comentario", "Estrellas", "Fecha" };
        tableModel = new DefaultTableModel(columnNames, 0);
        tableComentarios = new JTable(tableModel);
        tableComentarios.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        tableComentarios.setBackground(new Color(255, 255, 204));
        
        
        JScrollPane scrollPane = new JScrollPane(tableComentarios);
        scrollPane.setBounds(10, 11, 731, 333);
        desktopPane_1.add(scrollPane);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 204, 0));
        panel_2.setBounds(30, 33, 724, 324);
        desktopPane_1.add(panel_2);
        
        JButton btnEnviarResena = new JButton("Enviar");
        btnEnviarResena.setFont(new Font("Lucida Console", Font.PLAIN, 16));
        btnEnviarResena.setBackground(new Color(255, 255, 153));
        btnEnviarResena.setBounds(624, 432, 130, 30);
        desktopPane_1.add(btnEnviarResena);
        
        btnEnviarResena.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	    int idUsuario = perfil.getIdUsuario();
        	    String comentario = inputComentario.getText();
        	    int estrella = Integer.parseInt(comboEstrella.getSelectedItem().toString());
        	    LocalDate fecha = LocalDate.now();
        	    int idReceta = receta.getIdReceta();

        	    Resena resena = new Resena(0, idUsuario, "", comentario, estrella, fecha, idReceta);


                try {
                    resenaControlador.addResena(resena, idReceta);
                    JOptionPane.showMessageDialog(null, "Reseña agregada correctamente.");
                    actualizarTabla();
                    
                    inputComentario.setText("");
                    comboEstrella.setSelectedIndex(0);
                    
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al agregar la reseña: " + e1.getMessage());
                }
            }
        });
        actualizarTabla();
        
        comboEstrella = new JComboBox<Integer>();
        comboEstrella.setFont(new Font("Lucida Console", Font.PLAIN, 11));
        comboEstrella.setBounds(624, 391, 130, 30);
        desktopPane_1.add(comboEstrella);
        comboEstrella.addItem(1);
		comboEstrella.addItem(2);
		comboEstrella.addItem(3);
		comboEstrella.addItem(4);
		comboEstrella.addItem(5);
        
        JLabel lblEstrellas = new JLabel("Estrellas");
        lblEstrellas.setVerticalAlignment(SwingConstants.BOTTOM);
        lblEstrellas.setForeground(new Color(204, 0, 0));
        lblEstrellas.setFont(new Font("Lucida Console", Font.PLAIN, 14));
        lblEstrellas.setBounds(624, 368, 130, 22);
        desktopPane_1.add(lblEstrellas);
        
        
        inputComentario = new JTextField();
        inputComentario.setBackground(new Color(255, 255, 204));
        inputComentario.setColumns(10);
        inputComentario.setBounds(22, 378, 581, 84);
        desktopPane_1.add(inputComentario);
        
        JPanel panel_2_1 = new JPanel();
        panel_2_1.setBackground(new Color(255, 255, 204));
        panel_2_1.setBounds(10, 368, 604, 101);
        desktopPane_1.add(panel_2_1);
        
        JPanel panel_1_1_1 = new JPanel();
        panel_1_1_1.setForeground(new Color(51, 51, 0));
        panel_1_1_1.setBackground(new Color(204, 0, 0));
        panel_1_1_1.setBounds(49, 79, 770, 480);
        contentPane.add(panel_1_1_1);
        
        
        
        
        //fuera de las pestañas
        //boton volver
        JButton btnVolver = new JButton("Volver");
        btnVolver.setBackground(new Color(255, 255, 204));
        btnVolver.setBounds(10, 11, 131, 23);
        btnVolver.setFont(new Font("Lucida Console", Font.PLAIN, 16));
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TablaReceta tablaReceta = new TablaReceta(perfil);
                tablaReceta.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnVolver);
        
        
    }
    private void actualizarTabla() {
        List<Resena> resenas = resenaControlador.getResenasByRecetaId(receta.getIdReceta());
        tableModel.setRowCount(0);
        for (Resena resena : resenas) {
            Object[] fila = {
                resena.getPseudonimoUsuario(),
                resena.getComentario(),
                resena.getEstrella(),
                resena.getFecha().toString()
            };
            tableModel.addRow(fila);
        }
    }
}
