package PrimaryKey;

import javax.persistence.Embeddable;

@Embeddable
public class CaixaPK implements InterfaceKey {

	private String codigo = null;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
		return codigo;
	}
}
