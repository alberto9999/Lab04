package it.polito.tdp.lab04.model;

public class Studente {
private 	String matricola;
private 	String nome;
private 	String cognome;
private  String cds;


public String getCds() {
	return cds;
}
public void setCds(String cds) {
	this.cds = cds;
}
public String getMatricola() {
	return matricola;
}
public void setMatricola(String matricola) {
	this.matricola = matricola;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCognome() {
	return cognome;
}
public void setCognome(String cognome) {
	this.cognome = cognome;
}



@Override
public String toString() {
	return "Studente [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + ", cds=" + cds + "]";
}
public Studente(String  matricola, String cognome, String nome, String cds) {
	super();
	this.matricola = matricola;
	this.nome = nome;
	this.cognome = cognome;
	this.cds=cds;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((matricola == null) ? 0 : matricola.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Studente other = (Studente) obj;
	if (matricola == null) {
		if (other.matricola != null)
			return false;
	} else if (!matricola.equals(other.matricola))
		return false;
	return true;
}



	
}
