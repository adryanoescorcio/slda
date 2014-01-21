package DAO;

import java.sql.Statement;

import javax.persistence.EntityManager;

import Model.PadraoEntidade;

/**
 * Classe abstrata que implementa as fun��es genericas do CRUD
 * do Banco de Dados SQLite.
 * 
 * @author Adryano Escorcio
 * @version 1.0
 **/
public abstract class DAO {
	
	protected EntityManager em;
	protected Statement stm;
	private JPAUtil conexao;
	
	/**
	 * Construtor que recebe a conexao do BD
	 **/
	public DAO(JPAUtil conexaoBD) {
		this.conexao = conexaoBD;
		this.em = conexaoBD.getEm();
		this.stm = conexaoBD.getStm();
	}

	/**
	 * Indica para o BD que uma transicao ser� iniciada
	 **/
	protected void iniciarTransicao() {
		this.em.getTransaction().begin();
	}
	
	/**
	 * Concretiza uma transicao com o BD
	 **/
	protected void fazerCommit() {
		this.em.getTransaction().commit();
		this.em.clear();
	}
	
	public boolean transicaoCommit() {
		try {
			this.iniciarTransicao();
			this.fazerCommit();
			return true;
		} catch (Exception e) {
			System.out.println("Erro ao executar opera��o");
			return false;
		}
	}
	
	/**
	 * Inserir um objeto PadraoEntidade no BD 
	 **/
	protected boolean saveEntidade(PadraoEntidade entidade){
		
		try {
			System.out.println("Salvando: " + entidade.getCodigo());
			em.persist(entidade);
			this.fazerCommit();
			return true;
		} catch(Exception e) {
			System.out.println("Erro ao persistir");
			return false;
		}
	}
	
	/**
	 * Remover um objeto PadraoEntidade do BD.
	 * <h1><b>Aten�ao:</b></h1> Note a diferen�a das assinaturas de metodos. 
	 **/
	protected boolean remover(PadraoEntidade entidade){
		// verificar se entidade realmente existe no BD
			if(entidade != null) {
				
				return this.queryDeletarRow(entidade);
				
			} else {
				System.out.println("Erro: Nenhum objeto foi encontrado.");
				return false;
			}
	}
	
	/**
	 * Consultar um objeto PadraoEntidade do BD 
	 **/
	protected abstract PadraoEntidade consultar(String codigo);
	
	protected boolean removerPorCodigoPK(String codigo){
		return this.remover(
				this.consultar(codigo));
	}
	
	protected boolean removerPorObjetoEntidade(PadraoEntidade entidade){
		return this.remover(
				this.consultar(entidade.getCodigo()));
	}
	
	/**
	 * Atualizar um objeto PadraoEntidade do BD 
	 **/
	protected boolean atualizar(PadraoEntidade entidade) {
		try{
			//atualizar
			System.out.println("Alterando");
			em.merge(entidade);
			this.fazerCommit();
			return true;
			
		} catch(Exception e) {
			System.out.println("Erro: N�o foi possivel atualizar entidade");
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
			System.out.println("Erro: N�o foi possivel deletar objeto");
			return false;
		}
	}
	
	/**
	 * Pegar a Conexao que esta sendo utilizada
	 **/
	public JPAUtil getConexaoBD() {
		return this.conexao;
	}
	public void setConexaoBD(JPAUtil conexaoBD){
		this.conexao = conexaoBD;
	}
	
	public EntityManager getEm() {
		return em;
	}
	
	public Statement getStm() {
		return stm;
	}
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public void setStm(Statement stm) {
		this.stm = stm;
	}
	/**
	 * Remover Entidade do Banco de Dados
	 * @param <li><b>String</b> codigoEntidade</li> <b>or</b>
	 * <li><b>PadraoEntidade</b> entidade </li>
	 **/
	public boolean remover(Object params) {
		this.iniciarTransicao();
		
		try {
			return this.removerPorObjetoEntidade((PadraoEntidade) params);
			
		} catch (Exception e) {
			return this.removerPorCodigoPK((String) params);
		}
	}
	
	/**
	 * Metodo para inserir/atualiza o Aluno no Banco de Dados
	 **/	
	protected boolean save(PadraoEntidade objeto){
		this.iniciarTransicao();
		
		try {
			// verificar se a entidade j� existe no banco de dados
			PadraoEntidade entidade = this.consultar(objeto.getCodigo());
			
			//se n�o existir no BD, persistir entidade
			if(entidade == null) {			
				return this.saveEntidade(objeto);
			} else {
				// se existir no BD, verificar se a entidade foi alterada.
				if(entidade.toString().equals(objeto.toString())){
					System.out.println("Alerta: N�o houve modifica��es na entidade");
					return true;
				} else{
					// a entidade foi alterada, ent�o atualize BD
					return this.atualizar(objeto);
				}
			}
			
		} catch (NullPointerException e) {
			System.out.println("N�o foi setado EM da classe:" + e.getMessage());
			return false;
		}
	}
}
