package iranti.model.service;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Classe para as configuracoes de cada maquina
 *
 */
@ManagedBean
@SessionScoped
public class Config {
	private String dataRoot; //endereco do site
	private String irantiData; //local das imagens salvas
	
	public Config() {
		dataRoot = "http://localhost:8080/iranti";
		irantiData = "/data";
	}

	public String getDataRoot() {
		return dataRoot;
	}

	public void setDataRoot(String dataRoot) {
		this.dataRoot = dataRoot;
	}

	public String getIrantiData() {
		return irantiData;
	}

	public void setIrantiData(String irantiData) {
		this.irantiData = irantiData;
	}
}
