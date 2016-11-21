package iranti.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * @rel: 1 Peca tem um e somente um Iranti
 * 
 */

@Entity
@SequenceGenerator(name = "PECA_SEQUENCE", sequenceName = "PECA_SEQUENCE", allocationSize = 1, initialValue = 0)
@Table(name = "PECA")
public class Peca implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PECA_SEQUENCE")
	@Column(name = "Peca_Id", nullable = false)
	private Integer id;

	@Temporal(value = TemporalType.TIMESTAMP) // TIMESTAMP: Data e Hora
	@Column(name = "Data_Criacao", nullable = false)
	private Date dataCriacao;

	@Temporal(value = TemporalType.TIMESTAMP) // TIMESTAMP: Data e Hora
	@Column(name = "Data_Ultima_Modificacao", nullable = false)
	private Date ultimaModificacao;

	@Column(name = "Local")
	private String local; // diretório onde foi salvo: /data/...

	@OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "Iranti_Id", nullable = false)
	private Iranti iranti;

	public Peca() {

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

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

}
