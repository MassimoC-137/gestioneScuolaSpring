package it.prova.gestionescuolaspring.service;

import java.util.List;

import it.prova.gestionescuolaspring.model.Studente;

public interface StudenteService {
	
	public void createStudente(Studente studente); 
	
	public Studente readStudente(Long id); 
	
	public List<Studente> readAllStudenti(); 
	
	public void updateStudente(Studente studente); 
	
	public void deleteStudente(Studente studente);

}
