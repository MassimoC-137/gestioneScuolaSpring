package it.prova.gestionescuolaspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionescuolaspring.model.Classe;
import it.prova.gestionescuolaspring.model.Studente;
import it.prova.gestionescuolaspring.repository.StudenteRepository;
//import jakarta.persistence.EntityManager;

@Service
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

//	@Transactional
//	public void spostaStudenteInClasse(Long studenteId, Classe nuovaClasse) {
//        Studente studente = studenteRepository.findById(studenteId).orElse(null);
//        if (studente != null) {
//            studente.setClasse(nuovaClasse);
//            studenteRepository.save(studente);
//        } else {
//            throw new RuntimeException("Studente non trovato");
//        }
//    }

	@Transactional
    public Studente findById(Long id) {
        return studenteRepository.findById(id).orElse(null);
    }
	
	@Transactional
	public List<Studente> findByClasse(Classe classe) {
        return studenteRepository.findByClasse(classe);
    }

}
