package Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import PrimaryKey.InterfaceKey;
import PrimaryKey.SequenceCodePK;

@Entity 
public class SequenceCode implements InterfacePadraoEntidade {

	@EmbeddedId
	private SequenceCodePK code = new SequenceCodePK();
	private int valor = 0;

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getCode() {
		return code.getCodigo();
	}

	public void setCode(String code) {
		this.code.setCodigo(code);
	}

	@Override
	public InterfaceKey getCodigoKEY() {
		return code;
	}

	@Override
	public void setCodigoKEY(InterfaceKey chaveEntidade) {
		code = (SequenceCodePK) chaveEntidade;
		
	}

}
