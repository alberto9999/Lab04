package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class SegreteriaStudentiController {
	
	Model model;
	
	

    public void setModel(Model model) {
		this.model = model;
		comboCorso.getItems().addAll(model.getListaCorsiNome());
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboCorso;

    @FXML
    private Button btnCercaIscrittiCorso;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button btnTrova;

    @FXML
    private TextField txtNome;;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doCercaCorsi(ActionEvent event) {

    }

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {
    	String corso= comboCorso.getValue();
    	if(corso.compareTo("")==0){
    		txtResult.setText("Inserire un corso");	
    	}
    	else{
    		txtResult.setText(model.StudentiIscritti(corso));
    	}

    }
   
    @FXML
    void doCercaNome(ActionEvent event) {
 	
    	String matricola=txtMatricola.getText();
    	if(model.findStudentePerMatricola(matricola)!=null){
    	txtNome.setText(model.cercaNomePerMatricola(matricola));
    	txtCognome.setText(model.cercaCognomePerMatricola(matricola));
    	}
    	else{
    		txtResult.appendText("matricola "+matricola+" non trovata.");
    	}
    	
 
    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.setText("");
    	txtNome.setText("");
    	txtCognome.setText("");
    	txtMatricola.setText("");

    }

    @FXML
    void initialize() {
        assert comboCorso != null : "fx:id=\"comboCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnTrova != null : "fx:id=\"btnTrova\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

       
        
        
       
    }
}
