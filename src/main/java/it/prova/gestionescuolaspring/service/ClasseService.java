package it.prova.gestionescuolaspring.service;

import java.util.List;

import it.prova.gestionescuolaspring.model.Classe;

public interface ClasseService {

	public void createClasse(Classe classe); 
	
	public Classe readClasse(Long id); 
	
	public List<Classe> readAllClassi(); 
	
	public void updateClasse(Classe classe); 
	
	public void deleteClasse(Classe classe); 
	
}
