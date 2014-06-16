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

	public String getCodigoAluno() {
		return this.codigoAluno;
	}

	/**
	 * Metodo que insere o valor da Chave Primaria
	 **/
	public void setCodigoAluno(final String codigo) {
		this.codigoAluno = codigo;
	}

	@Override
	public String toString() {
		return codigoAluno;
	}
}