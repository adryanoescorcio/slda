package DAO;

import Model.Ata;
import Model.AtaPK;
import Model.PadraoEntidade;

/**
 * Classe concreta para realizar o CRUD da Entidade Caixa.
 * <p><b>Extends</b><br>DAO
 *  
 * @author Walysson Oliveira
 * @version 1.0
 * */
public class AtaDAO extends DAO {

	/**
	 * <b>Construtor</b><p>
	 * Transmite a conexao do BD para super classe.<br>
	 * E inicia uma conexa transacao de dados.
	 **/ 
	public AtaDAO(JPAUtil conexaoBD) {
		super(conexaoBD);
	}
	
	/**
	 * Metodo para inserir/atualiza o Entidade no Banco de Dados.
	 **/
	public boolean save(Ata ata) {
		return super.save(ata);
	}
	
	/**
	 * Buscar Caixa usando o codigo
	 **/
	public Ata buscar(String codigo) {
		return (Ata) this.consultar(codigo);
	}
	
	@Override
	protected PadraoEntidade consultar(String codigo) {
		// TODO Auto-generated method stub
		return em.find(Ata.class, codigo);
	}
}

