package it.unipv.ingsfw.gportafoglio.dao;

import java.util.List;
import it.unipv.ingsfw.gportafoglio.model.Portafoglio;
import it.unipv.ingsfw.gportafoglio.model.Transazione;

public interface PortafoglioDAO {
    Portafoglio getPortafoglioByUsername(String username);
    void createPortafoglio(String username, String password);
    void updatePortafoglio(String username, Portafoglio portafoglio);
    void deletePortafoglio(String username);
    
    void aggiungiTransazione(String username, double valore, String motivo, String tipo);
    List<Transazione> getTransazioni(String username);
	Portafoglio getPortafoglioByUsername(String username, String password);
	
}