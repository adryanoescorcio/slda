package Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Classe concreta referente a Entidade Caixa do BD.
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @implements PadraoEntidade
 **/

@Entity
public class Caixa implements PadraoEntidade{

	@Transient
	private static final String NOMETABLE = "caixa";
	@Transient
	private static final String NOMECOLUNAPK = "codCaixa";

	@Id
	private String codCaixa;
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
	@Override
	public String getCodigo() {
		// TODO Auto-generated method stub
		return codCaixa;
	}
	@Override
	public void setCodigo(String codigo) {
		this.codCaixa = codigo;
	}
	@Override
	public String getNomeTabelaBD() {
		// TODO Auto-generated method stub
		return NOMETABLE;
	}
	@Override
	public String getNomeColunaPKBD() {
		// TODO Auto-generated method stub
		return NOMECOLUNAPK;
	}
	
	@Override
	public String toString() {
		return "" +
				"Codigo: "+this.codCaixa+ ", " +
				"Status: "+this.status+ ", " +
				"Turno: "+this.turno+ ", " +
				"";
	}
	
}