package br.edu.ifrn.pi.bookcrud.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.ifrn.pi.bookcrud.model.entity.Country;

@Repository
public class CountryDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public void save(Country country) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(country);
		entityManager.getTransaction().commit();
	}

	public void update(Country country) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.merge(country);
		entityManager.getTransaction().commit();
	}

	public void delete(long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		
		Country country = entityManager.find(Country.class, id);
		entityManager.remove(country);
		
		entityManager.getTransaction().commit();
	}

	public List getAll() {
		return entityManagerFactory.createEntityManager().createQuery("from Country").getResultList();
	}

	public Country getById(long id) {
		return entityManagerFactory.createEntityManager().find(Country.class, id);
	}
}
