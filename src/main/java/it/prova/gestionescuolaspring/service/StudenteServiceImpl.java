package it.prova.gestionescuolaspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionescuolaspring.model.Studente;
import it.prova.gestionescuolaspring.repository.StudenteRepository;
//import jakarta.persistence.EntityManager;

public class StudenteServiceImpl implements StudenteService {

	@Autowired
	private StudenteRepository studenteRepository;
//	@Autowired
//	private EntityManager entityManager;
	
	
	@Transactional
	public void createStudente(Studente studente) {
		studenteRepository.save(studente);
	}
	
	@Transactional(readOnly = true)
	public Studente readStudente(Long id) {
		return studenteRepository.findById(id).orElse(null);
	}
	
	@Transactional(readOnly = true)
	public List<Studente> readAllStudenti() {
		return (List<Studente>) studenteRepository.findAll();
	}
	
	@Transactional
	public void updateStudente(Studente studente) {
		studenteRepository.save(studente);
	}
	
	@Transactional
	public void deleteStudente(Studente studente) {
		studenteRepository.delete(studente);
	}

}