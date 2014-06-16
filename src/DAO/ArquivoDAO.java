package DAO;

import java.sql.SQLException;

import javax.persistence.Query;

import Model.Arquivo;
import Model.Caixa;
import Model.InterfacePadraoEntidade;
import PrimaryKey.InterfaceKey;

/**
 * Classe concreta para realizar o CRUD da Entidade Arquivo.
 * <p>
 * <b>Extends</b><br>
 * DAO
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * */
public class ArquivoDAO extends DAO {

	/**
	 * <b>Construtor</b>
	 * <p>
	 * Transmite a conexao do BD para super classe.<br>
	 * E inicia uma conexa transacao de dados.
	 **/
	public ArquivoDAO(final JPAUtil conexaoBD) {
		super(conexaoBD);
	}

	/**
	 * Buscar Caixa usando o codigo
	 * 
	 * @return arquivo
	 * @throws SQLException
	 **/
	public Arquivo buscar(final Object codigo) throws SQLException {

		Arquivo arq = new Arquivo();
		em.getTransaction().begin();
		// tenta realizar consulta usando a interface
		arq = (Arquivo) this.consultar((InterfaceKey) codigo);
		em.getTransaction().commit();
		return arq;
	}

	/**
	 * Realiza a consulta do aluno usando o codigo e retorna um arquivo
	 **/
	// private ResultSet consultarAluno(String codigo) throws SQLException {
	// return
	// stm.executeQuery("Select * from arquivo where codigoaluno =="+codigo);
	// }

	@Override
	protected InterfacePadraoEntidade consultar(final InterfaceKey codigo) {
		em.clear();
		return em.find(Arquivo.class, codigo);
	}

	public void excluirPorCaixa(final Caixa caixa) {

		final String codCaixa = caixa.getCodigo();

		try {
			em.getTransaction().begin();
			final Query query = em
					.createQuery(Messages.getString("ArquivoDAO.0")); //$NON-NLS-1$
			query.setParameter(Messages.getString("ArquivoDAO.1"), codCaixa); //$NON-NLS-1$
			query.executeUpdate();
			em.getTransaction().commit();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para inserir/atualiza o Entidade no Banco de Dados.
	 **/
	public boolean save(final Arquivo arquivo) {
		return super.save(arquivo);
	}
}
