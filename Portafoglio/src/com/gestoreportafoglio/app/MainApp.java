package com.gestoreportafoglio.app;

import com.gestoreportafoglio.dao.PortafoglioDAOImpl;
import com.gestoreportafoglio.service.GestionePortafoglio;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il tuo username:");
        String username = scanner.nextLine();

        GestionePortafoglio gestionePortafoglio = new GestionePortafoglio(username, new PortafoglioDAOImpl());

       
        scanner.close();
        System.out.println("Connessione DB fatta!");
    }
}
