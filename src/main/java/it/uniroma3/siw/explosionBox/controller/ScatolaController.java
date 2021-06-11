package it.uniroma3.siw.explosionBox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.explosionBox.model.Scatola;
import it.uniroma3.siw.explosionBox.service.CardService;
import it.uniroma3.siw.explosionBox.service.ScatolaService;

@Component
public class ScatolaController {

	@Autowired
	private ScatolaService service;

	@Autowired
	private CardService cardService;

	@RequestMapping(value = "/inVendita", method = RequestMethod.GET)
	public String getScatole(Model model) {
		model.addAttribute("scatole", this.service.findAll());
		return "listaScatole.html";
	}

	@RequestMapping(value = "/scatola/{id}", method = RequestMethod.GET)
	public String getScatola(@PathVariable("id") Long id, Model model) {
		Scatola s = this.service.trovaPerId(id);
		model.addAttribute("scatola", s);
		model.addAttribute("cards", this.cardService.trovaPerScatolaId(id));
		return "scatola.html";
	}
}
