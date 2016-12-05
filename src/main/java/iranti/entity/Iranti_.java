package iranti.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-12-04T22:19:18.166-0200")
@StaticMetamodel(Iranti.class)
public class Iranti_ {
	public static volatile SingularAttribute<Iranti, Integer> id;
	public static volatile SingularAttribute<Iranti, String> nome;
	public static volatile SingularAttribute<Iranti, String> descricao;
	public static volatile SingularAttribute<Iranti, Date> dataCriacao;
	public static volatile SingularAttribute<Iranti, Date> ultimaModificacao;
	public static volatile ListAttribute<Iranti, Peca> pecas;
	public static volatile SingularAttribute<Iranti, Usuario> user;
}
