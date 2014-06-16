package DAO;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe que realiza a conexao com o Banco de Dados SQLite<br>
 * embarcado na App e faz a conexao com o arquivo persistence.xml.
 * 
 * <br>
 * Abrindo vários tipos de manipulação de Dados.
 * 
 * @param EntityManagerFactory
 *            factory<br>
 *            <b>EntityManager</b> em <br>
 *            <b>Connection</b> conn <br>
 *            <b>Statement</b> stm <br>
 * @author Adryano Escorcio
 * @version 2.0
 **/
public class JPAUtil {

	private static final String CLASS_BD = Messages.getString("JPAUtil.0"); //$NON-NLS-1$
	private static final String CONEXAO_BD = Messages.getString("JPAUtil.1"); //$NON-NLS-1$
	private static final String BANCO_WA = Messages.getString("JPAUtil.2"); //$NON-NLS-1$

	// ALTERAR EM CASO DE ERRO - WALYSSON
	private static final String DIR_WA = Messages.getString("JPAUtil.3"); // Diretorio do Computador //$NON-NLS-1$
	private static final String DIR_WAPW = Messages.getString("JPAUtil.4"); // Diretorio do //$NON-NLS-1$
														// Computador

	private static final String FILE_PERSISTENCE_XML_WAPW = Messages.getString("JPAUtil.5"); //$NON-NLS-1$
	private static final String FILE_PERSISTENCE_XML_WA = Messages.getString("JPAUtil.6"); //$NON-NLS-1$

	// Direciona o arquivo XML para conectar o BD
	private EntityManagerFactory factory;
	private EntityManagerFactory factoryPW;
	protected EntityManager em;
	protected EntityManager emPW;
	private Connection conn;
	private Statement stm;

	/**
	 * Classe responsavel pela conexão com o BD. Abrindo vários<br>
	 * tipos de manipulação de Dados
	 **/
	public JPAUtil() {
		// Verifica qual dos diretorios existe na máquina.
		final File file = new File(DIR_WA);
		final File file2 = new File(DIR_WAPW);

		if (!file.exists()) {
			file.mkdir();
			file2.mkdir();
		}

		conexaoManager(FILE_PERSISTENCE_XML_WA, FILE_PERSISTENCE_XML_WAPW,
				BANCO_WA, DIR_WA);
	}

	/**
	 * Fecha todas as conexao instanciadas pelo Objeto.
	 **/
	public void closeAllConexao() {
		factory.close();
	}

	private void conexaoManager(final String filePersistence,
			final String filePersistenceSenha, final String nomeBD,
			final String diretorioComp) {
		// Conexao com JPA
		try {
			// CONEXÃO BD MAIN
			this.factory = Persistence
					.createEntityManagerFactory(filePersistence);
			this.em = factory.createEntityManager();

			// CONEXAO BD SENHA
			this.factoryPW = Persistence
					.createEntityManagerFactory(filePersistenceSenha);
			this.emPW = factoryPW.createEntityManager();

		} catch (final Exception e) {
			System.out.println(Messages.getString("JPAUtil.7") + e.getMessage()); //$NON-NLS-1$
		}

		// Conexao com JDBC
		try {
			Class.forName(CLASS_BD);
			conn = DriverManager.getConnection(CONEXAO_BD + diretorioComp
					+ nomeBD); // Tenta conectar no banco de dados
			setStm(conn.createStatement());
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(Messages.getString("JPAUtil.8") + e); //$NON-NLS-1$
		}
	}

	public Connection getConn() {
		return conn;
	}

	public EntityManager getEm() {
		return em;
	}

	public EntityManager getEmPW() {
		return emPW;
	}

	public EntityManagerFactory getFactory() {
		return factory;
	}

	public Statement getStm() {
		return stm;
	}

	public void setConn(final Connection conn) {
		this.conn = conn;
	}

	public void setEm(final EntityManager em) {
		this.em = em;
	}

	public void setEmPW(final EntityManager emPW) {
		this.emPW = emPW;
	}

	public void setFactory(final EntityManagerFactory factory) {
		this.factory = factory;
	}

	public void setStm(final Statement stm) {
		this.stm = stm;
	}

}
