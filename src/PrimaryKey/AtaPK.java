package PrimaryKey;

import javax.persistence.Embeddable;

/**
 * Classe concreta referente a Chave Primária da Entidade Ata do BD.
 * 
 * @author Adryano Escorcio
 * @version 1.0
 * @implements InterfaceKey
 **/
@Embeddable
public class AtaPK implements InterfaceKey {

	private String turmaAta;
	private String turnoAta;
	private String anoAta;

	public String getAnoAta() {
		return anoAta;
	}

	public String getTurmaAta() {
		return turmaAta;
	}

	public String getTurnoAta() {
		return turnoAta;
	}

	public void setAnoAta(final String anoAta) {
		this.anoAta = anoAta;
	}

	public void setCodigo(final String turmaAta, final String turnoAta,
			final String anoAta) {
		this.turmaAta = turmaAta;
		this.turnoAta = turnoAta;
		this.anoAta = anoAta;
	}

	public void setTurmaAta(final String turmaAta) {
		this.turmaAta = turmaAta;
	}

	public void setTurnoAta(final String turnoAta) {
		this.turnoAta = turnoAta;
	}

	@Override
	public String toString() {
		return this.anoAta + this.turmaAta + this.turnoAta;
	}
}
