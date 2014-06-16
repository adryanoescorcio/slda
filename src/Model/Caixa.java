package Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import PrimaryKey.CaixaPK;
import PrimaryKey.InterfaceKey;

/**
 * Classe concreta referente a Entidade Caixa do BD.
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @implements PadraoEntidade
 **/

@NamedQuery(name = "Caixa.findAllC", query = "SELECT c FROM Caixa c")
@Entity
public class Caixa implements InterfacePadraoEntidade {

	@EmbeddedId
	private CaixaPK caixapk = new CaixaPK();

	private String status;
	private String turno;
	private String letra;
	private String modalidadeAta = null;
	private String ensinoAta = null;

	public String getCodigo() {
		return this.caixapk.toString();
	}

	@Override
	public CaixaPK getCodigoKEY() {
		return this.caixapk;
	}

	public String getEnsinoAta() {
		return ensinoAta;
	}

	public String getLetra() {
		return this.letra;
	}

	public String getModalidadeAta() {
		return modalidadeAta;
	}

	public String getStatus() {
		return status;
	}

	public String getTurno() {
		return turno;
	}

	public void setCodigo(final String codigo) {
		this.caixapk.setCodigo(codigo);
	}

	@Override
	public void setCodigoKEY(final InterfaceKey chaveEntidade) {
		this.caixapk = (CaixaPK) chaveEntidade;
	}

	public void setEnsinoAta(final String ensinoAta) {
		this.ensinoAta = ensinoAta;
	}

	public void setLetra(final String string) {
		this.letra = string;
	}

	public void setModalidadeAta(final String modalidadeAta) {
		this.modalidadeAta = modalidadeAta;
	}

	public void setStatus(final String status) {
		this.status = status;
	}

	public void setTurno(final String turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return Messages.getString("Caixa.0") + Messages.getString("Caixa.1") + this.caixapk.toString() + Messages.getString("Caixa.2") + Messages.getString("Caixa.3") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ this.status + Messages.getString("Caixa.4") + Messages.getString("Caixa.5") + this.turno + Messages.getString("Caixa.6") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ Messages.getString("Caixa.7") + this.letra + Messages.getString("Caixa.8"); //$NON-NLS-1$ //$NON-NLS-2$
	}

}
