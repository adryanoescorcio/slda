package Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class AtaResultado implements PadraoEntidade{

	@Transient
	private static final String NOMETABLE = "ataResultado";
	@Transient
	private static final String NOMECOLUNAPK = "codAluno; turmaAta; anoAta; turnoAta";
	
	/**
	 * A entidade aluno sai da tabela porque a AtaPK possui um atributo que guarda o codigo do aluno.
	 * Tem como conseguencia aumento do processamento para busca o aluno no BD.
	 **/
	@Transient
	private Aluno aluno = null;

	@Id
	@GeneratedValue
	private String ataResultadoPK = null;
	
	@EmbeddedId
	private AtaPK ata = new AtaPK();
	
	
	@Override
	public String getCodigo() {
		return ataResultadoPK;
	}

	/**
	 * Não Implementado para essa Entidade porque o ID é AutoIncrement.
	 **/
	@Override
	public void setCodigo(String codigo) {
		// vazio
	}
	
	@Override
	public String getNomeTabelaBD() {
		return ataResultadoPK;
	}
	@Override
	public String getNomeColunaPKBD() {
		// TODO
		return null;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
		this.ata.setCodAluno(aluno.getCodigo());
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
	
	public AtaPK getAta() {
		return ata;
	}
}
