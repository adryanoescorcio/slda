package Model;


/**
 * Interface que todas as entidades devem possuir
 * @author Adryano Escorcio
 * @version 1.5
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
	 * Pegar o nome da tabela referente a classe no BD
	 **/
	public String getNomeTabelaBD();
	
	/**
	 * Pegar o nome da coluna referente a PK da entidade no BD
	 **/
	public String getNomeColunaPKBD();
}
