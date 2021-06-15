package it.uniroma3.siw.explosionBox;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.explosionBox.model.Credentials;
import it.uniroma3.siw.explosionBox.model.Dipendente;
import it.uniroma3.siw.explosionBox.model.Esempio;
import it.uniroma3.siw.explosionBox.model.Ordine;
import it.uniroma3.siw.explosionBox.model.Scatola;
import it.uniroma3.siw.explosionBox.model.Utente;
import it.uniroma3.siw.explosionBox.service.CredentialsService;
import it.uniroma3.siw.explosionBox.service.DipendenteService;
import it.uniroma3.siw.explosionBox.service.EsempioService;
import it.uniroma3.siw.explosionBox.service.OrdineService;
import it.uniroma3.siw.explosionBox.service.ScatolaService;

@Component
public class InizializzaDB implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private EsempioService es;
	
	@Autowired
	private DipendenteService ds;
	
	@Autowired
	private CredentialsService cs;
	
	@Autowired
	private OrdineService co;
	
	@Autowired
	private ScatolaService csc;
	
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
		
		Ordine o1= new Ordine();
		Scatola s1 = new Scatola();
		s1.setColore1("Rosso");
		s1.setColore2("Giallo");
		s1.setPrezzo(60);
		s1.setLinkFoto("Standardbox.jpeg");
		s1.setNome(Scatola.SCATOLA_STANDARD);
		s1.setDecorazione("Fiocco");
		s1.setNumeroDediche(8);
		s1.setNumeroFoto(20);
		s1.setNote("nessuna");
		s1.setOrdine(o1);
		
		Ordine o2= new Ordine();
		Scatola s2 = new Scatola();
		s2.setColore1("Rosso");
		s2.setColore2("Giallo");
		s2.setPrezzo(40);
		s2.setNome(Scatola.SCATOLA_MINI);
		s2.setLinkFoto("SanValentino.jpeg");
		s2.setDecorazione("Fiocco");
		s2.setNumeroDediche(2);
		s2.setNumeroFoto(5);
		s2.setNote("nessuna");
		s2.setOrdine(o2);
		
		
		Ordine o3= new Ordine();
		Scatola s3 = new Scatola();
		s3.setColore1("Rosso");
		s3.setColore2("Giallo");
		s3.setNome(Scatola.SCATOLA_TOWER);
		s3.setPrezzo(65);
		s3.setLinkFoto("Towerbox.jpeg");
		s3.setDecorazione("Fiocco");
		s3.setNumeroDediche(10);
		s3.setNumeroFoto(40);
		s3.setNote("nessuna");
		s3.setOrdine(o3);
		
		
		
		o1.setScatola(s1);
		o1.setCompratore(u1);
		o1.setData(LocalDate.of(2021, 3, 12));
		o1.setIndirizzo("Piazza paperino");
		o1.setTelefono(325681234);
		
		
		
		o2.setScatola(s2);
		o2.setCompratore(u1);
		o2.setData(LocalDate.of(2021, 3, 12));
		o2.setIndirizzo("Piazza paperino");
		o2.setTelefono(325681234);
		
		
		o3.setScatola(s3);
		o3.setCompratore(u1);
		o3.setData(LocalDate.of(2021, 3, 12));
		o3.setIndirizzo("Piazza paperino");
		o3.setTelefono(325681234);
		
		co.inserisci(o1);
		co.inserisci(o2);
		co.inserisci(o3);
		csc.inserisci(s1);
		csc.inserisci(s2);
		csc.inserisci(s3);
		
		
		
	}

}
