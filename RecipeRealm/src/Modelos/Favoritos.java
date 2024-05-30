package Modelos;
import java.util.ArrayList;

public class Favoritos {
	private int idFavorito;
	private int idUsuario;
	private int idReceta;
	private ArrayList<Receta> favoritos; // Lista con las recetas favoritas

	
	public int getIdFavorito() {
		return idFavorito;
	}

	public void setIdFavorito(int idFavorito) {
		this.idFavorito = idFavorito;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}

	public ArrayList<Receta> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(ArrayList<Receta> favoritos) {
		this.favoritos = favoritos;
	}

	@Override
	public String toString() {
		return "Favoritos [idFavorito=" + idFavorito + ", idUsuario=" + idUsuario + ", idReceta=" + idReceta
				+ ", favoritos=" + favoritos + "]";
	}

	public Favoritos(int idFavorito, int idUsuario, int idReceta, ArrayList<Receta> favoritos) {
		super();
		this.idFavorito = idFavorito;
		this.idUsuario = idUsuario;
		this.idReceta = idReceta;
		this.favoritos = favoritos;
	}

	
	public Favoritos() {
		favoritos = new ArrayList<>(); // Iniciar la lista de arrays donde van a ir las recetas que tengan esFavorita como true
	}

}
