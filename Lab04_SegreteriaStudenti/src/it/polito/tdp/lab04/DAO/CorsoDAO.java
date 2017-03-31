package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {

	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Corso c = new Corso(rs.getString("codins"),rs.getInt("crediti"),rs.getString("nome"),rs.getInt("pd"));
				
                corsi.add(c);
				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo Corso alla lista
			}
            
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		return corsi;
	}
	
	public String findCodicePerNomeCorso(String nomeCorso){
		String codiceCorso="";
		final String sqlQuery="SELECT codins "+
                               "FROM corso "+
                               "WHERE nome=?";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sqlQuery);
			st.setString(1, nomeCorso);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				 codiceCorso = rs.getString("codins");
			}
            
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		return codiceCorso;
		
		
		
		
		
	}

	

	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public void getCorso(Corso corso) {
		// TODO
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public void getStudentiIscrittiAlCorso(Corso corso) {
		
	}

	/*
	 * Data una matricola ed il codice insegnamento,
	 * iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		return false;
	}
	
	

	public List<Corso> findCorsiPerMatricola(String matricola) {
	final String sqlQuery="SELECT * "+
			               "FROM corso c, iscrizione i "+
			               "WHERE c.codins=i.codins and i.matricola=?";
	
	List <Corso> listaCorsi = new LinkedList <Corso>();
	try {
		Connection conn = ConnectDB.getConnection();
		PreparedStatement st = conn.prepareStatement(sqlQuery);
		st.setString(1, matricola);
		
		ResultSet rs = st.executeQuery();
		
		
		while(rs.next()){
	    	  Corso c = new Corso(rs.getString("codins"), rs.getInt("crediti"),rs.getString("nome"),rs.getInt("pd"));
	         listaCorsi.add(c);
	     }

	

	} catch (SQLException e) {
		// e.printStackTrace();
		throw new RuntimeException("Errore Db");
	}		
	
	
		return listaCorsi;
	}
	
	
	
}
