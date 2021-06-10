package it.uniroma3.siw.explosionBox.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import it.uniroma3.siw.explosionBox.model.Card;

public interface CardRepository extends CrudRepository<Card, Long>{

	public List<Card> findByColore(String colore);
}
