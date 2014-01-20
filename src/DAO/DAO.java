package DAO;

import java.sql.Statement;

import javax.persistence.EntityManager;

import Model.PadraoEntidade;

/**
 * Classe abstrata que implementa as funções genericas do CRUD
 * do Banco de Dados SQLite.
 * 
 * @author Adryano Escorcio
 * @version 1.0
 **/
public abstract class DAO {
	
	protected EntityManager em;
	protected Statement stm;
	
	/**
	 * Construtor que recebe a conexao do BD
	 **/
	public DAO(JPAUtil conexaoBD) {
		this.em = conexaoBD.getEm();
		this.stm = conexaoBD.getStm();
	}

	/**
	 * Indica para o BD que uma transicao será iniciada
	 **/
	protected void inicarTransicao() {
		em.getTransaction().begin();
	}
	
	/**
	 * Concretiza uma transicao com o BD
	 **/
	protected void fazerCommit() {
		em.getTransaction().commit();
	}
	
	/**
	 * Inserir um objeto PadraoEntidade no BD 
	 **/
	protected abstract boolean saveEntidade(PadraoEntidade entidade);
	
	/**
	 * Remover um objeto PadraoEntidade do BD 
	 **/
	protected boolean remover(PadraoEntidade entidade){
		// verificar se entidade realmente existe no BD
			if(entidade != null) {
				
				return queryDeletarRow(entidade);
				
			} else {
				System.out.println("Erro: Nenhum objeto foi encontrado.");
				return false;
			}
	}
	
	/**
	 * Consultar um objeto PadraoEntidade do BD 
	 **/
	protected abstract PadraoEntidade consultar(String codigo);
	
	protected abstract boolean removerPorCodigoPK(String codigo);
	
	protected abstract boolean removerPorObjetoEntidade(PadraoEntidade entidade);
	
	/**
	 * Atualizar um objeto PadraoEntidade do BD 
	 **/
	protected boolean atualizar(PadraoEntidade entidade) {
		try{
			//atualizar
			System.out.println("Alterando");
			em.merge(entidade);
			fazerCommit();
			return true;
		} catch(Exception e) {
			System.out.println("Erro: Não foi possivel atualizar entidade");
			return false;
		}
	}

	/**
	 * Codigo SQL para remover entidade do BD
	 **/
	protected boolean queryDeletarRow(PadraoEntidade entidade) {
		try{
			System.out.println("Removendo: "+entidade.getCodigo());
			stm.executeUpdate("" +
					"DELETE FROM " +entidade.getNomeTabelaBD()+ " WHERE " +
					entidade.getNomeColunaPKBD()+ " = \"" +entidade.getCodigo()+ "\"");
			return true;
			
		}catch(Exception e){
			System.out.println("Erro: Não foi possivel deletar objeto");
			return false;
		}
	}
	
	/**
	 * Pegar a Conexao que esta sendo utilizada
	 **/
	protected abstract JPAUtil getConexaoBD();
	protected abstract void setConexaoBD(JPAUtil conexaoBD);
	
}
