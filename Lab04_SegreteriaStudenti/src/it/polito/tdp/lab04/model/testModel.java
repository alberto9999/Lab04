package it.polito.tdp.lab04.model;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.IscrizioneDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class testModel {

	public static void main(String[] args) {
		Model m= new Model();
/*		StudenteDAO stDAO= new StudenteDAO();
		Studente s= m.findStudentePerMatricola("146101");
       System.out.println(s);
       System.out.println(s.getCognome());
       
       CorsoDAO cDAO = new CorsoDAO();
       String codice= cDAO.findCodicePerNomeCorso("Gestione dell'innovazione e sviluppo prodotto");
       System.out.println(codice);*/
       
       IscrizioneDAO iDAO = new IscrizioneDAO();
   //    int result=iDAO.InsertStudenteACorso("148072","01KSUPG");
   //    System.out.println(result);
       
	}
	

}
