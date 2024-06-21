package it.unipv.ingsfw.gportafoglio.service;

import it.unipv.ingsfw.gportafoglio.dao.*;
import it.unipv.ingsfw.gportafoglio.model.*;

public class GestionePortafoglio {
    private String username;
    private Portafoglio portafoglio;
    private PortafoglioDAO portafoglioDAO;

    public GestionePortafoglio(String username, PortafoglioDAO portafoglioDAO) {
        this.username = username;
        this.portafoglioDAO = portafoglioDAO;
        this.portafoglio = portafoglioDAO.getPortafoglioByUsername(username);
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

    public void stampaTransazioni() {
        for (Transazione transazione : portafoglio.getTransazioni()) {
            System.out.println(transazione.getData() + " - " + transazione.getTipo() + ": " + transazione.getValore() + " (" + transazione.getMotivo() + ")");
        }
    }
}

/*
public class GestionePortafoglio {
    private String username;
    private Portafoglio portafoglio;
    private PortafoglioDAO portafoglioDAO;

    public GestionePortafoglio(String username, PortafoglioDAO portafoglioDAO) {
        this.username = username;
        this.portafoglioDAO = portafoglioDAO;
        this.portafoglio = portafoglioDAO.getPortafoglioByUsername(username);
    }

    public void aggiungiAccredito(double valore) {
        portafoglio.accredito(valore);
        portafoglioDAO.updatePortafoglio(username, portafoglio);
    }

    public void aggiungiSpesa(double valore) {
        portafoglio.spesa(valore);
        portafoglioDAO.updatePortafoglio(username, portafoglio);
    }

    public Portafoglio getPortafoglio() {
        return portafoglio;
    }
}
*/
