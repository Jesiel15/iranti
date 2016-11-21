package iranti.model.mb;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import iranti.entity.Iranti;

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

	public String criarIranti() {
		return "create";

	}

	public String editarIranti() {
		return "edit";

	}

	public String jogarAgora() {
		return "play";

	}

	public Iranti getIranti() {
		return iranti;
	}

	public void setIranti(Iranti iranti) {
		this.iranti = iranti;
	}

}
