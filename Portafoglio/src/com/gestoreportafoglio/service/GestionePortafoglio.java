package com.gestoreportafoglio.service;

import com.gestoreportafoglio.dao.PortafoglioDAO;
import com.gestoreportafoglio.dao.PortafoglioDAOImpl;

import Portafoglio.Portafoglio;

public class GestionePortafoglio {
    private Portafoglio portafoglio;
    private PortafoglioDAO portafoglioDAO;
    private String username;

    public GestionePortafoglio(String username, PortafoglioDAO portafoglioDAO) {
        this.username = username;
        this.portafoglioDAO = portafoglioDAO;
    }
/*
    public void aggiungiSpesa(double valore) {
        portafoglio.spesa(valore);
        portafoglioDAO.addSpesa(username, valore);
        portafoglioDAO.savePortafoglio(username, portafoglio);
    }

    public void aggiungiAccredito(double valore) {
        portafoglio.accredito(valore);
        portafoglioDAO.addAccredito(username, valore);
        portafoglioDAO.savePortafoglio(username, portafoglio);
    }

    public void visualizzaPortafoglio() {
        System.out.println("Saldo: " + portafoglio.getSaldo());
        System.out.println("Spese: " + portafoglio.getSpese());
        System.out.println("Accrediti: " + portafoglio.getAccrediti());
    }

    public static void main(String[] args) {
        PortafoglioDAO portafoglioDAO = new PortafoglioDAOImpl();
        GestionePortafoglio gestione = new GestionePortafoglio("username_corretto", portafoglioDAO);

        gestione.aggiungiSpesa(50.0);
        gestione.aggiungiAccredito(100.0);
        gestione.visualizzaPortafoglio();
    }*/
}
