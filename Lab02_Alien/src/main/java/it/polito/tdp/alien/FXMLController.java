package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private AlienDictionary dizionario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TextField txtInput;
    
    @FXML
    private Button btnTranslate;
    
    @FXML
    private TextArea txtRis;
    
    @FXML
    private Button btnReset;

    @FXML
    void doTranslate(ActionEvent event) {
    	 String testo= this.txtInput.getText().toLowerCase();
    	 if (testo.isEmpty()) {
    		 this.txtRis.setText("Inserire una parola da cercare, o una parola e la sua traduzione");
    		 return;
    	 }
    	 
    	 if (testo.contains("<")==false || testo.contains(">")==false) {
    		 this.txtRis.setText("FORMATO SBAGLIATO, inserire <alienWord> <translate> o solo <alienWord>");
    		 return;
    	 }
    	 String[] campi= testo.split("> <");
    	 Pattern pattern = Pattern.compile("[A-Za-z]*");
    	 Matcher matcher = pattern.matcher(campi[0]);
    	 //Matcher matcher2= pattern.matcher(campi[1]);
    	 if (matcher.matches()) {
    		 this.txtRis.setText("Sono ammesse solo lettere, maiuscole o minuscole");
    		 return;
    	 }
    	 if (campi.length>2) {
    		 this.txtRis.setText("Inserire max 2 stringhe: parola e traduzione");
    		 return;
    	 }
    	 if(campi.length==1) {
    		 String parolaAliena=campi[0].substring(1,campi[0].length()-1);
    		 this.txtRis.setText("La traduzione della parola "+parolaAliena+" e': \n"+dizionario.transalteWord(parolaAliena));
    	 } else {
    		 String parolaAliena=campi[0].substring(1);
    		 String traduzione=campi[1].substring(0, campi[1].length()-1);
    		 this.dizionario.addWord(parolaAliena, traduzione);
    		 this.txtRis.setText("Aggiunta la parola "+parolaAliena+" con la seguente traduzione: "+traduzione);
    	 }
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	this.txtInput.clear();
    	this.txtRis.clear();
    }
    
    public void setModel(AlienDictionary model) {
    	this.dizionario=model;
    }
    
    
    @FXML
    void initialize() {
    	 assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
         assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
         assert txtRis != null : "fx:id=\"txtRis\" was not injected: check your FXML file 'Scene.fxml'.";
         assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
    }
}