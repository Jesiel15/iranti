package iranti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * @rel: 1 Jogo tem nenhum ou varios Rankings
 * @rel: 1 Jogo eh de 1 e somente 1 Iranti
 * @rel: 1 Jogo eh jogado por 1 ou varios Usuarios
 * @rel: 1 Jogo eh criado por 1 e somente 1 Usuario
 * 
 */

@Entity
@SequenceGenerator(name = "JOGO_SEQUENCE", sequenceName = "JOGO_SEQUENCE", allocationSize = 1, initialValue = 0)
public class Jogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JOGO_SEQUENCE")
	@Column(name = "jogo_id", nullable = false, unique = true)
	private Integer id;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date inicio;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column
	private Date fim;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Status status;
	public enum Status {
		Concluido, Desistente
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Dificuldade dificuldade;

	public enum Dificuldade {
		Facil, Medio, Dificil
	}
	
	@OneToOne(mappedBy="jogo")
	@JoinColumn(name = "ranking_id")
	private Ranking ranking;

	public Jogo() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

}
