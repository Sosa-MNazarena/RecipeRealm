package Controladores;

import java.sql.Connection;
import java.util.List;

import Modelos.Perfil;
import interfaces.PerfilRepository;

public class PerfilControlador implements PerfilRepository {
    private final Connection connection;

    public PerfilControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public List<Perfil> getAllPerfils() {
        // TODO: Implementar la lógica para obtener todos los perfiles
        return null;
    }

    @Override
    public Perfil getPerfilById(int id) {
        // TODO: Implementar la lógica para obtener un perfil por ID
        return null;
    }

    @Override
    public void addPerfil(Perfil perfil) {
        // TODO: Implementar la lógica para agregar un perfil
    }

    @Override
    public void updatePerfil(Perfil perfil) {
        // TODO: Implementar la lógica para actualizar un perfil
    }

    @Override
    public void deletePerfil(int id) {
        // TODO: Implementar la lógica para eliminar un perfil por ID
    }
}
