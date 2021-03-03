package br.edu.ifrn.pi.bookcrud.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrn.pi.bookcrud.model.dao.AuthorDAO;
import br.edu.ifrn.pi.bookcrud.model.entity.Author;

@Service
public class AuthorService {

	@Autowired
	private AuthorDAO authorDAO;
	
	public void save(Author author) {
		authorDAO.save(author);
	}
	
	public void update(Author author) {		
		authorDAO.update(author);
	}
	
	public void delete(Long id) {
		authorDAO.delete(id);
	}
	
	public List getAll() {
		return authorDAO.getAll();
	}
	
	public String getNameById(Long id) {
		return authorDAO.getById(id).getName();
	}
	
}
