package iranti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * @rel: 1 Iranti possui nenhum ou varios Rankings
 * @rel: 1 Iranti possui nenhum ou varios Jogos
 * @rel: 1 Iranti possui uma ou varios Pecas
 * @rel: 1 Iranti eh criado por um e somente um Usuario
 *
 */
@Entity
@SequenceGenerator(name = "IRANTI_SEQUENCE", sequenceName = "IRANTI_SEQUENCE", allocationSize = 1, initialValue = 0)
@Table(name = "IRANTI")
public class Iranti implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IRANTI_SEQUENCE")
    @Column(name = "Iranti_Id", nullable = false)
    private Integer id;

    @Column(name = "Nome", nullable = false)
    private String nome;

    @Column(name = "Descricao")
    private String descricao;

    @Temporal(value = TemporalType.TIMESTAMP) // TIMESTAMP: Data e Hora
    @Column(name = "Data_Criacao", nullable = false)
    private Date dataCriacao;

    @Temporal(value = TemporalType.TIMESTAMP) // TIMESTAMP: Data e Hora
    @Column(name = "Data_Ultima_Modificacao", nullable = false)
    private Date ultimaModificacao;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Peca_Id")
    private List<Peca> pecas;

    @OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "User_Id", nullable = false)
    private Usuario user;

    public Iranti() {
        this.dataCriacao = new Date(System.currentTimeMillis());
    }

    public Iranti(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.ultimaModificacao = new Date(System.currentTimeMillis());
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Iranti{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", dataCriacao=" + dataCriacao + ", ultimaModificacao=" + ultimaModificacao + ", pecas=" + pecas + ", user=" + user + '}';
    }
    
    
}
