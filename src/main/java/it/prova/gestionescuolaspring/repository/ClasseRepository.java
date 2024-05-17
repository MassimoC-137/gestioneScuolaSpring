package it.prova.gestionescuolaspring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.gestionescuolaspring.model.Classe;

public interface ClasseRepository extends CrudRepository<Classe, Long>, QueryByExampleExecutor<Classe>{

}
