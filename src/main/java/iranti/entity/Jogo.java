package iranti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="jogo")
public class Jogo implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="jogo_id")
	private Integer id;
	@Column
	private Date inicio;
	@Column
	private Date fim;
	@Column
	private Integer Tipo;
	@Enumerated(EnumType.STRING)
	private Status status;
	public enum Status {
		Concluido, Desistente
	}
	@Enumerated(EnumType.STRING)
	private Dificuldade dificuldade;
	public enum Dificuldade {
		Facil, Medio, Dificil
	}
	private static final long serialVersionUID = 1L;
	
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

	public Integer getTipo() {
		return Tipo;
	}

	public void setTipo(Integer tipo) {
		Tipo = tipo;
	}

}
