package it.uniroma3.siw.explosionBox.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Scatola {
	
	public static final String DIMENSIONE_PICCOLA = "PICCOLA";
	public static final String DIMENSIONE_MEDIA = "MEDIA";
	public static final String DIMENSIONE_GRANDE = "GRANDE";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String dimensione;
	
	@Column(nullable = false)
	private String colore1;
	
	@Column(nullable = false)
	private String colore2;
	
	@Column(nullable = false)
	private int numeroFoto;
	
	private int numeroDediche;
	
	private String note;
	
	private String decorazione;
	
	private int prezzo;
	
	@ManyToOne
	private Dipendente dipendente;
	
	@OneToOne
	@JoinColumn(name = "ordine_id")
	private Ordine ordine;
	
	@OneToMany(mappedBy = "scatola")
	private List<Card> cards;

	/*COSTRUTTORE*/
	public Scatola() {
		this.cards = new ArrayList<Card>();
	}
	
	/*GETTERS E SETTERS*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDimensione() {
		return dimensione;
	}

	public void setDimensione(String dimensione) {
		this.dimensione = dimensione;
	}

	public String getColore1() {
		return colore1;
	}

	public void setColore1(String colore1) {
		this.colore1 = colore1;
	}

	public String getColore2() {
		return colore2;
	}

	public void setColore2(String colore2) {
		this.colore2 = colore2;
	}

	public int getNumeroFoto() {
		return numeroFoto;
	}

	public void setNumeroFoto(int numeroFoto) {
		this.numeroFoto = numeroFoto;
	}

	public Dipendente getDipendente() {
		return dipendente;
	}

	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDecorazione() {
		return decorazione;
	}

	public void setDecorazione(String decorazione) {
		this.decorazione = decorazione;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public int getNumeroDediche() {
		return numeroDediche;
	}

	public void setNumeroDediche(int numeroDediche) {
		this.numeroDediche = numeroDediche;
	}
}
