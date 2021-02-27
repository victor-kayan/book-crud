package br.edu.ifrn.pi.bookcrud.controller;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.event.DragDropEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.ifrn.pi.bookcrud.model.entity.Country;
import br.edu.ifrn.pi.bookcrud.model.entity.TradeAgreement;
import br.edu.ifrn.pi.bookcrud.model.service.TradeAgreementService;
import br.edu.ifrn.pi.bookcrud.model.service.ValidationService;

@Controller
public class TradeAgreementController extends AbstractController{
	
	private long id;
	private String name;
	private List<Country> countries = new ArrayList<Country>();
	
	@Autowired
	private TradeAgreementService tradeAgreementService;
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
	public List<Country> getCountries() {
		return countries;
	}
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	
	public void onDrop(DragDropEvent ddEvent) {
		Country country = ((Country) ddEvent.getData());
  
		if(!countries.contains(country)) {
			countries.add(country);
		}
    }
	
	public void onDropRemove(Country country) {
		countries.remove(country);
    }
	
	public String save() {
		if(validationService.validateName(name)) {		
			TradeAgreement tradeAgreement = new TradeAgreement();
			tradeAgreement.setName(name);
			tradeAgreement.setCountries(countries);
			
			tradeAgreementService.save(tradeAgreement);
			
			addInfoMessage("Save", String.format("A new TradeAgreement was created. %s", name));
			
			return goToListView();
		}else {
			addErrorMessage("Error", "Invalid name");
			return "";
		}
	}
	
	public String update() {
		if(validationService.validateName(name)) {
			TradeAgreement tradeAgreement = new TradeAgreement();
			tradeAgreement.setId(id);
			tradeAgreement.setName(name);
			tradeAgreement.setCountries(countries);
			
			tradeAgreementService.update(tradeAgreement);
			
			addInfoMessage("Update", String.format("TradeAgreement %s updated.", name));
			
			return goToListView();
		}else {
			addErrorMessage("Error", "Invalid name");
			return "";
		}
	}
	
	public String delete() {		
		tradeAgreementService.delete(id);
		
		addInfoMessage("Delete", String.format("TradeAgreement %d deleted", id));
		
		return goToListView();
	}
	
	public List getAll() {
		return tradeAgreementService.getAll();
	}
	
	public String goToCreateView() {
		return "tradeAgreementCreateView";
	}
	
	public String goToUpdateView() {
		return "tradeAgreementUpdateView";
	}
	
	public String goToListView() {
		return "tradeAgreementListView";
	}
	
}
