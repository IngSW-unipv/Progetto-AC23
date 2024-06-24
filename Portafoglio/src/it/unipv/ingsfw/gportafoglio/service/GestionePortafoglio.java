package it.unipv.ingsfw.gportafoglio.service;

import it.unipv.ingsfw.gportafoglio.dao.*;
import it.unipv.ingsfw.gportafoglio.model.*;

public class GestionePortafoglio implements AutoCloseable {
    private String username;
    private Portafoglio portafoglio;
    private PortafoglioDAO portafoglioDAO;

    public GestionePortafoglio(String username, String password, PortafoglioDAO portafoglioDAO) {
        this.username = username;
        this.portafoglioDAO = portafoglioDAO;
        this.portafoglio = portafoglioDAO.getPortafoglioByUsername(username, password);
    }
    
    public String getUsername() {
		return username;
	}

	public void aggiungiAccredito(double valore, String motivo) {
        portafoglio.accredito(valore, motivo);
        portafoglioDAO.updatePortafoglio(username, portafoglio);
    }

    public void aggiungiSpesa(double valore, String motivo) {
        portafoglio.spesa(valore, motivo);
        portafoglioDAO.updatePortafoglio(username, portafoglio);
    }

    public Portafoglio getPortafoglio() {
        return portafoglio;
    }

    public String stampaTransazioni() {
    	 String rslt = "";
        for (Transazione transazione : portafoglio.getTransazioni()) {
            System.out.println();
            rslt += transazione.getData() + " - " + transazione.getTipo() + ": " + transazione.getValore() + " (" + transazione.getMotivo() + ")\n";
        }
    return rslt;   
    }

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
