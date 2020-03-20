package it.polito.tdp.parole;

import it.polito.tdp.parole.model.ParoleArray;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	ParoleArray elenco ;
	
	
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
    private Button btnReset;
    
    @FXML
    private Button btnCancella;
    
    @FXML
    private TextField timeLinked;

    @FXML
    private TextField timeArray;
    @FXML
    void doCancella(ActionEvent event) {
    	if(elenco.cancella(txtParola.getText())==false)txtResult.appendText("ERRORE\n");
    	else {
    	List<String> lista=elenco.getElenco();
    	this.graficaUpdate(lista);
    	}

    }

    @FXML
    void doInsert(ActionEvent event) {
    	
    	elenco.addParola(txtParola.getText());
    	List<String> lista=elenco.getElenco();
    	this.graficaUpdate(lista);
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	elenco.reset();
    	List<String> lista=elenco.getElenco();
    	this.graficaUpdate(lista);
    	
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new ParoleArray() ;
    }
    
    void graficaUpdate(List<String> lista) {
    	String txt="";
    	txtParola.clear();
    	for(String s:lista) {txt+=s+"\n";}
    	txtResult.setText(txt);
    	
    	
    	
    }
    
    
    
    
    
    
    
}
