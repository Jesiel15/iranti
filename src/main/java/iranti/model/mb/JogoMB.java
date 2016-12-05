package iranti.model.mb;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

import iranti.entity.Iranti;
import iranti.entity.Jogo;
import iranti.entity.Usuario;
import iranti.entity.enums.Dificuldade;
import iranti.model.dao.IrantiDAO;
import iranti.model.dao.JogoDAO;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class JogoMB {

    private Jogo jogo;
    private JogoDAO jogoDao;
    private List<Jogo> jogos = new ArrayList<Jogo>();
    private List<Iranti> irantis = new ArrayList<Iranti>();
    private IrantiDAO irantiDAO;
    
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
    		return "erro, deu ruim! Cadastre um Iranti primeiro ;)";
    	}        
    }
    
    public Dificuldade[] getDificuldade() {
    	return Dificuldade.values();
    }

    public String editarJogo() {
        return "editar";
    }

    public String jogarAgora() {
        return "play";
    }
    
    public String salvarJogo() {
    	return "";

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

	public JogoDAO getJogoDao() {
		return jogoDao;
	}

	public void setJogoDao(JogoDAO jogoDao) {
		this.jogoDao = jogoDao;
	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

	public IrantiDAO getIrantiDAO() {
		return irantiDAO;
	}

	public void setIrantiDAO(IrantiDAO irantiDAO) {
		this.irantiDAO = irantiDAO;
	}
}
