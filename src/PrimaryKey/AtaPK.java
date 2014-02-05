package PrimaryKey;

import javax.persistence.Embeddable;


@Embeddable
public class AtaPK implements Key {
	
	private String codAluno = null;
	private String turmaAta = null;
	private String turnoAta = null;
	private String anoAta = null;
	
	@Override
    public boolean equals(Object obj) {
       
		if(obj instanceof AtaPK){
            AtaPK ataPk = (AtaPK) obj;
 
            if(!ataPk.getTurmaAta().equals(turmaAta)){
                return false;
            }
 
            if(!ataPk.getTurnoAta().equals(turnoAta)){
                return false;
            }
            
            if(!ataPk.getAnoAta().equals(anoAta)){
                return false;
            }
 
            return true;
        }
 
        return false;
    }
	
	@Override
    public int hashCode() {
        return turmaAta.hashCode() + turnoAta.hashCode() + anoAta.hashCode();
    }
	
	@Override
	public String toString() {
		return this.anoAta+this.codAluno+this.turmaAta+this.turnoAta;
		
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

	public String getCodAluno() {
		return codAluno;
	}

	public void setCodAluno(String codAluno) {
		this.codAluno = codAluno;
	}

	@Override
	public Key getCodigo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCodigo(Key codigo) {
		// TODO Auto-generated method stub
		
	}

}
