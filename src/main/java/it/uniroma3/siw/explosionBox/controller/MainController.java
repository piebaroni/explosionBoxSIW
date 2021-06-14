package it.uniroma3.siw.explosionBox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String index(Model model) {
			return "index";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
			return "home";
	}
	
	@RequestMapping(value = "/consegna", method = RequestMethod.GET)
	public String consegna(Model model) {
			return "consegna";
	}
	
	@RequestMapping(value = "/policy", method = RequestMethod.GET)
	public String policy(Model model) {
			return "policy";
	}
	@RequestMapping(value = "/cookies", method = RequestMethod.GET)
	public String cookies(Model model) {
			return "cookies";
	}
	
	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public String shop(Model model) {
			return "shop";
	}
	@RequestMapping(value = "/contatti", method = RequestMethod.GET)
	public String contatti(Model model) {
			return "contatti";
	}
}