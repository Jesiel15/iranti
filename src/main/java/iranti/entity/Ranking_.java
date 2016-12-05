package iranti.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-12-04T22:19:18.212-0200")
@StaticMetamodel(Ranking.class)
public class Ranking_ {
	public static volatile SingularAttribute<Ranking, Integer> id;
	public static volatile SingularAttribute<Ranking, Double> segundos;
	public static volatile SingularAttribute<Ranking, Jogo> jogo;
	public static volatile SingularAttribute<Ranking, Iranti> iranti;
	public static volatile SingularAttribute<Ranking, Usuario> user;
}
