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
		return "/author/listView";
	}
	
	public String getAuthorCreateView() {
		addInfoMessage("Create", "Cadastrar novo escritor");
		return "/author/createView";
	}
	
	public String getBookListView() {
		addInfoMessage("Listar", "Listar livros");
		return "/book/listView";
	}
	
	public String getBookCreateView() {
		addInfoMessage("Cadastrar", "Cadastrar novo livro");
		return "/book/createView";
	}
	
}
