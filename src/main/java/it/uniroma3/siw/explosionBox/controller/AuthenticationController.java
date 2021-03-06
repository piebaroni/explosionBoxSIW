package it.uniroma3.siw.explosionBox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.explosionBox.controller.CredentialsValidator;
import it.uniroma3.siw.explosionBox.controller.UtenteValidator;
import it.uniroma3.siw.explosionBox.model.Credentials;
import it.uniroma3.siw.explosionBox.model.Utente;
import it.uniroma3.siw.explosionBox.service.CredentialsService;
import it.uniroma3.siw.explosionBox.service.UtenteService;

@Controller
public class AuthenticationController {

	@Autowired
	private CredentialsService credentialsService;

	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	private UtenteValidator utenteValidator;

	@Autowired
	private CredentialsValidator credentialsValidator;

	@RequestMapping(value = "/register", method = RequestMethod.GET) 
	public String showRegisterForm (Model model) {
		model.addAttribute("user", new Utente());
		model.addAttribute("credentials", new Credentials());
		return "registerUser.html";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET) 
	public String showLoginForm (Model model) {
		return "login.html";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET) 
	public String logout(Model model) {
		return "index.html";
	}
	
	@RequestMapping(value = "/default", method = RequestMethod.GET)
	public String defaultAfterLogin(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    if (authentication instanceof AnonymousAuthenticationToken) {
	    	return "index.html";
	    }
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Credentials credentials = credentialsService.getCredentialsByUsername(userDetails.getUsername());
		if (credentials.getRole().equals(Credentials.ADMIN_ROLE)) {
			return "admin/home.html";
		}
		return "index.html";
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") Utente utente, BindingResult userBindingResult,
			@ModelAttribute("credentials") Credentials credentials, BindingResult credentialsBindingResult, Model model) {
		this.utenteValidator.validate(utente, userBindingResult);
		this.credentialsValidator.validate(credentials, credentialsBindingResult);
		if(!userBindingResult.hasErrors() && ! credentialsBindingResult.hasErrors()) {
			credentials.setUtente(utente);
			utenteService.saveUtente(utente);
			credentialsService.saveCredentials(credentials);
			return "registrationSuccessful.html";
		}
		return "registerUser.html";
	}

}