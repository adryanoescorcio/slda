package Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import PrimaryKey.ArquivoPK;
import PrimaryKey.InterfaceKey;

/**
 * Classe concreta referente a Entidade Arquivo do BD.
 * 
 * @author Walysson Oliveira
 * @version 1.8
 * @implements PadraoEntidade
 **/


@Entity
public class Arquivo implements InterfacePadraoEntidade{
	
	@Transient
	private static final String NOMETABLE = "arquivo";
	@Transient
	private static final String NOMECOLUNAPK = "aluno_codigoaluno";
	@Transient
	private Aluno aluno = null;
	@Transient
	private Caixa caixa = null;
	
	@EmbeddedId
	private ArquivoPK arquivopk = new ArquivoPK();
	
	private String codDossie = null;
	private String datadeEntradaArquivo = null;
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setCodigo(Aluno aluno, Caixa caixa) {
		this.aluno = aluno;
		this.caixa = caixa;
		this.arquivopk.setCodigo(caixa.getCodigo(), aluno.getCodigo());
	}
	
	public void setCodigo(String aluno, String caixa) {
		this.arquivopk.setCodigo(aluno, aluno);
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}
	
	public Caixa getCaixa() {
		return caixa;
	}

	public String getCodDossie() {
		return codDossie;
	}

	public void setCodDossie(String codDossie) {
		this.codDossie = codDossie;
	}

	public String getDatadeEntradaArquivo() {
		return datadeEntradaArquivo;
	}

	public void setDatadeEntradaArquivo(String datadeEntradaArquivo) {
		this.datadeEntradaArquivo = datadeEntradaArquivo;
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
			"Aluno: "+this.arquivopk.getCodigoAluno()+ ", " +
			"Caixa: "+this.arquivopk.getCodigoCaixa()+ ", " +
			"Codigo: "+this.codDossie+ ", " +
			"Entrada: "+this.datadeEntradaArquivo+ ", " +
			"";
	}
	
	
	
	public String getCodigoCaixa() {
		return (String) arquivopk.getCodigoCaixa();
	}

	public String getCodigoAluno() {
		return arquivopk.getCodigoAluno();
	}

	public String getCodigo() {
		return this.arquivopk.getCodigoAluno();
	}
	
	@Override
	public InterfaceKey getCodigoKEY() {
		return (ArquivoPK) this.arquivopk;
	}

	@Override
	public void setCodigoKEY(InterfaceKey chaveEntidade) {
		this.arquivopk = (ArquivoPK) chaveEntidade;
	}
}
