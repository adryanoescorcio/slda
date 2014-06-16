package Model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import PrimaryKey.DocumentoPK;
import PrimaryKey.InterfaceKey;

/**
 * Classe concreta referente a Entidade Documento do BD.
 * 
 * @author Adryano Escorcio
 * @version 1.5
 * @implements PadraoEntidade
 **/

@NamedQuery(name = "Documento.findByAluno", query = "SELECT d FROM Documento d where d.aluno = :aluno")
@Entity
public class Documento implements InterfacePadraoEntidade {

	@EmbeddedId
	private DocumentoPK documentopk = new DocumentoPK();
	private String nomeDocumento = null;
	@Column(length = 100)
	private String descricao = null;
	private String dataPedido = null;
	private String dataEntrega = null;
	private String status = null;

	@ManyToOne
	private Aluno aluno = null;

	public Aluno getAluno() {
		return aluno;
	}

	public String getCodigo() {
		return documentopk.getCodigo();
	}

	@Override
	public InterfaceKey getCodigoKEY() {
		return this.documentopk;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public String getDataPedido() {
		return dataPedido;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getNomeDocumento() {
		return nomeDocumento;
	}

	public String getStatus() {
		return status;
	}

	public void setAluno(final Aluno string) {
		this.aluno = string;
	}

	public void setCodigo(final String codigo) {
		this.documentopk.setCodigo(codigo);
	}

	@Override
	public void setCodigoKEY(final InterfaceKey chaveEntidade) {
		this.documentopk = (DocumentoPK) chaveEntidade;
	}

	public void setDataEntrega(final String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public void setDataPedido(final String dataPedido) {
		this.dataPedido = dataPedido;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	public void setNomeDocumento(final String nomeDocumento) {
		this.nomeDocumento = nomeDocumento;
	}

	public void setStatus(final String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return Messages.getString("Documento.0") + Messages.getString("Documento.1") + this.getCodigo() + Messages.getString("Documento.2") + Messages.getString("Documento.3") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ this.getAluno().toString() + Messages.getString("Documento.4") + Messages.getString("Documento.5") //$NON-NLS-1$ //$NON-NLS-2$
				+ this.nomeDocumento + Messages.getString("Documento.6") + Messages.getString("Documento.7") + this.descricao //$NON-NLS-1$ //$NON-NLS-2$
				+ Messages.getString("Documento.8") + Messages.getString("Documento.9") + this.dataEntrega + Messages.getString("Documento.10") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ Messages.getString("Documento.11") + this.dataPedido + Messages.getString("Documento.12") + Messages.getString("Documento.13") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ this.status + Messages.getString("Documento.14") + Messages.getString("Documento.15"); //$NON-NLS-1$ //$NON-NLS-2$
	}
}
