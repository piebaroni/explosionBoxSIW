package it.uniroma3.siw.explosionBox.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import it.uniroma3.siw.explosionBox.model.Ordine;

public interface OrdineRepository extends CrudRepository<Ordine, Long>{

	public List<Ordine> findByCompratoreId(Long id);

}
