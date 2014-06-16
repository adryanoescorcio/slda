package PrimaryKey;

import javax.persistence.Embeddable;

/**
 * Classe concreta referente a Chave Primária da Entidade Documento do BD.
 * 
 * @author Adryano Escorcio
 * @version 1.0
 * @implements InterfaceKey
 **/
@Embeddable
public class DocumentoPK implements InterfaceKey {

	private String protocoloPedidoDocumento = null;

	public String getCodigo() {
		return protocoloPedidoDocumento;
	}

	public void setCodigo(final String codigo) {
		this.protocoloPedidoDocumento = codigo;
	}

	@Override
	public String toString() {
		return this.protocoloPedidoDocumento;
	}

}
