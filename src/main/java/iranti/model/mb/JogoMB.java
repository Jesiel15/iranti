package iranti.model.mb;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import iranti.entity.Iranti;
import iranti.entity.Jogo;
import iranti.entity.Peca;
import iranti.entity.Usuario;
import iranti.entity.enums.Dificuldade;
import iranti.entity.enums.Status;
import iranti.model.dao.IrantiDAO;
import iranti.model.dao.JogoDAO;
import iranti.model.dao.UsuarioDAO;
import iranti.model.service.JogoSv;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class JogoMB {

	private Jogo jogo;
	private Iranti iranti;
	private IrantiDAO irantiDAO;
	private JogoDAO jogoDAO;
	private UsuarioDAO dono;
	private List<Jogo> jogos = new ArrayList<Jogo>();
	private List<Iranti> irantis = new ArrayList<Iranti>();
	private List<Peca> pecas = new ArrayList<Peca>();
	private List<Usuario> jogadores = new ArrayList<Usuario>();


	public JogoMB() {
		super();
		this.jogo = new Jogo();
	}

	public String novoJogo() {
		//this.irantis = irantiDAO.findAll();
		Iranti iranti = new Iranti("Teste 1", "Teste1 descricao");
		this.irantis.add(iranti);
		iranti = new Iranti("Teste 2", "Teste2 descricao");
		this.irantis.add(iranti);
		iranti = new Iranti("Teste 3", "Teste3 descricao");
		this.irantis.add(iranti);
		if (this.irantis.size() > 0 ) {
			return "novo";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Eh necessario cadastrar um Iranti primeiro ;)", "Erro no Jogo!"));
			return null;
		}
	}

	public Dificuldade[] getDificuldade() {
		return Dificuldade.values();
	}

	public Status[] getStatuses() {return Status.values(); }

	public String editarJogo() {
		return "editar";
	}

	public String jogarAgora() {
		//this.jogos = jogoDAO.findAll();
		Jogo jogo = new Jogo();
		this.jogos.add(jogo);
		jogo = new Jogo(Status.Andamento, Dificuldade.Medio, this.jogadores, irantiDAO.getInstance().getById(2), dono.getInstance().getById(1));
		this.jogos.add(jogo);
		if (this.jogos.size() > 0 ) {
			return "/jogo/play";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Eh necessario cadastrar um jogo primeiro ;)", "Erro no Jogo!"));
			return null;
		}
	}

	public String jogar() {
		JogoSv service = new JogoSv();
		jogo = service.montarJogo(iranti.getId());
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Eh necessario cadastrar um jogo primeiro ;)", "Erro no Jogo!"));
		return null;
	}

	public String salvarJogo() {
		if(jogoDAO.getInstance().persist(jogo)) {
			return jogarAgora();
		} else {
			return null;
		}
	}

	public void atualizarJogo() {

	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public List<Iranti> getIrantis() {
		return irantis;
	}

	public void setIrantis(List<Iranti> irantis) {
		this.irantis = irantis;
	}

	public List<Usuario> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Usuario> jogadores) {
		this.jogadores = jogadores;
	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

	public List<Peca> getPecas() {
		return pecas;
	}

	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}
}
