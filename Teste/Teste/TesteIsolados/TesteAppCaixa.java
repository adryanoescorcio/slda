package Teste.TesteIsolados;  

import java.util.Random;

import javax.persistence.EntityManager;

import org.junit.Test;

import DAO.CaixaDAO;
import DAO.JPAUtil;
import Model.Caixa;
import PrimaryKey.CaixaPK;

/**
 * Classe de Teste da aplicação
 * 
 * @author Walysson Oliveira
 * @version 1.0
 **/

public class TesteAppCaixa {

	private static final int INTERVALO = 999999999;
	EntityManager em;
	private JPAUtil conexaoBD;
	private Random rand;
	private CaixaDAO dao;
	private CaixaPK pkCai;
	
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
		caixa.setCodigo(numAleatorio());
		caixa.setLetra("X");
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
		caixa.setCodigo(numAleatorio());
		caixa.setLetra("X");
		caixa.setStatus("Morto");
		caixa.setTurno("Matutino");
		
		System.out.println("\n####### Iniciando Teste 1 #######");
		System.out.println("\n+++ Primeiro Teste - Inserir");
				
		// inserindo caixa
		boolean retorno = dao.save(caixa);
				
		// verificando o retorno
		if(retorno)
			System.out.println("\n****** Teste 1 - 100% OK ******");
	}
	
	@Test
	public void removerAluno(){
		
		// instanciando caixa
		Caixa caixaremove = new Caixa();
		
		caixaremove.setCodigo("000000020000002000000002000002");
		caixaremove.setLetra("X");
		caixaremove.setStatus("teste");
		caixaremove.setTurno("teste");
		
		System.out.println("\n#### Iniciando Teste 2 ####");
		// caixa é inserida
		dao.save(caixaremove);
		
		// remover aluno
		boolean retorno = dao.remover(caixaremove);
		
		if(retorno)
			System.out.println("****** OK Teste 2. ******");
	}
	
	@Test
	public void consultarCaixa(){
		System.out.println("\n#### Iniciando Teste 3 ####");
		
		pkCai = new CaixaPK();
		pkCai.setCodigo("941066905");
		Caixa caixabd = dao.buscar(pkCai);
		
		try{
			System.out.println(caixabd.toString());
		} catch (NullPointerException e) {
			System.out.println("Atencao: Não existe nenhuma caixa com o codigo digitado");
		}
		
		System.out.println("****** OK Teste 3. ******");
	}
	
	public String numAleatorio(){
		rand = new Random();
		String numAle = String.valueOf(rand.nextInt(INTERVALO));
		return numAle;
	}

}
