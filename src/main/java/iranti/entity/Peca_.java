package iranti.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-12-04T22:19:18.202-0200")
@StaticMetamodel(Peca.class)
public class Peca_ {
	public static volatile SingularAttribute<Peca, Integer> id;
	public static volatile SingularAttribute<Peca, Date> dataCriacao;
	public static volatile SingularAttribute<Peca, Date> ultimaModificacao;
	public static volatile SingularAttribute<Peca, String> local;
	public static volatile SingularAttribute<Peca, Iranti> iranti;
}
