package PrimaryKey;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ArquivoPK implements InterfaceKey {
	
	@Column (unique = true)
	private String codigoAluno = null;
	private String codigoCaixa = null;

	public String getCodigoCaixa() {
		return codigoCaixa;
	}
	
	public void setCodigoCaixa(String codigoCaixa) {
		this.codigoCaixa = codigoCaixa;
	}
	
	public void setCodigoAluno(String codigo) {
		this.codigoAluno = codigo;
	}
	
	public String getCodigoAluno() {
		return codigoAluno;
	}
	
	@Override
	public String toString() {
		return codigoAluno;
	}
}
