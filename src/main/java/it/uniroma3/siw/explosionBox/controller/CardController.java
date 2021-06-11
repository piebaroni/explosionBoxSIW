package it.uniroma3.siw.explosionBox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.siw.explosionBox.service.CardService;
import it.uniroma3.siw.explosionBox.model.Card;

@Controller
public class CardController {

	@Autowired
	private CardService service;
	
	@RequestMapping(value = "/card/{id}", method = RequestMethod.GET)
    public String getScatola(@PathVariable("id") Long id, Model model) {
    	Card c = this.service.trovaPerId(id);
    	model.addAttribute("card", c);
    	return "card.html";
    }
}
