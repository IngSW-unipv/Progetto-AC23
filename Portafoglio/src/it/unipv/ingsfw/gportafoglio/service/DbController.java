package it.unipv.ingsfw.gportafoglio.service;

import it.unipv.ingsfw.gportafoglio.dao.PortafoglioDAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbController {
    private String url = "jdbc:mysql://localhost:3306/databaseportafoglio";
    private String username = "root";
    private String password = "";
    private Connection connection;

    public DbController() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connessione al database avvenuta con successo!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PortafoglioDAOImpl getPortafoglioDAO() {
        return new PortafoglioDAOImpl(connection);
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


/*public class DbController {

	private String url;
	private String username;
	private String password;
	
	private Connection conn;

	public DbController() {
		url = "jdbc:mysql://localhost:3306/databaseportafoglio";
		username = "root";
		password = "";
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			System.out.println("Connessione avvenuta con successo!");
			this.conn = conn;
		}	
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
    public PortafoglioDAOImpl getPortafoglioDAO() throws SQLException {
    	conn = DriverManager.getConnection(url, username, password);
        return new PortafoglioDAOImpl();
    }

}*/