package Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
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
@NamedQueries({
	@NamedQuery(name="Ata.findAll", query="SELECT a FROM Ata a"),
	@NamedQuery(name="Ata.findByYear", query="SELECT a FROM Ata a where a.ata.anoAta = :ano ORDER BY a.ata.turmaAta")
})
@Entity
public class Ata implements InterfacePadraoEntidade, InterfacePadraoAta {

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

	public String getTurnoAta() {
		return ata.getTurnoAta();
	}

	public String getAnoAta() {
		return ata.getAnoAta();
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
		this.ata.setCodigo(turmaAta, turnoAta, anoAta);
	}

	@Override
	public AtaPK getCodigoKEY() {
		return this.ata;
	}

	@Override
	public void setCodigoKEY(InterfaceKey chaveEntidade) {
		this.ata = (AtaPK) chaveEntidade;
	}

	@Override
	public void setTurmaAta(String turmaAta) {
		ata.setTurmaAta(turmaAta);
	}

	@Override
	public void setTurnoAta(String turnoAta) {
		ata.setTurnoAta(turnoAta);
	}

	@Override
	public void setAnoAta(String anoAta) {
		ata.setAnoAta(anoAta);
	}
}
