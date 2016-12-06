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
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("iranti-project");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public Peca getById(final int id) {
        return entityManager.find(Peca.class, id);
    }

    @SuppressWarnings({"unchecked", "JpaQlInspection"})
    public List<Peca> findByIrantiId(int iranti_id) {
        return entityManager.createQuery("SELECT p FROM Peca p WHERE p.iranti_id = :iranti_id")
                .setParameter("iranti_id", iranti_id)
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Peca> findAll() {
        return entityManager.createQuery("FROM " + Peca.class.getName()).getResultList();
    }

    public void persist(Peca peca) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(peca);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Peca peca) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(peca);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Peca peca) {
        try {
            entityManager.getTransaction().begin();
            peca = entityManager.find(Peca.class, peca.getId());
            entityManager.remove(peca);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final int id) {
        try {
            Peca peca = getById(id);
            remove(peca);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
