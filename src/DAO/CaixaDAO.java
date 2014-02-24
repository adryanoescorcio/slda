package DAO;

import Model.Caixa;
import Model.InterfacePadraoEntidade;
import PrimaryKey.CaixaPK;
import PrimaryKey.InterfaceKey;

/**
 * Classe concreta para realizar o CRUD da Entidade Caixa.
 * <p><b>Extends</b><br>DAO
 *  
 * @author Walysson Oliveira
 * @version 1.0
 * */
public class CaixaDAO extends DAO {

	private CaixaPK pk;
	
	/**
	 * <b>Construtor</b><p>
	 * Transmite a conexao do BD para super classe.<br>
	 * E inicia uma conexa transacao de dados.
	 **/ 
	public CaixaDAO(JPAUtil conexaoBD) {
		super(conexaoBD);
	}
	
	/**
	 * Metodo para inserir/atualiza o Entidade no Banco de Dados.
	 **/
	public boolean save(Caixa caixa) {
		return super.save(caixa);
	}
	
	/**
	 * Buscar Caixa usando o codigo
	 **/
	public Caixa buscar(String codigo) {
		pk = new CaixaPK();
		pk.setCodigo(codigo);
		
		return (Caixa) this.consultar(pk);
	}
	
	@Override
	protected InterfacePadraoEntidade consultar(InterfaceKey codigo) {
		return em.find(Caixa.class, codigo);
	}
}
