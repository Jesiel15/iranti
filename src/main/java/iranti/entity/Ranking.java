package iranti.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * @rel: 1 Ranking eh de 1 e somente 1 Jogo
 * @rel: 1 Ranking eh de 1 e somente 1 Iranti
 * @rel: 1 Ranking eh de 1 e somente 1 Usuario
 *
 */

@Entity
public class Ranking implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ranking_id", nullable = false, unique = true)
	private Integer id;
	
	@Column
	private double segundos;
	
	@OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name="jogo_id", nullable=false)
    private Jogo jogo;
	
	@OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name="iranti_id", nullable=false)
    private Iranti iranti;
	
	@OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name="user_id", nullable=false)
    private Usuario user;
	
	public Ranking() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getSegundos() {
		return segundos;
	}

	public void setSegundos(double segundos) {
		this.segundos = segundos;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public Iranti getIranti() {
		return iranti;
	}

	public void setIranti(Iranti iranti) {
		this.iranti = iranti;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
	
}
