package DAO;

import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import Model.InterfacePadraoEntidade;
import PrimaryKey.InterfaceKey;

/**
 * Classe abstrata que implementa as funções genericas do CRUD<br>
 * do Banco de Dados SQLite.
 * <p><b>Observação:</b><br>Excepetion SQL não são capturadas.
 * 
 * @author Adryano Escorcio
 * @version 2.0
 **/
public abstract class DAO {
	
	protected EntityManager em; // Conexão JPA
	protected Statement stm; // Conexão JDBC
	private JPAUtil conexao; // Conexão BD
	
	/**
	 * Construtor que recebe a conexao do BD
	 **/
	public DAO(JPAUtil conexaoBD) {
		this.conexao = conexaoBD;
		this.em = conexaoBD.getEm();
		this.stm = conexaoBD.getStm();
	}

	/**
	 * Indica para o BD que uma transicao será iniciada
	 **/
	protected void beginTransaction() {
		this.em.getTransaction().begin();
	}
	
	/**
	 * Concretiza uma transicao com o BD
	 **/
	protected void doCommit() {
		this.em.getTransaction().commit();
		this.em.clear(); // limpa a conexao
	}
	
	/**
	 * Inserir um objeto PadraoEntidade no BD
	 * <p><b>Observação:</b><br> Entidade não inicia a transação com BD
	 **/
	protected boolean saveEntidade(InterfacePadraoEntidade entidade) throws SQLException{
			
		System.out.println("Salvando: " + entidade.getCodigoKEY());
		em.persist(entidade);
		return true;
	}
	
	/**
	 * Remover um objeto PadraoEntidade do BD.
	 * <h1><b>Atençao:</b></h1> Note a diferença das assinaturas de metodos. 
	 **/
	protected boolean remover(InterfacePadraoEntidade entidade){
	
		try {
			System.out.println("Removendo: "+entidade.getCodigoKEY());
			em.remove(entidade);
					
			return true;
		} catch (Exception e) {
			System.out.println("Erro: Remover.");
			return false;
		} finally {
			this.doCommit();
		}
	}
	
	/**
	 * Consultar um objeto PadraoEntidade do BD 
	 **/
	protected abstract InterfacePadraoEntidade consultar(InterfaceKey key);
	
	protected boolean removerPorCodigoPK(InterfaceKey codigo){
		return this.remover(
				this.consultar(codigo));
	}
	
	protected boolean removerPorObjetoEntidade(InterfacePadraoEntidade entidade){
		return this.remover(
				this.consultar(
						entidade.getCodigoKEY()));
	}
	
	/**
	 * Atualizar um objeto PadraoEntidade do BD 
	 **/
	protected boolean atualizar(InterfacePadraoEntidade entidade) {
		try{
			//atualizar
			System.out.println("Alterando");
			em.merge(entidade);
			return true;
			
		} catch(Exception e) {
			System.out.println("Erro: Não foi possivel atualizar entidade");
			return false;
		}
	}

	/**
	 * Metodo para inserir/atualiza o Entidade no Banco de Dados.
	 **/	
	protected boolean save(InterfacePadraoEntidade objeto) {
		this.beginTransaction();
		
		try {
			// verificar se a entidade já existe no banco de dados
			InterfacePadraoEntidade entidade = this.consultar(objeto.getCodigoKEY());
			
			//se não existir no BD, persistir entidade
			if(entidade == null) {			
				return this.saveEntidade(objeto);
			} else {
				// se existir no BD, verificar se a entidade foi alterada.
				if(entidade.toString().equals(objeto.toString())){
					System.out.println("Alerta: Não houve modificações na entidade");
					return true;
				} else{
					// a entidade foi alterada, então atualize BD
					return this.atualizar(objeto);
				}
			}
			
		} catch (NullPointerException | SQLException e) {
			JOptionPane.showMessageDialog(null, "(ER01) Não foi salvar e nem atualizar, " +
					"verifique os dados digitados e o banco de dados.", "ERRO ER01", JOptionPane.ERROR_MESSAGE);
			return false;
	
		} finally {
			this.doCommit();
		}
	}
	
	/**
	 * Pegar a Conexao que esta sendo utilizada.
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
		this.beginTransaction();
		
		try {
			return this.removerPorObjetoEntidade((InterfacePadraoEntidade) params);
		} catch (Exception e) {
			return this.removerPorCodigoPK((InterfaceKey) params);
		}
	}
	
	/**
	 * Metodo inicia uma transacão e realiza o commit.
	 * <p><b>Obervação:</b><br>Usado para persistencia indireta de objetos, 
	 * ou seja quando um objeto é setado do BD e seus atributos alterado. Para efetivar a alteração execute o metodo.
	 * @return True, caso a execução tenha terminado com sucesso. <br> False, caso a execução tenha terminado com erro.
	 **/
	public boolean transactionBeginAndCommit() {
		try {
			this.beginTransaction();
			this.doCommit();
			return true;
			
		} catch (Exception e) {
			System.out.println("Erro ao executar operação");
			return false;
		}
	}
}
