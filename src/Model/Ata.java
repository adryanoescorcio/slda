package Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Ata implements PadraoEntidade, Serializable{

	private static final long serialVersionUID = -5403084140557561137L;

	@Transient
	private static final String NOMETABLE = "ata";
	@Transient
	private static final String NOMECOLUNAPK = "turmaAta; anoAta; turnoAta";
	
	@Id
	private String ataCodigo;
	@Embedded
	private AtaPK atapk;
	@Column
	private String modalidadeAta;
	@Column
	private String ensinoAta;
	
	public AtaPK getAtapk() {
		return atapk;
	}

	public void setAtapk(AtaPK atapk) {
		this.atapk = atapk;
	}
	
	public String getModalidadeAta() {
		return modalidadeAta;
	}

	public void setModalidadeAta(String modalidadeAta) {
		this.modalidadeAta = modalidadeAta;
	}

	public String getEnsinoAta() {
		return ensinoAta;
	}

	public void setEnsinoAta(String ensinoAta) {
		this.ensinoAta = ensinoAta;
	}

	@Override
	public String getCodigo() {
		// TODO Auto-generated method stub
		return ataCodigo;
	}

	@Override
	public void setCodigo(String codigo) {
		this.ataCodigo = codigo;
	}

	@Override
	public String getNomeTabelaBD() {
		// TODO Auto-generated method stub
		return NOMETABLE;
	}

	@Override
	public String getNomeColunaPKBD() {
		// TODO Auto-generated method stub
		return NOMECOLUNAPK;
	}
	
	@Override
	public String toString() {
		return "" +
				"Turma: "+this.atapk.getTurmaAta()+ ", " +
				"Ano: "+this.atapk.getAnoAta()+ ", " +
				"Turno: "+this.atapk.getTurnoAta()+ ", " +
				"Modalidade de Ensino: "+this.modalidadeAta+ ", " +
				"Nivel de Ensino: "+this.ensinoAta+ ", " +
				"";
	}
}
