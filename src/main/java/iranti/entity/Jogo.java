package iranti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import iranti.entity.enums.Dificuldade;
import iranti.entity.enums.Status;

/**
 * @rel: 1 Jogo tem nenhum ou varios Rankings
 * @rel: 1 Jogo eh de 1 e somente 1 Iranti
 * @rel: 1 Jogo eh criado por 1 e somente 1 Usuario
 * @rel: 1 Jogo eh jogado por 1 ou varios Usuarios
 * 
 */

@Entity
@SequenceGenerator(name = "JOGO_SEQUENCE", sequenceName = "JOGO_SEQUENCE", allocationSize = 1, initialValue = 0)
@Table(name = "JOGO")
public class Jogo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JOGO_SEQUENCE")
	@Column(name = "Jogo_Id", nullable = false)
	private Integer id;

	@Temporal(value = TemporalType.TIMESTAMP) // TIMESTAMP: Data e Hora
	@Column(name = "Data_Inicio", nullable = false)
	private Date inicio;

	@Temporal(value = TemporalType.TIMESTAMP) // TIMESTAMP: Data e Hora
	@Column(name = "Data_Fim")
	private Date fim;

	@Enumerated(EnumType.STRING)
	@Column(name = "Status", nullable = false)
	private Status status;

	@Enumerated(EnumType.STRING)
	@Column(name = "Dificuldade", nullable = false)
	private Dificuldade dificuldade;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "Jogador_Id")
	private List<Usuario> jogadores;

	@OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "Iranti_Id", nullable = false)
	private Iranti iranti;

	@OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "Criador_Id", nullable = false)
	private Usuario criador;

	public Jogo() {

	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Dificuldade getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
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

	public Iranti getIranti() {
		return iranti;
	}

	public void setIranti(Iranti iranti) {
		this.iranti = iranti;
	}

	public Usuario getCriador() {
		return criador;
	}

	public void setCriador(Usuario criador) {
		this.criador = criador;
	}

}
