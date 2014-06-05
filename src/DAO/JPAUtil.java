package DAO;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 Classe que realiza a conexao com o Banco de 
 Dados SQLite<br> embarcado na App e faz a 
 conexao com o arquivo persistence.xml.

 <br>Abrindo vários tipos de manipulação de Dados. 
 *@param EntityManagerFactory factory<br>
	<b>EntityManager</b> em <br>
	<b>Connection</b> conn <br>
	<b>Statement</b> stm <br>
 * @author Adryano Escorcio
 * @version 2.0
 **/
public class JPAUtil {

	private static final String CLASS_BD = "org.sqlite.JDBC";
	private static final String CONEXAO_BD = "jdbc:sqlite:";
	private static final String BANCO_WA = "in.db";


	// ALTERAR EM CASO DE ERRO - WALYSSON
	private static final String DIR_WA = "sysdrive/"; // Diretorio do Computador
	private static final String DIR_WAPW = "systout/"; // Diretorio do Computador

	private static final String FILE_PERSISTENCE_XML_WAPW = "managerWAPW";
	private static final String FILE_PERSISTENCE_XML_WA = "managerWA";

	//Direciona o arquivo XML para conectar o BD
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
		File file = new File(DIR_WA);
		File file2 = new File(DIR_WAPW);
		try {
			if(!file.exists()) {
				file.createNewFile();
				file2.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			conexaoManager(FILE_PERSISTENCE_XML_WA, FILE_PERSISTENCE_XML_WAPW, BANCO_WA, DIR_WA);
		}
	}

	private void conexaoManager(String filePersistence, String filePersistenceSenha, String nomeBD, String diretorioComp) {
		// Conexao com JPA
		try{
			// CONEXÃO BD MAIN
			this.factory = Persistence.createEntityManagerFactory(filePersistence);
			this.em = factory.createEntityManager();
			
			//CONEXAO BD SENHA
			this.factoryPW = Persistence.createEntityManagerFactory(filePersistenceSenha);
			this.emPW = factoryPW.createEntityManager();
			
		} catch(Exception e) {
			System.out.println("Erro: conexao JPA" +e.getMessage());
		}

		// Conexao com JDBC
		try {
			Class.forName(CLASS_BD);
			conn = DriverManager.getConnection(CONEXAO_BD + diretorioComp + nomeBD); // Tenta conectar no banco de dados
			setStm(conn.createStatement());
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Erro: conexao JDBC" + e);
		}
	}

	/**
	 * Fecha todas as conexao instanciadas pelo Objeto.
	 **/
	public void closeAllConexao() {
		factory.close();
	}
	
	public EntityManager getEmPW() {
		return emPW;
	}

	public void setEmPW(EntityManager emPW) {
		this.emPW = emPW;
	}

	public EntityManagerFactory getFactory() {
		return factory;
	}

	public void setFactory(EntityManagerFactory factory) {
		this.factory = factory;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Statement getStm() {
		return stm;
	}

	public void setStm(Statement stm) {
		this.stm = stm;
	}

}
