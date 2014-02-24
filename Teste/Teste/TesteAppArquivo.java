package Teste;

import java.util.Random;

import javax.persistence.EntityManager;

import org.junit.Test;

import DAO.AlunoDAO;
import DAO.ArquivoDAO;
import DAO.CaixaDAO;
import DAO.JPAUtil;
import Model.Aluno;
import Model.Arquivo;
import Model.Caixa;

public class TesteAppArquivo {

	private static final int INTERVALO = 999999999;
	EntityManager em;
	private JPAUtil conexaoBD;
	
	private Random rand;
	private ArquivoDAO dao;
	private AlunoDAO alunoDAO;
	private CaixaDAO caixaDAO;
	
	/**
	 * Construtor que inicializa a conexao teste
	 **/
	
	public TesteAppArquivo() {
		this.conexaoBD = new JPAUtil();
		this.dao = new ArquivoDAO(conexaoBD);
		this.alunoDAO = new AlunoDAO(conexaoBD);
		this.caixaDAO = new CaixaDAO(conexaoBD);
		
	}
	
//	@Test
	public void conexao() {
		EntityManager em = dao.getEm();
		System.out.println(em.isOpen()); 
		em.getTransaction().begin();
		Caixa caixa = caixaDAO.buscar("118609431");
		Aluno aluno = alunoDAO.buscar("20120124588"); 
		Arquivo arquivo = new Arquivo();
		arquivo.setAluno(aluno);
		arquivo.setCaixa(caixa);
		arquivo.setCodDossie(numAleatorio());
		em.persist(arquivo); 
		em.getTransaction().commit();
	}
		
	@Test
	public void inserirAtualizarDocumento() {
		
		// Setando os valores
		Caixa caixa = caixaDAO.buscar("941066905");
		Aluno aluno = alunoDAO.buscar("310951701");
		Arquivo arquivo = new Arquivo();
		arquivo.setAluno(aluno);
		arquivo.setCaixa(caixa);
		arquivo.setCodDossie(numAleatorio());
		arquivo.setDatadeEntradaArquivo("21/08/2012");
		
		System.out.println("\n####### Iniciando Teste 1 #######");
		System.out.println("\n+++ Primeiro Teste - Inserir - Mude o Codigo do Aluno");
		
		
		// inserindo aluno
		boolean retorno = dao.save(arquivo);
		
		System.out.println("\n+++ Segundo Teste - Atualizar");
		Caixa caixa2 = caixaDAO.buscar("781373626");
		Arquivo arquivo2 = new Arquivo();
		Aluno aluno2 = alunoDAO.buscar("827768098");
		arquivo2.setCaixa(caixa2);
		arquivo2.setAluno(aluno2);
		
		dao.save(arquivo2);
		
		
		// verificando o retorno
		if(retorno)
			System.out.println("\n****** Teste 1 - 100% OK ******");
	}
	
//	@Test
	public void removerAluno(){
		
		// instanciando aluno
		Arquivo arq = new Arquivo();
		arq.setAluno(alunoDAO.buscar("777291288"));
		arq.setCaixa(caixaDAO.buscar("781373626"));
		arq.setCodDossie(numAleatorio());
		System.out.println("\n#### Iniciando Teste 2 ####");
		// aluno � inserido
		dao.save(arq);
		
		// remover aluno
		boolean retorno = dao.remover(arq);
		
		if(retorno)
			System.out.println("****** OK Teste 2. ******");
	}

//	@Test
	public void testarBuscaAlterar() {
		System.out.println("\n#### Iniciando Teste 3 ####");
		
		//buscando a partir do codAluno
//		Arquivo arq = dao.buscar("201203245133");
		
//		System.out.println(arq.toString());
		System.out.println("****** OK Teste 3. ******");
	}
	
	public String numAleatorio(){
		rand = new Random();
		String numAle = String.valueOf(rand.nextInt(INTERVALO));
		return numAle;
	}

}
