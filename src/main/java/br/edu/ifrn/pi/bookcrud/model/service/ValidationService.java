package br.edu.ifrn.pi.bookcrud.model.service;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {

	public boolean validateHeight(int height) {
		if(height > 0 && height < 200) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean validateName(String name) {
		if(name != null && !name.trim().isEmpty() && !name.contains("1")){
			return true;
		}
		
		return false;
	}
	
}
