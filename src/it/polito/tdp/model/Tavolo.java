package it.polito.tdp.model;

public class Tavolo {
	
	private int posti;
	private int id;
	private boolean statoTavolo;
	
	
	public Tavolo(int posti,int id) {
		
		this.posti = posti;
		this.id=id;
		this.statoTavolo=false;
	}


	public int getPosti() {
		return posti;
	}


	public void setPosti(int posti) {
		this.posti = posti;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public void occupaTavolo() {
		this.statoTavolo=true;
	}
	public void liberaTavolo() {
		this.statoTavolo=false;
	}
	
	public boolean getStatoTavolo() {
		return statoTavolo;
	}
	

}
