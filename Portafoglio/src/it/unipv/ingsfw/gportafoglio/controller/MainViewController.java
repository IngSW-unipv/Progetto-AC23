package it.unipv.ingsfw.gportafoglio.controller;

import it.unipv.ingsfw.gportafoglio.service.GestionePortafoglio;
import it.unipv.ingsfw.gportafoglio.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainViewController {
	
	private MainFrame view;
	private GestionePortafoglio model;
	
	public MainViewController(MainFrame view, GestionePortafoglio model) {
		this.view = view;
		this.model = model;
		this.view.setTitle("Bentornato "+ model.getUsername());
		this.view.getSaldoTitle().setText("IL TUO SALDO: "+ this.model.getPortafoglio().getSaldo() + " EURO");
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
		
		ActionListener AccreditaButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String stringaImporto =  JOptionPane.showInputDialog(new JFrame(),"Inserisci importo (€)", null, JOptionPane.QUESTION_MESSAGE);
				String causale =  JOptionPane.showInputDialog(new JFrame(),"Inserisci la causale", null, JOptionPane.QUESTION_MESSAGE);
				stringaImporto = stringaImporto.replace(",",".");
				double importo =  Double.parseDouble(stringaImporto);
				model.aggiungiAccredito(importo, causale);
				view.getSaldoTitle().setText("IL TUO SALDO: "+ model.getPortafoglio().getSaldo() + " EURO");
			}
			
		};
		view.getAccreditaButton().addActionListener(AccreditaButtonListener);
		
		ActionListener SpesaButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String stringaImporto =  JOptionPane.showInputDialog(new JFrame(),"Inserisci importo (€)", null, JOptionPane.QUESTION_MESSAGE);
				String causale =  JOptionPane.showInputDialog(new JFrame(),"Inserisci la causale", null, JOptionPane.QUESTION_MESSAGE);
				stringaImporto = stringaImporto.replace(",",".");
				double importo =  Double.parseDouble(stringaImporto);
				model.aggiungiSpesa(importo, causale);
				view.getSaldoTitle().setText("IL TUO SALDO: "+ model.getPortafoglio().getSaldo() + " EURO");
			}
			
		};
		view.getSpesaButton().addActionListener(SpesaButtonListener);
		
		ActionListener EsciButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		};
		view.getEsciButton().addActionListener(EsciButtonListener);
	}

}
