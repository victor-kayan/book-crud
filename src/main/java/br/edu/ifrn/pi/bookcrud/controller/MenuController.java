package br.edu.ifrn.pi.bookcrud.controller;

import org.springframework.stereotype.Controller;

@Controller
public class MenuController extends AbstractController{

	public String getHome() {
		addInfoMessage("Home", "Tela incial");
		return "/index.xhtml";
	}
	
	public String getAuthorListView() {
		addInfoMessage("Listar", "Listar escritores");
		return "authorListView";
	}
	
	public String getAuthorCreateView() {
		addInfoMessage("Create", "Cadastrar novo escritor");
		return "authorCreateView";
	}
	
	public String getBookListView() {
		addInfoMessage("Listar", "Listar livros");
		return "bookListView";
	}
	
	public String getBookCreateView() {
		addInfoMessage("Cadastrar", "Cadastrar novo livro");
		return "bookCreateView";
	}
	
}
