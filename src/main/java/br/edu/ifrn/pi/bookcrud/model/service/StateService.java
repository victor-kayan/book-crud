package br.edu.ifrn.pi.bookcrud.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrn.pi.bookcrud.model.dao.StateDAO;
import br.edu.ifrn.pi.bookcrud.model.entity.State;

@Service
public class StateService {

	@Autowired
	private StateDAO stateDAO;
	
	public void save(State state) {		
		stateDAO.save(state);
	}
	
	public void update(State state) {		
		stateDAO.update(state);
	}
	
	public void delete(long id) {
		stateDAO.delete(id);
	}
	
	public List getAll() {
		return stateDAO.getAll();
	}
	
}
