package Controladores;

import java.sql.Connection;
import java.util.List;

import Modelos.Perfil;
import interfaces.PerfilRepository;
public class PerfilControlador implements PerfilRepository{
	 private final Connection connection;

	 public PerfilControlador() {
	        this.connection = DatabaseConnection.getInstance().getConnection();
	 }

	@Override
	public List<Perfil> getAllPerfils() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Perfil getPerfilById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPerfil(Perfil Perfil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePerfil(Perfil Perfil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePerfil(int id) {
		// TODO Auto-generated method stub
		
	}
	 
}
