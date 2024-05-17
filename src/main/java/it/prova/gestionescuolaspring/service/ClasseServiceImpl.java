package it.prova.gestionescuolaspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionescuolaspring.model.Classe;
import it.prova.gestionescuolaspring.repository.ClasseRepository;
//import jakarta.persistence.EntityManager;

@Service
public class ClasseServiceImpl implements ClasseService{

	@Autowired 
	private ClasseRepository classeRepository; 
//	@Autowired
//	private EntityManager entityManager;
	

	@Transactional
	public void createClasse(Classe classe) {
		classeRepository.save(classe); 
	}

	@Transactional(readOnly = true)
	public Classe readClasse(Long id) {
		return classeRepository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public List<Classe> readAllClassi() {
		return (List<Classe>) classeRepository.findAll();
	}

	@Transactional
	public void updateClasse(Classe classe) {
		classeRepository.save(classe); 
	}

	@Transactional
	public void deleteClasse(Classe classe) {
		classeRepository.delete(classe); 
	}
	
}
