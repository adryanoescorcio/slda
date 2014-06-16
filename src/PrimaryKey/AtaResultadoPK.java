package PrimaryKey;

import javax.persistence.Embeddable;

/**
 * Classe concreta referente a Chave Primária da Entidade AtaResultado do BD.
 * 
 * @author Adryano Escorcio
 * @version 1.0
 * @implements InterfaceKey
 **/
@Embeddable
public class AtaResultadoPK implements InterfaceKey {

	private String aluno = null;
	private String turmaAta = null;
	private String turnoAta = null;
	private String anoAta = null;

	public String getAluno() {
		return aluno;
	}

	public String getAnoAta() {
		return anoAta;
	}

	public String getTurmaAta() {
		return turmaAta;
	}

	public String getTurnoAta() {
		return turnoAta;
	}

	public void setAluno(final String aluno) {
		this.aluno = aluno;
	}

	public void setAnoAta(final String anoAta) {
		this.anoAta = anoAta;
	}

	public void setCodigo(final String aluno, final String turmaAta,
			final String turnoAta, final String anoAta) {
		this.aluno = aluno;
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
		return this.anoAta + this.turmaAta + this.turnoAta + this.aluno;
	}
}
