package Vistas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import Controladores.RecetaControlador;
import Modelos.Perfil;
import Modelos.Receta;


public class PantallaVerRecetaComentarios extends JFrame {
	

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Receta receta; // CAMBIO: ATRIBUTO PARA ALMACENAR LA RECETA
    private Perfil perfil; // CAMBIO: ATRIBUTO PARA ALMACENAR EL PERFIL

    private JLabel lblNombre;
    private JTextArea txtIngredientes;
    private JTextArea txtCategoria;
    private JTextArea txtDescripcion;

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
    public PantallaVerRecetaComentarios(Receta receta, Perfil perfil) {
    	this.receta = receta;
        this.perfil = perfil;
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 856, 610);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(39, 42, 769, 508);
        contentPane.add(tabbedPane);
        
        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setBackground(new Color(255, 255, 204));
        tabbedPane.addTab("Receta", null, desktopPane, null);
                
        txtDescripcion = new JTextArea(receta.getProcedimiento());
        txtDescripcion.setFont(new Font("Courier New", Font.PLAIN, 14));
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setEditable(false);
        txtDescripcion.setBackground(new Color(255, 153, 153));
        txtDescripcion.setBounds(36, 206, 706, 250);
        desktopPane.add(txtDescripcion);
        
                txtIngredientes = new JTextArea(receta.getIngredientes());
                txtIngredientes.setFont(new Font("Courier New", Font.PLAIN, 12));
                txtIngredientes.setBackground(new Color(255, 153, 153));
                txtIngredientes.setBounds(36, 38, 241, 147);
                desktopPane.add(txtIngredientes);
                txtIngredientes.setEditable(false);
        
        // titulo
        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setForeground(new Color(0, 0, 0));
        lblTitulo.setFont(new Font("Lucida Console", Font.PLAIN, 14));
        lblTitulo.setBounds(306, 21, 118, 20);
        desktopPane.add(lblTitulo);

        // prcedimiento
        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setForeground(new Color(0, 0, 0));
        lblDescripcion.setFont(new Font("Lucida Console", Font.PLAIN, 14));
        lblDescripcion.setBounds(644, 181, 107, 20);
        desktopPane.add(lblDescripcion);
        
        
        JPanel panel_1_1 = new JPanel();
		panel_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1.setBackground(new Color(204, 0, 0));
		panel_1_1.setBounds(47, 212, 704, 252);
		desktopPane.add(panel_1_1);
		
		        txtCategoria = new JTextArea(receta.getCategorias());
		        txtCategoria.setEditable(false);
		        txtCategoria.setBackground(new Color(255, 255, 204));
		        txtCategoria.setLineWrap(true);
		        txtCategoria.setWrapStyleWord(true);
		        txtCategoria.setBounds(578, 11, 173, 25);
		        desktopPane.add(txtCategoria);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(51, 51, 0));
		panel_1.setBackground(new Color(128, 0, 0));
		panel_1.setBounds(47, 48, 241, 147);
		desktopPane.add(panel_1);
		
		        // ingredientes
		        JLabel lblIngredientes = new JLabel("Ingredientes:");
		        lblIngredientes.setBounds(36, 21, 118, 20);
		        desktopPane.add(lblIngredientes);
		        lblIngredientes.setForeground(new Color(0, 0, 0));
		        lblIngredientes.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		        //lblTitulo.setColumns(10);

		        lblNombre = new JLabel(receta.getTitulo());
		        lblNombre.setBackground(new Color(255, 255, 204));
		        lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		        lblNombre.setBounds(306, 38, 429, 73);
		        desktopPane.add(lblNombre);
		        lblNombre.setForeground(new Color(204, 0, 0));
		        lblNombre.setFont(new Font("Lucida Console", Font.BOLD, 24));
        
        JLabel lblCategoria = new JLabel("Categoría:");
        lblCategoria.setForeground(Color.WHITE);
        lblCategoria.setFont(new Font("Lucida Console", Font.PLAIN, 14));
        lblCategoria.setBounds(104, 393, 100, 20);
        contentPane.add(lblCategoria);
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.setBackground(new Color(255, 255, 204));
        btnVolver.setFont(new Font("Lucida Console", Font.PLAIN, 16));
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	TablaReceta tablaReceta = new TablaReceta(perfil);
                tablaReceta.setVisible(true);
                dispose();
            }
        });

        
        JDesktopPane desktopPane_1 = new JDesktopPane();
        tabbedPane.addTab("Comentarios", null, desktopPane_1, null);
        
        JPanel panel_1_1_1 = new JPanel();
        panel_1_1_1.setForeground(new Color(51, 51, 0));
        panel_1_1_1.setBackground(new Color(255, 204, 0));
        panel_1_1_1.setBounds(49, 79, 770, 480);
        contentPane.add(panel_1_1_1);
    }
}
