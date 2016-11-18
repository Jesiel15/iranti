package iranti.entity;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Administrador extends Jogador implements Serializable{

	private static final long serialVersionUID = 1L;

	public Administrador() {
		super();
	}
	
	public boolean isAdmin() {
		return true;
	}
	
	public boolean crudUsuario() {
		return true;
	}
	
	public boolean crudIranti() {
		return true;
	}
	
}
