package Model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class AtaResultado implements PadraoEntidade{

	@Transient
	private static final String NOMETABLE = "ataResultado";
	@Transient
	private static final String NOMECOLUNAPK = "codAluno; turmaAta; anoAta; turnoAta";

	@Id
	private String ataResultadopk;
	
	private String codAluno;
	@Embedded
	private AtaPK ata;
	@Override
	public String getCodigo() {
		// TODO Auto-generated method stub
		return ataResultadopk;
	}
	@Override
	public void setCodigo(String codigo) {
		this.ataResultadopk = codigo;
		
	}
	@Override
	public String getNomeTabelaBD() {
		// TODO Auto-generated method stub
		return ataResultadopk;
	}
	@Override
	public String getNomeColunaPKBD() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getCodAluno() {
		return codAluno;
	}
	public void setCodAluno(String codAluno) {
		this.codAluno = codAluno;
	}
	public AtaPK getAta() {
		return ata;
	}
	public void setAta(AtaPK ata) {
		this.ata = ata;
	}
	
}
