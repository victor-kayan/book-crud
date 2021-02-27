package br.edu.ifrn.pi.bookcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.ifrn.pi.bookcrud.model.entity.Person;
import br.edu.ifrn.pi.bookcrud.model.entity.State;
import br.edu.ifrn.pi.bookcrud.model.service.StateService;
import br.edu.ifrn.pi.bookcrud.model.service.ValidationService;

@Controller
public class StateController extends AbstractController{
	
	private long id;
	private String name;
	private Person governor;
	
	@Autowired
	private StateService stateService;
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
	public Person getGovernor() {
		return governor;
	}
	public void setGovernor(Person governor) {
		this.governor = governor;
	}
	
	public String save() {
		if(validationService.validateName(name)) {		
			State state = new State();
			state.setName(name);
			state.setGovernor(governor);
			
			stateService.save(state);
			
			addInfoMessage("Save", String.format("A new State was created. %s", name));
			
			return goToListView();
		}else {
			addErrorMessage("Error", "Invalid name");
			return "";
		}
	}
	
	public String update() {
		if(validationService.validateName(name)) {		
			State state = new State();
			state.setId(id);
			state.setName(name);
			state.setGovernor(governor);
			
			stateService.update(state);
			
			addInfoMessage("Update", String.format("State %s updated.", name));
			
			return goToListView();
		}else {
			addErrorMessage("Error", "Invalid name");
			return "";
		}
	}
	
	public String delete() {		
		stateService.delete(id);
		
		addInfoMessage("Delete", String.format("State %d deleted", id));
		
		return goToListView();
	}
	
	public List getAll() {
		return stateService.getAll();
	}
	
	public String goToCreateView() {
		return "stateCreateView";
	}
	
	public String goToUpdateView() {
		return "stateUpdateView";
	}
	
	public String goToListView() {
		return "stateListView";
	}
	
}
