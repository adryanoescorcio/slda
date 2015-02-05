package DAO;

import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import Model.InterfacePadraoEntidade;
import PrimaryKey.InterfaceKey;

/**
 * Classe abstrata que implementa as fun��es genericas do CRUD<br>
 * do Banco de Dados SQLite.
 * <p>
 * <b>Observa��o:</b><br>
 * Excepetion SQL n�o s�o capturadas.
 * 
 * @author Adryano Escorcio
 * @version 2.0
 **/

public abstract class DAO {

	protected EntityManager em; // Conex�o JPA
	protected EntityManager emPW; // Conex�o JPA
	protected Statement stm; // Conex�o JDBC
	private JPAUtil conexao; // Conex�o BD

	/**
	 * Construtor que recebe a conexao do BD
	 **/
	public DAO(final JPAUtil conexaoBD) {
		this.conexao = conexaoBD;
		this.em = conexaoBD.getEm();
		this.emPW = conexaoBD.getEmPW();
		this.stm = conexaoBD.getStm();
	}

	/**
	 * Atualizar um objeto PadraoEntidade do BD
	 **/
	public boolean atualizar(final InterfacePadraoEntidade entidade) {
		try {
			// atualizar
			System.out.println(Messages.getString("DAO.0")); //$NON-NLS-1$
			em.merge(entidade);
			return true;

		} catch (final Exception e) {
			System.out.println(Messages.getString("DAO.1")); //$NON-NLS-1$
			return false;
		}
	}

	/**
	 * Indica para o BD que uma transicao ser� iniciada
	 **/
	public void beginTransaction() {
		this.em.getTransaction().begin();
	}

	/**
	 * Consultar um objeto PadraoEntidade do BD
	 **/
	protected abstract InterfacePadraoEntidade consultar(InterfaceKey key);

	/**
	 * Concretiza uma transicao com o BD
	 **/
	public void doCommit() {
		this.em.getTransaction().commit();
		this.em.clear(); // limpa a conexao
	}

	/**
	 * Pegar a Conexao que esta sendo utilizada.
	 **/

	public JPAUtil getConexaoBD() {
		return this.conexao;
	}

	public EntityManager getEm() {
		return em;
	}

	public Statement getStm() {
		return stm;
	}

	/**
	 * Remover um objeto PadraoEntidade do BD. <h1><b>Aten�ao:</b></h1> Note a
	 * diferen�a das assinaturas de metodos.
	 **/
	protected boolean remover(final InterfacePadraoEntidade entidade) {

		try {
			System.out.println(Messages.getString("DAO.2") + entidade.getCodigoKEY()); //$NON-NLS-1$
			em.remove(entidade);
			return true;
		} catch (final Exception e) {
			System.out.println(Messages.getString("DAO.3")); //$NON-NLS-1$
			return false;
		} finally {
			this.doCommit();
		}
	}

	/**
	 * Remover Entidade do Banco de Dados
	 * 
	 * @param <li><b>String</b> codigoEntidade</li> <b>or</b> <li>
	 *        <b>PadraoEntidade</b> entidade</li>
	 **/

	public boolean remover(final Object params) {
		this.beginTransaction();

		try {
			return this
					.removerPorObjetoEntidade((InterfacePadraoEntidade) params);
		} catch (final Exception e) {
			return this.removerPorCodigoPK((InterfaceKey) params);
		}
	}

	protected boolean removerPorCodigoPK(final InterfaceKey codigo) {
		return this.remover(this.consultar(codigo));
	}

	protected boolean removerPorObjetoEntidade(
			final InterfacePadraoEntidade entidade) {
		return this.remover(this.consultar(entidade.getCodigoKEY()));
	}

	/**
	 * Metodo para inserir/atualiza o Entidade no Banco de Dados.
	 **/
	protected boolean save(final InterfacePadraoEntidade objeto) {
		this.beginTransaction();

		try {
			// verificar se a entidade j� existe no banco de dados
			final InterfacePadraoEntidade entidade = this.consultar(objeto
					.getCodigoKEY());

			// se n�o existir no BD, persistir entidade
			if (entidade == null) {
				return this.saveEntidade(objeto);
			} else {
				// se existir no BD, verificar se a entidade foi alterada.
				if (entidade.toString().equals(objeto.toString())) {
					System.out
							.println(Messages.getString("DAO.4")); //$NON-NLS-1$
					return true;
				} else {
					// a entidade foi alterada, ent�o atualize BD
					return this.atualizar(objeto);
				}
			}

		} catch (NullPointerException | SQLException e) {
			JOptionPane
					.showMessageDialog(
							null,
							Messages.getString("DAO.5") //$NON-NLS-1$
									+ Messages.getString("DAO.6"), //$NON-NLS-1$
							Messages.getString("DAO.7"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$
			return false;

		} finally {
			this.doCommit();
		}
	}

	/**
	 * Inserir um objeto PadraoEntidade no BD
	 * <p>
	 * <b>Observa��o:</b><br>
	 * Entidade n�o inicia a transa��o com BD
	 **/
	protected boolean saveEntidade(final InterfacePadraoEntidade entidade)
			throws SQLException {

		System.out.println(Messages.getString("DAO.8") + entidade.getCodigoKEY()); //$NON-NLS-1$
		em.persist(entidade);
		return true;
	}

	public void setConexaoBD(final JPAUtil conexaoBD) {
		this.conexao = conexaoBD;
	}

	public void setEm(final EntityManager em) {
		this.em = em;
	}

	public void setStm(final Statement stm) {
		this.stm = stm;
	}

	/**
	 * Metodo inicia uma transac�o e realiza o commit.
	 * <p>
	 * <b>Oberva��o:</b><br>
	 * Usado para persistencia indireta de objetos, ou seja quando um objeto �
	 * setado do BD e seus atributos alterado. Para efetivar a altera��o execute
	 * o metodo. Inicia e finaliza.
	 * 
	 * @return True, caso a execu��o tenha terminado com sucesso. <br>
	 *         False, caso a execu��o tenha terminado com erro.
	 **/

	public boolean transactionBeginAndCommit() {
		try {
			this.beginTransaction();
			this.doCommit();
			return true;

		} catch (final Exception e) {
			System.out.println(Messages.getString("DAO.9")); //$NON-NLS-1$
			return false;
		}
	}
}
