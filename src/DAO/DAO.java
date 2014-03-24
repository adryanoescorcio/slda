package DAO;

import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import Model.InterfacePadraoEntidade;
import PrimaryKey.InterfaceKey;

/**
 * Classe abstrata que implementa as fun��es genericas do CRUD<br>
 * do Banco de Dados SQLite.
 * <p><b>Observa��o:</b><br>Excepetion SQL n�o s�o capturadas.
 * 
 * @author Adryano Escorcio
 * @version 2.0
 **/
public abstract class DAO {
	
	protected EntityManager em; // Conex�o JPA
	protected Statement stm; // Conex�o JDBC
	private JPAUtil conexao; // Conex�o BD
	
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
	 * <p><b>Observa��o:</b><br> Entidade n�o inicia a transa��o com BD
	 **/
	protected boolean saveEntidade(InterfacePadraoEntidade entidade) throws SQLException{
			
		System.out.println("Salvando: " + entidade.getCodigoKEY());
		em.persist(entidade);
		return true;
	}
	
	/**
	 * Remover um objeto PadraoEntidade do BD.
	 * <h1><b>Aten�ao:</b></h1> Note a diferen�a das assinaturas de metodos. 
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
			System.out.println("Erro: N�o foi possivel atualizar entidade");
			return false;
		}
	}

	/**
	 * Metodo para inserir/atualiza o Entidade no Banco de Dados.
	 **/	
	protected boolean save(InterfacePadraoEntidade objeto) {
		this.beginTransaction();
		
		try {
			// verificar se a entidade j� existe no banco de dados
			InterfacePadraoEntidade entidade = this.consultar(objeto.getCodigoKEY());
			
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
			
		} catch (NullPointerException | SQLException e) {
			JOptionPane.showMessageDialog(null, "(ER01) N�o foi salvar e nem atualizar, " +
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
	 * Metodo inicia uma transac�o e realiza o commit.
	 * <p><b>Oberva��o:</b><br>Usado para persistencia indireta de objetos, 
	 * ou seja quando um objeto � setado do BD e seus atributos alterado. Para efetivar a altera��o execute o metodo.
	 * @return True, caso a execu��o tenha terminado com sucesso. <br> False, caso a execu��o tenha terminado com erro.
	 **/
	public boolean transactionBeginAndCommit() {
		try {
			this.beginTransaction();
			this.doCommit();
			return true;
			
		} catch (Exception e) {
			System.out.println("Erro ao executar opera��o");
			return false;
		}
	}
}
