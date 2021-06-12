package it.uniroma3.siw.explosionBox.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.explosionBox.model.Esempio;

public interface EsempioRepository extends CrudRepository<Esempio, Long>{

	public List<Esempio> findByTitolo(String titolo);
	
}
