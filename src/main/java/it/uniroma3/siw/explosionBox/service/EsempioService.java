package it.uniroma3.siw.explosionBox.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.uniroma3.siw.explosionBox.model.Esempio;
import it.uniroma3.siw.explosionBox.repository.EsempioRepository;

@Service
public class EsempioService {

	@Autowired
	private EsempioRepository repository;
	
	@Transactional
	public Esempio inserisci(Esempio e) {
		return repository.save(e);
	}
	
	public List<Esempio> findAll(){
		return (List<Esempio>) repository.findAll();
	}
	
	@Transactional
	public Esempio trovaPerId(Long id) {
		Optional<Esempio> optional = repository.findById(id);
		if(optional.isPresent()) return optional.get();
		return null;
	}
	
	@Transactional
	public boolean alreadyExists(Esempio s) {
		List<Esempio> opere = repository.findByTitolo(s.getTitolo());
		if(opere.size()>0) return true;
		return false;
	}
}
