package it.uniroma3.siw.explosionBox.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.explosionBox.model.Scatola;

@Component
public class ScatolaValidator implements Validator{

	private static final Logger logger = LoggerFactory.getLogger(OrdineValidator.class);
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Scatola.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "colore1", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "colore2", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numeroFoto", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numeroDediche", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "decorazione", "required");
		if(!errors.hasErrors()) {
			logger.debug("confermato: valori non nulli");
		}
	}

}
