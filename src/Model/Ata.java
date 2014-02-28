package Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import PrimaryKey.AtaPK;
import PrimaryKey.InterfaceKey;
/**
 * Classe concreta referente a Entidade Ata do BD.
 * 
 * @author Adryano Escorcio
 * @version 1.5
 * @implements PadraoEntidade
 **/
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
		this.ata.setCodigo(turmaAta, turnoAta, anoAta);
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
