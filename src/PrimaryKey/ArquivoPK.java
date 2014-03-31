package PrimaryKey;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Classe concreta referente a Chave Primária da Entidade Arquivo do BD.
 * 
 * @author Adryano Escorcio
 * @version 1.3
 * @implements InterfaceKey
 **/
@Embeddable
public class ArquivoPK implements InterfaceKey {
	
	@Column (unique = true)
	private String codigoAluno;
	private String codigoCaixa;

	public String getCodigoCaixa() {
		return codigoCaixa;
	}
	
	public void setCodigo(String codigoCaixa, String codigoAluno) {
		this.codigoCaixa = codigoCaixa;
		this.codigoAluno = codigoAluno;
	}
	
	public String getCodigoAluno() {
		return codigoAluno;
	}
	
	@Override
	public String toString() {
		return codigoAluno;
	}
}
