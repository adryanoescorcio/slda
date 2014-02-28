package PrimaryKey;

import javax.persistence.Embeddable;

/**
 * Classe concreta referente a Chave Primária da Entidade Aluno do BD.
 * 
 * @author Adryano Escorcio
 * @version 1.0
 * @implements InterfaceKey
 **/
@Embeddable
public class AlunoPK implements InterfaceKey {
	
	private String codigoAluno = null;

	/**
	 * Metodo que insere o valor da Chave Primaria
	 **/
	public void setCodigo(String codigo) {
		this.codigoAluno = codigo;
	}
	
	@Override
	public String toString() {
		return codigoAluno;
	}
}
