package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;


public class StudenteDAO {

	
	
	public Studente findStudentePerMatricola(String matricola){
		
		final String sqlQuery="SELECT * FROM studente WHERE matricola = ?";
		Studente result =null;		            		  
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sqlQuery);
			st.setString(1, matricola);
			
			ResultSet rs = st.executeQuery();
			
			
			if(rs.next()){
		    	  Studente s   = new Studente(matricola,rs.getString("cognome"),rs.getString("nome"),rs.getString("CDS"));
		          result = s;
		     }
			
			else{
				result =null;
			}
		    
		     
		      return result;

		

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}		
	}
	
	
	
	
	
	
	

	public List<Studente> findStudentiPerNomeCorso(String Corso){
		
		final String sqlQuery="SELECT s.matricola,cognome,nome,cds "+
                              "FROM studente s,( "+
                                                   "SELECT distinct matricola "+
                                                    "FROM corso c, iscrizione i "+
                                                    "WHERE c.codins=i.codins AND c.nome=?)AS matr "+
                              "WHERE s.matricola=matr.matricola ";	
		List<Studente>listaStudenti=new LinkedList<Studente>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sqlQuery);
			st.setString(1, Corso);
			
			ResultSet rs = st.executeQuery();
			
			
			while(rs.next()){
		    	  Studente s   = new Studente(rs.getString("matricola"),rs.getString("cognome"),rs.getString("nome"),rs.getString("CDS"));
		         listaStudenti.add(s);
		     }
			
		      return listaStudenti;

		

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}		
	}
	
	
	
	
	
	

}


