package br.edu.ifrn.pi.bookcrud.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.ifrn.pi.bookcrud.model.entity.Author;
import br.edu.ifrn.pi.bookcrud.model.entity.Country;
import br.edu.ifrn.pi.bookcrud.model.service.AuthorService;
import br.edu.ifrn.pi.bookcrud.model.service.ValidationService;

@Controller
public class AuthorController extends AbstractController{
	
	private Long id;
	private String name;
	private String cpf;
	private Date bornDate;
	private Country nationality;
	
	@Autowired
	private AuthorService authorService;
	@Autowired
	private ValidationService validationService;
	
	public String save() {
		if (validationService.validateName(name)) {
			if (validationService.validateCpf(cpf)) {
				Author author = new Author(name, cpf, bornDate, nationality);
				
				authorService.save(author);
				
				addInfoMessage("Salvo com sucesso!", String.format("O autor %s foi cadastrado", name));
				
				return goToListView();
			} else {
				addErrorMessage("O CPF inserido é inválido", "Erro ao cadastrar autor");
				return "";
			}
		} else {
			addErrorMessage("O nome inserido é inválido", "Erro ao cadastrar autor");
			return "";
		}
	}
	
	public String update() {
		if(validationService.validateName(name)) {
			if (validationService.validateCpf(cpf)) {
				Author author = new Author(id, name, cpf, bornDate, nationality);
				
				authorService.update(author);
				
				addInfoMessage("Atualizado com sucesso!", String.format("Autor %s atualizado", name));
				
				return goToListView();
			} else {
				addErrorMessage("O CPF inserido é inválido", "Erro ao atualizar autor");
				return "";
			}
		} else {
			addErrorMessage("O nome inserido é inválido", "Erro ao atualizar autor");
			return "";
		}
	}
	
	public String delete() {		
		String authorName = authorService.getNameById(id);
		
		authorService.delete(id);
		
		addInfoMessage("Excluído com sucesso!", String.format("O autor %s foi deletado", authorName));
		
		return goToListView();
	}
	
	public List getAll() {
		return authorService.getAll();
	}
	
	public String goToCreateView() {
		return "/author/createView";
	}
	
	public String goToUpdateView() {
		return "/author/updateView";
	}
	
	public String goToListView() {
		return "/author/listView";
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public Date getBornDate() {
		return bornDate;
	}
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}
	public Country getNationality() {
		return nationality;
	}
	public void setNationality(Country nationality) {
		this.nationality = nationality;
	}

}
