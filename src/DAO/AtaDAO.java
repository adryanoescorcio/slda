package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import Model.Aluno;
import Model.Ata;
import Model.AtaResultado;
import Model.InterfacePadraoEntidade;
import PrimaryKey.AtaPK;
import PrimaryKey.InterfaceKey;

/**
 * Classe concreta para realizar o CRUD da Entidade Ata.
 * <p><b>Extends</b><br>DAO
 *  
 * @author Walysson Oliveira
 * @version 1.5
 * */

public class AtaDAO extends DAO {

        /**
         * <b>Construtor</b><p>
         * Transmite a conexao do BD para super classe.<br>
         * E inicia uma conexa transacao de dados.
         **/
        public AtaDAO(JPAUtil conexaoBD) {
                super(conexaoBD);
        }
       
        /**
         * Metodo para inserir/atualiza o Entidade no Banco de Dados.
         **/
        public boolean save(Ata ata) {
                return super.save(ata);
        }
       
        /**
         * Buscar Caixa usando o codigo. Necessário criar uma AtaPK
         **/
        public Ata buscar(AtaPK codigo) {
                return (Ata) this.consultar(codigo);
        }
       
        @Override
        protected InterfacePadraoEntidade consultar(InterfaceKey codigo) {
                return em.find(Ata.class, codigo);
        }
        
        /**
    	 * RETORNA TODAS AS ATAS DO BANCO
    	 **/
        public List<Ata> getTodasAtas(){
    		
    		Query query = em.createNamedQuery("Ata.findAll");
    		@SuppressWarnings("unchecked")
			List<Ata> atas = query.getResultList();
    		return atas;
    	}

		@SuppressWarnings("unchecked")
		public List buscaAta(Aluno aln) {
			@SuppressWarnings("rawtypes")
			List list = new ArrayList();
			try {
				ResultSet rs = stm.executeQuery("Select * from ataresultado where aluno = '"+aln.getCodigo()+"'");
				while(rs.next()){
					AtaResultado ataResul = new AtaResultado();
					ataResul.setAluno(rs.getString("aluno")); // setando o codigo do aluno
					ataResul.setTurmaAta(rs.getString("turmaata")); // setando a turma da ata
					ataResul.setAnoAta(rs.getString("anoata")); // setando o ano
					ataResul.setTurnoAta(rs.getString("turnoata")); // setando o turno
					ataResul.setNomeAluno(aln.getNomeAluno()); // setando o codigo do aluno
					
					list.add(ataResul); // inserindo na lista
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
			
		}
}
