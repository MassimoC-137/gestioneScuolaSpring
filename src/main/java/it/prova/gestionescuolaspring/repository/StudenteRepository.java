package it.prova.gestionescuolaspring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.gestionescuolaspring.model.Classe;
import it.prova.gestionescuolaspring.model.Studente;

public interface StudenteRepository extends CrudRepository<Studente, Long>, QueryByExampleExecutor<Studente>{

	public List<Studente> findByClasse(Classe classe);
	
}
