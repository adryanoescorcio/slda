package PrimaryKey;

import javax.persistence.Embeddable;

@Embeddable
public class AlunoPK implements InterfaceKey {
	
	private String codigoAluno = null;

	public void setCodigo(String codigo) {
		this.codigoAluno = codigo;
	}
	
	@Override
	public String toString() {
		return codigoAluno;
	}

}
