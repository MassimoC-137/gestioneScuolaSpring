package it.prova.gestionescuolaspring.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "studente")
public class Studente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "matricola")
	private String matricola;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "nascita")
	private LocalDate nascita;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_classe", nullable = false)
	private Classe classe;

	public Studente() {

	}

	public Studente(Long id, String matricola, String nome, String cognome, LocalDate nascita, Classe classe) {
		super();
		this.id = id;
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.nascita = nascita;
		this.classe = classe;
	}

	public Studente(String matricola, String nome, String cognome, LocalDate nascita, Classe classe) {
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.nascita = nascita;
		this.classe = classe;
	}
	
	public Studente(String matricola, String nome, String cognome, LocalDate nascita) {
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.nascita = nascita;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getNascita() {
		return nascita;
	}

	public void setNascita(LocalDate nascita) {
		this.nascita = nascita;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

}
