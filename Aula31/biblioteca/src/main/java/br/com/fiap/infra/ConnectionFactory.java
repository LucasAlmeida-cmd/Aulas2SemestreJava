package br.com.fiap.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String login = "system";
        String senha = "system";

        try {
            return DriverManager.getConnection(url, login, senha);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao abrir conexão com o banco de dados", e);
        }
    }
}
