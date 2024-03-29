/**
 * 
 */
package Teste.TesteIsolados;

import java.util.Random;

import javax.persistence.EntityManager;

import org.junit.Test;

import DAO.AlunoDAO;
import DAO.JPAUtil;
import Model.Aluno;
import PrimaryKey.AlunoPK;

/**
 * Classe de Teste da aplica��o
 * 
 * @author Adryano Escorcio
 * @version 1.0
 **/
public class TesteAppAluno {

	private static final int INTERVALO = 999999999;
	private JPAUtil conexaoBD;
	
	private Random rand;
	private AlunoDAO dao;
	private AlunoPK pk;
	
	/**
	 * Construtor que inicializa a conexao teste
	 **/
	public TesteAppAluno() {
		this.conexaoBD = new JPAUtil();
		this.dao = new AlunoDAO(conexaoBD);
	}
	
	/**
	 * Testar se a Conexao est� funcionando e persistindo
	 **/
	@Test
	public void conexao() {
	  EntityManager em = dao.getEm();
      System.out.println(em.isOpen()); 
      em.getTransaction().begin();
      Aluno aluno = new Aluno();
      aluno.setCodigo(numAleatorio());
      em.persist(aluno);
      em.getTransaction().commit();
	}
	
	/**
	 * Testar ser o objeto Aluno est� sendo persistido com sucesso
	 * <br> Testar a utiliza��o sequencial da conexao
	 * TESTE 1
	 **/
	@Test
	public void inserirAtualizarAluno() {
	
		// instanciando aluno
		Aluno alunoTeste = new Aluno();
		
		// Setando os valores
		alunoTeste.setCodigo(numAleatorio());

		alunoTeste.setCPF_Aluno(numAleatorio());
		alunoTeste.setNomeAluno("Alan Kardec Souza");
		alunoTeste.setSexoAluno("Masculino");
		alunoTeste.setCorAluno("Branca");
		alunoTeste.setDataNascimento("07/02/1994");
		alunoTeste.setCidadeNascAluno("Paratins");
		alunoTeste.setEstadoNascAluno("Mato Grosso");
		alunoTeste.setNomeMae("Jessica");
		alunoTeste.setEnderecoAluno("Rua 25 Quadra 24");
		alunoTeste.setTelefoneAluno(numAleatorio());
		
		System.out.println("\n#### Iniciando Teste 1 ####");
		
		// inserindo aluno
		boolean retorno = this.dao.save(alunoTeste);
		
	
		Aluno alunoTeste2 = new Aluno();

		// Setando os valores
		alunoTeste2.setCodigo(numAleatorio());
		
		alunoTeste2.setCPF_Aluno("20120124500");
		alunoTeste2.setNomeAluno("Souza");
		dao.save(alunoTeste2);
		
		// verificando o retorno
		if(retorno)
			System.out.println("****** OK Teste 1 ******");
	}
	
	/**
	 * Testar se o objeto Aluno esta sendo removido.
	 * <br>Testar a utiliza��o acumulativa da conexao inserir->(consultar)remover.
	 * <br> TESTE 2
	 **/
	
	@Test
	public void removerAluno(){
		
		// instanciando aluno
		Aluno alunoTesteRemover = new Aluno();
		
		alunoTesteRemover.setCodigo("00000000020000000202");
		alunoTesteRemover.setCPF_Aluno("00000000020000000202");
		alunoTesteRemover.setNomeAluno("Tron");
		
		System.out.println("\n#### Iniciando Teste 2 ####");
		// aluno � inserido
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
		pk = new AlunoPK();
		pk.setCodigo("777291288");
		Aluno alunoBuscar= dao.buscar(pk);
		
		try{
			System.out.println(alunoBuscar.toString());
		} catch (NullPointerException e) {
			System.out.println("Atencao: N�o existe nenhum aluno com o codigo digitado");
		}
		
		System.out.println("****** OK Teste 3. ******");
	}

	public String numAleatorio() {
		rand = new Random();
		return String.valueOf(rand.nextInt(INTERVALO));
	}
	
}
