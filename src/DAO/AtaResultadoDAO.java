package DAO;

import Model.AtaResultado;
import Model.InterfacePadraoEntidade;
import PrimaryKey.AtaResultadoPK;
import PrimaryKey.InterfaceKey;

public class AtaResultadoDAO extends DAO {

	/**
	 * <b>Construtor</b><p>
	 * Transmite a conexao do BD para super classe.<br>
	 * E inicia uma conexa transacao de dados.
	 **/ 
	public AtaResultadoDAO(JPAUtil conexaoBD) {
		super(conexaoBD);
	}
	
	/**
	 * Metodo para inserir/atualiza o Entidade no Banco de Dados.
	 **/
	public boolean save(AtaResultado ataResultado) {
		return super.save(ataResultado);
	}
	
	/**
	 * Buscar Caixa usando o codigo
	 **/
	public AtaResultado buscar(AtaResultadoPK codigo) {
		return (AtaResultado) this.consultar(codigo);
	}
	
	@Override
	protected InterfacePadraoEntidade consultar(InterfaceKey codigo) {
		return em.find(AtaResultado.class, codigo);
	}

}
