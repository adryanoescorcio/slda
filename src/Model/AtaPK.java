package Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class AtaPK implements Serializable {
	
	private static final long serialVersionUID = -9049915368830597004L;
	
	@Column
	private String turmaAta;
	@Column
	private String turnoAta;
	@Column
	private String anoAta;
	
	public AtaPK() {
		
	}
	
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

}
