package Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import PrimaryKey.AtaPK;
import PrimaryKey.InterfaceKey;

/**
 * Classe concreta referente a Entidade Ata do BD.
 * 
 * @author Adryano Escorcio
 * @version 1.5
 * @implements PadraoEntidade
 **/

@NamedQuery(name = "Ata.findAll", query = "SELECT a FROM Ata a")
@Entity
public class Ata implements InterfacePadraoEntidade, InterfacePadraoAta {

	@EmbeddedId
	private AtaPK ata = new AtaPK();

	private String modalidadeAta;
	private String ensinoAta;

	@Override
	public String getAnoAta() {
		return ata.getAnoAta();
	}

	public AtaPK getAtapk() {
		return ata;
	}

	@Override
	public AtaPK getCodigoKEY() {
		return this.ata;
	}

	@Override
	public String getEnsinoAta() {
		return ensinoAta;
	}

	@Override
	public String getModalidadeAta() {
		return modalidadeAta;
	}

	@Override
	public String getTurmaAta() {
		return ata.getTurmaAta();
	}

	@Override
	public String getTurnoAta() {
		return ata.getTurnoAta();
	}

	@Override
	public void setAnoAta(final String anoAta) {
		ata.setAnoAta(anoAta);
	}

	/**
	 * Não implementada para esta Entidade que possui chave composta.
	 **/
	public void setCodigo(final String turnoAta, final String turmaAta,
			final String anoAta) {
		this.ata.setCodigo(turmaAta, turnoAta, anoAta);
	}

	@Override
	public void setCodigoKEY(final InterfaceKey chaveEntidade) {
		this.ata = (AtaPK) chaveEntidade;
	}

	@Override
	public void setEnsinoAta(final String ensinoAta) {
		this.ensinoAta = ensinoAta;
	}

	@Override
	public void setModalidadeAta(final String modalidadeAta) {
		this.modalidadeAta = modalidadeAta;
	}

	@Override
	public void setTurmaAta(final String turmaAta) {
		ata.setTurmaAta(turmaAta);
	}

	@Override
	public void setTurnoAta(final String turnoAta) {
		ata.setTurnoAta(turnoAta);
	}

	@Override
	public String toString() {
		return Messages.getString("Ata.0") + Messages.getString("Ata.1") + this.ata.getTurmaAta() + Messages.getString("Ata.2") + Messages.getString("Ata.3") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ this.ata.getAnoAta() + Messages.getString("Ata.4") + Messages.getString("Ata.5") //$NON-NLS-1$ //$NON-NLS-2$
				+ this.ata.getTurnoAta() + Messages.getString("Ata.6") + Messages.getString("Ata.7") //$NON-NLS-1$ //$NON-NLS-2$
				+ this.modalidadeAta + Messages.getString("Ata.8") + Messages.getString("Ata.9") //$NON-NLS-1$ //$NON-NLS-2$
				+ this.ensinoAta + Messages.getString("Ata.10") + Messages.getString("Ata.11"); //$NON-NLS-1$ //$NON-NLS-2$
	}
}
