package br.com.projeto.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/produto";
        String user = "postgres";
        String password = "madara135789";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão bem-sucedida!");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
