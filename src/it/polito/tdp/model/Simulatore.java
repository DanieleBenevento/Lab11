package it.polito.tdp.model;

import java.time.LocalTime;
import java.util.PriorityQueue;

import it.polito.tdp.model.Evento.TipoEvento;

public class Simulatore {
	
	private int N_TAVOLI =15;
	private int N_TOTCLIENTI;
	private int N_CLIENTI_INSODDISFATTI ;
	private int N_CLIENTI_SODDISFATTI;
	private Tavolo[] tavoli;
	private PriorityQueue<Evento> queue;
	

	public Simulatore() {
		
		queue=new PriorityQueue<>();
		tavoli=new Tavolo[N_TAVOLI];
		
		for(int i=0;i<2;i++) {
			tavoli[i]=new Tavolo(10,i+1);
		}
		for(int i=2;i<6;i++) {
			tavoli[i]=new Tavolo(8,i+1);
		}
		for(int i=6;i<10;i++) {
			tavoli[i]=new Tavolo(6,i+1);
		}
		for(int i=10;i<15;i++) {
			tavoli[i]=new Tavolo(4,i+1);
		}
	}
	
	public void init() {
		this.N_CLIENTI_INSODDISFATTI=0;
		this.N_CLIENTI_SODDISFATTI=0;
		this.N_TOTCLIENTI=0;
		
		queue.add(new Evento(LocalTime.of(8, 00),TipoEvento.ARRIVO_GRUPPO_CLIENTI,new Cliente()));
	}
	
	public void run() {
		
		while(!queue.isEmpty() && this.N_TOTCLIENTI <=1999) {
			
			Evento e=queue.poll();
			switch(e.getType()) {
			case ARRIVO_GRUPPO_CLIENTI:
				int min=11;
				int numTavoloAssegnato=0;
				this.N_TOTCLIENTI++;
				for(Tavolo t: tavoli) {
					if(t.getStatoTavolo()==false) {
						if(t.getPosti()<=e.getnPersone()*2) {
					if(	min>(t.getPosti()-e.getnPersone()) && (t.getPosti()-e.getnPersone())>=0 ) {
						min=(t.getPosti()-e.getnPersone());
						numTavoloAssegnato=t.getId();
					}
					}
					}
				}
				if(numTavoloAssegnato==0) {
					if(e.getTolleranza()< Math.random()) {
						this.N_CLIENTI_INSODDISFATTI++;
					}else {
						this.N_CLIENTI_SODDISFATTI++;
					}
				}else {
				tavoli[numTavoloAssegnato-1].occupaTavolo();
				e.getC().setTavolo(numTavoloAssegnato);
				this.N_CLIENTI_SODDISFATTI++;
				queue.add(new Evento(e.getT().plusMinutes(e.getD().toMinutes()),TipoEvento.USCITA_GRUPPO_CLIENTI,e.getC()));
				}
				queue.add(new Evento(e.getT().plusMinutes(e.getIntervallo().toMinutes()),TipoEvento.ARRIVO_GRUPPO_CLIENTI,new Cliente()));
			    break;
			    
			case USCITA_GRUPPO_CLIENTI:
				tavoli[(e.getC().getIdTavoloAssegnato()-1)].liberaTavolo();
				break;
			}
			
		
		}
		
	}

	public int getN_TAVOLI() {
		return N_TAVOLI;
	}

	public int getN_TOTCLIENTI() {
		return N_TOTCLIENTI;
	}

	public int getN_CLIENTI_INSODDISFATTI() {
		return N_CLIENTI_INSODDISFATTI;
	}

	public int getN_CLIENTI_SODDISFATTI() {
		return N_CLIENTI_SODDISFATTI;
	}

	public Tavolo[] getTavoli() {
		return tavoli;
	}

	public PriorityQueue<Evento> getQueue() {
		return queue;
	}
	
	

}
