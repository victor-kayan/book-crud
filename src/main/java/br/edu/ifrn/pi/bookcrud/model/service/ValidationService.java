package br.edu.ifrn.pi.bookcrud.model.service;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {
	
	public boolean validateName(String name) {
	    if (name != null && !name.trim().isEmpty()) {
			char[] nameCharsArray = name.toCharArray();
		    
		    for (char eachNameChar : nameCharsArray) {
		    	if (Character.isDigit(eachNameChar)) {
		    		return false;
		         }
		    }    
		    return true;
	    }
    	return false; 
	}
	
	public boolean validateTitle(String name) {
		return name != null && !name.trim().isEmpty();
    }
	
	public boolean validateCpf(String cpf) {
		String cpfWithoutDots = cpf.replace(".", "");
		String cpfDigitsOnly = cpfWithoutDots.replace("-", "");
		
		return cpf.matches("^\\d{11}$");
	}
	
	public boolean validateNumberOfPages(int number) {
		return number >= 1 && number <= 10000;
	}
}
