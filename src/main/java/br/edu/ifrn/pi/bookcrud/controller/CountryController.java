package br.edu.ifrn.pi.bookcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.ifrn.pi.bookcrud.model.entity.Country;
import br.edu.ifrn.pi.bookcrud.model.service.CountryService;
import br.edu.ifrn.pi.bookcrud.model.service.ValidationService;

@Controller
public class CountryController extends AbstractController{
	
	private long id;
	private String name;
	
	@Autowired
	private CountryService countryService;
	@Autowired
	private ValidationService validationService;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String save() {
		if(validationService.validateName(name)) {		
			Country country = new Country();
			country.setName(name);
			
			countryService.save(country);
			
			addInfoMessage("Save", String.format("A new Country was created. %s", name));
			
			return goToListView();
		}else {
			addErrorMessage("Error", "Invalid name");
			return "";
		}
	}
	
	public String update() {
		if(validationService.validateName(name)) {
			Country country = new Country();
			country.setId(id);
			country.setName(name);
			
			countryService.update(country);
			
			addInfoMessage("Update", String.format("Country %s updated.", name));
			
			return goToListView();
		}else {
			addErrorMessage("Error", "Invalid name");
			return "";
		}
	}
	
	public String delete() {		
		countryService.delete(id);
		
		addInfoMessage("Delete", String.format("Country %d deleted", id));
		
		return goToListView();
	}
	
	public List getAll() {
		return countryService.getAll();
	}
	
	public String goToCreateView() {
		return "countryCreateView";
	}
	
	public String goToUpdateView() {
		return "countryUpdateView";
	}
	
	public String goToListView() {
		return "countryListView";
	}
	
}
