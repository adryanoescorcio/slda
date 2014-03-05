package Teste.TesteIsolados;

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
import PrimaryKey.AlunoPK;
import PrimaryKey.CaixaPK;

public class TesteAppArquivo {

	private static final int INTERVALO = 999999999;
	EntityManager em;
	private JPAUtil conexaoBD;
	private Random rand;
	
	private ArquivoDAO dao;
	private AlunoDAO alunoDAO;
	private CaixaDAO caixaDAO;
	private AlunoPK pkAlu;
	private CaixaPK pkCai;
	
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
		
		pkCai = new CaixaPK();
		pkCai.setCodigo("118609431");
		Caixa caixa = caixaDAO.buscar(pkCai);
		
		pkAlu = new AlunoPK();
		pkAlu.setCodigo("20120124588");
		Aluno aluno = alunoDAO.buscar(pkAlu); 
		Arquivo arquivo = new Arquivo();
		arquivo.setCodigo(aluno, caixa);
		arquivo.setCodDossie(numAleatorio());
		em.persist(arquivo); 
		em.getTransaction().commit();
	}
		
	@Test
	public void inserirAtualizarDocumento() {
		
		pkCai = new CaixaPK();
		pkCai.setCodigo(numAleatorio());
		// Setando os valores
		Caixa caixa = caixaDAO.buscar(pkCai);
		pkAlu = new AlunoPK();
		pkAlu.setCodigo("310951701");
		Aluno aluno = alunoDAO.buscar(pkAlu);
		Arquivo arquivo = new Arquivo();
		arquivo.setCodigo(aluno, caixa);
		arquivo.setCodDossie(numAleatorio());
		arquivo.setDatadeEntradaArquivo("21/08/2012");
		
		System.out.println("\n####### Iniciando Teste 1 #######");
		System.out.println("\n+++ Primeiro Teste - Inserir - Mude o Codigo do Aluno");
		
		
		// inserindo aluno
		boolean retorno = dao.save(arquivo);
		
		System.out.println("\n+++ Segundo Teste - Atualizar");
		pkCai = new CaixaPK();
		pkCai.setCodigo("781373626");
		Caixa caixa2 = caixaDAO.buscar(pkCai);
		Arquivo arquivo2 = new Arquivo();
		pkAlu = new AlunoPK();
		pkAlu.setCodigo("827768098");
		Aluno aluno2 = alunoDAO.buscar(pkAlu);
		arquivo2.setCodigo(aluno2, caixa2);
		
		dao.save(arquivo2);
		
		
		// verificando o retorno
		if(retorno)
			System.out.println("\n****** Teste 1 - 100% OK ******");
	}
	
	@Test
	public void removerAluno(){
		
		// instanciando aluno
		Arquivo arq = new Arquivo();
		pkAlu = new AlunoPK();
		pkAlu.setCodigo("207030540");
		
		pkCai = new CaixaPK();
		pkCai.setCodigo("207030540");
		arq.setCodigo(alunoDAO.buscar(pkAlu), caixaDAO.buscar(pkCai));
		arq.setCodDossie(numAleatorio());
		System.out.println("\n#### Iniciando Teste 2 ####");
		
		// aluno é inserido, verifica se o aluno existe e não esta repetido
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
