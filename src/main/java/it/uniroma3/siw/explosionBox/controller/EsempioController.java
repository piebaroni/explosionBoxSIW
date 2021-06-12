package it.uniroma3.siw.explosionBox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.explosionBox.service.EsempioService;

@Controller
public class EsempioController {
	
	@Autowired
	private EsempioService service;

	@RequestMapping(value = "/esempi", method = RequestMethod.GET)
	public String getEsempi(Model model) {
		model.addAttribute("esempi", this.service.findAll());
		return "listaEsempi.html";
	}
	
}
