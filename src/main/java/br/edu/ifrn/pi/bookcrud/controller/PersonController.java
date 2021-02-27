package br.edu.ifrn.pi.bookcrud.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.ifrn.pi.bookcrud.model.entity.Country;
import br.edu.ifrn.pi.bookcrud.model.entity.Person;
import br.edu.ifrn.pi.bookcrud.model.service.PersonService;
import br.edu.ifrn.pi.bookcrud.model.service.ValidationService;

@Controller
public class PersonController extends AbstractController{
	
	private long id;
	private String name;
	private String cpf;
	private int height;
	private Date bornDate;
	
	@Autowired
	private PersonService personService;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Date getBornDate() {
		return bornDate;
	}
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}	
	
	public String save() {
		if(validationService.validateHeight(height) && validationService.validateName(name)) {	
			Person person = new Person();
			
			person.setName(name);
			person.setCpf(cpf);
			person.setHeight(height);
			person.setBornDate(bornDate);
			
			personService.save(person);
			
			addInfoMessage("Save", String.format("A new person was created. %s", name));
			
			return goToListView();
		}else {
			addErrorMessage("Error", "Invalid name and/or height");
			return "";
		}
	}
	
	public String update() {
		if(validationService.validateHeight(height) && validationService.validateName(name)) {			
			Person person = new Person();
			
			person.setId(id);
			person.setName(name);
			person.setCpf(cpf);
			person.setHeight(height);
			person.setBornDate(bornDate);
			
			personService.update(person);
			
			addInfoMessage("Update", String.format("Person %s updated", name));
			
			return goToListView();
		}else {
			addErrorMessage("Error", "Invalid name and/or height");
			return "";
		}
	}
	
	public String delete() {		
		personService.delete(id);
		
		addInfoMessage("Delete", String.format("Person %d deleted", id));
		
		return goToListView();
	}
	
	public List getAll() {
		return personService.getAll();
	}
	
	public String goToCreateView() {
		return "personCreateView";
	}
	
	public String goToUpdateView() {
		return "personUpdateView";
	}
	
	public String goToListView() {
		return "personListView";
	}
	
}
