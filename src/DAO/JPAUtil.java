package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe que realiza a conexao com o Banco de Dados SQLite embarcado na App
 * e faz a conexao com o arquivo persistence.xml.
 * 
 * @author Adryano Escorcio
 * @version 1.0
 **/
public class JPAUtil {
	
	//Direciona o arquivo XML para conectar o BD
	private EntityManagerFactory factory;
	protected EntityManager em;
	private Connection conn;

	private Statement stm;
	
	public JPAUtil() {
		try{
			this.factory = Persistence.createEntityManagerFactory("manager");
			this.setEm(factory.createEntityManager());
		} catch(Exception e) {
			System.out.println("Erro: conexao JPA");
		}
		
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:sldav1.db");
			setStm(conn.createStatement());
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Erro: conexao JDBC");
		}
	}
		
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
