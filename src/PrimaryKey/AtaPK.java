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

	private String turmaAta = null;
	private String turnoAta = null;
	private String anoAta = null;

	public void setCodigo(String turmaAta, String turnoAta, String anoAta) {
		this.turmaAta = turmaAta;
		this.turnoAta = turnoAta;
		this.anoAta = anoAta;
	}

	public String getTurmaAta() {
		return turmaAta;
	}

	public String getTurnoAta() {
		return turnoAta;
	}

	public String getAnoAta() {
		return anoAta;
	}

	public void setTurmaAta(String turmaAta) {
		this.turmaAta = turmaAta;
	}

	public void setTurnoAta(String turnoAta) {
		this.turnoAta = turnoAta;
	}

	public void setAnoAta(String anoAta) {
		this.anoAta = anoAta;
	}

	@Override
	public String toString() {
		return this.anoAta+this.turmaAta+this.turnoAta;
	}
}
