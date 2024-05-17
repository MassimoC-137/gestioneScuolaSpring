package it.prova.gestionescuolaspring.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestionescuolaspring.model.Classe;
import it.prova.gestionescuolaspring.model.Studente;

@Service
public class SequenzaTestService {

	@Autowired
	private StudenteService studenteService; 
	@Autowired
	private ClasseService classeService; 
	
	
	public void testCreateClasse() {
		
		classeService.createClasse(new Classe(1, 'A'));
		classeService.createClasse(new Classe(1, 'B'));
		classeService.createClasse(new Classe(1, 'C'));
		
		if (classeService.readAllClassi().isEmpty()) 
			throw new RuntimeException("Errore nella creazione delle classi. Creazione fallita."); 
		System.out.println("Creazione delle classi avvenuta con successo.");
	}
	
	public void testCreateStudente() {
		
		Classe classe1A = classeService.findByAnnoAndSezione(1, 'A');
        Classe classe1B = classeService.findByAnnoAndSezione(1, 'B');
        Classe classe1C = classeService.findByAnnoAndSezione(1, 'C');
        
		studenteService.createStudente(new Studente("M001", "Albert", "Einstein", LocalDate.of(1879, 3, 14), classe1A));
	    studenteService.createStudente(new Studente("M002", "Marie", "Curie", LocalDate.of(1867, 11, 7), classe1B));
	    studenteService.createStudente(new Studente("M003", "Nikola", "Tesla", LocalDate.of(1856, 7, 10), classe1A));
	    studenteService.createStudente(new Studente("M004", "Richard", "Feynman", LocalDate.of(1918, 5, 11), classe1A));
	    studenteService.createStudente(new Studente("M005", "Alan", "Turing", LocalDate.of(1912, 6, 23), classe1A));
	    studenteService.createStudente(new Studente("M006", "J. Robert", "Oppenheimer", LocalDate.of(1904, 4, 22), classe1A));
	    studenteService.createStudente(new Studente("M007", "Enrico", "Fermi", LocalDate.of(1901, 9, 29), classe1B));
	    studenteService.createStudente(new Studente("M008", "Erwin", "Schrödinger", LocalDate.of(1887, 8, 12), classe1A));
	    studenteService.createStudente(new Studente("M009", "Werner", "Heisenberg", LocalDate.of(1901, 12, 5), classe1B));
	    studenteService.createStudente(new Studente("M010", "Max", "Planck", LocalDate.of(1858, 4, 23), classe1A));
	    studenteService.createStudente(new Studente("M011", "Massimo", "Caramanna", LocalDate.of(1994, 9, 6), classe1C));
	}
	
	public void testSpostaStudenteInClasse() {
	    Classe nuovaClasse = classeService.findByAnnoAndSezione(1, 'B');
	    studenteService.spostaStudenteInClasse(3L, nuovaClasse);

	    Studente studente = studenteService.readStudente(3L);
	    if (studente.getClasse().equals(nuovaClasse)) {
	        System.out.println("Spostamento nella nuova classe avvenuto con successo.");
	    } else {
	        throw new RuntimeException("Errore nello spostamento dello studente.");
	    }
	}
	

	
}
