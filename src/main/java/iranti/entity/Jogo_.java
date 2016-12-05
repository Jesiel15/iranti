package iranti.entity;

import iranti.entity.enums.Dificuldade;
import iranti.entity.enums.Status;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-12-04T22:19:18.191-0200")
@StaticMetamodel(Jogo.class)
public class Jogo_ {
	public static volatile SingularAttribute<Jogo, Integer> id;
	public static volatile SingularAttribute<Jogo, Date> inicio;
	public static volatile SingularAttribute<Jogo, Date> fim;
	public static volatile SingularAttribute<Jogo, Status> status;
	public static volatile SingularAttribute<Jogo, Dificuldade> dificuldade;
	public static volatile ListAttribute<Jogo, Usuario> jogadores;
	public static volatile SingularAttribute<Jogo, Iranti> iranti;
	public static volatile SingularAttribute<Jogo, Usuario> criador;
}
