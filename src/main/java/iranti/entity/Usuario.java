package iranti.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * @rel: 1 Usuario cria nenhum ou varios Jogos
 * @rel: 1 Usuario joga nenhum ou varios Jogos
 * @rel: 1 Usuario cria nenhum ou varios Irantis: Administrador
 * @rel: 1 Usuario possui nenhum ou varios rankings
 *
 */

@Entity
@SequenceGenerator(name = "USER_SEQUENCE", sequenceName = "USER_SEQUENCE", allocationSize = 1, initialValue = 0)
@Table(name = "USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQUENCE")
	@Column(name = "User_Id", nullable = false)
	private Integer id;

	@Column(name = "Username", nullable = false, unique = true)
	private String nomeUsuario;

	@Column(name = "Senha", nullable = false, unique = false)
	private String senha;

	@Column(name = "Nome", nullable = false)
	private String nome;

	@Temporal(value = TemporalType.TIMESTAMP) // TIMESTAMP: Data e Hora
	@Column(name = "Last_Access")
	private Date ultimoAcesso;

	@Column(name = "Email")
	private String email;

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
