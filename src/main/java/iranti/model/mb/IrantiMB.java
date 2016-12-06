package iranti.model.mb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import iranti.entity.Iranti;
import iranti.model.dao.IrantiDAO;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class IrantiMB {

    private Iranti iranti;
    private IrantiDAO irantiDAO;
    private List<Iranti> irantis = irantiDAO.getInstance().findAll();

    public IrantiMB() {
        super();
        iranti = new Iranti();
    }

    public String novoIranti() {
        return "novo";
    }

    public String listarIranti() {
        return "irantis";
    }

    public String jogarAgora() {
        return "play";
    }

    public String voltarIranti() {
        return "index";
    }

    public String editarIranti(Iranti iranti) {
        if (irantiDAO.getInstance().merge(iranti)) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Iranti editado com sucesso;)", "Deu bom!"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Deu ruim na edicao:/", "Erro no Iranti!"));
        }
        return null;
    }

    public String excluirIranti(Iranti iranti) {
        if (irantiDAO.getInstance().remove(iranti)) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Iranti excluido com sucesso;)", "Deu bom!"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Deu ruim na exclusao:/", "Erro no Iranti!"));
        }
        return null;
    }

    public String salvarIranti() {
        iranti.setDataCriacao(new Date(System.currentTimeMillis()));
        iranti.setUltimaModificacao(new Date(System.currentTimeMillis()));
        if (IrantiDAO.getInstance().persist(this.iranti)) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cadastro efetuado com sucesso ;)", "Deu bom!"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cadastro deu ruim :/", "Deu bom!"));
        }
        return null;
    }


    public Iranti getIranti() {
        return iranti;
    }

    public void setIranti(Iranti iranti) {
        this.iranti = iranti;
    }

    public List<Iranti> getIrantis() {
        return irantis;
    }

    public void setIrantis(List<Iranti> irantis) {
        this.irantis = irantis;
    }
}
