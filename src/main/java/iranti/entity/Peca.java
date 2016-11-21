package iranti.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="peca")
public class Peca implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="peca_id")
	private Integer id;
	@Column
	private Date dataCriacao;
	@Column
	private Date dataModificacao;
	@Column
	private String local;
	@
	private Iranti iranti;
	private static final long serialVersionUID = 1L;
	
	public Peca() {
		super();
    }
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

}
