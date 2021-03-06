package it.uniroma3.siw.explosionBox.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import it.uniroma3.siw.explosionBox.model.Scatola;

public interface ScatolaRepository extends CrudRepository<Scatola, Long>{

	public List<Scatola> findByNome(String nome);
	
	public Scatola findByOrdineId(Long id);

	public List<Scatola> findByDipendenteIdIsNull();

}
