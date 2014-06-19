package PrimaryKey;

import javax.persistence.Embeddable;

@Embeddable
public class SequenceCodePK implements InterfaceKey {

	private String code;

	public String getCodigo() {
		return code;
	}

	public void setCodigo(String codigo) {
		this.code = codigo;
	}

	@Override
	public String toString() {
		return code;
	}
	
}
