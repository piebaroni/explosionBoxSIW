package it.uniroma3.siw.explosionBox.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import it.uniroma3.siw.explosionBox.model.Ordine;

@Component
public class OrdineValidator implements Validator {
	
	private static final Logger logger = LoggerFactory.getLogger(OrdineValidator.class);
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Ordine.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "indirizzo", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "required");
		if(!errors.hasErrors()) {
			logger.debug("confermato: valori non nulli");
		}
	}

}
