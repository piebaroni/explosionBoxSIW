package it.uniroma3.siw.explosionBox.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.uniroma3.siw.explosionBox.model.Ordine;
import it.uniroma3.siw.explosionBox.repository.OrdineRepository;

@Service
public class OrdineService {

	@Autowired
	private OrdineRepository repository;
	
	@Transactional
	public Ordine inserisci(Ordine o) {
		return repository.save(o);
	}
	
	public List<Ordine> trovaPerCliente(Long id){
		return repository.findByCompratoreId(id);
	}
	
	public List<Ordine> findAll(){
		return (List<Ordine>) repository.findAll();
	}
	
	@Transactional
	public Ordine trovaPerId(Long id) {
		Optional<Ordine> optional = repository.findById(id);
		if(optional.isPresent()) return optional.get();
		return null;
	}
	
}
