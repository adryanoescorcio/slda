package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	private static final String NOMECOLUNAPK = "aluno_codigoAluno";

	@Id
	@OneToOne
	private Aluno aluno = null;
	
	@ManyToOne
	private Caixa caixa = null;
	
	@Column(nullable=false, unique=true)
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
	public String getCodigo() {
		// TODO Auto-generated method stub
		return aluno.getCodigo();
	}

	@Override
	public void setCodigo(String codigo) {
		// TODO Auto-generated method stub
		aluno.setCodigo(codigo);
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
				"Codigo do Aluno: "+this.aluno.getCodigo()+ ", " +
				"Codigo da Caixa: "+this.caixa.getCodigo()+ ", " +
				"Codigo do Dossie: "+this.codDossie+ ", " +
				"Data de Entrada do Arquivo: "+this.datadeEntradaArquivo+ ", " +
				"";
	}
	
}
