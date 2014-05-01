package Teste;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import junit.framework.TestSuite;

import org.junit.Test;

import DAO.AlunoDAO;
import DAO.ArquivoDAO;
import DAO.AtaDAO;
import DAO.AtaResultadoDAO;
import DAO.CaixaDAO;
import DAO.DocumentoDAO;
import DAO.JPAUtil;
import Model.Aluno;
import Model.Arquivo;
import Model.Ata;
import Model.AtaResultado;
import Model.Caixa;
import Model.Documento;
import PrimaryKey.AlunoPK;
import PrimaryKey.ArquivoPK;
import PrimaryKey.AtaPK;
import PrimaryKey.AtaResultadoPK;
import PrimaryKey.CaixaPK;
import PrimaryKey.DocumentoPK;

/**
 * Classe de Teste da aplicação Principal
 * 
 * @author Adryano Escorcio
 * @version 3.0
 **/
public class MainTeste extends TestSuite {

	// Intervalo para o Random
	private static final int INTERVALO = 999999999;

	private static final String STR_EST = "\nVERIFICAR A CONEXÃO DO BD";
	private static final String STR_END = "<\\TERMINADO >\n";
	private static final String ERRO_TESTE = "Ocorreu no teste. Por favor verifique\n.";
	private static final String ALERTA = "ALERTA";

	private static final String TESTE = "-- INICIANDO TESTE CRUD COM ";
	private static final String ALUNO = "ALUNO ";
	private static final String CAIXA = "CAIXA ";
	private static final String DOCUMENTO = "DOCUMENTO ";
	private static final String ARQUIVO = "ARQUIVO ";
	private static final String ATA = "ATA ";
	private static final String RESULTADO = "RESULTADO ";

	private static final String CREATE = "**CREATE";
	private static final String READ = "**READ";
	private static final String UPDATE = "**UPDATE";
	private static final String DELETE = "**DELETE";

	private static final String ID_ALUNO_SEARCH_PADRAO = "912675214"; // Sempre existira no BD
	private static final String ID_CAIXA_SEARCH_PADRAO = "123456789";
	private static final String ID_DOCUMENTO_SEARCH_PADRAO = "213456789";
	private static final String ID_ATA_SEARCH_TURMA = "202";
	private static final String ID_ATA_SEARCH_TURNO = "Matutino";
	private static final String ID_ATA_SEARCH_ANO = "2012";

	private static final String CHAVE_REMOVER = "000000020000002000000002000002"; // Nunca deve esta no BD

	private static final long WAIT_TIME = 500; // Tempo de espera

	// Variaveis do BD
	private EntityManager em;
	private JPAUtil conexaoBD;
	private Random rand;

	// Variaveis para ALUNO
	private AlunoDAO alunoDAO;
	private Aluno aluno1;
	private Aluno aluno2;
	private Aluno aluno3;
	private Aluno alunoNull;
	private AlunoPK alunoPK1;
	private AlunoPK aluno2PK2;
	private Aluno alunoRemover;
	
	//Variaveis para CAIXA
	private CaixaDAO caixaDao;
	private Caixa caixa1;
	private Caixa caixa2;
	private Caixa caixa3;
	private Caixa caixaNull;
	private CaixaPK caixaPK1;
	private CaixaPK caixa2PK2;
	private Caixa caixaRemover;
	
	// Variaveis para DOCUMENTO
	private DocumentoDAO documentoDAO;
	private Documento documento1;
	private Documento documento2;
	private Documento documento3;
	private Documento documentoNull;
	private DocumentoPK documentoPK1;
	private DocumentoPK documento2PK2;
	
	// Variaveis para Arquivo
	private ArquivoDAO arquivoDAO;
	private Arquivo arquivo1;
	private Arquivo arquivo2;
	private Arquivo arquivo3;
	private Arquivo arquivoNull;
	private ArquivoPK arquivoPK1;
	private ArquivoPK arquivo2PK2;

	// Variaveis para Ata
	private AtaDAO ataDao;
	private Ata ata1;
	private Ata ata2;
	private Ata ata3;
	private Ata ataNull;
	private AtaPK ataPK1;
	private AtaPK ata2PK2;
	
	// Variaveis AtaResultados
	private AtaResultadoDAO resultadoDAO;
	private AtaResultado resultado1;
	private AtaResultado resultado2;
	private AtaResultado resultado3;
	private AtaResultado resultadoNull;
	private AtaResultadoPK resultadoPK1;
	private AtaResultadoPK resultado2PK2;

	// Contrutor
	public MainTeste() {
		this.conexaoBD = new JPAUtil();
		
		inicializarVariaveisAluno();
		inicializarVariaveisCaixa();
		inicializarVariaveisDocumento();
		inicializarVariaveisArquivo();
		inicializarVariaveisAta();
		inicializarVariaveisResultado();
	}

	public void ConexaoBD() {
		// Verificar se a conexão com o BD está estabilizada.
		try {
			System.out.println(STR_EST);
			this.em = alunoDAO.getEm();
			
			if(em.isOpen())
				System.out.println(STR_END);
			Thread.sleep(WAIT_TIME);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, ERRO_TESTE + e.getMessage(), ALERTA, JOptionPane.WARNING_MESSAGE);
		}
	}
	@Test(timeout=10000)
	public void TesteAluno() {
		try {
			System.out.println(TESTE+ALUNO);
			System.out.println(CREATE);
			
			// Salvando
			alunoDAO.save(aluno1);
			Thread.sleep(WAIT_TIME); // Esperar para realizar outra operação

			// Buscar
			System.out.println(READ);
			alunoNull = alunoDAO.buscar(alunoPK1);
			if(alunoNull != null) // Verificar se retornou algum objeto do BD
				System.out.println(alunoNull.toString());
			Thread.sleep(WAIT_TIME);

			//Atualizar
			System.out.println(UPDATE);
			alunoDAO.save(aluno3); // Vai ocorrer Atualização
			alunoDAO.save(aluno3); // NAO Vai ocorrer Atualização
			Thread.sleep(WAIT_TIME);

			// Deletar
			System.out.println(DELETE);
			alunoDAO.save(aluno2); // Inserindo Aluno
			alunoDAO.remover(aluno2); // Removendo por Entidade
			Thread.sleep(WAIT_TIME);

			alunoDAO.save(aluno2); // Inserindo Aluno
			alunoDAO.remover(aluno2PK2); // Removendo por Codigo
			
			System.out.println(STR_END);
			Thread.sleep(WAIT_TIME);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, ERRO_TESTE+ALUNO, ALERTA, JOptionPane.WARNING_MESSAGE);
		}
	}
	@Test(timeout=10000)
	public void TesteCaixa() {
		try {
			System.out.println(TESTE+CAIXA);
			System.out.println(CREATE);
			
			// Salvando
			caixaDao.save(caixa1);
			Thread.sleep(WAIT_TIME);

			// Buscar
			System.out.println(READ);
			caixaNull = caixaDao.buscar(caixaPK1);
			if(caixaNull != null)
				System.out.println(caixaNull.toString());

			//Atualizar
			System.out.println(UPDATE);
			caixaDao.save(caixa3); // Vai ocorrer Atualização
			caixaDao.save(caixa3); // NAO Vai ocorrer Atualização
			Thread.sleep(WAIT_TIME);

			// Deletar
			System.out.println(DELETE);
			caixaDao.save(caixa2); // Inserindo Aluno
			caixaDao.remover(caixa2); // Removendo por Entidade
			Thread.sleep(WAIT_TIME);

			caixaDao.save(caixa2); // Inserindo Aluno
			caixaDao.remover(caixa2PK2); // Removendo por Codigo
			
			System.out.println(STR_END);
			Thread.sleep(WAIT_TIME);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, ERRO_TESTE+CAIXA, ALERTA, JOptionPane.WARNING_MESSAGE);
		}
	}
	@Test(timeout=10000)
	public void TesteDocumento() {
		try {
			System.out.println(TESTE+DOCUMENTO);
			System.out.println(CREATE);
			
			// Salvando
			documentoDAO.save(documento1);
			Thread.sleep(WAIT_TIME);

			// Buscar
			System.out.println(READ);
			documentoNull = documentoDAO.buscar(documentoPK1);
			if(documentoNull != null)
				System.out.println(documentoNull.toString());
			Thread.sleep(WAIT_TIME);

			//Atualizar
			System.out.println(UPDATE);
			documentoDAO.save(documento3); // Vai ocorrer Atualização
			documentoDAO.save(documento3); // NAO Vai ocorrer Atualização
			Thread.sleep(WAIT_TIME);

			// Deletar
			System.out.println(DELETE);
			documentoDAO.save(documento2); // Inserindo Aluno
			documentoDAO.remover(documento2); // Removendo por Entidade
			Thread.sleep(WAIT_TIME);
			documentoDAO.save(documento2); // Inserindo Aluno
			documentoDAO.remover(documento2PK2); // Removendo por Codigo
			
			System.out.println(STR_END);
			Thread.sleep(WAIT_TIME);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, ERRO_TESTE+DOCUMENTO, ALERTA, JOptionPane.WARNING_MESSAGE);
		}
	}
	
	@Test(timeout=10000)
	public void TesteArquivo() {
		try {
			System.out.println(TESTE+ARQUIVO);
			System.out.println(CREATE);
			
			// Salvando
			arquivoDAO.save(arquivo1);
			
			Thread.sleep(WAIT_TIME);
			// Buscar
			System.out.println(READ);
			arquivoNull = arquivoDAO.buscar(arquivoPK1);
			if(arquivoNull != null)
				System.out.println(arquivoNull.toString());
			
			Thread.sleep(WAIT_TIME);
			//Atualizar
			System.out.println(UPDATE);
			arquivoDAO.save(arquivo3); // Vai ocorrer Atualização
			arquivoDAO.save(arquivo3); // NAO Vai ocorrer Atualização
			
			Thread.sleep(WAIT_TIME);
			// Deletar
			System.out.println(DELETE);
			arquivoDAO.save(arquivo2); // Inserindo Aluno
			arquivoDAO.remover(arquivo2); // Removendo por Entidade
			Thread.sleep(WAIT_TIME);
			arquivoDAO.save(arquivo2); // Inserindo Aluno
			arquivoDAO.remover(arquivo2PK2); // Removendo por Codigo
			
			System.out.println(STR_END);
			Thread.sleep(WAIT_TIME);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, ERRO_TESTE+ARQUIVO, ALERTA, JOptionPane.WARNING_MESSAGE);
		}
	}
	
	@Test(timeout=10000)
	public void TesteAta() {
		try {
			System.out.println(TESTE+ATA);
			System.out.println(CREATE);
			
			// Salvando
			ataDao.save(ata1);
			
			Thread.sleep(WAIT_TIME);
			// Buscar
			System.out.println(READ);
			ataNull = ataDao.buscar(ataPK1);
			if(ataNull != null)
				System.out.println(ataNull.toString());
			
			Thread.sleep(WAIT_TIME);
			//Atualizar
			System.out.println(UPDATE);
			ataDao.save(ata3); // Vai ocorrer Atualização
			ataDao.save(ata3); // NAO Vai ocorrer Atualização
			
			Thread.sleep(WAIT_TIME);
			// Deletar
			System.out.println(DELETE);
			ataDao.save(ata2); // Inserindo Aluno
			ataDao.remover(ata2); // Removendo por Entidade
			Thread.sleep(WAIT_TIME);
			ataDao.save(ata2); // Inserindo Aluno
			ataDao.remover(ata2PK2); // Removendo por Codigo
			
			System.out.println(STR_END);
			Thread.sleep(WAIT_TIME);

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, ERRO_TESTE+ATA, ALERTA, JOptionPane.WARNING_MESSAGE);
		}
	}
	
	@Test(timeout=10000)
	public void TesteResultado() {
		try {
			System.out.println(TESTE+RESULTADO);
			System.out.println(CREATE);
			
			// Salvando
			resultadoDAO.save(resultado1);
			
			Thread.sleep(WAIT_TIME);
			// Buscar
			System.out.println(READ);
			resultadoNull = resultadoDAO.buscar(resultadoPK1);
			if(resultadoNull != null)
				System.out.println(resultadoNull.toString());
			
			Thread.sleep(WAIT_TIME);
			//Atualizar
			System.out.println(UPDATE);
			resultadoDAO.save(resultado3); // Vai ocorrer Atualização
			resultadoDAO.save(resultado3); // NAO Vai ocorrer Atualização
			
			Thread.sleep(WAIT_TIME);
			// Deletar
			System.out.println(DELETE);
			resultadoDAO.save(resultado2); // Inserindo Aluno
			resultadoDAO.remover(resultado2); // Removendo por Entidade
			Thread.sleep(WAIT_TIME);
			resultadoDAO.save(resultado2); // Inserindo Aluno
			resultadoDAO.remover(resultado2PK2); // Removendo por Codigo
			
			System.out.println(STR_END);
			Thread.sleep(WAIT_TIME);

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, ERRO_TESTE+RESULTADO, ALERTA, JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public String numAleatorio() {
		rand = new Random();
		return String.valueOf(rand.nextInt(INTERVALO));
	}
	
	// Instanciando todos as variaveis de Aluno
	private void inicializarVariaveisAluno() {
		this.alunoDAO = new AlunoDAO(conexaoBD); // Setando DAO
		this.aluno1 = new Aluno();
		this.aluno2 = new Aluno();
		this.aluno3 = new Aluno();
		this.alunoPK1 = new AlunoPK();
		this.aluno2PK2 = new AlunoPK();
		this.alunoRemover = new Aluno();
		
		alunoRemover.setCodigo(CHAVE_REMOVER);
		
		aluno1.setCodigo(numAleatorio());
		aluno2.setCodigo(CHAVE_REMOVER);
		aluno3.setCodigo(ID_ALUNO_SEARCH_PADRAO);
		
		aluno2PK2.setCodigo(CHAVE_REMOVER);
		alunoPK1.setCodigo(ID_ALUNO_SEARCH_PADRAO);

		aluno1.setCPF_Aluno(numAleatorio());
		aluno1.setNomeAluno("Alan Kardec Souza");
//		aluno1.setINEP(numAleatorio());
//		aluno1.setRG_Aluno(numAleatorio());
		aluno1.setSexoAluno("Masculino");
		aluno1.setCorAluno("Branca");
		aluno1.setDataNascimento("07/02/1994");
		aluno1.setCidadeNascAluno("Paratins");
		aluno1.setEstadoNascAluno("Mato Grosso");
//		aluno1.setNomePai("Leal");
//		aluno1.setCidadePaiNasc("Itapirapoca");
//		aluno1.setEstadoPaiNasc("São Paulo");
		aluno1.setNomeMae("Jessica");
//		aluno1.setCidadeMaeNasc("Sao José dos Patos");
//		aluno1.setEstadoMaeNasc("Rio Branco");
		aluno1.setEnderecoAluno("Rua 25 Quadra 24");
		aluno1.setTelefoneAluno(numAleatorio());
		
		aluno3.setCPF_Aluno(numAleatorio());
		aluno3.setNomeAluno("Pedro Kardec Laden");
//		aluno3.setINEP(numAleatorio());
//		aluno3.setRG_Aluno(numAleatorio());
		aluno3.setSexoAluno("Masculino");
		aluno3.setCorAluno("Indio");
		aluno3.setDataNascimento("11/02/1982");
		aluno3.setCidadeNascAluno("Nova Iorque");
		aluno3.setEstadoNascAluno("India");
//		aluno3.setNomePai("Bon Jovi");
//		aluno3.setCidadePaiNasc("São Luís");
//		aluno3.setEstadoPaiNasc("Acre");
		aluno3.setNomeMae("Ruby");
//		aluno3.setCidadeMaeNasc("Codó");
//		aluno3.setEstadoMaeNasc("Rondonia");
		aluno3.setEnderecoAluno("Rua da Estrela");
		aluno3.setTelefoneAluno(numAleatorio());
	}
	
	// Instanciando todos as variaveis de Caixa
	private void inicializarVariaveisCaixa() {
		this.caixaDao = new CaixaDAO(conexaoBD);
		this.caixa1 = new Caixa();
		this.caixa2 = new Caixa();
		this.caixa3 = new Caixa();
		this.caixaPK1 = new CaixaPK();
		this.caixa2PK2 = new CaixaPK();
		this.caixaRemover = new Caixa();
		caixaRemover.setCodigo(CHAVE_REMOVER);
		
		caixa1.setCodigo(numAleatorio());
		caixa2.setCodigo(CHAVE_REMOVER);
		caixa3.setCodigo(ID_CAIXA_SEARCH_PADRAO);
		
		caixaPK1.setCodigo(ID_CAIXA_SEARCH_PADRAO);
		caixa2PK2.setCodigo(CHAVE_REMOVER);
		
		caixa1.setStatus("Desativado");
		caixa1.setTurno("Vespertino");
		
		caixa3.setTurno(numAleatorio());
		caixa3.setStatus("Ativo");
	}
	
	// Instanciando todos as variaveis de Documento
	private void inicializarVariaveisDocumento() {
		documentoDAO = new DocumentoDAO(conexaoBD);
		documento1 = new Documento();
		documento2 = new Documento();
		documento3 = new Documento();
		documentoPK1 = new DocumentoPK();
		documento2PK2 = new DocumentoPK();
		
		documentoPK1.setCodigo(ID_DOCUMENTO_SEARCH_PADRAO);
		documento2PK2.setCodigo(CHAVE_REMOVER);
		
		documento1.setCodigo(numAleatorio());
		documento1.setAluno(aluno3);
		documento2.setCodigo(CHAVE_REMOVER);
		documento2.setAluno(aluno3);
		documento3.setCodigo(ID_DOCUMENTO_SEARCH_PADRAO);
		documento3.setAluno(aluno3);
		
		documento3.setDataEntrega("32/03/1922");
		documento3.setDataPedido("08/02/9211");
		documento3.setNomeDocumento(numAleatorio());
		documento3.setStatus("Pendente");
		
		documento1.setDataEntrega("12/02/1994");
		documento1.setDataPedido("20/04/1982");
		documento1.setDescricao("Declaração");
		documento1.setNomeDocumento("Desclaração de Regularidade");
		documento1.setStatus("Entregue");
	}

	private void inicializarVariaveisArquivo() {
		this.arquivoDAO = new ArquivoDAO(conexaoBD);
		this.arquivo1 = new Arquivo();
		this.arquivo2 = new Arquivo();
		this.arquivo3 = new Arquivo();
		this.arquivoPK1 = new ArquivoPK();
		this.arquivo2PK2 = new ArquivoPK();
		
		arquivoPK1.setCodigoAluno(ID_ALUNO_SEARCH_PADRAO);
		arquivo2PK2.setCodigoAluno(CHAVE_REMOVER);
		
		arquivo1.setCodigo(aluno1, caixa1);
		arquivo1.setCodDossie(numAleatorio());
		arquivo1.setDatadeEntradaArquivo("22/02/1990");

		arquivo2.setCodigo(alunoRemover, caixaRemover);
		
		arquivo3.setCodigo(aluno3, caixa3);
		arquivo3.setCodDossie(numAleatorio());
		arquivo3.setDatadeEntradaArquivo("00/00/0000");
	}
	
	private void inicializarVariaveisAta() {
		this.ataDao = new AtaDAO(conexaoBD);
		this.ata1 = new Ata();
		this.ata2 = new Ata();
		this.ata3 = new Ata();
		this.ataPK1 = new AtaPK();
		this.ata2PK2 = new AtaPK();
		
		ataPK1.setCodigo(ID_ATA_SEARCH_TURMA, ID_ATA_SEARCH_TURNO, ID_ATA_SEARCH_ANO);
		ata2PK2.setCodigo(CHAVE_REMOVER, CHAVE_REMOVER, CHAVE_REMOVER);
		
		ata1.setCodigo(numAleatorio(), numAleatorio(), "2014");
		ata2.setCodigo(CHAVE_REMOVER, CHAVE_REMOVER, CHAVE_REMOVER);
		ata3.setCodigo(ID_ATA_SEARCH_TURMA, ID_ATA_SEARCH_TURNO, ID_ATA_SEARCH_ANO);
		
		ata1.setEnsinoAta("Publico");
		ata1.setModalidadeAta("EJA");
		
		ata3.setEnsinoAta("Regular");
		ata3.setModalidadeAta(numAleatorio());
	}
	
	private void inicializarVariaveisResultado() {
		this.resultadoDAO = new AtaResultadoDAO(conexaoBD);
		this.resultado1 = new AtaResultado();
		this.resultado2 = new AtaResultado();
		this.resultado3 = new AtaResultado();
		this.resultadoPK1 = new AtaResultadoPK();
		this.resultado2PK2 = new AtaResultadoPK();
		
		this.resultadoPK1.setCodigo(ID_ALUNO_SEARCH_PADRAO, 
				ID_ATA_SEARCH_TURMA, ID_ATA_SEARCH_TURNO, ID_ATA_SEARCH_ANO);
		
		this.resultado2PK2.setCodigo(CHAVE_REMOVER, 
				CHAVE_REMOVER, CHAVE_REMOVER, CHAVE_REMOVER);
		
		resultado1.setCodigo(aluno3.getCodigo(), 
				ata1.getTurmaAta(), ata1.getTurnoAta(), ata1.getAnoAta());
		resultado2.setCodigo(CHAVE_REMOVER, 
				CHAVE_REMOVER, CHAVE_REMOVER, CHAVE_REMOVER);
		resultado3.setCodigo(ID_ALUNO_SEARCH_PADRAO, 
				ID_ATA_SEARCH_TURMA, ID_ATA_SEARCH_TURNO, ID_ATA_SEARCH_ANO);
		
	}
}
