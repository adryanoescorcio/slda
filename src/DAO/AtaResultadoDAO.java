package DAO;

import Model.AtaPK;
import Model.AtaResultado;
import Model.PadraoEntidade;

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
	public AtaResultado buscar(String codigo) {
		return (AtaResultado) this.consultar(codigo);
	}
	
	protected PadraoEntidade consultar(AtaPK atapk) {
		return em.find(AtaResultado.class, atapk);
	}

	@Override
	protected PadraoEntidade consultar(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
