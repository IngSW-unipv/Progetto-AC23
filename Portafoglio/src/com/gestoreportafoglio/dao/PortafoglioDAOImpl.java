package com.gestoreportafoglio.dao;

import Portafoglio.Portafoglio;

import java.sql.*;
import java.util.ArrayList;

public class PortafoglioDAOImpl implements PortafoglioDAO {
	private String url;
	private String username;
	private String password;

	public PortafoglioDAOImpl() {
		url = "jdbc:mysql://localhost:3306/databaseportafoglio";
		username = "root";
		password = "";
		try (Connection conn = getConnection()){
			System.out.println("Connessione avvenuta con successo!");
		}	
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);	
	}

}
