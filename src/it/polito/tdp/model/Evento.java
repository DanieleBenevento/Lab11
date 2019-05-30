package it.polito.tdp.model;

import java.time.Duration;
import java.time.LocalTime;

public class Evento implements Comparable<Evento>{

	private LocalTime t;
	private Duration d;
	private int nPersone;
	private float tolleranza;
	private TipoEvento type;
	private Cliente c;
	private Duration intervallo;
	
	public Evento(LocalTime t,TipoEvento type,Cliente c) {
		this.t=t;
		this.d=Duration.ofMinutes(60+Math.round(Math.random()*60));
	    this.c=c;
	    this.nPersone=c.getnPersone();
	    this.tolleranza=c.getTolleranza();
	    this.intervallo=Duration.ofMinutes(1+Math.round(Math.random()*9));
	    this.type=type;
	}
	
	public enum TipoEvento{
		ARRIVO_GRUPPO_CLIENTI,
		USCITA_GRUPPO_CLIENTI
	}

	public LocalTime getT() {
		return t;
	}

	public Duration getD() {
		return d;
	}

	public int getnPersone() {
		return nPersone;
	}

	public float getTolleranza() {
		return tolleranza;
	}

	public TipoEvento getType() {
		return type;
	}

	public Cliente getC() {
		return c;
	}

	public Duration getIntervallo() {
		return intervallo;
	}

	@Override
	public String toString() {
		return  type+", "+t +", "+ d + ", " + nPersone;
	}

	@Override
	public int compareTo(Evento e) {
		
		return t.compareTo(e.getT());
	}
	
	
	
	
}
