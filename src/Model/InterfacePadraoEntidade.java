package Model;

import PrimaryKey.InterfaceKey;

/**
 * Interface que todas as entidades devem possuir
 * @author Adryano Escorcio
 * @version 1.5
 **/
public interface InterfacePadraoEntidade {

	/**
	 * Pegar o Codigo(PK) da entidade
	 **/
	public InterfaceKey getCodigoKEY();

	/**
	 * Modificar o Codigo(PK) da entidade
	 **/
	public void setCodigoKEY(InterfaceKey chaveEntidade);

	/**
	 * Descreve todos os atributos do objeto
	 **/
	@Override
	public String toString();

}
