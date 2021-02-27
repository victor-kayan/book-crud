package br.edu.ifrn.pi.bookcrud.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrn.pi.bookcrud.model.dao.TradeAgreementDAO;
import br.edu.ifrn.pi.bookcrud.model.entity.TradeAgreement;

@Service
public class TradeAgreementService {

	@Autowired
	private TradeAgreementDAO tradeAgreementDAO;
	
	public void save(TradeAgreement tradeAgreement) {		
		tradeAgreementDAO.save(tradeAgreement);
	}
	
	public void update(TradeAgreement tradeAgreement) {
		tradeAgreementDAO.update(tradeAgreement);
	}
	
	public void delete(long id) {
		tradeAgreementDAO.delete(id);
	}
	
	public List getAll() {
		return tradeAgreementDAO.getAll();
	}
	
}
