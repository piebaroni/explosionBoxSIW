package it.uniroma3.siw.explosionBox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.siw.explosionBox.model.Dipendente;
import it.uniroma3.siw.explosionBox.service.DipendenteService;

@Controller
public class DipendenteController {

	@Autowired
	private DipendenteService service;
	
	@RequestMapping(value = "/dipendente/{id}", method = RequestMethod.GET)
    public String getDipendente(@PathVariable("id") Long id, Model model) {
    	Dipendente d = this.service.trovaPerId(id);
    	model.addAttribute("dipendente", d);
    	return "dipendente.html";
    }
}
