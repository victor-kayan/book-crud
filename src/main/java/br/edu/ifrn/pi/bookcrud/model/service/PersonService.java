package br.edu.ifrn.pi.bookcrud.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrn.pi.bookcrud.model.dao.PersonDAO;
import br.edu.ifrn.pi.bookcrud.model.entity.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDAO personDAO;
	
	public void save(Person person) {
		personDAO.save(person);
	}
	
	public void update(Person person) {
		personDAO.update(person);
	}
	
	public void delete(long id) {
		personDAO.delete(id);
	}
	
	public List getAll() {
		return personDAO.getAll();
	}
	
}
