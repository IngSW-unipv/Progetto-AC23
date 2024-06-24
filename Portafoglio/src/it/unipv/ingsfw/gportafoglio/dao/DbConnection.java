package it.unipv.ingsfw.gportafoglio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private String url = "jdbc:mysql://localhost:3306/databaseportafoglio";
    private String username = "root";
    private String password = "";
    private Connection connection;

    public DbConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connessione al database avvenuta con successo!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
		return connection;
	}
    
    
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connessione al database chiusa.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
