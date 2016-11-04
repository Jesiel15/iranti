package iranti.entities;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Peca {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Date dataCriacao;
	private Date dataModificacao;
	private String local;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	public Peca() {
    		
    }
	
	
	
}
