package iranti.model.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import iranti.entity.Usuario;
import iranti.entity.Usuario;
import iranti.entity.enums.Papel;
import iranti.model.dao.UsuarioDAO;

import java.sql.SQLException;
import java.util.List;

@ManagedBean
@ViewScoped
public class UsuarioMB {

    private Usuario usuario = new Usuario();
    private UsuarioDAO userDAO;
    private Papel papeis;

    public String cadastro() {
        return "/user/novo";
    }

    public String novoUsuario() {
        if (userDAO.getInstance().persist(usuario)) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Usuario cadastrado com sucesso!"));
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Erro no cadastr de usuario!"));
        }
        return null;
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

    public boolean isAdmin() {
        return usuario.getPapel().equals(Papel.Administrador);
    }

    public String editarUser(Usuario user) {
        if (userDAO.getInstance().merge(user)) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario editado com sucesso;)", "Deu bom!"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Deu ruim na edicao:/", "Erro no Usuario!"));
        }
        return null;
    }

    public String excluirUser(Usuario user) {
        if (userDAO.getInstance().remove(user)) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario excluido com sucesso;)", "Deu bom!"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Deu ruim na exclusao:/", "Erro no Usuario!"));
        }
        return null;
    }

    public List<Usuario> getUsuarios() {
        List<Usuario> listaUsuarios = userDAO.getInstance().findAll();
        return listaUsuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Papel[] getPapeis() {
        return Papel.values();
    }

    public String listarUsuarios() {
        return "users";
    }

    public String criarUsuario() {
//        if(isAdmin())
        return "novo";
    }

    public String editar() {
        return "editar";
    }
}
