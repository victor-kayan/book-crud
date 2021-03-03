package br.edu.ifrn.pi.bookcrud.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.ifrn.pi.bookcrud.model.entity.Author;

@Repository
public class AuthorDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public void save(Author author) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(author);
		entityManager.getTransaction().commit();
	}

	public void update(Author author) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.merge(author);
		entityManager.getTransaction().commit();
	}

	public void delete(long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		
		Author author = entityManager.find(Author.class, id);
		entityManager.remove(author);
		
		entityManager.getTransaction().commit();
	}

	public List getAll() {
		return entityManagerFactory.createEntityManager().createQuery("from Author").getResultList();
	}

	public Author getById(long id) {
		return entityManagerFactory.createEntityManager().find(Author.class, id);
	}
}
