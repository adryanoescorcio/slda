package Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

import PrimaryKey.CaixaPK;
import PrimaryKey.InterfaceKey;

/**
 * Classe concreta referente a Entidade Caixa do BD.
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @implements PadraoEntidade
 **/

@NamedQuery(name="Caixa.findAll", query="SELECT c FROM Caixa c")
@Entity
public class Caixa implements InterfacePadraoEntidade{

	@Transient
	private static final String NOMETABLE = "caixa";
	@Transient
	private static final String NOMECOLUNAPK = "codCaixa";

	@EmbeddedId
	private CaixaPK caixapk = new CaixaPK();
	private String status;
	private String turno;
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getTurno() {
		return turno;
	}
	
	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	public String getCodigo() {
		return this.caixapk.toString();
	}
	
	public void setCodigo(String codigo) {
		this.caixapk.setCodigo(codigo);
	}
	
	@Override
	public String getNomeTabelaBD() {
		return NOMETABLE;
	}
	
	@Override
	public String getNomeColunaPKBD() {
		return NOMECOLUNAPK;
	}
	
	@Override
	public String toString() {
		return "" +
				"Codigo: "+this.caixapk.toString()+ ", " +
				"Status: "+this.status+ ", " +
				"Turno: "+this.turno+ ", " +
				"";
	}

	@Override
	public InterfaceKey getCodigoKEY() {
		return this.caixapk;
	}

	@Override
	public void setCodigoKEY(InterfaceKey chaveEntidade) {
		this.caixapk = (CaixaPK) chaveEntidade;
	}
	
}