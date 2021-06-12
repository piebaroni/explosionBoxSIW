package it.uniroma3.siw.explosionBox.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Ordine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(mappedBy = "ordine") 
	private List<Scatola> scatole;

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
		this.scatole = new ArrayList<Scatola>();
	}

	/*GETTERS E SETTERS*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Scatola> getScatole() {
		return scatole;
	}

	public void setScatole(List<Scatola> scatole) {
		this.scatole = scatole;
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
