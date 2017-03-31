package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class IscrizioneDAO {
	
	public boolean findIscrizione(String matricola, String codiceCorso){
		List<String> listaMatricoleIscritte	= new LinkedList<String >();
		boolean bool=false;
		final String sqlQuery="SELECT matricola "+
                               "FROM iscrizione "+
                               "WHERE codins=?";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sqlQuery);
			st.setString(1, codiceCorso);
			ResultSet rs= st.executeQuery();
			
			while(rs.next()){
				String matr=Integer.toString(rs.getInt("matricola"));
				listaMatricoleIscritte.add(matr);
			}
			for(String s:listaMatricoleIscritte){
				if(s.compareTo(matricola)==0){
					bool=true;
					break;
				}
			}
			
			}
            
			catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		return bool;
		
		
}

	public  void InsertStudenteACorso(String matricola, String codiceCorso) {
		final String sqlQuery="INSERT INTO `iscritticorsi`.`iscrizione` (`matricola`, `codins`) VALUES (?,?)";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sqlQuery);
			st.setString(1, matricola);
			st.setString(2, codiceCorso); 
			st.executeUpdate();

			}
            
			catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
	}
}
