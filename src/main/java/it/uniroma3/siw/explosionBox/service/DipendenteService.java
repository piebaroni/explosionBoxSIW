package it.uniroma3.siw.explosionBox.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.uniroma3.siw.explosionBox.model.Dipendente;
import it.uniroma3.siw.explosionBox.repository.DipendenteRepository;

@Service
public class DipendenteService {

	@Autowired
	private DipendenteRepository repository;
	
	@Transactional
	public Dipendente inserisci(Dipendente d) {
		return repository.save(d);
	}
	
	public List<Dipendente> trovaPerNome(String nome){
		return repository.findByNome(nome);
	}
	
	public List<Dipendente> trovaPerMatricola(int matricola){
		return repository.findByMatricola(matricola);
	}
	
	public List<Dipendente> trovaPerNomeECognome(String nome, String cognome){
		return repository.findByNomeAndCognome(nome, cognome);
	}
	
	public List<Dipendente> trovaPerNomeOCognome(String nome, String cognome){
		return repository.findByNomeOrCognome(nome, cognome);
	}
	
	public List<Dipendente> findAll(){
		return (List<Dipendente>) repository.findAll();
	}
	
	@Transactional
	public Dipendente trovaPerId(Long id) {
		Optional<Dipendente> optional = repository.findById(id);
		if(optional.isPresent()) return optional.get();
		return null;
	}
	
	@Transactional
	public boolean alreadyExists(Dipendente d) {
		List<Dipendente> opere = repository.findByNomeAndCognome(d.getNome(), d.getCognome());
		if(opere.size()>0) return true;
		return false;
	}
}
