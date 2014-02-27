package PrimaryKey;

import javax.persistence.Embeddable;

@Embeddable
public class DocumentoPK implements InterfaceKey{
	
	private String protocoloPedidoDocumento = null;
	
	public void setCodigo(String codigo) {
		this.protocoloPedidoDocumento = codigo;
	}
	
	@Override
	public String toString() {
		return this.protocoloPedidoDocumento;
	}

}
