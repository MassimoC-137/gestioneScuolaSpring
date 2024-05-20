package it.prova.gestionescuolaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.prova.gestionescuolaspring.service.SequenzaTestService;

@SpringBootApplication
public class GestionescuolaspringApplication implements CommandLineRunner{

	@Autowired
	private SequenzaTestService sequenzaTestService; 
	
	public static void main(String[] args) {
		SpringApplication.run(GestionescuolaspringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		
		System.out.println("∞∞∞∞∞∞∞∞∞∞ Inizio sequenza test programma GestioneScuola ∞∞∞∞∞∞∞∞∞∞");
		
		sequenzaTestService.testCreateClasse();
		sequenzaTestService.testReadAllClassi(); 
		
		sequenzaTestService.testCreateStudente();
		sequenzaTestService.testReadAllStudenti();
		
		sequenzaTestService.testReadAllClassiConStudenti();
		
		sequenzaTestService.testFindByClasse();
		sequenzaTestService.testReadAllClassiConStudenti();
		
//		sequenzaTestService.testSpostaStudenteInClasse();
//		sequenzaTestService.testReadAllClassiConStudenti();
		
		sequenzaTestService.testUpdateClasse();
		
		sequenzaTestService.testUpdateStudente();
		sequenzaTestService.testReadAllClassiConStudenti();
		
		sequenzaTestService.testDeleteStudente();
		
		sequenzaTestService.testDeleteClasse();
		sequenzaTestService.testReadAllClassiConStudenti();
		
		
		
		
		System.out.println("∞∞∞∞∞∞∞∞∞∞ Fine sequenza test programma GestioneScuola ∞∞∞∞∞∞∞∞∞∞");
	}
	
	
}
