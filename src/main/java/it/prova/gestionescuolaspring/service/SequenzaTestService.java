package it.prova.gestionescuolaspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.prova.gestionescuolaspring.model.Studente;
import it.prova.gestionescuolaspring.model.Classe;

@Service
public class SequenzaTestService {

	@Autowired
	private StudenteService studenteService; 
	@Autowired
	private ClasseService classeService; 
	
	
	public void testCreateClasse() {
		
		classeService.createClasse(new Classe(1, 'A'));
	}
	
	
}
