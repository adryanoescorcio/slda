package PrimaryKey;

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

	private String codigoAluno = null;

	/**
	 * Metodo que insere o valor da Chave Primaria
	 **/
	public void setCodigoAluno(String codigo) {
		this.codigoAluno = codigo;
	}

	public String getCodigoAluno() {
		return this.codigoAluno;
	}

	@Override
	public String toString() {
		return codigoAluno;
	}
}