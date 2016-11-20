package iranti.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
 
@Entity
public class Usuario {
      
      @Id
      @Column(name="id", nullable=false, unique=true)
      private int id;
      
      @Column(name="userName", nullable=false, unique=true)
      private String nomeUsuario;
      
      @Column(name="password", nullable=false, unique=false)
      private String senha;
 
      @Column(name="lastAccess", unique=true)
      @Temporal(TemporalType.DATE)
      private Date ultimoAcesso;
      
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
 }

//import javax.persistence.*;
//
//@Entity
//public class Usuario {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//	private String nome;
//	private String sobrenome;
//	private String email;
//	private String apelido;
//	
//	public Usuario() {
//		
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	public String getSobrenome() {
//		return sobrenome;
//	}
//
//	public void setSobrenome(String sobrenome) {
//		this.sobrenome = sobrenome;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getApelido() {
//		return apelido;
//	}
//
//	public void setApelido(String apelido) {
//		this.apelido = apelido;
//	}
//	
//}
