package Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

import PrimaryKey.AtaResultadoPK;
import PrimaryKey.InterfaceKey;

/**
 * Classe concreta referente a Entidade AtaResultado do BD.
 * 
 * @author Adryano Escorcio
 * @version 1.8
 * @implements PadraoEntidade
 **/
@NamedQuery(name="AtaResultado.findByAluno", query="SELECT a FROM AtaResultado a where a.atapk.aluno = :aluno")

@Entity
public class AtaResultado implements InterfacePadraoEntidade, InterfacePadraoAta {

        @EmbeddedId
        private AtaResultadoPK atapk = new AtaResultadoPK();

        private String modalidadeAta = null;
        private String ensinoAta = null;
        
        @Transient
        private String nomeAluno = "";
        
		public AtaResultadoPK getAtapk() {
			return atapk;
		}

		public void setAtapk(AtaResultadoPK atapk) {
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

		public void setCodigo(String aluno, String turnoAta, String turmaAta, String anoAta) {
            atapk.setCodigo(aluno, turmaAta, turnoAta, anoAta);
        }
       
        public String getNomeAluno() {
			return nomeAluno;
		}
        
        public String getTurmaAta() {
                return atapk.getTurmaAta();
        }

        public String getTurnoAta() {
                return atapk.getTurnoAta();
        }

        public String getAnoAta() {
                return atapk.getAnoAta();
        }
       
        @Override
        public InterfaceKey getCodigoKEY() {
                return atapk;
        }

        @Override
        public void setCodigoKEY(InterfaceKey chaveEntidade) {
                this.atapk = (AtaResultadoPK) chaveEntidade;
        }
        
        public String toString() {
        	return "" +
        			"Turma: "+this.atapk.getTurmaAta()+ ", " +
        			"Ano: "+this.atapk.getAnoAta()+ ", " +
        			"Turno: "+this.atapk.getTurnoAta()+ ", " +
        			"Aluno: "+this.atapk.getAluno()+ ", " +
        			"Ensino: "+ getEnsinoAta()+ ", " +
        			"Modalidade: "+ getModalidadeAta()+ ", " +
        			"";
        }

		public boolean equals(Object obj) {
			return atapk.equals(obj);
		}

		public String getAluno() {
			return atapk.getAluno();
		}

		public int hashCode() {
			return atapk.hashCode();
		}

		public void setNomeAluno(String nomeAluno) {
			this.nomeAluno = nomeAluno;
		}
		
		public void setAluno(String aluno) {
			atapk.setAluno(aluno);
		}

		public void setTurmaAta(String turmaAta) {
			atapk.setTurmaAta(turmaAta);
		}

		public void setTurnoAta(String turnoAta) {
			atapk.setTurnoAta(turnoAta);
		}

		public void setAnoAta(String anoAta) {
			atapk.setAnoAta(anoAta);
		}

		public void setAta(Ata ata) {
			this.setEnsinoAta(ata.getModalidadeAta());
			this.setModalidadeAta(ata.getModalidadeAta());
			this.setTurmaAta(ata.getTurmaAta());
			this.setTurnoAta(ata.getTurnoAta());
			this.setAnoAta(ata.getAnoAta());
		}
}
