package Modelos;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import Controladores.RecetaControlador;

public class Receta {

	private int idReceta;
	private String titulo;
	private String procedimiento;
	private Ingrediente idIngrediente;
	private int nroIngredientes;
	private int cantidadDeIngrediente;
	private Aficionado idUsuario;
	private Categoria idCategoria;
	private Resena idResena;
	private Date fecha;
	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<Categoria> categorias;

	public Receta(int idReceta, String titulo, String procedimiento, Ingrediente idIngrediente, int nroIngredientes,
			int cantidadDeIngrediente, Aficionado idUsuario, Categoria idCategoria, Resena idResena, Aficionado autor,
			Date fecha, ArrayList<Ingrediente> ingredientes, ArrayList<Categoria> categorias) {
		this.idReceta = idReceta;
		this.titulo = titulo;
		this.procedimiento = procedimiento;
		this.idIngrediente = idIngrediente;
		this.nroIngredientes = nroIngredientes;
		this.cantidadDeIngrediente = cantidadDeIngrediente;
		this.idUsuario = idUsuario;
		this.idCategoria = idCategoria;
		this.idResena = idResena;
		this.fecha = fecha;
		this.ingredientes = ingredientes;
		this.categorias = categorias;
	}

	public int getIdReceta() {
		return idReceta;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getProcedimiento() {
		return procedimiento;
	}

	public Ingrediente getidIngrediente() {
		return idIngrediente;
	}

	public int getnroIngredientes() {
		return nroIngredientes;
	}

	public int getcantidadDeIngrediente() {
		return cantidadDeIngrediente;
	}

	public Aficionado getIdUsuario() {
		return idUsuario;
	}

	public Categoria getIdCategoria() {
		return idCategoria;
	}

	public Resena getIdResena() {
		return idResena;
	}

	public Date getFecha() {
		return fecha;
	}

	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}

	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	public void setIdIngrediente(Ingrediente idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public void setnroIngredientes(int nroIngredientes) {
		this.nroIngredientes = nroIngredientes;
	}

	public void setcantidadDeIngrediente(int cantidadDeIngrediente) {
		this.cantidadDeIngrediente = cantidadDeIngrediente;
	}

	public void setIdUsuario(Aficionado idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setIdCategoria(Categoria idCategoria) {
		this.idCategoria = idCategoria;
	}

	public void setIdResena(Resena idResena) {
		this.idResena = idResena;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public void setCategorias(ArrayList<Categoria> categorias) {
		this.categorias = categorias;
	}

	// Menu Mis Recetas
	public static void menuRecetas() {
		String[] opcionesRecetas = {"Subir receta", "Ver mis recetas", "Eliminar receta",
				"Volver" };
		int opcionElegida = 0;
		do {
			opcionElegida = JOptionPane.showOptionDialog(null, "Elija qué desea hacer", "Menú de Recetas", 0, 0, null,
					opcionesRecetas, opcionesRecetas[0]);
			switch (opcionElegida) {
			case 0:
				subirReceta();
				JOptionPane.showMessageDialog(null, "Su receta se subió exitosamente");
				break;
			case 1:
				verReceta();
				JOptionPane.showMessageDialog(null, "Hola, soy una receta");
				break;
			case 2:
				eliminarReceta(opcionElegida);
				JOptionPane.showMessageDialog(null, "Su receta se eliminó exitosamente");
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Volviendo al menú principal");
				break;
			}
		} while (opcionElegida != 3);
	}

	// Metodos de las recetas
	private static void subirReceta() {
		// Datos de la receta ingresados manualmente
		String titulo = "Título de la receta";
		String procedimiento = "Pasos para preparar la receta...";

		Date fecha = new Date(System.currentTimeMillis()); // para ingresar la fecha actual

		// número de ingredientes que el usuario quiera agregar
		int numIngredientes = Integer
				.parseInt(JOptionPane.showInputDialog("Ingrese el número de ingredientes que va a tener su receta:"));

		// inicio lista de ingredientes
		ArrayList<Ingrediente> ingredientes = new ArrayList<>();

		// solicitar al usuario que ingrese el nombre y la cantidad de cada ingrediente
		for (int i = 0; i < numIngredientes; i++) {
			String nombreIngrediente = JOptionPane
					.showInputDialog("Ingrese el nombre del ingrediente " + (i + 1) + ":");
			String cantidadStr = JOptionPane.showInputDialog("Ingrese la cantidad de " + nombreIngrediente + ":");
			double cantidad = Double.parseDouble(cantidadStr);
			Ingrediente ingrediente = new Ingrediente(nombreIngrediente);
			ingrediente.setCantidad(cantidad); // Establecer la cantidad en el objeto Ingrediente
			ingredientes.add(ingrediente); // Agregar el ingrediente a la lista
		}

		// instanciar receta
		Receta receta = new Receta(1, titulo, procedimiento, null, 2, 2, null, null, null, null, fecha, ingredientes,
				null);
		receta.setTitulo(titulo);
		receta.setProcedimiento(procedimiento);

		// llamar al controlador
		RecetaControlador recetaControlador = new RecetaControlador();
		recetaControlador.addReceta(receta);
	}

	private static void eliminarReceta(int opcionElegida) {
		// TODO Auto-generated method stub

	}

	private static void verReceta() {
		// TODO Auto-generated method stub

	}
}
