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
	
	long tinizio;
	long tfine;

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
    	
    	tinizio = System.nanoTime();
    	
    	if(txtParola.getText().compareTo("") == 0)
    		txtResult.setText("Non hai inserito nulla!");
    	else {
    		
    		elenco.addParola(txtParola.getText());
    		
    		txtResult.clear();
    		
    		for(String s : elenco.getElenco())
    			txtResult.appendText(s+"\n");
    		
    	}
    	
    	txtParola.clear();
    	
    	tfine = System.nanoTime();
    	
    	txtTime.setText(String.valueOf((double)(tfine-tinizio)/1e6)+" millisecondi");
    	
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	
    	tinizio = System.nanoTime();
    	
    	if(txtResult.getSelectedText().compareTo("") == 0)
    		txtResult.setText("Non hai inserito nulla!");
    	
    	
    	
    	for(String s : elenco.getElenco())
    		if(s.compareTo(txtResult.getSelectedText()) == 0) {
    			elenco.cancella(txtResult.getSelectedText());
    		}
    	
    	txtResult.clear();
    		
    	for(String se : elenco.getElenco())
       		txtResult.appendText(se+"\n");
    		
    	txtParola.clear();
    	
    	tfine = System.nanoTime();
    	
    	txtTime.setText(String.valueOf((double)(tfine-tinizio)/1e6)+" millisecondi");

    }
    
    @FXML
    void doReset(ActionEvent event) {
    	
    	tinizio = System.nanoTime();
    	
    	elenco.reset();
    	txtParola.clear();
    	txtResult.clear();
    	
    	tfine = System.nanoTime();
    	
    	txtTime.setText(String.valueOf((double)(tfine-tinizio)/1e6)+" millisecondi");
    	
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
