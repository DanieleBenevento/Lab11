package it.polito.tdp.model;

public class Model {

	private Simulatore sim;
	
	public Model() {
		sim=new Simulatore();
	}
	
	public void Simula() {
		
		sim.init();
		sim.run();
	}

	public Simulatore getSim() {
		return sim;
	}
	
	
	
	
	
}
