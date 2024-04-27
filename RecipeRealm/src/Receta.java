import java.util.ArrayList;
import java.util.Date;

public class Receta {

	private String titulo;
	private Aficionado autor;
	private Date fecha;
	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<Categoria> categorias;
	private String procedimiento;
	private boolean esFavorita;

	// Constructor
	public Receta(String titulo, Aficionado autor, Date fecha, ArrayList<Ingrediente> ingredientes,
			ArrayList<Categoria> categorias, String procedimiento, boolean esFavorita) {
		this.titulo = titulo;
		this.autor = autor;
		this.fecha = fecha;
		this.ingredientes = ingredientes;
		this.categorias = categorias;
		this.procedimiento = procedimiento;
		this.esFavorita = esFavorita;
	}

	public String getTitulo() {
		return titulo;
	}

	public Aficionado getAutor() {
		return autor;
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

	public String getProcedimiento() {
		return procedimiento;
	}

	public boolean isEsFavorita() {
		return esFavorita;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(Aficionado autor) {
		this.autor = autor;
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

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	public void setEsFavorita(boolean esFavorita) {
		this.esFavorita = esFavorita;
	}

}
