package iranti.model.mb;

import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import iranti.entity.Peca;


@ManagedBean
@SessionScoped
public class PecaMB {
	private Peca peca;
	private Date dataCriacao;
	private Date dataModificacao;
	private String local;
	
	public PecaMB() {
		super();
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
		
}
