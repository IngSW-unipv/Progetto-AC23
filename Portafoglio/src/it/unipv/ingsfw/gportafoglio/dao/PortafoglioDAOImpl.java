package it.unipv.ingsfw.gportafoglio.dao;

import it.unipv.ingsfw.gportafoglio.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PortafoglioDAOImpl implements PortafoglioDAO {
	private Connection connection;

	public PortafoglioDAOImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Portafoglio getPortafoglioByUsername(String username, String password) {
		String querySaldo = "SELECT saldo FROM utenti WHERE username = ?";
		String queryTransazioni = "SELECT valore, motivo, data, tipo FROM transazioni WHERE username = ?";

		double saldo = 0.0;
		ArrayList<Transazione> transazioni = new ArrayList<>();

		try {
			try (PreparedStatement stmtSaldo = connection.prepareStatement(querySaldo)) {
				stmtSaldo.setString(1, username);
				try (ResultSet rsSaldo = stmtSaldo.executeQuery()) {
					if (rsSaldo.next()) {
						saldo = rsSaldo.getDouble("saldo");
					} else {
						createPortafoglio(username);
					}
				}
			}

			try (PreparedStatement stmtTransazioni = connection.prepareStatement(queryTransazioni)) {
				stmtTransazioni.setString(1, username);
				try (ResultSet rsTransazioni = stmtTransazioni.executeQuery()) {
					while (rsTransazioni.next()) {
						double valore = rsTransazioni.getDouble("valore");
						String motivo = rsTransazioni.getString("motivo");
						Timestamp data = rsTransazioni.getTimestamp("data");
						String tipo = rsTransazioni.getString("tipo");
						transazioni.add(new Transazione(valore, motivo, data, tipo));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new Portafoglio(saldo, transazioni);
	}

	@Override
	public void createPortafoglio(String username) {
		String insertUser = "INSERT INTO utenti (username, saldo) VALUES (?, 0)";
		try (PreparedStatement stmtInsertUser = connection.prepareStatement(insertUser)) {
			stmtInsertUser.setString(1, username);
			stmtInsertUser.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatePortafoglio(String username, Portafoglio portafoglio) {
		String updateSaldo = "UPDATE utenti SET saldo = ? WHERE username = ?";
		String deleteTransazioni = "DELETE FROM transazioni WHERE username = ?";
		String insertTransazione = "INSERT INTO transazioni (username, valore, motivo, data, tipo) VALUES (?, ?, ?, ?, ?)";

		try {
			try (PreparedStatement stmtUpdateSaldo = connection.prepareStatement(updateSaldo)) {
				stmtUpdateSaldo.setDouble(1, portafoglio.getSaldo());
				stmtUpdateSaldo.setString(2, username);
				stmtUpdateSaldo.executeUpdate();
			}

			try (PreparedStatement stmtDeleteTransazioni = connection.prepareStatement(deleteTransazioni)) {
				stmtDeleteTransazioni.setString(1, username);
				stmtDeleteTransazioni.executeUpdate();
			}

			try (PreparedStatement stmtInsertTransazione = connection.prepareStatement(insertTransazione)) {
				for (Transazione transazione : portafoglio.getTransazioni()) {
					stmtInsertTransazione.setString(1, username);
					stmtInsertTransazione.setDouble(2, transazione.getValore());
					stmtInsertTransazione.setString(3, transazione.getMotivo());
					stmtInsertTransazione.setTimestamp(4, new Timestamp(transazione.getData().getTime()));
					stmtInsertTransazione.setString(5, transazione.getTipo());
					stmtInsertTransazione.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletePortafoglio(String username) {
		String deleteUser = "DELETE FROM utenti WHERE username = ?";
		String deleteTransazioni = "DELETE FROM transazioni WHERE username = ?";

		try {
			try (PreparedStatement stmtDeleteTransazioni = connection.prepareStatement(deleteTransazioni)) {
				stmtDeleteTransazioni.setString(1, username);
				stmtDeleteTransazioni.executeUpdate();
			}

			try (PreparedStatement stmtDeleteUser = connection.prepareStatement(deleteUser)) {
				stmtDeleteUser.setString(1, username);
				stmtDeleteUser.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
    public void aggiungiTransazione(String username, double valore, String motivo, String tipo) {
        String query = "INSERT INTO transazioni (username, valore, motivo, tipo, data) VALUES (?, ?, ?, ?, NOW())";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setDouble(2, valore);
            stmt.setString(3, motivo);
            stmt.setString(4, tipo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Transazione> getTransazioni(String username) {
        List<Transazione> transazioni = new ArrayList<>();
        String query = "SELECT * FROM transazioni WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Transazione transazione = new Transazione(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getDouble("valore"),
                            rs.getString("motivo"),
                            rs.getString("tipo"),
                            rs.getTimestamp("data").toLocalDateTime()
                    );
                    transazioni.add(transazione);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transazioni;
    }

	@Override
	public Portafoglio getPortafoglioByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public void createPortafoglio(String username, String password) {
//		// TODO Auto-generated method stub
		
//	}

//	@Override
//	public void updatePortafoglio(String username, String password, Portafoglio portafoglio) {
//		// TODO Auto-generated method stub
		
//	}
}

/*
public class PortafoglioDAOImpl implements PortafoglioDAO {
    private Connection connection;

    public PortafoglioDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Portafoglio getPortafoglioByUsername(String username) {
        String querySaldo = "SELECT saldo FROM utenti WHERE username = ?";
        String queryTransazioni = "SELECT valore, motivo, data, tipo FROM transazioni WHERE username = ?";

        double saldo = 0.0;
        ArrayList<Transazione> transazioni = new ArrayList<>();

        try {
            try (PreparedStatement stmtSaldo = connection.prepareStatement(querySaldo)) {
                stmtSaldo.setString(1, username);
                try (ResultSet rsSaldo = stmtSaldo.executeQuery()) {
                    if (rsSaldo.next()) {
                        saldo = rsSaldo.getDouble("saldo");
                    } else {
                        createPortafoglio(username);
                    }
                }
            }

            try (PreparedStatement stmtTransazioni = connection.prepareStatement(queryTransazioni)) {
                stmtTransazioni.setString(1, username);
                try (ResultSet rsTransazioni = stmtTransazioni.executeQuery()) {
                    while (rsTransazioni.next()) {
                        double valore = rsTransazioni.getDouble("valore");
                        String motivo = rsTransazioni.getString("motivo");
                        Date data = rsTransazioni.getDate("data");
                        String tipo = rsTransazioni.getString("tipo");
                        transazioni.add(new Transazione(valore, motivo, data, tipo));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Portafoglio(saldo, transazioni);
    }

    @Override
    public void createPortafoglio(String username) {
        String insertUser = "INSERT INTO utenti (username, saldo) VALUES (?, 0)";
        try (PreparedStatement stmtInsertUser = connection.prepareStatement(insertUser)) {
            stmtInsertUser.setString(1, username);
            stmtInsertUser.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePortafoglio(String username, Portafoglio portafoglio) {
        String updateSaldo = "UPDATE utenti SET saldo = ? WHERE username = ?";
        String deleteTransazioni = "DELETE FROM transazioni WHERE username = ?";
        String insertTransazione = "INSERT INTO transazioni (username, valore, motivo, data, tipo) VALUES (?, ?, ?, ?, ?)";

        try {
            try (PreparedStatement stmtUpdateSaldo = connection.prepareStatement(updateSaldo)) {
                stmtUpdateSaldo.setDouble(1, portafoglio.getSaldo());
                stmtUpdateSaldo.setString(2, username);
                stmtUpdateSaldo.executeUpdate();
            }

            try (PreparedStatement stmtDeleteTransazioni = connection.prepareStatement(deleteTransazioni)) {
                stmtDeleteTransazioni.setString(1, username);
                stmtDeleteTransazioni.executeUpdate();
            }

            try (PreparedStatement stmtInsertTransazione = connection.prepareStatement(insertTransazione)) {
                for (Transazione transazione : portafoglio.getTransazioni()) {
                    stmtInsertTransazione.setString(1, username);
                    stmtInsertTransazione.setDouble(2, transazione.getValore());
                    stmtInsertTransazione.setString(3, transazione.getMotivo());
                    stmtInsertTransazione.setDate(4, new java.sql.Date(transazione.getData().getTime()));
                    stmtInsertTransazione.setString(5, transazione.getTipo());
                    stmtInsertTransazione.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePortafoglio(String username) {
        String deleteUser = "DELETE FROM utenti WHERE username = ?";
        String deleteTransazioni = "DELETE FROM transazioni WHERE username = ?";

        try {
            try (PreparedStatement stmtDeleteTransazioni = connection.prepareStatement(deleteTransazioni)) {
                stmtDeleteTransazioni.setString(1, username);
                stmtDeleteTransazioni.executeUpdate();
            }

            try (PreparedStatement stmtDeleteUser = connection.prepareStatement(deleteUser)) {
                stmtDeleteUser.setString(1, username);
                stmtDeleteUser.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

 */

/*public class PortafoglioDAOImpl implements PortafoglioDAO {
    private Connection connection;

    public PortafoglioDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Portafoglio getPortafoglioByUsername(String username) {
        String querySaldo = "SELECT saldo FROM utenti WHERE username = ?";
        String querySpese = "SELECT valore FROM transazioni WHERE username = ? AND tipo = 'spesa'";
        String queryAccrediti = "SELECT valore FROM transazioni WHERE username = ? AND tipo = 'accredito'";

        double saldo = 0.0;
        ArrayList<Double> spese = new ArrayList<>();
        ArrayList<Double> accrediti = new ArrayList<>();

        try {
            try (PreparedStatement stmtSaldo = connection.prepareStatement(querySaldo)) {
                stmtSaldo.setString(1, username);
                try (ResultSet rsSaldo = stmtSaldo.executeQuery()) {
                    if (rsSaldo.next()) {
                        saldo = rsSaldo.getDouble("saldo");
                    } else {
                        createPortafoglio(username);
                    }
                }
            }

            try (PreparedStatement stmtSpese = connection.prepareStatement(querySpese)) {
                stmtSpese.setString(1, username);
                try (ResultSet rsSpese = stmtSpese.executeQuery()) {
                    while (rsSpese.next()) {
                        spese.add(rsSpese.getDouble("valore"));
                    }
                }
            }

            try (PreparedStatement stmtAccrediti = connection.prepareStatement(queryAccrediti)) {
                stmtAccrediti.setString(1, username);
                try (ResultSet rsAccrediti = stmtAccrediti.executeQuery()) {
                    while (rsAccrediti.next()) {
                        accrediti.add(rsAccrediti.getDouble("valore"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Portafoglio(saldo, spese, accrediti);
    }

    @Override
    public void createPortafoglio(String username) {
        String insertUser = "INSERT INTO utenti (username, saldo) VALUES (?, 0)";
        try (PreparedStatement stmtInsertUser = connection.prepareStatement(insertUser)) {
            stmtInsertUser.setString(1, username);
            stmtInsertUser.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePortafoglio(String username, Portafoglio portafoglio) {
        String updateSaldo = "UPDATE utenti SET saldo = ? WHERE username = ?";
        String deleteTransazioni = "DELETE FROM transazioni WHERE username = ?";
        String insertTransazione = "INSERT INTO transazioni (username, valore, tipo) VALUES (?, ?, ?)";

        try {
            try (PreparedStatement stmtUpdateSaldo = connection.prepareStatement(updateSaldo)) {
                stmtUpdateSaldo.setDouble(1, portafoglio.getSaldo());
                stmtUpdateSaldo.setString(2, username);
                stmtUpdateSaldo.executeUpdate();
            }

            try (PreparedStatement stmtDeleteTransazioni = connection.prepareStatement(deleteTransazioni)) {
                stmtDeleteTransazioni.setString(1, username);
                stmtDeleteTransazioni.executeUpdate();
            }

            try (PreparedStatement stmtInsertTransazione = connection.prepareStatement(insertTransazione)) {
                for (double spesa : portafoglio.getSpese()) {
                    stmtInsertTransazione.setString(1, username);
                    stmtInsertTransazione.setDouble(2, spesa);
                    stmtInsertTransazione.setString(3, "spesa");
                    stmtInsertTransazione.executeUpdate();
                }

                for (double accredito : portafoglio.getAccrediti()) {
                    stmtInsertTransazione.setString(1, username);
                    stmtInsertTransazione.setDouble(2, accredito);
                    stmtInsertTransazione.setString(3, "accredito");
                    stmtInsertTransazione.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePortafoglio(String username) {
        String deleteUser = "DELETE FROM utenti WHERE username = ?";
        String deleteTransazioni = "DELETE FROM transazioni WHERE username = ?";

        try {
            try (PreparedStatement stmtDeleteTransazioni = connection.prepareStatement(deleteTransazioni)) {
                stmtDeleteTransazioni.setString(1, username);
                stmtDeleteTransazioni.executeUpdate();
            }

            try (PreparedStatement stmtDeleteUser = connection.prepareStatement(deleteUser)) {
                stmtDeleteUser.setString(1, username);
                stmtDeleteUser.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
 */