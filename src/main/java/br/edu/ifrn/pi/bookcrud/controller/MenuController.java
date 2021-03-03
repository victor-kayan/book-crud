package br.edu.ifrn.pi.bookcrud.controller;

import org.springframework.stereotype.Controller;

@Controller
public class MenuController extends AbstractController{

	public String getHome() {
		addInfoMessage("Home", "Home");
		return "index";
	}
	
	public String getPersonListView() {
		addInfoMessage("List", "List of people");
		return "personListView";
	}
	
	public String getPersonCreateView() {
		addInfoMessage("Create", "Create a new person");
		return "personCreateView";
	}
	
	public String getBookListView() {
		addInfoMessage("Listar", "Listar livros");
		return "/book/listView";
	}
	
	public String getBookCreateView() {
		addInfoMessage("Cadastrar", "Cadastrar novo livro");
		return "/book/createView";
	}
	
	public String getStateListView() {
		addInfoMessage("List", "List of State");
		return "stateListView";
	}
	
	public String getStateCreateView() {
		addInfoMessage("Create", "Create a new state");
		return "stateCreateView";
	}
	
	public String getCityListView() {
		addInfoMessage("List", "List of City");
		return "cityListView";
	}
	
	public String getCityCreateView() {
		addInfoMessage("Create", "Create a new city");
		return "cityCreateView";
	}
	
	public String getTradeAgreementListView() {
		addInfoMessage("List", "List of Trade Agreements");
		return "tradeAgreementListView";
	}
	
	public String getTradeAgreementCreateView() {
		addInfoMessage("Create", "Create a new Trade Agreement");
		return "tradeAgreementCreateView";
	}
	
}
