package Teste.TesteIsolados;

import java.util.Random;

import javax.persistence.EntityManager;

import org.junit.Test;

import DAO.AtaDAO;
import DAO.JPAUtil;
import Model.Ata;
import PrimaryKey.AtaPK;

public class TesteAppAta {

	private static final int INTERVALO = 999999999;
	private JPAUtil conexaoBD;
	private Random rand;
	private AtaDAO dao;

	public TesteAppAta() {
		this.conexaoBD = new JPAUtil();
		dao = new AtaDAO(conexaoBD);
	}

//    @Test
	public void conexao() {
		EntityManager em = dao.getEm();
		System.out.println(em.isOpen()); 
	}
	
	@Test
	public void inserirAtualizarAta() {
	
		// instanciando caixa
		Ata ata = new Ata();
		
		// Setando os valores
		ata.setCodigo("Matutino","202","2012");
		ata.setModalidadeAta("Normal");
		ata.setEnsinoAta("Medio");
		
		System.out.println("\n####### Iniciando Teste 1 #######");
		System.out.println("\n+++ Primeiro Teste - Inserir");
				
		// inserindo caixa
		boolean retorno = dao.save(ata);
				
		// verificando o retorno
		if(retorno)
			System.out.println("\n****** Teste 1 - 100% OK ******");
	}
	
	@Test
	public void removerAta(){
		
		Ata ata = new Ata();
		// instanciando caixa
		AtaPK atapk = new AtaPK();
		atapk.setCodigo("406", "Vespertino", "2013");
		ata.setCodigo("Matutino","202","2012");
		ata.setModalidadeAta("Normal");
		ata.setEnsinoAta("Superior");
		
		System.out.println("\n#### Iniciando Teste 2 ####");
		// caixa é inserida
		dao.save(ata);
		
		// remover aluno
		boolean retorno = dao.remover(ata);
		
		if(retorno)
			System.out.println("****** OK Teste 2. ******");
	}
	
//	@Test
	public void consultarAta(){
		System.out.println("\n#### Iniciando Teste 3 ####");
		
		// Codigo: 20120124500
//		Ata ata = dao.buscar("402 - 2014 - Vespertino");
		
		try{
//			System.out.println(ata.toString());
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
	
	public String getCodigoDaAta(AtaPK atapk){
		return atapk.getTurmaAta() + " - " + atapk.getAnoAta() + " - " + atapk.getTurnoAta();
	}

}
