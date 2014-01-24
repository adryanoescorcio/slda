package Teste;

import java.util.Random;

import javax.persistence.EntityManager;

import org.junit.Test;

import DAO.AlunoDAO;
import DAO.DocumentoDAO;
import DAO.JPAUtil;
import Model.Aluno;
import Model.Documento;

public class TesteAppDocumento {

	private static final int INTERVALO = 999999999;
	EntityManager em;
	private JPAUtil conexaoBD;
	
	private Random rand;
	private DocumentoDAO dao;
	private Aluno aluno = new Aluno();
	
	/**
	 * Construtor que inicializa a conexao teste
	 **/
	public TesteAppDocumento() {
		this.conexaoBD = new JPAUtil();
		this.dao = new DocumentoDAO(conexaoBD);
		this.aluno.setCodigo("20120124500");
	}
	
//	@Test
	public void conexao() {
		EntityManager em = dao.getEm();
		System.out.println(em.isOpen()); 
		em.getTransaction().begin();
		
		Documento doc = new Documento();
		doc.setCodigo(numAleatorio());
		Aluno aluno = new Aluno();
		aluno.setCodigo("20120124500");
		
		doc.setAluno(aluno);
		
		em.persist(doc);
		em.getTransaction().commit();
	}
		
	@Test
	public void inserirAtualizarDocumento() {
	
		// instanciando aluno
		Documento doc = new Documento();
		
		// Setando os valores
		doc.setCodigo(numAleatorio());

		doc.setAluno(aluno);
		doc.setDataEntrega("02/02/1992");
		doc.setDataPedido("83/92/3912");
		doc.setDescricao("Corrigir falha do documento");
		doc.setNomeDocumento("Historico Escolar");
		doc.setStatus("Finalizado");
		
		System.out.println("\n####### Iniciando Teste 1 #######");
		System.out.println("\n+++ Primeiro Teste - Inserir");
		
		AlunoDAO daoAluno = new AlunoDAO(conexaoBD);
		Aluno aluno2 = daoAluno.buscar("20120124500");
		
		// inserindo aluno
		boolean retorno = dao.save(doc);
		
		System.out.println("\n+++ Segundo Teste - Erro");
		Documento doc2 = new Documento();

		// Setando os valores
		doc2.setCodigo("134287583");
		dao.save(doc2);
		
		System.out.println("\n+++ Terceiro Teste - Atualizar");
		
				
		// Setando os valores
		Documento doc3 = new Documento();
		doc3.setCodigo("854336025");
		doc3.setAluno(aluno2);
		doc3.setNomeDocumento("44444444");
		
		dao.save(doc3);
				
		
		// verificando o retorno
		if(retorno)
			System.out.println("\n****** Teste 1 - 100% OK ******");
	}
	
	@Test
	public void removerAluno(){
		
		// instanciando aluno
		Documento doc = new Documento();
		
		doc.setCodigo("000000020000002000000002000002");
		doc.setAluno(aluno);
		
		System.out.println("\n#### Iniciando Teste 2 ####");
		// aluno é inserido
		dao.save(doc);
		
		// remover aluno
		boolean retorno = dao.remover(doc);
		
		if(retorno)
			System.out.println("****** OK Teste 2. ******");
	}
	
	@Test
	public void testarBuscaAlterar() {
		System.out.println("\n#### Iniciando Teste 3 ####");
		
		Documento doc = dao.buscar("854336025");
		doc.setDataEntrega("3332322");
		
		dao.getEm().clear();
		
		doc = dao.buscar("792293492");
		doc.setStatus("dsdfsdfdsfsdfsdfsdfsd");
		dao.transactionBeginAndCommit();
		System.out.println(doc.toString());
		System.out.println("****** OK Teste 3. ******");
	}
	
	public String numAleatorio(){
		rand = new Random();
		String numAle = String.valueOf(rand.nextInt(INTERVALO));
		return numAle;
	}
	
}
