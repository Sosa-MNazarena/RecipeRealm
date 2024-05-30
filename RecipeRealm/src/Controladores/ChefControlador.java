package Controladores;

import java.sql.Connection;

public class ChefControlador {
	private final Connection connection;

    public ChefControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

}
