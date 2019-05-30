package it.polito.tdp.bar;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BarController {
	
	private Model model= new Model();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSimula;

    @FXML
    private TextArea txtResult;

    @FXML
    void doSimula(ActionEvent event) {
    	
    	model.Simula();
    	txtResult.clear();
    	txtResult.appendText("Clienti totali: "+model.getSim().getN_TOTCLIENTI()+"\n"+"Clienti soddisfatti: "+model.getSim().getN_CLIENTI_SODDISFATTI()+"\n"+"Clienti isoddisfatti: "+model.getSim().getN_CLIENTI_INSODDISFATTI()+"\n");

    }

    @FXML
    void initialize() {
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Bar.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Bar.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model=model;
    }
}

