package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controladores.PerfilControlador;
import Modelos.Perfil;
import Modelos.Receta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import Modelos.Perfil;
import Controladores.PerfilControlador;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PantallaSubirReceta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputNombreIngrediente;
	private JTextField inputCantidadIngrediente;
	private List<String> listaIngredientes;
	private List<String> listaCategorias;
	private JPanel panelIngredientes;
	private JPanel panelCategorias;
	private JComboBox<String> comboBox;
	private JTextField textFieldTitulo;
	private JTextArea inputProcedimiento;
	private JTextField textFieldCategoria;
	private JTextField inputCategoria;
	private Perfil perfil;
    private PerfilControlador controlador = new PerfilControlador();

	/*public static void main(String[] args) {
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
*/
	public PantallaSubirReceta(Perfil perfil) {
		this.perfil = perfil;
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelCategorias = new JPanel();
	    panelCategorias.setBackground(new Color(255, 51, 51));
	    panelCategorias.setForeground(Color.WHITE);
	    panelCategorias.setBounds(43, 388, 284, 51);
	    contentPane.add(panelCategorias);
	    panelCategorias.setLayout(null);

		JLabel lblNewLabel = new JLabel("Subí tu Receta acá");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Console", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 11, 786, 44);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/pergaminoIconMini.png")));

		JLabel lblTitulo = new JLabel("Título");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblTitulo.setBounds(43, 80, 108, 20);
		contentPane.add(lblTitulo);

		textFieldTitulo = new JTextField();
		textFieldTitulo.setColumns(10);
		textFieldTitulo.setBounds(43, 99, 284, 33);
		contentPane.add(textFieldTitulo);

		inputProcedimiento = new JTextArea();
		inputProcedimiento.setBackground(new Color(255, 255, 204));
		inputProcedimiento.setWrapStyleWord(true);
		inputProcedimiento.setLineWrap(true);
		inputProcedimiento.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		inputProcedimiento.setBounds(363, 102, 354, 370);
		contentPane.add(inputProcedimiento);

		JLabel lblProcedimiento = new JLabel("Procedimiento");
		lblProcedimiento.setForeground(Color.WHITE);
		lblProcedimiento.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblProcedimiento.setBounds(363, 79, 337, 22);
		contentPane.add(lblProcedimiento);

		JButton btnPublicarReceta = new JButton("Publicar Receta");
		btnPublicarReceta.setBackground(Color.WHITE);
		btnPublicarReceta.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		btnPublicarReceta.setBounds(363, 489, 354, 29);
		contentPane.add(btnPublicarReceta);

		btnPublicarReceta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDate fecha = LocalDate.now();
				String categorias = String.join(" - ", listaCategorias);
				String ingredientes = String.join(" | ", listaIngredientes);
				
				if (perfil == null) {
		            JOptionPane.showMessageDialog(null, "El perfil no está definido.");
		            return;
		        }
				
				int idUsuario = perfil.getIdUsuario();
				
				String respuesta = Receta.subirReceta(textFieldTitulo.getText(), inputProcedimiento.getText(),
						categorias, ingredientes, fecha, perfil.getIdUsuario());dispose();
		                PantallaHomeChef pantallaHomeChef = new PantallaHomeChef(perfil);
		                pantallaHomeChef.setVisible(true);

			}
		});

		inputNombreIngrediente = new JTextField();
		inputNombreIngrediente.setBounds(43, 170, 205, 26);
		contentPane.add(inputNombreIngrediente);
		inputNombreIngrediente.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		inputNombreIngrediente.setColumns(10);

		JLabel lblNombreIngrediente = new JLabel("Nombre del Ingrediente");
		lblNombreIngrediente.setForeground(Color.WHITE);
		lblNombreIngrediente.setBounds(43, 150, 205, 20);
		contentPane.add(lblNombreIngrediente);
		lblNombreIngrediente.setFont(new Font("Lucida Console", Font.PLAIN, 14));

		JButton btnAgregarIngrediente = new JButton("Agregar");
		btnAgregarIngrediente.setBackground(Color.WHITE);
		btnAgregarIngrediente.setBounds(43, 207, 92, 29);
		contentPane.add(btnAgregarIngrediente);
		btnAgregarIngrediente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarIngrediente();
			}
		});

		btnAgregarIngrediente.setFont(new Font("Lucida Console", Font.PLAIN, 12));

		JLabel lblCantidadIngrediente = new JLabel("Cantidad");
		lblCantidadIngrediente.setForeground(Color.WHITE);
		lblCantidadIngrediente.setBounds(258, 150, 83, 20);
		contentPane.add(lblCantidadIngrediente);
		lblCantidadIngrediente.setFont(new Font("Lucida Console", Font.PLAIN, 14));

		inputCantidadIngrediente = new JTextField();
		inputCantidadIngrediente.setBounds(258, 170, 67, 26);
		contentPane.add(inputCantidadIngrediente);
		inputCantidadIngrediente.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		inputCantidadIngrediente.setColumns(10);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1_1.setBorder(null);
		panel_1_1_1.setBackground(new Color(153, 0, 0));
		panel_1_1_1.setBounds(0, 11, 786, 44);
		contentPane.add(panel_1_1_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setForeground(new Color(51, 51, 0));
		panel_1_1.setBackground(new Color(255, 255, 102));
		panel_1_1.setBounds(52, 106, 281, 33);
		contentPane.add(panel_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(51, 51, 0));
		panel_1.setBackground(new Color(128, 0, 0));
		panel_1.setBounds(373, 493, 356, 33);
		contentPane.add(panel_1);
		
			comboBox = new JComboBox<>();
	        comboBox.setBounds(43, 455, 291, 33);
	        contentPane.add(comboBox);
	        comboBox.addItem("Italia");
	        comboBox.addItem("China");
	        comboBox.addItem("México");
	        comboBox.addItem("Argentina");
	        comboBox.addItem("Brasil");
	        comboBox.addItem("Colombia");
	        comboBox.addItem("Dulces");
	        comboBox.addItem("Japón");
	        
	        
	    
				
						JLabel lblCategoria = new JLabel("Categorías");
						lblCategoria.setBounds(43, 437, 238, 20);
						contentPane.add(lblCategoria);
						lblCategoria.setForeground(Color.WHITE);
						lblCategoria.setFont(new Font("Lucida Console", Font.PLAIN, 14));
						
								JButton btnAgregarCategoria = new JButton("Agregar");
								btnAgregarCategoria.setBackground(Color.WHITE);
								btnAgregarCategoria.setBounds(43, 492, 92, 29);
								contentPane.add(btnAgregarCategoria);
								btnAgregarCategoria.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										agregarCategoria();

									}
								});
								btnAgregarCategoria.setFont(new Font("Lucida Console", Font.PLAIN, 12));
								
										panelIngredientes = new JPanel();
										panelIngredientes.setBounds(43, 240, 284, 144);
										contentPane.add(panelIngredientes);
										panelIngredientes.setBackground(new Color(255, 51, 51));
										panelIngredientes.setForeground(new Color(255, 255, 255));
										panelIngredientes.setLayout(null);

		listaIngredientes = new ArrayList<>();
		listaCategorias = new ArrayList<>();

	}

	private void agregarIngrediente() {
	    String nombreIngrediente = inputNombreIngrediente.getText();
	    String cantidadIngrediente = inputCantidadIngrediente.getText();
	    String nuevoIngrediente = nombreIngrediente + " - " + cantidadIngrediente;

	    listaIngredientes.add(nuevoIngrediente); // Agregar a la lista de ingredientes

	    JLabel labelIngrediente = new JLabel(nuevoIngrediente);
	    labelIngrediente.setFont(new Font("Tahoma", Font.PLAIN, 14));

	    int yPosition = 10 + listaIngredientes.size() * 30;
	    labelIngrediente.setBounds(10, yPosition, 400, 20);
	    panelIngredientes.add(labelIngrediente);

	    inputNombreIngrediente.setText("");
	    inputCantidadIngrediente.setText("");

	    panelIngredientes.setPreferredSize(new java.awt.Dimension(301, yPosition + 30));
	    panelIngredientes.revalidate();
	    panelIngredientes.repaint();
	}

	private void agregarCategoria() {
        String nuevaCategoria = (String)comboBox.getSelectedItem();
        listaCategorias.add(nuevaCategoria);

        JLabel labelCategoria = new JLabel(nuevaCategoria);
        labelCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));

        int yPosition = 10 + listaCategorias.size() * 30;
        labelCategoria.setBounds(10, yPosition, 400, 20);
        panelCategorias.add(labelCategoria);

      

        panelCategorias.setPreferredSize(new java.awt.Dimension(354, yPosition + 30));
        panelCategorias.revalidate();
        panelCategorias.repaint();
        
    }
	
	
	
}
