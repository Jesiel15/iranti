package iranti.model.dao;

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
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("iranti");
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

	public boolean inserirUsuario(Usuario usuario) {
		try {
			getEntityManager().persist(usuario);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletarUsuario(Usuario usuario) {
		try {
			getEntityManager().remove(usuario);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}