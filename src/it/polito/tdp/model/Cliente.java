package it.polito.tdp.model;

public class Cliente {

	private int nPersone;
	private float tolleranza;
	private int idTavoloAssegnato;
	public Cliente() {
		
		this.nPersone=(int) Math.round((Math.random()*9)+1);
		this.tolleranza= (float) (Math.random()*0.9);
		
	}

	public int getnPersone() {
		return nPersone;
	}

	public float getTolleranza() {
		return tolleranza;
	}
	public void setTavolo(int id) {
		this.idTavoloAssegnato=id;
	}

	public int getIdTavoloAssegnato() {
		return idTavoloAssegnato;
	}
	


	
	
	
	
}
