package DAO;

import java.util.List;

import javax.persistence.Query;

import Model.Ata;
import Model.InterfacePadraoEntidade;
import PrimaryKey.AtaPK;
import PrimaryKey.InterfaceKey;

/**
 * Classe concreta para realizar o CRUD da Entidade Caixa.
 * <p><b>Extends</b><br>DAO
 *  
 * @author Walysson Oliveira
 * @version 1.0
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
        
        //METODO QUE RETORNA UMA MATRIZ DE ATAS CONTENDO TODAS AS ATAS DO BANCO PARA PREENCHER UMA JTABLE
    	public String[][] visualizarTodasAtas(){
    		String[][] matriz;
    		Query query = em.createNamedQuery("Ata.findAll");
    		@SuppressWarnings("unchecked")
    		List<Ata> atas = query.getResultList();
    		
    		matriz = new String[atas.size()][5];
    		
    		for (int i = 0; i < atas.size(); i++) {
    			Ata ata = atas.get(i); 
    			
    			matriz[i][0] = ata.getTurnoAta();
    			matriz[i][1] = ata.getAnoAta();
    			matriz[i][2] = ata.getTurnoAta();
    			matriz[i][3] = ata.getModalidadeAta();
    			matriz[i][4] = ata.getEnsinoAta();
    				
    		}
    		
    		return matriz;
    	}
}
