package Controladores;

import java.sql.Connection;

public class AficionadoControlador {
	private final Connection connection;

    public AficionadoControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

}
