package iranti.model.service;

import iranti.entity.Iranti;
import iranti.entity.Jogo;
import iranti.entity.Peca;
import iranti.entity.Usuario;
import iranti.model.dao.IrantiDAO;
import iranti.model.dao.JogoDAO;
import iranti.model.dao.PecaDAO;
import iranti.model.dao.UsuarioDAO;

import java.util.Collections;
import java.util.List;

public class JogoSv {
    private IrantiDAO irantiDAO;
    private PecaDAO pecaDAO;
    private UsuarioDAO dono;

    public Jogo montarJogo(int iranti_id) {
        Jogo jogo = new Jogo();
        Iranti iranti = irantiDAO.getInstance().getById(iranti_id);
        List<Peca> pecas = pecaDAO.getInstance().findByIrantiId(iranti_id);
        duplicarPecas(pecas); //cria o par
        sortPecas(pecas); //bagunca os pares
        jogo.setCriador(dono.getInstance().getById(1)); //set criador
        return jogo;
    }

    /**
     * Duplica a lista e cria os pares
     * @param pecas
     * @return
     */
    private List<Peca> duplicarPecas(List<Peca> pecas) {
        pecas.addAll(pecas);
        return pecas;
    }

    /**
     * Embaralhar a lista
     * @param pecas
     * @return
     */
    private List<Peca> sortPecas(List<Peca> pecas) {
        Collections.shuffle(pecas);
        Collections.shuffle(pecas);
        return pecas;
    }
}
