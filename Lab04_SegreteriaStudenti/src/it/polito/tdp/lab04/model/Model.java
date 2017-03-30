package it.polito.tdp.lab04.model;

import java.util.*;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	
	
	
	public List<String> getListaCorsiNome(){
		CorsoDAO cDAO= new CorsoDAO();
		List<String > listaCodiciCorso= new LinkedList<String>();
		listaCodiciCorso.add("");
		for(Corso c: cDAO.getTuttiICorsi()){
			listaCodiciCorso.add(c.getNome());
		}
	return listaCodiciCorso;	
	
	}
	
	
	
	
	
	
	public Studente findStudentePerMatricola(String matricola){
		StudenteDAO sDAO = new StudenteDAO();
		Studente s=sDAO.findStudentePerMatricola(matricola);
		return s;
		
	}
	public String cercaNomePerMatricola(String matricola){
		String  nome= findStudentePerMatricola(matricola).getNome();
		return nome;
	}
	public String cercaCognomePerMatricola(String matricola){
		String cognome= findStudentePerMatricola(matricola).getCognome();
		return cognome;
	}






	public String StudentiIscritti(String corso) {
		StudenteDAO sDAO = new StudenteDAO();
	    String result="";
	    for(Studente stud:sDAO.findStudentiPerNomeCorso(corso)){
	    	result+=stud.toString()+"\n";
	    }		
	   return result;
		
	}
	

	
	
	
	
}
