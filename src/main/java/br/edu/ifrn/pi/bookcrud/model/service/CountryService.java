package br.edu.ifrn.pi.bookcrud.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrn.pi.bookcrud.model.dao.CountryDAO;
import br.edu.ifrn.pi.bookcrud.model.entity.Country;

@Service
public class CountryService {

	@Autowired
	private CountryDAO stateDAO;
	
	public void save(Country country) {				
		stateDAO.save(country);
	}
	
	public void update(Country country) {		
		stateDAO.update(country);
	}
	
	public void delete(long id) {
		stateDAO.delete(id);
	}
	
	public List getAll() {
		return stateDAO.getAll();
	}
	
}
