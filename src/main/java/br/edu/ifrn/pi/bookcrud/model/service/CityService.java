package br.edu.ifrn.pi.bookcrud.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrn.pi.bookcrud.model.dao.CityDAO;
import br.edu.ifrn.pi.bookcrud.model.entity.City;

@Service
public class CityService {

	@Autowired
	private CityDAO cityDAO;
	
	public void save(City city) {		
		cityDAO.save(city);
	}
	
	public void update(City city) {
		cityDAO.update(city);
	}
	
	public void delete(long id) {
		cityDAO.delete(id);
	}
	
	public List getAll() {
		return cityDAO.getAll();
	}
	
}
