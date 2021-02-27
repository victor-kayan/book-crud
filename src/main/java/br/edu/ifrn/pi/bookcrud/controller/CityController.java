package br.edu.ifrn.pi.bookcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.ifrn.pi.bookcrud.model.entity.City;
import br.edu.ifrn.pi.bookcrud.model.entity.State;
import br.edu.ifrn.pi.bookcrud.model.service.CityService;
import br.edu.ifrn.pi.bookcrud.model.service.ValidationService;

@Controller
public class CityController extends AbstractController{
	
	private long id;
	private String name;
	private State state;
	
	@Autowired
	private CityService cityService;
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
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	public String save() {
		if(validationService.validateName(name)) {				
			City city = new City();
			city.setName(name);
			city.setState(state);
			
			cityService.save(city);
			
			addInfoMessage("Save", String.format("A new City was created. %s", name));
			
			return goToListView();
		}else {
			addErrorMessage("Error", "Invalid name");
			return "";
		}
	}
	
	public String update() {
		if(validationService.validateName(name)) {
			City city = new City();
			city.setId(id);
			city.setName(name);
			city.setState(state);
			
			cityService.update(city);
			
			addInfoMessage("Update", String.format("City %s updated.", name));
			
			return goToListView();
		}else {
			addErrorMessage("Error", "Invalid name");
			return "";
		}
	}
	
	public String delete() {		
		cityService.delete(id);
		
		addInfoMessage("Delete", String.format("City %d deleted", id));
		
		return goToListView();
	}
	
	public List getAll() {
		return cityService.getAll();
	}
	
	public String goToCreateView() {
		return "cityCreateView";
	}
	
	public String goToUpdateView() {
		return "cityUpdateView";
	}
	
	public String goToListView() {
		return "cityListView";
	}
	
}
