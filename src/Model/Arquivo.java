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
	private Aluno aluno = null;
	@Transient
	private Caixa caixa = null;

	@EmbeddedId
	private ArquivoPK arquivopk = new ArquivoPK();

	private String codigoCaixa;

	private String codDossie = null;
	private String datadeEntradaArquivo = null;

	public Aluno getAluno() {
		return aluno;
	}

	public void setCodigo(Aluno aluno, Caixa caixa) {
		this.arquivopk.setCodigoAluno(aluno.getCodigo());
		this.codigoCaixa = caixa.getCodigo();
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public void setArquivo (Arquivo arquivo) {
		this.arquivopk.setCodigoAluno(arquivopk.getCodigoAluno());
		this.setCodigoCaixa(arquivo.getCodigoCaixa());
		this.setCodigoAluno(arquivo.getCodigoAluno());
		this.setDatadeEntradaArquivo(arquivo.getDatadeEntradaArquivo());
		this.setCodDossie(arquivo.getCodDossie());
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
	public String toString() {
		return "" +
				"Aluno: "+this.getCodigoAluno()+ ", " +
				"Caixa: "+this.getCodigoCaixa()+ ", " +
				"Codigo: "+this.codDossie+ ", " +
				"Entrada: "+this.datadeEntradaArquivo+ ", " +
				"";
	}

	@Override
	public InterfaceKey getCodigoKEY() {
		return (ArquivoPK) this.arquivopk;
	}

	@Override
	public void setCodigoKEY(InterfaceKey chaveEntidade) {
		this.arquivopk = (ArquivoPK) chaveEntidade;
	}

	public String getCodigoCaixa() {
		return codigoCaixa;
	}

	public void setCodigo(String codigoAluno, String codigoCaixa) {
		this.codigoCaixa = codigoCaixa;
		this.arquivopk.setCodigoAluno(codigoAluno);
	}

	public String getCodigoAluno() {
		return arquivopk.getCodigoAluno();
	}

	public void setCodigoAluno(String codigoAluno) {
		this.arquivopk.setCodigoAluno(codigoAluno);
	}

	public void setCodigoCaixa(String caixa) {
		this.codigoCaixa = caixa;
	}
}
