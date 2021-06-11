package it.uniroma3.siw.explosionBox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String descrizione;
	
	@Column(nullable = false)
	private String colore;
	
	@Column(nullable = false)
	private String tipologia;
	
	@ManyToOne
	private Scatola scatola;
	
	/*COSTRUTTORE*/
	public Card() {
	}
	
	/*GETTERS E SETTERS*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public Scatola getScatola() {
		return scatola;
	}

	public void setScatola(Scatola scatola) {
		this.scatola = scatola;
	}
}
