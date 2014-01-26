package DAO;

import Model.Caixa;
import Model.PadraoEntidade;

/**
 * Classe concreta para realizar o CRUD da Entidade Caixa.
 * <p><b>Extends</b><br>DAO
 *  
 * @author Walysson Oliveira
 * @version 1.0
 * */
public class CaixaDAO extends DAO {

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
		return (Caixa) this.consultar(codigo);
	}
	
	@Override
	protected PadraoEntidade consultar(String codigo) {
		return em.find(Caixa.class, codigo);
	}
}
