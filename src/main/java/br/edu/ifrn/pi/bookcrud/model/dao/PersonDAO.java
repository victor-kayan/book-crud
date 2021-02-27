package br.edu.ifrn.pi.bookcrud.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.ifrn.pi.bookcrud.model.entity.Person;
import br.edu.ifrn.pi.bookcrud.model.entity.State;

@Repository
public class PersonDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public void save(Person person) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(person);
		entityManager.getTransaction().commit();
	}

	public void update(Person person) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.merge(person);
		entityManager.getTransaction().commit();
	}

	public void delete(long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		
		Person person = entityManager.find(Person.class, id);
		entityManager.remove(person);
		
		entityManager.getTransaction().commit();
	}

	public List getAll() {
		return entityManagerFactory.createEntityManager().createQuery("from Person").getResultList();
	}

	public Person getById(long id) {
		return entityManagerFactory.createEntityManager().find(Person.class, id);
	}
}
