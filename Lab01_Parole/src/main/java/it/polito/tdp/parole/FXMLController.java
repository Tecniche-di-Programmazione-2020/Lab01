package it.polito.tdp.parole;

import it.polito.tdp.parole.model.ParoleArray;
import it.polito.tdp.parole.model.ParoleLinked;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	ParoleArray elenco1 ;
	ParoleLinked elenco2;
	
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
    	
    	List<String> lista;
    	long start;
    	long stop;
    	long clcTimeArray;
    	long clcTimeLinked;
    	
    	start= System.nanoTime();
    	if(elenco1.cancella(txtParola.getText())==false) {stop= System.nanoTime();clcTimeArray=stop-start;}
    	
    	else {
    	lista=elenco1.getElenco();
    	stop= System.nanoTime();
    	clcTimeArray=stop-start;
    	
    	}
    	
    	
    	start= System.nanoTime();
    	if(elenco1.cancella(txtParola.getText())==false) {stop= System.nanoTime();clcTimeLinked=stop-start;this.graficaUpdate(null,clcTimeLinked,clcTimeArray);}
    	
    	else {
    	lista=elenco1.getElenco();
    	stop= System.nanoTime();
    	clcTimeLinked=stop-start;
    	this.graficaUpdate(lista,clcTimeLinked,clcTimeArray);
    	}
    	
    	
    	
    	
    }

    @FXML
    void doInsert(ActionEvent event) {
    	List<String> lista;
    	long start;
    	long stop;
    	//calcolo tempi ArrayList
    	start= System.nanoTime();
    	elenco1.addParola(txtParola.getText());
    	lista=elenco1.getElenco();
    	stop= System.nanoTime();
    	
    	long clcTimeArray=stop-start;
    	
    	//calcolo tempi linkedList
    	start= System.nanoTime();
    	elenco2.addParola(txtParola.getText());
    	lista=elenco2.getElenco();
    	stop= System.nanoTime();
    	
    	long clcTimeLinked=stop-start;
    	
    	
    	
    	
    	
    	
    	//aggiorno la grafica
    	this.graficaUpdate(lista,clcTimeLinked,clcTimeArray);
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	List<String> lista;
    	long start;
    	long stop;
    	
    	//calcolo tempi arrayList
    	start= System.nanoTime();
    	elenco1.reset();
    	lista=elenco1.getElenco();
    	stop= System.nanoTime();
    	long clcTimeArray=stop-start;
    	
    	
    	//calcolo tempi LinkedList
    	start= System.nanoTime();
    	elenco2.reset();
    	lista=elenco2.getElenco();
    	stop= System.nanoTime();
    	long clcTimeLinked=stop-start;
    	
    	//aggiorna grafica
    	this.graficaUpdate(lista,clcTimeLinked,clcTimeArray);
    	
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco1 = new ParoleArray() ;
        elenco2 = new ParoleLinked() ;
    }
    
    void graficaUpdate(List<String> lista,long clcTimeLinked,long clcTimeArray ) {
    	if(lista==null) {txtResult.appendText("ERRORE\n");return;}
    	
    	String txt="";
    	txtParola.clear();
    	for(String s:lista) {txt+=s+"\n";}
    	txtResult.setText(txt);
    	
    	
    	
    }
    
    
    
    
    
    
    
}
