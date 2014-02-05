package Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Ata implements PadraoEntidade {

	@Transient
	private static final String NOMETABLE = "ata";
	@Transient
	private static final String NOMECOLUNAPK = "turmaAta; anoAta; turnoAta";
		
	@EmbeddedId
	private AtaPK ata = new AtaPK();

	private String modalidadeAta = null;
	private String ensinoAta = null;
	
	public AtaPK getAtapk() {
		return ata;
	}
	
	public String getTurmaAta() {
		return ata.getTurmaAta();
	}

	public void setTurmaAta(String turmaAta) {
		ata.setTurmaAta(turmaAta);
	}

	public String getTurnoAta() {
		return ata.getTurnoAta();
	}

	public void setTurnoAta(String turnoAta) {
		ata.setTurnoAta(turnoAta);
	}

	public String getAnoAta() {
		return ata.getAnoAta();
	}

	public void setAnoAta(String anoAta) {
		ata.setAnoAta(anoAta);
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
	public String getNomeTabelaBD() {
		return NOMETABLE;
	}

	@Override
	public String getNomeColunaPKBD() {
		return NOMECOLUNAPK;
	}
	
	@Override
	public String toString() {
		return "" +
			"Turma: "+this.ata.getTurmaAta()+ ", " +
			"Ano: "+this.ata.getAnoAta()+ ", " +
			"Turno: "+this.ata.getTurnoAta()+ ", " +
			"Modalidade de Ensino: "+this.modalidadeAta+ ", " +
			"Nivel de Ensino: "+this.ensinoAta+ ", " +
			"";
	}

	/**
	 * Não implementada para esta Entidade que possui chave composta.
	 **/
	@Override
	public String getCodigo() {
		return null;
	}

	/**
	 * Não implementada para esta Entidade que possui chave composta.
	 **/
	@Override
	public void setCodigo(String codigo) {
		
	}
}
