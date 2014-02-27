package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe que realiza a conexao com o Banco de 
 * Dados SQLite<br> embarcado na App e faz a 
 * conexao com o arquivo persistence.xml.
 * <br>Abrindo vários tipos de manipulação de Dados.
 * 
 *@param EntityManagerFactory factory<br>
	<b>EntityManager</b> em <br>
	<b>Connection</b> conn <br>
	<b>Statement</b> stm <br>
 * @author Adryano Escorcio
 * @version 1.5
 **/
public class JPAUtil {
	
	//Direciona o arquivo XML para conectar o BD
	private EntityManagerFactory factory;
	protected EntityManager em;
	private Connection conn;
	private Statement stm;
	
	/**
	 * Classe responsavel pela conexão com o BD. Abrindo vários<br>
	 * tipos de manipulação de Dados
	 **/
	public JPAUtil() {
		
		// Conexao com JPA
		try{
			this.factory = Persistence.createEntityManagerFactory("manager");
			this.em = factory.createEntityManager();
		} catch(Exception e) {
			System.out.println("Erro: conexao JPA" +e.getMessage());
		}
		
		// Conexao com JDBC
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:sldav1.db");
			setStm(conn.createStatement());
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Erro: conexao JDBC");
		}
	}
	
	/**
	 * Fecha todas as conexao instanciadas pelo Objeto.
	 **/
	public void closeAllConexao() {
		factory.close();
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
