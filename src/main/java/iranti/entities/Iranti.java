package iranti.entities;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;

@ManagedBean
@Entity
public class Iranti {
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private String descricao;
	private Date dataCriacao;
	private Date ultimaModificacao;
	
	public Iranti() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getUltimaModificacao() {
		return ultimaModificacao;
	}

	public void setUltimaModificacao(Date ultimaModificacao) {
		this.ultimaModificacao = ultimaModificacao;
	}
}
