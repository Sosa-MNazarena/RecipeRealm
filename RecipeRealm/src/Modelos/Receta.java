package Modelos;

import java.util.ArrayList;
import java.util.Date;

public class Receta {

	private int idReceta;
	private String titulo;
	private String procedimiento;
	private Ingrediente idIngrediente;
	private Aficionado idUsuario;
	private Categoria idCategoria;
	private Resena idResena;
	private Date fecha;
	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<Categoria> categorias;

	public Receta(int idReceta, String titulo, String procedimiento, Ingrediente idIngrediente, Aficionado idUsuario,
			Categoria idCategoria, Resena idResena, Aficionado autor, Date fecha, ArrayList<Ingrediente> ingredientes,
			ArrayList<Categoria> categorias) {
		this.idReceta = idReceta;
		this.titulo = titulo;
		this.procedimiento = procedimiento;
		this.idIngrediente = idIngrediente;
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

	public Ingrediente getIdIngrediente() {
		return idIngrediente;
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
}
