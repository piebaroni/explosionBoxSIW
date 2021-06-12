package it.uniroma3.siw.explosionBox.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import it.uniroma3.siw.explosionBox.model.Esempio;
import it.uniroma3.siw.explosionBox.service.EsempioService;

@Component
public class EsempioValidator implements Validator {
	
	@Autowired
	private EsempioService service;
	
	private static final Logger logger = LoggerFactory.getLogger(OrdineValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		return Esempio.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "linkFoto", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titolo", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sottotitolo", "required");
		if(!errors.hasErrors()) {
			logger.debug("confermato: valori non nulli");
			if(this.service.alreadyExists((Esempio) target)) {
				logger.debug("e' un duplicato");
				errors.reject("duplicato");
			}
		}
	}

}
