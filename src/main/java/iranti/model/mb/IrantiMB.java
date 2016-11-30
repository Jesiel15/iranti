package iranti.model.mb;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import iranti.entity.Iranti;
import iranti.model.dao.IrantiDAO;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class IrantiMB {

    private Iranti iranti;
    private List<Iranti> irantis = new ArrayList<Iranti>();

    public List<Iranti> getAlunos() {
        return irantis;
    }

    public void setIrantis(List<Iranti> irantis) {
        this.irantis = irantis;
    }

    public IrantiMB() {
        super();
        iranti = new Iranti();
    }

    public String novoIranti() {
        return "novo";
    }

    public String editarIranti() {
        return "editar";
    }

    public String jogarAgora() {
        return "play";
    }
    
    public void salvarIranti() {
        System.out.println(this.iranti);
        IrantiDAO.getInstance().persist(this.iranti);
    }

    public Iranti getIranti() {
        return iranti;
    }

    public void setIranti(Iranti iranti) {
        this.iranti = iranti;
    }

}
