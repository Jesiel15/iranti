package iranti.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import iranti.entity.Iranti;

public class JogoDAO {

    private static JogoDAO instance;
    protected EntityManager entityManager;

    public static JogoDAO getInstance() {
        if (instance == null) {
            instance = new JogoDAO();
        }

        return instance;
    }

    private JogoDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("iranti-project");
            entityManager = factory.createEntityManager();

        return entityManager;
    }

    public Iranti getById(final int id) {
        return entityManager.find(Iranti.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Iranti> findAll() {
        return entityManager.createQuery("FROM " + Iranti.class.getName()).getResultList();
    }

    public boolean persist(Iranti iranti) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(iranti);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
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
