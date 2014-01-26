package Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import DAO.CaixaDAO;

/**
 * Classe concreta referente a Entidade Caixa do BD.
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @implements PadraoEntidade
 **/

@Entity
public class Caixa implements PadraoEntidade {

	@Transient
	private static final String NOMETABLE = "caixa";
	@Transient
	private static final String NOMECOLUNAPK = "codCaixa";
	@Transient
	private CaixaDAO dao = null;
	
	@Id
	private String codCaixa = null;
	private String status = null;
	private String turno = null;
	
	
	@Override
	public String getCodigo() {
		// TODO Auto-generated method stub
		return codCaixa;
	}

	@Override
	public void setCodigo(String codigo) {
		this.codCaixa = codigo;		
	}

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
	public String toString() throws NullPointerException {
		return "" +
				"codCaixa= "+this.codCaixa+ ", " +
				"status= "+this.status+ ", " +
				"turno= "+this.turno + ", " +
				"";
	}
		
}