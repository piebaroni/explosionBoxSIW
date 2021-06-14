package it.uniroma3.siw.explosionBox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Scatola {
	
	public static final String SCATOLA_STANDARD = "Standard";
	public static final String SCATOLA_MINI = "Mini";
	public static final String SCATOLA_TOWER = "Tower";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String colore1;
	
	@Column(nullable = false)
	private String colore2;
	
	@Column(nullable = false)
	private int numeroFoto;
	
	private int numeroDediche;
	
	private String linkFoto;
	
	private String note;
	
	private String decorazione;
	
	private int prezzo;
	
	@ManyToOne
	private Dipendente dipendente;
	
	@OneToOne
	@JoinColumn(name = "ordine_id")
	private Ordine ordine;

	/*COSTRUTTORE*/
	public Scatola() {
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

	public String getLinkFoto() {
		return linkFoto;
	}

	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
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
