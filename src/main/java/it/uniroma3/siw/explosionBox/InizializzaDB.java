package it.uniroma3.siw.explosionBox;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.explosionBox.model.Dipendente;
import it.uniroma3.siw.explosionBox.model.Scatola;
import it.uniroma3.siw.explosionBox.service.DipendenteService;
import it.uniroma3.siw.explosionBox.service.ScatolaService;

@Component
public class InizializzaDB implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private ScatolaService ss;
	
	@Autowired
	private DipendenteService ds;
	
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
		
		Scatola s1 = new Scatola();
		s1.setNome("San Valentino");
		s1.setColore1("Rosso");
		s1.setColore2("Bianco");
		s1.setDimensione("GRANDE");
		s1.setDescrizione("Scatola per coppie per San Valentino");
		s1.setLinkFoto("SanValentino.jpeg");
		s1.setNumeroFoto(1);
		s1.setDipendente(d);
		ss.inserisci(s1);
		
		Scatola s2 = new Scatola();
		s2.setNome("Ohana");
		s2.setColore1("Blu");
		s2.setColore2("Rosa");
		s2.setDimensione("GRANDE");
		s2.setDescrizione("Scatola a tema Lilo e Stitch");
		s2.setLinkFoto("Ohana.jpeg");
		s2.setNumeroFoto(1);
		s2.setDipendente(d);
		ss.inserisci(s2);
		
		Scatola s3 = new Scatola();
		s3.setNome("Frutta");
		s3.setColore1("Marrone");
		s3.setColore2("Verde");
		s3.setDimensione("PICCOLA");
		s3.setDescrizione("Scatola a tema agricolo");
		s3.setLinkFoto("Frutta.jpeg");
		s3.setNumeroFoto(1);
		s3.setDipendente(d);
		ss.inserisci(s3);
		
		Scatola s4 = new Scatola();
		s4.setNome("Laurea");
		s4.setColore1("Nero");
		s4.setColore2("Beige");
		s4.setDimensione("GRANDE");
		s4.setDescrizione("Scatola per festeggiare una laurea");
		s4.setLinkFoto("Laurea.jpeg");
		s4.setNumeroFoto(1);
		s4.setDipendente(d);
		ss.inserisci(s4);
		
		Scatola s5 = new Scatola();
		s5.setNome("Patente");
		s5.setColore1("Giallo");
		s5.setColore2("Rosso");
		s5.setDimensione("PICCOLA");
		s5.setDescrizione("Scatola per festeggiare l'esame della patente");
		s5.setLinkFoto("Patente.jpeg");
		s5.setNumeroFoto(1);
		s5.setDipendente(d);
		ss.inserisci(s5);
		
		Scatola s6 = new Scatola();
		s6.setNome("Minnie");
		s6.setColore1("Rosso");
		s6.setColore2("Nero");
		s6.setDimensione("GRANDE");
		s6.setDescrizione("Scatola per coppie a tema Minnie e Mickey Mouse");
		s6.setLinkFoto("Minnie.jpeg");
		s6.setNumeroFoto(1);
		s6.setDipendente(d);
		ss.inserisci(s6);
		
		Scatola s7 = new Scatola();
		s7.setNome("Kinder");
		s7.setColore1("Blu");
		s7.setColore2("Nero");
		s7.setDimensione("PICCOLA");
		s7.setDescrizione("Scatola a tema Kinder");
		s7.setLinkFoto("Kinder.jpeg");
		s7.setNumeroFoto(1);
		s7.setDipendente(d);
		ss.inserisci(s7);
		
		Scatola s8 = new Scatola();
		s8.setNome("Viola");
		s8.setColore1("Viola");
		s8.setColore2("Lilla");
		s8.setDimensione("Grande");
		s8.setDescrizione("Scatola per coppie");
		s8.setLinkFoto("Frutta.jpeg");
		s8.setNumeroFoto(1);
		s8.setDipendente(d);
		ss.inserisci(s8);
	}

}
