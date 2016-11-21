package iranti.model.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import iranti.entity.Usuario;
import iranti.model.dao.UsuarioDAO;

@ManagedBean
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
