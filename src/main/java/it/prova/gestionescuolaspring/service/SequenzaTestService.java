package it.prova.gestionescuolaspring.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
//	*******************************************	
	public void testCreateClasse() {
		
		classeService.createClasse(new Classe(1, 'A'));
		classeService.createClasse(new Classe(1, 'B'));
		classeService.createClasse(new Classe(3, 'L'));
		
		if (classeService.readAllClassi().isEmpty()) 
			throw new RuntimeException("Errore nella creazione delle classi. Creazione fallita."); 
		System.out.println("Creazione delle classi avvenuta con successo.");
	}
//	*******************************************	
	public void testCreateStudente() {
		
		Classe classe1A = classeService.findByAnnoAndSezione(1, 'A');
        Classe classe1B = classeService.findByAnnoAndSezione(1, 'B');
        Classe classe3L = classeService.findByAnnoAndSezione(3, 'L');
        
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
	    studenteService.createStudente(new Studente("M011", "Massimo", "Da Vinci", LocalDate.of(1994, 9, 6), classe3L));
	    
	    if (studenteService.readAllStudenti().isEmpty())
	    	throw new RuntimeException("Errore nella creazione degli studenti. Creazione fallita."); 
	    System.out.println("Creazione degli studenti avvenuta con successo.");
	}
//	*******************************************	
	public List<Classe> testReadAllClassi() {
		List<Classe> classi = classeService.readAllClassi();
        if (classi.isEmpty()) {
            throw new RuntimeException("Nessuna classe trovata.");
        }
        classi.forEach(classe -> System.out.println("Classe " + classe.getAnno() + classe.getSezione())); //utilizzo Lamba expression
        return classi;
	}
//	*******************************************
	public List<Studente> testReadAllStudenti() {
		List<Studente> studenti = studenteService.readAllStudenti();
		if (studenti.isEmpty()) {
			throw new RuntimeException("Nessuno studente trovato.");
		}
		studenti.forEach(studente -> System.out.println(studente.getNome() + " " + studente.getCognome())); //utilizzo Lamba expression
		return studenti;
	}
//	*******************************************
	public Map<Classe, List<Studente>> testReadAllClassiConStudenti() {
        Map<Classe, List<Studente>> classiConStudenti = new HashMap<>();
        List<Classe> classi = testReadAllClassi();
        for (Classe classe : classi) {
            List<Studente> studenti = studenteService.findByClasse(classe);
            classiConStudenti.put(classe, studenti);
            System.out.println("Classe " + classe.getAnno() + classe.getSezione() + ":");
            if (studenti.isEmpty()) {
                System.out.println("Nessuno studente in questa classe.");
            } else {
                studenti.forEach(studente -> System.out.println("  " + studente.getNome() + " " + studente.getCognome()));
            }
        }
        return classiConStudenti;
    }
//	*******************************************	
	public void testFindByClasse() {
		
	}
//	*******************************************	
//	public void testSpostaStudenteInClasse() {
//		Classe nuovaClasse = classeService.findByAnnoAndSezione(1, 'B');
//	    
//	    if (nuovaClasse == null)
//	        throw new RuntimeException("Errore: la nuova classe non esiste.");
//	    
//	    studenteService.spostaStudenteInClasse(3L, nuovaClasse);
//	    
//	    Studente studente = studenteService.findById(3L);
//	    if (studente == null)
//	        throw new RuntimeException("Errore: lo studente non esiste.");
//	    
//	    if (studente.getClasse().equals(nuovaClasse)) {
//	        System.out.println("Spostamento nella nuova classe avvenuto con successo.");
//	    } else {
//	        throw new RuntimeException("Errore nello spostamento dello studente.");
//	    }
//	}
	
//	*******************************************	
	public void testUpdateClasse() {
		List<Classe> classi = classeService.readAllClassi(); 
		if (classi.isEmpty())
			throw new RuntimeException("Errore: la scuola non ha classi."); 
		
		classi.get(2).setAnno(1);
		classi.get(2).setSezione('C');
		
		Long idToUpdate = classi.get(2).getId();
		
		classeService.updateClasse(classi.get(2));
		
		if (classeService.readClasse(idToUpdate) == null || !classeService.readClasse(idToUpdate).getSezione().equals('C')) {
			System.out.println(classeService.readClasse(idToUpdate).getSezione());
			throw new RuntimeException("Errore: aggiornamento classe non riuscito.");
		}
		System.out.println("Aggiornamento classe avvenuto con successo.");
	}
//	*******************************************	
	public void testUpdateStudente() {
		List<Studente> studenti = studenteService.readAllStudenti(); 
		if (studenti.isEmpty())
			throw new RuntimeException("Errore: la scuola non ha studenti."); 
		
		studenti.get(10).setNome("Massimo");
		studenti.get(10).setCognome("Caramanna");
		studenti.get(10).setNascita(LocalDate.of(1994, 9, 6));
		
		Long idToUpdate = studenti.get(10).getId();
		
		studenteService.updateStudente(studenti.get(10));
		
		if(studenteService.readStudente(idToUpdate) == null || !studenteService.readStudente(idToUpdate).getCognome().equals("Caramanna")) {
			System.out.println(studenteService.readStudente(idToUpdate).getCognome());
			throw new RuntimeException("Errore: aggiornamento studente non riuscito.");
		}
		System.out.println("Aggiornamento studente avvenuto con successo.");
	}
//	*******************************************	
	public void testDeleteClasse() {
		List<Classe> classi = classeService.readAllClassi();
	    if (classi.isEmpty())
	        throw new RuntimeException("Errore: la scuola non ha classi.");

	    Long idToDelete = classi.get(2).getId();
	    classeService.deleteClasse(classi.get(2));

	    if (classeService.readClasse(idToDelete) != null) {
	        throw new RuntimeException("Errore: eliminazione classe non riuscita.");
	    }
	    System.out.println("Eliminazione classe avvenuta con successo.");
	}
//	*******************************************	
	public void testDeleteStudente() {
		List<Studente> studenti = studenteService.readAllStudenti();
	    if (studenti.isEmpty())
	        throw new RuntimeException("Errore: la scuola non ha studenti.");

	    Long idToDelete = studenti.get(10).getId();
	    studenteService.deleteStudente(studenti.get(10));

	    if (studenteService.readStudente(idToDelete) != null) {
	        throw new RuntimeException("Errore: eliminazione studente non riuscita.");
	    }
	    System.out.println("Eliminazione studente avvenuta con successo.");
	}
	
}
