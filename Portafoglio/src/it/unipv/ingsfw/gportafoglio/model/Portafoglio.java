package it.unipv.ingsfw.gportafoglio.model;

import java.util.ArrayList;
import java.util.Date;

public class Portafoglio {
    private double saldo;
    private ArrayList<Transazione> transazioni;

    public Portafoglio(double saldo, ArrayList<Transazione> transazioni) {
        this.saldo = saldo;
        this.transazioni = transazioni;
    }

    public double getSaldo() {
        return saldo;
    }

    public void spesa(double valore, String motivo) {
        saldo -= valore;
        transazioni.add(new Transazione(valore, motivo, new Date(), "spesa"));
    }

    public void accredito(double valore, String motivo) {
        saldo += valore;
        transazioni.add(new Transazione(valore, motivo, new Date(), "accredito"));
    }

    public ArrayList<Transazione> getTransazioni() {
        return transazioni;
    }
}

/*
public class Portafoglio {

	private double saldo;
	private ArrayList <Double> spese;
	private ArrayList <Double> accrediti;

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public ArrayList<Double> getSpese() {
		return spese;
	}

	public void setSpese(ArrayList<Double> spese) {
		this.spese = spese;
	}

	public ArrayList<Double> getAccrediti() {
		return accrediti;
	}

	public void setAccrediti(ArrayList<Double> accrediti) {
		this.accrediti = accrediti;
	}

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

}
*/