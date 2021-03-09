package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco;
	
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea txtTime;

    @FXML
    private Button btnReset;
    
    @FXML
    void doInsert(ActionEvent event) {
    	
    	// TODO
    	if(txtParola.getText().compareTo("") == 0)
    		txtResult.setText("Non hai inserito nulla!");
    	else {
    		
    		elenco.addParola(txtParola.getText());
    		
    		txtResult.clear();
    		
    		for(String s : elenco.getElenco())
    			txtResult.appendText(s+"\n");
    		
    	}
    	
    	txtParola.clear();
    	
    	txtTime.setText(String.valueOf(System.nanoTime()));
    	
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	
    	if(txtParola.getText().compareTo("") == 0)
    		txtResult.setText("Non hai inserito nulla!");
    	
    	boolean trovata = false;
    	
    	for(String s : elenco.getElenco())
    		if(s.compareTo(txtParola.getText()) == 0) {
    			
    			trovata = true;
    			elenco.cancella(txtParola.getText());
    			
    		}
    	
    	if(trovata == false)
    		txtResult.setText("Hai inserito una parola inesistente!");
    	else {
    		
    		txtResult.clear();
    		
    		for(String se : elenco.getElenco())
        			txtResult.appendText(se+"\n");
    		
    	}
    		
    	txtParola.clear();
    	
    	txtTime.setText(String.valueOf(System.nanoTime()));
    	
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	
    	// TODO
    	elenco.reset();
    	txtParola.clear();
    	txtResult.clear();
    	
    	txtTime.setText(String.valueOf(System.nanoTime()));
    	
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
