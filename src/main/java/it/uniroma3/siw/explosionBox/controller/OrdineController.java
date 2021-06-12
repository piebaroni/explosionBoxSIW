package it.uniroma3.siw.explosionBox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.siw.explosionBox.model.Credentials;
import it.uniroma3.siw.explosionBox.model.Ordine;
import it.uniroma3.siw.explosionBox.model.Utente;
import it.uniroma3.siw.explosionBox.service.CredentialsService;
import it.uniroma3.siw.explosionBox.service.OrdineService;
import it.uniroma3.siw.explosionBox.service.ScatolaService;

@Controller
public class OrdineController {

	@Autowired
	private OrdineService service;
	
	@Autowired
	private CredentialsService credentialsService;
	
	@Autowired
	private ScatolaService scatolaService;
	
	@RequestMapping(value = "/ordini", method = RequestMethod.GET)
	public String getOrdini(Model model) {
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Credentials credentials = credentialsService.getCredentialsByUsername(userDetails.getUsername());
		Utente c = credentials.getUtente();
		model.addAttribute("ordini", this.service.trovaPerCliente(c.getId()));
		return "listaOrdini.html";
	}
	
	@RequestMapping(value = "/ordine/{id}", method = RequestMethod.GET)
	public String getOrdine(@PathVariable("id") Long id, Model model) {
		Ordine o = this.service.trovaPerId(id);
		model.addAttribute("ordine", o);
		model.addAttribute("scatole", this.scatolaService.trovaPerOrdine(id));
		return "ordine.html";
	}
	
}
