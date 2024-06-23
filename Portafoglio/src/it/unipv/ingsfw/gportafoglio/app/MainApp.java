package it.unipv.ingsfw.gportafoglio.app;

import it.unipv.ingsfw.gportafoglio.controller.*;
import it.unipv.ingsfw.gportafoglio.view.*;

public class MainApp {
    public static void main(String[] args) {
    	
//    	MainFrame prova = new MainFrame();
//    	LogInView log = new LogInView();
    	
    	PswSettingView psw = new PswSettingView();
    	SetLoginController setContr = new SetLoginController(psw);
    	
    	while(!psw.isAlreadyLogged()) {
    		psw.toString();
    	}
//    	LogInView log = new LogInView();
//    	LoginController logContr = new LoginController(log);
//    	
//    	while(!log.isUnlocked()) {
//    		log.toString();
//    	}
    	
//	MainFrame prova = new MainFrame();
    }
}

/*
public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DbController dbController = new DbController();
        System.out.println("Inserisci il tuo username:");
        String username = scanner.nextLine();

        GestionePortafoglio gestionePortafoglio = new GestionePortafoglio(username, dbController.getPortafoglioDAO());

        while (true) {
            System.out.println("1. Aggiungi accredito");
            System.out.println("2. Aggiungi spesa");
            System.out.println("3. Visualizza saldo");
            System.out.println("4. Stampa transazioni");
            System.out.println("5. Esci");
            int scelta = scanner.nextInt();
            scanner.nextLine(); 

            if (scelta == 1) {
                System.out.println("Inserisci il valore dell'accredito:");
                double valore = scanner.nextDouble();
                scanner.nextLine(); 
                System.out.println("Inserisci il motivo dell'accredito:");
                String motivo = scanner.nextLine();
                gestionePortafoglio.aggiungiAccredito(valore, motivo);
            } else if (scelta == 2) {
                System.out.println("Inserisci il valore della spesa:");
                double valore = scanner.nextDouble();
                scanner.nextLine(); 
                System.out.println("Inserisci il motivo della spesa:");
                String motivo = scanner.nextLine();
                gestionePortafoglio.aggiungiSpesa(valore, motivo);
            } else if (scelta == 3) {
                System.out.println("Il saldo attuale è: " + gestionePortafoglio.getPortafoglio().getSaldo());
            } else if (scelta == 4) {
                gestionePortafoglio.stampaTransazioni();
            } else if (scelta == 5) {
                break;
            } else {
                System.out.println("Scelta non valida. Riprova.");
            }
        }

        scanner.close();
        dbController.closeConnection();
        System.out.println("Applicazione terminata.");
    }
}
*/
