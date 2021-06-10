package it.uniroma3.siw.explosionBox.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.uniroma3.siw.explosionBox.model.Card;
import it.uniroma3.siw.explosionBox.repository.CardRepository;

@Service
public class CardService {

	@Autowired
	private CardRepository repository;
	
	@Transactional
	public Card inserisci(Card c) {
		return repository.save(c);
	}
	
	public List<Card> trovaPerColore(String colore) {
		return repository.findByColore(colore);
	}
	
	public List<Card> findAll(){
		return (List<Card>) repository.findAll();
	}
	
	@Transactional
	public Card trovaPerId(Long id) {
		Optional<Card> optional = repository.findById(id);
		if(optional.isPresent()) return optional.get();
		return null;
	}
	
}
