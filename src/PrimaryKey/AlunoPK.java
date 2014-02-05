package PrimaryKey;

import javax.persistence.Embeddable;

@Embeddable
public class AlunoPK implements Key {
	
	private String codigoAluno = null;
	
	@Override
	public Key getCodigo() {
		return null;
	}

	public void setCodigo(String codigo) {
		this.codigoAluno = codigo;
	}
	
	@Override
	public String toString() {
		return codigoAluno;
	}

}
