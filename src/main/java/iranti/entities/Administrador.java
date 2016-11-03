package iranti.entities;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;

@ManagedBean
@Entity
public class Administrador extends Jogador{
	public Administrador() {
		// TODO Auto-generated constructor stub
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
