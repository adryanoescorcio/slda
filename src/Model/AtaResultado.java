package Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;
import PrimaryKey.AtaResultadoPK;
import PrimaryKey.InterfaceKey;

/**
 * Classe concreta referente a Entidade AtaResultado do BD.
 * 
 * @author Adryano Escorcio
 * @version 1.5
 * @implements PadraoEntidade
 **/
@Entity
public class AtaResultado implements InterfacePadraoEntidade{

        @Transient
        private static final String NOMETABLE = "ataResultado";
        @Transient
        private static final String NOMECOLUNAPK = "codAluno; turmaAta; anoAta; turnoAta";
       
        @EmbeddedId
        private AtaResultadoPK atapk = new AtaResultadoPK();
       
        public void setCodigo(String aluno, String turnoAta, String turmaAta, String anoAta) {
            atapk.setCodigo(aluno, turmaAta, turnoAta, anoAta);
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
}
