package iranti.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import iranti.entity.Ranking;

public class RankingDAO {
	private static RankingDAO instance;
	protected EntityManager entityManager;

	public static RankingDAO getInstance() {
		if (instance == null) {
			instance = new RankingDAO();
		}

		return instance;
	}

	private RankingDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("iranti");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public Ranking getById(final int id) {
		return entityManager.find(Ranking.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Ranking> findAll() {
		return entityManager.createQuery("FROM " + Ranking.class.getName()).getResultList();
	}

	public void persist(Ranking ranking) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(ranking);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Ranking ranking) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(ranking);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Ranking ranking) {
		try {
			entityManager.getTransaction().begin();
			ranking = entityManager.find(Ranking.class, ranking.getId());
			entityManager.remove(ranking);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) {
		try {
			Ranking ranking = getById(id);
			remove(ranking);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
