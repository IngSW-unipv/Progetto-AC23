package it.unipv.ingsfw.gportafoglio.controller;

import it.unipv.ingsfw.gportafoglio.model.*;
import it.unipv.ingsfw.gportafoglio.service.GestionePortafoglio;
import it.unipv.ingsfw.gportafoglio.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainViewController {
	
	private MainFrame view;
	private GestionePortafoglio model;
	
	public MainViewController(MainFrame view, GestionePortafoglio model) {
		this.view = view;
		this.model = model;
		addListeners();
		
	}
	private void addListeners() {
		
		ActionListener stampaTransazioniListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view.getLogArea().setText(model.stampaTransazioni());
			}
			
		};
		view.getStampaTransazioniButton().addActionListener(stampaTransazioniListener);
	}

}
