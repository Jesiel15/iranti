package iranti.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import iranti.entity.Peca;

public class PecaDAO {
	private static PecaDAO instance;
	protected EntityManager entityManager;

	public static PecaDAO getInstance() {
		if (instance == null) {
			instance = new PecaDAO();
		}

		return instance;
	}

	private PecaDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Peca");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public Peca getById(final int id) {
		return entityManager.find(Peca.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Peca> findAll() {
		return entityManager.createQuery("FROM " + Peca.class.getName()).getResultList();
	}

	public void persist(Peca Peca) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(Peca);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Peca Peca) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(Peca);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Peca Peca) {
		try {
			entityManager.getTransaction().begin();
			Peca = entityManager.find(Peca.class, Peca.getId());
			entityManager.remove(Peca);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) {
		try {
			Peca Peca = getById(id);
			remove(Peca);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
