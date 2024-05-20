package Portafoglio;

import java.util.ArrayList;

public class Portafoglio {

	private double saldo;
	private ArrayList <Double> spese;
	private ArrayList <Double> accrediti;

	public Portafoglio() {
	}

	public Portafoglio(double saldo, ArrayList<Double> spese, ArrayList<Double> accrediti) {
		super();
		this.saldo = saldo;
		this.spese = spese;
		this.accrediti = accrediti;
	}

	public void spesa(double valore){
		saldo -= valore;
		spese.add(valore);
	}

	public void accredito(double valore) {
		saldo += valore;
		accrediti.add(valore);
	}

	
	//Inizializzare PF nel database
	// tabella utenti e tabella transazione
	//pattern per fare cose con database si chiama DAO



}
