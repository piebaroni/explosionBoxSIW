package it.uniroma3.siw.explosionBox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.siw.explosionBox.model.Scatola;
import it.uniroma3.siw.explosionBox.service.CardService;
import it.uniroma3.siw.explosionBox.service.ScatolaService;

@Controller
public class ScatolaController {

	@Autowired
	private ScatolaService service;

	@Autowired
	private ScatolaValidator validator;
	
	@Autowired
	private CardService cardService;

	@RequestMapping(value = "/scatola/{id}", method = RequestMethod.GET)
	public String getScatola(@PathVariable("id") Long id, Model model) {
		Scatola s = this.service.trovaPerId(id);
		model.addAttribute("scatola", s);
		model.addAttribute("cards", this.cardService.trovaPerScatolaId(id));
		return "scatola.html";
	}

	@RequestMapping(value = "/shopMini", method = RequestMethod.GET)
	public String shopMini(Model model) {
		model.addAttribute("scatola", new Scatola());
		return "shopMini.html";
	}
	
	@RequestMapping(value = "/shopStandard", method = RequestMethod.GET)
	public String shopStandard(Model model) {
		model.addAttribute("scatola", new Scatola());
		return "shopStandard.html";
	}
	
	@RequestMapping(value = "/shopTower", method = RequestMethod.GET)
	public String shopTower(Model model) {
		model.addAttribute("scatola", new Scatola());
		return "shopTower.html";
	}

	@RequestMapping(value = "/newScatolaStandard", method = RequestMethod.POST)
	public String addScatolaStandard(@ModelAttribute("scatola") Scatola scatola, Model model, BindingResult bindingResult) {
		this.validator.validate(scatola, bindingResult);
		if(!bindingResult.hasErrors()) {
			scatola.setDimensione(Scatola.DIMENSIONE_MEDIA);
			scatola.setPrezzo(60);
			scatola.setNome("Standard");
			this.service.inserisci(scatola);
			model.addAttribute("scatola", scatola);
			return "confermaOrdine.html";
		}
		return "shopStandard.html";
	}
	
	@RequestMapping(value = "/newScatolaMini", method = RequestMethod.POST)
	public String addScatolaMini(@ModelAttribute("scatola") Scatola scatola, Model model, BindingResult bindingResult) {
		this.validator.validate(scatola, bindingResult);
		if(!bindingResult.hasErrors()) {
			scatola.setDimensione(Scatola.DIMENSIONE_PICCOLA);
			scatola.setPrezzo(40);
			scatola.setNome("Mini");
			this.service.inserisci(scatola);
			model.addAttribute("scatola", scatola);
			return "confermaOrdine.html";
		}
		return "shopMini.html";
	}
	
	@RequestMapping(value = "/newScatolaTower", method = RequestMethod.POST)
	public String addScatolaTower(@ModelAttribute("scatola") Scatola scatola, Model model, BindingResult bindingResult) {
		this.validator.validate(scatola, bindingResult);
		if(!bindingResult.hasErrors()) {
			scatola.setDimensione(Scatola.DIMENSIONE_GRANDE);
			scatola.setNome("Tower");
			scatola.setPrezzo(65);
			this.service.inserisci(scatola);
			model.addAttribute("scatola", scatola);
			return "confermaOrdine.html";
		}
		return "shopTower.html";
	}
	
	@RequestMapping(value = "/deleteScatola/{id}", method = RequestMethod.GET)
	public String eliminaScatola(@PathVariable("id") Long id, Model model) {
		this.service.eliminaScatola(id);
		return "index.html";
	}
}
