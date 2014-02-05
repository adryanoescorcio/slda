package Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * Classe concreta referente a Entidade Arquivo do BD.
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @implements PadraoEntidade
 **/

@Entity
public class Arquivo implements PadraoEntidade{
	
	@Transient
	private static final String NOMETABLE = "arquivo";
	@Transient
	private static final String NOMECOLUNAPK = "aluno_codigoaluno";
	
	@Id
	@ManyToOne
	private Aluno aluno;
	
	@ManyToOne
	private Caixa caixa;
	
	private String codDossie = null;
	private String datadeEntradaArquivo = null;
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
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

	@Override
	public String getCodigo() {
		return this.aluno.getCodigo();
	}

	@Override
	public void setCodigo(String codigo) {
		this.aluno.setCodigo(codigo);
	}
	
}


