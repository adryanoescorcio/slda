package Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

import PrimaryKey.AtaPK;
import PrimaryKey.InterfaceKey;

@NamedQuery(name="Ata.findAll", query="SELECT a FROM Ata a")
@Entity
public class Ata implements InterfacePadraoEntidade {

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
	public void setCodigo(String turnoAta, String turmaAta, String anoAta) {
		this.ata.setTurnoAta(turnoAta);
		this.ata.setAnoAta(anoAta);
		this.ata.setTurmaAta(turmaAta);
	}
	
	@Override
	public InterfaceKey getCodigoKEY() {
		return this.ata;
	}

	@Override
	public void setCodigoKEY(InterfaceKey chaveEntidade) {
		this.ata = (AtaPK) chaveEntidade;
	}
}
