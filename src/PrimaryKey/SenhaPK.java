package PrimaryKey;

import javax.persistence.Embeddable;

@Embeddable
public class SenhaPK implements InterfaceKey {

	private String pass;

	public String getCodigo() {
		return pass;
	}

	public void setCodigo(final String codigo) {
		this.pass = codigo;
	}

	@Override
	public String toString() {
		return pass;
	}

}
