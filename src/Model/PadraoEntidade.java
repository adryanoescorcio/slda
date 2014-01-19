package Model;

import DAO.JPAUtil;

/**
 * Interface que todas as entidades devem possuir
 * @author Adryano Escorcio
 * @version 1.0
 * 
 **/
public interface PadraoEntidade {
	
	/**
	 * Pegar o Codigo(PK) da entidade
	 **/
	public String getCodigo();

	/**
	 * Modificar o Codigo(PK) da entidade
	 **/
	public void setCodigo(String codigo);
	
	/**
	 * Pegar a Conexao que esta sendo utilizada
	 **/
	public JPAUtil getConexaoBD();
	public void setConexaoBD(JPAUtil conexaoBD);
	
	/**
	 * Pegar o nome da tabela referente a classe no BD
	 **/
	public String getNomeTabelaBD();
	
	/**
	 * Pegar o nome da coluna referente a PK da entidade no BD
	 **/
	public String getNomeColunaPKBD();
}
