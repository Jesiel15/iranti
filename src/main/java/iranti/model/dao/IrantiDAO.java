package iranti.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import iranti.entity.Iranti;

public class IrantiDAO {

    private static IrantiDAO instance;
    protected EntityManager entityManager;

    public static IrantiDAO getInstance() {
        if (instance == null) {
            instance = new IrantiDAO();
        }

        return instance;
    }

    private IrantiDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("iranti-project");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public Iranti getById(final int id) {
        return entityManager.find(Iranti.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Iranti> findAll() {
        return entityManager.createQuery("FROM " + Iranti.class.getName()).getResultList();
    }

    public void persist(Iranti iranti) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(iranti);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Iranti iranti) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(iranti);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Iranti iranti) {
        try {
            entityManager.getTransaction().begin();
            iranti = entityManager.find(Iranti.class, iranti.getId());
            entityManager.remove(iranti);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final int id) {
        try {
            Iranti iranti = getById(id);
            remove(iranti);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
