package Model;

import PrimaryKey.Key;


/**
 * Interface que todas as entidades devem possuir
 * @author Adryano Escorcio
 * @version 1.5
 **/
public interface PadraoEntidade {
	
	/**
	 * Pegar o Codigo(PK) da entidade
	 **/
	public Key getCodigoKEY();

	/**
	 * Modificar o Codigo(PK) da entidade
	 **/
	public void setCodigoKEY(Key chaveEntidade);
	
	/**
	 * Retorna o nome da tabela que é referente a classe no BD
	 **/
	
	public String getNomeTabelaBD();
	
	/**
	 * Pegar o nome da coluna referente a PK da entidade no BD
	 **/
	public String getNomeColunaPKBD();
	
	/**
	 * Descreve todos os atributos do objeto
	 **/
	@Override
	public String toString();

	
	void setCodigo(String codigo);
}
