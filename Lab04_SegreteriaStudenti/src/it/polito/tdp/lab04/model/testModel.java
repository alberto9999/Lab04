package it.polito.tdp.lab04.model;

import it.polito.tdp.lab04.DAO.StudenteDAO;

public class testModel {

	public static void main(String[] args) {
		Model m= new Model();
		StudenteDAO stDAO= new StudenteDAO();
		Studente s= m.findStudentePerMatricola("146101");
       System.out.println(s);
       System.out.println(s.getCognome());
	}

}
