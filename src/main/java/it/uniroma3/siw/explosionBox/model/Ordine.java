package it.uniroma3.siw.explosionBox.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Ordine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(mappedBy = "ordine")
	private Scatola scatola;

	@Column(nullable = false)
	private String indirizzo;
	
	@Column(nullable = false)
	private int telefono;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;
	
	@ManyToOne
	private Utente compratore;
	
	/*COSTRUTTORE*/
	public Ordine() {
	}

	/*GETTERS E SETTERS*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Scatola getScatola() {
		return scatola;
	}

	public void setScatola(Scatola scatola) {
		this.scatola = scatola;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Utente getCompratore() {
		return compratore;
	}

	public void setCompratore(Utente compratore) {
		this.compratore = compratore;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
}
