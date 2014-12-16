package Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

import PrimaryKey.AtaResultadoPK;
import PrimaryKey.InterfaceKey;

/**
 * Classe concreta referente a Entidade AtaResultado do BD.
 * 
 * @author Adryano Escorcio
 * @version 1.8
 * @implements PadraoEntidade
 **/

@NamedQueries({
	@NamedQuery(name = "AtaResultado.findByAluno", query = "SELECT a FROM AtaResultado a where a.atapk.aluno = :aluno"),
	@NamedQuery(name = "AtaResultado.findByTurma", query = "SELECT a FROM AtaResultado a WHERE a.atapk.turmaAta LIKE :turmaata AND a.atapk.anoAta LIKE :anoata")
})
@Entity
public class AtaResultado implements InterfacePadraoEntidade,
		InterfacePadraoAta {

	@EmbeddedId
	private AtaResultadoPK atapk = new AtaResultadoPK();

	private String modalidadeAta = null;
	private String ensinoAta = null;

	@Transient
	private String nomeAluno = Messages.getString("AtaResultado.0"); //$NON-NLS-1$

	@Override
	public boolean equals(final Object obj) {
		return atapk.equals(obj);
	}

	public String getAluno() {
		return atapk.getAluno();
	}

	@Override
	public String getAnoAta() {
		return atapk.getAnoAta();
	}

	public Ata getAta() {
		final Ata ata = new Ata();

		ata.setAnoAta(atapk.getAnoAta());
		ata.setModalidadeAta(modalidadeAta);
		ata.setEnsinoAta(ensinoAta);
		ata.setTurmaAta(atapk.getTurmaAta());
		ata.setTurnoAta(atapk.getTurnoAta());

		return ata;
	}

	public AtaResultadoPK getAtapk() {
		return atapk;
	}

	@Override
	public InterfaceKey getCodigoKEY() {
		return atapk;
	}

	@Override
	public String getEnsinoAta() {
		return ensinoAta;
	}

	@Override
	public String getModalidadeAta() {
		return modalidadeAta;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	@Override
	public String getTurmaAta() {
		return atapk.getTurmaAta();
	}

	@Override
	public String getTurnoAta() {
		return atapk.getTurnoAta();
	}

	@Override
	public int hashCode() {
		return atapk.hashCode();
	}

	public void setAluno(final String aluno) {
		atapk.setAluno(aluno);
	}

	@Override
	public void setAnoAta(final String anoAta) {
		atapk.setAnoAta(anoAta);
	}

	public void setAta(final Ata ata) {
		this.setEnsinoAta(ata.getEnsinoAta());
		this.setModalidadeAta(ata.getModalidadeAta());
		this.setTurmaAta(ata.getTurmaAta());
		this.setTurnoAta(ata.getTurnoAta());
		this.setAnoAta(ata.getAnoAta());
	}

	public void setAtapk(final AtaResultadoPK atapk) {
		this.atapk = atapk;
	}

	public void setCodigo(final String aluno, final String turnoAta,
			final String turmaAta, final String anoAta) {
		atapk.setCodigo(aluno, turmaAta, turnoAta, anoAta);
	}

	@Override
	public void setCodigoKEY(final InterfaceKey chaveEntidade) {
		this.atapk = (AtaResultadoPK) chaveEntidade;
	}

	@Override
	public void setEnsinoAta(final String ensinoAta) {
		this.ensinoAta = ensinoAta;
	}

	@Override
	public void setModalidadeAta(final String modalidadeAta) {
		this.modalidadeAta = modalidadeAta;
	}

	public void setNomeAluno(final String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	@Override
	public void setTurmaAta(final String turmaAta) {
		atapk.setTurmaAta(turmaAta);
	}

	@Override
	public void setTurnoAta(final String turnoAta) {
		atapk.setTurnoAta(turnoAta);
	}

	@Override
	public String toString() {
		return Messages.getString("AtaResultado.1") + Messages.getString("AtaResultado.2") + this.atapk.getTurmaAta() + Messages.getString("AtaResultado.3") + Messages.getString("AtaResultado.4") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ this.atapk.getAnoAta() + Messages.getString("AtaResultado.5") + Messages.getString("AtaResultado.6") //$NON-NLS-1$ //$NON-NLS-2$
				+ this.atapk.getTurnoAta() + Messages.getString("AtaResultado.7") + Messages.getString("AtaResultado.8") //$NON-NLS-1$ //$NON-NLS-2$
				+ this.atapk.getAluno() + Messages.getString("AtaResultado.9") + Messages.getString("AtaResultado.10") + getEnsinoAta() //$NON-NLS-1$ //$NON-NLS-2$
				+ Messages.getString("AtaResultado.11") + Messages.getString("AtaResultado.12") + getModalidadeAta() + Messages.getString("AtaResultado.13") + Messages.getString("AtaResultado.14"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}
}
