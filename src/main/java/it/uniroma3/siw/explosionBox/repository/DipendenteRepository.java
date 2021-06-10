package it.uniroma3.siw.explosionBox.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import it.uniroma3.siw.explosionBox.model.Dipendente;

public interface DipendenteRepository extends CrudRepository<Dipendente, Long>{

	public List<Dipendente> findByNome(String nome);

	public List<Dipendente> findByNomeOrCognome(String nome, String cognome);

	public List<Dipendente> findByNomeAndCognome(String nome, String cognome);

	public List<Dipendente> findByMatricola(int matricola);

}
