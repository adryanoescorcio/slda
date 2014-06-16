package PrimaryKey;

import javax.persistence.Embeddable;

/**
 * Classe concreta referente a Chave Prim�ria da Entidade Caixa do BD.
 * 
 * @author Adryano Escorcio
 * @version 1.0
 * @implements InterfaceKey
 **/
@Embeddable
public class CaixaPK implements InterfaceKey {

	private String codigo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(final String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return codigo;
	}
}
