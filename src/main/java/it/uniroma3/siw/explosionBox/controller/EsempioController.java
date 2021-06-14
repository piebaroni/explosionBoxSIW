package it.uniroma3.siw.explosionBox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.siw.explosionBox.model.Esempio;
import it.uniroma3.siw.explosionBox.service.EsempioService;

@Controller
public class EsempioController {
	
	@Autowired
	private EsempioService service;

	@Autowired
	private EsempioValidator validator;
	
	@RequestMapping(value = "/esempi", method = RequestMethod.GET)
	public String getEsempi(Model model) {
		model.addAttribute("esempi", this.service.findAll());
		return "listaEsempi.html";
	}
	
	@RequestMapping(value = "/addEsempio", method = RequestMethod.GET)
	public String addEsempo(Model model) {
		model.addAttribute("esempio", new Esempio());
		return "esempioForm.html";
	}
	
	@RequestMapping(value = "/newEsempio", method = RequestMethod.POST)
	public String newArtista(@ModelAttribute("esempio") Esempio e, Model model, BindingResult bindingResult) {
		this.validator.validate(e, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.service.inserisci(e);
			return "admin/home.html";
		}
		return "esempioForm.html";
	}
}
