/**
 * 
 */
package Teste;

import java.util.Random;

import javax.persistence.EntityManager;

import org.junit.Test;

import DAO.AlunoDAO;
import DAO.JPAUtil;
import Model.Aluno;
import Model.Caixa;

/**
 * Classe de Teste da aplicação
 * 
 * @author Adryano Escorcio
 * @version 1.0
 **/
public class TesteAppAluno {

	private static final int INTERVALO = 999999999;
	EntityManager em;
	private JPAUtil conexaoBD;
	
	private Random rand;
	private AlunoDAO dao;
	
	/**
	 * Construtor que inicializa a conexao teste
	 **/
	public TesteAppAluno() {
		this.conexaoBD = new JPAUtil();
		this.dao = new AlunoDAO(conexaoBD);
	}
	
	/**
	 * Testar se a Conexao está funcionando e persistindo
	 **/
	//@Test
	public void conexao() {
		EntityManager em = dao.getEm();
		System.out.println(em.isOpen()); 
		em.getTransaction().begin();
		Caixa caixa = new Caixa();
		caixa.setCodigo(numAleatorio());
		em.persist(caixa);
		em.getTransaction().commit();
	}
	
	/**
	 * Testar ser o objeto Aluno está sendo persistido com sucesso
	 * <br> Testar a utilização sequencial da conexao
	 * TESTE 1
	 **/
	@Test
	public void inserirAtualizarAluno() {
	
		// instanciando aluno
		Aluno alunoTeste = new Aluno();
		
		// Setando os valores
		alunoTeste.setCodigo(numAleatorio());

		alunoTeste.setCPF_Aluno(numAleatorio());
		alunoTeste.setNomeAluno("Daniel Souza");
		alunoTeste.setINEP(numAleatorio());
		alunoTeste.setRG_Aluno(numAleatorio());
		alunoTeste.setSexoAluno("Masculino");
		alunoTeste.setCorAluno("Branca");
		alunoTeste.setDataNascimento("07/02/1994");
		alunoTeste.setCidadeNascAluno("Paratins");
		alunoTeste.setEstadoNascAluno("Mato Grosso");
		alunoTeste.setNomePai("Leal");
		alunoTeste.setCidadePaiNasc("Itapirapoca");
		alunoTeste.setEstadoPaiNasc("São Paulo");
		alunoTeste.setNomeMae("Jessica");
		alunoTeste.setCidadeMaeNasc("Sao José dos Patos");
		alunoTeste.setEstadoMaeNasc("Rio Branco");
		alunoTeste.setEnderecoAluno("Rua 25 Quadra 24");
		alunoTeste.setTelefoneAluno(numAleatorio());
		
		System.out.println("\n#### Iniciando Teste 1 ####");
		
		// inserindo aluno
		boolean retorno = this.dao.save(alunoTeste);
		
	
		Aluno alunoTeste2 = new Aluno();

		// Setando os valores
		alunoTeste2.setCodigo("20120124588");
		
		alunoTeste2.setCPF_Aluno("20120124500");
		alunoTeste2.setNomeAluno("Souza");
		alunoTeste2.setINEP("20120124500");
		dao.save(alunoTeste2);
		
		// verificando o retorno
		if(retorno)
			System.out.println("****** OK Teste 1 ******");
	}
	
	/**
	 * Testar se o objeto Aluno esta sendo removido.
	 * <br>Testar a utilização acumulativa da conexao inserir->(consultar)remover.
	 * <br> TESTE 2
	 **/
	
	@Test
	public void removerAluno(){
		
		// instanciando aluno
		Aluno alunoTesteRemover = new Aluno();
		
		alunoTesteRemover.setCodigo("000000020000002000000002000002");
		alunoTesteRemover.setCPF_Aluno("00000000020000000202");
		alunoTesteRemover.setNomeAluno("Tron");
		alunoTesteRemover.setINEP("232232323232332");
		alunoTesteRemover.setRG_Aluno("324234234243234242432");
		
		System.out.println("\n#### Iniciando Teste 2 ####");
		// aluno é inserido
		dao.save(alunoTesteRemover);
		
		// remover aluno
		boolean retorno = dao.remover(alunoTesteRemover);
		
		if(retorno)
			System.out.println("****** OK Teste 2. ******");
	}
	
	/**
	 * Teste para busca aluno no BD
	 * TESTE 3
	 **/
	@Test
	public void consultarAluno(){
		System.out.println("\n#### Iniciando Teste 3 ####");
		
		// Codigo: 20120124500
		Aluno alunoBuscar= dao.buscar("20120124500");
		
		try{
			System.out.println(alunoBuscar.toString());
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
