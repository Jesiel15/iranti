package iranti.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Jogo {
	@Id
	@GeneratedValue
	private Integer id;

	private Date inicio;
	private Date fim;
	private Integer Tipo;

	enum Status {
		Concluido, Desistente
	}	Status status;

	enum Dificuldade {
		Facil, Medio, Dificil
	}	Dificuldade dificuldade;

	
	
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

	public Dificuldade getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}

}
