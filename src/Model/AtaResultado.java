package Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;
import PrimaryKey.AtaResultadoPK;
import PrimaryKey.InterfaceKey;

@Entity
public class AtaResultado implements InterfacePadraoEntidade{

	@Transient
	private static final String NOMETABLE = "ataResultado";
	@Transient
	private static final String NOMECOLUNAPK = "codAluno; turmaAta; anoAta; turnoAta";
	
	@EmbeddedId
	private AtaResultadoPK atapk = new AtaResultadoPK();
	
	public void setCodigo(String aluno, String turnoAta, String turmaAta, String anoAta) {
		atapk.setAluno(aluno);
		atapk.setAnoAta(anoAta);
		atapk.setTurmaAta(turmaAta);
		atapk.setTurnoAta(turnoAta);
	}
	
	@Override
	public String getNomeTabelaBD() {
		return NOMETABLE;
	}
	
	@Override
	public String getNomeColunaPKBD() {
		return NOMECOLUNAPK;
	}

	public String getTurmaAta() {
		return atapk.getTurmaAta();
	}

	public void setTurmaAta(String turmaAta) {
		atapk.setTurmaAta(turmaAta);
	}

	public String getTurnoAta() {
		return atapk.getTurnoAta();
	}

	public void setTurnoAta(String turnoAta) {
		atapk.setTurnoAta(turnoAta);
	}

	public String getAnoAta() {
		return atapk.getAnoAta();
	}

	public void setAnoAta(String anoAta) {
		atapk.setAnoAta(anoAta);
	}
	
	@Override
	public InterfaceKey getCodigoKEY() {
		return atapk;
	}

	@Override
	public void setCodigoKEY(InterfaceKey chaveEntidade) {
		this.atapk = (AtaResultadoPK) chaveEntidade;
	}
}
