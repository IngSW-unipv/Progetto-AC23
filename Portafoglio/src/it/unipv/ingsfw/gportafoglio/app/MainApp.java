package it.unipv.ingsfw.gportafoglio.app;

import it.unipv.ingsfw.gportafoglio.controller.SetLoginController;
import it.unipv.ingsfw.gportafoglio.service.DbController;
import it.unipv.ingsfw.gportafoglio.service.GestionePortafoglio;
import it.unipv.ingsfw.gportafoglio.view.LogInView;
import it.unipv.ingsfw.gportafoglio.view.MainFrame;
import it.unipv.ingsfw.gportafoglio.view.PswSettingView;
import it.unipv.ingsfw.gportafoglio.controller.*;


public class MainApp {
    public static void main(String[] args) {
    	

    	PswSettingView psw = new PswSettingView();
    	SetLoginController setContr = new SetLoginController(psw);
    	
    	while(!psw.isAlreadyLogged()) {
    		psw.toString();
    	}
    	LogInView log = new LogInView();
    	LoginController logContr = new LoginController(log);
    	
    	while(!log.isUnlocked()) {
    		log.toString();
    	}
    	
    	DbController connection = new DbController();
    	GestionePortafoglio model = logContr.getModel();
    	
    	MainFrame main = new MainFrame();
    	MainViewController viewC = new MainViewController(main, model);
    
    }
}
