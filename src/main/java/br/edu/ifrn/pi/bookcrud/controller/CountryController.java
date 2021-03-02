package br.edu.ifrn.pi.bookcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.ifrn.pi.bookcrud.model.service.CountryService;
import br.edu.ifrn.pi.bookcrud.model.service.ValidationService;

@Controller
public class CountryController extends AbstractController{
	
	private long id;
	private String nameInPortuguese;
	private String nameInEnglish;
	private String acronym;
	
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
	public String getNameInPortuguese() {
		return nameInPortuguese;
	}
	public void setNameInPortuguese(String nameInPortuguese) {
		this.nameInPortuguese = nameInPortuguese;
	}
	public String getNameInEnglish() {
		return nameInEnglish;
	}
	public void setNameInEnglish(String nameInEnglish) {
		this.nameInEnglish = nameInEnglish;
	}
	public String getAcronym() {
		return acronym;
	}
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	
	public List getAll() {
		return countryService.getAll();
	}	
}
