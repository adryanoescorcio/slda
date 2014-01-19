/**
 * 
 */
package Teste;

import javax.persistence.EntityManager;

import org.junit.Test;

import DAO.JPAUtil;
import Model.Aluno;

/**
 * Classe de Teste da aplicação
 * 
 * @author Adryano Escorcio
 * @version 1.0
 **/
public class TesteApp {

	EntityManager em;
	private JPAUtil conexaoBD;
	private Aluno alunoGenerico;
	
	/**
	 * Construtor que inicializa a conexao teste
	 **/
	public TesteApp() {
		this.conexaoBD = new JPAUtil();
		
		// criando um objeto aluno generico para utilizar a conexao
		alunoGenerico = new Aluno();
		alunoGenerico.setConexaoBD(conexaoBD);
	}
		
	/**
	 * Testar ser o objeto Aluno está sendo persistido com sucesso
	 * TESTE 1
	 **/
	@Test
	public void inserirAtualizarAluno() {
		
		// instanciando aluno
		Aluno alunoTeste = new Aluno();

		// Setando os valores
		alunoTeste.setCodigo("301203254326758");
		alunoTeste.setCPF_Aluno("3242523222");
		alunoTeste.setNomeAluno("Daniel Souza");
		alunoTeste.setINEP("238923939");
		alunoTeste.setRG_Aluno("2389285435343");
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
		alunoTeste.setTelefoneAluno("32471232");
		
		// Necessario setar o EM para conectar no BD
		alunoTeste.setConexaoBD(conexaoBD);
		
		System.out.println("\n#### Iniciando Teste 1 ####");
		
		// inserindo aluno
		boolean retorno = alunoTeste.inserirAtualizarAlunoBD(alunoTeste);
		
		// verificando o retorno
		if(retorno)
			System.out.println("****** OK Teste 1. ******");
	}
	
	/**
	 * Testar se o objeto Aluno esta sendo removido.
	 * <br>Testar a utilização acumulativa da conexao inserir->(consultar)remover.
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
		
		// Necessario setar o EM para conectar no BD
		alunoTesteRemover.setConexaoBD(conexaoBD);
		
		System.out.println("\n#### Iniciando Teste 2 ####");
		// aluno é inserido
		alunoTesteRemover.inserirAtualizarAlunoBD(alunoTesteRemover);
		
		// remover aluno
		boolean retorno = alunoTesteRemover.removerAlunoBD("000000020000002000000002000002");
		
		if(retorno)
			System.out.println("****** OK Teste 2. ******");
	}
	/***
	@Test
	public void consultarAluno(){
		Aluno alunoBuscar= alunoGenerico.buscarAlunoBD("34234234");
		System.out.println("\n#### Iniciando Teste 2 ####");
	}
	
}
