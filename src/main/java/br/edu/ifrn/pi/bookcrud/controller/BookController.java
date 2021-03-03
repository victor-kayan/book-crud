package br.edu.ifrn.pi.bookcrud.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.ifrn.pi.bookcrud.model.entity.Author;
import br.edu.ifrn.pi.bookcrud.model.entity.Book;
import br.edu.ifrn.pi.bookcrud.model.service.BookService;
import br.edu.ifrn.pi.bookcrud.model.service.ValidationService;

@Controller
public class BookController extends AbstractController{
	
	private Long id;
	private String title;
	private String company;
	private Date releaseYear;
	private int numberOfPages;
	private Author author;
	
	@Autowired
	private BookService bookService;
	@Autowired
	private ValidationService validationService;
	
	public String save() {
		if (validationService.validateTitle(title)) {
			if (validationService.validateTitle(company)) {
				if (validationService.validateNumberOfPages(numberOfPages)) {
					Book book = new Book(title, company, releaseYear, numberOfPages, author);
					
					bookService.save(book);
					
					addInfoMessage("Salvo com sucesso!", String.format("O livro %s foi cadastrado", title));
					
					return goToListView();
				} else {
					addErrorMessage("O número de páginas inserido é inválido", "Erro ao cadastrar livro");
				}
			} else {
				addErrorMessage("A editora inserida é inválida", "Erro ao cadastrar livro");
			}
		} else {
			addErrorMessage("O título inserido é inválido", "Erro ao cadastrar livro");
		}
		return "";
	}
	
	public String update() {
		if (validationService.validateTitle(title)) {
			if (validationService.validateTitle(company)) {
				if (validationService.validateNumberOfPages(numberOfPages)) {
					Book book = new Book(id, title, company, releaseYear, numberOfPages, author);
				
					bookService.update(book);
					
					addInfoMessage("Atualizado com sucesso!", String.format("Livro %s atualizado", title));
					
					return goToListView();
				} else {
					addErrorMessage("O número de páginas inserido é inválido", "Erro ao atualizar livro");
				}
			} else {
				addErrorMessage("A editora inserida é inválido", "Erro ao atualizar livro");
			}
		} else {
			addErrorMessage("O título inserido é inválido", "Erro ao atualizar livro");
		}
		return "";
	}
	
	public String delete() {		
		String bookTitle = bookService.geTitleById(id);
		
		bookService.delete(id);
		
		addInfoMessage("Excluído com sucesso!", String.format("O livro %s foi deletado", bookTitle));
		
		return goToListView();
	}
	
	public List getAll() {
		return bookService.getAll();
	}
	
	public String goToCreateView() {
		return "/book/createView";
	}
	
	public String goToUpdateView() {
		return "bookUpdateView";
	}
	
	public String goToListView() {
		return "/book/listView";
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}

}
