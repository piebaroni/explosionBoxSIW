package it.uniroma3.siw.explosionBox;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.explosionBox.model.Credentials;
import it.uniroma3.siw.explosionBox.model.Dipendente;
import it.uniroma3.siw.explosionBox.model.Esempio;
import it.uniroma3.siw.explosionBox.model.Utente;
import it.uniroma3.siw.explosionBox.service.CredentialsService;
import it.uniroma3.siw.explosionBox.service.DipendenteService;
import it.uniroma3.siw.explosionBox.service.EsempioService;

@Component
public class InizializzaDB /*implements ApplicationListener<ContextRefreshedEvent>*/ {

	@Autowired
	private EsempioService es;
	
	@Autowired
	private DipendenteService ds;
	
	@Autowired
	private CredentialsService cs;
	/*
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Dipendente d = new Dipendente();
		d.setNome("Mario");
		d.setCognome("Rossi");
		d.setEmail("rossi@explosionBox.it");
		d.setDataNascita(LocalDate.of(1990, 12, 12));
		d.setLuogoNascita("Roma");
		d.setMatricola(123);
		d.setTelefono(0606);
		ds.inserisci(d);
		
		Dipendente d1 = new Dipendente();
		d1.setNome("Luca");
		d1.setCognome("Verdi");
		d1.setEmail("verdi@explosionBox.it");
		d1.setDataNascita(LocalDate.of(1995, 10, 12));
		d1.setLuogoNascita("Roma");
		d1.setMatricola(321);
		d1.setTelefono(0707);
		ds.inserisci(d1);
		
		Esempio e1 = new Esempio();
		e1.setTitolo("San Valentino");
		e1.setSottotitolo("sottotitolo");
		e1.setLinkFoto("SanValentino.jpeg");
		es.inserisci(e1);
		
		Esempio e2 = new Esempio();
		e2.setTitolo("Ohana");
		e2.setSottotitolo("sottotitolo");
		e2.setLinkFoto("Ohana.jpeg");
		es.inserisci(e2);
		
		Esempio e3 = new Esempio();
		e3.setTitolo("Frutta");
		e3.setSottotitolo("sottotitolo");
		e3.setLinkFoto("Frutta.jpeg");
		es.inserisci(e3);
		
		Esempio e4 = new Esempio();
		e4.setTitolo("Kinder");
		e4.setSottotitolo("sottotitolo");
		e4.setLinkFoto("Kinder.jpeg");
		es.inserisci(e4);
		
		Esempio e5 = new Esempio();
		e5.setTitolo("Laurea");
		e5.setSottotitolo("sottotitolo");
		e5.setLinkFoto("Laurea.jpeg");
		es.inserisci(e5);
		
		Esempio e6 = new Esempio();
		e6.setTitolo("Minnie");
		e6.setSottotitolo("sottotitolo");
		e6.setLinkFoto("Minnie.jpeg");
		es.inserisci(e6);
		
		Esempio e7 = new Esempio();
		e7.setTitolo("Viola");
		e7.setSottotitolo("sottotitolo");
		e7.setLinkFoto("Viola.jpeg");
		es.inserisci(e7);
		
		Esempio e8 = new Esempio();
		e8.setTitolo("Patente");
		e8.setSottotitolo("sottotitolo");
		e8.setLinkFoto("Patente.jpeg");
		es.inserisci(e8);
		
		Utente u1 = new Utente();
		u1.setNome("nome");
		u1.setCognome("cognome");
		
		Credentials c1 = new Credentials();
		c1.setUtente(u1);
		c1.setUsername("user");
		c1.setPassword("user");
		c1.setRole("DEFAULT");
		cs.saveCredentials(c1);
		
		Utente u2 = new Utente();
		u2.setNome("nome");
		u2.setCognome("cognome");
		
		Credentials c2 = new Credentials();
		c2.setUtente(u2);
		c2.setUsername("admin");
		c2.setPassword("admin");
		c2.setRole("ADMIN");
		cs.saveCredentials(c2);
	}*/

}
