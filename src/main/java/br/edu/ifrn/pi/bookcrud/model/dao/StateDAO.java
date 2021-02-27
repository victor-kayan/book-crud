package br.edu.ifrn.pi.bookcrud.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.ifrn.pi.bookcrud.model.entity.State;

@Repository
public class StateDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public void save(State state) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(state);
		entityManager.getTransaction().commit();
	}

	public void update(State state) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.merge(state);
		entityManager.getTransaction().commit();
	}

	public void delete(long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		
		State state = entityManager.find(State.class, id);
		entityManager.remove(state);
		
		entityManager.getTransaction().commit();
	}

	public List getAll() {
		return entityManagerFactory.createEntityManager().createQuery("from State").getResultList();
	}

	public State getById(long id) {
		return entityManagerFactory.createEntityManager().find(State.class, id);
	}
}
