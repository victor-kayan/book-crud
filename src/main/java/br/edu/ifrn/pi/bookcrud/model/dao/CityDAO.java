package br.edu.ifrn.pi.bookcrud.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.ifrn.pi.bookcrud.model.entity.City;

@Repository
public class CityDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public void save(City city) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(city);
		entityManager.getTransaction().commit();
	}

	public void update(City city) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.merge(city);
		entityManager.getTransaction().commit();
	}

	public void delete(long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		
		City city = entityManager.find(City.class, id);
		entityManager.remove(city);
		
		entityManager.getTransaction().commit();
	}

	public List getAll() {
		return entityManagerFactory.createEntityManager().createQuery("from City").getResultList();
	}

	public City getById(long id) {
		return entityManagerFactory.createEntityManager().find(City.class, id);
	}
}
