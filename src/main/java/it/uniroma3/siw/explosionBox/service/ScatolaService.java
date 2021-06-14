package it.uniroma3.siw.explosionBox.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.uniroma3.siw.explosionBox.model.Scatola;
import it.uniroma3.siw.explosionBox.repository.ScatolaRepository;

@Service
public class ScatolaService {

	@Autowired
	private ScatolaRepository repository;
	
	@Transactional
	public Scatola inserisci(Scatola s) {
		return repository.save(s);
	}
	
	public List<Scatola> trovaPerDipendenteNullo(){
		return repository.findByDipendenteIdIsNull();
	}
	
	public List<Scatola> trovaPerNome(String nome){
		return repository.findByNome(nome);
	}
	
	public List<Scatola> trovaPerOrdine(Long id){
		return repository.findByOrdineId(id);
	}
	
	public List<Scatola> findAll(){
		return (List<Scatola>) repository.findAll();
	}
	
	public void eliminaScatola(Long id) {
		this.repository.deleteById(id);
	}
	
	@Transactional
	public Scatola trovaPerId(Long id) {
		Optional<Scatola> optional = repository.findById(id);
		if(optional.isPresent()) return optional.get();
		return null;
	}
	
	@Transactional
	public boolean alreadyExists(Scatola s) {
		List<Scatola> opere = repository.findByNome(s.getNome());
		if(opere.size()>0) return true;
		return false;
	}
}
