package DAO;

import java.util.List;

import javax.persistence.Query;

import Model.Ata;
import Model.InterfacePadraoEntidade;
import PrimaryKey.AtaPK;
import PrimaryKey.InterfaceKey;

/**
 * Classe concreta para realizar o CRUD da Entidade Ata.
 * <p>
 * <b>Extends</b><br>
 * DAO
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * */

public class AtaDAO extends DAO {

	/**
	 * <b>Construtor</b>
	 * <p>
	 * Transmite a conexao do BD para super classe.<br>
	 * E inicia uma conexa transacao de dados.
	 **/
	public AtaDAO(final JPAUtil conexaoBD) {
		super(conexaoBD);
	}

	/**
	 * Buscar Caixa usando o codigo. Necessário criar uma AtaPK
	 **/
	public Ata buscar(final AtaPK codigo) {
		return (Ata) this.consultar(codigo);
	}

	@Override
	protected InterfacePadraoEntidade consultar(final InterfaceKey codigo) {
		em.clear();
		return em.find(Ata.class, codigo);
	}

	public List<Ata> getAtasByYear(final String ano) {

		final Query query = em.createNamedQuery(Messages.getString("AtaDAO.0")); //$NON-NLS-1$
		query.setParameter(Messages.getString("AtaDAO.1"), ano); //$NON-NLS-1$
		@SuppressWarnings("unchecked")
		final List<Ata> atas = query.getResultList();
		return atas;

	}

	/**
	 * RETORNA TODAS AS ATAS DO BANCO
	 **/
	public List<Ata> getTodasAtas() {

		final Query query = em.createNamedQuery(Messages.getString("AtaDAO.2")); //$NON-NLS-1$
		@SuppressWarnings("unchecked")
		final List<Ata> atas = query.getResultList();
		return atas;
	}

	public boolean isContem(final Ata ataTest) {
		return em.contains(ataTest);
	}

	/**
	 * Metodo para inserir/atualiza o Entidade no Banco de Dados.
	 **/
	public boolean save(final Ata ata) {
		return super.save(ata);
	}
}
