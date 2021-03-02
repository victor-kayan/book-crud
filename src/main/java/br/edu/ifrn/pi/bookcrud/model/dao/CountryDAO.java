package br.edu.ifrn.pi.bookcrud.model.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.ifrn.pi.bookcrud.model.entity.Country;

@Repository
public class CountryDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public List getAll() {
		return entityManagerFactory.createEntityManager().createQuery("from Country").getResultList();
	}

	public Country getById(long id) {
		return entityManagerFactory.createEntityManager().find(Country.class, id);
	}
}
