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
	
	public void setCodigo(String aluno, String turmaAta, String turnoAta, String anoAta) {
		this.aluno = aluno;
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
	
	public String toString() {
		return this.anoAta+this.turmaAta+this.turnoAta+this.aluno;
	}
}
