package it.polito.tdp.lab04.model;

import java.util.*;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.IscrizioneDAO;
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






	public String CorsiPerStudente(String matricola) {
		CorsoDAO cDAO = new CorsoDAO();
		 String result="";
		for(Corso c:cDAO.findCorsiPerMatricola(matricola)){
			result+=c.toString()+"\n";
		}
		
		
		return result;
	}
	
	
	
	public boolean matricolaCoretta(String matricola){
		boolean bool=true;
		for(char c: matricola.toCharArray()){
			if(c<48||c>57){
				bool=false;
			}
		}
		
		
		if(findStudentePerMatricola(matricola)==null||matricola.length()!=6||bool==false)
		return false;
		
		return true;
		
	}






	public String IscriviStudenteACorso(String matricola, String nomeCorso) {
		
		CorsoDAO cDAO = new CorsoDAO();
		String codiceCorso=cDAO.findCodicePerNomeCorso(nomeCorso);
		
		IscrizioneDAO iDAO = new IscrizioneDAO();
		if(iDAO.findIscrizione(matricola,codiceCorso)==false){
	     iDAO.InsertStudenteACorso(matricola,codiceCorso);
		
		return "studente iscritto correttamente\n";
		
		}
		else{
		
		return "studente gia iscritto al corso\n";
		}
		
		
		
	}

	
	
	
	
}
