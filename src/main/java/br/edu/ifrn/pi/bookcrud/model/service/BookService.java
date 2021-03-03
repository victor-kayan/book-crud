package br.edu.ifrn.pi.bookcrud.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrn.pi.bookcrud.model.dao.BookDAO;
import br.edu.ifrn.pi.bookcrud.model.entity.Book;


@Service
public class BookService {

	@Autowired
	private BookDAO bookDAO;
	
	public void save(Book book) {
		bookDAO.save(book);
	}
	
	public void update(Book book) {		
		bookDAO.update(book);
	}
	
	public void delete(Long id) {
		bookDAO.delete(id);
	}
	
	public List getAll() {
		return bookDAO.getAll();
	}
	
	public String geTitleById(Long id) {
		return bookDAO.getById(id).getTitle();
	}
	
}
