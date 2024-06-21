package it.unipv.ingsfw.gportafoglio.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Transazione {
    private double valore;
    private String motivo;
    private Date data;
    private String tipo; // "spesa" o "accredito"

    public Transazione(double valore, String motivo, Date data, String tipo) {
        this.valore = valore;
        this.motivo = motivo;
        this.data = data;
        this.tipo = tipo;
    }

    public Transazione(int int1, String string, double double1, String string2, String string3,
			LocalDateTime localDateTime) {
		// TODO Auto-generated constructor stub
	}

	public double getValore() {
        return valore;
    }

    public String getMotivo() {
        return motivo;
    }

    public Date getData() {
        return data;
    }

    public String getTipo() {
        return tipo;
    }
}
