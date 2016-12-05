package iranti.model.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import iranti.entity.Usuario;
import iranti.model.dao.UsuarioDAO;

@ManagedBean(name = "LoginMB")
@ViewScoped
public class LoginMB {

	private Usuario usuario;

	public LoginMB() {
		super();
		this.usuario = new Usuario();
	}

	public String criarUsuario() {
		return "create";

	}


	public String Enviar() {
		
		System.out.println(this.usuario.getNomeUsuario());
		usuario = UsuarioDAO.getInstance().getUsuario(usuario.getNomeUsuario(), usuario.getSenha());
	
		if (usuario == null) {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario nao encontrado!", "Erro no Login!"));
			return null;
		} else {
			return "/index";
		}

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
