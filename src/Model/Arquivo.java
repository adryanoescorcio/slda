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
public class Arquivo implements InterfacePadraoEntidade {

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

	public Caixa getCaixa() {
		return caixa;
	}

	public String getCodDossie() {
		return codDossie;
	}

	public String getCodigoAluno() {
		return arquivopk.getCodigoAluno();
	}

	public String getCodigoCaixa() {
		return codigoCaixa;
	}

	@Override
	public InterfaceKey getCodigoKEY() {
		return this.arquivopk;
	}

	public String getDatadeEntradaArquivo() {
		return datadeEntradaArquivo;
	}

	public void setAluno(final Aluno aluno) {
		this.aluno = aluno;
	}

	public void setArquivo(final Arquivo arquivo) {
		this.arquivopk.setCodigoAluno(arquivopk.getCodigoAluno());
		this.setCodigoCaixa(arquivo.getCodigoCaixa());
		this.setCodigoAluno(arquivo.getCodigoAluno());
		this.setDatadeEntradaArquivo(arquivo.getDatadeEntradaArquivo());
		this.setCodDossie(arquivo.getCodDossie());
	}

	public void setCaixa(final Caixa caixa) {
		this.caixa = caixa;
	}

	public void setCodDossie(final String codDossie) {
		this.codDossie = codDossie;
	}

	public void setCodigo(final Aluno aluno, final Caixa caixa) {
		this.arquivopk.setCodigoAluno(aluno.getCodigo());
		this.codigoCaixa = caixa.getCodigo();
	}

	public void setCodigo(final String codigoAluno, final String codigoCaixa) {
		this.codigoCaixa = codigoCaixa;
		this.arquivopk.setCodigoAluno(codigoAluno);
	}

	public void setCodigoAluno(final String codigoAluno) {
		this.arquivopk.setCodigoAluno(codigoAluno);
	}

	public void setCodigoCaixa(final String caixa) {
		this.codigoCaixa = caixa;
	}

	@Override
	public void setCodigoKEY(final InterfaceKey chaveEntidade) {
		this.arquivopk = (ArquivoPK) chaveEntidade;
	}

	public void setDatadeEntradaArquivo(final String datadeEntradaArquivo) {
		this.datadeEntradaArquivo = datadeEntradaArquivo;
	}

	@Override
	public String toString() {
		return Messages.getString("Arquivo.0") + Messages.getString("Arquivo.1") + this.getCodigoAluno() + Messages.getString("Arquivo.2") + Messages.getString("Arquivo.3") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ this.getCodigoCaixa() + Messages.getString("Arquivo.4") + Messages.getString("Arquivo.5") + this.codDossie //$NON-NLS-1$ //$NON-NLS-2$
				+ Messages.getString("Arquivo.6") + Messages.getString("Arquivo.7") + this.datadeEntradaArquivo + Messages.getString("Arquivo.8") + Messages.getString("Arquivo.9"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}
}
