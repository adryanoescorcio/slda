package Teste;  

import java.util.Random;

import javax.persistence.EntityManager;

import org.junit.Test;

import DAO.CaixaDAO;
import DAO.JPAUtil;
import Model.Caixa;

/**
 * Classe de Teste da aplicação
 * 
 * @author Adryano Escorcio
 * @version 1.0
 **/

public class TesteAppCaixa {

	private static final int INTERVALO = 999999999;
	EntityManager em;
	private JPAUtil conexaoBD;
	private Random rand;
	private CaixaDAO dao;
	
	/**
	 * Construtor que inicializa a conexao teste
	 **/
	public TesteAppCaixa() {
		this.conexaoBD = new JPAUtil();
		this.dao = new CaixaDAO(conexaoBD);
	}
	
	@Test
	public void conexao() {
		EntityManager em = dao.getEm();
		System.out.println(em.isOpen()); 
		em.getTransaction().begin();
		Caixa caixa = new Caixa();
		caixa.setCodigo("123");
		caixa.setStatus("Cheio");
		caixa.setTurno("Noturno");
		em.persist(caixa); 
		em.getTransaction().commit();
	}
		
	@Test
	public void inserirAtualizarCaixa() {
	
		
		// instanciando caixa
		Caixa caixa = new Caixa();
		
		// Setando os valores
		//caixa.setCodigo(numAleatorio());
		caixa.setCodigo("20120124500");

		caixa.setStatus("Aguardando...");
		caixa.setTurno("Matutino");
		
		System.out.println("\n####### Iniciando Teste 1 #######");
		System.out.println("\n+++ Primeiro Teste - Inserir");
		
		//CaixaDAO caixadao = new CaixaDAO(conexaoBD);
		
		// inserindo caixa
		boolean retorno = dao.save(caixa);
				
		// verificando o retorno
		if(retorno)
			System.out.println("\n****** Teste 1 - 100% OK ******");
	}
	
	public void consultarAluno(){
		System.out.println("\n#### Iniciando Teste 3 ####");
		
		// Codigo: 20120124500
		Caixa caixabd = dao.buscar("20120124500");
		
		try{
			System.out.println(caixabd.toString());
		} catch (NullPointerException e) {
			System.out.println("Atencao: Não existe nenhum aluno com o codigo digitado");
		}
		
		System.out.println("****** OK Teste 3. ******");
	}
	
	public String numAleatorio(){
		rand = new Random();
		String numAle = String.valueOf(rand.nextInt(INTERVALO));
		return numAle;
	}

}
