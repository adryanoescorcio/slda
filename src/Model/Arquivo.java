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
 * @version 1.5
 * @implements PadraoEntidade
 **/

@Entity
public class Arquivo implements InterfacePadraoEntidade{
	
	@Transient
	private static final String NOMETABLE = "arquivo";
	@Transient
	private static final String NOMECOLUNAPK = "aluno_codigoaluno";
	
	@EmbeddedId
	private ArquivoPK arquivopk = new ArquivoPK();
	
	@Transient
	private Aluno aluno = null;
	
	@Transient
	private Caixa caixa = null;
	
	private String codDossie = null;
	private String datadeEntradaArquivo = null;
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
		this.arquivopk.setCodigoAluno(aluno.getCodigo());
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
		this.arquivopk.setCodigoCaixa(caixa.getCodigo());
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
			"Aluno: "+this.aluno.getCodigo()+ ", " +
			"Caixa: "+this.caixa.getCodigo()+ ", " +
			"Codigo: "+this.codDossie+ ", " +
			"Entrada: "+this.datadeEntradaArquivo+ ", " +
			"";
	}
	
	public String getCodigo() {
		return this.aluno.getCodigo();
	}
	
	public void setCodigo(String codigo) {
		this.aluno.setCodigo(codigo);
	}

	/**
	 * Não Implementado para esta classe
	 **/
	@Override
	public InterfaceKey getCodigoKEY() {
		return this.arquivopk;
	}

	/**
	 * Não Implementado para esta classe
	 **/
	@Override
	public void setCodigoKEY(InterfaceKey chaveEntidade) {
		this.arquivopk = (ArquivoPK) chaveEntidade;
	}
	
}


