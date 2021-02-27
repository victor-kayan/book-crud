package br.edu.ifrn.pi.bookcrud.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.ifrn.pi.bookcrud.model.entity.TradeAgreement;

@Repository
public class TradeAgreementDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public void save(TradeAgreement tradeAgreement) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(tradeAgreement);
		entityManager.getTransaction().commit();
	}

	public void update(TradeAgreement tradeAgreement) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.merge(tradeAgreement);
		entityManager.getTransaction().commit();
	}

	public void delete(long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		
		TradeAgreement tradeAgreement = entityManager.find(TradeAgreement.class, id);
		entityManager.remove(tradeAgreement);
		
		entityManager.getTransaction().commit();
	}

	public List getAll() {
		return entityManagerFactory.createEntityManager().createQuery("from TradeAgreement").getResultList();
	}

	public TradeAgreement getById(long id) {
		return entityManagerFactory.createEntityManager().find(TradeAgreement.class, id);
	}
}
