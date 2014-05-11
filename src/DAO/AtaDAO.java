package DAO;

import java.util.List;

import javax.persistence.Query;


import Model.Ata;
import Model.InterfacePadraoEntidade;
import PrimaryKey.AtaPK;
import PrimaryKey.InterfaceKey;

/**
 * Classe concreta para realizar o CRUD da Entidade Ata.
 * <p><b>Extends</b><br>DAO
 *  
 * @author Walysson Oliveira
 * @version 1.5
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
	 * Buscar Caixa usando o codigo. Necessário criar uma AtaPK
	 **/
	public Ata buscar(AtaPK codigo) {
		return (Ata) this.consultar(codigo);
	}

	@Override
	protected InterfacePadraoEntidade consultar(InterfaceKey codigo) {
		return em.find(Ata.class, codigo);
	}

	/**
	 * RETORNA TODAS AS ATAS DO BANCO
	 **/
	public List<Ata> getTodasAtas(){

		Query query = em.createNamedQuery("Ata.findAll");
		@SuppressWarnings("unchecked")
		List<Ata> atas = query.getResultList();
		return atas;
	}

	public boolean isContem(Ata ataTest) {
		return em.contains(ataTest);
	}

	public List<Ata> getAtasByYear(String ano){

		Query query = em.createNamedQuery("Ata.findByYear");
		query.setParameter("ano", ano);
		@SuppressWarnings("unchecked")
		List<Ata> atas = query.getResultList();
		return atas;

	}
}
