package iranti.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import iranti.entity.Usuario;

public class UsuarioDAO {

	private static UsuarioDAO instance;
	protected EntityManager entityManager;

	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}

		return instance;
	}

	private UsuarioDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("iranti-project");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public Usuario getUsuario(String nomeUsuario, String senha) {

		try {
			Usuario usuario = (Usuario) getEntityManager()
					.createQuery("SELECT u from Usuario u where u.nomeUsuario = :name and u.senha = :senha")
					.setParameter("name", nomeUsuario).setParameter("senha", senha).getSingleResult();

			return usuario;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Usuario getById(final int id) {
		return entityManager.find(Usuario.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() {
		return entityManager.createQuery("FROM " + Usuario.class.getName()).getResultList();
	}

	public boolean persist(Usuario usuario) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(usuario);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	public boolean merge(Usuario usuario) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(usuario);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

	public boolean remove(Usuario usuario) {
		try {
			entityManager.getTransaction().begin();
			usuario = entityManager.find(Usuario.class, usuario.getId());
			entityManager.remove(usuario);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
			return false;
		}
	}

}