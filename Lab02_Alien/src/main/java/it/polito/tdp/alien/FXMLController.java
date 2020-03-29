package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	AlienDictionary dizionario = new AlienDictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtTranslate;

    @FXML
    private Button btmTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btmClear;

    @FXML
    void clearArea(ActionEvent event) {
    	txtResult.clear();
    }

    @FXML
    void translate(ActionEvent event) {
    	String daTradurre = txtTranslate.getText();
    	
    	if(daTradurre == null || daTradurre.isEmpty()) {
    		txtResult.appendText("Necessario inserire un testo affinché si possa effettuare la traduzione");
    	}
    	
    	String[] parole = daTradurre.split("\\s+");
    	
    	if(parole.length == 1) {
    		txtResult.appendText(dizionario.TranslateWord(daTradurre) + "\n");
    	}
    	
    	if(parole.length == 2) {
    		dizionario.addWord(parole[0], parole[1]);
//    		txtResult.appendText("La parola aliena: '" + parole [0] + "' è stata inserita con traduzione '" + parole[1] + "'");
    	}
    	
    	if(parole.length > 2) {
    		txtResult.appendText("Errore nell'inserizione; inserire <ParolaAliena> (spazio) <Traduzione> \n");
    	}
    	
    	txtTranslate.clear();
    
    }

    @FXML
    void initialize() {
        assert txtTranslate != null : "fx:id=\"txtTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btmTranslate != null : "fx:id=\"btmTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btmClear != null : "fx:id=\"btmClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
