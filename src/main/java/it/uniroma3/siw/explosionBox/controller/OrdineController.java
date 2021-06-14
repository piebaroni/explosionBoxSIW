package it.uniroma3.siw.explosionBox.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.siw.explosionBox.model.Credentials;
import it.uniroma3.siw.explosionBox.model.Ordine;
import it.uniroma3.siw.explosionBox.model.Scatola;
import it.uniroma3.siw.explosionBox.model.Utente;
import it.uniroma3.siw.explosionBox.service.CredentialsService;
import it.uniroma3.siw.explosionBox.service.OrdineService;
import it.uniroma3.siw.explosionBox.service.ScatolaService;

@Controller
public class OrdineController {

	private Long id;
	
	private static final Logger logger = LoggerFactory.getLogger(OrdineValidator.class);
	
	@Autowired
	private OrdineService service;
	
	@Autowired
	private CredentialsService credentialsService;
	
	@Autowired
	private ScatolaService scatolaService;

	@Autowired
	private OrdineValidator ordineValidator;
	
	@RequestMapping(value = "/ordini", method = RequestMethod.GET)
	public String getOrdini(Model model) {
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Credentials credentials = credentialsService.getCredentialsByUsername(userDetails.getUsername());
		if(credentials.getRole().equals(Credentials.ADMIN_ROLE)) {
			List<Scatola> scatole = this.scatolaService.trovaPerDipendenteNullo();
			List<Ordine> ordini = new ArrayList<Ordine>();
			for(Scatola scatola: scatole) {
				ordini.add(scatola.getOrdine());
			}
			model.addAttribute("ordini", ordini);
			return "listaOrdini.html";
		}
		Utente u = credentials.getUtente();
		model.addAttribute("ordini", this.service.trovaPerCliente(u.getId()));
		return "listaOrdini.html";
	}
	
	@RequestMapping(value = "/ordine/{id}", method = RequestMethod.GET)
	public String getOrdine(@PathVariable("id") Long id, Model model) {
		Ordine o = this.service.trovaPerId(id);
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Credentials credentials = credentialsService.getCredentialsByUsername(userDetails.getUsername());
		if(credentials.getRole().equals(Credentials.ADMIN_ROLE)) {
			model.addAttribute("ordine", o);
			model.addAttribute("scatole", this.scatolaService.trovaPerOrdine(id));
			return "admin/ordine.html";
		}
		model.addAttribute("ordine", o);
		model.addAttribute("scatole", this.scatolaService.trovaPerOrdine(id));
		return "ordine.html";
	}
	
	@RequestMapping(value = "/nuovoOrdine/{id}", method = RequestMethod.GET)
	public String nuovoOrdine(@PathVariable("id") Long id, Model model) {
		model.addAttribute("ordine", new Ordine());
		this.id = id;
		return "ordineForm.html";
	}
	
	@RequestMapping(value = "/faiOrdine", method = RequestMethod.POST)
	public String addOrdine(@ModelAttribute("ordine") Ordine ordine, Model model, BindingResult bindingResult) {
		this.ordineValidator.validate(ordine, bindingResult);
		if(!bindingResult.hasErrors()) {
			ordine.setData(LocalDate.now());
			UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Credentials credentials = credentialsService.getCredentialsByUsername(userDetails.getUsername());
			Utente u = credentials.getUtente();
			ordine.setCompratore(u);
			Scatola s = this.scatolaService.trovaPerId(this.id);
			s.setOrdine(ordine);
			ordine.setScatola(s);
			this.service.inserisci(ordine);
			model.addAttribute("credentials", credentials);
			model.addAttribute("scatola", s);
			model.addAttribute("ordine", ordine);
			model.addAttribute("numeroOrdine", this.service.findAll().size());
			logger.debug("EFFETTUATO ORDINE!!!");
			return "ordineEffettuato.html";
		}
		return "ordineForm.html";
	}
	
}
