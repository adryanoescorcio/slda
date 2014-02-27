package PrimaryKey;

import javax.persistence.Embeddable;

@Embeddable
public class AtaResultadoPK implements InterfaceKey {
	
	private String aluno = null;
	private String turmaAta = null;
	private String turnoAta = null;
	private String anoAta = null;
	
	public String getAluno() {
		return aluno;
	}
	
	public void setAluno(String aluno) {
		this.aluno = aluno;
	}
	
	public String getTurmaAta() {
		return turmaAta;
	}
	
	public void setTurmaAta(String turmaAta) {
		this.turmaAta = turmaAta;
	}
	
	public String getTurnoAta() {
		return turnoAta;
	}
	
	public void setTurnoAta(String turnoAta) {
		this.turnoAta = turnoAta;
	}
	
	public String getAnoAta() {
		return anoAta;
	}
	
	public void setAnoAta(String anoAta) {
		this.anoAta = anoAta;
	}
	
	public String toString() {
		return this.anoAta+this.turmaAta+this.turnoAta+this.aluno;
	}
}
