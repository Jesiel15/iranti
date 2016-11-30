package iranti.model.mb;

import iranti.entity.Ranking;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class RankingMB {
    
    private List<Ranking> usuarios;
    private int cont;

    public RankingMB() {
    }

    public List<Ranking> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Ranking> usuarios) {
        this.usuarios = usuarios;
    }

    public int getCont() {
        return cont;
    }
    
}
