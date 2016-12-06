package iranti.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import iranti.entity.Jogo;

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
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("iranti");
        entityManager = factory.createEntityManager();

        return entityManager;
    }

    public Jogo getById(final int id) {
        return entityManager.find(Jogo.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Jogo> findAll() {
        return entityManager.createQuery("FROM " + Jogo.class.getName()).getResultList();
    }

    public List<Jogo> getByName(String string) {
        return entityManager.createQuery("SELECT j FROM Jogo j WHERE j.nome LIKE %:nome%")
                .setParameter("nome", string)
                .getResultList();
    }

    public boolean persist(Jogo jogo) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(jogo);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    public void merge(Jogo jogo) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(jogo);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public boolean remove(Jogo jogo) {
        try {
            entityManager.getTransaction().begin();
            jogo = entityManager.find(Jogo.class, jogo.getId());
            entityManager.remove(jogo);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    public void removeById(final int id) {
        try {
            Jogo jogo = getById(id);
            remove(jogo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
